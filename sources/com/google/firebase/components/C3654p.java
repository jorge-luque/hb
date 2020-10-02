package com.google.firebase.components;

import com.google.firebase.p123d.C3659a;
import com.google.firebase.p123d.C3660b;
import com.google.firebase.p123d.C3661c;
import com.google.firebase.p123d.C3662d;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.components.p */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
class C3654p implements C3662d, C3661c {

    /* renamed from: a */
    private final Map<Class<?>, ConcurrentHashMap<C3660b<Object>, Executor>> f10217a = new HashMap();

    /* renamed from: b */
    private Queue<C3659a<?>> f10218b = new ArrayDeque();

    /* renamed from: c */
    private final Executor f10219c;

    C3654p(Executor executor) {
        this.f10219c = executor;
    }

    /* renamed from: b */
    private synchronized Set<Map.Entry<C3660b<Object>, Executor>> m12438b(C3659a<?> aVar) {
        Map map;
        map = this.f10217a.get(aVar.mo27263b());
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0.hasNext() == false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r1 = r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(com.google.firebase.components.C3653o.m12436a(r1, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = m12438b(r4).iterator();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27259a(com.google.firebase.p123d.C3659a<?> r4) {
        /*
            r3 = this;
            com.google.firebase.components.C3656r.m12443a(r4)
            monitor-enter(r3)
            java.util.Queue<com.google.firebase.d.a<?>> r0 = r3.f10218b     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x000f
            java.util.Queue<com.google.firebase.d.a<?>> r0 = r3.f10218b     // Catch:{ all -> 0x0033 }
            r0.add(r4)     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x000f:
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            java.util.Set r0 = r3.m12438b(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            java.lang.Runnable r1 = com.google.firebase.components.C3653o.m12436a(r1, r4)
            r2.execute(r1)
            goto L_0x0018
        L_0x0032:
            return
        L_0x0033:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            goto L_0x0037
        L_0x0036:
            throw r4
        L_0x0037:
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.C3654p.mo27259a(com.google.firebase.d.a):void");
    }

    /* renamed from: a */
    public synchronized <T> void mo27261a(Class<T> cls, Executor executor, C3660b<? super T> bVar) {
        C3656r.m12443a(cls);
        C3656r.m12443a(bVar);
        C3656r.m12443a(executor);
        if (!this.f10217a.containsKey(cls)) {
            this.f10217a.put(cls, new ConcurrentHashMap());
        }
        this.f10217a.get(cls).put(bVar, executor);
    }

    /* renamed from: a */
    public <T> void mo27260a(Class<T> cls, C3660b<? super T> bVar) {
        mo27261a(cls, this.f10219c, bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27258a() {
        Queue<C3659a<?>> queue;
        synchronized (this) {
            queue = null;
            if (this.f10218b != null) {
                Queue<C3659a<?>> queue2 = this.f10218b;
                this.f10218b = null;
                queue = queue2;
            }
        }
        if (queue != null) {
            for (C3659a a : queue) {
                mo27259a(a);
            }
        }
    }
}
