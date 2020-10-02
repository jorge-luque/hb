package p118io.presage;

import android.annotation.TargetApi;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: io.presage.am */
public abstract class C6222am extends WebViewClient {
    /* renamed from: a */
    public WebResourceResponse mo34732a(WebView webView, String str) {
        return null;
    }

    /* renamed from: a */
    public void mo34733a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder("onReceivedError: ");
        sb.append(i);
        sb.append(" description: ");
        sb.append(str);
        sb.append(" failingUrl: ");
        sb.append(str2);
    }

    /* renamed from: b */
    public boolean mo34734b(WebView webView, String str) {
        return true;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        mo34733a(i, str, str2);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return mo34732a(webView, str);
    }

    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        C6514hl.m21414a((Object) uri, "request.url.toString()");
        return mo34734b(webView, uri);
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        mo34733a(webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        C6514hl.m21414a((Object) uri, "request.url.toString()");
        return mo34732a(webView, uri);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return mo34734b(webView, str);
    }
}
