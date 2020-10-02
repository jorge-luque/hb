package bolts;

import bolts.C1167g;

/* renamed from: bolts.i */
/* compiled from: UnobservedErrorNotifier */
class C1177i {

    /* renamed from: a */
    private C1167g<?> f3231a;

    public C1177i(C1167g<?> gVar) {
        this.f3231a = gVar;
    }

    /* renamed from: a */
    public void mo6203a() {
        this.f3231a = null;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        C1167g.C1175g i;
        try {
            C1167g<?> gVar = this.f3231a;
            if (!(gVar == null || (i = C1167g.m4780i()) == null)) {
                i.mo6195a(gVar, new UnobservedTaskException(gVar.mo6182a()));
            }
        } finally {
            super.finalize();
        }
    }
}
