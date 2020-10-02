package com.google.android.gms.internal.ads;

import admost.sdk.AdMostInterstitial;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbxu implements zzegz<String> {
    public static zzbxu zzajz() {
        return zzbxx.zzfpe;
    }

    public static String zzaka() {
        return (String) zzehf.zza(AdMostInterstitial.ZONE_TYPE_INTERSTITIAL, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzaka();
    }
}
