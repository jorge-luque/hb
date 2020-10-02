package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcpf implements zzbxz {
    private final zzcnl zzgex;

    zzcpf(zzcnl zzcnl) {
        this.zzgex = zzcnl;
    }

    public final void zza(boolean z, Context context) {
        zzcnl zzcnl = this.zzgex;
        try {
            ((zzdhq) zzcnl.zzdgp).setImmersiveMode(z);
            ((zzdhq) zzcnl.zzdgp).showInterstitial();
        } catch (zzdhk e) {
            zzazw.zzfb("Cannot show interstitial.");
            throw new zzbxy(e.getCause());
        }
    }
}
