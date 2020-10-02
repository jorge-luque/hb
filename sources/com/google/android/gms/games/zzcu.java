package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcu extends zzar<Void> {
    private final /* synthetic */ String zzfa;

    zzcu(TurnBasedMultiplayerClient turnBasedMultiplayerClient, String str) {
        this.zzfa = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzg.zzc(this.zzfa);
        taskCompletionSource.setResult(null);
    }
}
