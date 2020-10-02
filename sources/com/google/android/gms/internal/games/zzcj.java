package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzcj extends Games.zzb<Snapshots.CommitSnapshotResult> {
    private zzcj(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzcm(this, status);
    }

    /* synthetic */ zzcj(GoogleApiClient googleApiClient, zzcg zzcg) {
        this(googleApiClient);
    }
}
