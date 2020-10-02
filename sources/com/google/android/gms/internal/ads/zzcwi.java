package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcwi implements zzdak<zzdah<Bundle>> {
    private final Executor executor;
    private final zzawd zzbnp;

    zzcwi(Executor executor2, zzawd zzawd) {
        this.executor = executor2;
        this.zzbnp = zzawd;
    }

    public final zzdri<zzdah<Bundle>> zzaqa() {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcnw)).booleanValue()) {
            return zzdqw.zzag(null);
        }
        return zzdqw.zzb(this.zzbnp.zzwc(), zzcwh.zzdsc, this.executor);
    }
}
