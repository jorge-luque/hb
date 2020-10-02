package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzaib extends zzahx {
    private final InstreamAd.InstreamAdLoadCallback zzdbp;

    public zzaib(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzdbp = instreamAdLoadCallback;
    }

    public final void onInstreamAdFailedToLoad(int i) {
        this.zzdbp.onInstreamAdFailedToLoad(i);
    }

    public final void zza(zzaho zzaho) {
        this.zzdbp.onInstreamAdLoaded(new zzahz(zzaho));
    }
}
