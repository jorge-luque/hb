package com.tapjoy.internal;

import java.io.Serializable;
import java.util.Arrays;

/* renamed from: com.tapjoy.internal.iu */
public class C5212iu implements Serializable, Comparable {

    /* renamed from: a */
    static final char[] f14312a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static final C5212iu f14313b = new C5212iu((byte[]) new byte[0].clone());

    /* renamed from: c */
    final byte[] f14314c;

    /* renamed from: d */
    transient int f14315d;

    /* renamed from: e */
    transient String f14316e;

    public C5212iu(byte[] bArr) {
        this.f14314c = bArr;
    }

    /* renamed from: a */
    public String mo31421a() {
        String str = this.f14316e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f14314c, C5226je.f14342a);
        this.f14316e = str2;
        return str2;
    }

    /* renamed from: b */
    public String mo31424b() {
        byte[] bArr = this.f14314c;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f14312a;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: c */
    public int mo31425c() {
        return this.f14314c.length;
    }

    public /* synthetic */ int compareTo(Object obj) {
        C5212iu iuVar = (C5212iu) obj;
        int c = mo31425c();
        int c2 = iuVar.mo31425c();
        int min = Math.min(c, c2);
        for (int i = 0; i < min; i++) {
            byte a = mo31419a(i) & 255;
            byte a2 = iuVar.mo31419a(i) & 255;
            if (a != a2) {
                return a < a2 ? -1 : 1;
            }
        }
        if (c == c2) {
            return 0;
        }
        return c < c2 ? -1 : 1;
    }

    /* renamed from: d */
    public byte[] mo31427d() {
        return (byte[]) this.f14314c.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5212iu) {
            C5212iu iuVar = (C5212iu) obj;
            int c = iuVar.mo31425c();
            byte[] bArr = this.f14314c;
            return c == bArr.length && iuVar.mo31423a(0, bArr, 0, bArr.length);
        }
    }

    public int hashCode() {
        int i = this.f14315d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f14314c);
        this.f14315d = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.f14314c.length == 0) {
            return "[size=0]";
        }
        String a = mo31421a();
        int length = a.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = a.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = a.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i != -1) {
            String replace = a.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (i < a.length()) {
                return "[size=" + this.f14314c.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + "]";
        } else if (this.f14314c.length <= 64) {
            return "[hex=" + mo31424b() + "]";
        } else {
            return "[size=" + this.f14314c.length + " hex=" + mo31420a(0, 64).mo31424b() + "…]";
        }
    }

    /* renamed from: a */
    public C5212iu mo31420a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f14314c;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.f14314c, i, bArr2, 0, i3);
                    return new C5212iu(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.f14314c.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    /* renamed from: a */
    public byte mo31419a(int i) {
        return this.f14314c[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo31422a(C5209ir irVar) {
        byte[] bArr = this.f14314c;
        irVar.mo31390a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public boolean mo31423a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.f14314c;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C5226je.m17569a(bArr2, i, bArr, i2, i3);
    }
}
