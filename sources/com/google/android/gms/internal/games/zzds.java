package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzds extends Games.zzb<TurnBasedMultiplayer.UpdateMatchResult> {
    private zzds(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzdr(this, status);
    }

    /* synthetic */ zzds(GoogleApiClient googleApiClient, zzcy zzcy) {
        this(googleApiClient);
    }
}
