package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassEventParcelCreator")
/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public final class zzdmp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdmp> CREATOR = new zzdms();
    @SafeParcelable.VersionField(mo15202id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo15196id = 2)
    private final byte[] zzhcl;

    @SafeParcelable.Constructor
    zzdmp(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzhcl = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhcl, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzdmp(byte[] bArr) {
        this(1, bArr);
    }
}
