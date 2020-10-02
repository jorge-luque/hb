package com.google.zxing.p140k.p141b;

/* renamed from: com.google.zxing.k.b.b */
/* compiled from: Mode */
public enum C4128b {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    

    /* renamed from: a */
    private final int[] f11075a;

    /* renamed from: b */
    private final int f11076b;

    private C4128b(int[] iArr, int i) {
        this.f11075a = iArr;
        this.f11076b = i;
    }

    /* renamed from: b */
    public static C4128b[] m13787b() {
        return (C4128b[]) f11074m.clone();
    }

    /* renamed from: a */
    public int mo28395a(C4129c cVar) {
        int c = cVar.mo28399c();
        return this.f11075a[c <= 9 ? 0 : c <= 26 ? (char) 1 : 2];
    }

    /* renamed from: a */
    public int mo28394a() {
        return this.f11076b;
    }
}
