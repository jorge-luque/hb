package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "PermissionCreator")
@SafeParcelable.Reserved({1})
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @SafeParcelable.Field(getter = "getAccountType", mo15196id = 3)
    private int accountType;
    @SafeParcelable.Field(getter = "getAccountIdentifier", mo15196id = 2)
    private String zzbg;
    @SafeParcelable.Field(getter = "getAccountDisplayName", mo15196id = 4)
    private String zzbh;
    @SafeParcelable.Field(getter = "getPhotoLink", mo15196id = 5)
    private String zzbi;
    @SafeParcelable.Field(getter = "getRole", mo15196id = 6)
    private int zzbj;
    @SafeParcelable.Field(getter = "isLinkRequiredForAccess", mo15196id = 7)
    private boolean zzbk;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) int i, @SafeParcelable.Param(mo15199id = 4) String str2, @SafeParcelable.Param(mo15199id = 5) String str3, @SafeParcelable.Param(mo15199id = 6) int i2, @SafeParcelable.Param(mo15199id = 7) boolean z) {
        this.zzbg = str;
        this.accountType = i;
        this.zzbh = str2;
        this.zzbi = str3;
        this.zzbj = i2;
        this.zzbk = z;
    }

    private static boolean zzb(int i) {
        switch (i) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzr.class) {
            if (obj == this) {
                return true;
            }
            zzr zzr = (zzr) obj;
            return Objects.equal(this.zzbg, zzr.zzbg) && this.accountType == zzr.accountType && this.zzbj == zzr.zzbj && this.zzbk == zzr.zzbk;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbg, Integer.valueOf(this.accountType), Integer.valueOf(this.zzbj), Boolean.valueOf(this.zzbk));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        String str;
        int i2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        if (!zzb(this.accountType)) {
            str = null;
        } else {
            str = this.zzbg;
        }
        boolean z = false;
        SafeParcelWriter.writeString(parcel, 2, str, false);
        int i3 = -1;
        if (!zzb(this.accountType)) {
            i2 = -1;
        } else {
            i2 = this.accountType;
        }
        SafeParcelWriter.writeInt(parcel, 3, i2);
        SafeParcelWriter.writeString(parcel, 4, this.zzbh, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbi, false);
        int i4 = this.zzbj;
        if (i4 == 0 || i4 == 1 || i4 == 2 || i4 == 3) {
            z = true;
        }
        if (z) {
            i3 = this.zzbj;
        }
        SafeParcelWriter.writeInt(parcel, 6, i3);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
