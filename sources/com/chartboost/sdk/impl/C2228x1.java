package com.chartboost.sdk.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C2102d;
import com.chartboost.sdk.C2107e;
import com.chartboost.sdk.C2109f;
import com.chartboost.sdk.C2116i;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.C2078f;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.x1 */
public class C2228x1 extends C2109f {

    /* renamed from: A */
    int f7501A = 0;

    /* renamed from: B */
    private int f7502B = 0;

    /* renamed from: C */
    private int f7503C = 0;

    /* renamed from: D */
    private int f7504D = 0;

    /* renamed from: E */
    int f7505E = 0;

    /* renamed from: F */
    int f7506F = 0;

    /* renamed from: G */
    int f7507G = 0;

    /* renamed from: H */
    int f7508H = 0;

    /* renamed from: I */
    int f7509I = 0;

    /* renamed from: J */
    int f7510J = 0;

    /* renamed from: K */
    int f7511K = 0;

    /* renamed from: L */
    int f7512L = 0;

    /* renamed from: M */
    int f7513M = -1;

    /* renamed from: N */
    private boolean f7514N = true;

    /* renamed from: O */
    private int f7515O = -1;

    /* renamed from: P */
    private int f7516P = 0;

    /* renamed from: l */
    private final C2078f f7517l;

    /* renamed from: m */
    private final C2218v0 f7518m;

    /* renamed from: n */
    private final C2098a f7519n;

    /* renamed from: o */
    final C2107e f7520o;

    /* renamed from: p */
    String f7521p = "UNKNOWN";

    /* renamed from: q */
    private String f7522q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public String f7523r = null;

    /* renamed from: s */
    private int f7524s = 1;

    /* renamed from: t */
    private float f7525t = 0.0f;

    /* renamed from: u */
    private float f7526u = 0.0f;

    /* renamed from: v */
    private boolean f7527v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public long f7528w = 0;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public long f7529x = 0;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f7530y = false;

    /* renamed from: z */
    int f7531z = 0;

    /* renamed from: com.chartboost.sdk.impl.x1$a */
    class C2229a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C2232d f7532a;

        C2229a(C2232d dVar) {
            this.f7532a = dVar;
        }

