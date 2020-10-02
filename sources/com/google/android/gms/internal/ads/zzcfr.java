package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcfr implements zzbrs {
    private final zzbek zzdce;

    zzcfr(zzbek zzbek) {
        this.zzdce = !((Boolean) zzvj.zzpv().zzd(zzzz.zzcli)).booleanValue() ? null : zzbek;
    }

    public final void zzbx(Context context) {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            zzbek.onPause();
        }
    }

    public final void zzby(Context context) {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            zzbek.onResume();
        }
    }

    public final void zzbz(Context context) {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            zzbek.destroy();
        }
    }
}
