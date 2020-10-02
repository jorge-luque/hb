package com.criteo.publisher.advancednative;

import com.criteo.publisher.p057p.C2502c;
import java.lang.ref.Reference;
import java.net.URI;

/* renamed from: com.criteo.publisher.advancednative.c */
class C2355c implements C2371l {

    /* renamed from: a */
    private final URI f7730a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Reference<CriteoNativeAdListener> f7731b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C2360f f7732c;

    /* renamed from: com.criteo.publisher.advancednative.c$a */
    class C2356a implements C2502c {
        C2356a() {
        }

        /* renamed from: a */
        public void mo10106a() {
            C2355c.this.f7732c.mo10216b((CriteoNativeAdListener) C2355c.this.f7731b.get());
        }

        /* renamed from: b */
        public void mo10107b() {
            C2355c.this.f7732c.mo10217c((CriteoNativeAdListener) C2355c.this.f7731b.get());
        }
    }

    C2355c(URI uri, Reference<CriteoNativeAdListener> reference, C2360f fVar) {
        this.f7730a = uri;
        this.f7731b = reference;
        this.f7732c = fVar;
    }

    /* renamed from: a */
    public void mo10205a() {
        this.f7732c.mo10214a(this.f7731b.get());
        this.f7732c.mo10215a(this.f7730a, new C2356a());
    }
}
