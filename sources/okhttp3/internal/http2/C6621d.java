package okhttp3.internal.http2;

import java.io.IOException;
import p113i.p114e0.C3500c;
import p119j.C3581f;

/* renamed from: okhttp3.internal.http2.d */
/* compiled from: Http2 */
public final class C6621d {

    /* renamed from: a */
    static final C3581f f17356a = C3581f.m12177d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    private static final String[] f17357b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c */
    static final String[] f17358c = new String[64];

    /* renamed from: d */
    static final String[] f17359d = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f17359d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = C3500c.m11639a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f17358c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            f17358c[i4 | 8] = f17358c[i4] + "|PADDED";
        }
        String[] strArr3 = f17358c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr4 = f17358c;
                int i9 = i8 | i6;
                strArr4[i9] = f17358c[i8] + '|' + f17358c[i6];
                f17358c[i9 | 8] = f17358c[i8] + '|' + f17358c[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr5 = f17358c;
            if (i < strArr5.length) {
                if (strArr5[i] == null) {
                    strArr5[i] = f17359d[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private C6621d() {
    }

    /* renamed from: a */
    static IllegalArgumentException m21771a(String str, Object... objArr) {
        throw new IllegalArgumentException(C3500c.m11639a(str, objArr));
    }

    /* renamed from: b */
    static IOException m21774b(String str, Object... objArr) throws IOException {
        throw new IOException(C3500c.m11639a(str, objArr));
    }

    /* renamed from: a */
    static String m21773a(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f17357b;
        String a = b < strArr.length ? strArr[b] : C3500c.m11639a("0x%02x", Byte.valueOf(b));
        String a2 = m21772a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a;
        objArr[4] = a2;
        return C3500c.m11639a("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: a */
    static String m21772a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (!(b == 2 || b == 3)) {
            if (b == 4 || b == 6) {
                if (b2 == 1) {
                    return "ACK";
                }
                return f17359d[b2];
            } else if (!(b == 7 || b == 8)) {
                String[] strArr = f17358c;
                String str = b2 < strArr.length ? strArr[b2] : f17359d[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f17359d[b2];
    }
}
