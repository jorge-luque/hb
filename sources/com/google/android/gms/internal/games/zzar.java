package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class zzar<TResult> extends TaskApiCall<zzg, TResult> {
    /* access modifiers changed from: protected */
    public /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            zza((zzg) anyClient, taskCompletionSource);
        } catch (RemoteException | SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzg zzg, TaskCompletionSource<TResult> taskCompletionSource) throws RemoteException;
}
