package com.google.android.gms.games.stats;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.util.VisibleForTesting;

@Deprecated
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface Stats {

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface LoadPlayerStatsResult extends Releasable, Result {
        PlayerStats getPlayerStats();
    }

    PendingResult<LoadPlayerStatsResult> loadPlayerStats(GoogleApiClient googleApiClient, boolean z);
}
