package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzctk implements zzbtb {
    private final AtomicReference<zzxf> zzgjn = new AtomicReference<>();

    public final void zzb(zzxf zzxf) {
        this.zzgjn.set(zzxf);
    }

    public final void zzb(zzuo zzuo) {
        zzdek.zza(this.zzgjn, new zzctn(zzuo));
    }
}
