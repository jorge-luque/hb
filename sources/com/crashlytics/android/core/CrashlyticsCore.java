package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.answers.AppMeasurementEventLogger;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6088g;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p202b.C6097l;
import p118io.fabric.sdk.android.p200m.p202b.C6100o;
import p118io.fabric.sdk.android.p200m.p202b.C6106r;
import p118io.fabric.sdk.android.p200m.p202b.C6107s;
import p118io.fabric.sdk.android.p200m.p204d.C6131b;
import p118io.fabric.sdk.android.p200m.p204d.C6133d;
import p118io.fabric.sdk.android.p200m.p205e.C6150q;
import p118io.fabric.sdk.android.p200m.p205e.C6155t;
import p118io.fabric.sdk.android.services.concurrency.C3572d;
import p118io.fabric.sdk.android.services.concurrency.C6174e;
import p118io.fabric.sdk.android.services.concurrency.C6178g;
import p118io.fabric.sdk.android.services.concurrency.C6184l;
import p118io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import p118io.fabric.sdk.android.services.network.C6197b;
import p118io.fabric.sdk.android.services.network.C6199c;
import p118io.fabric.sdk.android.services.network.C6200d;
import p118io.fabric.sdk.android.services.network.HttpRequest;

@C3572d({CrashlyticsNdkDataProvider.class})
public class CrashlyticsCore extends C6069h<Void> {
    static final float CLS_DEFAULT_PROCESS_DELAY = 1.0f;
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.";
    private static final String PREFERENCE_STORE_NAME = "com.crashlytics.android.core.CrashlyticsCore";
    public static final String TAG = "CrashlyticsCore";
    private final ConcurrentHashMap<String, String> attributes;
    private CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsController controller;
    private CrashlyticsFileMarker crashMarker;
    private CrashlyticsNdkDataProvider crashlyticsNdkDataProvider;
    private float delay;
    private boolean disabled;
    private C6200d httpRequestFactory;
    /* access modifiers changed from: private */
    public CrashlyticsFileMarker initializationMarker;
    private CrashlyticsListener listener;
    private final PinningInfoProvider pinningInfo;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;

    public static class Builder {
        private float delay = -1.0f;
        private boolean disabled = false;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public CrashlyticsCore build() {
            if (this.delay < 0.0f) {
                this.delay = 1.0f;
            }
            return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
        }

        public Builder delay(float f) {
            if (f <= 0.0f) {
                throw new IllegalArgumentException("delay must be greater than 0");
            } else if (this.delay <= 0.0f) {
                this.delay = f;
                return this;
            } else {
                throw new IllegalStateException("delay already set.");
            }
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        public Builder listener(CrashlyticsListener crashlyticsListener) {
            if (crashlyticsListener == null) {
                throw new IllegalArgumentException("listener must not be null.");
            } else if (this.listener == null) {
                this.listener = crashlyticsListener;
                return this;
            } else {
                throw new IllegalStateException("listener already set.");
            }
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider2) {
            if (pinningInfoProvider2 == null) {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            } else if (this.pinningInfoProvider == null) {
                this.pinningInfoProvider = pinningInfoProvider2;
                return this;
            } else {
                throw new IllegalStateException("pinningInfoProvider already set.");
            }
        }
    }

    private static final class CrashMarkerCheck implements Callable<Boolean> {
        private final CrashlyticsFileMarker crashMarker;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.crashMarker = crashlyticsFileMarker;
        }

