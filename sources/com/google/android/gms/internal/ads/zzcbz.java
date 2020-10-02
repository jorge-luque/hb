package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcbz implements Callable {
    private final zzdgo zzfjm;
    private final zzcbw zzfuu;
    private final zzdha zzfvc;
    private final JSONObject zzfvd;

    zzcbz(zzcbw zzcbw, zzdha zzdha, zzdgo zzdgo, JSONObject jSONObject) {
        this.zzfuu = zzcbw;
        this.zzfvc = zzdha;
        this.zzfjm = zzdgo;
        this.zzfvd = jSONObject;
    }

    public final Object call() {
        zzdha zzdha = this.zzfvc;
        zzdgo zzdgo = this.zzfjm;
        JSONObject jSONObject = this.zzfvd;
        zzbzx zzbzx = new zzbzx();
        zzbzx.zzdr(jSONObject.optInt(ReportDBAdapter.ReportColumns.COLUMN_TEMPATE_ID, -1));
        zzbzx.zzfy(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzbzx.zzfz(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzdhe zzdhe = zzdha.zzgur.zzfll;
        if (zzdhe.zzguy.contains(Integer.toString(zzbzx.zzakw()))) {
            if (zzbzx.zzakw() == 3) {
                if (zzbzx.getCustomTemplateId() == null) {
                    throw new zzcqm("No custom template id for custom template ad response.", 0);
                } else if (!zzdhe.zzguz.contains(zzbzx.getCustomTemplateId())) {
                    throw new zzcqm("Unexpected custom template id in the response.", 0);
                }
            }
            zzbzx.setStarRating(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzdgo.zzdpp) {
                zzq.zzkw();
                String zzxj = zzaxa.zzxj();
                StringBuilder sb = new StringBuilder(String.valueOf(zzxj).length() + 3 + String.valueOf(optString).length());
                sb.append(zzxj);
                sb.append(" : ");
                sb.append(optString);
                optString = sb.toString();
            }
            zzbzx.zzn("headline", optString);
            zzbzx.zzn("body", jSONObject.optString("body", (String) null));
            zzbzx.zzn("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzbzx.zzn("store", jSONObject.optString("store", (String) null));
            zzbzx.zzn("price", jSONObject.optString("price", (String) null));
            zzbzx.zzn(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, jSONObject.optString(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, (String) null));
            return zzbzx;
        }
        int zzakw = zzbzx.zzakw();
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Invalid template ID: ");
        sb2.append(zzakw);
        throw new zzcqm(sb2.toString(), 0);
    }
}
