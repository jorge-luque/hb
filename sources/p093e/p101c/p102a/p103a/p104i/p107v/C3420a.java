package p093e.p101c.p102a.p103a.p104i.p107v;

import p093e.p101c.p102a.p103a.C3384h;
import p093e.p101c.p102a.p103a.p104i.C3400h;
import p093e.p101c.p102a.p103a.p104i.C3406l;

/* renamed from: e.c.a.a.i.v.a */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3420a implements Runnable {

    /* renamed from: a */
    private final C3422c f9509a;

    /* renamed from: b */
    private final C3406l f9510b;

    /* renamed from: c */
    private final C3384h f9511c;

    /* renamed from: d */
    private final C3400h f9512d;

    private C3420a(C3422c cVar, C3406l lVar, C3384h hVar, C3400h hVar2) {
        this.f9509a = cVar;
        this.f9510b = lVar;
        this.f9511c = hVar;
        this.f9512d = hVar2;
    }

    /* renamed from: a */
    public static Runnable m11385a(C3422c cVar, C3406l lVar, C3384h hVar, C3400h hVar2) {
        return new C3420a(cVar, lVar, hVar, hVar2);
    }

    public void run() {
        C3422c.m11388a(this.f9509a, this.f9510b, this.f9511c, this.f9512d);
    }
}
