package com.google.firebase.installations.p130q;

import com.google.firebase.installations.p130q.C3784b;

/* renamed from: com.google.firebase.installations.q.e */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
public abstract class C3791e {

    /* renamed from: com.google.firebase.installations.q.e$a */
    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public static abstract class C3792a {
        /* renamed from: a */
        public abstract C3792a mo27467a(long j);

        /* renamed from: a */
        public abstract C3792a mo27468a(C3793b bVar);

        /* renamed from: a */
        public abstract C3792a mo27469a(String str);

        /* renamed from: a */
        public abstract C3791e mo27470a();
    }

    /* renamed from: com.google.firebase.installations.q.e$b */
    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public enum C3793b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR;

        /* renamed from: a */
        public static C3793b[] m12825a() {
            return (C3793b[]) f10496d.clone();
        }
    }

    /* renamed from: d */
    public static C3792a m12817d() {
        C3784b.C3786b bVar = new C3784b.C3786b();
        bVar.mo27467a(0);
        return bVar;
    }

    /* renamed from: a */
    public abstract C3793b mo27461a();

    /* renamed from: b */
    public abstract String mo27462b();

    /* renamed from: c */
    public abstract long mo27463c();
}
