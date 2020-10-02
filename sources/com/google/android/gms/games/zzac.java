package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzac implements PendingResultUtil.ResultConverter<Leaderboards.LoadScoresResult, LeaderboardsClient.LeaderboardScores> {
    zzac() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Leaderboards.LoadScoresResult loadScoresResult = (Leaderboards.LoadScoresResult) result;
        Leaderboard leaderboard = null;
        if (loadScoresResult == null) {
            return null;
        }
        if (loadScoresResult.getLeaderboard() != null) {
            leaderboard = (Leaderboard) loadScoresResult.getLeaderboard().freeze();
        }
        return new LeaderboardsClient.LeaderboardScores(leaderboard, loadScoresResult.getScores());
    }
}
