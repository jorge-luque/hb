package com.google.android.gms.internal.ads;

import admost.sdk.AdMostInterstitial;
import android.os.Bundle;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcyr implements zzdah<Bundle> {
    private final String zzgnk;

    public zzcyr(String str) {
        this.zzgnk = str;
    }

    /* access modifiers changed from: private */
    public static boolean zze(Set<String> set) {
        return set.contains(AdMostInterstitial.ZONE_TYPE_REWARDED) || set.contains(AdMostInterstitial.ZONE_TYPE_INTERSTITIAL) || set.contains("native") || set.contains("banner");
    }

    public final /* synthetic */ void zzs(Object obj) {
        zzdhj.zza((Bundle) obj, "omid_v", this.zzgnk);
    }
}
