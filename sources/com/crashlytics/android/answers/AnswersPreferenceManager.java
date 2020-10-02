package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import p118io.fabric.sdk.android.p200m.p204d.C6132c;
import p118io.fabric.sdk.android.p200m.p204d.C6133d;

class AnswersPreferenceManager {
    static final String PREFKEY_ANALYTICS_LAUNCHED = "analytics_launched";
    static final String PREF_STORE_NAME = "settings";
    private final C6132c prefStore;

    AnswersPreferenceManager(C6132c cVar) {
        this.prefStore = cVar;
    }

    public static AnswersPreferenceManager build(Context context) {
        return new AnswersPreferenceManager(new C6133d(context, PREF_STORE_NAME));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean hasAnalyticsLaunched() {
        return this.prefStore.get().getBoolean(PREFKEY_ANALYTICS_LAUNCHED, false);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void setAnalyticsLaunched() {
        C6132c cVar = this.prefStore;
        cVar.mo34242a(cVar.mo34241a().putBoolean(PREFKEY_ANALYTICS_LAUNCHED, true));
    }
}
