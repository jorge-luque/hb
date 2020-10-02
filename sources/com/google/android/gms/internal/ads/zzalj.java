package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final /* synthetic */ class zzalj implements Runnable {
    private final Context zzchn;
    private final zzalh zzdeo;

    zzalj(zzalh zzalh, Context context) {
        this.zzdeo = zzalh;
        this.zzchn = context;
    }

    public final void run() {
        zzalh.zzn(this.zzchn);
    }
}
