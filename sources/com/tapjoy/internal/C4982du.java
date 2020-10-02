package com.tapjoy.internal;

import android.os.Handler;
import android.webkit.WebView;
import com.vungle.warren.AdLoader;
import java.util.List;

/* renamed from: com.tapjoy.internal.du */
public final class C4982du extends C4979ds {

    /* renamed from: f */
    WebView f13523f;

    /* renamed from: g */
    private List f13524g;

    /* renamed from: h */
    private final String f13525h;

    public C4982du(List list, String str) {
        this.f13524g = list;
        this.f13525h = str;
    }

    /* renamed from: a */
    public final void mo31068a() {
        super.mo31068a();
        WebView webView = new WebView(C4963df.m16824a().f13494a);
        this.f13523f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        mo31070a(this.f13523f);
        C4964dg.m16825a();
        C4964dg.m16827a(this.f13523f, this.f13525h);
        for (C4954cy cyVar : this.f13524g) {
            String externalForm = cyVar.f13461b.toExternalForm();
            C4964dg.m16825a();
            WebView webView2 = this.f13523f;
            if (externalForm != null) {
                C4964dg.m16827a(webView2, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", externalForm));
            }
        }
    }

    /* renamed from: b */
    public final void mo31074b() {
        super.mo31074b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            private WebView f13527b = C4982du.this.f13523f;

            public final void run() {
                this.f13527b.destroy();
            }
        }, AdLoader.RETRY_DELAY);
        this.f13523f = null;
    }
}
