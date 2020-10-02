package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzh;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "OnDownloadProgressResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfl> CREATOR = new zzfm();
    private static final List<zzh> zzhx = Collections.emptyList();
    @SafeParcelable.Field(mo15196id = 4)
    private final int status;
    @SafeParcelable.Field(mo15196id = 2)
    final long zzhy;
    @SafeParcelable.Field(mo15196id = 3)
    final long zzhz;
    @SafeParcelable.Field(mo15196id = 5)
    private final List<zzh> zzia;

    @SafeParcelable.Constructor
    public zzfl(@SafeParcelable.Param(mo15199id = 2) long j, @SafeParcelable.Param(mo15199id = 3) long j2, @SafeParcelable.Param(mo15199id = 4) int i, @SafeParcelable.Param(mo15199id = 5) List<zzh> list) {
        this.zzhy = j;
        this.zzhz = j2;
        this.status = i;
        this.zzia = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, this.zzhy);
        SafeParcelWriter.writeLong(parcel, 3, this.zzhz);
        SafeParcelWriter.writeInt(parcel, 4, this.status);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zzia, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
