package p118io.presage;

import java.util.LinkedList;
import java.util.List;

/* renamed from: io.presage.ck */
public final class C6274ck implements C6272ci {

    /* renamed from: a */
    private LinkedList<C6275cl> f16905a = new LinkedList<>();

    /* renamed from: b */
    private final C6270cg f16906b;

    public C6274ck(C6270cg cgVar) {
        this.f16906b = cgVar;
    }

    /* renamed from: b */
    private final void m21087b() {
        C6275cl pollFirst = this.f16905a.pollFirst();
        if (pollFirst != null) {
            pollFirst.mo34862a(this.f16906b);
        }
    }

    /* renamed from: a */
    public final void mo34861a(List<? extends C6275cl> list) {
        this.f16905a.addAll(list);
        m21087b();
    }

    /* renamed from: a */
    public final void mo34860a() {
        m21087b();
    }
}
