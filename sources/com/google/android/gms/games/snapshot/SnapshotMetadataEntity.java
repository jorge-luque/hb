package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotMetadataEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class SnapshotMetadataEntity extends zzc implements SnapshotMetadata {
    public static final Parcelable.Creator<SnapshotMetadataEntity> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 8)
    private final String description;
    @SafeParcelable.Field(getter = "getDeviceName", mo15196id = 15)
    private final String deviceName;
    @SafeParcelable.Field(getter = "getTitle", mo15196id = 7)
    private final String zzca;
    @SafeParcelable.Field(getter = "getSnapshotId", mo15196id = 3)
    private final String zzhv;
    @SafeParcelable.Field(getter = "getGame", mo15196id = 1)
    private final GameEntity zzlm;
    @SafeParcelable.Field(getter = "getCoverImageUri", mo15196id = 5)
    private final Uri zzre;
    @SafeParcelable.Field(getter = "getOwner", mo15196id = 2)
    private final PlayerEntity zzrh;
    @SafeParcelable.Field(getter = "getCoverImageUrl", mo15196id = 6)
    private final String zzri;
    @SafeParcelable.Field(getter = "getLastModifiedTimestamp", mo15196id = 9)
    private final long zzrj;
    @SafeParcelable.Field(getter = "getPlayedTime", mo15196id = 10)
    private final long zzrk;
    @SafeParcelable.Field(getter = "getCoverImageAspectRatio", mo15196id = 11)
    private final float zzrl;
    @SafeParcelable.Field(getter = "getUniqueName", mo15196id = 12)
    private final String zzrm;
    @SafeParcelable.Field(getter = "hasChangePending", mo15196id = 13)
    private final boolean zzrn;
    @SafeParcelable.Field(getter = "getProgressValue", mo15196id = 14)
    private final long zzro;

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this(snapshotMetadata, new PlayerEntity(snapshotMetadata.getOwner()));
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return Objects.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName());
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        return Objects.toStringHelper(snapshotMetadata).add("Game", snapshotMetadata.getGame()).add("Owner", snapshotMetadata.getOwner()).add("SnapshotId", snapshotMetadata.getSnapshotId()).add("CoverImageUri", snapshotMetadata.getCoverImageUri()).add("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).add("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).add("Description", snapshotMetadata.getDescription()).add("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).add("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).add("UniqueName", snapshotMetadata.getUniqueName()).add("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).add("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).add("DeviceName", snapshotMetadata.getDeviceName()).toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final SnapshotMetadata freeze() {
        return this;
    }

    public final float getCoverImageAspectRatio() {
        return this.zzrl;
    }

    public final Uri getCoverImageUri() {
        return this.zzre;
    }

    public final String getCoverImageUrl() {
        return this.zzri;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final Game getGame() {
        return this.zzlm;
    }

    public final long getLastModifiedTimestamp() {
        return this.zzrj;
    }

    public final Player getOwner() {
        return this.zzrh;
    }

    public final long getPlayedTime() {
        return this.zzrk;
    }

    public final long getProgressValue() {
        return this.zzro;
    }

    public final String getSnapshotId() {
        return this.zzhv;
    }

    public final String getTitle() {
        return this.zzca;
    }

    public final String getUniqueName() {
        return this.zzrm;
    }

    public final boolean hasChangePending() {
        return this.zzrn;
    }

    public final int hashCode() {
        return zza(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getOwner(), i, false);
        SafeParcelWriter.writeString(parcel, 3, getSnapshotId(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getCoverImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getCoverImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzca, false);
        SafeParcelWriter.writeString(parcel, 8, getDescription(), false);
        SafeParcelWriter.writeLong(parcel, 9, getLastModifiedTimestamp());
        SafeParcelWriter.writeLong(parcel, 10, getPlayedTime());
        SafeParcelWriter.writeFloat(parcel, 11, getCoverImageAspectRatio());
        SafeParcelWriter.writeString(parcel, 12, getUniqueName(), false);
        SafeParcelWriter.writeBoolean(parcel, 13, hasChangePending());
        SafeParcelWriter.writeLong(parcel, 14, getProgressValue());
        SafeParcelWriter.writeString(parcel, 15, getDeviceName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata, PlayerEntity playerEntity) {
        this.zzlm = new GameEntity(snapshotMetadata.getGame());
        this.zzrh = playerEntity;
        this.zzhv = snapshotMetadata.getSnapshotId();
        this.zzre = snapshotMetadata.getCoverImageUri();
        this.zzri = snapshotMetadata.getCoverImageUrl();
        this.zzrl = snapshotMetadata.getCoverImageAspectRatio();
        this.zzca = snapshotMetadata.getTitle();
        this.description = snapshotMetadata.getDescription();
        this.zzrj = snapshotMetadata.getLastModifiedTimestamp();
        this.zzrk = snapshotMetadata.getPlayedTime();
        this.zzrm = snapshotMetadata.getUniqueName();
        this.zzrn = snapshotMetadata.hasChangePending();
        this.zzro = snapshotMetadata.getProgressValue();
        this.deviceName = snapshotMetadata.getDeviceName();
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return Objects.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && Objects.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && Objects.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && Objects.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && Objects.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && Objects.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && Objects.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && Objects.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && Objects.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && Objects.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && Objects.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && Objects.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && Objects.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    @SafeParcelable.Constructor
    SnapshotMetadataEntity(@SafeParcelable.Param(mo15199id = 1) GameEntity gameEntity, @SafeParcelable.Param(mo15199id = 2) PlayerEntity playerEntity, @SafeParcelable.Param(mo15199id = 3) String str, @SafeParcelable.Param(mo15199id = 5) Uri uri, @SafeParcelable.Param(mo15199id = 6) String str2, @SafeParcelable.Param(mo15199id = 7) String str3, @SafeParcelable.Param(mo15199id = 8) String str4, @SafeParcelable.Param(mo15199id = 9) long j, @SafeParcelable.Param(mo15199id = 10) long j2, @SafeParcelable.Param(mo15199id = 11) float f, @SafeParcelable.Param(mo15199id = 12) String str5, @SafeParcelable.Param(mo15199id = 13) boolean z, @SafeParcelable.Param(mo15199id = 14) long j3, @SafeParcelable.Param(mo15199id = 15) String str6) {
        this.zzlm = gameEntity;
        this.zzrh = playerEntity;
        this.zzhv = str;
        this.zzre = uri;
        this.zzri = str2;
        this.zzrl = f;
        this.zzca = str3;
        this.description = str4;
        this.zzrj = j;
        this.zzrk = j2;
        this.zzrm = str5;
        this.zzrn = z;
        this.zzro = j3;
        this.deviceName = str6;
    }
}
