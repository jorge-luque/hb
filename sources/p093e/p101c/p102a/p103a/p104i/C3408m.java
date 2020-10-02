package p093e.p101c.p102a.p103a.p104i;

import java.util.Set;
import p093e.p101c.p102a.p103a.C3378b;
import p093e.p101c.p102a.p103a.C3381e;
import p093e.p101c.p102a.p103a.C3382f;
import p093e.p101c.p102a.p103a.C3383g;

/* renamed from: e.c.a.a.i.m */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3408m implements C3383g {

    /* renamed from: a */
    private final Set<C3378b> f9490a;

    /* renamed from: b */
    private final C3406l f9491b;

    /* renamed from: c */
    private final C3411p f9492c;

    C3408m(Set<C3378b> set, C3406l lVar, C3411p pVar) {
        this.f9490a = set;
        this.f9491b = lVar;
        this.f9492c = pVar;
    }

    /* renamed from: a */
    public <T> C3382f<T> mo19151a(String str, Class<T> cls, C3378b bVar, C3381e<T, byte[]> eVar) {
        if (this.f9490a.contains(bVar)) {
            return new C3410o(this.f9491b, str, bVar, eVar, this.f9492c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{bVar, this.f9490a}));
    }
}
