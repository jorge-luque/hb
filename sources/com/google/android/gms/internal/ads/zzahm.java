package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzahm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzahm> CREATOR = new zzahp();
    @SafeParcelable.VersionField(mo15202id = 1000)
    public final int versionCode;
    @SafeParcelable.Field(mo15196id = 3)
    public final int zzbky;
    @SafeParcelable.Field(mo15196id = 1)
    public final int zzdbm;
    @SafeParcelable.Field(mo15196id = 2)
    public final String zzdbn;

    public zzahm(zzahy zzahy) {
        this(2, 1, zzahy.zzsq(), zzahy.getMediaAspectRatio());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzdbm);
        SafeParcelWriter.writeString(parcel, 2, this.zzdbn, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbky);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzahm(@SafeParcelable.Param(mo15199id = 1000) int i, @SafeParcelable.Param(mo15199id = 1) int i2, @SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) int i3) {
        this.versionCode = i;
        this.zzdbm = i2;
        this.zzdbn = str;
        this.zzbky = i3;
    }
}
