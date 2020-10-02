package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "StockProfileImageEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class StockProfileImageEntity extends zzc implements StockProfileImage {
    public static final Parcelable.Creator<StockProfileImageEntity> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getImageUri", mo15196id = 2)
    private final Uri zzfw;
    @SafeParcelable.Field(getter = "getImageUrl", mo15196id = 1)
    private final String zzns;

    @SafeParcelable.Constructor
    public StockProfileImageEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) Uri uri) {
        this.zzns = str;
        this.zzfw = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StockProfileImage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        StockProfileImage stockProfileImage = (StockProfileImage) obj;
        return Objects.equal(this.zzns, stockProfileImage.getImageUrl()) && Objects.equal(this.zzfw, stockProfileImage.zzal());
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final String getImageUrl() {
        return this.zzns;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzns, this.zzfw);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("ImageId", this.zzns).add("ImageUri", this.zzfw).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzfw, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Uri zzal() {
        return this.zzfw;
    }
}
