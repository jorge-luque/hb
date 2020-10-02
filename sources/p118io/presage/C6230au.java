package p118io.presage;

import android.app.Application;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.WebAdTracker;

/* renamed from: io.presage.au */
public final class C6230au {

    /* renamed from: a */
    private WebAdTracker f16769a;

    /* renamed from: b */
    private final C6229at f16770b;

    private C6230au(C6229at atVar) {
        this.f16770b = atVar;
    }

    /* renamed from: a */
    private final void m20818a(Application application) {
        this.f16770b.mo34744a(application);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C6230au() {
        /*
            r3 = this;
            io.presage.at r0 = new io.presage.at
            com.moat.analytics.mobile.ogury.MoatAnalytics r1 = com.moat.analytics.mobile.ogury.MoatAnalytics.getInstance()
            java.lang.String r2 = "MoatAnalytics.getInstance()"
            p118io.presage.C6514hl.m21414a((java.lang.Object) r1, (java.lang.String) r2)
            r0.<init>(r1)
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.C6230au.<init>():void");
    }

    /* renamed from: a */
    private final void m20819a(WebView webView) {
        this.f16769a = C6229at.m20816a().createWebAdTracker(webView);
    }

    /* renamed from: a */
    public final void mo34746a(Application application, WebView webView) {
        m20818a(application);
        m20819a(webView);
        WebAdTracker webAdTracker = this.f16769a;
        if (webAdTracker != null) {
            webAdTracker.startTracking();
        }
    }

    /* renamed from: a */
    public final void mo34745a() {
        WebAdTracker webAdTracker = this.f16769a;
        if (webAdTracker != null) {
            webAdTracker.stopTracking();
        }
    }
}
