package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdg extends zzdi {
    private final /* synthetic */ String zzfa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdg(zzcv zzcv, String str, GoogleApiClient googleApiClient, String str2) {
        super(str, googleApiClient);
        this.zzfa = str2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zzf((BaseImplementation.ResultHolder<TurnBasedMultiplayer.CancelMatchResult>) this, this.zzfa);
    }
}
