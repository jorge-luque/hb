package com.criteo.publisher.p062u;

import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.BannerAdUnit;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.model.InterstitialAdUnit;
import com.criteo.publisher.model.p055z.C2488n;
import com.criteo.publisher.model.p055z.C2493r;
import com.criteo.publisher.p054a0.C2323c;
import com.criteo.publisher.p054a0.C2327g;
import com.criteo.publisher.p054a0.C2338m;
import com.criteo.publisher.p054a0.C2345t;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.loopj.android.http.C4250c;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: com.criteo.publisher.u.a */
public class C2563a implements C2567c {

    /* renamed from: a */
    private final C2323c f8112a;

    /* renamed from: b */
    private final C2338m f8113b;

    /* renamed from: com.criteo.publisher.u.a$b */
    private static class C2565b {

        /* renamed from: a */
        private final PublisherAdRequest.Builder f8114a;

        /* renamed from: a */
        static boolean m9630a(Object obj) {
            try {
                return obj instanceof PublisherAdRequest.Builder;
            } catch (LinkageError unused) {
                return false;
            }
        }

        private C2565b(PublisherAdRequest.Builder builder) {
            this.f8114a = builder;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10606a(String str, String str2) {
            try {
                this.f8114a.addCustomTargeting(str, str2);
            } catch (LinkageError unused) {
            }
        }
    }

    public C2563a(C2323c cVar, C2338m mVar) {
        this.f8112a = cVar;
        this.f8113b = mVar;
    }

    /* renamed from: a */
    public boolean mo10605a(Object obj) {
        return C2565b.m9630a(obj);
    }

    /* renamed from: a */
    public void mo10604a(Object obj, AdUnit adUnit, C2465w wVar) {
        if (mo10605a(obj)) {
            C2565b bVar = new C2565b((PublisherAdRequest.Builder) obj);
            bVar.mo10606a("crt_cpm", wVar.mo10401a());
            if (wVar.mo10414j()) {
                m9624a(bVar, wVar);
            } else if (adUnit instanceof BannerAdUnit) {
                m9625a(bVar, wVar.mo10406c(), "crt_displayurl");
                bVar.mo10606a("crt_size", wVar.mo10413i() + "x" + wVar.mo10407d());
            } else if (adUnit instanceof InterstitialAdUnit) {
                m9625a(bVar, wVar.mo10406c(), "crt_displayurl");
                bVar.mo10606a("crt_size", m9623a(wVar));
            }
        }
    }

    /* renamed from: a */
    private String m9623a(C2465w wVar) {
        boolean z = true;
        if (this.f8112a.mo10117a() != 1) {
            z = false;
        }
        if (this.f8113b.mo10160f()) {
            if (z && wVar.mo10413i() >= 768 && wVar.mo10407d() >= 1024) {
                return "768x1024";
            }
            if (!z && wVar.mo10413i() >= 1024 && wVar.mo10407d() >= 768) {
                return "1024x768";
            }
        }
        return z ? "320x480" : "480x320";
    }

    /* renamed from: a */
    private void m9624a(C2565b bVar, C2465w wVar) {
        C2488n f = wVar.mo10410f();
        if (f != null) {
            C2493r m = f.mo10491m();
            m9625a(bVar, m.mo10468g(), "crtn_title");
            m9625a(bVar, m.mo10464c(), "crtn_desc");
            m9625a(bVar, m.mo10467f(), "crtn_price");
            m9625a(bVar, m.mo10463b().toString(), "crtn_clickurl");
            m9625a(bVar, m.mo10462a(), "crtn_cta");
            m9625a(bVar, m.mo10493e().toString(), "crtn_imageurl");
            m9625a(bVar, f.mo10483b(), "crtn_advname");
            m9625a(bVar, f.mo10484c(), "crtn_advdomain");
            m9625a(bVar, f.mo10486e().toString(), "crtn_advlogourl");
            m9625a(bVar, f.mo10485d().toString(), "crtn_advurl");
            m9625a(bVar, f.mo10489k().toString(), "crtn_prurl");
            m9625a(bVar, f.mo10490l().toString(), "crtn_primageurl");
            m9625a(bVar, f.mo10488j(), "crtn_prtext");
            List<URL> f2 = f.mo10487f();
            for (int i = 0; i < f2.size(); i++) {
                String url = f2.get(i).toString();
                m9625a(bVar, url, "crtn_pixurl_" + i);
            }
            bVar.mo10606a("crtn_pixcount", f2.size() + "");
        }
    }

    /* renamed from: a */
    private void m9625a(C2565b bVar, String str, String str2) {
        if (!C2345t.m9006a((CharSequence) str)) {
            bVar.mo10606a(str2, mo10602a(str));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10602a(String str) {
        if (C2345t.m9006a((CharSequence) str)) {
            return null;
        }
        try {
            String a = mo10603a(str.getBytes(Charset.forName(C4250c.DEFAULT_CHARSET)));
            String name = Charset.forName(C4250c.DEFAULT_CHARSET).name();
            return URLEncoder.encode(URLEncoder.encode(a, name), name);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10603a(byte[] bArr) {
        return C2327g.m8957b(bArr, 2);
    }
}
