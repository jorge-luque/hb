package com.criteo.publisher.model;

import com.criteo.publisher.p054a0.C2330h;
import com.criteo.publisher.p054a0.C2338m;
import com.criteo.publisher.p054a0.C2345t;
import com.criteo.publisher.p058q.C2506d;
import com.criteo.publisher.p066y.C2580a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* renamed from: com.criteo.publisher.model.m */
public class C2452m {

    /* renamed from: a */
    private final C2460s f7900a;

    /* renamed from: b */
    private final C2456q f7901b;

    /* renamed from: c */
    private final C2338m f7902c;

    /* renamed from: d */
    private final C2580a f7903d;

    /* renamed from: e */
    private final C2506d f7904e;

    /* renamed from: f */
    private final C2330h f7905f;

    public C2452m(C2460s sVar, C2456q qVar, C2338m mVar, C2580a aVar, C2506d dVar, C2330h hVar) {
        this.f7900a = sVar;
        this.f7901b = qVar;
        this.f7902c = mVar;
        this.f7903d = aVar;
        this.f7904e = dVar;
        this.f7905f = hVar;
    }

    /* renamed from: b */
    private List<C2453n> m9261b(List<C2450k> list) {
        ArrayList arrayList = new ArrayList();
        for (C2450k a : list) {
            arrayList.add(m9260a(a));
        }
        return arrayList;
    }

    /* renamed from: a */
    public C2451l mo10374a(List<C2450k> list) {
        return new C2451l(this.f7900a, C2466x.m9331a(this.f7902c.mo10156b(), C2345t.m9005a(this.f7903d.mo10632c()), C2345t.m9005a(this.f7903d.mo10631b()), C2345t.m9005a(this.f7903d.mo10633d())), this.f7905f.mo10140m(), this.f7905f.mo10139l(), this.f7903d.mo10628a(), m9261b(list));
    }

    /* renamed from: a */
    private C2453n m9260a(C2450k kVar) {
        return C2453n.m9264a(this.f7904e.mo10515a(), kVar.mo10366b(), kVar.mo10365a(), kVar.mo10367c());
    }

    /* renamed from: a */
    public Future<String> mo10375a() {
        return this.f7901b.mo10295a();
    }
}
