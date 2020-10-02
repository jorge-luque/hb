package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p045b.C1697a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.k */
public class C1779k {

    /* renamed from: a */
    private final List<C1780a> f5495a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.mediation.k$a */
    public interface C1780a {
        /* renamed from: a */
        void mo7969a(C1697a aVar);
    }

    /* renamed from: a */
    public void mo7966a(C1697a aVar) {
        Iterator it = new ArrayList(this.f5495a).iterator();
        while (it.hasNext()) {
            ((C1780a) it.next()).mo7969a(aVar);
        }
    }

    /* renamed from: a */
    public void mo7967a(C1780a aVar) {
        this.f5495a.add(aVar);
    }

    /* renamed from: b */
    public void mo7968b(C1780a aVar) {
        this.f5495a.remove(aVar);
    }
}
