package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;

/* renamed from: com.tapjoy.internal.gc */
abstract class C5117gc {

    /* renamed from: a */
    private static final C5117gc f14005a;

    /* renamed from: b */
    private static C5117gc f14006b;

    static {
        C5118gd gdVar = new C5118gd();
        f14005a = gdVar;
        f14006b = gdVar;
    }

    C5117gc() {
    }

    /* renamed from: a */
    static C5117gc m17257a() {
        return f14006b;
    }

    /* renamed from: a */
    public abstract Object mo31295a(Context context, String str, TJPlacementListener tJPlacementListener);

    /* renamed from: b */
    public abstract Object mo31296b();
}
