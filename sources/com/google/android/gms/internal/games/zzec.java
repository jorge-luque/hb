package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzec extends Games.zzb<Videos.CaptureStateResult> {
    private zzec(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzeb(this, status);
    }

    /* synthetic */ zzec(GoogleApiClient googleApiClient, zzdt zzdt) {
        this(googleApiClient);
    }
}
