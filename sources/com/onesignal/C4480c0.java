package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* renamed from: com.onesignal.c0 */
/* compiled from: NotificationOpenedActivity */
public class C4480c0 extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4485d0.m15457b(this, getIntent());
        finish();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C4485d0.m15457b(this, getIntent());
        finish();
    }
}
