package com.google.android.gms.internal.ads;

import admost.sdk.base.AdMostAdClassName;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final /* synthetic */ class zzyb implements InitializationStatus {
    private final zzxw zzchl;

    zzyb(zzxw zzxw) {
        this.zzchl = zzxw;
    }

    public final Map getAdapterStatusMap() {
        zzxw zzxw = this.zzchl;
        HashMap hashMap = new HashMap();
        hashMap.put(AdMostAdClassName.ADMOB, new zzya(zzxw));
        return hashMap;
    }
}
