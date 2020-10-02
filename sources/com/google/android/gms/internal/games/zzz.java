package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzz implements Achievements.LoadAchievementsResult {
    private final /* synthetic */ Status zzba;

    zzz(zzaa zzaa, Status status) {
        this.zzba = status;
    }

    public final AchievementBuffer getAchievements() {
        return new AchievementBuffer(DataHolder.empty(14));
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final void release() {
    }
}
