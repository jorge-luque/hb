package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdt;
import com.google.android.gms.internal.ads.zzdu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzm implements Callable<zzdt> {
    private final /* synthetic */ zzl zzbmn;

    zzm(zzl zzl) {
        this.zzbmn = zzl;
    }

    public final /* synthetic */ Object call() throws Exception {
        return new zzdt(zzdu.zzb(this.zzbmn.zzbmo.zzbnd, this.zzbmn.zzvf, false));
    }
}
