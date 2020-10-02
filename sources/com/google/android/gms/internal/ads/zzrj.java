package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzrj extends zzrr {
    private final AppOpenAdPresentationCallback zzbry;

    public zzrj(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzbry = appOpenAdPresentationCallback;
    }

    public final void onAppOpenAdClosed() {
        this.zzbry.onAppOpenAdClosed();
    }
}
