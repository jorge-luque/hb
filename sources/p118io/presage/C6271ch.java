package p118io.presage;

import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.regex.Pattern;

/* renamed from: io.presage.ch */
public final class C6271ch implements C6275cl {

    /* renamed from: a */
    private C6270cg f16899a;

    /* renamed from: b */
    private final Pattern f16900b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f16901c;

    /* renamed from: d */
    private final C6396db f16902d;

    /* renamed from: e */
    private final PontlEveque f16903e;

    /* renamed from: io.presage.ch$CamembertauCalvados */
    public static final class CamembertauCalvados extends C6266cc {

        /* renamed from: a */
        final /* synthetic */ C6271ch f16904a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        CamembertauCalvados(C6271ch chVar, Pattern pattern) {
            super(pattern);
            this.f16904a = chVar;
        }

        /* renamed from: b */
        public final void mo34865b() {
            this.f16904a.m21076d();
        }

        /* renamed from: c */
        public final void mo34866c() {
            this.f16904a.m21076d();
        }

        /* renamed from: b */
        public final void mo34799b(WebView webView, String str) {
            this.f16904a.f16901c = true;
            this.f16904a.m21076d();
        }
    }

    public C6271ch(C6396db dbVar, PontlEveque pontlEveque) {
        this.f16902d = dbVar;
        this.f16903e = pontlEveque;
        this.f16900b = Pattern.compile(pontlEveque.mo34645u());
        m21075c();
    }

    /* renamed from: c */
    private final void m21075c() {
        C6396db dbVar = this.f16902d;
        Pattern pattern = this.f16900b;
        C6514hl.m21414a((Object) pattern, "whitelistPattern");
        dbVar.setClientAdapter(new CamembertauCalvados(this, pattern));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m21076d() {
        C6270cg cgVar = this.f16899a;
        if (cgVar != null) {
            cgVar.mo34867a();
        }
        m21077e();
        C6223an.m20796e(this.f16902d);
    }

    /* renamed from: e */
    private final void m21077e() {
        C6396db dbVar = this.f16902d;
        Pattern pattern = this.f16900b;
        C6514hl.m21414a((Object) pattern, "whitelistPattern");
        dbVar.setClientAdapter(new C6266cc(pattern));
    }

    /* renamed from: a */
    public final void mo34862a(C6270cg cgVar) {
        this.f16899a = cgVar;
        if (this.f16903e.mo34644t()) {
            WebSettings settings = this.f16902d.getSettings();
            C6514hl.m21414a((Object) settings, "webView.settings");
            settings.setJavaScriptEnabled(false);
        }
        this.f16902d.loadUrl(this.f16903e.mo34643s());
    }

    /* renamed from: b */
    public final void mo34864b() {
        this.f16899a = null;
        m21077e();
        C6223an.m20796e(this.f16902d);
    }

    /* renamed from: a */
    public final boolean mo34863a() {
        return this.f16901c;
    }
}
