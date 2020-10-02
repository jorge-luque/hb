package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzaf extends zzar<Void> {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ long zzbr;
    private final /* synthetic */ String zzbs;

    zzaf(LeaderboardsClient leaderboardsClient, String str, long j, String str2) {
        this.zzbo = str;
        this.zzbr = j;
        this.zzbs = str2;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzg.zza((BaseImplementation.ResultHolder<Leaderboards.SubmitScoreResult>) null, this.zzbo, this.zzbr, this.zzbs);
    }
}
