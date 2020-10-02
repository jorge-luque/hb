package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzald implements zzagi {
    private final zzbaj<O> zzdej;
    private final /* synthetic */ zzalb zzdem;

    public zzald(zzalb zzalb, zzbaj<O> zzbaj) {
        this.zzdem = zzalb;
        this.zzdej = zzbaj;
    }

    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.zzdej.setException(new zzake());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzdej.setException(new zzake(str));
        }
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdej.set(this.zzdem.zzdea.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdej.setException(e);
        }
    }
}
