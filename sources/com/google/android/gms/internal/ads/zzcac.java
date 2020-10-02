package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcac implements zzegz<zzcaa> {
    private final zzehm<JSONObject> zzeyy;
    private final zzehm<zzdgo> zzfia;

    public zzcac(zzehm<zzdgo> zzehm, zzehm<JSONObject> zzehm2) {
        this.zzfia = zzehm;
        this.zzeyy = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return new zzcaa(this.zzfia.get(), this.zzeyy.get());
    }
}
