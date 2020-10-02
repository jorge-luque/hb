package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbl;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.zzg;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbj extends zzbl<zzg> {
    private final /* synthetic */ ListenerHolder zzbg;
    private final /* synthetic */ RoomConfig zzdp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbj(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2, RoomConfig roomConfig) {
        super(listenerHolder);
        this.zzbg = listenerHolder2;
        this.zzdp = roomConfig;
    }

    /* access modifiers changed from: protected */
    public final void zzc(com.google.android.gms.games.internal.zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        ListenerHolder listenerHolder = this.zzbg;
        zzg.zzc(listenerHolder, listenerHolder, listenerHolder, this.zzdp);
        taskCompletionSource.setResult(null);
    }
}
