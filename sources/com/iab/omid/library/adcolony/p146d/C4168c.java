package com.iab.omid.library.adcolony.p146d;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.adcolony.C4142a;

/* renamed from: com.iab.omid.library.adcolony.d.c */
public final class C4168c {
    /* renamed from: a */
    public static void m13995a(String str) {
        if (C4142a.f11107a.booleanValue()) {
            boolean isEmpty = TextUtils.isEmpty(str);
        }
    }

    /* renamed from: a */
    public static void m13996a(String str, Exception exc) {
        if ((C4142a.f11107a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
