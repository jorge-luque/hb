package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.p033a.C1481b;
import com.applovin.impl.p033a.C1489i;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1847b;
import com.applovin.impl.sdk.p051c.C1854d;
import com.applovin.impl.sdk.utils.C1984a;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.applovin.impl.adview.d */
class C1556d extends WebViewClient {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f4876a;

    /* renamed from: b */
    private final C1977q f4877b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AdViewControllerImpl f4878c;

    public C1556d(AdViewControllerImpl adViewControllerImpl, C1941j jVar) {
        this.f4876a = jVar;
        this.f4877b = jVar.mo8602v();
        this.f4878c = adViewControllerImpl;
    }

    /* renamed from: a */
    private void m5999a() {
        this.f4878c.mo7236a();
    }

    /* renamed from: a */
    private void m6000a(PointF pointF) {
        this.f4878c.expandAd(pointF);
    }

    /* renamed from: a */
    private void m6001a(Uri uri, C1548c cVar) {
        String str;
        C1977q qVar;
        final String queryParameter = uri.getQueryParameter("n");
        if (C2025o.m7963b(queryParameter)) {
            String queryParameter2 = uri.getQueryParameter("load_type");
            if ("external".equalsIgnoreCase(queryParameter2)) {
                C1977q qVar2 = this.f4877b;
                qVar2.mo8742b("AdWebView", "Loading new page externally: " + queryParameter);
                C2029r.m8016a(cVar.getContext(), Uri.parse(queryParameter), this.f4876a);
                C1994j.m7927c(this.f4878c.getAdViewEventListener(), (AppLovinAd) this.f4878c.getCurrentAd(), this.f4878c.getParentView());
                return;
            } else if (TapjoyConstants.LOG_LEVEL_INTERNAL.equalsIgnoreCase(queryParameter2)) {
                C1977q qVar3 = this.f4877b;
                qVar3.mo8742b("AdWebView", "Loading new page in WebView: " + queryParameter);
                cVar.loadUrl(queryParameter);
                String queryParameter3 = uri.getQueryParameter("bg_color");
                if (C2025o.m7963b(queryParameter3)) {
                    cVar.setBackgroundColor(Color.parseColor(queryParameter3));
                    return;
                }
                return;
            } else if ("in_app".equalsIgnoreCase(queryParameter2)) {
                C1977q qVar4 = this.f4877b;
                qVar4.mo8742b("AdWebView", "Loading new page in slide-up webview: " + queryParameter);
                this.f4876a.mo8565aa().mo8071a(new C1984a() {
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            ((AppLovinWebViewActivity) activity).loadUrl(queryParameter, (AppLovinWebViewActivity.EventListener) null);
                            C1994j.m7908a(C1556d.this.f4878c.getAdViewEventListener(), (AppLovinAd) C1556d.this.f4878c.getCurrentAd(), C1556d.this.f4878c.getParentView());
                        }
                    }

                    public void onActivityDestroyed(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            C1994j.m7923b(C1556d.this.f4878c.getAdViewEventListener(), (AppLovinAd) C1556d.this.f4878c.getCurrentAd(), C1556d.this.f4878c.getParentView());
                            C1556d.this.f4876a.mo8565aa().mo8073b(this);
                        }
                    }
                });
                Intent intent = new Intent(this.f4876a.mo8527E(), AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f4876a.mo8599t());
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                this.f4876a.mo8527E().startActivity(intent);
                return;
            } else {
                qVar = this.f4877b;
                str = "Could not find load type in original uri";
            }
        } else {
            qVar = this.f4877b;
            str = "Could not find url to load from query in original uri";
        }
        qVar.mo8746e("AdWebView", str);
    }

    /* renamed from: a */
    private void m6002a(C1476a aVar, C1548c cVar) {
        C1481b m = aVar.mo7167m();
        if (m != null) {
            C1489i.m5789a(m.mo7185c(), this.f4878c.getSdk());
            m6003a(cVar, m.mo7183a());
        }
    }

    /* renamed from: a */
    private void m6003a(C1548c cVar, Uri uri) {
        C1827g currentAd = cVar.getCurrentAd();
        AppLovinAdView parentView = this.f4878c.getParentView();
        if (parentView == null || currentAd == null) {
            C1977q qVar = this.f4877b;
            qVar.mo8746e("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
            return;
        }
        C1854d statsManagerHelper = cVar.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.mo8361b();
        }
        this.f4878c.mo7238a(currentAd, parentView, uri, cVar.getAndClearLastClickLocation());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0114, code lost:
        if (r6.mo7146aQ() != false) goto L_0x00a5;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m6004a(android.webkit.WebView r9, java.lang.String r10, boolean r11) {
        /*
            r8 = this;
            com.applovin.impl.sdk.q r0 = r8.f4877b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Processing click on ad URL \""
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = "\""
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AdWebView"
            r0.mo8744c(r2, r1)
            r0 = 1
            if (r10 == 0) goto L_0x011d
            boolean r1 = r9 instanceof com.applovin.impl.adview.C1548c
            if (r1 == 0) goto L_0x011d
            android.net.Uri r1 = android.net.Uri.parse(r10)
            com.applovin.impl.adview.c r9 = (com.applovin.impl.adview.C1548c) r9
            java.lang.String r3 = r1.getScheme()
            java.lang.String r4 = r1.getHost()
            java.lang.String r5 = r1.getPath()
            com.applovin.impl.adview.AdViewControllerImpl r6 = r8.f4878c
            com.applovin.impl.sdk.ad.g r6 = r6.getCurrentAd()
            if (r6 != 0) goto L_0x0046
            com.applovin.impl.sdk.q r9 = r8.f4877b
            java.lang.String r10 = "Unable to process click, ad not found!"
            r9.mo8746e(r2, r10)
            return r0
        L_0x0046:
            java.lang.String r7 = "applovin"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x00df
            java.lang.String r7 = "com.applovin.sdk"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x00df
            java.lang.String r11 = "/adservice/close_ad"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0063
            r8.m5999a()
            goto L_0x011d
        L_0x0063:
            java.lang.String r11 = "/adservice/expand_ad"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0074
            android.graphics.PointF r9 = r9.getAndClearLastClickLocation()
            r8.m6000a((android.graphics.PointF) r9)
            goto L_0x011d
        L_0x0074:
            java.lang.String r11 = "/adservice/contract_ad"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0081
            r8.m6006b()
            goto L_0x011d
        L_0x0081:
            java.lang.String r11 = "/adservice/no_op"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x008a
            return r0
        L_0x008a:
            java.lang.String r11 = "/adservice/load_url"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0097
            r8.m6001a((android.net.Uri) r1, (com.applovin.impl.adview.C1548c) r9)
            goto L_0x011d
        L_0x0097:
            java.lang.String r11 = "/adservice/track_click_now"
            boolean r1 = r11.equals(r5)
            if (r1 == 0) goto L_0x00b2
            boolean r10 = r6 instanceof com.applovin.impl.p033a.C1476a
            if (r10 == 0) goto L_0x00aa
            com.applovin.impl.a.a r6 = (com.applovin.impl.p033a.C1476a) r6
        L_0x00a5:
            r8.m6002a((com.applovin.impl.p033a.C1476a) r6, (com.applovin.impl.adview.C1548c) r9)
            goto L_0x011d
        L_0x00aa:
            android.net.Uri r10 = android.net.Uri.parse(r11)
            r8.m6003a((com.applovin.impl.adview.C1548c) r9, (android.net.Uri) r10)
            goto L_0x011d
        L_0x00b2:
            com.applovin.impl.sdk.q r9 = r8.f4877b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "Unknown URL: "
            r11.append(r1)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.mo8745d(r2, r10)
            com.applovin.impl.sdk.q r9 = r8.f4877b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Path: "
            r10.append(r11)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            r9.mo8745d(r2, r10)
            goto L_0x011d
        L_0x00df:
            if (r11 == 0) goto L_0x011b
            java.util.List r10 = r6.mo8237aG()
            java.util.List r11 = r6.mo8238aH()
            boolean r5 = r10.isEmpty()
            if (r5 != 0) goto L_0x00f5
            boolean r10 = r10.contains(r3)
            if (r10 == 0) goto L_0x0102
        L_0x00f5:
            boolean r10 = r11.isEmpty()
            if (r10 != 0) goto L_0x010a
            boolean r10 = r11.contains(r4)
            if (r10 == 0) goto L_0x0102
            goto L_0x010a
        L_0x0102:
            com.applovin.impl.sdk.q r9 = r8.f4877b
            java.lang.String r10 = "URL is not whitelisted - bypassing click"
            r9.mo8746e(r2, r10)
            goto L_0x011d
        L_0x010a:
            boolean r10 = r6 instanceof com.applovin.impl.p033a.C1476a
            if (r10 == 0) goto L_0x0117
            com.applovin.impl.a.a r6 = (com.applovin.impl.p033a.C1476a) r6
            boolean r10 = r6.mo7146aQ()
            if (r10 == 0) goto L_0x0117
            goto L_0x00a5
        L_0x0117:
            r8.m6003a((com.applovin.impl.adview.C1548c) r9, (android.net.Uri) r1)
            goto L_0x011d
        L_0x011b:
            r9 = 0
            return r9
        L_0x011d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C1556d.m6004a(android.webkit.WebView, java.lang.String, boolean):boolean");
    }

    /* renamed from: b */
    private void m6006b() {
        this.f4878c.contractAd();
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        C1977q qVar = this.f4877b;
        qVar.mo8744c("AdWebView", "Loaded resource: " + str);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f4878c.onAdHtmlLoaded(webView);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        C1827g currentAd = this.f4878c.getCurrentAd();
        String str3 = "Received error with error code: " + i + " with description \\'" + str + "\\' for URL: " + str2;
        if (currentAd != null) {
            this.f4876a.mo8545X().mo8346a((AppLovinAdBase) currentAd).mo8356a(C1847b.f6150z, str3).mo8357a();
        }
        this.f4877b.mo8746e("AdWebView", str3 + " for ad: " + currentAd);
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        C1827g currentAd = this.f4878c.getCurrentAd();
        this.f4876a.mo8545X().mo8346a((AppLovinAdBase) currentAd).mo8354a(C1847b.f6120A).mo8357a();
        C1977q qVar = this.f4877b;
        qVar.mo8746e("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + currentAd);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        C1827g currentAd = this.f4878c.getCurrentAd();
        String str = "Received SSL error: " + sslError;
        this.f4876a.mo8545X().mo8346a((AppLovinAdBase) currentAd).mo8356a(C1847b.f6122C, str).mo8357a();
        this.f4877b.mo8746e("AdWebView", str + " for ad: " + currentAd);
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        C1977q.m7751i("AdWebView", "Render process gone for ad: " + this.f4878c.getCurrentAd() + ". Process did crash: " + renderProcessGoneDetail.didCrash());
        C1827g currentAd = this.f4878c.getCurrentAd();
        if (currentAd != null) {
            this.f4876a.mo8545X().mo8346a((AppLovinAdBase) currentAd).mo8354a(C1847b.f6121B).mo8357a();
        }
        if (!((Boolean) this.f4876a.mo8549a(C1841c.f6033eX)).booleanValue()) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (webView == null || !webView.equals(this.f4878c.getAdWebView())) {
            return true;
        }
        this.f4878c.destroy();
        AppLovinAdSize size = this.f4878c.getSize();
        if (!C2029r.m8019a(size)) {
            return true;
        }
        this.f4878c.attachNewAdView(size);
        this.f4878c.resume();
        return true;
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean hasGesture = ((Boolean) this.f4876a.mo8549a(C1841c.f5875bV)).booleanValue() ? webResourceRequest.hasGesture() : true;
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return m6004a(webView, url.toString(), hasGesture);
        }
        this.f4877b.mo8746e("AdWebView", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return m6004a(webView, str, true);
    }
}
