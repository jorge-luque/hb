package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzax extends zzav {
    private final /* synthetic */ zzj zzek;
    private final /* synthetic */ zzee zzel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzax(zzaw zzaw, GoogleApiClient googleApiClient, zzj zzj, zzee zzee) {
        super(googleApiClient);
        this.zzek = zzj;
        this.zzel = zzee;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(this.zzek, (zzes) this.zzel, (String) null, (zzeq) new zzgy(this));
    }
}
