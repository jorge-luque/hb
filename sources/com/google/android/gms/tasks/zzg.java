package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzg<TResult> implements zzq<TResult> {
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final Executor zzd;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public OnCanceledListener zzj;

    public zzg(Executor executor, OnCanceledListener onCanceledListener) {
        this.zzd = executor;
        this.zzj = onCanceledListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzj = null;
        }
    }

    public final void onComplete(Task task) {
        if (task.isCanceled()) {
            synchronized (this.mLock) {
                if (this.zzj != null) {
                    this.zzd.execute(new zzh(this));
                }
            }
        }
    }
}
