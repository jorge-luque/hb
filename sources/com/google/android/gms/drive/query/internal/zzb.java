package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "ComparisonFilterCreator")
@SafeParcelable.Reserved({1000})
public final class zzb<T> extends zza {
    public static final zzc CREATOR = new zzc();
    @SafeParcelable.Field(mo15196id = 1)
    private final zzx zzlz;
    @SafeParcelable.Field(mo15196id = 2)
    private final MetadataBundle zzma;
    private final MetadataField<T> zzmb;

    @SafeParcelable.Constructor
    zzb(@SafeParcelable.Param(mo15199id = 1) zzx zzx, @SafeParcelable.Param(mo15199id = 2) MetadataBundle metadataBundle) {
        this.zzlz = zzx;
        this.zzma = metadataBundle;
        this.zzmb = zzi.zza(metadataBundle);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzlz, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzma, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final <F> F zza(zzj<F> zzj) {
        zzx zzx = this.zzlz;
        MetadataField<T> metadataField = this.zzmb;
        return zzj.zza(zzx, metadataField, this.zzma.zza(metadataField));
    }

    public zzb(zzx zzx, SearchableMetadataField<T> searchableMetadataField, T t) {
        this(zzx, MetadataBundle.zza(searchableMetadataField, t));
    }
}
