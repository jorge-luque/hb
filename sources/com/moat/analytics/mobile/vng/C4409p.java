package com.moat.analytics.mobile.vng;

import android.util.Log;
import android.view.View;

/* renamed from: com.moat.analytics.mobile.vng.p */
class C4409p {
    C4409p() {
    }

    /* renamed from: a */
    static String m14770a(View view) {
        if (view == null) {
            return "null";
        }
        return view.getClass().getSimpleName() + "@" + view.hashCode();
    }

    /* renamed from: a */
    private static String m14771a(String str) {
        return "Moat" + str;
    }

    /* renamed from: a */
    static void m14772a(int i, String str, Object obj, String str2) {
        String str3;
        if (C4424w.m14808a().f11857b) {
            String a = m14771a(str);
            if (obj == null) {
                str3 = String.format("message = %s", new Object[]{str2});
            } else {
                str3 = String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2});
            }
            Log.println(i, a, str3);
        }
    }

    /* renamed from: a */
    static void m14773a(String str, int i, String str2, Object obj, String str3) {
        m14772a(i, str2, obj, str3);
        m14775a(str, str3);
    }

    /* renamed from: a */
    static void m14774a(String str, Object obj, String str2, Throwable th) {
        if (C4424w.m14808a().f11857b) {
            Log.e(m14771a(str), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}), th);
        }
    }

    /* renamed from: a */
    static void m14775a(String str, String str2) {
        if (!C4424w.m14808a().f11857b && ((C4400k) MoatAnalytics.getInstance()).f11807a) {
            int i = 2;
            if (str.equals("[ERROR] ")) {
                i = 6;
            }
            Log.println(i, "MoatAnalytics", str + str2);
        }
    }

    /* renamed from: b */
    static void m14776b(int i, String str, Object obj, String str2) {
        if (C4424w.m14808a().f11858c) {
            String a = m14771a(str);
            Object[] objArr = new Object[2];
            objArr[0] = obj == null ? "null" : Integer.valueOf(obj.hashCode());
            objArr[1] = str2;
            Log.println(i, a, String.format("id = %s, message = %s", objArr));
        }
    }
}
