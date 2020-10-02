package com.crashlytics.android.answers;

import android.content.Context;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;

class FirebaseAnalyticsApiAdapter {
    private final Context context;
    private EventLogger eventLogger;
    private final FirebaseAnalyticsEventMapper eventMapper;

    public FirebaseAnalyticsApiAdapter(Context context2) {
        this(context2, new FirebaseAnalyticsEventMapper());
    }

    public EventLogger getFirebaseAnalytics() {
        if (this.eventLogger == null) {
            this.eventLogger = AppMeasurementEventLogger.getEventLogger(this.context);
        }
        return this.eventLogger;
    }

    public void processEvent(SessionEvent sessionEvent) {
        EventLogger firebaseAnalytics = getFirebaseAnalytics();
        if (firebaseAnalytics == null) {
            C6059c.m19630f().mo34093d(Answers.TAG, "Firebase analytics logging was enabled, but not available...");
            return;
        }
        FirebaseAnalyticsEvent mapEvent = this.eventMapper.mapEvent(sessionEvent);
        if (mapEvent == null) {
            C6072k f = C6059c.m19630f();
            f.mo34093d(Answers.TAG, "Fabric event was not mappable to Firebase event: " + sessionEvent);
            return;
        }
        firebaseAnalytics.logEvent(mapEvent.getEventName(), mapEvent.getEventParams());
        if ("levelEnd".equals(sessionEvent.predefinedType)) {
            firebaseAnalytics.logEvent("post_score", mapEvent.getEventParams());
        }
    }

    public FirebaseAnalyticsApiAdapter(Context context2, FirebaseAnalyticsEventMapper firebaseAnalyticsEventMapper) {
        this.context = context2;
        this.eventMapper = firebaseAnalyticsEventMapper;
    }
}
