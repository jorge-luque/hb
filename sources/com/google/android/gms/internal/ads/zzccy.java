package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzccy implements zzpz {
    private final zzbek zzelg;

    zzccy(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    public final void zza(zzqa zzqa) {
        zzbek zzbek = this.zzelg;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", zzqa.zzbot ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzbek.zza("onAdVisibilityChanged", hashMap);
    }
}
