package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class zzbk<L> extends UnregisterListenerMethod<zzg, L> {
    protected zzbk(ListenerHolder.ListenerKey<L> listenerKey) {
        super(listenerKey);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void unregisterListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            zzb((zzg) anyClient, taskCompletionSource);
        } catch (SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzb(zzg zzg, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;
}
