package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzaqc;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzyh;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public class QueryInfo {
    private final zzyh zzhau;

    public QueryInfo(zzyh zzyh) {
        this.zzhau = zzyh;
    }

    @KeepForSdk
    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzxt zzxt;
        if (adRequest == null) {
            zzxt = null;
        } else {
            zzxt = adRequest.zzdq();
        }
        new zzaqc(context, adFormat, zzxt).zza(queryInfoGenerationCallback);
    }

    @KeepForSdk
    public String getQuery() {
        return this.zzhau.getQuery();
    }

    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zzhau.getQueryBundle();
    }

    @KeepForSdk
    public String getRequestId() {
        return zzyh.zza(this);
    }
}
