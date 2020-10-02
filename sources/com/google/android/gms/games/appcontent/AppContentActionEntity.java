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
@SafeParcelable.Class(creator = "AppContentActionEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class AppContentActionEntity extends zzc implements zza {
    public static final Parcelable.Creator<AppContentActionEntity> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getExtras", mo15196id = 3)
    private final Bundle extras;
    @SafeParcelable.Field(getter = "getType", mo15196id = 6)
    private final String type;
    @SafeParcelable.Field(getter = "getConditions", mo15196id = 1)
    private final ArrayList<AppContentConditionEntity> zzfr;
    @SafeParcelable.Field(getter = "getContentDescription", mo15196id = 2)
    private final String zzfs;
    @SafeParcelable.Field(getter = "getId", mo15196id = 7)
    private final String zzft;
    @SafeParcelable.Field(getter = "getAnnotation", mo15196id = 8)
    private final AppContentAnnotationEntity zzfu;
    @SafeParcelable.Field(getter = "getOverflowText", mo15196id = 9)
    private final String zzfv;

    @SafeParcelable.Constructor
    AppContentActionEntity(@SafeParcelable.Param(mo15199id = 1) ArrayList<AppContentConditionEntity> arrayList, @SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) Bundle bundle, @SafeParcelable.Param(mo15199id = 6) String str2, @SafeParcelable.Param(mo15199id = 7) String str3, @SafeParcelable.Param(mo15199id = 8) AppContentAnnotationEntity appContentAnnotationEntity, @SafeParcelable.Param(mo15199id = 9) String str4) {
        this.zzfu = appContentAnnotationEntity;
        this.zzfr = arrayList;
        this.zzfs = str;
        this.extras = bundle;
        this.zzft = str3;
        this.zzfv = str4;
        this.type = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zza zza = (zza) obj;
        if (!Objects.equal(zza.zzaf(), zzaf()) || !Objects.equal(zza.zzag(), zzag()) || !Objects.equal(zza.zzah(), zzah()) || !zzd.zza(zza.getExtras(), getExtras()) || !Objects.equal(zza.getId(), getId()) || !Objects.equal(zza.zzai(), zzai()) || !Objects.equal(zza.getType(), getType())) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getId() {
        return this.zzft;
    }

    public final String getType() {
        return this.type;
    }

    public final int hashCode() {
        return Objects.hashCode(zzaf(), zzag(), zzah(), Integer.valueOf(zzd.zza(getExtras())), getId(), zzai(), getType());
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Annotation", zzaf()).add("Conditions", zzag()).add("ContentDescription", zzah()).add("Extras", getExtras()).add("Id", getId()).add("OverflowText", zzai()).add("Type", getType()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, zzag(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzfs, false);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeString(parcel, 6, this.type, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzft, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzfu, i, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzfv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzb zzaf() {
        return this.zzfu;
    }

    public final List<zzf> zzag() {
        return new ArrayList(this.zzfr);
    }

    public final String zzah() {
        return this.zzfs;
    }

    public final String zzai() {
        return this.zzfv;
    }
}
