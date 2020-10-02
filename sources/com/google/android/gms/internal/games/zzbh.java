package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbh implements Leaderboards.LeaderboardMetadataResult {
    private final /* synthetic */ Status zzba;

    zzbh(zzbi zzbi, Status status) {
        this.zzba = status;
    }

    public final LeaderboardBuffer getLeaderboards() {
        return new LeaderboardBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
