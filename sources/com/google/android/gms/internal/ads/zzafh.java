package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzafh extends zzaeq {
    private final UnifiedNativeAd.UnconfirmedClickListener zzczv;

    public zzafh(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzczv = unconfirmedClickListener;
    }

    public final void onUnconfirmedClickCancelled() {
        this.zzczv.onUnconfirmedClickCancelled();
    }

    public final void onUnconfirmedClickReceived(String str) {
        this.zzczv.onUnconfirmedClickReceived(str);
    }
}
