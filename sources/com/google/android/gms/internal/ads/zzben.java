package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzben implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzaun zzeij;
    private final /* synthetic */ zzbej zzeik;

    zzben(zzbej zzbej, zzaun zzaun) {
        this.zzeik = zzbej;
        this.zzeij = zzaun;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzeik.zza(view, this.zzeij, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
