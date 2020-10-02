package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassRequestParcelCreator")
/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public final class zzdmu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdmu> CREATOR = new zzdmt();
    @SafeParcelable.Field(mo15196id = 2)
    private final String packageName;
    @SafeParcelable.VersionField(mo15202id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo15196id = 3)
    private final String zzhcn;

    @SafeParcelable.Constructor
    zzdmu(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzhcn = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhcn, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzdmu(String str, String str2) {
        this(1, str, str2);
    }
}
