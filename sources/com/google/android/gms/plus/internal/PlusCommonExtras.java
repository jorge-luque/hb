package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepName
@SafeParcelable.Class(creator = "PlusCommonExtrasCreator")
public class PlusCommonExtras extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PlusCommonExtras> CREATOR = new zzl();
    @SafeParcelable.VersionField(getter = "getVersionCode", mo15202id = 1000)
    private final int zzw;
    @SafeParcelable.Field(getter = "getGpsrc", mo15196id = 1)
    private String zzx;
    @SafeParcelable.Field(getter = "getClientCallingPackage", mo15196id = 2)
    private String zzy;

    public PlusCommonExtras() {
        this.zzw = 1;
        this.zzx = "";
        this.zzy = "";
    }

    @SafeParcelable.Constructor
    PlusCommonExtras(@SafeParcelable.Param(mo15199id = 1000) int i, @SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2) {
        this.zzw = i;
        this.zzx = str;
        this.zzy = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.zzw == plusCommonExtras.zzw && Objects.equal(this.zzx, plusCommonExtras.zzx) && Objects.equal(this.zzy, plusCommonExtras.zzy);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzw), this.zzx, this.zzy);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zzw)).add("Gpsrc", this.zzx).add("ClientCallingPackage", this.zzy).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzx, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzy, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
