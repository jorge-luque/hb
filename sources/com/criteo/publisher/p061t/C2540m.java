package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2512a;
import com.criteo.publisher.p061t.C2518e;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/* renamed from: com.criteo.publisher.t.m */
public abstract class C2540m {

    /* renamed from: com.criteo.publisher.t.m$a */
    static abstract class C2541a {
        C2541a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C2541a mo10535a(Long l);

        /* access modifiers changed from: package-private */
        @Deprecated
        /* renamed from: a */
        public abstract C2541a mo10536a(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C2541a mo10537a(boolean z);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C2540m mo10538a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C2541a mo10539b(Long l);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C2541a mo10540b(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C2541a mo10541b(boolean z);

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract C2541a mo10542c(Long l);

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract C2541a mo10543c(boolean z);
    }

    /* renamed from: a */
    public static C2541a m9536a(String str) {
        return m9538j().mo10536a(str);
    }

    @Deprecated
    /* renamed from: j */
    public static C2541a m9538j() {
        return new C2512a.C2514b().mo10543c(false).mo10541b(false).mo10537a(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Long mo10523a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract Long mo10524b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract Long mo10525c();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract String mo10526d();

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract String mo10527e();

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract boolean mo10529f();

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public abstract boolean mo10530g();

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public abstract boolean mo10531h();

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public abstract C2541a mo10533i();

    /* renamed from: a */
    public static TypeAdapter<C2540m> m9537a(Gson gson) {
        return new C2518e.C2519a(gson);
    }
}
