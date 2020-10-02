package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcf implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.CancelMatchResult, String> {
    zzcf() {
    }

    public final /* synthetic */ Object convert(Result result) {
        TurnBasedMultiplayer.CancelMatchResult cancelMatchResult = (TurnBasedMultiplayer.CancelMatchResult) result;
        if (cancelMatchResult == null) {
            return null;
        }
        return cancelMatchResult.getMatchId();
    }
}
