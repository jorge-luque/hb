package com.criteo.publisher.p068z;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.criteo.publisher.model.C2455p;
import com.loopj.android.http.C4250c;
import java.lang.ref.Reference;

/* renamed from: com.criteo.publisher.z.b */
public class C2592b implements Runnable {

    /* renamed from: a */
    private final Reference<? extends WebView> f8168a;

    /* renamed from: b */
    private final C2455p f8169b;

    /* renamed from: c */
    private final WebViewClient f8170c;

    /* renamed from: d */
    private final String f8171d;

    public C2592b(Reference<? extends WebView> reference, WebViewClient webViewClient, C2455p pVar, String str) {
        this.f8168a = reference;
        this.f8170c = webViewClient;
        this.f8169b = pVar;
        this.f8171d = str;
    }

    /* renamed from: a */
    private String m9714a() {
        return this.f8169b.mo10384c().replace(this.f8169b.mo10385d(), this.f8171d);
    }

    /* renamed from: b */
    private void m9715b() {
        WebView webView = (WebView) this.f8168a.get();
        if (webView != null) {
            String a = m9714a();
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(this.f8170c);
            webView.loadDataWithBaseURL("", a, "text/html", C4250c.DEFAULT_CHARSET, "");
        }
    }

    public void run() {
        try {
            m9715b();
        } catch (Throwable th) {
            Log.e("Criteo.BLT", "Internal BLT exec error.", th);
        }
    }
}
