package p118io.presage;

import android.app.Application;
import android.webkit.WebView;

/* renamed from: io.presage.Beaufort */
public final class Beaufort {

    /* renamed from: a */
    public static final CamembertauCalvados f16376a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final C6230au f16377b;

    /* renamed from: c */
    private final C6420dz f16378c;

    /* renamed from: io.presage.Beaufort$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static Beaufort m20207a() {
            return new Beaufort(new C6230au(), new C6420dz());
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public Beaufort(C6230au auVar, C6420dz dzVar) {
        this.f16377b = auVar;
        this.f16378c = dzVar;
    }

    /* renamed from: a */
    public final void mo34453a(C6556j jVar, PontlEveque pontlEveque, WebView webView, Application application) {
        if (jVar.mo35579d() && pontlEveque.mo34640p()) {
            this.f16378c.mo35388a(pontlEveque.mo34641q(), webView);
        }
        if (jVar.mo35576c() && pontlEveque.mo34639o()) {
            this.f16377b.mo34746a(application, webView);
        }
    }

    /* renamed from: a */
    public final void mo34452a() {
        this.f16378c.mo35387a();
        this.f16377b.mo34745a();
    }
}
