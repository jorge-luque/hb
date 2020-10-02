package com.criteo.publisher.p065x;

import com.criteo.publisher.C2433m;
import com.criteo.publisher.model.C2450k;
import com.criteo.publisher.model.C2451l;
import com.criteo.publisher.model.C2452m;
import com.criteo.publisher.model.C2455p;
import com.criteo.publisher.model.C2463u;
import com.criteo.publisher.p054a0.C2331i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* renamed from: com.criteo.publisher.x.b */
public class C2574b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C2452m f8130a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C2463u f8131b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C2579d f8132c;

    /* renamed from: d */
    private final Executor f8133d;

    /* renamed from: e */
    private final Map<C2450k, Future<?>> f8134e;

    /* renamed from: f */
    private final Object f8135f = new Object();

    /* renamed from: com.criteo.publisher.x.b$a */
    class C2575a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C2576b f8136a;

        /* renamed from: b */
        final /* synthetic */ List f8137b;

        C2575a(C2576b bVar, List list) {
            this.f8136a = bVar;
            this.f8137b = list;
        }

        public void run() {
            try {
                this.f8136a.run();
            } finally {
                C2574b.this.m9657a((List<C2450k>) this.f8137b);
            }
        }
    }

    /* renamed from: com.criteo.publisher.x.b$b */
    private class C2576b extends C2433m {

        /* renamed from: c */
        private final List<C2450k> f8139c;

        /* renamed from: d */
        private final C2331i f8140d;

        /* synthetic */ C2576b(C2574b bVar, List list, C2331i iVar, C2575a aVar) {
            this(list, iVar);
        }

        /* renamed from: a */
        public void mo10204a() throws ExecutionException, InterruptedException {
            C2451l a = C2574b.this.f8130a.mo10374a(this.f8139c);
            String str = C2574b.this.f8130a.mo10375a().get();
            this.f8140d.mo10142a(a);
            try {
                this.f8140d.mo10143a(a, C2574b.this.f8132c.mo10622a(a, str));
            } catch (Exception e) {
                this.f8140d.mo10144a(a, e);
            }
        }

        private C2576b(List<C2450k> list, C2331i iVar) {
            this.f8139c = list;
            this.f8140d = iVar;
        }
    }

    /* renamed from: com.criteo.publisher.x.b$c */
    private class C2577c extends C2433m {

        /* renamed from: c */
        private final C2455p f8142c;

        /* synthetic */ C2577c(C2574b bVar, C2455p pVar, C2575a aVar) {
            this(pVar);
        }

        /* renamed from: a */
        public void mo10204a() throws IOException {
            this.f8142c.mo10382a(C2574b.this.f8132c.mo10623a(C2574b.this.f8131b.mo10399a()));
        }

        private C2577c(C2455p pVar) {
            this.f8142c = pVar;
        }
    }

    public C2574b(C2452m mVar, C2463u uVar, C2579d dVar, Executor executor) {
        this.f8130a = mVar;
        this.f8131b = uVar;
        this.f8132c = dVar;
        this.f8133d = executor;
        this.f8134e = new ConcurrentHashMap();
    }

    /* renamed from: b */
    private FutureTask<Void> m9659b(List<C2450k> list, C2331i iVar) {
        return new FutureTask<>(new C2575a(new C2576b(this, list, iVar, (C2575a) null), list), (Object) null);
    }

    /* renamed from: a */
    public void mo10619a(C2455p pVar) {
        this.f8133d.execute(new C2577c(this, pVar, (C2575a) null));
    }

    /* renamed from: a */
    public void mo10620a(List<C2450k> list, C2331i iVar) {
        ArrayList<C2450k> arrayList = new ArrayList<>(list);
        synchronized (this.f8135f) {
            arrayList.removeAll(this.f8134e.keySet());
            if (!arrayList.isEmpty()) {
                FutureTask<Void> b = m9659b(arrayList, iVar);
                for (C2450k put : arrayList) {
                    this.f8134e.put(put, b);
                }
                try {
                    this.f8133d.execute(b);
                } catch (Throwable th) {
                    if (b != null) {
                        m9657a((List<C2450k>) arrayList);
                    }
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9657a(List<C2450k> list) {
        synchronized (this.f8135f) {
            this.f8134e.keySet().removeAll(list);
        }
    }

    /* renamed from: a */
    public void mo10618a() {
        synchronized (this.f8135f) {
            for (Future<?> cancel : this.f8134e.values()) {
                cancel.cancel(true);
            }
            this.f8134e.clear();
        }
    }
}
