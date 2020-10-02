package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;

@SafeParcelable.Class(creator = "OpenContentsRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzgj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgj> CREATOR = new zzgk();
    @SafeParcelable.Field(mo15196id = 3)
    private final int mode;
    @SafeParcelable.Field(mo15196id = 2)
    private final DriveId zzdd;
    @SafeParcelable.Field(mo15196id = 4)
    private final int zzip;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzgj(@SafeParcelable.Param(mo15199id = 2) DriveId driveId, @SafeParcelable.Param(mo15199id = 3) int i, @SafeParcelable.Param(mo15199id = 4) int i2) {
        this.zzdd = driveId;
        this.mode = i;
        this.zzip = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.mode);
        SafeParcelWriter.writeInt(parcel, 4, this.zzip);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
