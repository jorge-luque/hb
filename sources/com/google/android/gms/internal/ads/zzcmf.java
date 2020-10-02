package com.google.android.gms.internal.ads;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzcmf implements zzaki<zzcmc> {
    zzcmf() {
    }

    public final /* synthetic */ JSONObject zzj(Object obj) throws JSONException {
        zzcmc zzcmc = (zzcmc) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcmc.zzgcs.zzuw());
        jSONObject2.put("signals", zzcmc.zzgcr);
        jSONObject3.put("body", zzcmc.zzgcq.zzdnr);
        jSONObject3.put("headers", zzq.zzkw().zzj((Map<String, ?>) zzcmc.zzgcq.zzab));
        jSONObject3.put("response_code", zzcmc.zzgcq.zzgcz);
        jSONObject3.put("latency", zzcmc.zzgcq.zzgda);
        jSONObject.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcmc.zzgcs.zzuz());
        return jSONObject;
    }
}
