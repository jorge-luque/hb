package com.tapjoy.internal;

import com.tapjoy.internal.C5006ej;

/* renamed from: com.tapjoy.internal.ef */
public abstract class C5000ef extends C5006ej {
    protected C5000ef(Class cls) {
        super(C5001eg.VARINT, cls);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ int mo31092a(Object obj) {
        return C5023el.m16973a(((C5024em) obj).mo31123a());
    }

    /* renamed from: a */
    public abstract C5024em mo31093a(int i);

    /* renamed from: a */
    public final /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
        elVar.mo31119c(((C5024em) obj).mo31123a());
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
        int d = ekVar.mo31113d();
        C5024em a = mo31093a(d);
        if (a != null) {
            return a;
        }
        throw new C5006ej.C5021a(d, this.f13598a);
    }
}
