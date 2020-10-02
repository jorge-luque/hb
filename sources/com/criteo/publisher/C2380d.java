package com.criteo.publisher;

import android.webkit.WebViewClient;
import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2459r;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p056o.C2497b;
import com.criteo.publisher.p057p.C2499a;
import com.criteo.publisher.p057p.C2502c;
import com.criteo.publisher.p060s.C2508a;
import com.criteo.publisher.p068z.C2590a;
import com.criteo.publisher.p068z.C2592b;
import java.lang.ref.WeakReference;

/* renamed from: com.criteo.publisher.d */
public class C2380d {

    /* renamed from: a */
    private final WeakReference<CriteoBannerView> f7776a;

    /* renamed from: b */
    private final CriteoBannerAdListener f7777b;

    /* renamed from: c */
    private final Criteo f7778c;

    /* renamed from: d */
    private final C2497b f7779d;

    /* renamed from: e */
    private final C2508a f7780e;

    /* renamed from: com.criteo.publisher.d$a */
    class C2381a implements C2502c {
        C2381a() {
        }

        /* renamed from: a */
        public void mo10106a() {
            C2380d.this.m9060a(C2385g.CLOSE);
        }

        /* renamed from: b */
        public void mo10107b() {
            C2380d.this.m9060a(C2385g.CLICK);
        }
    }

    public C2380d(CriteoBannerView criteoBannerView, Criteo criteo, C2497b bVar, C2508a aVar) {
        this.f7776a = new WeakReference<>(criteoBannerView);
        this.f7777b = criteoBannerView.getCriteoBannerAdListener();
        this.f7778c = criteo;
        this.f7779d = bVar;
        this.f7780e = aVar;
    }

    /* renamed from: a */
    public void mo10240a(AdUnit adUnit) {
        C2465w a = this.f7778c.mo10078a(adUnit);
        if (a == null) {
            m9060a(C2385g.INVALID);
            return;
        }
        m9060a(C2385g.VALID);
        mo10241a(a.mo10406c());
    }

    /* renamed from: a */
    public void mo10239a(BidToken bidToken) {
        C2459r a = this.f7778c.mo10077a(bidToken, C2321a.CRITEO_BANNER);
        if (a == null) {
            m9060a(C2385g.INVALID);
            return;
        }
        m9060a(C2385g.VALID);
        mo10241a(a.mo10391b());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9060a(C2385g gVar) {
        this.f7780e.mo10520a(new C2590a(this.f7777b, this.f7776a, gVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10241a(String str) {
        this.f7780e.mo10520a(new C2592b(this.f7776a, mo10238a(), this.f7778c.mo10076a(), str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WebViewClient mo10238a() {
        return new C2499a(new C2381a(), this.f7779d.mo10503a());
    }
}
