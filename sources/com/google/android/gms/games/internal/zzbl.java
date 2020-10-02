package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class zzbl<L> extends RegisterListenerMethod<zzg, L> {
    protected zzbl(ListenerHolder<L> listenerHolder) {
        super(listenerHolder);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void registerListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            zzc((zzg) anyClient, taskCompletionSource);
        } catch (SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzc(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;
}
