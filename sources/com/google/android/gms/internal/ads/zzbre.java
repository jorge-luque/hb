package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbre extends zzbui<zzbrb> implements zzbrb {
    public zzbre(zzbri zzbri, Set<zzbvt<zzbrb>> set, Executor executor) {
        super(set);
        zza(zzbri, executor);
    }

    public final void zza(zzbxy zzbxy) {
        zza(new zzbrg(zzbxy));
    }

    public final void zzais() {
        zza(zzbrf.zzfnf);
    }

    public final void zzf(int i, String str) {
        zza(new zzbrd(i, str));
    }
}
