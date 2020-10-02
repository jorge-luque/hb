package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class SnapshotEntity extends zzc implements Snapshot {
    public static final Parcelable.Creator<SnapshotEntity> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getMetadata", mo15196id = 1)
    private final SnapshotMetadataEntity zzqz;
    @SafeParcelable.Field(getter = "getSnapshotContents", mo15196id = 3)
    private final SnapshotContentsEntity zzra;

    @SafeParcelable.Constructor
    public SnapshotEntity(@SafeParcelable.Param(mo15199id = 1) SnapshotMetadata snapshotMetadata, @SafeParcelable.Param(mo15199id = 3) SnapshotContentsEntity snapshotContentsEntity) {
        this.zzqz = new SnapshotMetadataEntity(snapshotMetadata);
        this.zzra = snapshotContentsEntity;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Snapshot snapshot = (Snapshot) obj;
        if (!Objects.equal(snapshot.getMetadata(), getMetadata()) || !Objects.equal(snapshot.getSnapshotContents(), getSnapshotContents())) {
            return false;
        }
        return true;
    }

    public final Snapshot freeze() {
        return this;
    }

    public final SnapshotMetadata getMetadata() {
        return this.zzqz;
    }

    public final SnapshotContents getSnapshotContents() {
        if (this.zzra.isClosed()) {
            return null;
        }
        return this.zzra;
    }

    public final int hashCode() {
        return Objects.hashCode(getMetadata(), getSnapshotContents());
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Metadata", getMetadata()).add("HasContents", Boolean.valueOf(getSnapshotContents() != null)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getMetadata(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getSnapshotContents(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
