package com.google.firebase.p124e;

import android.content.Context;
import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3637e;
import com.google.firebase.components.C3642g;
import com.google.firebase.components.C3652n;
import com.google.firebase.p124e.C3666c;

/* renamed from: com.google.firebase.e.b */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class C3665b implements C3666c {

    /* renamed from: a */
    private C3668d f10233a;

    private C3665b(Context context) {
        this.f10233a = C3668d.m12465a(context);
    }

    /* renamed from: a */
    public C3666c.C3667a mo27265a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean a = this.f10233a.mo27268a(str, currentTimeMillis);
        boolean a2 = this.f10233a.mo27267a(currentTimeMillis);
        if (a && a2) {
            return C3666c.C3667a.COMBINED;
        }
        if (a2) {
            return C3666c.C3667a.GLOBAL;
        }
        if (a) {
            return C3666c.C3667a.SDK;
        }
        return C3666c.C3667a.NONE;
    }

    /* renamed from: a */
    public static C3634d<C3666c> m12460a() {
        C3634d.C3636b<C3666c> a = C3634d.m12372a(C3666c.class);
        a.mo27232a(C3652n.m12430b(Context.class));
        a.mo27231a((C3642g<C3666c>) C3664a.m12458a());
        return a.mo27233b();
    }

    /* renamed from: a */
    static /* synthetic */ C3666c m12461a(C3637e eVar) {
        return new C3665b((Context) eVar.mo27220a(Context.class));
    }
}
