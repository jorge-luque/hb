package p118io.presage;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* renamed from: io.presage.Abondance */
public final class Abondance {

    /* renamed from: a */
    public static final CamembertauCalvados f16363a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private C6396db f16364b;

    /* renamed from: c */
    private final C6261by f16365c;

    /* renamed from: d */
    private final C6241be f16366d;

    /* renamed from: e */
    private final C6384cq f16367e;

    /* renamed from: io.presage.Abondance$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static Abondance m20195a(C6246bj bjVar, C6384cq cqVar) {
            return new Abondance(C6261by.f16869a, bjVar.mo34785a(), cqVar, (byte) 0);
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: io.presage.Abondance$CamembertdeNormandie */
    public static final class CamembertdeNormandie extends C6397dc {

        /* renamed from: a */
        final /* synthetic */ Abondance f16368a;

        CamembertdeNormandie(Abondance abondance) {
            this.f16368a = abondance;
        }

        /* renamed from: a */
        public final void mo34449a(WebView webView) {
            this.f16368a.m20193b();
        }
    }

    private Abondance(C6261by byVar, C6241be beVar, C6384cq cqVar) {
        this.f16365c = byVar;
        this.f16366d = beVar;
        this.f16367e = cqVar;
    }

    /* renamed from: b */
    private static C6396db m20192b(PontlEveque pontlEveque) {
        return C6261by.m21023b(pontlEveque.mo34601a());
    }

    public /* synthetic */ Abondance(C6261by byVar, C6241be beVar, C6384cq cqVar, byte b) {
        this(byVar, beVar, cqVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m20193b() {
        C6396db dbVar = this.f16364b;
        if (dbVar != null) {
            dbVar.mo35337c();
        }
    }

    /* renamed from: a */
    public final C6396db mo34448a(PontlEveque pontlEveque) {
        C6396db b = m20192b(pontlEveque);
        if (b == null) {
            return null;
        }
        this.f16364b = b;
        m20189a();
        m20191a(this.f16364b);
        m20193b();
        return this.f16364b;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: a */
    private final void m20189a() {
        C6396db dbVar = this.f16364b;
        if (dbVar != null) {
            dbVar.setMraidUrlHandler(new C6383cp(new C6241be[]{this.f16366d, this.f16367e.mo35308a(dbVar)}));
            WebSettings settings = dbVar.getSettings();
            if (settings != null) {
                settings.setJavaScriptEnabled(true);
            }
            C6223an.m20794c(dbVar);
            C6223an.m20793b(dbVar);
        }
    }

    /* renamed from: a */
    private final void m20191a(C6396db dbVar) {
        if (dbVar != null) {
            dbVar.setClientAdapter(new CamembertdeNormandie(this));
        }
    }
}
