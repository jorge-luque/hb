package com.ogury.p159cm;

import android.content.Context;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.ogury.core.OguryError;

/* renamed from: com.ogury.cm.aaaaa */
public final class aaaaa extends WebViewClient {

    /* renamed from: a */
    private aacab f11928a = new aacab();

    /* renamed from: b */
    private boolean f11929b;

    /* renamed from: c */
    private Context f11930c;

    /* renamed from: d */
    private final aacbc f11931d;

    public aaaaa(Context context, aacbc aacbc) {
        accbb.m15218b(context, "context");
        accbb.m15218b(aacbc, "consentCallback");
        this.f11930c = context;
        this.f11931d = aacbc;
    }

    /* renamed from: a */
    private final void m14891a(String str) {
        if (!this.f11929b) {
            this.f11929b = true;
            aacbc aacbc = this.f11931d;
            if (str == null) {
                str = "";
            }
            aacbc.mo29384a(new OguryError(1003, str));
            Context context = this.f11930c;
            if (!(context instanceof ConsentActivity)) {
                return;
            }
            if (context != null) {
                ((ConsentActivity) context).finish();
                return;
            }
            throw new acbab("null cannot be cast to non-null type com.ogury.cm.ConsentActivity");
        }
    }

    /* renamed from: a */
    private final boolean m14892a(String str, WebView webView) {
        if (this.f11929b) {
            return true;
        }
        this.f11928a.mo29423a(str, this.f11930c, this.f11931d, webView);
        return true;
    }

    /* renamed from: a */
    public final void mo29377a(Context context) {
        accbb.m15218b(context, "context");
        this.f11930c = context;
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        m14891a(str);
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        accbb.m15218b(webView, ViewHierarchyConstants.VIEW_KEY);
        accbb.m15218b(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        accbb.m15218b(webResourceError, "error");
        m14891a(webResourceError.getDescription().toString());
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        accbb.m15218b(webView, ViewHierarchyConstants.VIEW_KEY);
        accbb.m15218b(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return null;
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        accbb.m15218b(webView, ViewHierarchyConstants.VIEW_KEY);
        accbb.m15218b(str, "url");
        return null;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        accbb.m15218b(webView, ViewHierarchyConstants.VIEW_KEY);
        accbb.m15218b(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        String uri = webResourceRequest.getUrl().toString();
        accbb.m15215a((Object) uri, "request.url.toString()");
        return m14892a(uri, webView);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        accbb.m15218b(webView, ViewHierarchyConstants.VIEW_KEY);
        accbb.m15218b(str, "url");
        return m14892a(str, webView);
    }
}
