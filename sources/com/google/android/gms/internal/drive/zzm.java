package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzn;

@SafeParcelable.Class(creator = "CloseContentsAndUpdateMetadataRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();
    @SafeParcelable.Field(mo15196id = 6)
    private final String zzan;
    @SafeParcelable.Field(mo15196id = 5)
    private final boolean zzao;
    @SafeParcelable.Field(defaultValue = "true", mo15196id = 10)
    private final boolean zzat;
    @SafeParcelable.Field(mo15196id = 2)
    private final DriveId zzdd;
    @SafeParcelable.Field(mo15196id = 3)
    private final MetadataBundle zzde;
    @SafeParcelable.Field(mo15196id = 4)
    private final Contents zzdf;
    @SafeParcelable.Field(mo15196id = 7)
    private final int zzdg;
    @SafeParcelable.Field(mo15196id = 8)
    private final int zzdh;
    @SafeParcelable.Field(mo15196id = 9)
    private final boolean zzdi;

    @SafeParcelable.Constructor
    zzm(@SafeParcelable.Param(mo15199id = 2) DriveId driveId, @SafeParcelable.Param(mo15199id = 3) MetadataBundle metadataBundle, @SafeParcelable.Param(mo15199id = 4) Contents contents, @SafeParcelable.Param(mo15199id = 5) boolean z, @SafeParcelable.Param(mo15199id = 6) String str, @SafeParcelable.Param(mo15199id = 7) int i, @SafeParcelable.Param(mo15199id = 8) int i2, @SafeParcelable.Param(mo15199id = 9) boolean z2, @SafeParcelable.Param(mo15199id = 10) boolean z3) {
        this.zzdd = driveId;
        this.zzde = metadataBundle;
        this.zzdf = contents;
        this.zzao = z;
        this.zzan = str;
        this.zzdg = i;
        this.zzdh = i2;
        this.zzdi = z2;
        this.zzat = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzde, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzao);
        SafeParcelWriter.writeString(parcel, 6, this.zzan, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzdg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzdh);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzdi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzat);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @VisibleForTesting
    public zzm(DriveId driveId, MetadataBundle metadataBundle, int i, boolean z, zzn zzn) {
        this(driveId, metadataBundle, (Contents) null, zzn.zzm(), zzn.zzl(), zzn.zzn(), i, z, zzn.zzp());
    }
}
