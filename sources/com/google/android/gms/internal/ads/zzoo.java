package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzoo {
    public static boolean zzbd(String str) {
        return "audio".equals(zzbf(str));
    }

    public static boolean zzbe(String str) {
        return "video".equals(zzbf(str));
    }

    private static String zzbf(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid mime type: ".concat(valueOf) : new String("Invalid mime type: "));
    }
}
