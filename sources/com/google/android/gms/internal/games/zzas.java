package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GamesMetadata;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzas implements GamesMetadata.LoadGamesResult {
    private final /* synthetic */ Status zzba;

    zzas(zzap zzap, Status status) {
        this.zzba = status;
    }

    public final GameBuffer getGames() {
        return new GameBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
