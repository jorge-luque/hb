package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdd extends zzdm {
    private final /* synthetic */ String zzfa;
    private final /* synthetic */ String zzkz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdd(zzcv zzcv, GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient, (zzcy) null);
        this.zzfa = str;
        this.zzkz = str2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult>) this, this.zzfa, this.zzkz);
    }
}
