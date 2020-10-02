package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzac extends zzg.zzan<GamesMetadata.LoadGamesResult> {
    zzac(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzg(DataHolder dataHolder) {
        setResult(new zzg.zzy(dataHolder));
    }
}
