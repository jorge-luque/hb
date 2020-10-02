package com.google.zxing.p135h.p136b;

import admost.sdk.listener.AdMostAdListener;
import com.google.zxing.C4062b;

/* renamed from: com.google.zxing.h.b.k */
/* compiled from: SymbolInfo */
public class C4093k {

    /* renamed from: i */
    private static C4093k[] f10991i = {new C4093k(false, 3, 5, 8, 8, 1), new C4093k(false, 5, 7, 10, 10, 1), new C4093k(true, 5, 7, 16, 6, 1), new C4093k(false, 8, 10, 12, 12, 1), new C4093k(true, 10, 11, 14, 6, 2), new C4093k(false, 12, 12, 14, 14, 1), new C4093k(true, 16, 14, 24, 10, 1), new C4093k(false, 18, 14, 16, 16, 1), new C4093k(false, 22, 18, 18, 18, 1), new C4093k(true, 22, 18, 16, 10, 2), new C4093k(false, 30, 20, 20, 20, 1), new C4093k(true, 32, 24, 16, 14, 2), new C4093k(false, 36, 24, 22, 22, 1), new C4093k(false, 44, 28, 24, 24, 1), new C4093k(true, 49, 28, 22, 14, 2), new C4093k(false, 62, 36, 14, 14, 4), new C4093k(false, 86, 42, 16, 16, 4), new C4093k(false, 114, 48, 18, 18, 4), new C4093k(false, 144, 56, 20, 20, 4), new C4093k(false, 174, 68, 22, 22, 4), new C4093k(false, 204, 84, 24, 24, 4, 102, 42), new C4093k(false, 280, 112, 14, 14, 16, 140, 56), new C4093k(false, 368, 144, 16, 16, 16, 92, 36), new C4093k(false, 456, 192, 18, 18, 16, 114, 48), new C4093k(false, 576, 224, 20, 20, 16, 144, 56), new C4093k(false, 696, 272, 22, 22, 16, 174, 68), new C4093k(false, 816, 336, 24, 24, 16, 136, 56), new C4093k(false, 1050, 408, 18, 18, 36, 175, 68), new C4093k(false, 1304, 496, 20, 20, 36, AdMostAdListener.LOADED, 62), new C4086d()};

    /* renamed from: a */
    private final boolean f10992a;

    /* renamed from: b */
    private final int f10993b;

    /* renamed from: c */
    private final int f10994c;

    /* renamed from: d */
    public final int f10995d;

    /* renamed from: e */
    public final int f10996e;

    /* renamed from: f */
    private final int f10997f;

    /* renamed from: g */
    private final int f10998g;

    /* renamed from: h */
    private final int f10999h;

    public C4093k(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    /* renamed from: a */
    public static C4093k m13690a(int i, C4094l lVar, C4062b bVar, C4062b bVar2, boolean z) {
        for (C4093k kVar : f10991i) {
            if ((lVar != C4094l.FORCE_SQUARE || !kVar.f10992a) && ((lVar != C4094l.FORCE_RECTANGLE || kVar.f10992a) && ((bVar == null || (kVar.mo28374g() >= bVar.mo28267b() && kVar.mo28373f() >= bVar.mo28266a())) && ((bVar2 == null || (kVar.mo28374g() <= bVar2.mo28267b() && kVar.mo28373f() <= bVar2.mo28266a())) && i <= kVar.f10993b)))) {
                return kVar;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i)));
    }

    /* renamed from: h */
    private int m13691h() {
        int i = this.f10997f;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (!(i == 2 || i == 4)) {
                if (i == 16) {
                    return 4;
                }
                if (i == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i2;
    }

    /* renamed from: i */
    private int m13692i() {
        int i = this.f10997f;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    /* renamed from: b */
    public final int mo28369b() {
        return this.f10994c;
    }

    /* renamed from: c */
    public int mo28346c() {
        return this.f10993b / this.f10998g;
    }

    /* renamed from: d */
    public final int mo28371d() {
        return m13692i() * this.f10996e;
    }

    /* renamed from: e */
    public final int mo28372e() {
        return m13691h() * this.f10995d;
    }

    /* renamed from: f */
    public final int mo28373f() {
        return mo28371d() + (m13692i() << 1);
    }

    /* renamed from: g */
    public final int mo28374g() {
        return mo28372e() + (m13691h() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10992a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f10995d);
        sb.append('x');
        sb.append(this.f10996e);
        sb.append(", symbol size ");
        sb.append(mo28374g());
        sb.append('x');
        sb.append(mo28373f());
        sb.append(", symbol data size ");
        sb.append(mo28372e());
        sb.append('x');
        sb.append(mo28371d());
        sb.append(", codewords ");
        sb.append(this.f10993b);
        sb.append('+');
        sb.append(this.f10994c);
        return sb.toString();
    }

    C4093k(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f10992a = z;
        this.f10993b = i;
        this.f10994c = i2;
        this.f10995d = i3;
        this.f10996e = i4;
        this.f10997f = i5;
        this.f10998g = i6;
        this.f10999h = i7;
    }

    /* renamed from: b */
    public final int mo28370b(int i) {
        return this.f10999h;
    }

    /* renamed from: a */
    public final int mo28368a() {
        return this.f10993b;
    }

    /* renamed from: a */
    public int mo28345a(int i) {
        return this.f10998g;
    }
}
