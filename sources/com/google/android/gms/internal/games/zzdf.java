package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdf extends zzdq {
    private final /* synthetic */ int zzla;
    private final /* synthetic */ int[] zzlb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdf(zzcv zzcv, GoogleApiClient googleApiClient, int i, int[] iArr) {
        super(googleApiClient, (zzcy) null);
        this.zzla = i;
        this.zzlb = iArr;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchesResult>) this, this.zzla, this.zzlb);
    }
}
