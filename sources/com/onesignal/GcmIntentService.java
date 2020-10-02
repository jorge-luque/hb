package com.onesignal;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.C4739z;
import p075d.p088f.p089a.C3217a;

public class GcmIntentService extends IntentService {
    public GcmIntentService() {
        super("GcmIntentService");
        setIntentRedelivery(true);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            C4714x.m16405a((Context) this, (C4528j) new C4534k(extras), (C4739z.C4740a) null);
            C3217a.completeWakefulIntent(intent);
        }
    }
}
