package okhttp3.internal.publicsuffix;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import p113i.p114e0.C3500c;
import p119j.C3580e;
import p119j.C3586u;
import p119j.C6587l;
import p119j.C6589n;

public final class PublicSuffixDatabase {

    /* renamed from: e */
    private static final byte[] f17459e = {42};

    /* renamed from: f */
    private static final String[] f17460f = new String[0];

    /* renamed from: g */
    private static final String[] f17461g = {"*"};

    /* renamed from: h */
    private static final PublicSuffixDatabase f17462h = new PublicSuffixDatabase();

    /* renamed from: a */
    private final AtomicBoolean f17463a = new AtomicBoolean(false);

    /* renamed from: b */
    private final CountDownLatch f17464b = new CountDownLatch(1);

    /* renamed from: c */
    private byte[] f17465c;

    /* renamed from: d */
    private byte[] f17466d;

    /* renamed from: a */
    public static PublicSuffixDatabase m21904a() {
        return f17462h;
    }

    /* renamed from: b */
    private void m21906b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            C3580e a = C6589n.m21610a((C3586u) new C6587l(C6589n.m21616a(resourceAsStream)));
            try {
                byte[] bArr = new byte[a.readInt()];
                a.readFully(bArr);
                byte[] bArr2 = new byte[a.readInt()];
                a.readFully(bArr2);
                synchronized (this) {
                    this.f17465c = bArr;
                    this.f17466d = bArr2;
                }
                this.f17464b.countDown();
            } finally {
                C3500c.m11649a((Closeable) a);
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m21907c() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.m21906b()     // Catch:{ InterruptedIOException -> 0x0025, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002a
        L_0x0010:
            r1 = move-exception
            i.e0.i.f r2 = p113i.p114e0.p117i.C3521f.m11740d()     // Catch:{ all -> 0x000e }
            r3 = 5
            java.lang.String r4 = "Failed to read public suffix list"
            r2.mo19409a((int) r3, (java.lang.String) r4, (java.lang.Throwable) r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0024
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0024:
            return
        L_0x0025:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002a:
            if (r0 == 0) goto L_0x0033
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0033:
            goto L_0x0035
        L_0x0034:
            throw r1
        L_0x0035:
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.m21907c():void");
    }

    /* renamed from: a */
    public String mo35755a(String str) {
        int i;
        int i2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] a = m21905a(split);
            if (split.length == a.length && a[0].charAt(0) != '!') {
                return null;
            }
            if (a[0].charAt(0) == '!') {
                i2 = split.length;
                i = a.length;
            } else {
                i2 = split.length;
                i = a.length + 1;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            for (int i3 = i2 - i; i3 < split2.length; i3++) {
                sb.append(split2[i3]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        throw new NullPointerException("domain == null");
    }

    /* renamed from: a */
    private String[] m21905a(String[] strArr) {
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        int i = 0;
        if (this.f17463a.get() || !this.f17463a.compareAndSet(false, true)) {
            try {
                this.f17464b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            m21907c();
        }
        synchronized (this) {
            if (this.f17465c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(C3500c.f9709i);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = m21903a(this.f17465c, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            int i4 = 0;
            while (true) {
                if (i4 >= bArr2.length - 1) {
                    break;
                }
                bArr2[i4] = f17459e;
                str3 = m21903a(this.f17465c, bArr2, i4);
                if (str3 != null) {
                    break;
                }
                i4++;
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String a = m21903a(this.f17466d, bArr, i);
                if (a != null) {
                    str = a;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        } else if (str2 == null && str3 == null) {
            return f17461g;
        } else {
            if (str2 != null) {
                strArr2 = str2.split("\\.");
            } else {
                strArr2 = f17460f;
            }
            if (str3 != null) {
                strArr3 = str3.split("\\.");
            } else {
                strArr3 = f17460f;
            }
            return strArr2.length > strArr3.length ? strArr2 : strArr3;
        }
    }

    /* renamed from: a */
    private static String m21903a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        byte b;
        int i3;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = (i4 + length) / 2;
            while (i5 > -1 && bArr3[i5] != 10) {
                i5--;
            }
            int i6 = i5 + 1;
            int i7 = 1;
            while (true) {
                i2 = i6 + i7;
                if (bArr3[i2] == 10) {
                    break;
                }
                i7++;
            }
            int i8 = i2 - i6;
            int i9 = i;
            boolean z2 = false;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (z2) {
                    b = 46;
                    z = false;
                } else {
                    z = z2;
                    b = bArr4[i9][i10] & 255;
                }
                i3 = b - (bArr3[i6 + i11] & 255);
                if (i3 == 0) {
                    i11++;
                    i10++;
                    if (i11 == i8) {
                        break;
                    } else if (bArr4[i9].length != i10) {
                        z2 = z;
                    } else if (i9 == bArr4.length - 1) {
                        break;
                    } else {
                        i9++;
                        z2 = true;
                        i10 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i3 >= 0) {
                if (i3 <= 0) {
                    int i12 = i8 - i11;
                    int length2 = bArr4[i9].length - i10;
                    while (true) {
                        i9++;
                        if (i9 >= bArr4.length) {
                            break;
                        }
                        length2 += bArr4[i9].length;
                    }
                    if (length2 >= i12) {
                        if (length2 <= i12) {
                            return new String(bArr3, i6, i8, C3500c.f9709i);
                        }
                    }
                }
                i4 = i2 + 1;
            }
            length = i6 - 1;
        }
        return null;
    }
}
