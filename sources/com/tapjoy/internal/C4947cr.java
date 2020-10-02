package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.cr */
public final class C4947cr {

    /* renamed from: a */
    private final C4955cz f13439a;

    private C4947cr(C4955cz czVar) {
        this.f13439a = czVar;
    }

    /* renamed from: a */
    public static C4947cr m16784a(C4948cs csVar) {
        C4955cz czVar = (C4955cz) csVar;
        C4975do.m16853a((Object) csVar, "AdSession is null");
        if (czVar.f13465c.f13515b == null) {
            C4975do.m16852a(czVar);
            C4947cr crVar = new C4947cr(czVar);
            czVar.f13465c.f13515b = crVar;
            return crVar;
        }
        throw new IllegalStateException("AdEvents already exists for AdSession");
    }

    /* renamed from: a */
    public final void mo31034a() {
        C4975do.m16852a(this.f13439a);
        if (C4952cw.NATIVE == this.f13439a.f13463a.f13440a) {
            if (!this.f13439a.mo31041d()) {
                try {
                    this.f13439a.mo31035a();
                } catch (Exception unused) {
                }
            }
            if (this.f13439a.mo31041d()) {
                C4955cz czVar = this.f13439a;
                if (!czVar.f13469g) {
                    C4964dg.m16825a().mo31062a(czVar.f13465c.mo31075c(), "publishImpressionEvent", new Object[0]);
                    czVar.f13469g = true;
                    return;
                }
                throw new IllegalStateException("Impression event can only be sent once");
            }
            return;
        }
        throw new IllegalStateException("Impression event is not expected from the Native AdSession");
    }
}
