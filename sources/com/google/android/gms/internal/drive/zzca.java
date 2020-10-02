package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder;

abstract class zzca extends zzau<DriveFolder.DriveFolderResult> {
    zzca(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzbz(status, (DriveFolder) null);
    }
}
