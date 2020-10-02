package com.crashlytics.android;

import android.content.Context;
import com.crashlytics.android.CrashlyticsInitProvider;
import p118io.fabric.sdk.android.p200m.p202b.C6097l;

class ManifestEnabledCheckStrategy implements CrashlyticsInitProvider.EnabledCheckStrategy {
    ManifestEnabledCheckStrategy() {
    }

    public boolean isCrashlyticsEnabled(Context context) {
        return C6097l.m19766a(context).mo34178b();
    }
}
