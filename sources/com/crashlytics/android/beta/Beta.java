package com.crashlytics.android.beta;

import java.util.Collections;
import java.util.Map;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.p200m.p202b.C6099n;
import p118io.fabric.sdk.android.p200m.p202b.C6107s;

public class Beta extends C6069h<Boolean> implements C6099n {
    public static final String TAG = "Beta";

    public static Beta getInstance() {
        return (Beta) C6059c.m19621a(Beta.class);
    }

    public Map<C6107s.C6108a, String> getDeviceIdentifiers() {
        return Collections.emptyMap();
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String getVersion() {
        return "1.2.10.27";
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground() {
        C6059c.m19630f().mo34093d(TAG, "Beta kit initializing...");
        return true;
    }
}
