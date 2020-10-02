package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzce implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LoadMatchesResult, LoadMatchesResponse> {
    zzce() {
    }

    public final /* synthetic */ Object convert(Result result) {
        TurnBasedMultiplayer.LoadMatchesResult loadMatchesResult = (TurnBasedMultiplayer.LoadMatchesResult) result;
        if (loadMatchesResult == null) {
            return null;
        }
        return loadMatchesResult.getMatches();
    }
}
