package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;

/* renamed from: com.applovin.impl.adview.b */
class C1547b extends WebChromeClient {

    /* renamed from: a */
    private final C1977q f4859a;

    public C1547b(C1941j jVar) {
        this.f4859a = jVar.mo8602v();
    }

    public void onConsoleMessage(String str, int i, String str2) {
        C1977q qVar = this.f4859a;
        qVar.mo8745d("AdWebView", "console.log[" + i + "] :" + str);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        this.f4859a.mo8742b("AdWebView", consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message());
        return true;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C1977q qVar = this.f4859a;
        qVar.mo8745d("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        C1977q qVar = this.f4859a;
        qVar.mo8745d("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        C1977q qVar = this.f4859a;
        qVar.mo8745d("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }
}
