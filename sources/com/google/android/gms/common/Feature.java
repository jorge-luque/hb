package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "FeatureCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getName", mo15196id = 1)
    private final String name;
    @SafeParcelable.Field(getter = "getOldVersion", mo15196id = 2)
    @Deprecated
    private final int zzw;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getVersion", mo15196id = 3)
    private final long zzx;

    @KeepForSdk
    public Feature(String str, long j) {
        this.name = str;
        this.zzx = j;
        this.zzw = -1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() == null || !getName().equals(feature.getName())) && (getName() != null || feature.getName() != null)) || getVersion() != feature.getVersion()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @KeepForSdk
    public String getName() {
        return this.name;
    }

    @KeepForSdk
    public long getVersion() {
        long j = this.zzx;
        return j == -1 ? (long) this.zzw : j;
    }

    public int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzw);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) int i, @SafeParcelable.Param(mo15199id = 3) long j) {
        this.name = str;
        this.zzw = i;
        this.zzx = j;
    }
}
