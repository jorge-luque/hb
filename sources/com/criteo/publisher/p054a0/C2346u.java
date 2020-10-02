package com.criteo.publisher.p054a0;

/* renamed from: com.criteo.publisher.a0.u */
public class C2346u {
    /* renamed from: a */
    private static boolean m9007a(String str) {
        if (str == null || str.length() <= 6 || !str.substring(0, 7).equalsIgnoreCase("http://")) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m9008b(String str) {
        if (str == null || str.length() <= 7 || !str.substring(0, 8).equalsIgnoreCase("https://")) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m9009c(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (m9007a(str) || m9008b(str)) {
            return true;
        }
        return false;
    }
}
