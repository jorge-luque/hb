package com.criteo.publisher.advancednative;

import com.criteo.publisher.p057p.C2502c;
import java.lang.ref.Reference;
import java.net.URI;

/* renamed from: com.criteo.publisher.advancednative.a */
class C2352a implements C2371l {

    /* renamed from: a */
    private final URI f7723a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Reference<CriteoNativeAdListener> f7724b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C2360f f7725c;

    /* renamed from: com.criteo.publisher.advancednative.a$a */
    class C2353a implements C2502c {
        C2353a() {
        }

        /* renamed from: a */
        public void mo10106a() {
            C2352a.this.f7725c.mo10216b((CriteoNativeAdListener) C2352a.this.f7724b.get());
        }

        /* renamed from: b */
        public void mo10107b() {
            C2352a.this.f7725c.mo10217c((CriteoNativeAdListener) C2352a.this.f7724b.get());
        }
    }

    C2352a(URI uri, Reference<CriteoNativeAdListener> reference, C2360f fVar) {
        this.f7723a = uri;
        this.f7724b = reference;
        this.f7725c = fVar;
    }

    /* renamed from: a */
    public void mo10205a() {
        this.f7725c.mo10215a(this.f7723a, new C2353a());
    }
}
