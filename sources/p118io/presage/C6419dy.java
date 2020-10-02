package p118io.presage;

import android.webkit.WebView;
import com.iab.omid.library.oguryco.adsession.AdSession;

/* renamed from: io.presage.dy */
public final class C6419dy {
    /* renamed from: a */
    public static AdSession m21290a(WebView webView, boolean z) {
        try {
            C6414dt dtVar = C6414dt.f16999a;
            C6415du a = C6414dt.m21279a(webView, z);
            AdSession createAdSession = AdSession.createAdSession(a != null ? a.mo35384b() : null, a != null ? a.mo35381a() : null);
            createAdSession.registerAdView(webView);
            return createAdSession;
        } catch (Exception e) {
            C6416dv dvVar = C6416dv.f17002a;
            C6416dv.m21284a(e);
            return null;
        }
    }
}
