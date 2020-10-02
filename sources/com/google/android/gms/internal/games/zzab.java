package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzab implements Achievements.UpdateAchievementResult {
    private final /* synthetic */ Status zzba;
    private final /* synthetic */ zzac zzkd;

    zzab(zzac zzac, Status status) {
        this.zzkd = zzac;
        this.zzba = status;
    }

    public final String getAchievementId() {
        return this.zzkd.zzft;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
