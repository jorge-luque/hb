package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzk extends zzar<String> {
    zzk(GamesClient gamesClient) {
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<String> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzg.zzbx());
    }
}
