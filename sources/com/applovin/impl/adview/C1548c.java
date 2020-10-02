package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.p033a.C1481b;
import com.applovin.impl.p033a.C1484e;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1817a;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1854d;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.c */
public class C1548c extends C1562g {

    /* renamed from: c */
    private static C1548c f4860c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static WebView f4861d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static volatile String f4862e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static volatile Map<String, String> f4863f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1977q f4864a;

    /* renamed from: b */
    private final C1941j f4865b;

    /* renamed from: g */
    private C1854d f4866g;

    /* renamed from: h */
    private C1827g f4867h;

    /* renamed from: i */
    private boolean f4868i;

    /* renamed from: j */
    private boolean f4869j;

    /* renamed from: k */
    private final boolean f4870k;

    /* renamed from: com.applovin.impl.adview.c$a */
    private static class C1555a extends WebViewClient {
        private C1555a() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return true;
        }
    }

    static {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                WebView unused = C1548c.f4861d = new WebView(C1941j.m7443F());
                C1548c.f4861d.setWebViewClient(new C1555a());
            }
        });
    }

    C1548c(C1556d dVar, C1941j jVar, Context context) {
        this(dVar, jVar, context, false);
    }

    C1548c(C1556d dVar, C1941j jVar, Context context, boolean z) {
        super(context);
        if (jVar != null) {
            this.f4865b = jVar;
            this.f4864a = jVar.mo8602v();
            this.f4870k = z;
            setBackgroundColor(0);
            WebSettings settings = getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            setWebViewClient(dVar);
            setWebChromeClient(new C1547b(jVar));
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            if (C1991g.m7844g()) {
                setWebViewRenderProcessClient(new C1558e(jVar).mo7400a());
            }
            setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (view.hasFocus()) {
                        return false;
                    }
                    view.requestFocus();
                    return false;
                }
            });
            setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    C1548c.this.f4864a.mo8742b("AdWebView", "Received a LongClick event.");
                    return true;
                }
            });
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    public static C1548c m5984a(AppLovinAdSize appLovinAdSize, C1556d dVar, C1941j jVar, Context context) {
        if (!((Boolean) jVar.mo8549a(C1841c.f6034eY)).booleanValue() || appLovinAdSize != AppLovinAdSize.INTERSTITIAL) {
            return new C1548c(dVar, jVar, context);
        }
        C1548c cVar = f4860c;
        if (cVar == null) {
            f4860c = new C1548c(dVar, jVar, context.getApplicationContext(), true);
        } else {
            cVar.setWebViewClient(dVar);
        }
        return f4860c;
    }

    /* renamed from: a */
    public static String m5986a(long j) {
        if (f4862e != null || j <= 0) {
            return f4862e;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    String unused = C1548c.f4862e = C1548c.f4861d.getSettings().getUserAgentString();
                } catch (Throwable unused2) {
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(j, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
        }
        return f4862e;
    }

    /* renamed from: a */
    private String m5987a(String str, String str2) {
        if (C2025o.m7963b(str)) {
            return C2029r.m7999a(this.f4869j, str).replace("{SOURCE}", str2);
        }
        return null;
    }

    /* renamed from: a */
    private void m5989a(String str, String str2, String str3, C1941j jVar) {
        String a = m5987a(str3, str);
        if (C2025o.m7963b(a)) {
            C1977q qVar = this.f4864a;
            qVar.mo8742b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a);
            loadDataWithBaseURL(str2, a, "text/html", (String) null, "");
            return;
        }
        String a2 = m5987a((String) jVar.mo8549a(C1841c.f6010eA), str);
        if (C2025o.m7963b(a2)) {
            C1977q qVar2 = this.f4864a;
            qVar2.mo8742b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a2);
            loadDataWithBaseURL(str2, a2, "text/html", (String) null, "");
            return;
        }
        C1977q qVar3 = this.f4864a;
        qVar3.mo8742b("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        loadUrl(str);
    }

    /* renamed from: b */
    public static Map<String, String> m5992b(long j) {
        if (f4863f != null || j <= 0) {
            return f4863f;
        }
        if (C1991g.m7841d()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    C1548c.f4861d.setWebViewClient(new C1555a() {
                        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                            HashMap hashMap = new HashMap();
                            for (Map.Entry next : webResourceRequest.getRequestHeaders().entrySet()) {
                                hashMap.put("AppLovin-WebView-" + ((String) next.getKey()), next.getValue());
                            }
                            Map unused = C1548c.f4863f = hashMap;
                            countDownLatch.countDown();
                            return super.shouldInterceptRequest(webView, webResourceRequest);
                        }
                    });
                    C1548c.f4861d.loadUrl("https://blank");
                }
            });
            try {
                countDownLatch.await(j, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        return f4863f;
    }

    /* renamed from: b */
    private void m5993b(C1827g gVar) {
        Boolean n;
        Integer a;
        if (((Boolean) this.f4865b.mo8549a(C1841c.f6025eP)).booleanValue() || gVar.mo8233aC()) {
            loadUrl("about:blank");
        }
        if (C1991g.m7839b()) {
            getSettings().setMediaPlaybackRequiresUserGesture(gVar.mo8232aB());
        }
        if (C1991g.m7840c() && gVar.mo8235aE()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        C1632v aF = gVar.mo8236aF();
        if (aF != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState b = aF.mo7555b();
            if (b != null) {
                settings.setPluginState(b);
            }
            Boolean c = aF.mo7556c();
            if (c != null) {
                settings.setAllowFileAccess(c.booleanValue());
            }
            Boolean d = aF.mo7557d();
            if (d != null) {
                settings.setLoadWithOverviewMode(d.booleanValue());
            }
            Boolean e = aF.mo7558e();
            if (e != null) {
                settings.setUseWideViewPort(e.booleanValue());
            }
            Boolean f = aF.mo7559f();
            if (f != null) {
                settings.setAllowContentAccess(f.booleanValue());
            }
            Boolean g = aF.mo7560g();
            if (g != null) {
                settings.setBuiltInZoomControls(g.booleanValue());
            }
            Boolean h = aF.mo7561h();
            if (h != null) {
                settings.setDisplayZoomControls(h.booleanValue());
            }
            Boolean i = aF.mo7562i();
            if (i != null) {
                settings.setSaveFormData(i.booleanValue());
            }
            Boolean j = aF.mo7563j();
            if (j != null) {
                settings.setGeolocationEnabled(j.booleanValue());
            }
            Boolean k = aF.mo7564k();
            if (k != null) {
                settings.setNeedInitialFocus(k.booleanValue());
            }
            Boolean l = aF.mo7565l();
            if (l != null) {
                settings.setAllowFileAccessFromFileURLs(l.booleanValue());
            }
            Boolean m = aF.mo7566m();
            if (m != null) {
                settings.setAllowUniversalAccessFromFileURLs(m.booleanValue());
            }
            if (C1991g.m7841d() && (a = aF.mo7554a()) != null) {
                settings.setMixedContentMode(a.intValue());
            }
            if (C1991g.m7842e() && (n = aF.mo7567n()) != null) {
                settings.setOffscreenPreRaster(n.booleanValue());
            }
        }
    }

    public static Map<String, String> getHttpHeaders() {
        return f4863f;
    }

    /* renamed from: a */
    public void mo7371a(C1827g gVar) {
        C1977q qVar;
        String str;
        C1977q qVar2;
        String str2;
        String str3;
        String aD;
        String str4;
        String str5;
        String str6;
        String aD2;
        C1941j jVar;
        if (!this.f4868i) {
            this.f4867h = gVar;
            try {
                m5993b(gVar);
                if (gVar.mo8258al()) {
                    setVisibility(0);
                }
                if (gVar instanceof C1817a) {
                    loadDataWithBaseURL(gVar.mo8234aD(), C2029r.m7999a(this.f4869j, ((C1817a) gVar).mo7152b()), "text/html", (String) null, "");
                    qVar = this.f4864a;
                    str = "AppLovinAd rendered";
                } else if (gVar instanceof C1476a) {
                    C1476a aVar = (C1476a) gVar;
                    C1481b m = aVar.mo7167m();
                    if (m != null) {
                        C1484e b = m.mo7184b();
                        Uri b2 = b.mo7203b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c = b.mo7204c();
                        String aR = aVar.mo7147aR();
                        if (!C2025o.m7963b(uri)) {
                            if (!C2025o.m7963b(c)) {
                                qVar2 = this.f4864a;
                                str2 = "Unable to load companion ad. No resources provided.";
                                qVar2.mo8746e("AdWebView", str2);
                                return;
                            }
                        }
                        if (b.mo7200a() == C1484e.C1485a.STATIC) {
                            this.f4864a.mo8742b("AdWebView", "Rendering WebView for static VAST ad");
                            loadDataWithBaseURL(gVar.mo8234aD(), m5987a((String) this.f4865b.mo8549a(C1841c.f6061ez), uri), "text/html", (String) null, "");
                            return;
                        }
                        if (b.mo7200a() == C1484e.C1485a.HTML) {
                            if (C2025o.m7963b(c)) {
                                String a = m5987a(aR, c);
                                str3 = C2025o.m7963b(a) ? a : c;
                                C1977q qVar3 = this.f4864a;
                                qVar3.mo8742b("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str3);
                                aD = gVar.mo8234aD();
                                str4 = "text/html";
                                str5 = null;
                                str6 = "";
                            } else if (C2025o.m7963b(uri)) {
                                this.f4864a.mo8742b("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                aD2 = gVar.mo8234aD();
                                jVar = this.f4865b;
                                m5989a(uri, aD2, aR, jVar);
                                return;
                            } else {
                                return;
                            }
                        } else if (b.mo7200a() != C1484e.C1485a.IFRAME) {
                            qVar2 = this.f4864a;
                            str2 = "Failed to render VAST companion ad of invalid type";
                            qVar2.mo8746e("AdWebView", str2);
                            return;
                        } else if (C2025o.m7963b(uri)) {
                            this.f4864a.mo8742b("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                            aD2 = gVar.mo8234aD();
                            jVar = this.f4865b;
                            m5989a(uri, aD2, aR, jVar);
                            return;
                        } else if (C2025o.m7963b(c)) {
                            String a2 = m5987a(aR, c);
                            str3 = C2025o.m7963b(a2) ? a2 : c;
                            C1977q qVar4 = this.f4864a;
                            qVar4.mo8742b("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str3);
                            aD = gVar.mo8234aD();
                            str4 = "text/html";
                            str5 = null;
                            str6 = "";
                        } else {
                            return;
                        }
                        loadDataWithBaseURL(aD, str3, str4, str5, str6);
                        return;
                    }
                    qVar = this.f4864a;
                    str = "No companion ad provided.";
                } else {
                    return;
                }
                qVar.mo8742b("AdWebView", str);
            } catch (Throwable th) {
                String valueOf = gVar != null ? String.valueOf(gVar.getAdIdNumber()) : "null";
                throw new RuntimeException("Unable to render AppLovin ad (" + valueOf + ") - " + th);
            }
        } else {
            C1977q.m7751i("AdWebView", "Ad can not be loaded in a destroyed webview");
        }
    }

    /* renamed from: a */
    public void mo7372a(String str) {
        mo7373a(str, (Runnable) null);
    }

    /* renamed from: a */
    public void mo7373a(String str, Runnable runnable) {
        try {
            C1977q qVar = this.f4864a;
            qVar.mo8742b("AdWebView", "Forwarding \"" + str + "\" to ad template");
            loadUrl(str);
        } catch (Throwable th) {
            this.f4864a.mo8743b("AdWebView", "Unable to forward to template", th);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: a */
    public boolean mo7374a() {
        return this.f4870k;
    }

    public void computeScroll() {
    }

    public void destroy() {
        this.f4868i = true;
        super.destroy();
    }

    /* access modifiers changed from: package-private */
    public C1827g getCurrentAd() {
        return this.f4867h;
    }

    public C1854d getStatsManagerHelper() {
        return this.f4866g;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void scrollTo(int i, int i2) {
    }

    public void setIsShownOutOfContext(boolean z) {
        this.f4869j = z;
    }

    public void setStatsManagerHelper(C1854d dVar) {
        this.f4866g = dVar;
    }
}
