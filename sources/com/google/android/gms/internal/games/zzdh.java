package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdh implements TurnBasedMultiplayer.CancelMatchResult {
    private final /* synthetic */ Status zzba;
    private final /* synthetic */ zzdi zzlc;

    zzdh(zzdi zzdi, Status status) {
        this.zzlc = zzdi;
        this.zzba = status;
    }

    public final String getMatchId() {
        return this.zzlc.zzft;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
