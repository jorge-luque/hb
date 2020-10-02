package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.multiplayer.realtime.zzg;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbk extends com.google.android.gms.games.internal.zzbk<zzg> {
    zzbk(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* access modifiers changed from: protected */
    public final void zzb(com.google.android.gms.games.internal.zzg zzg, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        taskCompletionSource.setResult(true);
    }
}
