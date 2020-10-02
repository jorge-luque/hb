package androidx.lifecycle;

import androidx.lifecycle.C0959a;
import androidx.lifecycle.C0965e;

class ReflectiveGenericLifecycleObserver implements C0968f {

    /* renamed from: a */
    private final Object f2505a;

    /* renamed from: b */
    private final C0959a.C0960a f2506b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2505a = obj;
        this.f2506b = C0959a.f2508c.mo4982a(obj.getClass());
    }

    /* renamed from: a */
    public void mo1895a(C0970h hVar, C0965e.C0966a aVar) {
        this.f2506b.mo4984a(hVar, aVar, this.f2505a);
    }
}
