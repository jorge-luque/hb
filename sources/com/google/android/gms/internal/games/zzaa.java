package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzaa extends Games.zzb<Achievements.LoadAchievementsResult> {
    private zzaa(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzz(this, status);
    }

    /* synthetic */ zzaa(GoogleApiClient googleApiClient, zzp zzp) {
        this(googleApiClient);
    }
}
