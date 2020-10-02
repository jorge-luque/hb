package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzag extends zzar<Void> {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ long zzbr;

    zzag(LeaderboardsClient leaderboardsClient, String str, long j) {
        this.zzbo = str;
        this.zzbr = j;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzg.zza((BaseImplementation.ResultHolder<Leaderboards.SubmitScoreResult>) null, this.zzbo, this.zzbr, (String) null);
    }
}
