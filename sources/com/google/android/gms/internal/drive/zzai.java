package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

final class zzai extends zzap {
    private final /* synthetic */ String zzdw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzai(zzaf zzaf, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzdw = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzek(DriveId.zza(this.zzdw), false), (zzeq) new zzan(this));
    }
}
