package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzm<TResult> implements zzq<TResult> {
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final Executor zzd;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public OnSuccessListener<? super TResult> zzp;

    public zzm(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzd = executor;
        this.zzp = onSuccessListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzp = null;
        }
    }

    public final void onComplete(Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.mLock) {
                if (this.zzp != null) {
                    this.zzd.execute(new zzn(this, task));
                }
            }
        }
    }
}
