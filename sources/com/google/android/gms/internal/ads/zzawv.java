package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzawv implements Runnable {
    private final Context zzchn;
    private final String zzdep;
    private final zzaww zzdvh;

    zzawv(zzaww zzaww, Context context, String str) {
        this.zzdvh = zzaww;
        this.zzchn = context;
        this.zzdep = str;
    }

    public final void run() {
        this.zzdvh.zzp(this.zzchn, this.zzdep);
    }
}
