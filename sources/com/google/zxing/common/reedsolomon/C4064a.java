package com.google.zxing.common.reedsolomon;

import admost.sdk.base.AdMost;
import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: com.google.zxing.common.reedsolomon.a */
/* compiled from: GenericGF */
public final class C4064a {

    /* renamed from: g */
    public static final C4064a f10901g = new C4064a(4201, CodedOutputStream.DEFAULT_BUFFER_SIZE, 1);

    /* renamed from: h */
    public static final C4064a f10902h = new C4064a(1033, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS, 1);

    /* renamed from: i */
    public static final C4064a f10903i = new C4064a(67, 64, 1);

    /* renamed from: j */
    public static final C4064a f10904j = new C4064a(19, 16, 1);

    /* renamed from: k */
    public static final C4064a f10905k = new C4064a(285, 256, 0);

    /* renamed from: l */
    public static final C4064a f10906l = new C4064a(AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN, 256, 1);

    /* renamed from: a */
    private final int[] f10907a;

    /* renamed from: b */
    private final int[] f10908b;

    /* renamed from: c */
    private final C4065b f10909c;

    /* renamed from: d */
    private final int f10910d;

    /* renamed from: e */
    private final int f10911e;

    /* renamed from: f */
    private final int f10912f;

    public C4064a(int i, int i2, int i3) {
        this.f10911e = i;
        this.f10910d = i2;
        this.f10912f = i3;
        this.f10907a = new int[i2];
        this.f10908b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f10907a[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f10908b[this.f10907a[i6]] = i6;
        }
        this.f10909c = new C4065b(this, new int[]{0});
        new C4065b(this, new int[]{1});
    }

    /* renamed from: c */
    static int m13538c(int i, int i2) {
        return i ^ i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C4065b mo28273a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f10909c;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C4065b(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C4065b mo28276b() {
        return this.f10909c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo28277c(int i) {
        if (i != 0) {
            return this.f10908b[i];
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f10911e) + ',' + this.f10910d + ')';
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo28274b(int i) {
        if (i != 0) {
            return this.f10907a[(this.f10910d - this.f10908b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo28275b(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f10907a;
        int[] iArr2 = this.f10908b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f10910d - 1)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo28272a(int i) {
        return this.f10907a[i];
    }

    /* renamed from: a */
    public int mo28271a() {
        return this.f10912f;
    }
}
