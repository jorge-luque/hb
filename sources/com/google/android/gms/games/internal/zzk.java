package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzk extends zzg.zzan<TurnBasedMultiplayer.LoadMatchResult> {
    zzk(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzn(DataHolder dataHolder) {
        setResult(new zzg.zzaa(dataHolder));
    }
}
