package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzaz extends zzbi {
    private final /* synthetic */ boolean zzkb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaz(zzba zzba, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, (zzaz) null);
        this.zzkb = z;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zzb((BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult>) this, this.zzkb);
    }
}
