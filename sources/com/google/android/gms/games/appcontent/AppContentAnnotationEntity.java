package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "AppContentAnnotationEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class AppContentAnnotationEntity extends zzc implements zzb {
    public static final Parcelable.Creator<AppContentAnnotationEntity> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 1)
    private final String description;
    @SafeParcelable.Field(getter = "getTitle", mo15196id = 3)
    private final String zzca;
    @SafeParcelable.Field(getter = "getId", mo15196id = 5)
    private final String zzft;
    @SafeParcelable.Field(getter = "getImageUri", mo15196id = 2)
    private final Uri zzfw;
    @SafeParcelable.Field(getter = "getLayoutSlot", mo15196id = 6)
    private final String zzfx;
    @SafeParcelable.Field(getter = "getImageDefaultId", mo15196id = 7)
    private final String zzfy;
    @SafeParcelable.Field(getter = "getImageHeight", mo15196id = 8)
    private final int zzfz;
    @SafeParcelable.Field(getter = "getImageWidth", mo15196id = 9)
    private final int zzga;
    @SafeParcelable.Field(getter = "getModifiers", mo15196id = 10)
    private final Bundle zzgb;

    @SafeParcelable.Constructor
    AppContentAnnotationEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) Uri uri, @SafeParcelable.Param(mo15199id = 3) String str2, @SafeParcelable.Param(mo15199id = 5) String str3, @SafeParcelable.Param(mo15199id = 6) String str4, @SafeParcelable.Param(mo15199id = 7) String str5, @SafeParcelable.Param(mo15199id = 8) int i, @SafeParcelable.Param(mo15199id = 9) int i2, @SafeParcelable.Param(mo15199id = 10) Bundle bundle) {
        this.description = str;
        this.zzft = str3;
        this.zzfy = str5;
        this.zzfz = i;
        this.zzfw = uri;
        this.zzga = i2;
        this.zzfx = str4;
        this.zzgb = bundle;
        this.zzca = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzb)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzb zzb = (zzb) obj;
        if (!Objects.equal(zzb.getDescription(), getDescription()) || !Objects.equal(zzb.getId(), getId()) || !Objects.equal(zzb.zzaj(), zzaj()) || !Objects.equal(Integer.valueOf(zzb.zzak()), Integer.valueOf(zzak())) || !Objects.equal(zzb.zzal(), zzal()) || !Objects.equal(Integer.valueOf(zzb.zzan()), Integer.valueOf(zzan())) || !Objects.equal(zzb.zzao(), zzao()) || !zzd.zza(zzb.zzam(), zzam()) || !Objects.equal(zzb.getTitle(), getTitle())) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.zzft;
    }

    public final String getTitle() {
        return this.zzca;
    }

    public final int hashCode() {
        return Objects.hashCode(getDescription(), getId(), zzaj(), Integer.valueOf(zzak()), zzal(), Integer.valueOf(zzan()), zzao(), Integer.valueOf(zzd.zza(zzam())), getTitle());
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Description", getDescription()).add("Id", getId()).add("ImageDefaultId", zzaj()).add("ImageHeight", Integer.valueOf(zzak())).add("ImageUri", zzal()).add("ImageWidth", Integer.valueOf(zzan())).add("LayoutSlot", zzao()).add("Modifiers", zzam()).add("Title", getTitle()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.description, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzfw, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzca, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzft, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzfx, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzfy, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zzfz);
        SafeParcelWriter.writeInt(parcel, 9, this.zzga);
        SafeParcelWriter.writeBundle(parcel, 10, this.zzgb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzaj() {
        return this.zzfy;
    }

    public final int zzak() {
        return this.zzfz;
    }

    public final Uri zzal() {
        return this.zzfw;
    }

    public final Bundle zzam() {
        return this.zzgb;
    }

    public final int zzan() {
        return this.zzga;
    }

    public final String zzao() {
        return this.zzfx;
    }
}
