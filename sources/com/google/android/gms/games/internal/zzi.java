package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzi extends zzg.zzan<Status> {
    zzi(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void onSignOutComplete() {
        setResult(GamesStatusCodes.zza(0));
    }
}
