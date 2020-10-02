package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.games.internal.zzd;
import java.util.ArrayList;
import java.util.List;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "AppContentCardEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class AppContentCardEntity extends zzc implements zze {
    public static final Parcelable.Creator<AppContentCardEntity> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 6)
    private final String description;
    @SafeParcelable.Field(getter = "getExtras", mo15196id = 7)
    private final Bundle extras;
    @SafeParcelable.Field(getter = "getType", mo15196id = 13)
    private final String type;
    @SafeParcelable.Field(getter = "getTitle", mo15196id = 11)
    private final String zzca;
    @SafeParcelable.Field(getter = "getConditions", mo15196id = 3)
    private final ArrayList<AppContentConditionEntity> zzfr;
    @SafeParcelable.Field(getter = "getContentDescription", mo15196id = 4)
    private final String zzfs;
    @SafeParcelable.Field(getter = "getId", mo15196id = 14)
    private final String zzft;
    @SafeParcelable.Field(getter = "getActions", mo15196id = 1)
    private final ArrayList<AppContentActionEntity> zzgc;
    @SafeParcelable.Field(getter = "getAnnotations", mo15196id = 2)
    private final ArrayList<AppContentAnnotationEntity> zzgd;
    @SafeParcelable.Field(getter = "getCurrentProgress", mo15196id = 5)
    private final int zzge;
    @SafeParcelable.Field(getter = "getSubtitle", mo15196id = 10)
    private final String zzgf;
    @SafeParcelable.Field(getter = "getTotalProgress", mo15196id = 12)
    private final int zzgg;

    @SafeParcelable.Constructor
    AppContentCardEntity(@SafeParcelable.Param(mo15199id = 1) ArrayList<AppContentActionEntity> arrayList, @SafeParcelable.Param(mo15199id = 2) ArrayList<AppContentAnnotationEntity> arrayList2, @SafeParcelable.Param(mo15199id = 3) ArrayList<AppContentConditionEntity> arrayList3, @SafeParcelable.Param(mo15199id = 4) String str, @SafeParcelable.Param(mo15199id = 5) int i, @SafeParcelable.Param(mo15199id = 6) String str2, @SafeParcelable.Param(mo15199id = 7) Bundle bundle, @SafeParcelable.Param(mo15199id = 10) String str3, @SafeParcelable.Param(mo15199id = 11) String str4, @SafeParcelable.Param(mo15199id = 12) int i2, @SafeParcelable.Param(mo15199id = 13) String str5, @SafeParcelable.Param(mo15199id = 14) String str6) {
        this.zzgc = arrayList;
        this.zzgd = arrayList2;
        this.zzfr = arrayList3;
        this.zzfs = str;
        this.zzge = i;
        this.description = str2;
        this.extras = bundle;
        this.zzft = str6;
        this.zzgf = str3;
        this.zzca = str4;
        this.zzgg = i2;
        this.type = str5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zze)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zze zze = (zze) obj;
        if (!Objects.equal(zze.getActions(), getActions()) || !Objects.equal(zze.zzap(), zzap()) || !Objects.equal(zze.zzag(), zzag()) || !Objects.equal(zze.zzah(), zzah()) || !Objects.equal(Integer.valueOf(zze.zzaq()), Integer.valueOf(zzaq())) || !Objects.equal(zze.getDescription(), getDescription()) || !zzd.zza(zze.getExtras(), getExtras()) || !Objects.equal(zze.getId(), getId()) || !Objects.equal(zze.zzar(), zzar()) || !Objects.equal(zze.getTitle(), getTitle()) || !Objects.equal(Integer.valueOf(zze.zzas()), Integer.valueOf(zzas())) || !Objects.equal(zze.getType(), getType())) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final List<zza> getActions() {
        return new ArrayList(this.zzgc);
    }

    public final String getDescription() {
        return this.description;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getId() {
        return this.zzft;
    }

    public final String getTitle() {
        return this.zzca;
    }

    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(getActions(), zzap(), zzag(), zzah(), Integer.valueOf(zzaq()), getDescription(), Integer.valueOf(zzd.zza(getExtras())), getId(), zzar(), getTitle(), Integer.valueOf(zzas()), getType());
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Actions", getActions()).add("Annotations", zzap()).add("Conditions", zzag()).add("ContentDescription", zzah()).add("CurrentSteps", Integer.valueOf(zzaq())).add("Description", getDescription()).add("Extras", getExtras()).add("Id", getId()).add("Subtitle", zzar()).add("Title", getTitle()).add("TotalSteps", Integer.valueOf(zzas())).add("Type", getType()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getActions(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, zzap(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, zzag(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzfs, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzge);
        SafeParcelWriter.writeString(parcel, 6, this.description, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.extras, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzgf, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzca, false);
        SafeParcelWriter.writeInt(parcel, 12, this.zzgg);
        SafeParcelWriter.writeString(parcel, 13, this.type, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzft, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<zzf> zzag() {
        return new ArrayList(this.zzfr);
    }

    public final String zzah() {
        return this.zzfs;
    }

    public final List<zzb> zzap() {
        return new ArrayList(this.zzgd);
    }

    public final int zzaq() {
        return this.zzge;
    }

    public final String zzar() {
        return this.zzgf;
    }

    public final int zzas() {
        return this.zzgg;
    }
}
