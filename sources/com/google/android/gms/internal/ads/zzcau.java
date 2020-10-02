package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzcau implements zzacg {
    private final /* synthetic */ zzcbj zzftq;
    private final /* synthetic */ ViewGroup zzftr;
    private final /* synthetic */ zzcat zzfts;

    zzcau(zzcat zzcat, zzcbj zzcbj, ViewGroup viewGroup) {
        this.zzfts = zzcat;
        this.zzftq = zzcbj;
        this.zzftr = viewGroup;
    }

    public final void zzc(MotionEvent motionEvent) {
        this.zzftq.onTouch((View) null, motionEvent);
    }

    public final void zzrx() {
        if (zzcat.zza(this.zzftq, zzcar.zzfth)) {
            this.zzftq.onClick(this.zzftr);
        }
    }
}
