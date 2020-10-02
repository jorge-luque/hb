package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

abstract class zzcg extends zzau<DrivePreferencesApi.FileUploadPreferencesResult> {
    private final /* synthetic */ zzcb zzfk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcg(zzcb zzcb, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzfk = zzcb;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzcf(this.zzfk, status, (FileUploadPreferences) null, (zzcc) null);
    }
}
