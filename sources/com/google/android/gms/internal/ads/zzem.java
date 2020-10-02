package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzem extends BroadcastReceiver {
    private boolean zzyg = true;

    zzem(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(this, intentFilter);
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zzyg = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zzyg = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzcg() {
        return this.zzyg;
    }
}
