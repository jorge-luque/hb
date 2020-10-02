package com.google.android.gms.ads.query;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzazw;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public class AdInfo {
    private final QueryInfo zzhas;
    private final String zzhat;

    @KeepForSdk
    public AdInfo(QueryInfo queryInfo, String str) {
        this.zzhas = queryInfo;
        this.zzhat = str;
    }

    @KeepForSdk
    public static String getRequestId(String str) {
        if (str == null) {
            zzazw.zzfc("adString passed to AdInfo.getRequestId() cannot be null. Returning empty string.");
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            zzazw.zzfc("Invalid adString passed to AdInfo.getRequestId(). Returning empty string.");
            return "";
        }
    }

    @KeepForSdk
    public String getAdString() {
        return this.zzhat;
    }

    @KeepForSdk
    public QueryInfo getQueryInfo() {
        return this.zzhas;
    }
}
