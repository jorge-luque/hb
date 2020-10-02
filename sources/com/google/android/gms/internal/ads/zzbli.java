package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbli {
    private final zzdha zzepv;
    private final zzchz zzfiq;

    public zzbli(zzchz zzchz, zzdha zzdha) {
        this.zzfiq = zzchz;
        this.zzepv = zzdha;
    }

    public final void zzfd(long j) {
        this.zzfiq.zzaoa().zza(this.zzepv.zzgus.zzgup).zzq(NativeProtocol.WEB_DIALOG_ACTION, "ad_closed").zzq("show_time", String.valueOf(j)).zzq("ad_format", "appopen").zzany();
    }
}
