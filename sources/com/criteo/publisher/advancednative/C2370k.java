package com.criteo.publisher.advancednative;

import com.criteo.publisher.model.p055z.C2488n;
import java.lang.ref.WeakReference;

/* renamed from: com.criteo.publisher.advancednative.k */
public class C2370k {

    /* renamed from: a */
    private final C2374o f7754a;

    /* renamed from: b */
    private final C2366i f7755b;

    /* renamed from: c */
    private final C2358e f7756c;

    /* renamed from: d */
    private final C2360f f7757d;

    /* renamed from: e */
    private final C2354b f7758e;

    /* renamed from: f */
    private final RendererHelper f7759f;

    public C2370k(C2374o oVar, C2366i iVar, C2358e eVar, C2360f fVar, C2354b bVar, RendererHelper rendererHelper) {
        this.f7754a = oVar;
        this.f7755b = iVar;
        this.f7756c = eVar;
        this.f7757d = fVar;
        this.f7758e = bVar;
        this.f7759f = rendererHelper;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CriteoNativeAd mo10227a(C2488n nVar, WeakReference<CriteoNativeAdListener> weakReference, CriteoNativeRenderer criteoNativeRenderer) {
        C2369j jVar = new C2369j(nVar.mo10487f(), weakReference, this.f7755b);
        C2355c cVar = new C2355c(nVar.mo10491m().mo10463b(), weakReference, this.f7757d);
        C2352a aVar = new C2352a(nVar.mo10489k(), weakReference, this.f7757d);
        this.f7759f.preloadMedia(nVar.mo10491m().mo10493e());
        this.f7759f.preloadMedia(nVar.mo10486e());
        this.f7759f.preloadMedia(nVar.mo10490l());
        return new CriteoNativeAd(nVar, this.f7754a, jVar, this.f7756c, cVar, aVar, this.f7758e, criteoNativeRenderer, this.f7759f);
    }
}
