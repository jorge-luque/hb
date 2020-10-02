package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbk;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcn extends zzbk<OnTurnBasedMatchUpdateReceivedListener> {
    zzcn(TurnBasedMultiplayerClient turnBasedMultiplayerClient, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzg zzg, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        zzg.zzbp();
        taskCompletionSource.setResult(true);
    }
}