        public Boolean call() throws Exception {
            if (!this.crashMarker.isPresent()) {
                return Boolean.FALSE;
            }
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Found previous crash marker.");
            this.crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    private static final class NoOpListener implements CrashlyticsListener {
        private NoOpListener() {
        }

        public void crashlyticsDidDetectCrashDuringPreviousExecution() {
        }
    }

    public CrashlyticsCore() {
        this(1.0f, (CrashlyticsListener) null, (PinningInfoProvider) null, false);
    }

    private void checkForPreviousCrash() {
        if (Boolean.TRUE.equals((Boolean) this.backgroundWorker.submitAndWait(new CrashMarkerCheck(this.crashMarker)))) {
            try {
                this.listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            } catch (Exception e) {
                C6059c.m19630f().mo34090b(TAG, "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    private void doLog(int i, String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
            this.controller.writeToLog(System.currentTimeMillis() - this.startTime, formatLogMessage(i, str, str2));
        }
    }

    private static boolean ensureFabricWithCalled(String str) {
        CrashlyticsCore instance = getInstance();
        if (instance != null && instance.controller != null) {
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        }
        C6072k f = C6059c.m19630f();
        f.mo34090b(TAG, "Crashlytics must be initialized by calling Fabric.with(Context) " + str, (Throwable) null);
        return false;
    }

    private void finishInitSynchronously() {
        C22961 r0 = new C6178g<Void>() {
            public C6174e getPriority() {
                return C6174e.IMMEDIATE;
            }

            public Void call() throws Exception {
                return CrashlyticsCore.this.doInBackground();
            }
        };
        for (C6184l addDependency : getDependencies()) {
            r0.addDependency(addDependency);
        }
        Future submit = getFabric().mo34102b().submit(r0);
        C6059c.m19630f().mo34093d(TAG, "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C6059c.m19630f().mo34090b(TAG, "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            C6059c.m19630f().mo34090b(TAG, "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            C6059c.m19630f().mo34090b(TAG, "Crashlytics timed out during initialization.", e3);
        }
    }

    private static String formatLogMessage(int i, String str, String str2) {
        return C6090i.m19722a(i) + "/" + str + " " + str2;
    }

    public static CrashlyticsCore getInstance() {
        return (CrashlyticsCore) C6059c.m19621a(CrashlyticsCore.class);
    }

    static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            C6059c.m19630f().mo34093d(TAG, "Configured not to require a build ID.");
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        } else if (!C6090i.m19743b(str)) {
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        } else {
            Log.e(TAG, ".");
            Log.e(TAG, ".     |  | ");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".   \\ |  | /");
            Log.e(TAG, ".    \\    /");
            Log.e(TAG, ".     \\  /");
            Log.e(TAG, ".      \\/");
            Log.e(TAG, ".");
            Log.e(TAG, MISSING_BUILD_ID_MSG);
            Log.e(TAG, ".");
            Log.e(TAG, ".      /\\");
            Log.e(TAG, ".     /  \\");
            Log.e(TAG, ".    /    \\");
            Log.e(TAG, ".   / |  | \\");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".");
            return false;
        }
    }

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    public void crash() {
        new CrashTest().indexOutOfBounds();
    }

    /* access modifiers changed from: package-private */
    public void createCrashMarker() {
        this.crashMarker.create();
    }

