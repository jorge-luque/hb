package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcx extends zzdo {
    private final /* synthetic */ String zzfa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcx(zzcv zzcv, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, (zzcy) null);
        this.zzfa = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zzg(this, this.zzfa);
    }
}
