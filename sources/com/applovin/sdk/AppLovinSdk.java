package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C1986c;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    private static final Map<String, AppLovinSdk> sdkInstances = new HashMap();
    private static final Object sdkInstancesLock = new Object();
    private final C1941j mSdkImpl;

    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    /* renamed from: com.applovin.sdk.AppLovinSdk$a */
    private static class C2055a extends AppLovinSdkSettings {
        C2055a(Context context) {
            super(context);
        }
    }

    private AppLovinSdk(C1941j jVar) {
        this.mSdkImpl = jVar;
    }

    /* renamed from: a */
    public static List<AppLovinSdk> m8096a() {
        return new ArrayList(sdkInstances.values());
    }

    public static AppLovinSdk getInstance(Context context) {
        return getInstance(new C2055a(context), context);
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return getInstance(C1986c.m7820a(context).mo8769a("applovin.sdk.key", ""), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public static AppLovinSdk getInstance(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (appLovinSdkSettings == null) {
            throw new IllegalArgumentException("No userSettings specified");
        } else if (context != null) {
            synchronized (sdkInstancesLock) {
                if (sdkInstances.containsKey(str)) {
                    AppLovinSdk appLovinSdk = sdkInstances.get(str);
                    return appLovinSdk;
                }
                if (!TextUtils.isEmpty(str) && str.contains(File.separator)) {
                    C1977q.m7751i(TAG, "\n**************************************************\nINVALID SDK KEY: " + str + "\n**************************************************\n");
                    if (!sdkInstances.isEmpty()) {
                        AppLovinSdk next = sdkInstances.values().iterator().next();
                        return next;
                    }
                    str = str.replace(File.separator, "");
                }
                C1941j jVar = new C1941j();
                jVar.mo8561a(str, appLovinSdkSettings, context);
                AppLovinSdk appLovinSdk2 = new AppLovinSdk(jVar);
                jVar.mo8559a(appLovinSdk2);
                sdkInstances.put(str, appLovinSdk2);
                return appLovinSdk2;
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    private static String getVersion() {
        return "9.12.8";
    }

    private static int getVersionCode() {
        return 91208;
    }

    public static void initializeSdk(Context context) {
        initializeSdk(context, (SdkInitializationListener) null);
    }

    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context != null) {
            AppLovinSdk instance = getInstance(context);
            if (instance != null) {
                instance.initializeSdk(sdkInitializationListener);
            } else {
                C1977q.m7751i(TAG, "Unable to initialize AppLovin SDK: SDK object not created");
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    static void reinitializeAll(Boolean bool, Boolean bool2, Boolean bool3) {
        synchronized (sdkInstancesLock) {
            for (AppLovinSdk next : sdkInstances.values()) {
                next.mSdkImpl.mo8577b();
                if (bool != null) {
                    C1977q v = next.mSdkImpl.mo8602v();
                    v.mo8744c(TAG, "Toggled 'huc' to " + bool);
                    next.getEventService().trackEvent("huc", C1989e.m7834a(AppMeasurementSdk.ConditionalUserProperty.VALUE, bool.toString()));
                }
                if (bool2 != null) {
                    C1977q v2 = next.mSdkImpl.mo8602v();
                    v2.mo8744c(TAG, "Toggled 'aru' to " + bool2);
                    next.getEventService().trackEvent("aru", C1989e.m7834a(AppMeasurementSdk.ConditionalUserProperty.VALUE, bool2.toString()));
                }
                if (bool3 != null) {
                    C1977q v3 = next.mSdkImpl.mo8602v();
                    v3.mo8744c(TAG, "Toggled 'dns' to " + bool3);
                    next.getEventService().trackEvent("dns", C1989e.m7834a(AppMeasurementSdk.ConditionalUserProperty.VALUE, bool3.toString()));
                }
            }
        }
    }

    public AppLovinAdService getAdService() {
        return this.mSdkImpl.mo8594o();
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public Context getApplicationContext() {
        return this.mSdkImpl.mo8527E();
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.mSdkImpl.mo8592m();
    }

    public AppLovinEventService getEventService() {
        return this.mSdkImpl.mo8596q();
    }

    @Deprecated
    public C1977q getLogger() {
        return this.mSdkImpl.mo8602v();
    }

    public String getMediationProvider() {
        return this.mSdkImpl.mo8593n();
    }

    public AppLovinNativeAdService getNativeAdService() {
        return this.mSdkImpl.mo8595p();
    }

    public AppLovinPostbackService getPostbackService() {
        return this.mSdkImpl.mo8539R();
    }

    public String getSdkKey() {
        return this.mSdkImpl.mo8599t();
    }

    public AppLovinSdkSettings getSettings() {
        return this.mSdkImpl.mo8591l();
    }

    public String getUserIdentifier() {
        return this.mSdkImpl.mo8588i();
    }

    public AppLovinUserService getUserService() {
        return this.mSdkImpl.mo8597r();
    }

    public AppLovinVariableService getVariableService() {
        return this.mSdkImpl.mo8598s();
    }

    public boolean hasCriticalErrors() {
        return this.mSdkImpl.mo8601u();
    }

    public void initializeSdk() {
    }

    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.mSdkImpl.mo8558a(sdkInitializationListener);
    }

    public boolean isEnabled() {
        return this.mSdkImpl.mo8583d();
    }

    public void setMediationProvider(String str) {
        this.mSdkImpl.mo8581c(str);
    }

    public void setPluginVersion(String str) {
        this.mSdkImpl.mo8560a(str);
    }

    public void setUserIdentifier(String str) {
        this.mSdkImpl.mo8579b(str);
    }

    public void showMediationDebugger() {
        this.mSdkImpl.mo8587h();
    }

    public String toString() {
        return "AppLovinSdk{sdkKey='" + getSdkKey() + "', isEnabled=" + isEnabled() + ", isFirstSession=" + this.mSdkImpl.mo8530I() + '}';
    }
}
