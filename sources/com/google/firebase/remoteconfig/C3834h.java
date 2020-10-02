package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.C3852k;

/* renamed from: com.google.firebase.remoteconfig.h */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3834h {

    /* renamed from: a */
    private final boolean f10591a;

    /* renamed from: b */
    private final long f10592b;

    /* renamed from: c */
    private final long f10593c;

    /* renamed from: com.google.firebase.remoteconfig.h$b */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static class C3836b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f10594a = false;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public long f10595b = 60;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public long f10596c = C3852k.f10634j;

        /* renamed from: a */
        public C3836b mo27553a(long j) {
            if (j >= 0) {
                this.f10596c = j;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j + " is an invalid argument");
        }

        /* renamed from: a */
        public C3834h mo27554a() {
            return new C3834h(this);
        }
    }

    /* renamed from: a */
    public long mo27550a() {
        return this.f10592b;
    }

    /* renamed from: b */
    public long mo27551b() {
        return this.f10593c;
    }

    @Deprecated
    /* renamed from: c */
    public boolean mo27552c() {
        return this.f10591a;
    }

    private C3834h(C3836b bVar) {
        this.f10591a = bVar.f10594a;
        this.f10592b = bVar.f10595b;
        this.f10593c = bVar.f10596c;
    }
}
