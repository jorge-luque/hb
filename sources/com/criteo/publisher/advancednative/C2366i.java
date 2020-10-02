package com.criteo.publisher.advancednative;

import com.criteo.publisher.C2433m;
import com.criteo.publisher.p060s.C2508a;
import com.criteo.publisher.p065x.C2579d;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Executor;

/* renamed from: com.criteo.publisher.advancednative.i */
public class C2366i {

    /* renamed from: a */
    private final C2579d f7744a;

    /* renamed from: b */
    private final Executor f7745b;

    /* renamed from: c */
    private final C2508a f7746c;

    /* renamed from: com.criteo.publisher.advancednative.i$a */
    class C2367a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CriteoNativeAdListener f7747a;

        C2367a(C2366i iVar, CriteoNativeAdListener criteoNativeAdListener) {
            this.f7747a = criteoNativeAdListener;
        }

        public void run() {
            this.f7747a.onAdImpression();
        }
    }

    /* renamed from: com.criteo.publisher.advancednative.i$b */
    private static class C2368b extends C2433m {

        /* renamed from: c */
        private final URL f7748c;

        /* renamed from: d */
        private final C2579d f7749d;

        /* synthetic */ C2368b(URL url, C2579d dVar, C2367a aVar) {
            this(url, dVar);
        }

        /* renamed from: a */
        public void mo10204a() throws IOException {
            InputStream a = this.f7749d.mo10624a(this.f7748c);
            if (a != null) {
                a.close();
            }
        }

        private C2368b(URL url, C2579d dVar) {
            this.f7748c = url;
            this.f7749d = dVar;
        }
    }

    public C2366i(C2579d dVar, Executor executor, C2508a aVar) {
        this.f7744a = dVar;
        this.f7745b = executor;
        this.f7746c = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10224a(Iterable<URL> iterable) {
        for (URL bVar : iterable) {
            this.f7745b.execute(new C2368b(bVar, this.f7744a, (C2367a) null));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10223a(CriteoNativeAdListener criteoNativeAdListener) {
        this.f7746c.mo10520a(new C2367a(this, criteoNativeAdListener));
    }
}
