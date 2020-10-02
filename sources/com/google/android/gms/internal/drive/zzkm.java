package com.google.android.gms.internal.drive;

import com.loopj.android.http.C4250c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzkm {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName(C4250c.DEFAULT_CHARSET);
    public static final byte[] zzsn;
    private static final ByteBuffer zzso;
    private static final zzjo zzsp;

    static {
        byte[] bArr = new byte[0];
        zzsn = bArr;
        zzso = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzsn;
        zzsp = zzjo.zza(bArr2, 0, bArr2.length, false);
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzd(byte[] bArr) {
        return zznf.zzd(bArr);
    }

    public static int zze(boolean z) {
        return z ? 1231 : 1237;
    }

    public static String zze(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    static boolean zzf(zzlq zzlq) {
        return false;
    }

    public static int zzu(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zza(Object obj, Object obj2) {
        return ((zzlq) obj).zzcy().zza((zzlq) obj2).zzde();
    }
}
