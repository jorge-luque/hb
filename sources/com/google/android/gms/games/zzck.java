package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzck implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LeaveMatchResult, TurnBasedMatch> {
    zzck() {
    }

    public final /* synthetic */ Object convert(Result result) {
        TurnBasedMatch match;
        TurnBasedMultiplayer.LeaveMatchResult leaveMatchResult = (TurnBasedMultiplayer.LeaveMatchResult) result;
        if (leaveMatchResult == null || (match = leaveMatchResult.getMatch()) == null) {
            return null;
        }
        return (TurnBasedMatch) match.freeze();
    }
}
