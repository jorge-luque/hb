package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "UpdateMetadataRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzhf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhf> CREATOR = new zzhg();
    @SafeParcelable.Field(mo15196id = 2)
    private final DriveId zzdd;
    @SafeParcelable.Field(mo15196id = 3)
    private final MetadataBundle zzde;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzhf(@SafeParcelable.Param(mo15199id = 2) DriveId driveId, @SafeParcelable.Param(mo15199id = 3) MetadataBundle metadataBundle) {
        this.zzdd = driveId;
        this.zzde = metadataBundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzde, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
