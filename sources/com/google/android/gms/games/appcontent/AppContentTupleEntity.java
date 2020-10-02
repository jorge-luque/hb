package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "AppContentTupleEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class AppContentTupleEntity extends zzc implements zzj {
    public static final Parcelable.Creator<AppContentTupleEntity> CREATOR = new zzl();
    @SafeParcelable.Field(getter = "getName", mo15196id = 1)
    private final String name;
    @SafeParcelable.Field(getter = "getValue", mo15196id = 2)
    private final String value;

    @SafeParcelable.Constructor
    AppContentTupleEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2) {
        this.name = str;
        this.value = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzj zzj = (zzj) obj;
        if (!Objects.equal(zzj.getName(), getName()) || !Objects.equal(zzj.getValue(), getValue())) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final int hashCode() {
        return Objects.hashCode(getName(), getValue());
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Name", getName()).add("Value", getValue()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.name, false);
        SafeParcelWriter.writeString(parcel, 2, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
