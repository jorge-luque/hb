package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzn implements View.OnTouchListener {
    private final /* synthetic */ zzl zzbmn;

    zzn(zzl zzl) {
        this.zzbmn = zzl;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzbmn.zzbmu == null) {
            return false;
        }
        this.zzbmn.zzbmu.zza(motionEvent);
        return false;
    }
}
