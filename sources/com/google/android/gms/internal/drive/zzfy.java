package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "OnMetadataResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfy> CREATOR = new zzfz();
    @SafeParcelable.Field(mo15196id = 2)
    final MetadataBundle zzdn;

    @SafeParcelable.Constructor
    public zzfy(@SafeParcelable.Param(mo15199id = 2) MetadataBundle metadataBundle) {
        this.zzdn = metadataBundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdn, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final MetadataBundle zzaw() {
        return this.zzdn;
    }
}
