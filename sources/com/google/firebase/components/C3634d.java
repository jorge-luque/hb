package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.firebase.components.d */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final class C3634d<T> {

    /* renamed from: a */
    private final Set<Class<? super T>> f10183a;

    /* renamed from: b */
    private final Set<C3652n> f10184b;

    /* renamed from: c */
    private final int f10185c;

    /* renamed from: d */
    private final int f10186d;

    /* renamed from: e */
    private final C3642g<T> f10187e;

    /* renamed from: f */
    private final Set<Class<?>> f10188f;

    /* renamed from: com.google.firebase.components.d$b */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    public static class C3636b<T> {

        /* renamed from: a */
        private final Set<Class<? super T>> f10189a;

        /* renamed from: b */
        private final Set<C3652n> f10190b;

        /* renamed from: c */
        private int f10191c;

        /* renamed from: d */
        private int f10192d;

        /* renamed from: e */
        private C3642g<T> f10193e;

        /* renamed from: f */
        private Set<Class<?>> f10194f;

        /* access modifiers changed from: private */
        /* renamed from: d */
        public C3636b<T> m12389d() {
            this.f10192d = 1;
            return this;
        }

        /* renamed from: b */
        public C3634d<T> mo27233b() {
            C3656r.m12446b(this.f10193e != null, "Missing required property: factory.");
            return new C3634d(new HashSet(this.f10189a), new HashSet(this.f10190b), this.f10191c, this.f10192d, this.f10193e, this.f10194f);
        }

        /* renamed from: c */
        public C3636b<T> mo27234c() {
            m12386a(2);
            return this;
        }

        @SafeVarargs
        private C3636b(Class<T> cls, Class<? super T>... clsArr) {
            this.f10189a = new HashSet();
            this.f10190b = new HashSet();
            this.f10191c = 0;
            this.f10192d = 0;
            this.f10194f = new HashSet();
            C3656r.m12444a(cls, "Null interface");
            this.f10189a.add(cls);
            for (Class<? super T> a : clsArr) {
                C3656r.m12444a(a, "Null interface");
            }
            Collections.addAll(this.f10189a, clsArr);
        }

        /* renamed from: a */
        public C3636b<T> mo27232a(C3652n nVar) {
            C3656r.m12444a(nVar, "Null dependency");
            m12388a(nVar.mo27250a());
            this.f10190b.add(nVar);
            return this;
        }

        /* renamed from: a */
        public C3636b<T> mo27230a() {
            m12386a(1);
            return this;
        }

        /* renamed from: a */
        private C3636b<T> m12386a(int i) {
            C3656r.m12446b(this.f10191c == 0, "Instantiation type has already been set.");
            this.f10191c = i;
            return this;
        }

        /* renamed from: a */
        private void m12388a(Class<?> cls) {
            C3656r.m12445a(!this.f10189a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        /* renamed from: a */
        public C3636b<T> mo27231a(C3642g<T> gVar) {
            C3656r.m12444a(gVar, "Null factory");
            this.f10193e = gVar;
            return this;
        }
    }

    /* renamed from: a */
    static /* synthetic */ Object m12376a(Object obj, C3637e eVar) {
        return obj;
    }

    /* renamed from: b */
    static /* synthetic */ Object m12378b(Object obj, C3637e eVar) {
        return obj;
    }

    /* renamed from: a */
    public Set<C3652n> mo27222a() {
        return this.f10184b;
    }

    /* renamed from: b */
    public C3642g<T> mo27223b() {
        return this.f10187e;
    }

    /* renamed from: c */
    public Set<Class<? super T>> mo27224c() {
        return this.f10183a;
    }

    /* renamed from: d */
    public Set<Class<?>> mo27225d() {
        return this.f10188f;
    }

    /* renamed from: e */
    public boolean mo27226e() {
        return this.f10185c == 1;
    }

    /* renamed from: f */
    public boolean mo27227f() {
        return this.f10185c == 2;
    }

    /* renamed from: g */
    public boolean mo27228g() {
        return this.f10186d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f10183a.toArray()) + ">{" + this.f10185c + ", type=" + this.f10186d + ", deps=" + Arrays.toString(this.f10184b.toArray()) + "}";
    }

    private C3634d(Set<Class<? super T>> set, Set<C3652n> set2, int i, int i2, C3642g<T> gVar, Set<Class<?>> set3) {
        this.f10183a = Collections.unmodifiableSet(set);
        this.f10184b = Collections.unmodifiableSet(set2);
        this.f10185c = i;
        this.f10186d = i2;
        this.f10187e = gVar;
        this.f10188f = Collections.unmodifiableSet(set3);
    }

    /* renamed from: a */
    public static <T> C3636b<T> m12372a(Class<T> cls) {
        return new C3636b<>(cls, new Class[0]);
    }

    /* renamed from: b */
    public static <T> C3636b<T> m12377b(Class<T> cls) {
        C3636b<T> a = m12372a(cls);
        C3636b unused = a.m12389d();
        return a;
    }

    @SafeVarargs
    /* renamed from: a */
    public static <T> C3636b<T> m12373a(Class<T> cls, Class<? super T>... clsArr) {
        return new C3636b<>(cls, clsArr);
    }

    @SafeVarargs
    /* renamed from: a */
    public static <T> C3634d<T> m12375a(T t, Class<T> cls, Class<? super T>... clsArr) {
        C3636b<T> a = m12373a(cls, clsArr);
        a.mo27231a((C3642g<T>) C3632b.m12368a((Object) t));
        return a.mo27233b();
    }

    /* renamed from: a */
    public static <T> C3634d<T> m12374a(T t, Class<T> cls) {
        C3636b<T> b = m12377b(cls);
        b.mo27231a((C3642g<T>) C3633c.m12370a((Object) t));
        return b.mo27233b();
    }
}
