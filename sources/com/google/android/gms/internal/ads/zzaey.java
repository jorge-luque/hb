package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzaey extends zzadv {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzczl;

    public zzaey(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzczl = onAppInstallAdLoadedListener;
    }

    public final void zza(zzadg zzadg) {
        this.zzczl.onAppInstallAdLoaded(new zzadl(zzadg));
    }
}
