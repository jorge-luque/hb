package com.tapjoy.internal;

import java.lang.ref.WeakReference;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* renamed from: com.tapjoy.internal.by */
public final class C4930by {

    /* renamed from: a */
    public WeakReference f13425a;

    /* renamed from: a */
    public final Object mo31018a() {
        WeakReference weakReference = this.f13425a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public final void mo31019a(Object obj) {
        this.f13425a = new WeakReference(obj);
    }
}
