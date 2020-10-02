package p119j;

import com.loopj.android.http.C4250c;
import java.nio.charset.Charset;

/* renamed from: j.w */
/* compiled from: Util */
final class C6597w {

    /* renamed from: a */
    public static final Charset f17172a = Charset.forName(C4250c.DEFAULT_CHARSET);

    /* renamed from: a */
    public static int m21671a(int i) {
        return ((i & 255) << 24) | ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* renamed from: a */
    public static short m21672a(short s) {
        short s2 = s & 65535;
        return (short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8));
    }

    /* renamed from: a */
    public static void m21673a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    /* renamed from: b */
    private static <T extends Throwable> void m21676b(Throwable th) throws Throwable {
        throw th;
    }

    /* renamed from: a */
    public static void m21674a(Throwable th) {
        m21676b(th);
        throw null;
    }

    /* renamed from: a */
    public static boolean m21675a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
