package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzcc extends zzcg {
    private final /* synthetic */ zzcb zzfk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcc(zzcb zzcb, GoogleApiClient googleApiClient) {
        super(zzcb, googleApiClient);
        this.zzfk = zzcb;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zzb(new zzce(this.zzfk, this, (zzcc) null));
    }
}
