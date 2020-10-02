package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzafe extends zzaek {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzczq;

    public zzafe(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzczq = onUnifiedNativeAdLoadedListener;
    }

    public final void zza(zzaes zzaes) {
        this.zzczq.onUnifiedNativeAdLoaded(new zzaex(zzaes));
    }
}
