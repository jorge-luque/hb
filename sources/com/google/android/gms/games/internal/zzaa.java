package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzaa extends zzg.zzan<Leaderboards.SubmitScoreResult> {
    zzaa(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzd(DataHolder dataHolder) {
        setResult(new zzg.zzau(dataHolder));
    }
}
