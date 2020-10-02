package com.criteo.publisher.advancednative;

import java.lang.ref.Reference;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.criteo.publisher.advancednative.j */
class C2369j implements C2373n {

    /* renamed from: a */
    private final Iterable<URL> f7750a;

    /* renamed from: b */
    private final Reference<CriteoNativeAdListener> f7751b;

    /* renamed from: c */
    private final C2366i f7752c;

    /* renamed from: d */
    private final AtomicBoolean f7753d = new AtomicBoolean(false);

    C2369j(Iterable<URL> iterable, Reference<CriteoNativeAdListener> reference, C2366i iVar) {
        this.f7750a = iterable;
        this.f7751b = reference;
        this.f7752c = iVar;
    }

    /* renamed from: a */
    public void mo10226a() {
        if (this.f7753d.compareAndSet(false, true)) {
            this.f7752c.mo10224a(this.f7750a);
            CriteoNativeAdListener criteoNativeAdListener = this.f7751b.get();
            if (criteoNativeAdListener != null) {
                this.f7752c.mo10223a(criteoNativeAdListener);
            }
        }
    }
}
