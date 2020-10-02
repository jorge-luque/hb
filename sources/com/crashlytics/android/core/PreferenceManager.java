package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import p118io.fabric.sdk.android.p200m.p204d.C6132c;
import p118io.fabric.sdk.android.p200m.p204d.C6133d;

@SuppressLint({"CommitPrefEdits"})
class PreferenceManager {
    static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final String PREF_MIGRATION_COMPLETE = "preferences_migration_complete";
    private static final boolean SHOULD_ALWAYS_SEND_REPORTS_DEFAULT = false;
    private final CrashlyticsCore kit;
    private final C6132c preferenceStore;

    public PreferenceManager(C6132c cVar, CrashlyticsCore crashlyticsCore) {
        this.preferenceStore = cVar;
        this.kit = crashlyticsCore;
    }

    public static PreferenceManager create(C6132c cVar, CrashlyticsCore crashlyticsCore) {
        return new PreferenceManager(cVar, crashlyticsCore);
    }

    /* access modifiers changed from: package-private */
    public void setShouldAlwaysSendReports(boolean z) {
        C6132c cVar = this.preferenceStore;
        cVar.mo34242a(cVar.mo34241a().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
    }

    /* access modifiers changed from: package-private */
    public boolean shouldAlwaysSendReports() {
        if (!this.preferenceStore.get().contains(PREF_MIGRATION_COMPLETE)) {
            C6133d dVar = new C6133d(this.kit);
            if (!this.preferenceStore.get().contains(PREF_ALWAYS_SEND_REPORTS_KEY) && dVar.get().contains(PREF_ALWAYS_SEND_REPORTS_KEY)) {
                boolean z = dVar.get().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
                C6132c cVar = this.preferenceStore;
                cVar.mo34242a(cVar.mo34241a().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
            }
            C6132c cVar2 = this.preferenceStore;
            cVar2.mo34242a(cVar2.mo34241a().putBoolean(PREF_MIGRATION_COMPLETE, true));
        }
        return this.preferenceStore.get().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
    }
}
