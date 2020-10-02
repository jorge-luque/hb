package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.stats.Stats;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzct extends Games.zzb<Stats.LoadPlayerStatsResult> {
    private zzct(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzcw(this, status);
    }

    /* synthetic */ zzct(GoogleApiClient googleApiClient, zzcu zzcu) {
        this(googleApiClient);
    }
}
