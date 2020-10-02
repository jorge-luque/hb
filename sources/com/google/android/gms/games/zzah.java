package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzah implements PendingResultUtil.ResultConverter<Leaderboards.LeaderboardMetadataResult, Leaderboard> {
    zzah() {
    }

    private static Leaderboard zza(Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult) {
        if (leaderboardMetadataResult == null) {
            return null;
        }
        LeaderboardBuffer leaderboards = leaderboardMetadataResult.getLeaderboards();
        if (leaderboards != null) {
            try {
                if (leaderboards.getCount() > 0) {
                    return (Leaderboard) ((Leaderboard) leaderboards.get(0)).freeze();
                }
            } finally {
                if (leaderboards != null) {
                    leaderboards.release();
                }
            }
        }
        if (leaderboards != null) {
            leaderboards.release();
        }
        return null;
    }

    public final /* synthetic */ Object convert(Result result) {
        return zza((Leaderboards.LeaderboardMetadataResult) result);
    }
}
