package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcq extends zzar<Intent> {
    private final /* synthetic */ int zzdq;
    private final /* synthetic */ int zzdr;
    private final /* synthetic */ boolean zzds;

    zzcq(TurnBasedMultiplayerClient turnBasedMultiplayerClient, int i, int i2, boolean z) {
        this.zzdq = i;
        this.zzdr = i2;
        this.zzds = z;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzg.zza(this.zzdq, this.zzdr, this.zzds));
    }
}
