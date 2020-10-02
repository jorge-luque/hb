package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzx implements PendingResultUtil.ResultConverter<Leaderboards.LoadPlayerScoreResult, LeaderboardScore> {
    zzx() {
    }

    public final /* synthetic */ Object convert(Result result) {
        LeaderboardScore score;
        Leaderboards.LoadPlayerScoreResult loadPlayerScoreResult = (Leaderboards.LoadPlayerScoreResult) result;
        if (loadPlayerScoreResult == null || (score = loadPlayerScoreResult.getScore()) == null) {
            return null;
        }
        return (LeaderboardScore) score.freeze();
    }
}