    /* access modifiers changed from: package-private */
    public boolean didPreviousInitializationFail() {
        return this.initializationMarker.isPresent();
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    /* access modifiers changed from: package-private */
    public CrashlyticsController getController() {
        return this.controller;
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    /* access modifiers changed from: package-private */
    public CrashlyticsNdkData getNativeCrashData() {
        CrashlyticsNdkDataProvider crashlyticsNdkDataProvider2 = this.crashlyticsNdkDataProvider;
        if (crashlyticsNdkDataProvider2 != null) {
            return crashlyticsNdkDataProvider2.getCrashlyticsNdkData();
        }
        return null;
    }

    public PinningInfoProvider getPinningInfoProvider() {
        if (!this.disabled) {
            return this.pinningInfo;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String getUserEmail() {
        if (getIdManager().mo34189a()) {
            return this.userEmail;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String getUserIdentifier() {
        if (getIdManager().mo34189a()) {
            return this.userId;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String getUserName() {
        if (getIdManager().mo34189a()) {
            return this.userName;
        }
        return null;
    }

    public String getVersion() {
        return "2.7.0.33";
    }

    /* access modifiers changed from: package-private */
    public boolean internalVerifyPinning(URL url) {
        if (getPinningInfoProvider() == null) {
            return false;
        }
        HttpRequest a = this.httpRequestFactory.mo34368a(C6199c.GET, url.toString());
        ((HttpsURLConnection) a.mo34354j()).setInstanceFollowRedirects(false);
        a.mo34351g();
        return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
    }

    public void log(String str) {
        doLog(3, TAG, str);
    }

    public void logException(Throwable th) {
        if (this.disabled || !ensureFabricWithCalled("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            C6059c.m19630f().mo34084a(5, TAG, "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.controller.writeNonFatalException(Thread.currentThread(), th);
        }
    }

    /* access modifiers changed from: package-private */
    public void markInitializationComplete() {
        this.backgroundWorker.submit(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                try {
                    boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                    C6072k f = C6059c.m19630f();
                    f.mo34093d(CrashlyticsCore.TAG, "Initialization marker file removed: " + remove);
                    return Boolean.valueOf(remove);
                } catch (Exception e) {
                    C6059c.m19630f().mo34090b(CrashlyticsCore.TAG, "Problem encountered deleting Crashlytics initialization marker.", e);
                    return false;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void markInitializationStarted() {
        this.backgroundWorker.submitAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                CrashlyticsCore.this.initializationMarker.create();
                C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Initialization marker file created.");
                return null;
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        return onPreExecute(super.getContext());
    }

    public void setBool(String str, boolean z) {
        setString(str, Boolean.toString(z));
    }

    /* access modifiers changed from: package-private */
    public void setCrashlyticsNdkDataProvider(CrashlyticsNdkDataProvider crashlyticsNdkDataProvider2) {
        this.crashlyticsNdkDataProvider = crashlyticsNdkDataProvider2;
    }

    public void setDouble(String str, double d) {
        setString(str, Double.toString(d));
    }

    public void setFloat(String str, float f) {
        setString(str, Float.toString(f));
    }

    public void setInt(String str, int i) {
        setString(str, Integer.toString(i));
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        C6059c.m19630f().mo34086a(TAG, "Use of setListener is deprecated.");
        if (crashlyticsListener != null) {
            this.listener = crashlyticsListener;
        } else {
            throw new IllegalArgumentException("listener must not be null.");
        }
    }

    public void setLong(String str, long j) {
        setString(str, Long.toString(j));
    }

    public void setString(String str, String str2) {
        String str3;
        if (this.disabled || !ensureFabricWithCalled("prior to setting keys.")) {
            return;
        }
        if (str == null) {
            Context context = getContext();
            if (context == null || !C6090i.m19755j(context)) {
                C6059c.m19630f().mo34090b(TAG, "Attempting to set custom attribute with null key, ignoring.", (Throwable) null);
                return;
            }
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        String sanitizeAttribute = sanitizeAttribute(str);
        if (this.attributes.size() < 64 || this.attributes.containsKey(sanitizeAttribute)) {
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = sanitizeAttribute(str2);
            }
            this.attributes.put(sanitizeAttribute, str3);
            this.controller.cacheKeyData(this.attributes);
            return;
        }
        C6059c.m19630f().mo34093d(TAG, "Exceeded maximum number of custom attributes (64)");
    }

    public void setUserEmail(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            String sanitizeAttribute = sanitizeAttribute(str);
            this.userEmail = sanitizeAttribute;
            this.controller.cacheUserData(this.userId, this.userName, sanitizeAttribute);
        }
    }

    public void setUserIdentifier(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            String sanitizeAttribute = sanitizeAttribute(str);
            this.userId = sanitizeAttribute;
            this.controller.cacheUserData(sanitizeAttribute, this.userName, this.userEmail);
        }
    }

    public void setUserName(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            String sanitizeAttribute = sanitizeAttribute(str);
            this.userName = sanitizeAttribute;
            this.controller.cacheUserData(this.userId, sanitizeAttribute, this.userEmail);
        }
    }

    public boolean verifyPinning(URL url) {
        try {
            return internalVerifyPinning(url);
        } catch (Exception e) {
            C6059c.m19630f().mo34090b(TAG, "Could not verify SSL pinning", e);
            return false;
        }
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f, crashlyticsListener, pinningInfoProvider, z, C6100o.m19772a("Crashlytics Exception Handler"));
    }

    /* access modifiers changed from: protected */
    public Void doInBackground() {
        markInitializationStarted();
        this.controller.cleanInvalidTempFiles();
        try {
            this.controller.registerDevicePowerStateListener();
            C6155t a = C6150q.m19903d().mo34260a();
            if (a == null) {
                C6059c.m19630f().mo34086a(TAG, "Received null settings, skipping report submission!");
                markInitializationComplete();
                return null;
            }
            this.controller.registerAnalyticsEventListener(a);
            if (!a.f16177d.f16150b) {
                C6059c.m19630f().mo34093d(TAG, "Collection of crash reports disabled in Crashlytics settings.");
                markInitializationComplete();
                return null;
            } else if (!C6097l.m19766a(getContext()).mo34177a()) {
                C6059c.m19630f().mo34093d(TAG, "Automatic collection of crash reports disabled by Firebase settings.");
                markInitializationComplete();
                return null;
            } else {
                CrashlyticsNdkData nativeCrashData = getNativeCrashData();
                if (nativeCrashData != null && !this.controller.finalizeNativeReport(nativeCrashData)) {
                    C6059c.m19630f().mo34093d(TAG, "Could not finalize previous NDK sessions.");
                }
                if (!this.controller.finalizeSessions(a.f16175b)) {
                    C6059c.m19630f().mo34093d(TAG, "Could not finalize previous sessions.");
                }
                this.controller.submitAllReports(this.delay, a);
                markInitializationComplete();
                return null;
            }
        } catch (Exception e) {
            C6059c.m19630f().mo34090b(TAG, "Crashlytics encountered a problem during asynchronous initialization.", e);
        } catch (Throwable th) {
            markInitializationComplete();
            throw th;
        }
    }

    public void log(int i, String str, String str2) {
        doLog(i, str, str2);
        C6059c.m19630f().mo34085a(i, "" + str, "" + str2, CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT);
    }

    /* access modifiers changed from: package-private */
    public boolean onPreExecute(Context context) {
        String d;
        Context context2 = context;
        if (!C6097l.m19766a(context).mo34177a()) {
            C6059c.m19630f().mo34093d(TAG, "Crashlytics is disabled, because data collection is disabled by Firebase.");
            this.disabled = CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        }
        if (this.disabled || (d = new C6088g().mo34168d(context2)) == null) {
            return false;
        }
        String n = C6090i.m19759n(context);
        if (isBuildIdValid(n, C6090i.m19737a(context2, CRASHLYTICS_REQUIRE_BUILD_ID, (boolean) CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT))) {
            try {
                C6072k f = C6059c.m19630f();
                f.mo34095e(TAG, "Initializing Crashlytics Core " + getVersion());
                C6131b bVar = new C6131b(this);
                this.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, bVar);
                this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, bVar);
                PreferenceManager create = PreferenceManager.create(new C6133d(getContext(), PREFERENCE_STORE_NAME), this);
                CrashlyticsPinningInfoProvider crashlyticsPinningInfoProvider = this.pinningInfo != null ? new CrashlyticsPinningInfoProvider(this.pinningInfo) : null;
                C6197b bVar2 = new C6197b(C6059c.m19630f());
                this.httpRequestFactory = bVar2;
                bVar2.mo34370a(crashlyticsPinningInfoProvider);
                C6107s idManager = getIdManager();
                AppData create2 = AppData.create(context2, idManager, d, n);
                CrashlyticsController crashlyticsController = r1;
                CrashlyticsController crashlyticsController2 = new CrashlyticsController(this, this.backgroundWorker, this.httpRequestFactory, idManager, create, bVar, create2, new ResourceUnityVersionProvider(context2, new ManifestUnityVersionProvider(context2, create2.packageName)), new DefaultAppMeasurementEventListenerRegistrar(this), AppMeasurementEventLogger.getEventLogger(context));
                this.controller = crashlyticsController;
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                this.controller.enableExceptionHandling(Thread.getDefaultUncaughtExceptionHandler(), new C6106r().mo34188e(context2));
                if (!didPreviousInitializationFail || !C6090i.m19742b(context)) {
                    C6059c.m19630f().mo34093d(TAG, "Exception handling initialization successful");
                    return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
                }
                C6059c.m19630f().mo34093d(TAG, "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                finishInitSynchronously();
                return false;
            } catch (Exception e) {
                C6059c.m19630f().mo34090b(TAG, "Crashlytics was not started due to an exception during initialization", e);
                this.controller = null;
                return false;
            }
        } else {
            throw new UnmetDependencyException(MISSING_BUILD_ID_MSG);
        }
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.userEmail = null;
        this.userName = null;
        this.delay = f;
        this.listener = crashlyticsListener == null ? new NoOpListener() : crashlyticsListener;
        this.pinningInfo = pinningInfoProvider;
        this.disabled = z;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
        this.attributes = new ConcurrentHashMap<>();
        this.startTime = System.currentTimeMillis();
    }
}
