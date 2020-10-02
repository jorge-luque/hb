package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbj implements Leaderboards.LoadPlayerScoreResult {
    private final /* synthetic */ Status zzba;

    zzbj(zzbk zzbk, Status status) {
        this.zzba = status;
    }

    public final LeaderboardScore getScore() {
        return null;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
