package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzafd extends zzaec {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzczp;

    public zzafd(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzczp = onCustomTemplateAdLoadedListener;
    }

    public final void zzb(zzado zzado) {
        this.zzczp.onCustomTemplateAdLoaded(zzadt.zza(zzado));
    }
}
