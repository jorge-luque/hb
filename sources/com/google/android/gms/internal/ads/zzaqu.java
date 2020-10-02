package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzaqu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqu> CREATOR = new zzaqt();
    @SafeParcelable.Field(mo15196id = 6)
    private final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(mo15196id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo15196id = 11)
    private final zzazz zzbmo;
    @SafeParcelable.Field(mo15196id = 4)
    private final zzum zzbmp;
    @SafeParcelable.Field(mo15196id = 20)
    private final float zzbpk;
    @SafeParcelable.Field(mo15196id = 5)
    private final String zzbsc;
    @SafeParcelable.Field(mo15196id = 10)
    private final String zzcgc;
    @SafeParcelable.Field(mo15196id = 42)
    private final boolean zzdez;
    @SafeParcelable.Field(mo15196id = 29)
    private final zzaci zzdhc;
    @SafeParcelable.Field(mo15196id = 14)
    private final List<String> zzdhd;
    @SafeParcelable.Field(mo15196id = 18)
    private final int zzdji;
    @SafeParcelable.Field(mo15196id = 19)
    private final int zzdjj;
    @SafeParcelable.Field(mo15196id = 2)
    private final Bundle zzdlw;
    @SafeParcelable.Field(mo15196id = 3)
    private final zzuj zzdlx;
    @SafeParcelable.Field(mo15196id = 7)
    private final PackageInfo zzdly;
    @SafeParcelable.Field(mo15196id = 8)
    private final String zzdlz;
    @SafeParcelable.Field(mo15196id = 9)
    private final String zzdma;
    @SafeParcelable.Field(mo15196id = 12)
    private final Bundle zzdmb;
    @SafeParcelable.Field(mo15196id = 13)
    private final int zzdmc;
    @SafeParcelable.Field(mo15196id = 15)
    private final Bundle zzdmd;
    @SafeParcelable.Field(mo15196id = 16)
    private final boolean zzdme;
    @SafeParcelable.Field(mo15196id = 21)
    private final String zzdmf;
    @SafeParcelable.Field(mo15196id = 25)
    private final long zzdmg;
    @SafeParcelable.Field(mo15196id = 26)
    private final String zzdmh;
    @SafeParcelable.Field(mo15196id = 27)
    private final List<String> zzdmi;
    @SafeParcelable.Field(mo15196id = 28)
    private final String zzdmj;
    @SafeParcelable.Field(mo15196id = 30)
    private final List<String> zzdmk;
    @SafeParcelable.Field(mo15196id = 31)
    private final long zzdml;
    @SafeParcelable.Field(mo15196id = 33)
    private final String zzdmm;
    @SafeParcelable.Field(mo15196id = 34)
    private final float zzdmn;
    @SafeParcelable.Field(mo15196id = 35)
    private final int zzdmo;
    @SafeParcelable.Field(mo15196id = 36)
    private final int zzdmp;
    @SafeParcelable.Field(mo15196id = 37)
    private final boolean zzdmq;
    @SafeParcelable.Field(mo15196id = 38)
    private final boolean zzdmr;
    @SafeParcelable.Field(mo15196id = 39)
    private final String zzdms;
    @SafeParcelable.Field(mo15196id = 40)
    private final boolean zzdmt;
    @SafeParcelable.Field(mo15196id = 41)
    private final String zzdmu;
    @SafeParcelable.Field(mo15196id = 43)
    private final int zzdmv;
    @SafeParcelable.Field(mo15196id = 44)
    private final Bundle zzdmw;
    @SafeParcelable.Field(mo15196id = 45)
    private final String zzdmx;
    @SafeParcelable.Field(mo15196id = 46)
    private final zzxr zzdmy;
    @SafeParcelable.Field(mo15196id = 47)
    private final boolean zzdmz;
    @SafeParcelable.Field(mo15196id = 48)
    private final Bundle zzdna;
    @SafeParcelable.Field(mo15196id = 49)
    private final String zzdnb;
    @SafeParcelable.Field(mo15196id = 50)
    private final String zzdnc;
    @SafeParcelable.Field(mo15196id = 51)
    private final String zzdnd;
    @SafeParcelable.Field(mo15196id = 52)
    private final boolean zzdne;
    @SafeParcelable.Field(mo15196id = 53)
    private final List<Integer> zzdnf;
    @SafeParcelable.Field(mo15196id = 54)
    private final String zzdng;
    @SafeParcelable.Field(mo15196id = 55)
    private final List<String> zzdnh;
    @SafeParcelable.Field(mo15196id = 56)
    private final int zzdni;
    @SafeParcelable.Field(mo15196id = 57)
    private final boolean zzdnj;
    @SafeParcelable.Field(mo15196id = 58)
    private final boolean zzdnk;
    @SafeParcelable.Field(mo15196id = 59)
    private final boolean zzdnl;
    @SafeParcelable.Field(mo15196id = 60)
    private final ArrayList<String> zzdnm;
    @SafeParcelable.Field(mo15196id = 61)
    private final String zzdnn;
    @SafeParcelable.Field(mo15196id = 63)
    private final zzahm zzdno;
    @SafeParcelable.Field(mo15196id = 64)
    private final String zzdnp;
    @SafeParcelable.Field(mo15196id = 65)
    private final Bundle zzdnq;

    @SafeParcelable.Constructor
    zzaqu(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) Bundle bundle, @SafeParcelable.Param(mo15199id = 3) zzuj zzuj, @SafeParcelable.Param(mo15199id = 4) zzum zzum, @SafeParcelable.Param(mo15199id = 5) String str, @SafeParcelable.Param(mo15199id = 6) ApplicationInfo applicationInfo2, @SafeParcelable.Param(mo15199id = 7) PackageInfo packageInfo, @SafeParcelable.Param(mo15199id = 8) String str2, @SafeParcelable.Param(mo15199id = 9) String str3, @SafeParcelable.Param(mo15199id = 10) String str4, @SafeParcelable.Param(mo15199id = 11) zzazz zzazz, @SafeParcelable.Param(mo15199id = 12) Bundle bundle2, @SafeParcelable.Param(mo15199id = 13) int i2, @SafeParcelable.Param(mo15199id = 14) List<String> list, @SafeParcelable.Param(mo15199id = 15) Bundle bundle3, @SafeParcelable.Param(mo15199id = 16) boolean z, @SafeParcelable.Param(mo15199id = 18) int i3, @SafeParcelable.Param(mo15199id = 19) int i4, @SafeParcelable.Param(mo15199id = 20) float f, @SafeParcelable.Param(mo15199id = 21) String str5, @SafeParcelable.Param(mo15199id = 25) long j, @SafeParcelable.Param(mo15199id = 26) String str6, @SafeParcelable.Param(mo15199id = 27) List<String> list2, @SafeParcelable.Param(mo15199id = 28) String str7, @SafeParcelable.Param(mo15199id = 29) zzaci zzaci, @SafeParcelable.Param(mo15199id = 30) List<String> list3, @SafeParcelable.Param(mo15199id = 31) long j2, @SafeParcelable.Param(mo15199id = 33) String str8, @SafeParcelable.Param(mo15199id = 34) float f2, @SafeParcelable.Param(mo15199id = 40) boolean z2, @SafeParcelable.Param(mo15199id = 35) int i5, @SafeParcelable.Param(mo15199id = 36) int i6, @SafeParcelable.Param(mo15199id = 37) boolean z3, @SafeParcelable.Param(mo15199id = 38) boolean z4, @SafeParcelable.Param(mo15199id = 39) String str9, @SafeParcelable.Param(mo15199id = 41) String str10, @SafeParcelable.Param(mo15199id = 42) boolean z5, @SafeParcelable.Param(mo15199id = 43) int i7, @SafeParcelable.Param(mo15199id = 44) Bundle bundle4, @SafeParcelable.Param(mo15199id = 45) String str11, @SafeParcelable.Param(mo15199id = 46) zzxr zzxr, @SafeParcelable.Param(mo15199id = 47) boolean z6, @SafeParcelable.Param(mo15199id = 48) Bundle bundle5, @SafeParcelable.Param(mo15199id = 49) String str12, @SafeParcelable.Param(mo15199id = 50) String str13, @SafeParcelable.Param(mo15199id = 51) String str14, @SafeParcelable.Param(mo15199id = 52) boolean z7, @SafeParcelable.Param(mo15199id = 53) List<Integer> list4, @SafeParcelable.Param(mo15199id = 54) String str15, @SafeParcelable.Param(mo15199id = 55) List<String> list5, @SafeParcelable.Param(mo15199id = 56) int i8, @SafeParcelable.Param(mo15199id = 57) boolean z8, @SafeParcelable.Param(mo15199id = 58) boolean z9, @SafeParcelable.Param(mo15199id = 59) boolean z10, @SafeParcelable.Param(mo15199id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(mo15199id = 61) String str16, @SafeParcelable.Param(mo15199id = 63) zzahm zzahm, @SafeParcelable.Param(mo15199id = 64) String str17, @SafeParcelable.Param(mo15199id = 65) Bundle bundle6) {
        List<String> list6;
        List<String> list7;
        this.versionCode = i;
        this.zzdlw = bundle;
        this.zzdlx = zzuj;
        this.zzbmp = zzum;
        this.zzbsc = str;
        this.applicationInfo = applicationInfo2;
        this.zzdly = packageInfo;
        this.zzdlz = str2;
        this.zzdma = str3;
        this.zzcgc = str4;
        this.zzbmo = zzazz;
        this.zzdmb = bundle2;
        this.zzdmc = i2;
        this.zzdhd = list;
        if (list3 == null) {
            list6 = Collections.emptyList();
        } else {
            list6 = Collections.unmodifiableList(list3);
        }
        this.zzdmk = list6;
        this.zzdmd = bundle3;
        this.zzdme = z;
        this.zzdji = i3;
        this.zzdjj = i4;
        this.zzbpk = f;
        this.zzdmf = str5;
        this.zzdmg = j;
        this.zzdmh = str6;
        if (list2 == null) {
            list7 = Collections.emptyList();
        } else {
            list7 = Collections.unmodifiableList(list2);
        }
        this.zzdmi = list7;
        this.zzdmj = str7;
        this.zzdhc = zzaci;
        this.zzdml = j2;
        this.zzdmm = str8;
        this.zzdmn = f2;
        this.zzdmt = z2;
        this.zzdmo = i5;
        this.zzdmp = i6;
        this.zzdmq = z3;
        this.zzdmr = z4;
        this.zzdms = str9;
        this.zzdmu = str10;
        this.zzdez = z5;
        this.zzdmv = i7;
        this.zzdmw = bundle4;
        this.zzdmx = str11;
        this.zzdmy = zzxr;
        this.zzdmz = z6;
        this.zzdna = bundle5;
        this.zzdnb = str12;
        this.zzdnc = str13;
        this.zzdnd = str14;
        this.zzdne = z7;
        this.zzdnf = list4;
        this.zzdng = str15;
        this.zzdnh = list5;
        this.zzdni = i8;
        this.zzdnj = z8;
        this.zzdnk = z9;
        this.zzdnl = z10;
        this.zzdnm = arrayList;
        this.zzdnn = str16;
        this.zzdno = zzahm;
        this.zzdnp = str17;
        this.zzdnq = bundle6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdlw, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdlx, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbmp, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbsc, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.applicationInfo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdly, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdlz, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzdma, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzcgc, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzbmo, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzdmb, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdmc);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzdhd, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzdmd, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzdme);
        SafeParcelWriter.writeInt(parcel, 18, this.zzdji);
        SafeParcelWriter.writeInt(parcel, 19, this.zzdjj);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzbpk);
        SafeParcelWriter.writeString(parcel, 21, this.zzdmf, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzdmg);
        SafeParcelWriter.writeString(parcel, 26, this.zzdmh, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzdmi, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzdmj, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzdhc, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzdmk, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzdml);
        SafeParcelWriter.writeString(parcel, 33, this.zzdmm, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzdmn);
        SafeParcelWriter.writeInt(parcel, 35, this.zzdmo);
        SafeParcelWriter.writeInt(parcel, 36, this.zzdmp);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzdmq);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdmr);
        SafeParcelWriter.writeString(parcel, 39, this.zzdms, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzdmt);
        SafeParcelWriter.writeString(parcel, 41, this.zzdmu, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdez);
        SafeParcelWriter.writeInt(parcel, 43, this.zzdmv);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzdmw, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdmx, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzdmy, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdmz);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdna, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzdnb, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzdnc, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzdnd, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzdne);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzdnf, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzdng, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzdnh, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzdni);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdnj);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzdnk);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzdnl);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzdnm, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzdnn, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzdno, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzdnp, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzdnq, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
