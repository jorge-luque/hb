package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.leaderboard.Leaderboards;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbf extends zzbo {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ long zzbr;
    private final /* synthetic */ String zzbs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbf(zzba zzba, GoogleApiClient googleApiClient, String str, long j, String str2) {
        super(googleApiClient);
        this.zzbo = str;
        this.zzbr = j;
        this.zzbs = str2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<Leaderboards.SubmitScoreResult>) this, this.zzbo, this.zzbr, this.zzbs);
    }
}
