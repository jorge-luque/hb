package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcks extends zzarg {
    private final /* synthetic */ zzckt zzgbq;

    protected zzcks(zzckt zzckt) {
        this.zzgbq = zzckt;
    }

    public final void zza(zzaye zzaye) {
        this.zzgbq.zzdej.setException(new zzayd(zzaye.zzdxf, zzaye.errorCode));
    }

    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzgbq.zzdej.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
