package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;

final class zzdz implements DriveResource.MetadataResult {
    private final Status zzdy;
    private final Metadata zzgr;

    public zzdz(Status status, Metadata metadata) {
        this.zzdy = status;
        this.zzgr = metadata;
    }

    public final Metadata getMetadata() {
        return this.zzgr;
    }

    public final Status getStatus() {
        return this.zzdy;
    }
}
