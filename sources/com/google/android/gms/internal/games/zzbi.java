package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzbi extends Games.zzb<Leaderboards.LeaderboardMetadataResult> {
    private zzbi(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzbh(this, status);
    }

    /* synthetic */ zzbi(GoogleApiClient googleApiClient, zzaz zzaz) {
        this(googleApiClient);
    }
}
