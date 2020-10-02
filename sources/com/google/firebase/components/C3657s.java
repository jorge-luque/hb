package com.google.firebase.components;

import com.google.firebase.p123d.C3661c;
import com.google.firebase.p126f.C3680a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.firebase.components.s */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
final class C3657s extends C3631a {

    /* renamed from: a */
    private final Set<Class<?>> f10223a;

    /* renamed from: b */
    private final Set<Class<?>> f10224b;

    /* renamed from: c */
    private final Set<Class<?>> f10225c;

    /* renamed from: d */
    private final Set<Class<?>> f10226d;

    /* renamed from: e */
    private final Set<Class<?>> f10227e;

    /* renamed from: f */
    private final C3637e f10228f;

    /* renamed from: com.google.firebase.components.s$a */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    private static class C3658a implements C3661c {
        public C3658a(Set<Class<?>> set, C3661c cVar) {
        }
    }

    C3657s(C3634d<?> dVar, C3637e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (C3652n next : dVar.mo27222a()) {
            if (next.mo27251b()) {
                if (next.mo27253d()) {
                    hashSet3.add(next.mo27250a());
                } else {
                    hashSet.add(next.mo27250a());
                }
            } else if (next.mo27253d()) {
                hashSet4.add(next.mo27250a());
            } else {
                hashSet2.add(next.mo27250a());
            }
        }
        if (!dVar.mo27225d().isEmpty()) {
            hashSet.add(C3661c.class);
        }
        this.f10223a = Collections.unmodifiableSet(hashSet);
        this.f10224b = Collections.unmodifiableSet(hashSet2);
        this.f10225c = Collections.unmodifiableSet(hashSet3);
        this.f10226d = Collections.unmodifiableSet(hashSet4);
        this.f10227e = dVar.mo27225d();
        this.f10228f = eVar;
    }

    /* renamed from: a */
    public <T> T mo27220a(Class<T> cls) {
        if (this.f10223a.contains(cls)) {
            T a = this.f10228f.mo27220a(cls);
            if (!cls.equals(C3661c.class)) {
                return a;
            }
            return new C3658a(this.f10227e, (C3661c) a);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    /* renamed from: b */
    public <T> C3680a<T> mo27235b(Class<T> cls) {
        if (this.f10224b.contains(cls)) {
            return this.f10228f.mo27235b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    /* renamed from: c */
    public <T> C3680a<Set<T>> mo27236c(Class<T> cls) {
        if (this.f10226d.contains(cls)) {
            return this.f10228f.mo27236c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }

    /* renamed from: d */
    public <T> Set<T> mo27221d(Class<T> cls) {
        if (this.f10225c.contains(cls)) {
            return this.f10228f.mo27221d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }
}
