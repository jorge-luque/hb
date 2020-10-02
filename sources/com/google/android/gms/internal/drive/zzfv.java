package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzu;

@SafeParcelable.Class(creator = "OnListParentsResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfv extends zzu {
    public static final Parcelable.Creator<zzfv> CREATOR = new zzfw();
    @SafeParcelable.Field(mo15196id = 2)
    final DataHolder zzij;

    @SafeParcelable.Constructor
    public zzfv(@SafeParcelable.Param(mo15199id = 2) DataHolder dataHolder) {
        this.zzij = dataHolder;
    }

    /* access modifiers changed from: protected */
    public final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzij, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DataHolder zzav() {
        return this.zzij;
    }
}
