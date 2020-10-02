package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* renamed from: com.tapjoy.internal.dt */
public final class C4981dt extends C4979ds {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C4981dt(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        mo31070a(webView);
    }
}
