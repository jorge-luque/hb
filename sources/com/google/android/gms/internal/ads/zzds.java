package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzds implements Runnable {
    private final /* synthetic */ MotionEvent zzxh;

    zzds(zzdl zzdl, MotionEvent motionEvent) {
        this.zzxh = motionEvent;
    }

    public final void run() {
        try {
            zzdl.zzvw.zza(this.zzxh);
        } catch (Exception e) {
            zzdl.zzvy.zza(2022, -1, e);
        }
    }
}
