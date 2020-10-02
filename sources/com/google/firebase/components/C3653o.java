package com.google.firebase.components;

import com.google.firebase.p123d.C3659a;
import com.google.firebase.p123d.C3660b;
import java.util.Map;

/* renamed from: com.google.firebase.components.o */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
final /* synthetic */ class C3653o implements Runnable {

    /* renamed from: a */
    private final Map.Entry f10215a;

    /* renamed from: b */
    private final C3659a f10216b;

    private C3653o(Map.Entry entry, C3659a aVar) {
        this.f10215a = entry;
        this.f10216b = aVar;
    }

    /* renamed from: a */
    public static Runnable m12436a(Map.Entry entry, C3659a aVar) {
        return new C3653o(entry, aVar);
    }

    public void run() {
        ((C3660b) this.f10215a.getKey()).mo27204a(this.f10216b);
    }
}
