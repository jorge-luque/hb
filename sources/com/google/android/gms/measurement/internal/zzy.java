package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzx();
    @SafeParcelable.Field(mo15196id = 2)
    public String zza;
    @SafeParcelable.Field(mo15196id = 3)
    public String zzb;
    @SafeParcelable.Field(mo15196id = 4)
    public zzkn zzc;
    @SafeParcelable.Field(mo15196id = 5)
    public long zzd;
    @SafeParcelable.Field(mo15196id = 6)
    public boolean zze;
    @SafeParcelable.Field(mo15196id = 7)
    public String zzf;
    @SafeParcelable.Field(mo15196id = 8)
    public zzaq zzg;
    @SafeParcelable.Field(mo15196id = 9)
    public long zzh;
    @SafeParcelable.Field(mo15196id = 10)
    public zzaq zzi;
    @SafeParcelable.Field(mo15196id = 11)
    public long zzj;
    @SafeParcelable.Field(mo15196id = 12)
    public zzaq zzk;

    zzy(zzy zzy) {
        Preconditions.checkNotNull(zzy);
        this.zza = zzy.zza;
        this.zzb = zzy.zzb;
        this.zzc = zzy.zzc;
        this.zzd = zzy.zzd;
        this.zze = zzy.zze;
        this.zzf = zzy.zzf;
        this.zzg = zzy.zzg;
        this.zzh = zzy.zzh;
        this.zzi = zzy.zzi;
        this.zzj = zzy.zzj;
        this.zzk = zzy.zzk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzy(@SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) String str2, @SafeParcelable.Param(mo15199id = 4) zzkn zzkn, @SafeParcelable.Param(mo15199id = 5) long j, @SafeParcelable.Param(mo15199id = 6) boolean z, @SafeParcelable.Param(mo15199id = 7) String str3, @SafeParcelable.Param(mo15199id = 8) zzaq zzaq, @SafeParcelable.Param(mo15199id = 9) long j2, @SafeParcelable.Param(mo15199id = 10) zzaq zzaq2, @SafeParcelable.Param(mo15199id = 11) long j3, @SafeParcelable.Param(mo15199id = 12) zzaq zzaq3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzkn;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzaq;
        this.zzh = j2;
        this.zzi = zzaq2;
        this.zzj = j3;
        this.zzk = zzaq3;
    }
}
