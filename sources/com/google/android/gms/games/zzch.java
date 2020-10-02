package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzch implements PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LeaveMatchResult, Void> {
    zzch() {
    }

    public final /* bridge */ /* synthetic */ Object convert(Result result) {
        TurnBasedMultiplayer.LeaveMatchResult leaveMatchResult = (TurnBasedMultiplayer.LeaveMatchResult) result;
        return null;
    }
}
