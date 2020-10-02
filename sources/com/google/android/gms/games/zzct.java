package com.google.android.gms.games;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.TurnBasedMultiplayerClient;
import com.google.android.gms.games.internal.zzbg;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzct implements zzbg<TurnBasedMatch> {
    zzct() {
    }

    public final /* synthetic */ ApiException zza(Status status, Object obj) {
        TurnBasedMatch turnBasedMatch = (TurnBasedMatch) obj;
        if (status.getStatusCode() == 26593) {
            return new TurnBasedMultiplayerClient.MatchOutOfDateApiException(status, turnBasedMatch);
        }
        return ApiExceptionUtil.fromStatus(status);
    }
}
