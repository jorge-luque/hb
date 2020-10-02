package androidx.fragment.app;

import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0970h;
import androidx.lifecycle.C0971i;

/* renamed from: androidx.fragment.app.o */
/* compiled from: FragmentViewLifecycleOwner */
class C0954o implements C0970h {

    /* renamed from: a */
    private C0971i f2482a = null;

    C0954o() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4963a() {
        if (this.f2482a == null) {
            this.f2482a = new C0971i(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4965b() {
        return this.f2482a != null;
    }

    public C0965e getLifecycle() {
        mo4963a();
        return this.f2482a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4964a(C0965e.C0966a aVar) {
        this.f2482a.mo4999a(aVar);
    }
}
