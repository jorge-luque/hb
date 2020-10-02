package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

final class zzds extends zzav {
    private final /* synthetic */ List zzgb;
    private final /* synthetic */ zzdp zzgq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzds(zzdp zzdp, GoogleApiClient googleApiClient, List list) {
        super(googleApiClient);
        this.zzgq = zzdp;
        this.zzgb = list;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgw(this.zzgq.zzk, this.zzgb), (zzeq) new zzgy(this));
    }
}
