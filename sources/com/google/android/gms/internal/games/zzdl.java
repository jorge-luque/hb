package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdl implements TurnBasedMultiplayer.LeaveMatchResult {
    private final /* synthetic */ Status zzba;

    zzdl(zzdm zzdm, Status status) {
        this.zzba = status;
    }

    public final TurnBasedMatch getMatch() {
        return null;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
