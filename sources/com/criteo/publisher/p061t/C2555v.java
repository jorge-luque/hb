package com.criteo.publisher.p061t;

import com.criteo.publisher.C2433m;
import com.criteo.publisher.model.C2455p;
import com.criteo.publisher.p054a0.C2330h;
import com.criteo.publisher.p065x.C2579d;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.criteo.publisher.t.v */
public class C2555v {

    /* renamed from: a */
    private final C2554u f8090a;

    /* renamed from: b */
    private final C2579d f8091b;

    /* renamed from: c */
    private final C2330h f8092c;

    /* renamed from: d */
    private final C2455p f8093d;

    /* renamed from: e */
    private final Executor f8094e;

    /* renamed from: com.criteo.publisher.t.v$b */
    private static class C2557b extends C2433m {

        /* renamed from: c */
        private final C2554u f8095c;

        /* renamed from: d */
        private final C2579d f8096d;

        /* renamed from: e */
        private final C2330h f8097e;

        /* renamed from: b */
        private void m9602b(Collection<C2540m> collection) {
            for (C2540m a : collection) {
                this.f8095c.mo10579a(a);
            }
        }

        /* renamed from: a */
        public void mo10204a() throws IOException {
            List<C2540m> a = this.f8095c.mo10578a(this.f8097e.mo10131d());
            if (!a.isEmpty()) {
                try {
                    this.f8096d.mo10627a(m9601a(a));
                } catch (Throwable th) {
                    m9602b(a);
                    throw th;
                }
            }
        }

        private C2557b(C2554u uVar, C2579d dVar, C2330h hVar) {
            this.f8095c = uVar;
            this.f8096d = dVar;
            this.f8097e = hVar;
        }

        /* renamed from: a */
        private C2551t m9601a(Collection<C2540m> collection) {
            return C2551t.m9579a(collection, this.f8097e.mo10140m(), this.f8097e.mo10139l());
        }
    }

    public C2555v(C2554u uVar, C2579d dVar, C2330h hVar, C2455p pVar, Executor executor) {
        this.f8090a = uVar;
        this.f8091b = dVar;
        this.f8092c = hVar;
        this.f8093d = pVar;
        this.f8094e = executor;
    }

    /* renamed from: a */
    public void mo10594a() {
        if (this.f8093d.mo10386e()) {
            this.f8094e.execute(new C2557b(this.f8090a, this.f8091b, this.f8092c));
        }
    }
}
