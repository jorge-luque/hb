package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.events.OpenFileCallback;

final /* synthetic */ class zzdl implements zzdg {
    private final zzdk zzgl;
    private final Status zzgm;

    zzdl(zzdk zzdk, Status status) {
        this.zzgl = zzdk;
        this.zzgm = status;
    }

    public final void accept(Object obj) {
        this.zzgl.zza(this.zzgm, (OpenFileCallback) obj);
    }
}
