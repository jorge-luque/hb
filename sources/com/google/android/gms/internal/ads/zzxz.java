package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final /* synthetic */ class zzxz implements Runnable {
    private final zzxw zzchl;
    private final Context zzchn;

    zzxz(zzxw zzxw, Context context) {
        this.zzchl = zzxw;
        this.zzchn = context;
    }

    public final void run() {
        this.zzchl.getRewardedVideoAdInstance(this.zzchn);
    }
}
