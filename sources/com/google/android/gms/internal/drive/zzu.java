package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "CreateFileIntentSenderRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();
    @SafeParcelable.Field(mo15196id = 4)
    private final String zzba;
    @SafeParcelable.Field(mo15196id = 5)
    private final DriveId zzbd;
    @SafeParcelable.Field(mo15196id = 2)
    private final MetadataBundle zzdn;
    @SafeParcelable.Field(mo15196id = 6)
    private final Integer zzdo;
    @SafeParcelable.Field(mo15196id = 3)
    private final int zzj;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzu(@SafeParcelable.Param(mo15199id = 2) MetadataBundle metadataBundle, @SafeParcelable.Param(mo15199id = 3) int i, @SafeParcelable.Param(mo15199id = 4) String str, @SafeParcelable.Param(mo15199id = 5) DriveId driveId, @SafeParcelable.Param(mo15199id = 6) Integer num) {
        this.zzdn = metadataBundle;
        this.zzj = i;
        this.zzba = str;
        this.zzbd = driveId;
        this.zzdo = num;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdn, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzj);
        SafeParcelWriter.writeString(parcel, 4, this.zzba, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzbd, i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 6, this.zzdo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
