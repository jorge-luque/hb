package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import p118io.fabric.sdk.android.p200m.p203c.C6125e;
import p118io.fabric.sdk.android.p200m.p205e.C6135b;

interface SessionAnalyticsManagerStrategy extends C6125e {
    void deleteAllEvents();

    void processEvent(SessionEvent.Builder builder);

    void sendEvents();

    void setAnalyticsSettingsData(C6135b bVar, String str);
}
