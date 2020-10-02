package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzja implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzja> CREATOR = new zzjc();
    private int zzahb;
    private final zza[] zzanm;
    public final int zzann;

    /* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new zzje();
        private final byte[] data;
        private final String mimeType;
        /* access modifiers changed from: private */
        public final UUID uuid;
        private int zzahb;
        public final boolean zzanq;

        public zza(UUID uuid2, String str, byte[] bArr) {
            this(uuid2, str, bArr, false);
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zza = (zza) obj;
            return this.mimeType.equals(zza.mimeType) && zzov.zza(this.uuid, zza.uuid) && Arrays.equals(this.data, zza.data);
        }

        public final int hashCode() {
            if (this.zzahb == 0) {
                this.zzahb = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.zzahb;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.zzanq ? (byte) 1 : 0);
        }

        private zza(UUID uuid2, String str, byte[] bArr, boolean z) {
            this.uuid = (UUID) zzoh.checkNotNull(uuid2);
            this.mimeType = (String) zzoh.checkNotNull(str);
            this.data = (byte[]) zzoh.checkNotNull(bArr);
            this.zzanq = false;
        }

        zza(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.zzanq = parcel.readByte() != 0;
        }
    }

    public zzja(zza... zzaArr) {
        this(true, zzaArr);
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zza zza2 = (zza) obj;
        zza zza3 = (zza) obj2;
        if (zzgr.zzadl.equals(zza2.uuid)) {
            return zzgr.zzadl.equals(zza3.uuid) ? 0 : 1;
        }
        return zza2.uuid.compareTo(zza3.uuid);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzja.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzanm, ((zzja) obj).zzanm);
    }

    public final int hashCode() {
        if (this.zzahb == 0) {
            this.zzahb = Arrays.hashCode(this.zzanm);
        }
        return this.zzahb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzanm, 0);
    }

    public final zza zzaa(int i) {
        return this.zzanm[i];
    }

    private zzja(boolean z, zza... zzaArr) {
        zza[] zzaArr2 = (zza[]) zzaArr.clone();
        Arrays.sort(zzaArr2, this);
        int i = 1;
        while (i < zzaArr2.length) {
            if (!zzaArr2[i - 1].uuid.equals(zzaArr2[i].uuid)) {
                i++;
            } else {
                String valueOf = String.valueOf(zzaArr2[i].uuid);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.zzanm = zzaArr2;
        this.zzann = zzaArr2.length;
    }

    zzja(Parcel parcel) {
        zza[] zzaArr = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzanm = zzaArr;
        this.zzann = zzaArr.length;
    }
}
