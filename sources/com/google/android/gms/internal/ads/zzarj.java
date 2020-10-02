package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzarj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarj> CREATOR = new zzarm();
    @SafeParcelable.Field(mo15196id = 3)
    public final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(mo15196id = 4)
    public final String packageName;
    @SafeParcelable.Field(mo15196id = 2)
    public final zzazz zzdls;
    @SafeParcelable.Field(mo15196id = 6)
    public final PackageInfo zzdly;
    @SafeParcelable.Field(mo15196id = 5)
    public final List<String> zzdmi;
    @SafeParcelable.Field(mo15196id = 7)
    public final String zzdms;
    @SafeParcelable.Field(mo15196id = 1)
    public final Bundle zzdpe;
    @SafeParcelable.Field(mo15196id = 8)
    public final boolean zzdpf;
    @SafeParcelable.Field(mo15196id = 9)
    public final String zzdpg;
    @SafeParcelable.Field(mo15196id = 10)
    public zzdir zzdph;
    @SafeParcelable.Field(mo15196id = 11)
    public String zzdpi;

    @SafeParcelable.Constructor
    public zzarj(@SafeParcelable.Param(mo15199id = 1) Bundle bundle, @SafeParcelable.Param(mo15199id = 2) zzazz zzazz, @SafeParcelable.Param(mo15199id = 3) ApplicationInfo applicationInfo2, @SafeParcelable.Param(mo15199id = 4) String str, @SafeParcelable.Param(mo15199id = 5) List<String> list, @SafeParcelable.Param(mo15199id = 6) PackageInfo packageInfo, @SafeParcelable.Param(mo15199id = 7) String str2, @SafeParcelable.Param(mo15199id = 8) boolean z, @SafeParcelable.Param(mo15199id = 9) String str3, @SafeParcelable.Param(mo15199id = 10) zzdir zzdir, @SafeParcelable.Param(mo15199id = 11) String str4) {
        this.zzdpe = bundle;
        this.zzdls = zzazz;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzdmi = list;
        this.zzdly = packageInfo;
        this.zzdms = str2;
        this.zzdpf = z;
        this.zzdpg = str3;
        this.zzdph = zzdir;
        this.zzdpi = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdpe, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdls, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdmi, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdly, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdms, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdpf);
        SafeParcelWriter.writeString(parcel, 9, this.zzdpg, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdph, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzdpi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
