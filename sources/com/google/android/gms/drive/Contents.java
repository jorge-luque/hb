package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@KeepForSdk
@SafeParcelable.Class(creator = "ContentsCreator")
@SafeParcelable.Reserved({1})
public class Contents extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new zzc();
    @SafeParcelable.Field(mo15196id = 4)
    private final int mode;
    @SafeParcelable.Field(mo15196id = 2)
    private final ParcelFileDescriptor zzi;
    @SafeParcelable.Field(mo15196id = 3)
    final int zzj;
    @SafeParcelable.Field(mo15196id = 5)
    private final DriveId zzk;
    @SafeParcelable.Field(mo15196id = 7)
    private final boolean zzl;
    @SafeParcelable.Field(mo15196id = 8)
    private final String zzm;

    @SafeParcelable.Constructor
    public Contents(@SafeParcelable.Param(mo15199id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(mo15199id = 3) int i, @SafeParcelable.Param(mo15199id = 4) int i2, @SafeParcelable.Param(mo15199id = 5) DriveId driveId, @SafeParcelable.Param(mo15199id = 7) boolean z, @SafeParcelable.Param(mo15199id = 8) String str) {
        this.zzi = parcelFileDescriptor;
        this.zzj = i;
        this.mode = i2;
        this.zzk = driveId;
        this.zzl = z;
        this.zzm = str;
    }

    public final DriveId getDriveId() {
        return this.zzk;
    }

    public final InputStream getInputStream() {
        return new FileInputStream(this.zzi.getFileDescriptor());
    }

    public final int getMode() {
        return this.mode;
    }

    public final OutputStream getOutputStream() {
        return new FileOutputStream(this.zzi.getFileDescriptor());
    }

    @KeepForSdk
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzi;
    }

    public final int getRequestId() {
        return this.zzj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzi, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzj);
        SafeParcelWriter.writeInt(parcel, 4, this.mode);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzk, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzl);
        SafeParcelWriter.writeString(parcel, 8, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzb() {
        return this.zzl;
    }
}
