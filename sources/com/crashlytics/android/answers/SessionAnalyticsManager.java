package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.BackgroundManager;
import com.crashlytics.android.answers.SessionEvent;
import java.util.concurrent.ScheduledExecutorService;
import p118io.fabric.sdk.android.C6054a;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6100o;
import p118io.fabric.sdk.android.p200m.p202b.C6107s;
import p118io.fabric.sdk.android.p200m.p204d.C6131b;
import p118io.fabric.sdk.android.p200m.p205e.C6135b;
import p118io.fabric.sdk.android.services.network.C6197b;

class SessionAnalyticsManager implements BackgroundManager.Listener {
    static final String EXECUTOR_SERVICE = "Answers Events Handler";
    static final String ON_CRASH_ERROR_MSG = "onCrash called from main thread!!!";
    final BackgroundManager backgroundManager;
    final AnswersEventsHandler eventsHandler;
    private final long installedAt;
    final C6054a lifecycleManager;
    final AnswersPreferenceManager preferenceManager;

    SessionAnalyticsManager(AnswersEventsHandler answersEventsHandler, C6054a aVar, BackgroundManager backgroundManager2, AnswersPreferenceManager answersPreferenceManager, long j) {
        this.eventsHandler = answersEventsHandler;
        this.lifecycleManager = aVar;
        this.backgroundManager = backgroundManager2;
        this.preferenceManager = answersPreferenceManager;
        this.installedAt = j;
    }

    public static SessionAnalyticsManager build(C6069h hVar, Context context, C6107s sVar, String str, String str2, long j) {
        Context context2 = context;
        C6107s sVar2 = sVar;
        SessionMetadataCollector sessionMetadataCollector = new SessionMetadataCollector(context, sVar, str, str2);
        AnswersFilesManagerProvider answersFilesManagerProvider = new AnswersFilesManagerProvider(context, new C6131b(hVar));
        C6197b bVar = new C6197b(C6059c.m19630f());
        C6054a aVar = new C6054a(context);
        ScheduledExecutorService b = C6100o.m19775b(EXECUTOR_SERVICE);
        BackgroundManager backgroundManager2 = new BackgroundManager(b);
        return new SessionAnalyticsManager(new AnswersEventsHandler(hVar, context, answersFilesManagerProvider, sessionMetadataCollector, bVar, b, new FirebaseAnalyticsApiAdapter(context)), aVar, backgroundManager2, AnswersPreferenceManager.build(context), j);
    }

    public void disable() {
        this.lifecycleManager.mo34075a();
        this.eventsHandler.disable();
    }

    public void enable() {
        this.eventsHandler.enable();
        this.lifecycleManager.mo34076a(new AnswersLifecycleCallbacks(this, this.backgroundManager));
        this.backgroundManager.registerListener(this);
        if (isFirstLaunch()) {
            onInstall(this.installedAt);
            this.preferenceManager.setAnalyticsLaunched();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isFirstLaunch() {
        return !this.preferenceManager.hasAnalyticsLaunched();
    }

    public void onBackground() {
        C6059c.m19630f().mo34093d(Answers.TAG, "Flush events when app is backgrounded");
        this.eventsHandler.flushEvents();
    }

    public void onCrash(String str, String str2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C6059c.m19630f().mo34093d(Answers.TAG, "Logged crash");
            this.eventsHandler.processEventSync(SessionEvent.crashEventBuilder(str, str2));
            return;
        }
        throw new IllegalStateException(ON_CRASH_ERROR_MSG);
    }

    public void onCustom(CustomEvent customEvent) {
        C6072k f = C6059c.m19630f();
        f.mo34093d(Answers.TAG, "Logged custom event: " + customEvent);
        this.eventsHandler.processEventAsync(SessionEvent.customEventBuilder(customEvent));
    }

    public void onError(String str) {
    }

    public void onInstall(long j) {
        C6059c.m19630f().mo34093d(Answers.TAG, "Logged install");
        this.eventsHandler.processEventAsyncAndFlush(SessionEvent.installEventBuilder(j));
    }

    public void onLifecycle(Activity activity, SessionEvent.Type type) {
        C6072k f = C6059c.m19630f();
        f.mo34093d(Answers.TAG, "Logged lifecycle event: " + type.name());
        this.eventsHandler.processEventAsync(SessionEvent.lifecycleEventBuilder(type, activity));
    }

    public void onPredefined(PredefinedEvent predefinedEvent) {
        C6072k f = C6059c.m19630f();
        f.mo34093d(Answers.TAG, "Logged predefined event: " + predefinedEvent);
        this.eventsHandler.processEventAsync(SessionEvent.predefinedEventBuilder(predefinedEvent));
    }

    public void setAnalyticsSettingsData(C6135b bVar, String str) {
        this.backgroundManager.setFlushOnBackground(bVar.f16122i);
        this.eventsHandler.setAnalyticsSettingsData(bVar, str);
    }
}
