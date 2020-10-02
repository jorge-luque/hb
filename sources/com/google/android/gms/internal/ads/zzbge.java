package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbge implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzaun zzeij;
    private final /* synthetic */ int zzeil;
    private final /* synthetic */ zzbgc zzelm;

    zzbge(zzbgc zzbgc, View view, zzaun zzaun, int i) {
        this.zzelm = zzbgc;
        this.val$view = view;
        this.zzeij = zzaun;
        this.zzeil = i;
    }

    public final void run() {
        this.zzelm.zza(this.val$view, this.zzeij, this.zzeil - 1);
    }
}
