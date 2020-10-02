package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

final class zzce extends zzl {
    private final BaseImplementation.ResultHolder<DrivePreferencesApi.FileUploadPreferencesResult> zzdx;
    private final /* synthetic */ zzcb zzfk;

    private zzce(zzcb zzcb, BaseImplementation.ResultHolder<DrivePreferencesApi.FileUploadPreferencesResult> resultHolder) {
        this.zzfk = zzcb;
        this.zzdx = resultHolder;
    }

    public final void zza(zzfj zzfj) throws RemoteException {
        this.zzdx.setResult(new zzcf(this.zzfk, Status.RESULT_SUCCESS, zzfj.zzhw, (zzcc) null));
    }

    /* synthetic */ zzce(zzcb zzcb, BaseImplementation.ResultHolder resultHolder, zzcc zzcc) {
        this(zzcb, resultHolder);
    }

    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzcf(this.zzfk, status, (FileUploadPreferences) null, (zzcc) null));
    }
}
