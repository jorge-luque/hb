package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterStatusParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzaha extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaha> CREATOR = new zzahd();
    @SafeParcelable.Field(mo15196id = 4)
    public final String description;
    @SafeParcelable.Field(mo15196id = 1)
    public final String zzdbg;
    @SafeParcelable.Field(mo15196id = 2)
    public final boolean zzdbh;
    @SafeParcelable.Field(mo15196id = 3)
    public final int zzdbi;

    @SafeParcelable.Constructor
    public zzaha(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) boolean z, @SafeParcelable.Param(mo15199id = 3) int i, @SafeParcelable.Param(mo15199id = 4) String str2) {
        this.zzdbg = str;
        this.zzdbh = z;
        this.zzdbi = i;
        this.description = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdbg, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdbh);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdbi);
        SafeParcelWriter.writeString(parcel, 4, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
