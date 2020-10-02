package com.iab.omid.library.oguryco.p152d;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.oguryco.C4193a;

/* renamed from: com.iab.omid.library.oguryco.d.c */
public final class C4219c {
    /* renamed from: a */
    public static void m14224a(String str) {
        if (C4193a.f11260a.booleanValue()) {
            boolean isEmpty = TextUtils.isEmpty(str);
        }
    }

    /* renamed from: a */
    public static void m14225a(String str, Exception exc) {
        if ((C4193a.f11260a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
