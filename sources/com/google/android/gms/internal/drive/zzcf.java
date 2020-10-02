package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

final class zzcf implements DrivePreferencesApi.FileUploadPreferencesResult {
    private final Status zzdy;
    private final FileUploadPreferences zzfm;

    private zzcf(zzcb zzcb, Status status, FileUploadPreferences fileUploadPreferences) {
        this.zzdy = status;
        this.zzfm = fileUploadPreferences;
    }

    public final FileUploadPreferences getFileUploadPreferences() {
        return this.zzfm;
    }

    public final Status getStatus() {
        return this.zzdy;
    }

    /* synthetic */ zzcf(zzcb zzcb, Status status, FileUploadPreferences fileUploadPreferences, zzcc zzcc) {
        this(zzcb, status, fileUploadPreferences);
    }
}
