package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzj();
    @SafeParcelable.Field(mo15196id = 2)
    public final boolean zzblz;
    @SafeParcelable.Field(mo15196id = 3)
    public final boolean zzbma;
    @SafeParcelable.Field(mo15196id = 4)
    private final String zzbmb;
    @SafeParcelable.Field(mo15196id = 5)
    public final boolean zzbmc;
    @SafeParcelable.Field(mo15196id = 6)
    public final float zzbmd;
    @SafeParcelable.Field(mo15196id = 7)
    public final int zzbme;
    @SafeParcelable.Field(mo15196id = 8)
    public final boolean zzbmf;
    @SafeParcelable.Field(mo15196id = 9)
    public final boolean zzbmg;
    @SafeParcelable.Field(mo15196id = 10)
    public final boolean zzbmh;

    public zzg(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(false, z2, (String) null, false, 0.0f, -1, z4, z5, z6);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzblz);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbma);
        SafeParcelWriter.writeString(parcel, 4, this.zzbmb, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbmc);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzbmd);
        SafeParcelWriter.writeInt(parcel, 7, this.zzbme);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbmf);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbmg);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzbmh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzg(@SafeParcelable.Param(mo15199id = 2) boolean z, @SafeParcelable.Param(mo15199id = 3) boolean z2, @SafeParcelable.Param(mo15199id = 4) String str, @SafeParcelable.Param(mo15199id = 5) boolean z3, @SafeParcelable.Param(mo15199id = 6) float f, @SafeParcelable.Param(mo15199id = 7) int i, @SafeParcelable.Param(mo15199id = 8) boolean z4, @SafeParcelable.Param(mo15199id = 9) boolean z5, @SafeParcelable.Param(mo15199id = 10) boolean z6) {
        this.zzblz = z;
        this.zzbma = z2;
        this.zzbmb = str;
        this.zzbmc = z3;
        this.zzbmd = f;
        this.zzbme = i;
        this.zzbmf = z4;
        this.zzbmg = z5;
        this.zzbmh = z6;
    }
}
