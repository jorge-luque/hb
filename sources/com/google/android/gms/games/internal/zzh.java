package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzh extends zzg.zzan<TurnBasedMultiplayer.CancelMatchResult> {
    zzh(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzc(int i, String str) {
        setResult(new zzg.zzf(GamesStatusCodes.zza(i), str));
    }
}
