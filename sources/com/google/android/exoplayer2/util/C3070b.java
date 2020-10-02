package com.google.android.exoplayer2.util;

/* renamed from: com.google.android.exoplayer2.util.b */
/* compiled from: RepeatModeUtil */
public final class C3070b {
    /* renamed from: a */
    public static int m10122a(int i, int i2) {
        for (int i3 = 1; i3 <= 2; i3++) {
            int i4 = (i + i3) % 3;
            if (m10123b(i4, i2)) {
                return i4;
            }
        }
        return i;
    }

    /* renamed from: b */
    public static boolean m10123b(int i, int i2) {
        if (i != 0) {
            return i != 1 ? i == 2 && (i2 & 2) != 0 : (i2 & 1) != 0;
        }
        return true;
    }
}
