package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "ProgramResponseCreator")
/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public final class zzdng extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdng> CREATOR = new zzdnf();
    @SafeParcelable.Field(mo15196id = 3)
    public final int status;
    @SafeParcelable.VersionField(mo15202id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo15196id = 2)
    public final byte[] zzhdb;

    @SafeParcelable.Constructor
    zzdng(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) byte[] bArr, @SafeParcelable.Param(mo15199id = 3) int i2) {
        byte[] bArr2;
        this.versionCode = i;
        if (bArr == null) {
            bArr2 = null;
        } else {
            bArr2 = Arrays.copyOf(bArr, bArr.length);
        }
        this.zzhdb = bArr2;
        this.status = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhdb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.status);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzdng(byte[] bArr, int i) {
        this(1, (byte[]) null, 1);
    }
}
