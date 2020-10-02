package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.adcolony.sdk.C1439u;
import com.facebook.GraphResponse;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.iab.omid.library.adcolony.ScriptInjector;
import com.iab.omid.library.adcolony.adsession.FriendlyObstructionPurpose;
import com.loopj.android.http.C4250c;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TJAdUnitConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
/* renamed from: com.adcolony.sdk.m0 */
class C1379m0 extends WebView implements C1201a0 {

    /* renamed from: N */
    static boolean f4345N = false;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f4346A;

    /* renamed from: B */
    private boolean f4347B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f4348C;

    /* renamed from: D */
    private boolean f4349D;

    /* renamed from: E */
    private boolean f4350E;

    /* renamed from: F */
    private boolean f4351F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public JSONArray f4352G = C1437s.m5579a();
    /* access modifiers changed from: private */

    /* renamed from: H */
    public JSONObject f4353H = C1437s.m5599b();

    /* renamed from: I */
    private JSONObject f4354I = C1437s.m5599b();
    /* access modifiers changed from: private */

    /* renamed from: J */
    public C1205c f4355J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C1454x f4356K;

    /* renamed from: L */
    private ImageView f4357L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public final Object f4358M = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f4359a;

    /* renamed from: b */
    private String f4360b;

    /* renamed from: c */
    private String f4361c = "";

    /* renamed from: d */
    private String f4362d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f4363e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f4364f = "";

    /* renamed from: g */
    private String f4365g = "";

    /* renamed from: h */
    private String f4366h = "";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f4367i = "";

    /* renamed from: j */
    private String f4368j = "";
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f4369k;

    /* renamed from: l */
    private int f4370l;

    /* renamed from: m */
    private int f4371m;

    /* renamed from: n */
    private int f4372n;

    /* renamed from: o */
    private int f4373o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f4374p;

    /* renamed from: q */
    private int f4375q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f4376r;

    /* renamed from: s */
    private int f4377s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f4378t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f4379u;

    /* renamed from: v */
    private int f4380v;

    /* renamed from: w */
    private int f4381w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f4382x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f4383y;

    /* renamed from: z */
    private boolean f4384z;

    /* renamed from: com.adcolony.sdk.m0$a */
    class C1380a implements Runnable {
        C1380a() {
        }

