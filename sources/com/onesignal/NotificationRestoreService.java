package com.onesignal;

import android.app.IntentService;
import android.content.Intent;
import p075d.p088f.p089a.C3217a;

public class NotificationRestoreService extends IntentService {
    public NotificationRestoreService() {
        super("NotificationRestoreService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            Thread.currentThread().setPriority(10);
            C4564n1.m15865k(this);
            C4495e0.m15485b(this);
            C3217a.completeWakefulIntent(intent);
        }
    }
}
