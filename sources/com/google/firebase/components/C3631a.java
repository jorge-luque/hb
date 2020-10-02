package com.google.firebase.components;

import com.google.firebase.p126f.C3680a;
import java.util.Set;

/* renamed from: com.google.firebase.components.a */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
abstract class C3631a implements C3637e {
    C3631a() {
    }

    /* renamed from: a */
    public <T> T mo27220a(Class<T> cls) {
        C3680a<T> b = mo27235b(cls);
        if (b == null) {
            return null;
        }
        return b.get();
    }

    /* renamed from: d */
    public <T> Set<T> mo27221d(Class<T> cls) {
        return mo27236c(cls).get();
    }
}
