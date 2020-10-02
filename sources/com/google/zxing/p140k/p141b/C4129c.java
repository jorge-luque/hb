package com.google.zxing.p140k.p141b;

import admost.sdk.listener.AdMostAdListener;
import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: com.google.zxing.k.b.c */
/* compiled from: Version */
public final class C4129c {

    /* renamed from: d */
    private static final C4129c[] f11077d = m13791d();

    /* renamed from: a */
    private final int f11078a;

    /* renamed from: b */
    private final C4131b[] f11079b;

    /* renamed from: c */
    private final int f11080c;

    /* renamed from: com.google.zxing.k.b.c$a */
    /* compiled from: Version */
    public static final class C4130a {

        /* renamed from: a */
        private final int f11081a;

        /* renamed from: b */
        private final int f11082b;

        C4130a(int i, int i2) {
            this.f11081a = i;
            this.f11082b = i2;
        }

        /* renamed from: a */
        public int mo28401a() {
            return this.f11081a;
        }

        /* renamed from: b */
        public int mo28402b() {
            return this.f11082b;
        }
    }

    /* renamed from: com.google.zxing.k.b.c$b */
    /* compiled from: Version */
    public static final class C4131b {

        /* renamed from: a */
        private final int f11083a;

        /* renamed from: b */
        private final C4130a[] f11084b;

        C4131b(int i, C4130a... aVarArr) {
            this.f11083a = i;
            this.f11084b = aVarArr;
        }

        /* renamed from: a */
        public C4130a[] mo28403a() {
            return this.f11084b;
        }

        /* renamed from: b */
        public int mo28404b() {
            return this.f11083a;
        }

        /* renamed from: c */
        public int mo28405c() {
            int i = 0;
            for (C4130a a : this.f11084b) {
                i += a.mo28401a();
            }
            return i;
        }

        /* renamed from: d */
        public int mo28406d() {
            return this.f11083a * mo28405c();
        }
    }

    private C4129c(int i, int[] iArr, C4131b... bVarArr) {
        this.f11078a = i;
        this.f11079b = bVarArr;
        int b = bVarArr[0].mo28404b();
        int i2 = 0;
        for (C4130a aVar : bVarArr[0].mo28403a()) {
            i2 += aVar.mo28401a() * (aVar.mo28402b() + b);
        }
        this.f11080c = i2;
    }

