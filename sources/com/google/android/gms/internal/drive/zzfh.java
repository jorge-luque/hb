package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

@SafeParcelable.Class(creator = "OnContentsResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfh> CREATOR = new zzfi();
    @SafeParcelable.Field(mo15196id = 2)
    final Contents zzes;
    @SafeParcelable.Field(mo15196id = 3)
    final boolean zzhv;

    @SafeParcelable.Constructor
    public zzfh(@SafeParcelable.Param(mo15199id = 2) Contents contents, @SafeParcelable.Param(mo15199id = 3) boolean z) {
        this.zzes = contents;
        this.zzhv = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzes, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzhv);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Contents zzar() {
        return this.zzes;
    }
}
