package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "AppContentConditionEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class AppContentConditionEntity extends zzc implements zzf {
    public static final Parcelable.Creator<AppContentConditionEntity> CREATOR = new zzh();
    @SafeParcelable.Field(getter = "getDefaultValue", mo15196id = 1)
    private final String zzgh;
    @SafeParcelable.Field(getter = "getExpectedValue", mo15196id = 2)
    private final String zzgi;
    @SafeParcelable.Field(getter = "getPredicate", mo15196id = 3)
    private final String zzgj;
    @SafeParcelable.Field(getter = "getPredicateParameters", mo15196id = 4)
    private final Bundle zzgk;

    @SafeParcelable.Constructor
    AppContentConditionEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2, @SafeParcelable.Param(mo15199id = 3) String str3, @SafeParcelable.Param(mo15199id = 4) Bundle bundle) {
        this.zzgh = str;
        this.zzgi = str2;
        this.zzgj = str3;
        this.zzgk = bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzf)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzf zzf = (zzf) obj;
        if (!Objects.equal(zzf.zzat(), zzat()) || !Objects.equal(zzf.zzau(), zzau()) || !Objects.equal(zzf.zzav(), zzav()) || !Objects.equal(zzf.zzaw(), zzaw())) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return Objects.hashCode(zzat(), zzau(), zzav(), zzaw());
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("DefaultValue", zzat()).add("ExpectedValue", zzau()).add("Predicate", zzav()).add("PredicateParameters", zzaw()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgj, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzat() {
        return this.zzgh;
    }

    public final String zzau() {
        return this.zzgi;
    }

    public final String zzav() {
        return this.zzgj;
    }

    public final Bundle zzaw() {
        return this.zzgk;
    }
}
