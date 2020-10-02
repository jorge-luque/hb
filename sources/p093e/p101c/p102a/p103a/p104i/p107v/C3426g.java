package p093e.p101c.p102a.p103a.p104i.p107v;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3014g;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;
import p188f.p189a.C5913b;
import p188f.p189a.C5915d;
import p193h.p194a.C5925a;

/* renamed from: e.c.a.a.i.v.g */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3426g implements C5913b<C3014g> {

    /* renamed from: a */
    private final C5925a<C3469a> f9527a;

    public C3426g(C5925a<C3469a> aVar) {
        this.f9527a = aVar;
    }

    /* renamed from: a */
    public static C3426g m11394a(C5925a<C3469a> aVar) {
        return new C3426g(aVar);
    }

    /* renamed from: a */
    public static C3014g m11393a(C3469a aVar) {
        C3014g a = C3425f.m11392a(aVar);
        C5915d.m18981a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public C3014g get() {
        return m11393a(this.f9527a.get());
    }
}
