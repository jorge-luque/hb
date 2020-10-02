package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcg implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LoadMatchResult, TurnBasedMatch> {
    zzcg() {
    }

    public final /* synthetic */ Object convert(Result result) {
        TurnBasedMatch match;
        TurnBasedMultiplayer.LoadMatchResult loadMatchResult = (TurnBasedMultiplayer.LoadMatchResult) result;
        if (loadMatchResult == null || (match = loadMatchResult.getMatch()) == null) {
            return null;
        }
        return (TurnBasedMatch) match.freeze();
    }
}
