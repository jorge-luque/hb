package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zzt;

@SafeParcelable.Class(creator = "RemoveEventListenerRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzgs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgs> CREATOR = new zzgt();
    @SafeParcelable.Field(mo15196id = 3)
    private final int zzda;
    @SafeParcelable.Field(mo15196id = 4)
    private final zzt zzdc;
    @SafeParcelable.Field(mo15196id = 2)
    private final DriveId zzk;

    @SafeParcelable.Constructor
    zzgs(@SafeParcelable.Param(mo15199id = 2) DriveId driveId, @SafeParcelable.Param(mo15199id = 3) int i, @SafeParcelable.Param(mo15199id = 4) zzt zzt) {
        this.zzk = driveId;
        this.zzda = i;
        this.zzdc = zzt;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzda);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @VisibleForTesting
    public zzgs(DriveId driveId, int i) {
        this(driveId, i, (zzt) null);
    }
}
