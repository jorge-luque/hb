package com.google.android.gms.internal.games;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdp implements TurnBasedMultiplayer.LoadMatchesResult {
    private final /* synthetic */ Status zzba;

    zzdp(zzdq zzdq, Status status) {
        this.zzba = status;
    }

    public final LoadMatchesResponse getMatches() {
        return new LoadMatchesResponse(new Bundle());
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
