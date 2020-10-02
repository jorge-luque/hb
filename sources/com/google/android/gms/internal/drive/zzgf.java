package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "OnStartStreamSessionCreator")
@SafeParcelable.Reserved({1})
public final class zzgf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgf> CREATOR = new zzgg();
    @SafeParcelable.Field(mo15196id = 2)
    private final ParcelFileDescriptor zzin;
    @SafeParcelable.Field(mo15196id = 3)
    private final IBinder zzio;
    @SafeParcelable.Field(mo15196id = 4)
    private final String zzm;

    @SafeParcelable.Constructor
    zzgf(@SafeParcelable.Param(mo15199id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(mo15199id = 3) IBinder iBinder, @SafeParcelable.Param(mo15199id = 4) String str) {
        this.zzin = parcelFileDescriptor;
        this.zzio = iBinder;
        this.zzm = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzin, i | 1, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzio, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
