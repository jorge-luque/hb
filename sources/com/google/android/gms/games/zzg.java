package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.Games;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzg extends Games.zzc {
    private final /* synthetic */ String zzam;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzg(GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, (zze) null);
        this.zzam = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((com.google.android.gms.games.internal.zzg) anyClient).zza(this.zzam, (BaseImplementation.ResultHolder<Games.GetServerAuthCodeResult>) this);
    }
}
