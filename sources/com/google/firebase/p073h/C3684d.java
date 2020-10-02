package com.google.firebase.p073h;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.firebase.h.d */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class C3684d {

    /* renamed from: b */
    private static volatile C3684d f10261b;

    /* renamed from: a */
    private final Set<C3099f> f10262a = new HashSet();

    C3684d() {
    }

    /* renamed from: b */
    public static C3684d m12517b() {
        C3684d dVar = f10261b;
        if (dVar == null) {
            synchronized (C3684d.class) {
                dVar = f10261b;
                if (dVar == null) {
                    dVar = new C3684d();
                    f10261b = dVar;
                }
            }
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Set<C3099f> mo27288a() {
        Set<C3099f> unmodifiableSet;
        synchronized (this.f10262a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f10262a);
        }
        return unmodifiableSet;
    }
}
