package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzczc implements zzdak<zzcyz> {
    private final Bundle zzfmv;
    private final zzdrh zzfur;

    public zzczc(zzdrh zzdrh, Bundle bundle) {
        this.zzfur = zzdrh;
        this.zzfmv = bundle;
    }

    public final zzdri<zzcyz> zzaqa() {
        return this.zzfur.zzd(new zzczb(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcyz zzaqk() throws Exception {
        return new zzcyz(this.zzfmv);
    }
}
