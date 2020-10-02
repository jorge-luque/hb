package com.google.android.gms.ads.formats;

import android.widget.ImageView;
import com.google.android.gms.internal.ads.zzacj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final /* synthetic */ class zzd implements zzacj {
    private final UnifiedNativeAdView zzbln;

    zzd(UnifiedNativeAdView unifiedNativeAdView) {
        this.zzbln = unifiedNativeAdView;
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzbln.zza(scaleType);
    }
}
