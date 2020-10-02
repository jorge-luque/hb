package com.criteo.publisher.p059r;

import com.criteo.publisher.model.AdSize;
import com.criteo.publisher.model.C2450k;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p054a0.C2338m;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.criteo.publisher.r.a */
public class C2507a {

    /* renamed from: a */
    private final Map<C2450k, C2465w> f7999a = new HashMap();

    /* renamed from: b */
    private final C2338m f8000b;

    public C2507a(C2338m mVar) {
        this.f8000b = mVar;
    }

    /* renamed from: b */
    private C2321a m9456b(C2465w wVar) {
        if (wVar.mo10414j()) {
            return C2321a.CRITEO_CUSTOM_NATIVE;
        }
        if ((this.f8000b.mo10158d().getHeight() == wVar.mo10407d() && this.f8000b.mo10158d().getWidth() == wVar.mo10413i()) || (this.f8000b.mo10157c().getHeight() == wVar.mo10407d() && this.f8000b.mo10157c().getWidth() == wVar.mo10413i())) {
            return C2321a.CRITEO_INTERSTITIAL;
        }
        return C2321a.CRITEO_BANNER;
    }

    /* renamed from: a */
    public void mo10518a(C2465w wVar) {
        this.f7999a.put(new C2450k(new AdSize(wVar.mo10413i(), wVar.mo10407d()), wVar.mo10411g(), m9456b(wVar)), wVar);
    }

    /* renamed from: a */
    public C2465w mo10517a(C2450k kVar) {
        return this.f7999a.get(kVar);
    }

    /* renamed from: b */
    public void mo10519b(C2450k kVar) {
        this.f7999a.remove(kVar);
    }
}