    /* renamed from: d */
    private static C4129c[] m13791d() {
        return new C4129c[]{new C4129c(1, new int[0], new C4131b(7, new C4130a(1, 19)), new C4131b(10, new C4130a(1, 16)), new C4131b(13, new C4130a(1, 13)), new C4131b(17, new C4130a(1, 9))), new C4129c(2, new int[]{6, 18}, new C4131b(10, new C4130a(1, 34)), new C4131b(16, new C4130a(1, 28)), new C4131b(22, new C4130a(1, 22)), new C4131b(28, new C4130a(1, 16))), new C4129c(3, new int[]{6, 22}, new C4131b(15, new C4130a(1, 55)), new C4131b(26, new C4130a(1, 44)), new C4131b(18, new C4130a(2, 17)), new C4131b(22, new C4130a(2, 13))), new C4129c(4, new int[]{6, 26}, new C4131b(20, new C4130a(1, 80)), new C4131b(18, new C4130a(2, 32)), new C4131b(26, new C4130a(2, 24)), new C4131b(16, new C4130a(4, 9))), new C4129c(5, new int[]{6, 30}, new C4131b(26, new C4130a(1, 108)), new C4131b(24, new C4130a(2, 43)), new C4131b(18, new C4130a(2, 15), new C4130a(2, 16)), new C4131b(22, new C4130a(2, 11), new C4130a(2, 12))), new C4129c(6, new int[]{6, 34}, new C4131b(18, new C4130a(2, 68)), new C4131b(16, new C4130a(4, 27)), new C4131b(24, new C4130a(4, 19)), new C4131b(28, new C4130a(4, 15))), new C4129c(7, new int[]{6, 22, 38}, new C4131b(20, new C4130a(2, 78)), new C4131b(18, new C4130a(4, 31)), new C4131b(18, new C4130a(2, 14), new C4130a(4, 15)), new C4131b(26, new C4130a(4, 13), new C4130a(1, 14))), new C4129c(8, new int[]{6, 24, 42}, new C4131b(24, new C4130a(2, 97)), new C4131b(22, new C4130a(2, 38), new C4130a(2, 39)), new C4131b(22, new C4130a(4, 18), new C4130a(2, 19)), new C4131b(26, new C4130a(4, 14), new C4130a(2, 15))), new C4129c(9, new int[]{6, 26, 46}, new C4131b(30, new C4130a(2, 116)), new C4131b(22, new C4130a(3, 36), new C4130a(2, 37)), new C4131b(20, new C4130a(4, 16), new C4130a(4, 17)), new C4131b(24, new C4130a(4, 12), new C4130a(4, 13))), new C4129c(10, new int[]{6, 28, 50}, new C4131b(18, new C4130a(2, 68), new C4130a(2, 69)), new C4131b(26, new C4130a(4, 43), new C4130a(1, 44)), new C4131b(24, new C4130a(6, 19), new C4130a(2, 20)), new C4131b(28, new C4130a(6, 15), new C4130a(2, 16))), new C4129c(11, new int[]{6, 30, 54}, new C4131b(20, new C4130a(4, 81)), new C4131b(30, new C4130a(1, 50), new C4130a(4, 51)), new C4131b(28, new C4130a(4, 22), new C4130a(4, 23)), new C4131b(24, new C4130a(3, 12), new C4130a(8, 13))), new C4129c(12, new int[]{6, 32, 58}, new C4131b(24, new C4130a(2, 92), new C4130a(2, 93)), new C4131b(22, new C4130a(6, 36), new C4130a(2, 37)), new C4131b(26, new C4130a(4, 20), new C4130a(6, 21)), new C4131b(28, new C4130a(7, 14), new C4130a(4, 15))), new C4129c(13, new int[]{6, 34, 62}, new C4131b(26, new C4130a(4, 107)), new C4131b(22, new C4130a(8, 37), new C4130a(1, 38)), new C4131b(24, new C4130a(8, 20), new C4130a(4, 21)), new C4131b(22, new C4130a(12, 11), new C4130a(4, 12))), new C4129c(14, new int[]{6, 26, 46, 66}, new C4131b(30, new C4130a(3, 115), new C4130a(1, 116)), new C4131b(24, new C4130a(4, 40), new C4130a(5, 41)), new C4131b(20, new C4130a(11, 16), new C4130a(5, 17)), new C4131b(24, new C4130a(11, 12), new C4130a(5, 13))), new C4129c(15, new int[]{6, 26, 48, 70}, new C4131b(22, new C4130a(5, 87), new C4130a(1, 88)), new C4131b(24, new C4130a(5, 41), new C4130a(5, 42)), new C4131b(30, new C4130a(5, 24), new C4130a(7, 25)), new C4131b(24, new C4130a(11, 12), new C4130a(7, 13))), new C4129c(16, new int[]{6, 26, 50, 74}, new C4131b(24, new C4130a(5, 98), new C4130a(1, 99)), new C4131b(28, new C4130a(7, 45), new C4130a(3, 46)), new C4131b(24, new C4130a(15, 19), new C4130a(2, 20)), new C4131b(30, new C4130a(3, 15), new C4130a(13, 16))), new C4129c(17, new int[]{6, 30, 54, 78}, new C4131b(28, new C4130a(1, 107), new C4130a(5, 108)), new C4131b(28, new C4130a(10, 46), new C4130a(1, 47)), new C4131b(28, new C4130a(1, 22), new C4130a(15, 23)), new C4131b(28, new C4130a(2, 14), new C4130a(17, 15))), new C4129c(18, new int[]{6, 30, 56, 82}, new C4131b(30, new C4130a(5, 120), new C4130a(1, 121)), new C4131b(26, new C4130a(9, 43), new C4130a(4, 44)), new C4131b(28, new C4130a(17, 22), new C4130a(1, 23)), new C4131b(28, new C4130a(2, 14), new C4130a(19, 15))), new C4129c(19, new int[]{6, 30, 58, 86}, new C4131b(28, new C4130a(3, 113), new C4130a(4, 114)), new C4131b(26, new C4130a(3, 44), new C4130a(11, 45)), new C4131b(26, new C4130a(17, 21), new C4130a(4, 22)), new C4131b(26, new C4130a(9, 13), new C4130a(16, 14))), new C4129c(20, new int[]{6, 34, 62, 90}, new C4131b(28, new C4130a(3, 107), new C4130a(5, 108)), new C4131b(26, new C4130a(3, 41), new C4130a(13, 42)), new C4131b(30, new C4130a(15, 24), new C4130a(5, 25)), new C4131b(28, new C4130a(15, 15), new C4130a(10, 16))), new C4129c(21, new int[]{6, 28, 50, 72, 94}, new C4131b(28, new C4130a(4, 116), new C4130a(4, 117)), new C4131b(26, new C4130a(17, 42)), new C4131b(28, new C4130a(17, 22), new C4130a(6, 23)), new C4131b(30, new C4130a(19, 16), new C4130a(6, 17))), new C4129c(22, new int[]{6, 26, 50, 74, 98}, new C4131b(28, new C4130a(2, 111), new C4130a(7, 112)), new C4131b(28, new C4130a(17, 46)), new C4131b(30, new C4130a(7, 24), new C4130a(16, 25)), new C4131b(24, new C4130a(34, 13))), new C4129c(23, new int[]{6, 30, 54, 78, 102}, new C4131b(30, new C4130a(4, 121), new C4130a(5, 122)), new C4131b(28, new C4130a(4, 47), new C4130a(14, 48)), new C4131b(30, new C4130a(11, 24), new C4130a(14, 25)), new C4131b(30, new C4130a(16, 15), new C4130a(14, 16))), new C4129c(24, new int[]{6, 28, 54, 80, 106}, new C4131b(30, new C4130a(6, 117), new C4130a(4, 118)), new C4131b(28, new C4130a(6, 45), new C4130a(14, 46)), new C4131b(30, new C4130a(11, 24), new C4130a(16, 25)), new C4131b(30, new C4130a(30, 16), new C4130a(2, 17))), new C4129c(25, new int[]{6, 32, 58, 84, 110}, new C4131b(26, new C4130a(8, 106), new C4130a(4, 107)), new C4131b(28, new C4130a(8, 47), new C4130a(13, 48)), new C4131b(30, new C4130a(7, 24), new C4130a(22, 25)), new C4131b(30, new C4130a(22, 15), new C4130a(13, 16))), new C4129c(26, new int[]{6, 30, 58, 86, 114}, new C4131b(28, new C4130a(10, 114), new C4130a(2, 115)), new C4131b(28, new C4130a(19, 46), new C4130a(4, 47)), new C4131b(28, new C4130a(28, 22), new C4130a(6, 23)), new C4131b(30, new C4130a(33, 16), new C4130a(4, 17))), new C4129c(27, new int[]{6, 34, 62, 90, 118}, new C4131b(30, new C4130a(8, 122), new C4130a(4, 123)), new C4131b(28, new C4130a(22, 45), new C4130a(3, 46)), new C4131b(30, new C4130a(8, 23), new C4130a(26, 24)), new C4131b(30, new C4130a(12, 15), new C4130a(28, 16))), new C4129c(28, new int[]{6, 26, 50, 74, 98, 122}, new C4131b(30, new C4130a(3, 117), new C4130a(10, 118)), new C4131b(28, new C4130a(3, 45), new C4130a(23, 46)), new C4131b(30, new C4130a(4, 24), new C4130a(31, 25)), new C4131b(30, new C4130a(11, 15), new C4130a(31, 16))), new C4129c(29, new int[]{6, 30, 54, 78, 102, 126}, new C4131b(30, new C4130a(7, 116), new C4130a(7, 117)), new C4131b(28, new C4130a(21, 45), new C4130a(7, 46)), new C4131b(30, new C4130a(1, 23), new C4130a(37, 24)), new C4131b(30, new C4130a(19, 15), new C4130a(26, 16))), new C4129c(30, new int[]{6, 26, 52, 78, 104, 130}, new C4131b(30, new C4130a(5, 115), new C4130a(10, 116)), new C4131b(28, new C4130a(19, 47), new C4130a(10, 48)), new C4131b(30, new C4130a(15, 24), new C4130a(25, 25)), new C4131b(30, new C4130a(23, 15), new C4130a(25, 16))), new C4129c(31, new int[]{6, 30, 56, 82, 108, 134}, new C4131b(30, new C4130a(13, 115), new C4130a(3, 116)), new C4131b(28, new C4130a(2, 46), new C4130a(29, 47)), new C4131b(30, new C4130a(42, 24), new C4130a(1, 25)), new C4131b(30, new C4130a(23, 15), new C4130a(28, 16))), new C4129c(32, new int[]{6, 34, 60, 86, 112, 138}, new C4131b(30, new C4130a(17, 115)), new C4131b(28, new C4130a(10, 46), new C4130a(23, 47)), new C4131b(30, new C4130a(10, 24), new C4130a(35, 25)), new C4131b(30, new C4130a(19, 15), new C4130a(35, 16))), new C4129c(33, new int[]{6, 30, 58, 86, 114, 142}, new C4131b(30, new C4130a(17, 115), new C4130a(1, 116)), new C4131b(28, new C4130a(14, 46), new C4130a(21, 47)), new C4131b(30, new C4130a(29, 24), new C4130a(19, 25)), new C4131b(30, new C4130a(11, 15), new C4130a(46, 16))), new C4129c(34, new int[]{6, 34, 62, 90, 118, 146}, new C4131b(30, new C4130a(13, 115), new C4130a(6, 116)), new C4131b(28, new C4130a(14, 46), new C4130a(23, 47)), new C4131b(30, new C4130a(44, 24), new C4130a(7, 25)), new C4131b(30, new C4130a(59, 16), new C4130a(1, 17))), new C4129c(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new C4131b(30, new C4130a(12, 121), new C4130a(7, 122)), new C4131b(28, new C4130a(12, 47), new C4130a(26, 48)), new C4131b(30, new C4130a(39, 24), new C4130a(14, 25)), new C4131b(30, new C4130a(22, 15), new C4130a(41, 16))), new C4129c(36, new int[]{6, 24, 50, 76, 102, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE, 154}, new C4131b(30, new C4130a(6, 121), new C4130a(14, 122)), new C4131b(28, new C4130a(6, 47), new C4130a(34, 48)), new C4131b(30, new C4130a(46, 24), new C4130a(10, 25)), new C4131b(30, new C4130a(2, 15), new C4130a(64, 16))), new C4129c(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new C4131b(30, new C4130a(17, 122), new C4130a(4, 123)), new C4131b(28, new C4130a(29, 46), new C4130a(14, 47)), new C4131b(30, new C4130a(49, 24), new C4130a(10, 25)), new C4131b(30, new C4130a(24, 15), new C4130a(46, 16))), new C4129c(38, new int[]{6, 32, 58, 84, 110, 136, AdMostAdListener.COMPLETED}, new C4131b(30, new C4130a(4, 122), new C4130a(18, 123)), new C4131b(28, new C4130a(13, 46), new C4130a(32, 47)), new C4131b(30, new C4130a(48, 24), new C4130a(14, 25)), new C4131b(30, new C4130a(42, 15), new C4130a(32, 16))), new C4129c(39, new int[]{6, 26, 54, 82, 110, 138, AdMostAdListener.STATUS_CHANGED}, new C4131b(30, new C4130a(20, 117), new C4130a(4, 118)), new C4131b(28, new C4130a(40, 47), new C4130a(7, 48)), new C4131b(30, new C4130a(43, 24), new C4130a(22, 25)), new C4131b(30, new C4130a(10, 15), new C4130a(67, 16))), new C4129c(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new C4131b(30, new C4130a(19, 118), new C4130a(6, 119)), new C4131b(28, new C4130a(18, 47), new C4130a(31, 48)), new C4131b(30, new C4130a(34, 24), new C4130a(34, 25)), new C4131b(30, new C4130a(20, 15), new C4130a(61, 16)))};
    }

    /* renamed from: a */
    public int mo28396a() {
        return (this.f11078a * 4) + 17;
    }

    /* renamed from: b */
    public int mo28398b() {
        return this.f11080c;
    }

    /* renamed from: c */
    public int mo28399c() {
        return this.f11078a;
    }

    public String toString() {
        return String.valueOf(this.f11078a);
    }

    /* renamed from: a */
    public C4131b mo28397a(C4127a aVar) {
        return this.f11079b[aVar.ordinal()];
    }

    /* renamed from: a */
    public static C4129c m13790a(int i) {
        if (i > 0 && i <= 40) {
            return f11077d[i - 1];
        }
        throw new IllegalArgumentException();
    }
}
