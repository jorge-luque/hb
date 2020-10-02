package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzaax extends zzaav {
    private final OnCustomRenderedAdLoadedListener zzcha;

    public zzaax(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcha = onCustomRenderedAdLoadedListener;
    }

    public final void zza(zzaar zzaar) {
        this.zzcha.onCustomRenderedAdLoaded(new zzaao(zzaar));
    }
}
