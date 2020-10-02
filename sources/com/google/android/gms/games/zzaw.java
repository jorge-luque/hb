package com.google.android.gms.games;

import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.zzbj;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzaw implements zzbj<Players.LoadPlayersResult> {
    zzaw() {
    }

    public final /* synthetic */ void zza(Object obj) {
        Players.LoadPlayersResult loadPlayersResult = (Players.LoadPlayersResult) obj;
        if (loadPlayersResult.getPlayers() != null) {
            loadPlayersResult.getPlayers().release();
        }
    }
}
