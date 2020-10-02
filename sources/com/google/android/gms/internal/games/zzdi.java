package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzdi extends Games.zzb<TurnBasedMultiplayer.CancelMatchResult> {
    /* access modifiers changed from: private */
    public final String zzft;

    public zzdi(String str, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzft = str;
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzdh(this, status);
    }
}
