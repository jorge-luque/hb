package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveFile;

final class zzbj extends zzam {
    private final /* synthetic */ zzbi zzev;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbj(zzbi zzbi, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzev = zzbi;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgj(this.zzev.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzev.zzes.getRequestId()), (zzeq) new zzgl(this, (DriveFile.DownloadProgressListener) null));
    }
}
