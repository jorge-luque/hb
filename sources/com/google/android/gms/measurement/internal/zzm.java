package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1, 20})
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzo();
    @SafeParcelable.Field(mo15196id = 2)
    public final String zza;
    @SafeParcelable.Field(mo15196id = 3)
    public final String zzb;
    @SafeParcelable.Field(mo15196id = 4)
    public final String zzc;
    @SafeParcelable.Field(mo15196id = 5)
    public final String zzd;
    @SafeParcelable.Field(mo15196id = 6)
    public final long zze;
    @SafeParcelable.Field(mo15196id = 7)
    public final long zzf;
    @SafeParcelable.Field(mo15196id = 8)
    public final String zzg;
    @SafeParcelable.Field(defaultValue = "true", mo15196id = 9)
    public final boolean zzh;
    @SafeParcelable.Field(mo15196id = 10)
    public final boolean zzi;
    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MIN_VALUE", mo15196id = 11)
    public final long zzj;
    @SafeParcelable.Field(mo15196id = 12)
    public final String zzk;
    @SafeParcelable.Field(mo15196id = 13)
    public final long zzl;
    @SafeParcelable.Field(mo15196id = 14)
    public final long zzm;
    @SafeParcelable.Field(mo15196id = 15)
    public final int zzn;
    @SafeParcelable.Field(defaultValue = "true", mo15196id = 16)
    public final boolean zzo;
    @SafeParcelable.Field(defaultValue = "true", mo15196id = 17)
    public final boolean zzp;
    @SafeParcelable.Field(mo15196id = 18)
    public final boolean zzq;
    @SafeParcelable.Field(mo15196id = 19)
    public final String zzr;
    @SafeParcelable.Field(mo15196id = 21)
    public final Boolean zzs;
    @SafeParcelable.Field(mo15196id = 22)
    public final long zzt;
    @SafeParcelable.Field(mo15196id = 23)
    public final List<String> zzu;
    @SafeParcelable.Field(mo15196id = 24)
    public final String zzv;

    zzm(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j6, List<String> list, String str8) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j;
        this.zzd = str4;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = j5;
        this.zzn = i;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = z5;
        this.zzr = str7;
        this.zzs = bool;
        this.zzt = j6;
        this.zzu = list;
        this.zzv = str8;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzl);
        SafeParcelWriter.writeLong(parcel, 14, this.zzm);
        SafeParcelWriter.writeInt(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzp);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzq);
        SafeParcelWriter.writeString(parcel, 19, this.zzr, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.zzs, false);
        SafeParcelWriter.writeLong(parcel, 22, this.zzt);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzm(@SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) String str2, @SafeParcelable.Param(mo15199id = 4) String str3, @SafeParcelable.Param(mo15199id = 5) String str4, @SafeParcelable.Param(mo15199id = 6) long j, @SafeParcelable.Param(mo15199id = 7) long j2, @SafeParcelable.Param(mo15199id = 8) String str5, @SafeParcelable.Param(mo15199id = 9) boolean z, @SafeParcelable.Param(mo15199id = 10) boolean z2, @SafeParcelable.Param(mo15199id = 11) long j3, @SafeParcelable.Param(mo15199id = 12) String str6, @SafeParcelable.Param(mo15199id = 13) long j4, @SafeParcelable.Param(mo15199id = 14) long j5, @SafeParcelable.Param(mo15199id = 15) int i, @SafeParcelable.Param(mo15199id = 16) boolean z3, @SafeParcelable.Param(mo15199id = 17) boolean z4, @SafeParcelable.Param(mo15199id = 18) boolean z5, @SafeParcelable.Param(mo15199id = 19) String str7, @SafeParcelable.Param(mo15199id = 21) Boolean bool, @SafeParcelable.Param(mo15199id = 22) long j6, @SafeParcelable.Param(mo15199id = 23) List<String> list, @SafeParcelable.Param(mo15199id = 24) String str8) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j3;
        this.zzd = str4;
        this.zze = j;
        this.zzf = j2;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = j5;
        this.zzn = i;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = z5;
        this.zzr = str7;
        this.zzs = bool;
        this.zzt = j6;
        this.zzu = list;
        this.zzv = str8;
    }
}
