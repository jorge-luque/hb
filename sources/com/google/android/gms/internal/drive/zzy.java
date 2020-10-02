package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "CreateFolderRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();
    @SafeParcelable.Field(mo15196id = 3)
    private final MetadataBundle zzdn;
    @SafeParcelable.Field(mo15196id = 2)
    private final DriveId zzdp;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzy(@SafeParcelable.Param(mo15199id = 2) DriveId driveId, @SafeParcelable.Param(mo15199id = 3) MetadataBundle metadataBundle) {
        this.zzdp = (DriveId) Preconditions.checkNotNull(driveId);
        this.zzdn = (MetadataBundle) Preconditions.checkNotNull(metadataBundle);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdp, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdn, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
