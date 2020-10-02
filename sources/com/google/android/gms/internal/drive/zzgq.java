package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.query.Query;

@SafeParcelable.Class(creator = "QueryRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzgq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgq> CREATOR = new zzgr();
    @SafeParcelable.Field(mo15196id = 2)
    private final Query zzir;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzgq(@SafeParcelable.Param(mo15199id = 2) Query query) {
        this.zzir = query;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzir, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
