package com.criteo.publisher.p062u;

import com.criteo.publisher.C2376b;
import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2465w;
import java.util.List;

/* renamed from: com.criteo.publisher.u.b */
public class C2566b {

    /* renamed from: a */
    private final C2376b f8115a;

    /* renamed from: b */
    private final List<C2567c> f8116b;

    public C2566b(C2376b bVar, List<C2567c> list) {
        this.f8115a = bVar;
        this.f8116b = list;
    }

    /* renamed from: a */
    public void mo10607a(Object obj, AdUnit adUnit) {
        if (obj != null) {
            for (C2567c next : this.f8116b) {
                if (next.mo10605a(obj)) {
                    C2465w a = this.f8115a.mo10232a(adUnit);
                    if (a != null) {
                        next.mo10604a(obj, adUnit, a);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
