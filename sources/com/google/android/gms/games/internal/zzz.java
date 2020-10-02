package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzz extends zzg.zzan<Achievements.LoadAchievementsResult> {
    zzz(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zza(DataHolder dataHolder) {
        setResult(new zzg.zzw(dataHolder));
    }
}
