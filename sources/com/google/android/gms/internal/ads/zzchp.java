package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzchp implements zzbrc, zzbsm, zzbtm {
    private final zzchx zzfyw;
    private final zzcie zzfyx;

    public zzchp(zzchx zzchx, zzcie zzcie) {
        this.zzfyw = zzchx;
        this.zzfyx = zzcie;
    }

    public final void onAdFailedToLoad(int i) {
        this.zzfyw.zzrm().put(NativeProtocol.WEB_DIALOG_ACTION, "ftl");
        this.zzfyw.zzrm().put("ftl", String.valueOf(i));
        this.zzfyx.zzn(this.zzfyw.zzrm());
    }

    public final void onAdLoaded() {
        this.zzfyw.zzrm().put(NativeProtocol.WEB_DIALOG_ACTION, "loaded");
        this.zzfyx.zzn(this.zzfyw.zzrm());
    }

    public final void zzb(zzdha zzdha) {
        this.zzfyw.zzc(zzdha);
    }

    public final void zzd(zzarj zzarj) {
        this.zzfyw.zzj(zzarj.zzdpe);
    }
}
