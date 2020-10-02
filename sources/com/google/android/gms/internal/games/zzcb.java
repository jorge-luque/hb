package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcb implements Players.LoadPlayersResult {
    private final /* synthetic */ Status zzba;

    zzcb(zzcc zzcc, Status status) {
        this.zzba = status;
    }

    public final PlayerBuffer getPlayers() {
        return new PlayerBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
