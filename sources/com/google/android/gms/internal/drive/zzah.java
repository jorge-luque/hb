package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveFile;

final class zzah extends zzam {
    private final /* synthetic */ int zzdv = DriveFile.MODE_WRITE_ONLY;

    zzah(zzaf zzaf, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzr(this.zzdv), (zzeq) new zzak(this));
    }
}
