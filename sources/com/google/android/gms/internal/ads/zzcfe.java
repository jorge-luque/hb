package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcfe implements View.OnTouchListener {
    private final zzcfa zzfxg;

    zzcfe(zzcfa zzcfa) {
        this.zzfxg = zzcfa;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.zzfxg.zza(view, motionEvent);
    }
}
