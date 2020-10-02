package com.google.android.gms.internal.ads;

import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzckm implements zzdqj {
    private final zzckn zzgbl;
    private final zzud zzgbm;

    zzckm(zzckn zzckn, zzud zzud) {
        this.zzgbl = zzckn;
        this.zzgbm = zzud;
    }

    public final zzdri zzf(Object obj) {
        zzud zzud = this.zzgbm;
        String str = (String) obj;
        String str2 = zzud.zzcec;
        String str3 = zzud.zzced;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("headers", new JSONObject());
        jSONObject3.put("body", str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzdqw.zzag(jSONObject);
    }
}
