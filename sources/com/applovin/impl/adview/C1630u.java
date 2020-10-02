package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.u */
public class C1630u extends WebViewClient {

    /* renamed from: a */
    private final C1977q f5077a;

    /* renamed from: b */
    private WeakReference<C1631a> f5078b;

    /* renamed from: com.applovin.impl.adview.u$a */
    public interface C1631a {
        /* renamed from: a */
        void mo7489a(C1629t tVar);

        /* renamed from: b */
        void mo7490b(C1629t tVar);

        /* renamed from: c */
        void mo7491c(C1629t tVar);
    }

    public C1630u(C1941j jVar) {
        this.f5077a = jVar.mo8602v();
    }

    /* renamed from: a */
    private void m6210a(WebView webView, String str) {
        C1977q qVar = this.f5077a;
        qVar.mo8744c("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        if (str != null && (webView instanceof C1629t)) {
            C1629t tVar = (C1629t) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            C1631a aVar = (C1631a) this.f5078b.get();
            if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && aVar != null) {
                if ("/track_click".equals(path)) {
                    aVar.mo7489a(tVar);
                } else if ("/close_ad".equals(path)) {
                    aVar.mo7490b(tVar);
                } else if ("/skip_ad".equals(path)) {
                    aVar.mo7491c(tVar);
                } else {
                    C1977q qVar2 = this.f5077a;
                    qVar2.mo8745d("WebViewButtonClient", "Unknown URL: " + str);
                    C1977q qVar3 = this.f5077a;
                    qVar3.mo8745d("WebViewButtonClient", "Path: " + path);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo7552a(WeakReference<C1631a> weakReference) {
        this.f5078b = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m6210a(webView, str);
        return true;
    }
}
