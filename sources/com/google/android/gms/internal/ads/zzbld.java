package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbld implements zzegz<JSONObject> {
    private final zzehm<zzdgo> zzfia;

    private zzbld(zzehm<zzdgo> zzehm) {
        this.zzfia = zzehm;
    }

    public static zzbld zzc(zzehm<zzdgo> zzehm) {
        return new zzbld(zzehm);
    }

    public final /* synthetic */ Object get() {
        return zzbla.zza(this.zzfia.get());
    }
}
