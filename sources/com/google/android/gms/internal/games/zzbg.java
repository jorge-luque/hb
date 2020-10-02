package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbg extends zzbm {
    private final /* synthetic */ int zzkj;
    private final /* synthetic */ LeaderboardScoreBuffer zzkk;
    private final /* synthetic */ int zzkl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbg(zzba zzba, GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        super(googleApiClient, (zzaz) null);
        this.zzkk = leaderboardScoreBuffer;
        this.zzkj = i;
        this.zzkl = i2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult>) this, this.zzkk, this.zzkj, this.zzkl);
    }
}
