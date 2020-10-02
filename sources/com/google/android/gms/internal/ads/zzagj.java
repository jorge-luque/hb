package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzagj implements zzagi {
    private final /* synthetic */ zzbaj zzdax;

    zzagj(zzagg zzagg, zzbaj zzbaj) {
        this.zzdax = zzbaj;
    }

    public final void onFailure(String str) {
        this.zzdax.setException(new zzake(str));
    }

    public final void zzc(JSONObject jSONObject) {
        this.zzdax.set(jSONObject);
    }
}
