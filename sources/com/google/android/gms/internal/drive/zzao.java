package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;

final class zzao implements DriveApi.DriveIdResult {
    private final Status zzdy;
    private final DriveId zzk;

    public zzao(Status status, DriveId driveId) {
        this.zzdy = status;
        this.zzk = driveId;
    }

    public final DriveId getDriveId() {
        return this.zzk;
    }

    public final Status getStatus() {
        return this.zzdy;
    }
}
