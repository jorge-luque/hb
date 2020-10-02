package com.google.android.datatransport.cct;

/* renamed from: com.google.android.datatransport.cct.f */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class C2987f {
    /* renamed from: a */
    static String m9849a(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }
}
