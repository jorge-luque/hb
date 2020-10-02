package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzae extends zzar<Intent> {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ int zzbp;

    zzae(LeaderboardsClient leaderboardsClient, String str, int i) {
        this.zzbo = str;
        this.zzbp = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zzg.zza(this.zzbo, this.zzbp, -1));
    }
}
