package com.google.firebase.components;

import com.google.firebase.p126f.C3680a;

/* renamed from: com.google.firebase.components.q */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class C3655q<T> implements C3680a<T> {

    /* renamed from: c */
    private static final Object f10220c = new Object();

    /* renamed from: a */
    private volatile Object f10221a = f10220c;

    /* renamed from: b */
    private volatile C3680a<T> f10222b;

    public C3655q(C3680a<T> aVar) {
        this.f10222b = aVar;
    }

    public T get() {
        T t = this.f10221a;
        if (t == f10220c) {
            synchronized (this) {
                t = this.f10221a;
                if (t == f10220c) {
                    t = this.f10222b.get();
                    this.f10221a = t;
                    this.f10222b = null;
                }
            }
        }
        return t;
    }
}
