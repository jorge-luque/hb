package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import java.util.concurrent.ScheduledExecutorService;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.p200m.p203c.C6124d;
import p118io.fabric.sdk.android.p200m.p205e.C6135b;
import p118io.fabric.sdk.android.services.network.C6200d;

class AnswersEventsHandler implements C6124d {
    /* access modifiers changed from: private */
    public final Context context;
    final ScheduledExecutorService executor;
    /* access modifiers changed from: private */
    public final AnswersFilesManagerProvider filesManagerProvider;
    /* access modifiers changed from: private */
    public final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    /* access modifiers changed from: private */
    public final C6069h kit;
    /* access modifiers changed from: private */
    public final SessionMetadataCollector metadataCollector;
    /* access modifiers changed from: private */
    public final C6200d requestFactory;
    SessionAnalyticsManagerStrategy strategy = new DisabledSessionAnalyticsManagerStrategy();

    public AnswersEventsHandler(C6069h hVar, Context context2, AnswersFilesManagerProvider answersFilesManagerProvider, SessionMetadataCollector sessionMetadataCollector, C6200d dVar, ScheduledExecutorService scheduledExecutorService, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter2) {
        this.kit = hVar;
        this.context = context2;
        this.filesManagerProvider = answersFilesManagerProvider;
        this.metadataCollector = sessionMetadataCollector;
        this.requestFactory = dVar;
        this.executor = scheduledExecutorService;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter2;
    }

    private void executeAsync(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Exception e) {
            C6059c.m19630f().mo34090b(Answers.TAG, "Failed to submit events task", e);
        }
    }

    private void executeSync(Runnable runnable) {
        try {
            this.executor.submit(runnable).get();
        } catch (Exception e) {
            C6059c.m19630f().mo34090b(Answers.TAG, "Failed to run events task", e);
        }
    }

    public void disable() {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    SessionAnalyticsManagerStrategy sessionAnalyticsManagerStrategy = AnswersEventsHandler.this.strategy;
                    AnswersEventsHandler.this.strategy = new DisabledSessionAnalyticsManagerStrategy();
                    sessionAnalyticsManagerStrategy.deleteAllEvents();
                } catch (Exception e) {
                    C6059c.m19630f().mo34090b(Answers.TAG, "Failed to disable events", e);
                }
            }
        });
    }

    public void enable() {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    SessionEventMetadata metadata = AnswersEventsHandler.this.metadataCollector.getMetadata();
                    SessionAnalyticsFilesManager analyticsFilesManager = AnswersEventsHandler.this.filesManagerProvider.getAnalyticsFilesManager();
                    analyticsFilesManager.registerRollOverListener(AnswersEventsHandler.this);
                    AnswersEventsHandler.this.strategy = new EnabledSessionAnalyticsManagerStrategy(AnswersEventsHandler.this.kit, AnswersEventsHandler.this.context, AnswersEventsHandler.this.executor, analyticsFilesManager, AnswersEventsHandler.this.requestFactory, metadata, AnswersEventsHandler.this.firebaseAnalyticsApiAdapter);
                } catch (Exception e) {
                    C6059c.m19630f().mo34090b(Answers.TAG, "Failed to enable events", e);
                }
            }
        });
    }

    public void flushEvents() {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.rollFileOver();
                } catch (Exception e) {
                    C6059c.m19630f().mo34090b(Answers.TAG, "Failed to flush events", e);
                }
            }
        });
    }

    public void onRollOver(String str) {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.sendEvents();
                } catch (Exception e) {
                    C6059c.m19630f().mo34090b(Answers.TAG, "Failed to send events files", e);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void processEvent(final SessionEvent.Builder builder, boolean z, final boolean z2) {
        C22496 r0 = new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.processEvent(builder);
                    if (z2) {
                        AnswersEventsHandler.this.strategy.rollFileOver();
                    }
                } catch (Exception e) {
                    C6059c.m19630f().mo34090b(Answers.TAG, "Failed to process event", e);
                }
            }
        };
        if (z) {
            executeSync(r0);
        } else {
            executeAsync(r0);
        }
    }

    public void processEventAsync(SessionEvent.Builder builder) {
        processEvent(builder, false, false);
    }

    public void processEventAsyncAndFlush(SessionEvent.Builder builder) {
        processEvent(builder, false, true);
    }

    public void processEventSync(SessionEvent.Builder builder) {
        processEvent(builder, true, false);
    }

    public void setAnalyticsSettingsData(final C6135b bVar, final String str) {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.setAnalyticsSettingsData(bVar, str);
                } catch (Exception e) {
                    C6059c.m19630f().mo34090b(Answers.TAG, "Failed to set analytics settings data", e);
                }
            }
        });
    }
}
