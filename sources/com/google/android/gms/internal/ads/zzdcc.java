package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdcc implements zzdah<JSONObject> {
    private List<String> zzdmi;

    public zzdcc(List<String> list) {
        this.zzdmi = list;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(",", this.zzdmi));
        } catch (JSONException unused) {
            zzawr.zzeg("Failed putting experiment ids.");
        }
    }
}
