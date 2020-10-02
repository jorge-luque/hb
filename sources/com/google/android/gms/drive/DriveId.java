package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.drive.zzbn;
import com.google.android.gms.internal.drive.zzbs;
import com.google.android.gms.internal.drive.zzdp;
import com.google.android.gms.internal.drive.zzfb;
import com.google.android.gms.internal.drive.zzfd;
import com.google.android.gms.internal.drive.zzjx;
import com.google.android.gms.internal.drive.zzkk;
import com.google.android.gms.internal.drive.zzkq;

@SafeParcelable.Class(creator = "DriveIdCreator")
@SafeParcelable.Reserved({1})
public class DriveId extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new zzk();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    @SafeParcelable.Field(mo15196id = 2)
    private final String zzad;
    @SafeParcelable.Field(mo15196id = 3)
    private final long zzae;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.drive.DriveId.RESOURCE_TYPE_UNKNOWN", mo15196id = 5)
    private final int zzaf;
    private volatile String zzag = null;
    @SafeParcelable.Field(mo15196id = 4)
    private final long zzf;
    private volatile String zzh = null;

    @SafeParcelable.Constructor
    public DriveId(@SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) long j, @SafeParcelable.Param(mo15199id = 4) long j2, @SafeParcelable.Param(mo15199id = 5) int i) {
        this.zzad = str;
        boolean z = true;
        Preconditions.checkArgument(!"".equals(str));
        if (str == null && j == -1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zzae = j;
        this.zzf = j2;
        this.zzaf = i;
    }

    public static DriveId decodeFromString(String str) {
        boolean startsWith = str.startsWith("DriveId:");
        String valueOf = String.valueOf(str);
        Preconditions.checkArgument(startsWith, valueOf.length() != 0 ? "Invalid DriveId: ".concat(valueOf) : new String("Invalid DriveId: "));
        return zza(Base64.decode(str.substring(8), 10));
    }

    @VisibleForTesting
    public static DriveId zza(String str) {
        Preconditions.checkNotNull(str);
        return new DriveId(str, -1, -1, -1);
    }

    public DriveFile asDriveFile() {
        if (this.zzaf != 1) {
            return new zzbn(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }

    public DriveFolder asDriveFolder() {
        if (this.zzaf != 0) {
            return new zzbs(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }

    public DriveResource asDriveResource() {
        int i = this.zzaf;
        if (i == 1) {
            return asDriveFolder();
        }
        if (i == 0) {
            return asDriveFile();
        }
        return new zzdp(this);
    }

    public final String encodeToString() {
        if (this.zzh == null) {
            zzfb.zza zzm = zzfb.zzan().zzm(1);
            String str = this.zzad;
            if (str == null) {
                str = "";
            }
            String valueOf = String.valueOf(Base64.encodeToString(((zzfb) ((zzkk) zzm.zze(str).zzg(this.zzae).zzh(this.zzf).zzn(this.zzaf).zzdf())).toByteArray(), 10));
            this.zzh = valueOf.length() != 0 ? "DriveId:".concat(valueOf) : new String("DriveId:");
        }
        return this.zzh;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj != null && obj.getClass() == DriveId.class) {
            DriveId driveId = (DriveId) obj;
            if (driveId.zzf != this.zzf) {
                return false;
            }
            if (driveId.zzae == -1 && this.zzae == -1) {
                return driveId.zzad.equals(this.zzad);
            }
            String str2 = this.zzad;
            if (str2 == null || (str = driveId.zzad) == null) {
                if (driveId.zzae == this.zzae) {
                    return true;
                }
            } else if (driveId.zzae != this.zzae || !str.equals(str2)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public String getResourceId() {
        return this.zzad;
    }

    public int getResourceType() {
        return this.zzaf;
    }

    public int hashCode() {
        if (this.zzae == -1) {
            return this.zzad.hashCode();
        }
        String valueOf = String.valueOf(String.valueOf(this.zzf));
        String valueOf2 = String.valueOf(String.valueOf(this.zzae));
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzag == null) {
            this.zzag = Base64.encodeToString(((zzfd) ((zzkk) zzfd.zzap().zzi(this.zzae).zzj(this.zzf).zzdf())).toByteArray(), 10);
        }
        return this.zzag;
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzad, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzae);
        SafeParcelWriter.writeLong(parcel, 4, this.zzf);
        SafeParcelWriter.writeInt(parcel, 5, this.zzaf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @VisibleForTesting
    private static DriveId zza(byte[] bArr) {
        String str;
        try {
            zzfb zza = zzfb.zza(bArr, zzjx.zzcj());
            if ("".equals(zza.getResourceId())) {
                str = null;
            } else {
                str = zza.getResourceId();
            }
            return new DriveId(str, zza.zzal(), zza.zzam(), zza.getResourceType());
        } catch (zzkq unused) {
            throw new IllegalArgumentException();
        }
    }
}
