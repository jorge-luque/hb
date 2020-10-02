package com.google.zxing.p140k.p142c;

import com.google.zxing.C4063c;
import com.google.zxing.WriterException;
import com.google.zxing.common.reedsolomon.C4064a;
import com.google.zxing.common.reedsolomon.C4066c;
import com.google.zxing.p134g.C4079a;
import com.google.zxing.p134g.C4081c;
import com.google.zxing.p140k.p141b.C4127a;
import com.google.zxing.p140k.p141b.C4128b;
import com.google.zxing.p140k.p141b.C4129c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.google.zxing.k.c.c */
/* compiled from: Encoder */
public final class C4134c {

    /* renamed from: a */
    private static final int[] f11090a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: com.google.zxing.k.c.c$a */
    /* compiled from: Encoder */
    static /* synthetic */ class C4135a {

        /* renamed from: a */
        static final /* synthetic */ int[] f11091a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.zxing.k.b.b[] r0 = com.google.zxing.p140k.p141b.C4128b.m13787b()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11091a = r0
                com.google.zxing.k.b.b r1 = com.google.zxing.p140k.p141b.C4128b.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11091a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.k.b.b r1 = com.google.zxing.p140k.p141b.C4128b.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f11091a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.k.b.b r1 = com.google.zxing.p140k.p141b.C4128b.BYTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f11091a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.k.b.b r1 = com.google.zxing.p140k.p141b.C4128b.KANJI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p140k.p142c.C4134c.C4135a.<clinit>():void");
        }
    }

    /* renamed from: a */
    private static int m13814a(C4133b bVar) {
        return C4136d.m13833a(bVar) + C4136d.m13838b(bVar) + C4136d.m13839c(bVar) + C4136d.m13840d(bVar);
    }

    /* renamed from: b */
    static void m13832b(CharSequence charSequence, C4079a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                aVar.mo28316a((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    aVar.mo28316a((charAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    aVar.mo28316a(charAt, 4);
                }
            }
        }
    }

    /* renamed from: a */
    public static C4138f m13819a(String str, C4127a aVar, Map<C4063c, ?> map) throws WriterException {
        C4129c cVar;
        C4081c a;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(C4063c.CHARACTER_SET);
        String obj = z2 ? map.get(C4063c.CHARACTER_SET).toString() : "ISO-8859-1";
        C4128b a2 = m13816a(str, obj);
        C4079a aVar2 = new C4079a();
        if (a2 == C4128b.BYTE && z2 && (a = C4081c.m13616a(obj)) != null) {
            m13823a(a, aVar2);
        }
        if (map == null || !map.containsKey(C4063c.GS1_FORMAT)) {
            z = false;
        }
        if (z && Boolean.valueOf(map.get(C4063c.GS1_FORMAT).toString()).booleanValue()) {
            m13824a(C4128b.FNC1_FIRST_POSITION, aVar2);
        }
        m13824a(a2, aVar2);
        C4079a aVar3 = new C4079a();
        m13828a(str, a2, aVar3, obj);
        if (map == null || !map.containsKey(C4063c.QR_VERSION)) {
            cVar = m13818a(aVar, a2, aVar2, aVar3);
        } else {
            cVar = C4129c.m13790a(Integer.parseInt(map.get(C4063c.QR_VERSION).toString()));
            if (!m13829a(m13813a(a2, aVar2, aVar3, cVar), cVar, aVar)) {
                throw new WriterException("Data too big for requested version");
            }
        }
        C4079a aVar4 = new C4079a();
        aVar4.mo28318a(aVar2);
        m13822a(a2 == C4128b.BYTE ? aVar3.mo28321b() : str.length(), cVar, a2, aVar4);
        aVar4.mo28318a(aVar3);
        C4129c.C4131b a3 = cVar.mo28397a(aVar);
        int b = cVar.mo28398b() - a3.mo28406d();
        m13821a(b, aVar4);
        C4079a a4 = m13815a(aVar4, cVar.mo28398b(), b, a3.mo28405c());
        C4138f fVar = new C4138f();
        fVar.mo28419a(aVar);
        fVar.mo28420a(a2);
        fVar.mo28421a(cVar);
        int a5 = cVar.mo28396a();
        C4133b bVar = new C4133b(a5, a5);
        int a6 = m13812a(a4, aVar, cVar, bVar);
        fVar.mo28418a(a6);
        C4137e.m13845a(a4, aVar, cVar, a6, bVar);
        fVar.mo28422a(bVar);
        return fVar;
    }

    /* renamed from: a */
    private static C4129c m13818a(C4127a aVar, C4128b bVar, C4079a aVar2, C4079a aVar3) throws WriterException {
        return m13817a(m13813a(bVar, aVar2, aVar3, m13817a(m13813a(bVar, aVar2, aVar3, C4129c.m13790a(1)), aVar)), aVar);
    }

    /* renamed from: a */
    private static int m13813a(C4128b bVar, C4079a aVar, C4079a aVar2, C4129c cVar) {
        return aVar.mo28315a() + bVar.mo28395a(cVar) + aVar2.mo28315a();
    }

    /* renamed from: a */
    static int m13811a(int i) {
        int[] iArr = f11090a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    /* renamed from: a */
    private static C4128b m13816a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && m13830a(str)) {
            return C4128b.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (m13811a((int) charAt) == -1) {
                return C4128b.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return C4128b.ALPHANUMERIC;
        }
        if (z2) {
            return C4128b.NUMERIC;
        }
        return C4128b.BYTE;
    }

    /* renamed from: a */
    private static boolean m13830a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                byte b = bytes[i] & 255;
                if ((b < 129 || b > 159) && (b < 224 || b > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static int m13812a(C4079a aVar, C4127a aVar2, C4129c cVar, C4133b bVar) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            C4137e.m13845a(aVar, aVar2, cVar, i3, bVar);
            int a = m13814a(bVar);
            if (a < i) {
                i2 = i3;
                i = a;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static C4129c m13817a(int i, C4127a aVar) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            C4129c a = C4129c.m13790a(i2);
            if (m13829a(i, a, aVar)) {
                return a;
            }
        }
        throw new WriterException("Data too big");
    }

    /* renamed from: a */
    private static boolean m13829a(int i, C4129c cVar, C4127a aVar) {
        return cVar.mo28398b() - cVar.mo28397a(aVar).mo28406d() >= (i + 7) / 8;
    }

    /* renamed from: a */
    static void m13821a(int i, C4079a aVar) throws WriterException {
        int i2 = i << 3;
        if (aVar.mo28315a() <= i2) {
            for (int i3 = 0; i3 < 4 && aVar.mo28315a() < i2; i3++) {
                aVar.mo28319a(false);
            }
            int a = aVar.mo28315a() & 7;
            if (a > 0) {
                while (a < 8) {
                    aVar.mo28319a(false);
                    a++;
                }
            }
            int b = i - aVar.mo28321b();
            for (int i4 = 0; i4 < b; i4++) {
                aVar.mo28316a((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (aVar.mo28315a() != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + aVar.mo28315a() + " > " + i2);
    }

    /* renamed from: a */
    static void m13820a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new WriterException("EC bytes mismatch");
            } else if (i3 != i6 + i5) {
                throw new WriterException("RS blocks mismatch");
            } else if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
            } else {
                iArr[0] = i10;
                iArr2[0] = i12;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    /* renamed from: a */
    static C4079a m13815a(C4079a aVar, int i, int i2, int i3) throws WriterException {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (aVar.mo28321b() == i5) {
            ArrayList<C4132a> arrayList = new ArrayList<>(i6);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                m13820a(i, i2, i3, i10, iArr, iArr2);
                int i11 = iArr[0];
                byte[] bArr = new byte[i11];
                aVar.mo28317a(i7 << 3, bArr, 0, i11);
                byte[] a = m13831a(bArr, iArr2[0]);
                arrayList.add(new C4132a(bArr, a));
                i8 = Math.max(i8, i11);
                i9 = Math.max(i9, a.length);
                i7 += iArr[0];
            }
            if (i5 == i7) {
                C4079a aVar2 = new C4079a();
                for (int i12 = 0; i12 < i8; i12++) {
                    for (C4132a a2 : arrayList) {
                        byte[] a3 = a2.mo28407a();
                        if (i12 < a3.length) {
                            aVar2.mo28316a(a3[i12], 8);
                        }
                    }
                }
                for (int i13 = 0; i13 < i9; i13++) {
                    for (C4132a b : arrayList) {
                        byte[] b2 = b.mo28408b();
                        if (i13 < b2.length) {
                            aVar2.mo28316a(b2[i13], 8);
                        }
                    }
                }
                if (i4 == aVar2.mo28321b()) {
                    return aVar2;
                }
                throw new WriterException("Interleaving error: " + i4 + " and " + aVar2.mo28321b() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    /* renamed from: a */
    static byte[] m13831a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new C4066c(C4064a.f10905k).mo28288a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    /* renamed from: a */
    static void m13824a(C4128b bVar, C4079a aVar) {
        aVar.mo28316a(bVar.mo28394a(), 4);
    }

    /* renamed from: a */
    static void m13822a(int i, C4129c cVar, C4128b bVar, C4079a aVar) throws WriterException {
        int a = bVar.mo28395a(cVar);
        int i2 = 1 << a;
        if (i < i2) {
            aVar.mo28316a(i, a);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    /* renamed from: a */
    static void m13828a(String str, C4128b bVar, C4079a aVar, String str2) throws WriterException {
        int i = C4135a.f11091a[bVar.ordinal()];
        if (i == 1) {
            m13832b(str, aVar);
        } else if (i == 2) {
            m13825a((CharSequence) str, aVar);
        } else if (i == 3) {
            m13827a(str, aVar, str2);
        } else if (i == 4) {
            m13826a(str, aVar);
        } else {
            throw new WriterException("Invalid mode: ".concat(String.valueOf(bVar)));
        }
    }

    /* renamed from: a */
    static void m13825a(CharSequence charSequence, C4079a aVar) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a = m13811a((int) charSequence.charAt(i));
            if (a != -1) {
                int i2 = i + 1;
                if (i2 < length) {
                    int a2 = m13811a((int) charSequence.charAt(i2));
                    if (a2 != -1) {
                        aVar.mo28316a((a * 45) + a2, 11);
                        i += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    aVar.mo28316a(a, 6);
                    i = i2;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    /* renamed from: a */
    static void m13827a(String str, C4079a aVar, String str2) throws WriterException {
        try {
            for (byte a : str.getBytes(str2)) {
                aVar.mo28316a(a, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException((Throwable) e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m13826a(java.lang.String r6, com.google.zxing.p134g.C4079a r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x004d }
            int r0 = r6.length
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x004c
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L_0x0024
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L_0x0024
        L_0x0022:
            int r2 = r2 - r3
            goto L_0x0033
        L_0x0024:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L_0x0032
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L_0x0032
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L_0x0022
        L_0x0032:
            r2 = -1
        L_0x0033:
            if (r2 == r4) goto L_0x0044
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.mo28316a(r3, r2)
            int r1 = r1 + 2
            goto L_0x0008
        L_0x0044:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x004c:
            return
        L_0x004d:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>((java.lang.Throwable) r6)
            goto L_0x0055
        L_0x0054:
            throw r7
        L_0x0055:
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.p140k.p142c.C4134c.m13826a(java.lang.String, com.google.zxing.g.a):void");
    }

    /* renamed from: a */
    private static void m13823a(C4081c cVar, C4079a aVar) {
        aVar.mo28316a(C4128b.ECI.mo28394a(), 4);
        aVar.mo28316a(cVar.mo28338a(), 8);
    }
}
