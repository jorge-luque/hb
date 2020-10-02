package com.google.android.gms.games;

import com.google.android.gms.games.internal.zzbj;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzaj implements zzbj<Leaderboards.LeaderboardMetadataResult> {
    zzaj() {
    }

    public final /* synthetic */ void zza(Object obj) {
        Leaderboards.LeaderboardMetadataResult leaderboardMetadataResult = (Leaderboards.LeaderboardMetadataResult) obj;
        if (leaderboardMetadataResult.getLeaderboards() != null) {
            leaderboardMetadataResult.getLeaderboards().release();
        }
    }
}
