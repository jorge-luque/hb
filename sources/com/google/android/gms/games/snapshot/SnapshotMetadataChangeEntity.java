package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotMetadataChangeCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class SnapshotMetadataChangeEntity extends zzc implements SnapshotMetadataChange {
    public static final Parcelable.Creator<SnapshotMetadataChangeEntity> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 1)
    private final String description;
    @SafeParcelable.Field(getter = "getProgressValue", mo15196id = 6)
    private final Long zzrc;
    @SafeParcelable.Field(getter = "getCoverImageUri", mo15196id = 4)
    private final Uri zzre;
    @SafeParcelable.Field(getter = "getPlayedTimeMillis", mo15196id = 2)
    private final Long zzrf;
    @SafeParcelable.Field(getter = "getCoverImageTeleporter", mo15196id = 5)
    private BitmapTeleporter zzrg;

    SnapshotMetadataChangeEntity() {
        this((String) null, (Long) null, (BitmapTeleporter) null, (Uri) null, (Long) null);
    }

    public final Bitmap getCoverImage() {
        BitmapTeleporter bitmapTeleporter = this.zzrg;
        if (bitmapTeleporter == null) {
            return null;
        }
        return bitmapTeleporter.get();
    }

    public final String getDescription() {
        return this.description;
    }

    public final Long getPlayedTimeMillis() {
        return this.zzrf;
    }

    public final Long getProgressValue() {
        return this.zzrc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getDescription(), false);
        SafeParcelWriter.writeLongObject(parcel, 2, getPlayedTimeMillis(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzre, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzrg, i, false);
        SafeParcelWriter.writeLongObject(parcel, 6, getProgressValue(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final BitmapTeleporter zzds() {
        return this.zzrg;
    }

    @SafeParcelable.Constructor
    SnapshotMetadataChangeEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) Long l, @SafeParcelable.Param(mo15199id = 5) BitmapTeleporter bitmapTeleporter, @SafeParcelable.Param(mo15199id = 4) Uri uri, @SafeParcelable.Param(mo15199id = 6) Long l2) {
        this.description = str;
        this.zzrf = l;
        this.zzrg = bitmapTeleporter;
        this.zzre = uri;
        this.zzrc = l2;
        Preconditions.checkState(bitmapTeleporter == null || uri == null, "Cannot set both a URI and an image");
    }
}
