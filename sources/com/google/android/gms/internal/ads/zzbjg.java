package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbjg implements zzegz<zzaym> {
    private final zzehm<Context> zzenp;

    public zzbjg(zzehm<Context> zzehm) {
        this.zzenp = zzehm;
    }

    public final /* synthetic */ Object get() {
        return (zzaym) zzehf.zza(new zzaym(this.zzenp.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
