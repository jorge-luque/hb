package com.google.firebase.components;

import com.google.firebase.p123d.C3661c;
import com.google.firebase.p123d.C3662d;
import com.google.firebase.p126f.C3680a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.components.l */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class C3647l extends C3631a {

    /* renamed from: e */
    private static final C3680a<Set<Object>> f10202e = C3646k.m12409a();

    /* renamed from: a */
    private final Map<C3634d<?>, C3655q<?>> f10203a = new HashMap();

    /* renamed from: b */
    private final Map<Class<?>, C3655q<?>> f10204b = new HashMap();

    /* renamed from: c */
    private final Map<Class<?>, C3655q<Set<?>>> f10205c = new HashMap();

    /* renamed from: d */
    private final C3654p f10206d;

    public C3647l(Executor executor, Iterable<C3643h> iterable, C3634d<?>... dVarArr) {
        this.f10206d = new C3654p(executor);
        ArrayList<C3634d> arrayList = new ArrayList<>();
        arrayList.add(C3634d.m12375a(this.f10206d, C3654p.class, C3662d.class, C3661c.class));
        for (C3643h components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        for (C3634d<?> dVar : dVarArr) {
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        C3648m.m12419a((List<C3634d<?>>) arrayList);
        for (C3634d dVar2 : arrayList) {
            this.f10203a.put(dVar2, new C3655q(C3644i.m12407a(this, dVar2)));
        }
        m12412a();
        m12413b();
    }

    /* renamed from: b */
    private void m12413b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f10203a.entrySet()) {
            C3634d dVar = (C3634d) next.getKey();
            if (!dVar.mo27228g()) {
                C3655q qVar = (C3655q) next.getValue();
                for (Class cls : dVar.mo27224c()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(qVar);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            this.f10205c.put((Class) entry.getKey(), new C3655q(C3645j.m12408a((Set) entry.getValue())));
        }
    }

    /* renamed from: c */
    public <T> C3680a<Set<T>> mo27236c(Class<T> cls) {
        C3655q qVar = this.f10205c.get(cls);
        if (qVar != null) {
            return qVar;
        }
        return f10202e;
    }

    /* renamed from: a */
    private void m12412a() {
        for (Map.Entry next : this.f10203a.entrySet()) {
            C3634d dVar = (C3634d) next.getKey();
            if (dVar.mo27228g()) {
                C3655q qVar = (C3655q) next.getValue();
                for (Class put : dVar.mo27224c()) {
                    this.f10204b.put(put, qVar);
                }
            }
        }
        m12414c();
    }

    /* renamed from: c */
    private void m12414c() {
        for (C3634d next : this.f10203a.keySet()) {
            Iterator<C3652n> it = next.mo27222a().iterator();
            while (true) {
                if (it.hasNext()) {
                    C3652n next2 = it.next();
                    if (next2.mo27252c() && !this.f10204b.containsKey(next2.mo27250a())) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.mo27250a()}));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ Set m12411a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((C3655q) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: a */
    public void mo27240a(boolean z) {
        for (Map.Entry next : this.f10203a.entrySet()) {
            C3634d dVar = (C3634d) next.getKey();
            C3655q qVar = (C3655q) next.getValue();
            if (dVar.mo27226e() || (dVar.mo27227f() && z)) {
                qVar.get();
            }
        }
        this.f10206d.mo27258a();
    }

    /* renamed from: b */
    public <T> C3680a<T> mo27235b(Class<T> cls) {
        C3656r.m12444a(cls, "Null interface requested.");
        return this.f10204b.get(cls);
    }
}
