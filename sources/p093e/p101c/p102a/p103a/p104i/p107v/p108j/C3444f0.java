package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.content.Context;
import p188f.p189a.C5913b;
import p193h.p194a.C5925a;

/* renamed from: e.c.a.a.i.v.j.f0 */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3444f0 implements C5913b<C3441e0> {

    /* renamed from: a */
    private final C5925a<Context> f9559a;

    /* renamed from: b */
    private final C5925a<Integer> f9560b;

    public C3444f0(C5925a<Context> aVar, C5925a<Integer> aVar2) {
        this.f9559a = aVar;
        this.f9560b = aVar2;
    }

    /* renamed from: a */
    public static C3444f0 m11446a(C5925a<Context> aVar, C5925a<Integer> aVar2) {
        return new C3444f0(aVar, aVar2);
    }

    public C3441e0 get() {
        return new C3441e0(this.f9559a.get(), this.f9560b.get().intValue());
    }
}
