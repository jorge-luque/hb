package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.stats.Stats;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzj extends zzg.zzan<Stats.LoadPlayerStatsResult> {
    zzj(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzao(DataHolder dataHolder) {
        setResult(new zzg.zzaf(dataHolder));
    }
}
