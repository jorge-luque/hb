package com.google.zxing.p135h.p136b;

import java.util.Arrays;

/* renamed from: com.google.zxing.h.b.e */
/* compiled from: DefaultPlacement */
public class C4087e {

    /* renamed from: a */
    private final CharSequence f10974a;

    /* renamed from: b */
    private final int f10975b;

    /* renamed from: c */
    private final int f10976c;

    /* renamed from: d */
    private final byte[] f10977d;

    public C4087e(CharSequence charSequence, int i, int i2) {
        this.f10974a = charSequence;
        this.f10976c = i;
        this.f10975b = i2;
        byte[] bArr = new byte[(i * i2)];
        this.f10977d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    /* renamed from: b */
    private boolean m13642b(int i, int i2) {
        return this.f10977d[(i2 * this.f10976c) + i] >= 0;
    }

    /* renamed from: c */
    private void m13643c(int i) {
        m13639a(this.f10975b - 3, 0, i, 1);
        m13639a(this.f10975b - 2, 0, i, 2);
        m13639a(this.f10975b - 1, 0, i, 3);
        m13639a(0, this.f10976c - 2, i, 4);
        m13639a(0, this.f10976c - 1, i, 5);
        m13639a(1, this.f10976c - 1, i, 6);
        m13639a(2, this.f10976c - 1, i, 7);
        m13639a(3, this.f10976c - 1, i, 8);
    }

    /* renamed from: d */
    private void m13644d(int i) {
        m13639a(this.f10975b - 1, 0, i, 1);
        m13639a(this.f10975b - 1, this.f10976c - 1, i, 2);
        m13639a(0, this.f10976c - 3, i, 3);
        m13639a(0, this.f10976c - 2, i, 4);
        m13639a(0, this.f10976c - 1, i, 5);
        m13639a(1, this.f10976c - 3, i, 6);
        m13639a(1, this.f10976c - 2, i, 7);
        m13639a(1, this.f10976c - 1, i, 8);
    }

    /* renamed from: a */
    public final boolean mo28348a(int i, int i2) {
        return this.f10977d[(i2 * this.f10976c) + i] == 1;
    }

    /* renamed from: a */
    private void m13640a(int i, int i2, boolean z) {
        this.f10977d[(i2 * this.f10976c) + i] = z ? (byte) 1 : 0;
    }

    /* renamed from: b */
    private void m13641b(int i) {
        m13639a(this.f10975b - 3, 0, i, 1);
        m13639a(this.f10975b - 2, 0, i, 2);
        m13639a(this.f10975b - 1, 0, i, 3);
        m13639a(0, this.f10976c - 4, i, 4);
        m13639a(0, this.f10976c - 3, i, 5);
        m13639a(0, this.f10976c - 2, i, 6);
        m13639a(0, this.f10976c - 1, i, 7);
        m13639a(1, this.f10976c - 1, i, 8);
    }

    /* renamed from: a */
    public final void mo28347a() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 4;
        while (true) {
            if (i5 == this.f10975b && i3 == 0) {
                m13637a(i4);
                i4++;
            }
            if (i5 == this.f10975b - 2 && i3 == 0 && this.f10976c % 4 != 0) {
                m13641b(i4);
                i4++;
            }
            if (i5 == this.f10975b - 2 && i3 == 0 && this.f10976c % 8 == 4) {
                m13643c(i4);
                i4++;
            }
            if (i5 == this.f10975b + 4 && i3 == 2 && this.f10976c % 8 == 0) {
                m13644d(i4);
                i4++;
            }
            do {
                if (i5 < this.f10975b && i3 >= 0 && !m13642b(i3, i5)) {
                    m13638a(i5, i3, i4);
                    i4++;
                }
                i5 -= 2;
                i3 += 2;
                if (i5 < 0 || i3 >= this.f10976c) {
                    int i6 = i5 + 1;
                    int i7 = i3 + 3;
                }
                m13638a(i5, i3, i4);
                i4++;
                i5 -= 2;
                i3 += 2;
                break;
            } while (i3 >= this.f10976c);
            int i62 = i5 + 1;
            int i72 = i3 + 3;
            do {
                if (i62 >= 0 && i72 < this.f10976c && !m13642b(i72, i62)) {
                    m13638a(i62, i72, i4);
                    i4++;
                }
                i62 += 2;
                i72 -= 2;
                if (i62 >= this.f10975b) {
                    break;
                }
            } while (i72 >= 0);
            i5 = i62 + 3;
            i3 = i72 + 1;
            i = this.f10975b;
            if (i5 >= i && i3 >= (i2 = this.f10976c)) {
                break;
            }
        }
        if (!m13642b(i2 - 1, i - 1)) {
            m13640a(this.f10976c - 1, this.f10975b - 1, true);
            m13640a(this.f10976c - 2, this.f10975b - 2, true);
        }
    }

    /* renamed from: a */
    private void m13639a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.f10975b;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.f10976c;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        boolean z = true;
        if ((this.f10974a.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        m13640a(i2, i, z);
    }

    /* renamed from: a */
    private void m13638a(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        m13639a(i4, i5, i3, 1);
        int i6 = i2 - 1;
        m13639a(i4, i6, i3, 2);
        int i7 = i - 1;
        m13639a(i7, i5, i3, 3);
        m13639a(i7, i6, i3, 4);
        m13639a(i7, i2, i3, 5);
        m13639a(i, i5, i3, 6);
        m13639a(i, i6, i3, 7);
        m13639a(i, i2, i3, 8);
    }

    /* renamed from: a */
    private void m13637a(int i) {
        m13639a(this.f10975b - 1, 0, i, 1);
        m13639a(this.f10975b - 1, 1, i, 2);
        m13639a(this.f10975b - 1, 2, i, 3);
        m13639a(0, this.f10976c - 2, i, 4);
        m13639a(0, this.f10976c - 1, i, 5);
        m13639a(1, this.f10976c - 1, i, 6);
        m13639a(2, this.f10976c - 1, i, 7);
        m13639a(3, this.f10976c - 1, i, 8);
    }
}
