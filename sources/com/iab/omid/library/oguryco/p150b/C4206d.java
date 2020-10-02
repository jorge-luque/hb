package com.iab.omid.library.oguryco.p150b;

import android.annotation.SuppressLint;
import android.content.Context;

/* renamed from: com.iab.omid.library.oguryco.b.d */
public class C4206d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C4206d f11301a = new C4206d();

    /* renamed from: b */
    private Context f11302b;

    private C4206d() {
    }

    /* renamed from: a */
    public static C4206d m14158a() {
        return f11301a;
    }

    /* renamed from: a */
    public void mo28735a(Context context) {
        this.f11302b = context != null ? context.getApplicationContext() : null;
    }

    /* renamed from: b */
    public Context mo28736b() {
        return this.f11302b;
    }
}
