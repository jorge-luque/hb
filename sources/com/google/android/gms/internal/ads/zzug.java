package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzug extends zzwf {
    private final AdMetadataListener zzcef;

    public zzug(AdMetadataListener adMetadataListener) {
        this.zzcef = adMetadataListener;
    }

    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzcef;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
