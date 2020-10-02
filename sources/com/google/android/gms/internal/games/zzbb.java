package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbb extends zzbk {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ int zzkh;
    private final /* synthetic */ int zzki;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbb(zzba zzba, GoogleApiClient googleApiClient, String str, int i, int i2) {
        super(googleApiClient, (zzaz) null);
        this.zzbo = str;
        this.zzkh = i;
        this.zzki = i2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<Leaderboards.LoadPlayerScoreResult>) this, (String) null, this.zzbo, this.zzkh, this.zzki);
    }
}
