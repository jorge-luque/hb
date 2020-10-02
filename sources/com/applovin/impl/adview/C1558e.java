package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p051c.C1847b;

@TargetApi(29)
/* renamed from: com.applovin.impl.adview.e */
class C1558e {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f4881a;

    /* renamed from: b */
    private final WebViewRenderProcessClient f4882b = new WebViewRenderProcessClient() {
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            if (webView instanceof C1548c) {
                C1827g currentAd = ((C1548c) webView).getCurrentAd();
                C1558e.this.f4881a.mo8545X().mo8346a((AppLovinAdBase) currentAd).mo8354a(C1847b.f6123D).mo8357a();
                C1977q v = C1558e.this.f4881a.mo8602v();
                v.mo8746e("AdWebViewRenderProcessClient", "WebView render process unresponsive for ad: " + currentAd);
            }
        }
    };

    C1558e(C1941j jVar) {
        this.f4881a = jVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WebViewRenderProcessClient mo7400a() {
        return this.f4882b;
    }
}
