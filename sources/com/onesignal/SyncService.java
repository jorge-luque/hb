package com.onesignal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.onesignal.C4469a2;

public class SyncService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C4469a2.m15409a((Context) this, (C4469a2.C4472c) new C4469a2.C4470a(this));
        return 1;
    }
}
