package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzal extends Games.zzb<Result> {
    private zzal(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public Result createFailedResult(Status status) {
        return new zzao(this, status);
    }

    /* synthetic */ zzal(GoogleApiClient googleApiClient, zzai zzai) {
        this(googleApiClient);
    }
}
