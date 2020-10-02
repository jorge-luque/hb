package com.tapjoy.internal;

import android.support.p004v4.media.session.PlaybackStateCompat;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.EOFException;
import java.nio.charset.Charset;

/* renamed from: com.tapjoy.internal.ir */
public final class C5209ir implements C5210is, C5211it, Cloneable {

    /* renamed from: c */
    private static final byte[] f14309c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a */
    C5218iy f14310a;

    /* renamed from: b */
    long f14311b;

    /* renamed from: a */
    public final C5210is mo31391a() {
        return this;
    }

    /* renamed from: a */
    public final void mo31392a(long j) {
        if (this.f14311b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: c */
    public final byte mo31400c() {
        long j = this.f14311b;
        if (j != 0) {
            C5218iy iyVar = this.f14310a;
            int i = iyVar.f14329b;
            int i2 = iyVar.f14330c;
            int i3 = i + 1;
            byte b = iyVar.f14328a[i];
            this.f14311b = j - 1;
            if (i3 == i2) {
                this.f14310a = iyVar.mo31435a();
                C5219iz.m17549a(iyVar);
            } else {
                iyVar.f14329b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public final void close() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5209ir)) {
            return false;
        }
        C5209ir irVar = (C5209ir) obj;
        long j = this.f14311b;
        if (j != irVar.f14311b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        C5218iy iyVar = this.f14310a;
        C5218iy iyVar2 = irVar.f14310a;
        int i = iyVar.f14329b;
        int i2 = iyVar2.f14329b;
        while (j2 < this.f14311b) {
            long min = (long) Math.min(iyVar.f14330c - i, iyVar2.f14330c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (iyVar.f14328a[i] != iyVar2.f14328a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == iyVar.f14330c) {
                iyVar = iyVar.f14333f;
                i = iyVar.f14329b;
            }
            if (i2 == iyVar2.f14330c) {
                iyVar2 = iyVar2.f14333f;
                i2 = iyVar2.f14329b;
            }
            j2 += min;
        }
        return true;
    }

    public final void flush() {
    }

    /* renamed from: g */
    public final byte[] mo31415g() {
        try {
            return m17472g(this.f14311b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: h */
    public final C5209ir clone() {
        C5209ir irVar = new C5209ir();
        if (this.f14311b == 0) {
            return irVar;
        }
        C5218iy iyVar = new C5218iy(this.f14310a);
        irVar.f14310a = iyVar;
        iyVar.f14334g = iyVar;
        iyVar.f14333f = iyVar;
        C5218iy iyVar2 = this.f14310a;
        while (true) {
            iyVar2 = iyVar2.f14333f;
            if (iyVar2 != this.f14310a) {
                irVar.f14310a.f14334g.mo31436a(new C5218iy(iyVar2));
            } else {
                irVar.f14311b = this.f14311b;
                return irVar;
            }
        }
    }

    public final int hashCode() {
        C5218iy iyVar = this.f14310a;
        if (iyVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = iyVar.f14330c;
            for (int i3 = iyVar.f14329b; i3 < i2; i3++) {
                i = (i * 31) + iyVar.f14328a[i3];
            }
            iyVar = iyVar.f14333f;
        } while (iyVar != this.f14310a);
        return i;
    }

    public final String toString() {
        C5212iu iuVar;
        long j = this.f14311b;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                iuVar = C5212iu.f14313b;
            } else {
                iuVar = new C5221ja(this, i);
            }
            return iuVar.toString();
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f14311b);
    }

    /* renamed from: a */
    private void m17471a(byte[] bArr) {
        int i;
        int i2 = 0;
        while (i2 < bArr.length) {
            int length = bArr.length - i2;
            C5226je.m17567a((long) bArr.length, (long) i2, (long) length);
            C5218iy iyVar = this.f14310a;
            if (iyVar == null) {
                i = -1;
            } else {
                i = Math.min(length, iyVar.f14330c - iyVar.f14329b);
                System.arraycopy(iyVar.f14328a, iyVar.f14329b, bArr, i2, i);
                int i3 = iyVar.f14329b + i;
                iyVar.f14329b = i3;
                this.f14311b -= (long) i;
                if (i3 == iyVar.f14330c) {
                    this.f14310a = iyVar.mo31435a();
                    C5219iz.m17549a(iyVar);
                }
            }
            if (i != -1) {
                i2 += i;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: d */
    public final int mo31405d() {
        long j = this.f14311b;
        if (j >= 4) {
            C5218iy iyVar = this.f14310a;
            int i = iyVar.f14329b;
            int i2 = iyVar.f14330c;
            if (i2 - i < 4) {
                return ((mo31400c() & 255) << 24) | ((mo31400c() & 255) << 16) | ((mo31400c() & 255) << 8) | (mo31400c() & 255);
            }
            byte[] bArr = iyVar.f14328a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & 255);
            this.f14311b = j - 4;
            if (i6 == i2) {
                this.f14310a = iyVar.mo31435a();
                C5219iz.m17549a(iyVar);
            } else {
                iyVar.f14329b = i6;
            }
            return b3;
        }
        throw new IllegalStateException("size < 4: " + this.f14311b);
    }

    /* renamed from: e */
    public final int mo31408e() {
        return C5226je.m17565a(mo31405d());
    }

    /* renamed from: f */
    public final long mo31412f() {
        long j;
        long j2 = this.f14311b;
        if (j2 >= 8) {
            C5218iy iyVar = this.f14310a;
            int i = iyVar.f14329b;
            int i2 = iyVar.f14330c;
            if (i2 - i < 8) {
                j = ((((long) mo31405d()) & 4294967295L) << 32) | (4294967295L & ((long) mo31405d()));
            } else {
                byte[] bArr = iyVar.f14328a;
                int i3 = i + 1;
                int i4 = i3 + 1;
                long j3 = (((long) bArr[i3]) & 255) << 48;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                long j4 = j3 | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
                this.f14311b = j2 - 8;
                if (i10 == i2) {
                    this.f14310a = iyVar.mo31435a();
                    C5219iz.m17549a(iyVar);
                } else {
                    iyVar.f14329b = i10;
                }
                j = j4;
            }
            return C5226je.m17566a(j);
        }
        throw new IllegalStateException("size < 8: " + this.f14311b);
    }

    /* renamed from: g */
    private byte[] m17472g(long j) {
        C5226je.m17567a(this.f14311b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            m17471a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    /* renamed from: b */
    public final boolean mo31399b() {
        return this.f14311b == 0;
    }

    /* renamed from: e */
    public final C5209ir mo31413f(long j) {
        long a = C5226je.m17566a(j);
        C5218iy c = mo31401c(8);
        byte[] bArr = c.f14328a;
        int i = c.f14330c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((a >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((a >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((a >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((a >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((a >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((a >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((a >>> 8) & 255));
        bArr[i8] = (byte) ((int) (a & 255));
        c.f14330c = i8 + 1;
        this.f14311b += 8;
        return this;
    }

    /* renamed from: b */
    public final C5212iu mo31398b(long j) {
        return new C5212iu(m17472g(j));
    }

    /* renamed from: b */
    public final C5209ir mo31406d(int i) {
        int a = C5226je.m17565a(i);
        C5218iy c = mo31401c(4);
        byte[] bArr = c.f14328a;
        int i2 = c.f14330c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((a >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((a >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((a >>> 8) & 255);
        bArr[i5] = (byte) (a & 255);
        c.f14330c = i5 + 1;
        this.f14311b += 4;
        return this;
    }

    /* renamed from: c */
    public final String mo31402c(long j) {
        Charset charset = C5226je.f14342a;
        C5226je.m17567a(this.f14311b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            C5218iy iyVar = this.f14310a;
            if (((long) iyVar.f14329b) + j > ((long) iyVar.f14330c)) {
                return new String(m17472g(j), charset);
            }
            String str = new String(iyVar.f14328a, iyVar.f14329b, (int) j, charset);
            int i = (int) (((long) iyVar.f14329b) + j);
            iyVar.f14329b = i;
            this.f14311b -= j;
            if (i == iyVar.f14330c) {
                this.f14310a = iyVar.mo31435a();
                C5219iz.m17549a(iyVar);
            }
            return str;
        }
    }

    /* renamed from: a */
    public final C5209ir mo31396b(C5212iu iuVar) {
        if (iuVar != null) {
            iuVar.mo31422a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: b */
    public final long mo31394b(C5209ir irVar, long j) {
        if (irVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f14311b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            irVar.mo31393a(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    /* renamed from: a */
    public final C5209ir mo31397b(String str) {
        char charAt;
        int length = str.length();
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (length < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + length + " < 0");
        } else if (length <= str.length()) {
            int i = 0;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    C5218iy c = mo31401c(1);
                    byte[] bArr = c.f14328a;
                    int i2 = c.f14330c - i;
                    int min = Math.min(length, 8192 - i2);
                    int i3 = i + 1;
                    bArr[i + i2] = (byte) charAt2;
                    while (true) {
                        i = i3;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i4 = c.f14330c;
                            int i5 = (i2 + i) - i4;
                            c.f14330c = i4 + i5;
                            this.f14311b += (long) i5;
                        } else {
                            i3 = i + 1;
                            bArr[i + i2] = (byte) charAt;
                        }
                    }
                    int i42 = c.f14330c;
                    int i52 = (i2 + i) - i42;
                    c.f14330c = i42 + i52;
                    this.f14311b += (long) i52;
                } else {
                    if (charAt2 < 2048) {
                        mo31410e((charAt2 >> 6) | 192);
                        mo31410e((int) (charAt2 & '?') | 128);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        mo31410e((charAt2 >> 12) | 224);
                        mo31410e(((charAt2 >> 6) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                        mo31410e((int) (charAt2 & '?') | 128);
                    } else {
                        int i6 = i + 1;
                        char charAt3 = i6 < length ? str.charAt(i6) : 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            mo31410e(63);
                            i = i6;
                        } else {
                            int i7 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 0;
                            mo31410e((i7 >> 18) | 240);
                            mo31410e(((i7 >> 12) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                            mo31410e(((i7 >> 6) & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                            mo31410e((i7 & 63) | OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + length + " > " + str.length());
        }
    }

    /* renamed from: d */
    public final void mo31407d(long j) {
        while (j > 0) {
            C5218iy iyVar = this.f14310a;
            if (iyVar != null) {
                int min = (int) Math.min(j, (long) (iyVar.f14330c - iyVar.f14329b));
                long j2 = (long) min;
                this.f14311b -= j2;
                j -= j2;
                C5218iy iyVar2 = this.f14310a;
                int i = iyVar2.f14329b + min;
                iyVar2.f14329b = i;
                if (i == iyVar2.f14330c) {
                    this.f14310a = iyVar2.mo31435a();
                    C5219iz.m17549a(iyVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final C5218iy mo31401c(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        C5218iy iyVar = this.f14310a;
        if (iyVar == null) {
            C5218iy a = C5219iz.m17548a();
            this.f14310a = a;
            a.f14334g = a;
            a.f14333f = a;
            return a;
        }
        C5218iy iyVar2 = iyVar.f14334g;
        return (iyVar2.f14330c + i > 8192 || !iyVar2.f14332e) ? iyVar2.mo31436a(C5219iz.m17548a()) : iyVar2;
    }

    /* renamed from: a */
    public final C5209ir mo31390a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C5226je.m17567a((long) bArr.length, 0, j);
            int i3 = i2 + 0;
            while (i < i3) {
                C5218iy c = mo31401c(1);
                int min = Math.min(i3 - i, 8192 - c.f14330c);
                System.arraycopy(bArr, i, c.f14328a, c.f14330c, min);
                i += min;
                c.f14330c += min;
            }
            this.f14311b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final C5209ir mo31410e(int i) {
        C5218iy c = mo31401c(1);
        byte[] bArr = c.f14328a;
        int i2 = c.f14330c;
        c.f14330c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f14311b++;
        return this;
    }

    /* renamed from: a */
    public final void mo31393a(C5209ir irVar, long j) {
        C5218iy iyVar;
        if (irVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (irVar != this) {
            C5226je.m17567a(irVar.f14311b, 0, j);
            while (j > 0) {
                C5218iy iyVar2 = irVar.f14310a;
                int i = 0;
                if (j < ((long) (iyVar2.f14330c - iyVar2.f14329b))) {
                    C5218iy iyVar3 = this.f14310a;
                    C5218iy iyVar4 = iyVar3 != null ? iyVar3.f14334g : null;
                    if (iyVar4 != null && iyVar4.f14332e) {
                        if ((((long) iyVar4.f14330c) + j) - ((long) (iyVar4.f14331d ? 0 : iyVar4.f14329b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            irVar.f14310a.mo31437a(iyVar4, (int) j);
                            irVar.f14311b -= j;
                            this.f14311b += j;
                            return;
                        }
                    }
                    C5218iy iyVar5 = irVar.f14310a;
                    int i2 = (int) j;
                    if (i2 <= 0 || i2 > iyVar5.f14330c - iyVar5.f14329b) {
                        throw new IllegalArgumentException();
                    }
                    if (i2 >= 1024) {
                        iyVar = new C5218iy(iyVar5);
                    } else {
                        iyVar = C5219iz.m17548a();
                        System.arraycopy(iyVar5.f14328a, iyVar5.f14329b, iyVar.f14328a, 0, i2);
                    }
                    iyVar.f14330c = iyVar.f14329b + i2;
                    iyVar5.f14329b += i2;
                    iyVar5.f14334g.mo31436a(iyVar);
                    irVar.f14310a = iyVar;
                }
                C5218iy iyVar6 = irVar.f14310a;
                long j2 = (long) (iyVar6.f14330c - iyVar6.f14329b);
                irVar.f14310a = iyVar6.mo31435a();
                C5218iy iyVar7 = this.f14310a;
                if (iyVar7 == null) {
                    this.f14310a = iyVar6;
                    iyVar6.f14334g = iyVar6;
                    iyVar6.f14333f = iyVar6;
                } else {
                    C5218iy a = iyVar7.f14334g.mo31436a(iyVar6);
                    C5218iy iyVar8 = a.f14334g;
                    if (iyVar8 == a) {
                        throw new IllegalStateException();
                    } else if (iyVar8.f14332e) {
                        int i3 = a.f14330c - a.f14329b;
                        int i4 = 8192 - iyVar8.f14330c;
                        if (!iyVar8.f14331d) {
                            i = iyVar8.f14329b;
                        }
                        if (i3 <= i4 + i) {
                            a.mo31437a(a.f14334g, i3);
                            a.mo31435a();
                            C5219iz.m17549a(a);
                        }
                    }
                }
                irVar.f14311b -= j2;
                this.f14311b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
