package p118io.presage;

import android.webkit.WebView;
import com.iab.omid.library.oguryco.adsession.AdSession;

/* renamed from: io.presage.dx */
public final class C6418dx {

    /* renamed from: a */
    private AdSession f17005a;

    /* renamed from: b */
    private C6419dy f17006b = new C6419dy();

    /* renamed from: a */
    public final void mo35386a(WebView webView, boolean z) {
        AdSession a = C6419dy.m21290a(webView, z);
        this.f17005a = a;
        if (a != null) {
            a.start();
        }
    }

    /* renamed from: a */
    public final void mo35385a() {
        AdSession adSession = this.f17005a;
        if (adSession != null) {
            adSession.finish();
        }
    }
}
