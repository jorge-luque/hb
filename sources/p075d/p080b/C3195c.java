package p075d.p080b;

/* renamed from: d.b.c */
/* compiled from: ContainerHelpers */
class C3195c {

    /* renamed from: a */
    static final int[] f8888a = new int[0];

    /* renamed from: b */
    static final long[] f8889b = new long[0];

    /* renamed from: c */
    static final Object[] f8890c = new Object[0];

    /* renamed from: a */
    public static int m10531a(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m10534a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    public static int m10535b(int i) {
        return m10531a(i * 4) / 4;
    }

    /* renamed from: c */
    public static int m10536c(int i) {
        return m10531a(i * 8) / 8;
    }

    /* renamed from: a */
    static int m10532a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    /* renamed from: a */
    static int m10533a(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else if (j2 <= j) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }
}
