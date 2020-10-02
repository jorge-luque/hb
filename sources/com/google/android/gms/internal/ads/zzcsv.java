package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzcsv implements zze {
    private final /* synthetic */ zzbwu zzgip;

    zzcsv(zzcsq zzcsq, zzbwu zzbwu) {
        this.zzgip = zzbwu;
    }

    public final void zzh(View view) {
    }

    public final void zzjy() {
        this.zzgip.zzaej().onAdClicked();
    }

    public final void zzjz() {
        this.zzgip.zzaek().onAdImpression();
        this.zzgip.zzael().zzajr();
    }
}
