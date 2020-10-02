package com.iab.omid.library.oguryco.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* renamed from: com.iab.omid.library.oguryco.publisher.a */
public class C4226a extends AdSessionStatePublisher {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C4226a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        mo28766a(webView);
    }
}
