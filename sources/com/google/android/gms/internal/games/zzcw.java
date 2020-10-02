package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcw implements Stats.LoadPlayerStatsResult {
    private final /* synthetic */ Status zzba;

    zzcw(zzct zzct, Status status) {
        this.zzba = status;
    }

    public final PlayerStats getPlayerStats() {
        return null;
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
