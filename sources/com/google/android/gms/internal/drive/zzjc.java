package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzjc implements Serializable, Iterable<Byte> {
    public static final zzjc zznq = new zzjm(zzkm.zzsn);
    private static final zzji zznr = (zzix.zzbr() ? new zzjn((zzjd) null) : new zzjg((zzjd) null));
    private static final Comparator<zzjc> zznt = new zzje();
    private int zzns = 0;

    zzjc() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public static zzjc zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzjm(zznr.zzc(bArr, i, i2));
    }

    public static zzjc zzk(String str) {
        return new zzjm(str.getBytes(zzkm.UTF_8));
    }

    static zzjk zzu(int i) {
        return new zzjk(i, (zzjd) null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzns;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzns = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzjd(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzjc zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzjb zzjb) throws IOException;

    public final String zzbt() {
        return size() == 0 ? "" : zza(zzkm.UTF_8);
    }

    public abstract boolean zzbu();

    /* access modifiers changed from: protected */
    public final int zzbv() {
        return this.zzns;
    }

    public abstract byte zzs(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzt(int i);

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }
}