        public void run() {
            String str;
            synchronized (C1379m0.this.f4358M) {
                str = "";
                if (C1379m0.this.f4352G.length() > 0) {
                    if (C1379m0.this.f4382x) {
                        str = C1379m0.this.f4352G.toString();
                    }
                    JSONArray unused = C1379m0.this.f4352G = C1437s.m5579a();
                }
            }
            if (C1379m0.this.f4382x) {
                C1379m0 m0Var = C1379m0.this;
                m0Var.mo6714b("NativeLayer.dispatch_messages(ADC3_update(" + str + "));");
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$b */
    class C1381b implements Runnable {
        C1381b() {
        }

        public void run() {
            C1218c0 c0Var;
            int i;
            try {
                C1222d b = C1199a.m4880c().mo6530b();
                AdColonyInterstitial adColonyInterstitial = b.mo6453a().get(C1379m0.this.f4363e);
                AdColonyAdView adColonyAdView = b.mo6458b().get(C1379m0.this.f4363e);
                if (adColonyInterstitial == null) {
                    c0Var = null;
                } else {
                    c0Var = adColonyInterstitial.mo6331e();
                }
                if (c0Var == null && adColonyAdView != null) {
                    c0Var = adColonyAdView.getOmidManager();
                }
                if (c0Var == null) {
                    i = -1;
                } else {
                    i = c0Var.mo6449d();
                }
                if (c0Var != null && i == 2) {
                    c0Var.mo6443a((WebView) C1379m0.this);
                    c0Var.mo6444a(C1379m0.this.f4355J);
                }
            } catch (IllegalArgumentException unused) {
                new C1439u.C1440a().mo6801a("IllegalArgumentException when creating omid session").mo6803a(C1439u.f4517j);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$c */
    class C1382c extends WebChromeClient {

        /* renamed from: a */
        final /* synthetic */ JSONObject f4387a;

        C1382c(JSONObject jSONObject) {
            this.f4387a = jSONObject;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String str;
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            String message = consoleMessage.message();
            boolean z = false;
            boolean z2 = messageLevel == ConsoleMessage.MessageLevel.ERROR;
            if (consoleMessage.message().contains("Viewport argument key \"shrink-to-fit\" not recognized and ignored") || consoleMessage.message().contains("Viewport target-densitydpi is not supported.")) {
                z = true;
            }
            if (message.contains("ADC3_update is not defined") || message.contains("NativeLayer.dispatch_messages is not a function")) {
                C1379m0.this.m5425a(this.f4387a, "Unable to communicate with AdColony. Please ensure that you have added an exception for our Javascript interface in your ProGuard configuration and that you do not have a faulty proxy enabled on your device.");
            }
            if (!z && (messageLevel == ConsoleMessage.MessageLevel.WARNING || z2)) {
                AdColonyInterstitial adColonyInterstitial = null;
                if (C1379m0.this.f4363e != null) {
                    adColonyInterstitial = C1199a.m4880c().mo6530b().mo6453a().get(C1379m0.this.f4363e);
                }
                if (adColonyInterstitial == null) {
                    str = "unknown";
                } else {
                    str = adColonyInterstitial.mo6316a();
                }
                new C1439u.C1440a().mo6801a("onConsoleMessage: ").mo6801a(consoleMessage.message()).mo6801a(" with ad id: ").mo6801a(str).mo6803a(z2 ? C1439u.f4517j : C1439u.f4515h);
            }
            return true;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }
    }

    /* renamed from: com.adcolony.sdk.m0$d */
    class C1383d extends C1395l {
        C1383d() {
            super(C1379m0.this, (C1382c) null);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            C1379m0.this.m5420a(webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest.getUrl().toString().endsWith("mraid.js")) {
                try {
                    return new WebResourceResponse("text/javascript", C4250c.DEFAULT_CHARSET, new ByteArrayInputStream(C1379m0.this.f4364f.getBytes(C4250c.DEFAULT_CHARSET)));
                } catch (UnsupportedEncodingException unused) {
                    new C1439u.C1440a().mo6801a("UTF-8 not supported.").mo6803a(C1439u.f4517j);
                }
            }
            return null;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (!C1379m0.this.f4346A || !webResourceRequest.isForMainFrame()) {
                return false;
            }
            Uri url = webResourceRequest.getUrl();
            C1359k0.m5307a(new Intent("android.intent.action.VIEW", url));
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "url", url.toString());
            C1437s.m5592a(b, "ad_session_id", C1379m0.this.f4363e);
            new C1454x("WebView.redirect_detected", C1379m0.this.f4355J.mo6428k(), b).mo6834d();
            C1316i0 w = C1199a.m4880c().mo6556w();
            w.mo6584a(C1379m0.this.f4363e);
            w.mo6587c(C1379m0.this.f4363e);
            return true;
        }
    }

    /* renamed from: com.adcolony.sdk.m0$e */
    class C1384e extends C1395l {
        C1384e() {
            super(C1379m0.this, (C1382c) null);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest.getUrl().toString().endsWith("mraid.js")) {
                try {
                    return new WebResourceResponse("text/javascript", C4250c.DEFAULT_CHARSET, new ByteArrayInputStream(C1379m0.this.f4364f.getBytes(C4250c.DEFAULT_CHARSET)));
                } catch (UnsupportedEncodingException unused) {
                    new C1439u.C1440a().mo6801a("UTF-8 not supported.").mo6803a(C1439u.f4517j);
                }
            }
            return null;
        }
    }

    /* renamed from: com.adcolony.sdk.m0$f */
    class C1385f {
        C1385f() {
        }

        @JavascriptInterface
        public void dispatch_messages(String str) {
            C1379m0.this.m5424a(str);
        }

        @JavascriptInterface
        public void enable_reverse_messaging() {
            boolean unused = C1379m0.this.f4348C = true;
        }

        @JavascriptInterface
        public String pull_messages() {
            String str;
            synchronized (C1379m0.this.f4358M) {
                str = "[]";
                if (C1379m0.this.f4352G.length() > 0) {
                    if (C1379m0.this.f4382x) {
                        str = C1379m0.this.f4352G.toString();
                    }
                    JSONArray unused = C1379m0.this.f4352G = C1437s.m5579a();
                }
            }
            return str;
        }

        @JavascriptInterface
        public void push_messages(String str) {
            C1379m0.this.m5424a(str);
        }
    }

    /* renamed from: com.adcolony.sdk.m0$g */
    class C1386g implements C1458z {

        /* renamed from: com.adcolony.sdk.m0$g$a */
        class C1387a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4393a;

            C1387a(C1454x xVar) {
                this.f4393a = xVar;
            }

            public void run() {
                C1379m0.this.mo6713b(this.f4393a);
            }
        }

        C1386g() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1379m0.this.mo6715c(xVar)) {
                C1359k0.m5309a((Runnable) new C1387a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$h */
    class C1388h implements C1458z {

        /* renamed from: com.adcolony.sdk.m0$h$a */
        class C1389a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4396a;

            C1389a(C1454x xVar) {
                this.f4396a = xVar;
            }

            public void run() {
                C1379m0.this.mo6708a(this.f4396a);
            }
        }

        C1388h() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1379m0.this.mo6715c(xVar)) {
                C1359k0.m5309a((Runnable) new C1389a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$i */
    class C1390i implements C1458z {

        /* renamed from: com.adcolony.sdk.m0$i$a */
        class C1391a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4399a;

            C1391a(C1454x xVar) {
                this.f4399a = xVar;
            }

            public void run() {
                C1379m0.this.mo6714b(C1437s.m5613h(this.f4399a.mo6830b(), "custom_js"));
            }
        }

        C1390i() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1379m0.this.mo6715c(xVar)) {
                C1359k0.m5309a((Runnable) new C1391a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$j */
    class C1392j implements C1458z {

        /* renamed from: com.adcolony.sdk.m0$j$a */
        class C1393a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4402a;

            C1393a(C1454x xVar) {
                this.f4402a = xVar;
            }

            public void run() {
                C1379m0.this.m5430b(C1437s.m5608d(this.f4402a.mo6830b(), TJAdUnitConstants.String.TRANSPARENT));
            }
        }

        C1392j() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1379m0.this.mo6715c(xVar)) {
                C1359k0.m5309a((Runnable) new C1393a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.m0$k */
    class C1394k implements View.OnClickListener {
        C1394k() {
        }

        public void onClick(View view) {
            C1359k0.m5307a(new Intent("android.intent.action.VIEW", Uri.parse(C1379m0.this.f4367i)));
            C1199a.m4880c().mo6556w().mo6587c(C1379m0.this.f4363e);
        }
    }

    /* renamed from: com.adcolony.sdk.m0$l */
    private class C1395l extends WebViewClient {
        private C1395l() {
        }

        public void onLoadResource(WebView webView, String str) {
            if (str.equals(C1379m0.this.f4359a)) {
                C1379m0.this.mo6714b("if (typeof(CN) != 'undefined' && CN.div) {\n  if (typeof(cn_dispatch_on_touch_begin) != 'undefined') CN.div.removeEventListener('mousedown',  cn_dispatch_on_touch_begin, true);\n  if (typeof(cn_dispatch_on_touch_end) != 'undefined')   CN.div.removeEventListener('mouseup',  cn_dispatch_on_touch_end, true);\n  if (typeof(cn_dispatch_on_touch_move) != 'undefined')  CN.div.removeEventListener('mousemove',  cn_dispatch_on_touch_move, true);\n}\n");
            }
        }

        public void onPageFinished(WebView webView, String str) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5602b(b, "id", C1379m0.this.f4369k);
            C1437s.m5592a(b, "url", str);
            if (C1379m0.this.f4355J == null) {
                new C1454x("WebView.on_load", C1379m0.this.f4378t, b).mo6834d();
            } else {
                C1437s.m5592a(b, "ad_session_id", C1379m0.this.f4363e);
                C1437s.m5602b(b, "container_id", C1379m0.this.f4355J.mo6410c());
                new C1454x("WebView.on_load", C1379m0.this.f4355J.mo6428k(), b).mo6834d();
            }
            if ((C1379m0.this.f4382x || C1379m0.this.f4383y) && !C1379m0.this.f4346A) {
                int h = C1379m0.this.f4379u > 0 ? C1379m0.this.f4379u : C1379m0.this.f4378t;
                if (C1379m0.this.f4379u > 0) {
                    float n = C1199a.m4880c().mo6542h().mo6630n();
                    C1437s.m5602b(C1379m0.this.f4353H, "app_orientation", C1359k0.m5331f(C1359k0.m5332g()));
                    C1437s.m5602b(C1379m0.this.f4353H, "x", C1359k0.m5297a((View) C1379m0.this));
                    C1437s.m5602b(C1379m0.this.f4353H, "y", C1359k0.m5314b((View) C1379m0.this));
                    C1437s.m5602b(C1379m0.this.f4353H, "width", (int) (((float) C1379m0.this.f4374p) / n));
                    C1437s.m5602b(C1379m0.this.f4353H, "height", (int) (((float) C1379m0.this.f4376r) / n));
                    C1437s.m5592a(C1379m0.this.f4353H, "ad_session_id", C1379m0.this.f4363e);
                }
                C1379m0 m0Var = C1379m0.this;
                m0Var.mo6714b("ADC3_init(" + h + "," + C1379m0.this.f4353H.toString() + ");");
                boolean unused = C1379m0.this.f4346A = true;
            }
            if (!C1379m0.this.f4383y) {
                return;
            }
            if (C1379m0.this.f4378t != 1 || C1379m0.this.f4379u > 0) {
                JSONObject b2 = C1437s.m5599b();
                C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, true);
                C1437s.m5602b(b2, "id", C1379m0.this.f4378t);
                C1379m0.this.f4356K.mo6829a(b2).mo6834d();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            boolean unused = C1379m0.this.f4346A = false;
            new C1439u.C1440a().mo6801a("onPageStarted with URL = ").mo6801a(str).mo6803a(C1439u.f4513f);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (Build.VERSION.SDK_INT < 23) {
                C1379m0.this.m5420a(i, str, str2);
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (!renderProcessGoneDetail.didCrash()) {
                return true;
            }
            C1379m0.this.m5425a(C1437s.m5599b(), "An error occurred while rendering the ad. Ad closing.");
            return true;
        }

        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (Build.VERSION.SDK_INT < 21 && str.endsWith("mraid.js")) {
                try {
                    return new WebResourceResponse("text/javascript", C4250c.DEFAULT_CHARSET, new ByteArrayInputStream(C1379m0.this.f4364f.getBytes(C4250c.DEFAULT_CHARSET)));
                } catch (UnsupportedEncodingException unused) {
                    new C1439u.C1440a().mo6801a("UTF-8 not supported.").mo6803a(C1439u.f4517j);
                }
            }
            return null;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!C1379m0.this.f4346A) {
                return false;
            }
            C1359k0.m5307a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            C1316i0 w = C1199a.m4880c().mo6556w();
            w.mo6584a(C1379m0.this.f4363e);
            w.mo6587c(C1379m0.this.f4363e);
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "url", str);
            C1437s.m5592a(b, "ad_session_id", C1379m0.this.f4363e);
            new C1454x("WebView.redirect_detected", C1379m0.this.f4355J.mo6428k(), b).mo6834d();
            return true;
        }

        /* synthetic */ C1395l(C1379m0 m0Var, C1382c cVar) {
            this();
        }
    }

    private C1379m0(Context context) {
        super(context);
    }

    /* renamed from: b */
    public void mo6388b() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AdColonyAdView adColonyAdView;
        if (motionEvent.getAction() == 1) {
            if (this.f4363e == null) {
                adColonyAdView = null;
            } else {
                adColonyAdView = C1199a.m4880c().mo6530b().mo6458b().get(this.f4363e);
            }
            if (adColonyAdView != null && !adColonyAdView.getUserInteraction()) {
                JSONObject b = C1437s.m5599b();
                C1437s.m5592a(b, "ad_session_id", this.f4363e);
                new C1454x("WebView.on_first_click", 1, b).mo6834d();
                adColonyAdView.setUserInteraction(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo6729r() {
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f4374p, this.f4376r);
        layoutParams.setMargins(this.f4370l, this.f4372n, 0, 0);
        layoutParams.gravity = 0;
        this.f4355J.addView(this, layoutParams);
        if (!this.f4366h.equals("") && !this.f4367i.equals("")) {
            m5437g();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean mo6730s() {
        return this.f4347B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public boolean mo6731t() {
        return this.f4384z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public boolean mo6732u() {
        return this.f4349D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo6733v() {
        if (this.f4357L != null) {
            int r = C1199a.m4880c().mo6542h().mo6634r();
            int q = C1199a.m4880c().mo6542h().mo6633q();
            if (this.f4351F) {
                r = this.f4370l + this.f4374p;
            }
            if (this.f4351F) {
                q = this.f4372n + this.f4376r;
            }
            float n = C1199a.m4880c().mo6542h().mo6630n();
            int i = (int) (((float) this.f4380v) * n);
            int i2 = (int) (((float) this.f4381w) * n);
            this.f4357L.setLayoutParams(new AbsoluteLayout.LayoutParams(i, i2, r - i, q - i2));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo6734w() {
        C1359k0.m5309a((Runnable) new C1380a());
    }

    /* renamed from: g */
    private void m5437g() {
        Context b = C1199a.m4878b();
        if (b != null && this.f4355J != null && !this.f4350E) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            ImageView imageView = new ImageView(b);
            this.f4357L = imageView;
            imageView.setImageURI(Uri.fromFile(new File(this.f4366h)));
            this.f4357L.setBackground(gradientDrawable);
            this.f4357L.setOnClickListener(new C1394k());
            mo6733v();
            addView(this.f4357L);
        }
    }

    /* renamed from: d */
    public int mo6390d() {
        return this.f4378t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6716e() {
        ImageView imageView = this.f4357L;
        if (imageView != null) {
            this.f4355J.mo6403a((View) imageView, FriendlyObstructionPurpose.OTHER);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6717f() {
        this.f4355J.mo6424i().add(C1199a.m4873a("WebView.set_visible", (C1458z) new C1386g(), true));
        this.f4355J.mo6424i().add(C1199a.m4873a("WebView.set_bounds", (C1458z) new C1388h(), true));
        this.f4355J.mo6424i().add(C1199a.m4873a("WebView.execute_js", (C1458z) new C1390i(), true));
        this.f4355J.mo6424i().add(C1199a.m4873a("WebView.set_transparent", (C1458z) new C1392j(), true));
        this.f4355J.mo6426j().add("WebView.set_visible");
        this.f4355J.mo6426j().add("WebView.set_bounds");
        this.f4355J.mo6426j().add("WebView.execute_js");
        this.f4355J.mo6426j().add("WebView.set_transparent");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6718h() {
        C1359k0.m5309a((Runnable) new C1381b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo6719i() {
        return this.f4376r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo6720j() {
        return this.f4374p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int mo6721k() {
        return this.f4370l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public int mo6722l() {
        return this.f4372n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo6723m() {
        return this.f4377s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public int mo6724n() {
        return this.f4375q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public int mo6725o() {
        return this.f4371m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public int mo6727p() {
        return this.f4373o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo6728q() {
        mo6712a(false, (C1454x) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6714b(String str) {
        if (this.f4347B) {
            new C1439u.C1440a().mo6801a("Ignoring call to execute_js as WebView has been destroyed.").mo6803a(C1439u.f4511d);
        } else if (Build.VERSION.SDK_INT >= 19) {
            try {
                evaluateJavascript(str, (ValueCallback) null);
            } catch (IllegalStateException unused) {
                new C1439u.C1440a().mo6801a("Device reporting incorrect OS version, evaluateJavascript ").mo6801a("is not available. Disabling AdColony.").mo6803a(C1439u.f4516i);
                AdColony.disable();
            }
        } else {
            loadUrl("javascript:" + str);
        }
    }

    /* renamed from: c */
    public int mo6389c() {
        return this.f4379u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6715c(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        return C1437s.m5611f(b, "id") == this.f4369k && C1437s.m5611f(b, "container_id") == this.f4355J.mo6410c() && C1437s.m5613h(b, "ad_session_id").equals(this.f4355J.mo6400a());
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"AddJavascriptInterface"})
    /* renamed from: a */
    public void mo6712a(boolean z, C1454x xVar) {
        WebViewClient webViewClient;
        String str;
        String str2;
        if (this.f4356K == null) {
            this.f4356K = xVar;
        }
        JSONObject b = this.f4356K.mo6830b();
        this.f4383y = z;
        this.f4384z = C1437s.m5608d(b, "is_display_module");
        if (z) {
            String h = C1437s.m5613h(b, "filepath");
            this.f4368j = C1437s.m5613h(b, "interstitial_html");
            this.f4365g = C1437s.m5613h(b, "mraid_filepath");
            this.f4362d = C1437s.m5613h(b, "base_url");
            this.f4360b = h;
            this.f4354I = C1437s.m5612g(b, "iab");
            if (f4345N && this.f4378t == 1) {
                this.f4360b = "android_asset/ADCController.js";
            }
            if (this.f4368j.equals("")) {
                str2 = "file:///" + this.f4360b;
            } else {
                str2 = "";
            }
            this.f4359a = str2;
            this.f4353H = C1437s.m5612g(b, TJAdUnitConstants.String.VIDEO_INFO);
            this.f4363e = C1437s.m5613h(b, "ad_session_id");
            this.f4382x = true;
        }
        setFocusable(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        setWebChromeClient(new C1382c(b));
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setGeolocationEnabled(true);
        settings.setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
            settings.setAllowFileAccess(true);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            webViewClient = new C1383d();
        } else if (i >= 21) {
            webViewClient = new C1384e();
        } else {
            webViewClient = new C1395l(this, (C1382c) null);
        }
        addJavascriptInterface(new C1385f(), "NativeLayer");
        setWebViewClient(webViewClient);
        if (this.f4384z) {
            try {
                if (this.f4368j.equals("")) {
                    FileInputStream fileInputStream = new FileInputStream(this.f4360b);
                    StringBuilder sb = new StringBuilder(fileInputStream.available());
                    byte[] bArr = new byte[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
                        if (read < 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    if (this.f4360b.contains(".html")) {
                        str = sb.toString();
                    } else {
                        str = "<html><script>" + sb.toString() + "</script></html>";
                    }
                } else {
                    str = this.f4368j.replaceFirst("script\\s*src\\s*=\\s*\"mraid.js\"", "script src=\"file://" + this.f4365g + "\"");
                }
                String h2 = C1437s.m5613h(C1437s.m5612g(b, TJAdUnitConstants.String.VIDEO_INFO), "metadata");
                loadDataWithBaseURL(this.f4359a.equals("") ? this.f4362d : this.f4359a, m5418a(str, C1437s.m5613h(C1437s.m5600b(h2), "iab_filepath")).replaceFirst("var\\s*ADC_DEVICE_INFO\\s*=\\s*null\\s*;", Matcher.quoteReplacement("var ADC_DEVICE_INFO = " + h2 + ";")), "text/html", (String) null, (String) null);
            } catch (IOException e) {
                m5427a((Exception) e);
                return;
            } catch (IllegalArgumentException e2) {
                m5427a((Exception) e2);
                return;
            } catch (IndexOutOfBoundsException e3) {
                m5427a((Exception) e3);
                return;
            }
        } else if (!this.f4359a.startsWith("http") && !this.f4359a.startsWith("file")) {
            loadDataWithBaseURL(this.f4362d, this.f4359a, "text/html", (String) null, (String) null);
        } else if (this.f4359a.contains(".html") || !this.f4359a.startsWith("file")) {
            loadUrl(this.f4359a);
        } else {
            loadDataWithBaseURL(this.f4359a, "<html><script src=\"" + this.f4359a + "\"></script></html>", "text/html", (String) null, (String) null);
        }
        if (!z) {
            mo6717f();
            mo6729r();
        }
        if (z || this.f4382x) {
            C1199a.m4880c().mo6548n().mo6836a((C1201a0) this);
        }
        if (!this.f4361c.equals("")) {
            mo6714b(this.f4361c);
        }
    }

    C1379m0(Context context, C1454x xVar, int i, int i2, C1205c cVar) {
        super(context);
        this.f4356K = xVar;
        mo6709a(xVar, i, i2, cVar);
        mo6728q();
    }

    /* renamed from: b */
    private void m5429b(Exception exc) {
        new C1439u.C1440a().mo6801a(exc.getClass().toString()).mo6801a(" during metadata injection w/ metadata = ").mo6801a(C1437s.m5613h(this.f4353H, "metadata")).mo6803a(C1439u.f4517j);
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "id", this.f4363e);
        new C1454x("AdSession.on_error", this.f4355J.mo6428k(), b).mo6834d();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5430b(boolean z) {
        setBackgroundColor(z ? 0 : -1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6713b(C1454x xVar) {
        if (C1437s.m5608d(xVar.mo6830b(), TJAdUnitConstants.String.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
        if (this.f4383y) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            C1437s.m5602b(b, "id", this.f4378t);
            xVar.mo6829a(b).mo6834d();
        }
    }

    C1379m0(Context context, int i, boolean z) {
        super(context);
        this.f4378t = i;
        this.f4384z = z;
    }

    /* renamed from: a */
    private String m5418a(String str, String str2) {
        C1218c0 c0Var;
        C1222d b = C1199a.m4880c().mo6530b();
        AdColonyInterstitial adColonyInterstitial = b.mo6453a().get(this.f4363e);
        AdColonyAdViewListener adColonyAdViewListener = b.mo6459c().get(this.f4363e);
        if (adColonyInterstitial != null && this.f4354I.length() > 0 && !C1437s.m5613h(this.f4354I, "ad_type").equals("video")) {
            adColonyInterstitial.mo6321a(this.f4354I);
        } else if (adColonyAdViewListener != null && this.f4354I.length() > 0) {
            adColonyAdViewListener.mo6262a(new C1218c0(this.f4354I, this.f4363e));
        }
        if (adColonyInterstitial == null) {
            c0Var = null;
        } else {
            c0Var = adColonyInterstitial.mo6331e();
        }
        if (c0Var == null && adColonyAdViewListener != null) {
            c0Var = adColonyAdViewListener.mo6264b();
        }
        if (c0Var != null && c0Var.mo6449d() == 2) {
            this.f4349D = true;
            if (!str2.equals("")) {
                try {
                    return ScriptInjector.injectScriptContentIntoHtml(C1199a.m4880c().mo6545k().mo6777a(str2, false).toString(), str);
                } catch (IOException e) {
                    m5427a((Exception) e);
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5424a(String str) {
        JSONArray a = C1437s.m5580a(str);
        for (int i = 0; i < a.length(); i++) {
            C1199a.m4880c().mo6548n().mo6840a(C1437s.m5606c(a, i));
        }
    }

    /* renamed from: a */
    private boolean m5427a(Exception exc) {
        AdColonyInterstitialListener listener;
        new C1439u.C1440a().mo6801a(exc.getClass().toString()).mo6801a(" during metadata injection w/ metadata = ").mo6801a(C1437s.m5613h(this.f4353H, "metadata")).mo6803a(C1439u.f4517j);
        AdColonyInterstitial remove = C1199a.m4880c().mo6530b().mo6453a().remove(C1437s.m5613h(this.f4353H, "ad_session_id"));
        if (remove == null || (listener = remove.getListener()) == null) {
            return false;
        }
        listener.onExpiring(remove);
        remove.mo6322a(true);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6710a(C1454x xVar, int i, C1205c cVar) {
        mo6709a(xVar, i, -1, cVar);
        mo6729r();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6709a(C1454x xVar, int i, int i2, C1205c cVar) {
        JSONObject b = xVar.mo6830b();
        String h = C1437s.m5613h(b, "url");
        this.f4359a = h;
        if (h.equals("")) {
            this.f4359a = C1437s.m5613h(b, "data");
        }
        this.f4362d = C1437s.m5613h(b, "base_url");
        this.f4361c = C1437s.m5613h(b, "custom_js");
        this.f4363e = C1437s.m5613h(b, "ad_session_id");
        this.f4353H = C1437s.m5612g(b, TJAdUnitConstants.String.VIDEO_INFO);
        this.f4365g = C1437s.m5613h(b, "mraid_filepath");
        this.f4379u = C1437s.m5608d(b, "use_mraid_module") ? C1199a.m4880c().mo6548n().mo6844d() : this.f4379u;
        this.f4366h = C1437s.m5613h(b, "ad_choices_filepath");
        this.f4367i = C1437s.m5613h(b, "ad_choices_url");
        this.f4350E = C1437s.m5608d(b, "disable_ad_choices");
        this.f4351F = C1437s.m5608d(b, "ad_choices_snap_to_webview");
        this.f4380v = C1437s.m5611f(b, "ad_choices_width");
        this.f4381w = C1437s.m5611f(b, "ad_choices_height");
        if (this.f4354I.length() == 0) {
            this.f4354I = C1437s.m5612g(b, "iab");
        }
        boolean z = false;
        if (!this.f4384z && !this.f4365g.equals("")) {
            if (this.f4379u > 0) {
                this.f4359a = m5418a(this.f4359a.replaceFirst("script\\s*src\\s*=\\s*\"mraid.js\"", "script src=\"file://" + this.f4365g + "\""), C1437s.m5613h(C1437s.m5612g(this.f4353H, DeviceRequestsHelper.DEVICE_INFO_PARAM), "iab_filepath"));
            } else {
                try {
                    this.f4364f = C1199a.m4880c().mo6545k().mo6777a(this.f4365g, false).toString();
                    this.f4364f = this.f4364f.replaceFirst("bridge.os_name\\s*=\\s*\"\"\\s*;", "bridge.os_name = \"\";\nvar ADC_DEVICE_INFO = " + this.f4353H.toString() + ";\n");
                } catch (IOException e) {
                    m5429b((Exception) e);
                } catch (IllegalArgumentException e2) {
                    m5429b((Exception) e2);
                } catch (IndexOutOfBoundsException e3) {
                    m5429b((Exception) e3);
                }
            }
        }
        this.f4369k = i;
        this.f4355J = cVar;
        if (i2 >= 0) {
            this.f4378t = i2;
        } else {
            mo6717f();
        }
        this.f4374p = C1437s.m5611f(b, "width");
        this.f4376r = C1437s.m5611f(b, "height");
        this.f4370l = C1437s.m5611f(b, "x");
        int f = C1437s.m5611f(b, "y");
        this.f4372n = f;
        this.f4375q = this.f4374p;
        this.f4377s = this.f4376r;
        this.f4373o = f;
        this.f4371m = this.f4370l;
        if (C1437s.m5608d(b, "enable_messages") || this.f4383y) {
            z = true;
        }
        this.f4382x = z;
        mo6718h();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6708a(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        this.f4370l = C1437s.m5611f(b, "x");
        this.f4372n = C1437s.m5611f(b, "y");
        this.f4374p = C1437s.m5611f(b, "width");
        this.f4376r = C1437s.m5611f(b, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f4370l, this.f4372n, 0, 0);
        layoutParams.width = this.f4374p;
        layoutParams.height = this.f4376r;
        setLayoutParams(layoutParams);
        if (this.f4383y) {
            JSONObject b2 = C1437s.m5599b();
            C1437s.m5603b(b2, GraphResponse.SUCCESS_KEY, true);
            C1437s.m5602b(b2, "id", this.f4378t);
            xVar.mo6829a(b2).mo6834d();
        }
        mo6733v();
    }

    /* renamed from: a */
    public void mo6387a(JSONObject jSONObject) {
        synchronized (this.f4358M) {
            this.f4352G.put(jSONObject);
        }
    }

    /* renamed from: a */
    public void mo6386a() {
        if (C1199a.m4881d() && this.f4346A && !this.f4348C) {
            mo6734w();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5425a(JSONObject jSONObject, String str) {
        Context b = C1199a.m4878b();
        if (b != null && (b instanceof C1202b)) {
            C1454x xVar = new C1454x("AdSession.finish_fullscreen_ad", 0);
            C1437s.m5602b(jSONObject, "status", 1);
            new C1439u.C1440a().mo6801a(str).mo6803a(C1439u.f4516i);
            ((C1202b) b).mo6341a(xVar);
        } else if (this.f4378t == 1) {
            new C1439u.C1440a().mo6801a("Unable to communicate with controller, disabling AdColony.").mo6803a(C1439u.f4516i);
            AdColony.disable();
        } else if (this.f4379u > 0) {
            this.f4382x = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5420a(int i, String str, String str2) {
        if (this.f4355J != null) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5602b(b, "id", this.f4369k);
            C1437s.m5592a(b, "ad_session_id", this.f4363e);
            C1437s.m5602b(b, "container_id", this.f4355J.mo6410c());
            C1437s.m5602b(b, "code", i);
            C1437s.m5592a(b, "error", str);
            C1437s.m5592a(b, "url", str2);
            new C1454x("WebView.on_error", this.f4355J.mo6428k(), b).mo6834d();
        }
        new C1439u.C1440a().mo6801a("onReceivedError: ").mo6801a(str).mo6803a(C1439u.f4517j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6711a(boolean z) {
        this.f4347B = z;
    }
}
