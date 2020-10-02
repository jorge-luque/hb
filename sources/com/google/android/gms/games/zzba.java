package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzba extends zzar<Intent> {
    private final /* synthetic */ Room zzdk;
    private final /* synthetic */ int zzdl;

    zzba(RealTimeMultiplayerClient realTimeMultiplayerClient, Room room, int i) {
        this.zzdk = room;
        this.zzdl = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzg.zza(this.zzdk, this.zzdl));
    }
}
