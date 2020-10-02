package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbl;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzco extends zzbl<OnTurnBasedMatchUpdateReceivedListener> {
    private final /* synthetic */ ListenerHolder zzbg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzco(TurnBasedMultiplayerClient turnBasedMultiplayerClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.zzbg = listenerHolder2;
    }

    /* access modifiers changed from: protected */
    public final void zzc(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        zzg.zzc((ListenerHolder<OnTurnBasedMatchUpdateReceivedListener>) this.zzbg);
        taskCompletionSource.setResult(null);
    }
}
