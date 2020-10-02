package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcxb implements zzdak<zzdah<Bundle>> {
    private final zzdee zzgmq;

    zzcxb(zzdee zzdee) {
        this.zzgmq = zzdee;
    }

    public final zzdri<zzdah<Bundle>> zzaqa() {
        zzdee zzdee = this.zzgmq;
        return zzdqw.zzag((zzdee == null || zzdee.zzarn() == null || this.zzgmq.zzarn().isEmpty()) ? null : new zzcxe(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(Bundle bundle) {
        bundle.putString("key_schema", this.zzgmq.zzarn());
    }
}
