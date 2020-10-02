package com.crashlytics.android.answers;

import admost.sdk.base.AdMostZonePlacementStatus;
import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6088g;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p203c.C6126f;
import p118io.fabric.sdk.android.p200m.p203c.C6129i;
import p118io.fabric.sdk.android.p200m.p205e.C6135b;
import p118io.fabric.sdk.android.services.network.C6200d;

class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    C6088g apiKey = new C6088g();
    private final Context context;
    boolean customEventsEnabled = true;
    EventFilter eventFilter = new KeepAllEventFilter();
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    C6126f filesSender;
    private final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    boolean forwardToFirebaseAnalyticsEnabled = false;
    private final C6200d httpRequestFactory;
    boolean includePurchaseEventsInForwardedEvents = false;
    private final C6069h kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled = true;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference<>();
    volatile int rolloverIntervalSeconds = -1;

    public EnabledSessionAnalyticsManagerStrategy(C6069h hVar, Context context2, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, C6200d dVar, SessionEventMetadata sessionEventMetadata, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter2) {
        this.kit = hVar;
        this.context = context2;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = dVar;
        this.metadata = sessionEventMetadata;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter2;
    }

    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            C6090i.m19746c(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            this.rolloverFutureRef.get().cancel(false);
            this.rolloverFutureRef.set((Object) null);
        }
    }

    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    public void processEvent(SessionEvent.Builder builder) {
        SessionEvent build = builder.build(this.metadata);
        if (!this.customEventsEnabled && SessionEvent.Type.CUSTOM.equals(build.type)) {
            C6072k f = C6059c.m19630f();
            f.mo34093d(Answers.TAG, "Custom events tracking disabled - skipping event: " + build);
        } else if (!this.predefinedEventsEnabled && SessionEvent.Type.PREDEFINED.equals(build.type)) {
            C6072k f2 = C6059c.m19630f();
            f2.mo34093d(Answers.TAG, "Predefined events tracking disabled - skipping event: " + build);
        } else if (this.eventFilter.skipEvent(build)) {
            C6072k f3 = C6059c.m19630f();
            f3.mo34093d(Answers.TAG, "Skipping filtered event: " + build);
        } else {
            try {
                this.filesManager.writeEvent(build);
            } catch (IOException e) {
                C6072k f4 = C6059c.m19630f();
                f4.mo34090b(Answers.TAG, "Failed to write event: " + build, e);
            }
            scheduleTimeBasedRollOverIfNeeded();
            boolean z = SessionEvent.Type.CUSTOM.equals(build.type) || SessionEvent.Type.PREDEFINED.equals(build.type);
            boolean equals = "purchase".equals(build.predefinedType);
            if (this.forwardToFirebaseAnalyticsEnabled && z) {
                if (!equals || this.includePurchaseEventsInForwardedEvents) {
                    try {
                        this.firebaseAnalyticsApiAdapter.processEvent(build);
                    } catch (Exception e2) {
                        C6072k f5 = C6059c.m19630f();
                        f5.mo34090b(Answers.TAG, "Failed to map event to Firebase: " + build, e2);
                    }
                }
            }
        }
    }

    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (IOException e) {
            C6090i.m19731a(this.context, "Failed to roll file over.", (Throwable) e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void scheduleTimeBasedFileRollOver(long j, long j2) {
        if (this.rolloverFutureRef.get() == null) {
            C6129i iVar = new C6129i(this.context, this);
            Context context2 = this.context;
            C6090i.m19746c(context2, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(iVar, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                C6090i.m19731a(this.context, "Failed to schedule time based file roll over", (Throwable) e);
            }
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
        if (this.rolloverIntervalSeconds != -1) {
            scheduleTimeBasedFileRollOver((long) this.rolloverIntervalSeconds, (long) this.rolloverIntervalSeconds);
        }
    }

    public void sendEvents() {
        if (this.filesSender == null) {
            C6090i.m19746c(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        C6090i.m19746c(this.context, "Sending all files");
        List<File> batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i = 0;
        while (true) {
            try {
                if (batchOfFilesToSend.size() <= 0) {
                    break;
                }
                C6090i.m19746c(this.context, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(batchOfFilesToSend.size())}));
                boolean send = this.filesSender.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                }
                batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
            } catch (Exception e) {
                Context context2 = this.context;
                C6090i.m19731a(context2, "Failed to send batch of analytics files to server: " + e.getMessage(), (Throwable) e);
            }
        }
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }

    public void setAnalyticsSettingsData(C6135b bVar, String str) {
        this.filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(this.kit, str, bVar.f16114a, this.httpRequestFactory, this.apiKey.mo34168d(this.context)));
        this.filesManager.setAnalyticsSettingsData(bVar);
        this.forwardToFirebaseAnalyticsEnabled = bVar.f16118e;
        this.includePurchaseEventsInForwardedEvents = bVar.f16119f;
        C6072k f = C6059c.m19630f();
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase analytics forwarding ");
        String str2 = "enabled";
        sb.append(this.forwardToFirebaseAnalyticsEnabled ? str2 : AdMostZonePlacementStatus.DISABLED);
        f.mo34093d(Answers.TAG, sb.toString());
        C6072k f2 = C6059c.m19630f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Firebase analytics including purchase events ");
        sb2.append(this.includePurchaseEventsInForwardedEvents ? str2 : AdMostZonePlacementStatus.DISABLED);
        f2.mo34093d(Answers.TAG, sb2.toString());
        this.customEventsEnabled = bVar.f16120g;
        C6072k f3 = C6059c.m19630f();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Custom event tracking ");
        sb3.append(this.customEventsEnabled ? str2 : AdMostZonePlacementStatus.DISABLED);
        f3.mo34093d(Answers.TAG, sb3.toString());
        this.predefinedEventsEnabled = bVar.f16121h;
        C6072k f4 = C6059c.m19630f();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Predefined event tracking ");
        if (!this.predefinedEventsEnabled) {
            str2 = AdMostZonePlacementStatus.DISABLED;
        }
        sb4.append(str2);
        f4.mo34093d(Answers.TAG, sb4.toString());
        if (bVar.f16123j > 1) {
            C6059c.m19630f().mo34093d(Answers.TAG, "Event sampling enabled");
            this.eventFilter = new SamplingEventFilter(bVar.f16123j);
        }
        this.rolloverIntervalSeconds = bVar.f16115b;
        scheduleTimeBasedFileRollOver(0, (long) this.rolloverIntervalSeconds);
    }
}
