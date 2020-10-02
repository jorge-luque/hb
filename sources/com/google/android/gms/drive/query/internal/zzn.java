package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "HasFilterCreator")
@SafeParcelable.Reserved({1000})
public final class zzn<T> extends zza {
    public static final zzo CREATOR = new zzo();
    @SafeParcelable.Field(mo15196id = 1)
    private final MetadataBundle zzma;
    private final MetadataField<T> zzmb;

    @SafeParcelable.Constructor
    zzn(@SafeParcelable.Param(mo15199id = 1) MetadataBundle metadataBundle) {
        this.zzma = metadataBundle;
        this.zzmb = zzi.zza(metadataBundle);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzma, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final <F> F zza(zzj<F> zzj) {
        MetadataField<T> metadataField = this.zzmb;
        return zzj.zzc(metadataField, this.zzma.zza(metadataField));
    }

    public zzn(SearchableMetadataField<T> searchableMetadataField, T t) {
        this(MetadataBundle.zza(searchableMetadataField, t));
    }
}
