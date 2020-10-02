package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzap extends Games.zzb<GamesMetadata.LoadGamesResult> {
    private zzap(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzas(this, status);
    }

    /* synthetic */ zzap(GoogleApiClient googleApiClient, zzaq zzaq) {
        this(googleApiClient);
    }
}
