package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Players;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzax implements PendingResultUtil.ResultConverter<Players.LoadPlayersResult, PlayerBuffer> {
    zzax() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Players.LoadPlayersResult loadPlayersResult = (Players.LoadPlayersResult) result;
        if (loadPlayersResult == null) {
            return null;
        }
        return loadPlayersResult.getPlayers();
    }
}
