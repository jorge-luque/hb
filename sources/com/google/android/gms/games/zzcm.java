package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcm implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.UpdateMatchResult, TurnBasedMatch> {
    zzcm() {
    }

    public final /* synthetic */ Object convert(Result result) {
        TurnBasedMatch match;
        TurnBasedMultiplayer.UpdateMatchResult updateMatchResult = (TurnBasedMultiplayer.UpdateMatchResult) result;
        if (updateMatchResult == null || (match = updateMatchResult.getMatch()) == null) {
            return null;
        }
        return (TurnBasedMatch) match.freeze();
    }
}
