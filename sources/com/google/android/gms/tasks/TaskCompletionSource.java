package com.google.android.gms.tasks;

public class TaskCompletionSource<TResult> {
    /* access modifiers changed from: private */
    public final zzu<TResult> zza = new zzu<>();

    public TaskCompletionSource() {
    }

    public Task<TResult> getTask() {
        return this.zza;
    }

    public void setException(Exception exc) {
        this.zza.setException(exc);
    }

    public void setResult(TResult tresult) {
        this.zza.setResult(tresult);
    }

    public boolean trySetException(Exception exc) {
        return this.zza.trySetException(exc);
    }

    public boolean trySetResult(TResult tresult) {
        return this.zza.trySetResult(tresult);
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new zzs(this));
    }
}
