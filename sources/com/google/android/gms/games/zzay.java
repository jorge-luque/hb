package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Players;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzay implements PendingResultUtil.ResultConverter<Players.LoadPlayersResult, Player> {
    zzay() {
    }

    private static Player zza(Players.LoadPlayersResult loadPlayersResult) {
        if (loadPlayersResult == null) {
            return null;
        }
        PlayerBuffer players = loadPlayersResult.getPlayers();
        if (players != null) {
            try {
                if (players.getCount() > 0) {
                    return (Player) ((Player) players.get(0)).freeze();
                }
            } finally {
                if (players != null) {
                    players.release();
                }
            }
        }
        if (players != null) {
            players.release();
        }
        return null;
    }

    public final /* synthetic */ Object convert(Result result) {
        return zza((Players.LoadPlayersResult) result);
    }
}
