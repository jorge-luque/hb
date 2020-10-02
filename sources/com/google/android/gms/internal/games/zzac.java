package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
abstract class zzac extends Games.zzb<Achievements.UpdateAchievementResult> {
    /* access modifiers changed from: private */
    public final String zzft;

    public zzac(String str, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzft = str;
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzab(this, status);
    }
}
