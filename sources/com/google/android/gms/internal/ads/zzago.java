package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "HttpResponseParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzago extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzago> CREATOR = new zzagr();
    @SafeParcelable.Field(mo15196id = 4)
    public final byte[] data;
    @SafeParcelable.Field(mo15196id = 3)
    public final int statusCode;
    @SafeParcelable.Field(mo15196id = 7)
    public final boolean zzac;
    @SafeParcelable.Field(mo15196id = 8)
    public final long zzad;
    @SafeParcelable.Field(mo15196id = 5)
    public final String[] zzdaz;
    @SafeParcelable.Field(mo15196id = 6)
    public final String[] zzdba;
    @SafeParcelable.Field(mo15196id = 1)
    public final boolean zzdbb;
    @SafeParcelable.Field(mo15196id = 2)
    public final String zzdbc;

    @SafeParcelable.Constructor
    zzago(@SafeParcelable.Param(mo15199id = 1) boolean z, @SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) int i, @SafeParcelable.Param(mo15199id = 4) byte[] bArr, @SafeParcelable.Param(mo15199id = 5) String[] strArr, @SafeParcelable.Param(mo15199id = 6) String[] strArr2, @SafeParcelable.Param(mo15199id = 7) boolean z2, @SafeParcelable.Param(mo15199id = 8) long j) {
        this.zzdbb = z;
        this.zzdbc = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzdaz = strArr;
        this.zzdba = strArr2;
        this.zzac = z2;
        this.zzad = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzdbb);
        SafeParcelWriter.writeString(parcel, 2, this.zzdbc, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 4, this.data, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzdaz, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzdba, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzac);
        SafeParcelWriter.writeLong(parcel, 8, this.zzad);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
