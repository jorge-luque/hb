package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbm extends zzav {
    private final /* synthetic */ zzbi zzev;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbm(zzbi zzbi, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzev = zzbi;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzo(this.zzev.zzes.getRequestId(), false), (zzeq) new zzgy(this));
    }
}
