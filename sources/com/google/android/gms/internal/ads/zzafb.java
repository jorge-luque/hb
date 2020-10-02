package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzafb extends zzadw {
    private final NativeContentAd.OnContentAdLoadedListener zzczn;

    public zzafb(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzczn = onContentAdLoadedListener;
    }

    public final void zza(zzadk zzadk) {
        this.zzczn.onContentAdLoaded(new zzadp(zzadk));
    }
}