        public void run() {
            if (this.f7532a.f7537h != null) {
                C2228x1.this.mo9565b("onForeground");
                this.f7532a.f7537h.onResume();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.x1$b */
    class C2230b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C2232d f7534a;

        C2230b(C2232d dVar) {
            this.f7534a = dVar;
        }

        public void run() {
            if (this.f7534a.f7537h != null) {
                C2228x1.this.mo9565b("onBackground");
                this.f7534a.f7537h.onPause();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.x1$c */
    private class C2231c extends WebViewClient {
        private C2231c() {
        }

        /* renamed from: a */
        private void m8864a(String str) {
            CBLogging.m8154b("CBWebViewProtocol", str);
            C2228x1.this.mo9236a(CBError.CBImpressionError.WEB_VIEW_CLIENT_RECEIVED_ERROR);
            boolean unused = C2228x1.this.f7530y = true;
            C2228x1 x1Var = C2228x1.this;
            x1Var.f7520o.mo9229d(x1Var.f7073g);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            boolean unused = C2228x1.this.f7530y = true;
            long unused2 = C2228x1.this.f7529x = System.currentTimeMillis();
            CBLogging.m8152a("CBWebViewProtocol", "Total web view load response time " + ((C2228x1.this.f7529x - C2228x1.this.f7528w) / 1000));
            Context context = webView.getContext();
            if (context != null) {
                C2228x1.this.mo9570d(context);
                C2228x1.this.mo9566c(context);
                C2228x1.this.mo9575p();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (Build.VERSION.SDK_INT >= 26) {
                PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
                if (currentWebViewPackage != null) {
                    CBLogging.m8152a("CBWebViewProtocol", "WebView version: " + currentWebViewPackage.versionName);
                    return;
                }
                m8864a(C2169j1.m8622e(C2242k.f7612l).equalsIgnoreCase("watch") ? "No webview support." : "Device was not set up correctly.");
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            m8864a("Error loading " + str2 + ": " + str);
        }

        @TargetApi(23)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error loading ");
            sb.append(webResourceRequest.getUrl().toString());
            sb.append(": ");
            sb.append(webResourceResponse == null ? "unknown error" : webResourceResponse.getReasonPhrase());
            CBLogging.m8152a("CBWebViewProtocol", sb.toString());
        }

        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String str;
            if (renderProcessGoneDetail.didCrash()) {
                str = "Webview crashed: " + renderProcessGoneDetail.toString();
            } else {
                str = "Webview killed, likely due to low memory";
            }
            m8864a(str);
            return true;
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return false;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }

        /* synthetic */ C2231c(C2228x1 x1Var, C2229a aVar) {
            this();
        }

        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceRequest.isForMainFrame()) {
                m8864a("Error loading " + webResourceRequest.getUrl().toString() + ": " + webResourceError.getDescription());
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.x1$d */
    public class C2232d extends C2109f.C2111b {

        /* renamed from: h */
        public C2223w1 f7537h;

        /* renamed from: i */
        public C2219v1 f7538i;

        /* renamed from: j */
        public RelativeLayout f7539j;

        /* renamed from: k */
        public RelativeLayout f7540k;

        public C2232d(Context context, String str) {
            super(context);
            setFocusable(false);
            C2116i a = C2116i.m8407a();
            this.f7539j = (RelativeLayout) a.mo9266a(new RelativeLayout(context));
            this.f7540k = (RelativeLayout) a.mo9266a(new RelativeLayout(context));
            this.f7537h = (C2223w1) a.mo9266a(new C2223w1(context));
            C2239j.m8895b(context);
            this.f7537h.setWebViewClient((WebViewClient) a.mo9266a(new C2231c(C2228x1.this, (C2229a) null)));
            C2219v1 v1Var = (C2219v1) a.mo9266a(new C2219v1(this.f7539j, this.f7540k, (View) null, this.f7537h, C2228x1.this, C2228x1.this.f7067a));
            this.f7538i = v1Var;
            this.f7537h.setWebChromeClient(v1Var);
            if (C2224x.m8805e().mo9548a(19)) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            this.f7537h.loadDataWithBaseURL(C2228x1.this.f7523r, str, "text/html", "utf-8", (String) null);
            this.f7539j.addView(this.f7537h);
            this.f7537h.getSettings().setSupportZoom(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.f7539j.setLayoutParams(layoutParams);
            this.f7537h.setLayoutParams(layoutParams);
            this.f7537h.setBackgroundColor(0);
            this.f7540k.setVisibility(8);
            this.f7540k.setLayoutParams(layoutParams);
            addView(this.f7539j);
            addView(this.f7540k);
            long unused = C2228x1.this.f7528w = System.currentTimeMillis();
            if (context instanceof Activity) {
                C2228x1.this.f7513M = ((Activity) context).getRequestedOrientation();
            } else {
                C2228x1.this.f7513M = -1;
            }
            C2228x1.this.f7067a.postDelayed(new C2142f2(this), 15000);
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m8866c() {
            if (!C2228x1.this.f7530y) {
                CBLogging.m8152a("CBWebViewProtocol", "Webview seems to be taking more time loading the html content, so closing the view.");
                C2228x1.this.mo9236a(CBError.CBImpressionError.WEB_VIEW_PAGE_LOAD_TIMEOUT);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9257a(int i, int i2) {
        }
    }

    public C2228x1(C2088c cVar, C2078f fVar, C2218v0 v0Var, SharedPreferences sharedPreferences, C2098a aVar, Handler handler, C2102d dVar, C2107e eVar) {
        super(cVar, handler, dVar);
        this.f7517l = fVar;
        this.f7518m = v0Var;
        this.f7519n = aVar;
        this.f7520o = eVar;
    }

    /* renamed from: a */
    public String mo9561a(int i) {
        return i != -1 ? i != 0 ? i != 1 ? "error" : TJAdUnitConstants.String.PORTRAIT : TJAdUnitConstants.String.LANDSCAPE : "none";
    }

    /* renamed from: e */
    public void mo9571e(String str) {
        C2098a aVar = this.f7519n;
        C2088c cVar = this.f7073g;
        String a = cVar.f6923c.mo9267a(cVar.f6938r.f6896b);
        C2088c cVar2 = this.f7073g;
        aVar.mo9172b(a, cVar2.f6934n, cVar2.mo9126c(), str);
    }

    /* renamed from: f */
    public void mo9572f(String str) {
        List<String> list;
        if (this.f7073g.f6938r.f6908n != null && !TextUtils.isEmpty(str) && (list = this.f7073g.f6938r.f6908n.get(str)) != null) {
            for (String str2 : list) {
                if (!str2.isEmpty()) {
                    this.f7518m.mo9524a(new C2203r0("GET", str2, 2, (File) null));
                    CBLogging.m8152a("CBWebViewProtocol", "###### Sending VAST Tracking Event: " + str2);
                }
            }
        }
    }

    /* renamed from: g */
    public void mo9573g(String str) {
        if (C2224x.m8805e().mo9549a((CharSequence) str)) {
            str = "Unknown Webview warning message";
        }
        C2098a aVar = this.f7519n;
        C2088c cVar = this.f7073g;
        String a = cVar.f6923c.mo9267a(cVar.f6938r.f6896b);
        C2088c cVar2 = this.f7073g;
        aVar.mo9163a(a, cVar2.f6934n, cVar2.mo9126c(), str);
        CBLogging.m8159e("CBWebViewProtocol", "Webview warning occurred closing the webview" + str);
    }

    /* renamed from: h */
    public float mo9248h() {
        return this.f7526u;
    }

    /* renamed from: j */
    public boolean mo9250j() {
        if (this.f7516P == 2 && this.f7073g.f6923c.f7101a == 1) {
            return true;
        }
        mo9241b();
        mo9234a();
        return true;
    }

    /* renamed from: k */
    public void mo9251k() {
        super.mo9251k();
        C2232d i = mo9249i();
        if (i != null && i.f7537h != null) {
            this.f7067a.post(new C2230b(i));
            this.f7519n.mo9173c(this.f7521p, this.f7073g.mo9126c());
        }
    }

    /* renamed from: l */
    public void mo9252l() {
        super.mo9252l();
        C2232d i = mo9249i();
        if (i != null && i.f7537h != null) {
            this.f7067a.post(new C2229a(i));
            this.f7519n.mo9177e(this.f7521p, this.f7073g.mo9126c());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r0.getResources().getConfiguration().orientation == 1) goto L_0x002c;
     */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9574o() {
        /*
            r3 = this;
            com.chartboost.sdk.d r0 = r3.f7068b
            android.app.Activity r0 = r0.mo9198d()
            if (r0 == 0) goto L_0x002f
            boolean r1 = com.chartboost.sdk.Libraries.CBUtility.m8167a((android.app.Activity) r0)
            if (r1 == 0) goto L_0x000f
            goto L_0x002f
        L_0x000f:
            int r1 = r3.f7515O
            r2 = 1
            if (r1 != r2) goto L_0x0015
            goto L_0x002c
        L_0x0015:
            if (r1 != 0) goto L_0x0018
            goto L_0x002b
        L_0x0018:
            boolean r1 = r3.f7514N
            if (r1 == 0) goto L_0x001e
            r2 = -1
            goto L_0x002c
        L_0x001e:
            android.content.res.Resources r1 = r0.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            if (r1 != r2) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            r0.setRequestedOrientation(r2)
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2228x1.mo9574o():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo9575p() {
        C2232d i = mo9249i();
        if (i == null || !this.f7530y) {
            this.f7509I = this.f7505E;
            this.f7510J = this.f7506F;
            this.f7511K = this.f7507G;
            this.f7512L = this.f7508H;
            return;
        }
        int[] iArr = new int[2];
        i.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1] - this.f7504D;
        int width = i.getWidth();
        int height = i.getHeight();
        this.f7505E = i2;
        this.f7506F = i3;
        int i4 = width + i2;
        this.f7507G = i4;
        int i5 = height + i3;
        this.f7508H = i5;
        this.f7509I = i2;
        this.f7510J = i3;
        this.f7511K = i4;
        this.f7512L = i5;
    }

    /* renamed from: q */
    public String mo9576q() {
        mo9575p();
        return C2076e.m8186a(C2076e.m8184a("x", (Object) Integer.valueOf(this.f7509I)), C2076e.m8184a("y", (Object) Integer.valueOf(this.f7510J)), C2076e.m8184a("width", (Object) Integer.valueOf(this.f7511K)), C2076e.m8184a("height", (Object) Integer.valueOf(this.f7512L))).toString();
    }

    /* renamed from: r */
    public String mo9577r() {
        mo9575p();
        return C2076e.m8186a(C2076e.m8184a("x", (Object) Integer.valueOf(this.f7505E)), C2076e.m8184a("y", (Object) Integer.valueOf(this.f7506F)), C2076e.m8184a("width", (Object) Integer.valueOf(this.f7507G)), C2076e.m8184a("height", (Object) Integer.valueOf(this.f7508H))).toString();
    }

    /* renamed from: s */
    public String mo9578s() {
        return C2076e.m8186a(C2076e.m8184a("width", (Object) Integer.valueOf(this.f7502B)), C2076e.m8184a("height", (Object) Integer.valueOf(this.f7503C))).toString();
    }

    /* renamed from: t */
    public String mo9579t() {
        return C2076e.m8186a(C2076e.m8184a("allowOrientationChange", (Object) Boolean.valueOf(this.f7514N)), C2076e.m8184a("forceOrientation", (Object) mo9561a(this.f7515O))).toString();
    }

    /* renamed from: u */
    public String mo9580u() {
        return C2076e.m8186a(C2076e.m8184a("width", (Object) Integer.valueOf(this.f7531z)), C2076e.m8184a("height", (Object) Integer.valueOf(this.f7501A))).toString();
    }

    /* renamed from: v */
    public void mo9581v() {
        C2088c cVar = this.f7073g;
        if (cVar.f6922b == 2 && !this.f7527v) {
            this.f7519n.mo9177e("", cVar.mo9126c());
            this.f7073g.mo9145v();
            this.f7527v = true;
        }
        m8822a(this.f7073g);
    }

    /* renamed from: w */
    public void mo9582w() {
        if (this.f7524s <= 1) {
            this.f7073g.mo9138o();
            this.f7524s++;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo9583x() {
        Activity d = this.f7068b.mo9198d();
        if (d != null && !CBUtility.m8167a(d)) {
            int requestedOrientation = d.getRequestedOrientation();
            int i = this.f7513M;
            if (requestedOrientation != i) {
                d.setRequestedOrientation(i);
            }
            this.f7514N = true;
            this.f7515O = -1;
        }
    }

    /* renamed from: y */
    public void mo9584y() {
        this.f7519n.mo9175d(this.f7521p, this.f7073g.mo9126c());
    }

    /* renamed from: c */
    public void mo9567c(String str) {
        if (C2224x.m8805e().mo9549a((CharSequence) str)) {
            str = "Unknown Webview error";
        }
        C2098a aVar = this.f7519n;
        C2088c cVar = this.f7073g;
        String a = cVar.f6923c.mo9267a(cVar.f6938r.f6896b);
        C2088c cVar2 = this.f7073g;
        aVar.mo9167a(a, cVar2.f6934n, cVar2.mo9126c(), str, true);
        CBLogging.m8154b("CBWebViewProtocol", "Webview error occurred closing the webview" + str);
        mo9236a(CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
        mo9234a();
    }

    /* renamed from: d */
    public int mo9569d(String str) {
        if (str.equals(TJAdUnitConstants.String.PORTRAIT)) {
            return 1;
        }
        return str.equals(TJAdUnitConstants.String.LANDSCAPE) ? 0 : -1;
    }

    /* renamed from: i */
    public C2232d m8849i() {
        return (C2232d) super.mo9249i();
    }

    /* renamed from: b */
    public boolean mo9242b(JSONObject jSONObject) {
        File file = this.f7517l.mo9089a().f6867a;
        if (file == null) {
            CBLogging.m8154b("CBWebViewProtocol", "External Storage path is unavailable or media not mounted");
            mo9236a(CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
            return false;
        }
        this.f7523r = "file://" + file.getAbsolutePath() + "/";
        if (C2224x.m8805e().mo9549a((CharSequence) this.f7073g.f6938r.f6899e)) {
            CBLogging.m8154b("CBWebViewProtocol", "Invalid adId being passed in the response");
            mo9236a(CBError.CBImpressionError.ERROR_DISPLAYING_VIEW);
            return false;
        }
        String str = this.f7073g.f6937q;
        if (str == null) {
            CBLogging.m8154b("CBWebViewProtocol", "No html data found in memory");
            mo9236a(CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
            return false;
        }
        this.f7522q = str;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2109f.C2111b mo9233a(Context context) {
        return new C2232d(context, this.f7522q);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo9570d(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f7531z = displayMetrics.widthPixels;
        this.f7501A = displayMetrics.heightPixels;
    }

    /* renamed from: g */
    public float mo9247g() {
        return this.f7525t;
    }

    /* renamed from: a */
    public void mo9234a() {
        super.mo9234a();
        mo9583x();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo9560a(Window window) {
        return window.findViewById(16908290).getTop();
    }

    /* renamed from: c */
    public void mo9568c(JSONObject jSONObject) {
        this.f7514N = jSONObject.optBoolean("allowOrientationChange", this.f7514N);
        this.f7515O = mo9569d(jSONObject.optString("forceOrientation", mo9561a(this.f7515O)));
        mo9574o();
    }

    /* renamed from: a */
    public void mo9562a(float f) {
        this.f7526u = f;
    }

    /* renamed from: a */
    private void m8822a(C2088c cVar) {
        if (cVar != null && cVar.f6923c.f7101a == 3) {
            C2102d dVar = this.f7068b;
            dVar.getClass();
            C2102d.C2106d dVar2 = new C2102d.C2106d(14);
            dVar2.f7056c = cVar;
            this.f7067a.post(dVar2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9566c(Context context) {
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            this.f7504D = mo9560a(window);
            if (this.f7531z == 0 || this.f7501A == 0) {
                mo9570d(context);
            }
            int width = rect.width();
            int i = this.f7501A - this.f7504D;
            if (width != this.f7502B || i != this.f7503C) {
                this.f7502B = width;
                this.f7503C = i;
            }
        }
    }

    /* renamed from: b */
    public void mo9241b() {
        C2232d i = mo9249i();
        if (i != null) {
            if (i.f7537h != null) {
                CBLogging.m8152a("CBWebViewProtocol", "Destroying the webview object and cleaning up the references");
                i.f7537h.destroy();
                i.f7537h = null;
            }
            if (i.f7538i != null) {
                i.f7538i = null;
            }
            if (i.f7539j != null) {
                i.f7539j = null;
            }
            if (i.f7540k != null) {
                i.f7540k = null;
            }
        }
        super.mo9241b();
    }

    /* renamed from: b */
    public void mo9564b(int i) {
        this.f7516P = i;
    }

    /* renamed from: b */
    public void mo9563b(float f) {
        this.f7525t = f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9565b(String str) {
        try {
            C2232d i = mo9249i();
            if (i != null) {
                C2223w1 w1Var = i.f7537h;
                if (w1Var != null) {
                    String str2 = "javascript:Chartboost.EventHandler.handleNativeEvent(\"" + str + "\", \"\")";
                    CBLogging.m8152a("CBWebViewProtocol", "Calling native to javascript: " + str2);
                    w1Var.loadUrl(str2);
                    return;
                }
                CBLogging.m8156c("CBWebViewProtocol", "Calling native to javascript webview is null");
            }
        } catch (Exception e) {
            CBLogging.m8156c("CBWebViewProtocol", "Calling native to javascript. Cannot open url: " + e.toString());
        }
    }
}
