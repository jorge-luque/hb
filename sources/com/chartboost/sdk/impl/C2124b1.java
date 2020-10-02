package com.chartboost.sdk.impl;

/* renamed from: com.chartboost.sdk.impl.b1 */
public class C2124b1 {
    /* renamed from: a */
    public static String m8448a(String str, String str2) {
        Object[] objArr = new Object[3];
        objArr[0] = str;
        String str3 = "/";
        if (str2 != null && str2.startsWith(str3)) {
            str3 = "";
        }
        objArr[1] = str3;
        if (str2 == null) {
            str2 = "";
        }
        objArr[2] = str2;
        return String.format("%s%s%s", objArr);
    }
}
