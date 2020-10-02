package com.criteo.publisher.p066y.p067b;

import android.content.Context;
import android.preference.PreferenceManager;
import com.criteo.publisher.p054a0.C2343r;

/* renamed from: com.criteo.publisher.y.b.d */
public class C2585d {

    /* renamed from: a */
    private final C2589h f8160a;

    public C2585d(Context context) {
        this(new C2589h(new C2343r(PreferenceManager.getDefaultSharedPreferences(context))));
    }

    /* renamed from: a */
    public C2584c mo10645a() {
        C2588g a = this.f8160a.mo10651a();
        Boolean bool = null;
        if (a == null) {
            return null;
        }
        String b = a.mo10647b();
        String c = a.mo10648c();
        if (!b.isEmpty()) {
            bool = Boolean.valueOf("1".equals(b));
        }
        return C2584c.m9695a(c, bool, a.mo10646a());
    }

    C2585d(C2589h hVar) {
        this.f8160a = hVar;
    }
}
