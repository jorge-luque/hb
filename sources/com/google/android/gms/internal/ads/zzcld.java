package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcld implements zzegz<zzcla> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzauu> zzffy;

    private zzcld(zzehm<Context> zzehm, zzehm<zzauu> zzehm2) {
        this.zzenp = zzehm;
        this.zzffy = zzehm2;
    }

    public static zzcld zzal(zzehm<Context> zzehm, zzehm<zzauu> zzehm2) {
        return new zzcld(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcla(this.zzenp.get(), this.zzffy.get());
    }
}
