package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;
import p118io.fabric.sdk.android.p200m.p205e.C6135b;

class DisabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    DisabledSessionAnalyticsManagerStrategy() {
    }

    public void cancelTimeBasedFileRollOver() {
    }

    public void deleteAllEvents() {
    }

    public void processEvent(SessionEvent.Builder builder) {
    }

    public boolean rollFileOver() throws IOException {
        return false;
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
    }

    public void sendEvents() {
    }

    public void setAnalyticsSettingsData(C6135b bVar, String str) {
    }
}
