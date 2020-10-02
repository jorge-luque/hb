package com.criteo.publisher;

import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2440f;
import com.criteo.publisher.model.C2450k;
import com.criteo.publisher.model.C2451l;
import com.criteo.publisher.model.C2454o;
import com.criteo.publisher.model.C2455p;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.p054a0.C2331i;
import com.criteo.publisher.p058q.C2503a;
import com.criteo.publisher.p059r.C2507a;
import com.criteo.publisher.p061t.C2555v;
import com.criteo.publisher.p065x.C2574b;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.criteo.publisher.b */
public class C2376b {

    /* renamed from: a */
    private final C2507a f7766a;

    /* renamed from: b */
    private final Object f7767b = new Object();

    /* renamed from: c */
    private final AtomicLong f7768c = new AtomicLong(0);

    /* renamed from: d */
    private final C2455p f7769d;

    /* renamed from: e */
    private final C2379c f7770e;

    /* renamed from: f */
    private final C2440f f7771f;

    /* renamed from: g */
    private final C2574b f7772g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C2503a f7773h;

    /* renamed from: i */
    private final C2555v f7774i;

    /* renamed from: com.criteo.publisher.b$b */
    private class C2378b implements C2331i {
        private C2378b() {
        }

        /* renamed from: a */
        public void mo10142a(C2451l lVar) {
            C2376b.this.f7773h.mo10511a(lVar);
        }

        /* renamed from: a */
        public void mo10143a(C2451l lVar, C2454o oVar) {
            C2376b.this.mo10236b(oVar.mo10378a());
            C2376b.this.mo10234a(oVar.mo10379b());
            C2376b.this.f7773h.mo10512a(lVar, oVar);
        }

        /* renamed from: a */
        public void mo10144a(C2451l lVar, Exception exc) {
            C2376b.this.f7773h.mo10513a(lVar, exc);
        }
    }

    C2376b(C2507a aVar, C2455p pVar, C2379c cVar, C2440f fVar, C2574b bVar, C2503a aVar2, C2555v vVar) {
        this.f7766a = aVar;
        this.f7769d = pVar;
        this.f7770e = cVar;
        this.f7771f = fVar;
        this.f7772g = bVar;
        this.f7773h = aVar2;
        this.f7774i = vVar;
    }

    /* renamed from: c */
    private void m9049c(List<C2450k> list) {
        if (!m9048b()) {
            this.f7772g.mo10620a(list, (C2331i) new C2378b());
            this.f7774i.mo10594a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10236b(List<C2465w> list) {
        long a = this.f7770e.mo10237a();
        synchronized (this.f7767b) {
            for (C2465w next : list) {
                if (next.mo10415k()) {
                    if (next.mo10405b().doubleValue() > 0.0d && next.mo10412h() == 0) {
                        next.mo10402a(900);
                    }
                    next.mo10403a(a);
                    this.f7766a.mo10518a(next);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9047a(C2450k kVar) {
        if (this.f7768c.get() <= this.f7770e.mo10237a()) {
            m9049c(Collections.singletonList(kVar));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007f, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.criteo.publisher.model.C2465w mo10232a(com.criteo.publisher.model.AdUnit r19) {
        /*
            r18 = this;
            r1 = r18
            boolean r0 = r18.m9048b()
            r2 = 0
            if (r0 == 0) goto L_0x000a
            return r2
        L_0x000a:
            com.criteo.publisher.model.f r0 = r1.f7771f
            r3 = r19
            com.criteo.publisher.model.k r0 = r0.mo10353a((com.criteo.publisher.model.AdUnit) r3)
            if (r0 != 0) goto L_0x001c
            java.lang.String r0 = "ContentValues"
            java.lang.String r3 = "Valid AdUnit is required."
            android.util.Log.e(r0, r3)
            return r2
        L_0x001c:
            java.lang.Object r3 = r1.f7767b
            monitor-enter(r3)
            com.criteo.publisher.r.a r4 = r1.f7766a     // Catch:{ all -> 0x0080 }
            com.criteo.publisher.model.w r4 = r4.mo10517a((com.criteo.publisher.model.C2450k) r0)     // Catch:{ all -> 0x0080 }
            if (r4 != 0) goto L_0x002c
            r1.m9047a((com.criteo.publisher.model.C2450k) r0)     // Catch:{ all -> 0x0080 }
            monitor-exit(r3)     // Catch:{ all -> 0x0080 }
            return r2
        L_0x002c:
            java.lang.Double r5 = r4.mo10405b()     // Catch:{ all -> 0x0080 }
            r6 = 0
            if (r5 != 0) goto L_0x0036
            r8 = r6
            goto L_0x003e
        L_0x0036:
            java.lang.Double r5 = r4.mo10405b()     // Catch:{ all -> 0x0080 }
            double r8 = r5.doubleValue()     // Catch:{ all -> 0x0080 }
        L_0x003e:
            int r5 = r4.mo10412h()     // Catch:{ all -> 0x0080 }
            long r10 = (long) r5     // Catch:{ all -> 0x0080 }
            com.criteo.publisher.c r5 = r1.f7770e     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.mo10404a((com.criteo.publisher.C2379c) r5)     // Catch:{ all -> 0x0080 }
            r12 = 1
            r5 = r5 ^ r12
            r13 = 0
            r15 = 0
            int r16 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r16 <= 0) goto L_0x0059
            int r16 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r16 <= 0) goto L_0x0059
            r16 = 1
            goto L_0x005b
        L_0x0059:
            r16 = 0
        L_0x005b:
            int r17 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r17 != 0) goto L_0x0064
            int r6 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r12 = 0
        L_0x0065:
            if (r12 == 0) goto L_0x006b
            if (r5 == 0) goto L_0x006b
            monitor-exit(r3)     // Catch:{ all -> 0x0080 }
            return r2
        L_0x006b:
            com.criteo.publisher.q.a r6 = r1.f7773h     // Catch:{ all -> 0x0080 }
            r6.mo10510a((com.criteo.publisher.model.C2450k) r0, (com.criteo.publisher.model.C2465w) r4)     // Catch:{ all -> 0x0080 }
            com.criteo.publisher.r.a r6 = r1.f7766a     // Catch:{ all -> 0x0080 }
            r6.mo10519b((com.criteo.publisher.model.C2450k) r0)     // Catch:{ all -> 0x0080 }
            r1.m9047a((com.criteo.publisher.model.C2450k) r0)     // Catch:{ all -> 0x0080 }
            if (r16 == 0) goto L_0x007e
            if (r5 == 0) goto L_0x007e
            monitor-exit(r3)     // Catch:{ all -> 0x0080 }
            return r4
        L_0x007e:
            monitor-exit(r3)     // Catch:{ all -> 0x0080 }
            return r2
        L_0x0080:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0080 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.C2376b.mo10232a(com.criteo.publisher.model.AdUnit):com.criteo.publisher.model.w");
    }

    /* renamed from: b */
    private boolean m9048b() {
        return this.f7769d.mo10387f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10234a(int i) {
        if (i > 0) {
            this.f7768c.set(this.f7770e.mo10237a() + ((long) (i * 1000)));
        }
    }

    /* renamed from: a */
    public void mo10233a() {
        this.f7772g.mo10618a();
    }

    /* renamed from: a */
    public void mo10235a(List<AdUnit> list) {
        List<List<C2450k>> a = this.f7771f.mo10354a(list);
        this.f7772g.mo10619a(this.f7769d);
        for (List<C2450k> c : a) {
            m9049c(c);
        }
    }
}
