package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.OpenFileCallback;

final /* synthetic */ class zzdm implements zzdg {
    private final zzfl zzgn;

    zzdm(zzfl zzfl) {
        this.zzgn = zzfl;
    }

    public final void accept(Object obj) {
        zzfl zzfl = this.zzgn;
        ((OpenFileCallback) obj).onProgress(zzfl.zzhy, zzfl.zzhz);
    }
}
