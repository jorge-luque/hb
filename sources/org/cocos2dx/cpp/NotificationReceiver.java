package org.cocos2dx.cpp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;

public class NotificationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (C3597b.m12267a().f10092a == null || !C3597b.m12267a().f10092a.f17485c) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if ((Build.VERSION.SDK_INT > 20 && !powerManager.isInteractive()) || !powerManager.isScreenOn()) {
                powerManager.newWakeLock(805306394, "NotificationPublisher:MyLock").acquire(3000);
                powerManager.newWakeLock(1, "NotificationPublisher:MyCpuLock").acquire(3000);
            }
            C6722d.m21983b(context, intent);
        }
    }
}
