package com.iab.omid.library.adcolony.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* renamed from: com.iab.omid.library.adcolony.publisher.a */
public class C4175a extends AdSessionStatePublisher {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C4175a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        mo28552a(webView);
    }
}
