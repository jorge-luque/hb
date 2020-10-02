package com.google.firebase.iid;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.p123d.C3659a;
import com.google.firebase.p123d.C3660b;

/* renamed from: com.google.firebase.iid.a1 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3692a1 implements C3660b {

    /* renamed from: a */
    private final FirebaseInstanceId.C3688a f10286a;

    C3692a1(FirebaseInstanceId.C3688a aVar) {
        this.f10286a = aVar;
    }

    /* renamed from: a */
    public final void mo27204a(C3659a aVar) {
        FirebaseInstanceId.C3688a aVar2 = this.f10286a;
        synchronized (aVar2) {
            if (aVar2.mo27306a()) {
                FirebaseInstanceId.this.m12533m();
            }
        }
    }
}
