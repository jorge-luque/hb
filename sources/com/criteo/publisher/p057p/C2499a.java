package com.criteo.publisher.p057p;

import android.content.ComponentName;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.criteo.publisher.C2387i;

/* renamed from: com.criteo.publisher.p.a */
public class C2499a extends WebViewClient {

    /* renamed from: a */
    private final C2502c f7989a;

    /* renamed from: b */
    private final ComponentName f7990b;

    /* renamed from: c */
    private final C2500b f7991c = C2387i.m9085U().mo10257J();

    public C2499a(C2502c cVar, ComponentName componentName) {
        this.f7989a = cVar;
        this.f7990b = componentName;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.f7991c.mo10507a(str, this.f7990b, this.f7989a);
        return true;
    }
}
