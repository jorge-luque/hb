package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ScopeCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getScopeUri", mo15196id = 2)
    private final String zzbc;
    @SafeParcelable.VersionField(mo15202id = 1)
    private final int zzq;

    @SafeParcelable.Constructor
    Scope(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) String str) {
        Preconditions.checkNotEmpty(str, "scopeUri must not be null or empty");
        this.zzq = i;
        this.zzbc = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.zzbc.equals(((Scope) obj).zzbc);
    }

    @KeepForSdk
    public final String getScopeUri() {
        return this.zzbc;
    }

    public final int hashCode() {
        return this.zzbc.hashCode();
    }

    public final String toString() {
        return this.zzbc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzq);
        SafeParcelWriter.writeString(parcel, 2, getScopeUri(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public Scope(String str) {
        this(1, str);
    }
}
