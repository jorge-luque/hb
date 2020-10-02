package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbw extends zzcc {
    private final /* synthetic */ boolean zzkb;
    private final /* synthetic */ String zzkm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbw(zzbu zzbu, GoogleApiClient googleApiClient, String str, boolean z) {
        super(googleApiClient);
        this.zzkm = str;
        this.zzkb = z;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<Players.LoadPlayersResult>) this, this.zzkm, this.zzkb);
    }
}
