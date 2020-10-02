package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzy extends zzg.zzan<Games.GetServerAuthCodeResult> {
    zzy(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zza(int i, String str) {
        setResult(new zzg.zzm(GamesStatusCodes.zza(i), str));
    }
}
