package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbl implements Leaderboards.LoadScoresResult {
    private final /* synthetic */ Status zzba;

    zzbl(zzbm zzbm, Status status) {
        this.zzba = status;
    }

    public final Leaderboard getLeaderboard() {
        return null;
    }

    public final LeaderboardScoreBuffer getScores() {
        return new LeaderboardScoreBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
