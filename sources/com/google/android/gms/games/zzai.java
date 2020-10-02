package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzai implements PendingResultUtil.ResultConverter<Leaderboards.LeaderboardMetadataResult, LeaderboardBuffer> {
    zzai() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult = (Leaderboards.LeaderboardMetadataResult) result;
        if (leaderboardMetadataResult == null) {
            return null;
        }
        return leaderboardMetadataResult.getLeaderboards();
    }
}
