package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.C3093Events;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzaj extends Games.zzb<C3093Events.LoadEventsResult> {
    private zzaj(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzam(this, status);
    }

    /* synthetic */ zzaj(GoogleApiClient googleApiClient, zzai zzai) {
        this(googleApiClient);
    }
}
