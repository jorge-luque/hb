package com.google.android.exoplayer2.util;

import android.os.Build;
import java.util.Formatter;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.util.c */
/* compiled from: Util */
public final class C3071c {

    /* renamed from: a */
    public static final int f8625a = ((Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT);

    /* renamed from: b */
    public static final String f8626b = Build.DEVICE;

    /* renamed from: c */
    public static final String f8627c = Build.MANUFACTURER;

    /* renamed from: d */
    public static final String f8628d = Build.MODEL;

    static {
        f8626b + ", " + f8628d + ", " + f8627c + ", " + f8625a;
        Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
    }

    /* renamed from: a */
    public static boolean m10127a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static int m10124a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    /* renamed from: a */
    public static long m10125a(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    /* renamed from: a */
    public static String m10126a(StringBuilder sb, Formatter formatter, long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j2 = (j + 500) / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        sb.setLength(0);
        if (j5 > 0) {
            return formatter.format("%d:%02d:%02d", new Object[]{Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)}).toString();
        }
        return formatter.format("%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j3)}).toString();
    }
}
