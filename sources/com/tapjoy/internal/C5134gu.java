package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.gu */
public final class C5134gu {
    /* renamed from: a */
    public static String m17311a(String str) {
        String trim;
        if (str == null || str.length() == 0 || (trim = str.trim()) == null || trim.length() == 0) {
            return null;
        }
        return trim;
    }

    /* renamed from: b */
    public static String m17313b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim;
    }

    /* renamed from: a */
    public static String m17312a(String str, String str2, String str3) {
        if (str == null) {
            C5139gw.m17324a(str2, str3, "must not be null");
            return null;
        } else if (str.length() == 0) {
            C5139gw.m17324a(str2, str3, "must not be empty");
            return null;
        } else {
            String trim = str.trim();
            if (trim.length() != 0) {
                return trim;
            }
            C5139gw.m17324a(str2, str3, "must not be blank");
            return null;
        }
    }
}
