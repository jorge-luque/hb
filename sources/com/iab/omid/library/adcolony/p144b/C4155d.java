package com.iab.omid.library.adcolony.p144b;

import android.annotation.SuppressLint;
import android.content.Context;

/* renamed from: com.iab.omid.library.adcolony.b.d */
public class C4155d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    private static C4155d f11180b = new C4155d();

    /* renamed from: a */
    private Context f11181a;

    private C4155d() {
    }

    /* renamed from: a */
    public static C4155d m13929a() {
        return f11180b;
    }

    /* renamed from: a */
    public void mo28521a(Context context) {
        this.f11181a = context != null ? context.getApplicationContext() : null;
    }

    /* renamed from: b */
    public Context mo28522b() {
        return this.f11181a;
    }
}
