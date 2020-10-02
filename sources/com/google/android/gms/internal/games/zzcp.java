package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzcp extends Games.zzb<Snapshots.OpenSnapshotResult> {
    private zzcp(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzcs(this, status);
    }

    /* synthetic */ zzcp(GoogleApiClient googleApiClient, zzcg zzcg) {
        this(googleApiClient);
    }
}
