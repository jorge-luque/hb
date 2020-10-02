package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ExceptionParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzaye extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaye> CREATOR = new zzayg();
    @SafeParcelable.Field(mo15196id = 2)
    public final int errorCode;
    @SafeParcelable.Field(mo15196id = 1)
    public final String zzdxf;

    @SafeParcelable.Constructor
    zzaye(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) int i) {
        this.zzdxf = str == null ? "" : str;
        this.errorCode = i;
    }

    public static zzaye zza(Throwable th, int i) {
        return new zzaye(th.getMessage(), i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdxf, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
