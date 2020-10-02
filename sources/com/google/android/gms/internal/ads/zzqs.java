package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzqs implements Runnable {
    private final /* synthetic */ zzqp zzbrc;
    private final /* synthetic */ View zzbrd;

    zzqs(zzqp zzqp, View view) {
        this.zzbrc = zzqp;
        this.zzbrd = view;
    }

    public final void run() {
        this.zzbrc.zzj(this.zzbrd);
    }
}
