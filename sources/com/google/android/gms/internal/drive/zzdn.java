package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.OpenFileCallback;

final /* synthetic */ class zzdn implements zzdg {
    private final zzdk zzgl;
    private final zzfh zzgo;

    zzdn(zzdk zzdk, zzfh zzfh) {
        this.zzgl = zzdk;
        this.zzgo = zzfh;
    }

    public final void accept(Object obj) {
        this.zzgl.zza(this.zzgo, (OpenFileCallback) obj);
    }
}
