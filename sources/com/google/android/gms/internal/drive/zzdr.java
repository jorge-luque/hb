package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdr extends zzar {
    private final /* synthetic */ zzdp zzgq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdr(zzdp zzdp, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzgq = zzdp;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzex(this.zzgq.zzk), (zzeq) new zzdx(this));
    }
}
