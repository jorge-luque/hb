package com.criteo.publisher.advancednative;

import com.criteo.publisher.p056o.C2497b;
import com.criteo.publisher.p057p.C2500b;
import com.criteo.publisher.p057p.C2502c;
import com.criteo.publisher.p060s.C2508a;
import java.net.URI;

/* renamed from: com.criteo.publisher.advancednative.f */
public class C2360f {

    /* renamed from: a */
    private final C2500b f7736a;

    /* renamed from: b */
    private final C2497b f7737b;

    /* renamed from: c */
    private final C2508a f7738c;

    /* renamed from: com.criteo.publisher.advancednative.f$a */
    class C2361a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CriteoNativeAdListener f7739a;

        C2361a(C2360f fVar, CriteoNativeAdListener criteoNativeAdListener) {
            this.f7739a = criteoNativeAdListener;
        }

        public void run() {
            this.f7739a.onAdClicked();
        }
    }

    /* renamed from: com.criteo.publisher.advancednative.f$b */
    class C2362b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CriteoNativeAdListener f7740a;

        C2362b(C2360f fVar, CriteoNativeAdListener criteoNativeAdListener) {
            this.f7740a = criteoNativeAdListener;
        }

        public void run() {
            this.f7740a.onAdLeftApplication();
        }
    }

    /* renamed from: com.criteo.publisher.advancednative.f$c */
    class C2363c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CriteoNativeAdListener f7741a;

        C2363c(C2360f fVar, CriteoNativeAdListener criteoNativeAdListener) {
            this.f7741a = criteoNativeAdListener;
        }

        public void run() {
            this.f7741a.onAdClosed();
        }
    }

    public C2360f(C2500b bVar, C2497b bVar2, C2508a aVar) {
        this.f7736a = bVar;
        this.f7737b = bVar2;
        this.f7738c = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10214a(CriteoNativeAdListener criteoNativeAdListener) {
        if (criteoNativeAdListener != null) {
            this.f7738c.mo10520a(new C2361a(this, criteoNativeAdListener));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10216b(CriteoNativeAdListener criteoNativeAdListener) {
        if (criteoNativeAdListener != null) {
            this.f7738c.mo10520a(new C2363c(this, criteoNativeAdListener));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10217c(CriteoNativeAdListener criteoNativeAdListener) {
        if (criteoNativeAdListener != null) {
            this.f7738c.mo10520a(new C2362b(this, criteoNativeAdListener));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10215a(URI uri, C2502c cVar) {
        this.f7736a.mo10507a(uri.toString(), this.f7737b.mo10503a(), cVar);
    }
}
