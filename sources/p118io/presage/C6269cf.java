package p118io.presage;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;

/* renamed from: io.presage.cf */
public final class C6269cf implements C6275cl {

    /* renamed from: a */
    private C6270cg f16892a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f16893b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C6396db f16894c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final PontlEveque f16895d;

    /* renamed from: e */
    private final C6261by f16896e;

    /* renamed from: f */
    private final C6265cb f16897f;

    public C6269cf(C6396db dbVar, PontlEveque pontlEveque, C6261by byVar, C6265cb cbVar) {
        this.f16894c = dbVar;
        this.f16895d = pontlEveque;
        this.f16896e = byVar;
        this.f16897f = cbVar;
        m21054c();
    }

    /* renamed from: io.presage.cf$CamembertauCalvados */
    public static final class CamembertauCalvados extends C6397dc {

        /* renamed from: a */
        final /* synthetic */ C6269cf f16898a;

        CamembertauCalvados(C6269cf cfVar) {
            this.f16898a = cfVar;
        }

        /* renamed from: b */
        public final void mo34865b() {
            C6269cf.m21053b(this.f16898a.f16894c, this.f16898a.f16895d);
            this.f16898a.m21056d();
        }

        /* renamed from: c */
        public final void mo34866c() {
            if (!this.f16898a.f16893b) {
                this.f16898a.m21058e();
            }
        }

        /* renamed from: b */
        public final void mo34799b(WebView webView, String str) {
            this.f16898a.f16893b = true;
            this.f16898a.m21062g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m21053b(WebView webView, PontlEveque pontlEveque) {
        C6223an.m20796e(webView);
        MoelleuxduRevard moelleuxduRevard = MoelleuxduRevard.f16573a;
        MoelleuxduRevard.m20487a((Mimolette24mois) new Munster("loaded_error", pontlEveque));
    }

    /* renamed from: c */
    private final void m21054c() {
        this.f16894c.setClientAdapter(new CamembertauCalvados(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m21056d() {
        C6270cg cgVar = this.f16892a;
        if (cgVar != null) {
            cgVar.mo34868a(this.f16895d);
        }
        m21060f();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m21058e() {
        MoelleuxduRevard moelleuxduRevard = MoelleuxduRevard.f16573a;
        MoelleuxduRevard.m20487a((Mimolette24mois) new Munster("loaded_error", this.f16895d));
        C6270cg cgVar = this.f16892a;
        if (cgVar != null) {
            cgVar.mo34869b();
        }
        m21060f();
    }

    /* renamed from: f */
    private final void m21060f() {
        this.f16894c.setWebViewClient((WebViewClient) null);
        this.f16894c.setClientAdapter((C6397dc) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void m21062g() {
        MoelleuxduRevard moelleuxduRevard = MoelleuxduRevard.f16573a;
        MoelleuxduRevard.m20487a((Mimolette24mois) new Munster("loaded", this.f16895d));
        C6261by.m21020a(new C6260bx(new WeakReference(this.f16897f), this.f16894c, this.f16895d));
        C6270cg cgVar = this.f16892a;
        if (cgVar != null) {
            cgVar.mo34867a();
        }
    }

    /* renamed from: a */
    public final void mo34862a(C6270cg cgVar) {
        this.f16892a = cgVar;
        C6399de.m21252a(this.f16894c, this.f16895d);
    }

    /* renamed from: b */
    public final void mo34864b() {
        this.f16892a = null;
        m21060f();
        C6223an.m20796e(this.f16894c);
    }

    /* renamed from: a */
    public final boolean mo34863a() {
        return this.f16893b;
    }
}
