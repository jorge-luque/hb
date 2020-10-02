package com.google.firebase.installations.p129p;

import com.google.firebase.installations.p129p.C3773a;
import com.google.firebase.installations.p129p.C3777c;

/* renamed from: com.google.firebase.installations.p.d */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
public abstract class C3779d {

    /* renamed from: com.google.firebase.installations.p.d$a */
    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public static abstract class C3780a {
        /* renamed from: a */
        public abstract C3780a mo27424a(long j);

        /* renamed from: a */
        public abstract C3780a mo27425a(C3777c.C3778a aVar);

        /* renamed from: a */
        public abstract C3780a mo27426a(String str);

        /* renamed from: a */
        public abstract C3779d mo27427a();

        /* renamed from: b */
        public abstract C3780a mo27428b(long j);

        /* renamed from: b */
        public abstract C3780a mo27429b(String str);

        /* renamed from: c */
        public abstract C3780a mo27430c(String str);

        /* renamed from: d */
        public abstract C3780a mo27431d(String str);
    }

    static {
        m12742p().mo27427a();
    }

    /* renamed from: p */
    public static C3780a m12742p() {
        C3773a.C3775b bVar = new C3773a.C3775b();
        bVar.mo27428b(0);
        bVar.mo27425a(C3777c.C3778a.ATTEMPT_MIGRATION);
        bVar.mo27424a(0);
        return bVar;
    }

    /* renamed from: a */
    public C3779d mo27438a(String str, String str2, long j, String str3, long j2) {
        C3780a m = mo27422m();
        m.mo27429b(str);
        m.mo27425a(C3777c.C3778a.REGISTERED);
        m.mo27426a(str3);
        m.mo27431d(str2);
        m.mo27424a(j2);
        m.mo27428b(j);
        return m.mo27427a();
    }

    /* renamed from: a */
    public abstract String mo27413a();

    /* renamed from: b */
    public abstract long mo27414b();

    /* renamed from: b */
    public C3779d mo27439b(String str) {
        C3780a m = mo27422m();
        m.mo27429b(str);
        m.mo27425a(C3777c.C3778a.UNREGISTERED);
        return m.mo27427a();
    }

    /* renamed from: c */
    public abstract String mo27415c();

    /* renamed from: d */
    public abstract String mo27416d();

    /* renamed from: e */
    public abstract String mo27417e();

    /* renamed from: f */
    public abstract C3777c.C3778a mo27419f();

    /* renamed from: g */
    public abstract long mo27420g();

    /* renamed from: h */
    public boolean mo27440h() {
        return mo27419f() == C3777c.C3778a.REGISTER_ERROR;
    }

    /* renamed from: i */
    public boolean mo27441i() {
        return mo27419f() == C3777c.C3778a.NOT_GENERATED || mo27419f() == C3777c.C3778a.ATTEMPT_MIGRATION;
    }

    /* renamed from: j */
    public boolean mo27442j() {
        return mo27419f() == C3777c.C3778a.REGISTERED;
    }

    /* renamed from: k */
    public boolean mo27443k() {
        return mo27419f() == C3777c.C3778a.UNREGISTERED;
    }

    /* renamed from: l */
    public boolean mo27444l() {
        return mo27419f() == C3777c.C3778a.ATTEMPT_MIGRATION;
    }

    /* renamed from: m */
    public abstract C3780a mo27422m();

    /* renamed from: n */
    public C3779d mo27445n() {
        C3780a m = mo27422m();
        m.mo27426a((String) null);
        return m.mo27427a();
    }

    /* renamed from: o */
    public C3779d mo27446o() {
        C3780a m = mo27422m();
        m.mo27425a(C3777c.C3778a.NOT_GENERATED);
        return m.mo27427a();
    }

    /* renamed from: a */
    public C3779d mo27436a(String str) {
        C3780a m = mo27422m();
        m.mo27430c(str);
        m.mo27425a(C3777c.C3778a.REGISTER_ERROR);
        return m.mo27427a();
    }

    /* renamed from: a */
    public C3779d mo27437a(String str, long j, long j2) {
        C3780a m = mo27422m();
        m.mo27426a(str);
        m.mo27424a(j);
        m.mo27428b(j2);
        return m.mo27427a();
    }
}
