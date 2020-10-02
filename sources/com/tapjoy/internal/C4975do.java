package com.tapjoy.internal;

import android.text.TextUtils;

/* renamed from: com.tapjoy.internal.do */
public final class C4975do {
    /* renamed from: a */
    public static void m16852a(C4955cz czVar) {
        if (czVar.f13467e) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: a */
    public static void m16853a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m16854a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: b */
    public static void m16855b(C4955cz czVar) {
        if (czVar.f13466d) {
            m16852a(czVar);
            return;
        }
        throw new IllegalStateException("AdSession is not started");
    }
}
