package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzak extends zzal {
    private final /* synthetic */ String zzf;
    private final /* synthetic */ int zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzak(zzaf zzaf, GoogleApiClient googleApiClient, String str, int i) {
        super(googleApiClient, (zzai) null);
        this.zzf = str;
        this.zzg = i;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza(this.zzf, this.zzg);
    }
}
