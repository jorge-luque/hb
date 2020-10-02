package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdqj;
import com.google.android.gms.internal.ads.zzdqw;
import com.google.android.gms.internal.ads.zzdri;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzf implements zzdqj {
    static final zzdqj zzbly = new zzf();

    private zzf() {
    }

    public final zzdri zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzq.zzla().zzwb().zzej(jSONObject.getString("appSettingsJson"));
        }
        return zzdqw.zzag(null);
    }
}
