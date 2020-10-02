package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@SafeParcelable.Class(creator = "VideoCapabilitiesCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class VideoCapabilities extends zzc {
    public static final Parcelable.Creator<VideoCapabilities> CREATOR = new zza();
    @SafeParcelable.Field(getter = "isCameraSupported", mo15196id = 1)
    private final boolean zzsg;
    @SafeParcelable.Field(getter = "isMicSupported", mo15196id = 2)
    private final boolean zzsh;
    @SafeParcelable.Field(getter = "isWriteStorageSupported", mo15196id = 3)
    private final boolean zzsi;
    @SafeParcelable.Field(getter = "getSupportedCaptureModes", mo15196id = 4)
    private final boolean[] zzsj;
    @SafeParcelable.Field(getter = "getSupportedQualityLevels", mo15196id = 5)
    private final boolean[] zzsk;

    @SafeParcelable.Constructor
    public VideoCapabilities(@SafeParcelable.Param(mo15199id = 1) boolean z, @SafeParcelable.Param(mo15199id = 2) boolean z2, @SafeParcelable.Param(mo15199id = 3) boolean z3, @SafeParcelable.Param(mo15199id = 4) boolean[] zArr, @SafeParcelable.Param(mo15199id = 5) boolean[] zArr2) {
        this.zzsg = z;
        this.zzsh = z2;
        this.zzsi = z3;
        this.zzsj = zArr;
        this.zzsk = zArr2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof VideoCapabilities)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
        return Objects.equal(videoCapabilities.getSupportedCaptureModes(), getSupportedCaptureModes()) && Objects.equal(videoCapabilities.getSupportedQualityLevels(), getSupportedQualityLevels()) && Objects.equal(Boolean.valueOf(videoCapabilities.isCameraSupported()), Boolean.valueOf(isCameraSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isMicSupported()), Boolean.valueOf(isMicSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isWriteStorageSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public final boolean[] getSupportedCaptureModes() {
        return this.zzsj;
    }

    public final boolean[] getSupportedQualityLevels() {
        return this.zzsk;
    }

    public final int hashCode() {
        return Objects.hashCode(getSupportedCaptureModes(), getSupportedQualityLevels(), Boolean.valueOf(isCameraSupported()), Boolean.valueOf(isMicSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public final boolean isCameraSupported() {
        return this.zzsg;
    }

    public final boolean isFullySupported(int i, int i2) {
        return this.zzsg && this.zzsh && this.zzsi && supportsCaptureMode(i) && supportsQualityLevel(i2);
    }

    public final boolean isMicSupported() {
        return this.zzsh;
    }

    public final boolean isWriteStorageSupported() {
        return this.zzsi;
    }

    public final boolean supportsCaptureMode(int i) {
        Preconditions.checkState(VideoConfiguration.isValidCaptureMode(i, false));
        return this.zzsj[i];
    }

    public final boolean supportsQualityLevel(int i) {
        Preconditions.checkState(VideoConfiguration.isValidQualityLevel(i, false));
        return this.zzsk[i];
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("SupportedCaptureModes", getSupportedCaptureModes()).add("SupportedQualityLevels", getSupportedQualityLevels()).add("CameraSupported", Boolean.valueOf(isCameraSupported())).add("MicSupported", Boolean.valueOf(isMicSupported())).add("StorageWriteSupported", Boolean.valueOf(isWriteStorageSupported())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isCameraSupported());
        SafeParcelWriter.writeBoolean(parcel, 2, isMicSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, isWriteStorageSupported());
        SafeParcelWriter.writeBooleanArray(parcel, 4, getSupportedCaptureModes(), false);
        SafeParcelWriter.writeBooleanArray(parcel, 5, getSupportedQualityLevels(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
