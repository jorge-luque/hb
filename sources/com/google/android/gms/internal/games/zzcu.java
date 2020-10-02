package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.stats.Stats;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcu extends zzct {
    private final /* synthetic */ boolean zzkb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcu(zzcr zzcr, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, (zzcu) null);
        this.zzkb = z;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zze((BaseImplementation.ResultHolder<Stats.LoadPlayerStatsResult>) this, this.zzkb);
    }
}
