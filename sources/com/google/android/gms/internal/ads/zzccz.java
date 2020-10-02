package com.google.android.gms.internal.ads;

import android.graphics.Rect;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzccz implements zzpz {
    private final zzbek zzelg;

    zzccz(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    public final void zza(zzqa zzqa) {
        zzbfw zzabj = this.zzelg.zzabj();
        Rect rect = zzqa.zzbpe;
        zzabj.zza(rect.left, rect.top, false);
    }
}
