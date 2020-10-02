package com.google.android.gms.internal.ads;

import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbqs extends zzxj {
    private final String zzfna;
    private final String zzfnb;

    public zzbqs(zzdgo zzdgo, String str) {
        String str2;
        String str3 = null;
        if (zzdgo == null) {
            str2 = null;
        } else {
            str2 = zzdgo.zzfnb;
        }
        this.zzfnb = str2;
        str3 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzb(zzdgo) : str3;
        this.zzfna = str3 != null ? str3 : str;
    }

    private static String zzb(zzdgo zzdgo) {
        try {
            return zzdgo.zzgtu.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String getMediationAdapterClassName() {
        return this.zzfna;
    }

    public final String getResponseId() {
        return this.zzfnb;
    }
}
