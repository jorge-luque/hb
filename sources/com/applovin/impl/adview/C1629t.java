package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1841c;

/* renamed from: com.applovin.impl.adview.t */
public class C1629t extends C1562g {

    /* renamed from: a */
    private static C1629t f5076a;

    public C1629t(C1630u uVar, Context context) {
        super(context);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(uVar);
        setWebChromeClient(new WebChromeClient());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
    }

    /* renamed from: a */
    public static C1629t m6208a(C1941j jVar, C1630u uVar, Context context) {
        if (!((Boolean) jVar.mo8549a(C1841c.f6031eV)).booleanValue()) {
            return new C1629t(uVar, context);
        }
        C1629t tVar = f5076a;
        if (tVar == null) {
            f5076a = new C1629t(uVar, context);
        } else {
            tVar.loadUrl("about:blank");
            f5076a.clearHistory();
            f5076a.setWebViewClient(uVar);
        }
        return f5076a;
    }

    /* renamed from: a */
    public void mo7551a(String str) {
        loadDataWithBaseURL("/", str, "text/html", (String) null, "");
    }
}
