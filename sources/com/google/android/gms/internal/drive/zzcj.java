package com.google.android.gms.internal.drive;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzcj implements Continuation {
    private final zzg zzfp;

    zzcj(zzg zzg) {
        this.zzfp = zzg;
    }

    public final Object then(Task task) {
        return zzch.zza(this.zzfp, task);
    }
}
