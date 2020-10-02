package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzpx extends BroadcastReceiver {
    private final /* synthetic */ zzpv zzboz;

    zzpx(zzpv zzpv) {
        this.zzboz = zzpv;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzboz.zzbo(3);
    }
}
