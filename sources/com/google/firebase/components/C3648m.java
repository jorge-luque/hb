package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.firebase.components.m */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
class C3648m {

    /* renamed from: com.google.firebase.components.m$b */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    private static class C3650b {

        /* renamed from: a */
        private final C3634d<?> f10207a;

        /* renamed from: b */
        private final Set<C3650b> f10208b = new HashSet();

        /* renamed from: c */
        private final Set<C3650b> f10209c = new HashSet();

        C3650b(C3634d<?> dVar) {
            this.f10207a = dVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27242a(C3650b bVar) {
            this.f10208b.add(bVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo27244b(C3650b bVar) {
            this.f10209c.add(bVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo27245c(C3650b bVar) {
            this.f10209c.remove(bVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo27247d() {
            return this.f10209c.isEmpty();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3634d<?> mo27241a() {
            return this.f10207a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Set<C3650b> mo27243b() {
            return this.f10208b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo27246c() {
            return this.f10208b.isEmpty();
        }
    }

    /* renamed from: com.google.firebase.components.m$c */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    private static class C3651c {

        /* renamed from: a */
        private final Class<?> f10210a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final boolean f10211b;

        public boolean equals(Object obj) {
            if (!(obj instanceof C3651c)) {
                return false;
            }
            C3651c cVar = (C3651c) obj;
            if (!cVar.f10210a.equals(this.f10210a) || cVar.f10211b != this.f10211b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((this.f10210a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f10211b).hashCode();
        }

        private C3651c(Class<?> cls, boolean z) {
            this.f10210a = cls;
            this.f10211b = z;
        }
    }

    /* renamed from: a */
    static void m12419a(List<C3634d<?>> list) {
        Set<C3650b> b = m12420b(list);
        Set<C3650b> a = m12418a(b);
        int i = 0;
        while (!a.isEmpty()) {
            C3650b next = a.iterator().next();
            a.remove(next);
            i++;
            for (C3650b next2 : next.mo27243b()) {
                next2.mo27245c(next);
                if (next2.mo27247d()) {
                    a.add(next2);
                }
            }
        }
        if (i != list.size()) {
            ArrayList arrayList = new ArrayList();
            for (C3650b next3 : b) {
                if (!next3.mo27247d() && !next3.mo27246c()) {
                    arrayList.add(next3.mo27241a());
                }
            }
            throw new DependencyCycleException(arrayList);
        }
    }

    /* renamed from: b */
    private static Set<C3650b> m12420b(List<C3634d<?>> list) {
        Set<C3650b> set;
        HashMap hashMap = new HashMap(list.size());
        for (C3634d next : list) {
            C3650b bVar = new C3650b(next);
            Iterator it = next.mo27224c().iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls = (Class) it.next();
                    C3651c cVar = new C3651c(cls, !next.mo27228g());
                    if (!hashMap.containsKey(cVar)) {
                        hashMap.put(cVar, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(cVar);
                    if (set2.isEmpty() || cVar.f10211b) {
                        set2.add(bVar);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{cls}));
                    }
                }
            }
        }
        for (Set<C3650b> it2 : hashMap.values()) {
            for (C3650b bVar2 : it2) {
                for (C3652n next2 : bVar2.mo27241a().mo27222a()) {
                    if (next2.mo27251b() && (set = (Set) hashMap.get(new C3651c(next2.mo27250a(), next2.mo27253d()))) != null) {
                        for (C3650b bVar3 : set) {
                            bVar2.mo27242a(bVar3);
                            bVar3.mo27244b(bVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        return hashSet;
    }

    /* renamed from: a */
    private static Set<C3650b> m12418a(Set<C3650b> set) {
        HashSet hashSet = new HashSet();
        for (C3650b next : set) {
            if (next.mo27247d()) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }
}
