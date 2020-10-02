package com.criteo.publisher.p058q;

import com.criteo.publisher.model.C2450k;
import com.criteo.publisher.model.C2451l;
import com.criteo.publisher.model.C2454o;
import com.criteo.publisher.model.C2465w;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.criteo.publisher.q.b */
public class C2504b implements C2503a {

    /* renamed from: a */
    private final List<C2503a> f7996a = new ArrayList();

    /* renamed from: a */
    public void mo10514a(C2503a aVar) {
        this.f7996a.add(aVar);
    }

    /* renamed from: a */
    public void mo10509a() {
        for (C2503a a : this.f7996a) {
            a.mo10509a();
        }
    }

    /* renamed from: a */
    public void mo10511a(C2451l lVar) {
        for (C2503a a : this.f7996a) {
            a.mo10511a(lVar);
        }
    }

    /* renamed from: a */
    public void mo10512a(C2451l lVar, C2454o oVar) {
        for (C2503a a : this.f7996a) {
            a.mo10512a(lVar, oVar);
        }
    }

    /* renamed from: a */
    public void mo10513a(C2451l lVar, Exception exc) {
        for (C2503a a : this.f7996a) {
            a.mo10513a(lVar, exc);
        }
    }

    /* renamed from: a */
    public void mo10510a(C2450k kVar, C2465w wVar) {
        for (C2503a a : this.f7996a) {
            a.mo10510a(kVar, wVar);
        }
    }
}
