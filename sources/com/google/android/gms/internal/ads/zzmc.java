package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzmc implements Runnable {
    private final /* synthetic */ zzly zzbau;
    private final /* synthetic */ IOException zzbca;

    zzmc(zzly zzly, IOException iOException) {
        this.zzbau = zzly;
        this.zzbca = iOException;
    }

    public final void run() {
        this.zzbau.zzbaw.zzb(this.zzbca);
    }
}
