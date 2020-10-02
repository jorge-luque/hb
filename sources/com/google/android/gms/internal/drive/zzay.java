package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzay extends zzav {
    private final /* synthetic */ zzee zzel;
    private final /* synthetic */ zzgs zzem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzay(zzaw zzaw, GoogleApiClient googleApiClient, zzgs zzgs, zzee zzee) {
        super(googleApiClient);
        this.zzem = zzgs;
        this.zzel = zzee;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(this.zzem, (zzes) this.zzel, (String) null, (zzeq) new zzgy(this));
    }
}
