package com.onesignal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.loopj.android.http.C4250c;
import com.onesignal.C4461a;
import com.onesignal.C4564n1;
import com.onesignal.C4657u;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(19)
/* renamed from: com.onesignal.w2 */
/* compiled from: WebViewManager */
class C4701w2 extends C4461a.C4463b {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f12770f = "com.onesignal.w2";

    /* renamed from: g */
    private static final int f12771g = C4543l1.m15662a(24);

    /* renamed from: h */
    protected static C4701w2 f12772h = null;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C4560m1 f12773a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C4657u f12774b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Activity f12775c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C4535k0 f12776d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f12777e = true;

    /* renamed from: com.onesignal.w2$a */
    /* compiled from: WebViewManager */
    static class C4702a implements C4712j {

        /* renamed from: a */
        final /* synthetic */ Activity f12778a;

        /* renamed from: b */
        final /* synthetic */ C4535k0 f12779b;

        /* renamed from: c */
        final /* synthetic */ String f12780c;

        C4702a(Activity activity, C4535k0 k0Var, String str) {
            this.f12778a = activity;
            this.f12779b = k0Var;
            this.f12780c = str;
        }

        public void onComplete() {
            C4701w2.f12772h = null;
            C4701w2.m16381b(this.f12778a, this.f12779b, this.f12780c);
        }
    }

    /* renamed from: com.onesignal.w2$b */
    /* compiled from: WebViewManager */
    static class C4703b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4535k0 f12781a;

        /* renamed from: b */
        final /* synthetic */ String f12782b;

        C4703b(C4535k0 k0Var, String str) {
            this.f12781a = k0Var;
            this.f12782b = str;
        }

        public void run() {
            C4701w2.m16369a(this.f12781a, this.f12782b);
        }
    }

    /* renamed from: com.onesignal.w2$c */
    /* compiled from: WebViewManager */
    static class C4704c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4701w2 f12783a;

        /* renamed from: b */
        final /* synthetic */ Activity f12784b;

        /* renamed from: c */
        final /* synthetic */ String f12785c;

        C4704c(C4701w2 w2Var, Activity activity, String str) {
            this.f12783a = w2Var;
            this.f12784b = activity;
            this.f12785c = str;
        }

        public void run() {
            this.f12783a.m16367a(this.f12784b, this.f12785c);
        }
    }

    /* renamed from: com.onesignal.w2$d */
    /* compiled from: WebViewManager */
    class C4705d implements Runnable {

        /* renamed from: com.onesignal.w2$d$a */
        /* compiled from: WebViewManager */
        class C4706a implements ValueCallback<String> {
            C4706a() {
            }

            /* renamed from: a */
            public void onReceiveValue(String str) {
                try {
                    C4701w2.this.m16375a(Integer.valueOf(C4701w2.m16378b(C4701w2.this.f12775c, new JSONObject(str))));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        C4705d() {
        }

        public void run() {
            C4701w2 w2Var = C4701w2.this;
            w2Var.m16387d(w2Var.f12775c);
            C4701w2.this.f12773a.evaluateJavascript("getPageMetaData()", new C4706a());
        }
    }

    /* renamed from: com.onesignal.w2$e */
    /* compiled from: WebViewManager */
    class C4707e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Activity f12788a;

        /* renamed from: b */
        final /* synthetic */ String f12789b;

        C4707e(Activity activity, String str) {
            this.f12788a = activity;
            this.f12789b = str;
        }

        public void run() {
            C4701w2.this.m16387d(this.f12788a);
            C4701w2.this.f12773a.loadData(this.f12789b, "text/html; charset=utf-8", "base64");
        }
    }

    /* renamed from: com.onesignal.w2$f */
    /* compiled from: WebViewManager */
    class C4708f implements C4657u.C4666i {
        C4708f() {
        }

        /* renamed from: a */
        public void mo29984a() {
            C4548m0.m15715h().mo29831a(C4701w2.this.f12776d);
            C4461a.m15375a(C4701w2.f12770f + C4701w2.this.f12776d.f12392a);
        }

        /* renamed from: b */
        public void mo29985b() {
            boolean unused = C4701w2.this.f12777e = false;
            C4548m0.m15715h().mo29836b(C4701w2.this.f12776d);
        }
    }

    /* renamed from: com.onesignal.w2$g */
    /* compiled from: WebViewManager */
    class C4709g implements C4712j {

        /* renamed from: a */
        final /* synthetic */ C4712j f12792a;

        C4709g(C4712j jVar) {
            this.f12792a = jVar;
        }

        public void onComplete() {
            C4657u unused = C4701w2.this.f12774b = null;
            C4712j jVar = this.f12792a;
            if (jVar != null) {
                jVar.onComplete();
            }
        }
    }

    /* renamed from: com.onesignal.w2$h */
    /* compiled from: WebViewManager */
    static /* synthetic */ class C4710h {

        /* renamed from: a */
        static final /* synthetic */ int[] f12794a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.onesignal.w2$k[] r0 = com.onesignal.C4701w2.C4713k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12794a = r0
                com.onesignal.w2$k r1 = com.onesignal.C4701w2.C4713k.TOP_BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12794a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.w2$k r1 = com.onesignal.C4701w2.C4713k.BOTTOM_BANNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4701w2.C4710h.<clinit>():void");
        }
    }

    /* renamed from: com.onesignal.w2$i */
    /* compiled from: WebViewManager */
    class C4711i {
        C4711i() {
        }

        /* renamed from: a */
        private C4713k m16394a(JSONObject jSONObject) {
            C4713k kVar = C4713k.FULL_SCREEN;
            try {
                if (!jSONObject.has("displayLocation") || jSONObject.get("displayLocation").equals("")) {
                    return kVar;
                }
                return C4713k.m16398a(jSONObject.optString("displayLocation", "FULL_SCREEN").toUpperCase());
            } catch (JSONException e) {
                e.printStackTrace();
                return kVar;
            }
        }

        /* renamed from: b */
        private int m16395b(JSONObject jSONObject) {
            try {
                return C4701w2.m16378b(C4701w2.this.f12775c, jSONObject.getJSONObject("pageMetaData"));
            } catch (JSONException unused) {
                return -1;
            }
        }

        /* renamed from: c */
        private void m16396c(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = jSONObject.getJSONObject("body");
            String optString = jSONObject2.optString("id", (String) null);
            if (C4701w2.this.f12776d.f12401j) {
                C4548m0.m15715h().mo29837b(C4701w2.this.f12776d, jSONObject2);
            } else if (optString != null) {
                C4548m0.m15715h().mo29832a(C4701w2.this.f12776d, jSONObject2);
            }
            if (jSONObject2.getBoolean("close")) {
                C4701w2.this.mo30016a((C4712j) null);
            }
        }

        /* renamed from: d */
        private void m16397d(JSONObject jSONObject) {
            C4713k a = m16394a(jSONObject);
            C4701w2.this.m16370a(a, a == C4713k.FULL_SCREEN ? -1 : m16395b(jSONObject));
        }

        @JavascriptInterface
        public void postMessage(String str) {
            try {
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
                C4564n1.m15815b(a0Var, "OSJavaScriptInterface:postMessage: " + str);
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                if (string.equals("rendering_complete")) {
                    m16397d(jSONObject);
                } else if (string.equals("action_taken") && !C4701w2.this.f12774b.mo29976c()) {
                    m16396c(jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.onesignal.w2$j */
    /* compiled from: WebViewManager */
    interface C4712j {
        void onComplete();
    }

    /* renamed from: com.onesignal.w2$k */
    /* compiled from: WebViewManager */
    enum C4713k {
        TOP_BANNER,
        BOTTOM_BANNER,
        CENTER_MODAL,
        FULL_SCREEN;

        /* renamed from: a */
        public static C4713k m16398a(String str) {
            return (C4713k) Enum.valueOf(C4713k.class, str);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo30025a() {
            int i = C4710h.f12794a[ordinal()];
            return i == 1 || i == 2;
        }
    }

    protected C4701w2(C4535k0 k0Var, Activity activity) {
        this.f12776d = k0Var;
        this.f12775c = activity;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m16381b(Activity activity, C4535k0 k0Var, String str) {
        try {
            String encodeToString = Base64.encodeToString(str.getBytes(C4250c.DEFAULT_CHARSET), 2);
            C4701w2 w2Var = new C4701w2(k0Var, activity);
            f12772h = w2Var;
            C4536k1.m15622a((Runnable) new C4704c(w2Var, activity, encodeToString));
        } catch (UnsupportedEncodingException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Catch on initInAppMessage: ", (Throwable) e);
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    static void m16384c() {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
        C4564n1.m15815b(a0Var, "WebViewManager IAM dismissAndAwaitNextMessage lastInstance: " + f12772h);
        C4701w2 w2Var = f12772h;
        if (w2Var != null) {
            w2Var.mo30016a((C4712j) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16387d(Activity activity) {
        this.f12773a.layout(0, 0, m16377b(activity), m16382c(activity));
    }

    /* renamed from: d */
    private static void m16386d() {
        if (Build.VERSION.SDK_INT >= 19 && C4564n1.m15805a(C4564n1.C4566a0.DEBUG)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    /* renamed from: c */
    private static int m16382c(Activity activity) {
        return C4543l1.m15666b(activity) - (f12771g * 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m16378b(Activity activity, JSONObject jSONObject) {
        try {
            int a = C4543l1.m15662a(jSONObject.getJSONObject("rect").getInt("height"));
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var, "getPageHeightData:pxHeight: " + a);
            int c = m16382c(activity);
            if (a <= c) {
                return a;
            }
            C4564n1.C4566a0 a0Var2 = C4564n1.C4566a0.DEBUG;
            C4564n1.m15789a(a0Var2, "getPageHeightData:pxHeight is over screen max: " + c);
            return c;
        } catch (JSONException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "pageRectToViewHeight could not get page height", (Throwable) e);
            return -1;
        }
    }

    /* renamed from: a */
    static void m16369a(C4535k0 k0Var, String str) {
        Activity activity = C4461a.f12260f;
        if (activity != null) {
            C4701w2 w2Var = f12772h;
            if (w2Var == null || !k0Var.f12401j) {
                m16381b(activity, k0Var, str);
            } else {
                w2Var.mo30016a((C4712j) new C4702a(activity, k0Var, str));
            }
        } else {
            Looper.prepare();
            new Handler().postDelayed(new C4703b(k0Var, str), 200);
        }
    }

    /* renamed from: b */
    private void m16380b() {
        if (this.f12774b.mo29974b() == C4713k.FULL_SCREEN) {
            m16375a((Integer) null);
        } else {
            C4543l1.m15664a(this.f12775c, new C4705d());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29683a(Activity activity) {
        this.f12775c = activity;
        if (this.f12777e) {
            m16375a((Integer) null);
        } else {
            m16380b();
        }
    }

    /* renamed from: b */
    private static int m16377b(Activity activity) {
        return C4543l1.m15670f(activity) - (f12771g * 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29690a(WeakReference<Activity> weakReference) {
        C4657u uVar = this.f12774b;
        if (uVar != null) {
            uVar.mo29977d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16375a(Integer num) {
        C4657u uVar = this.f12774b;
        if (uVar == null) {
            C4564n1.m15789a(C4564n1.C4566a0.WARN, "No messageView found to update a with a new height.");
            return;
        }
        uVar.mo29971a((WebView) this.f12773a);
        if (num != null) {
            this.f12774b.mo29969a(num.intValue());
        }
        this.f12774b.mo29975b(this.f12775c);
        this.f12774b.mo29968a();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    /* renamed from: a */
    public void m16367a(Activity activity, String str) {
        m16386d();
        C4560m1 m1Var = new C4560m1(activity);
        this.f12773a = m1Var;
        m1Var.setOverScrollMode(2);
        this.f12773a.setVerticalScrollBarEnabled(false);
        this.f12773a.setHorizontalScrollBarEnabled(false);
        this.f12773a.getSettings().setJavaScriptEnabled(true);
        this.f12773a.addJavascriptInterface(new C4711i(), "OSAndroid");
        m16368a((WebView) this.f12773a);
        C4543l1.m15664a(activity, new C4707e(activity, str));
    }

    /* renamed from: a */
    private void m16368a(WebView webView) {
        if (Build.VERSION.SDK_INT == 19) {
            webView.setLayerType(1, (Paint) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16370a(C4713k kVar, int i) {
        C4657u uVar = new C4657u(this.f12773a, kVar, i, this.f12776d.mo29816c());
        this.f12774b = uVar;
        uVar.mo29972a((C4657u.C4666i) new C4708f());
        C4461a.m15376a(f12770f + this.f12776d.f12392a, (C4461a.C4463b) this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30016a(C4712j jVar) {
        C4657u uVar = this.f12774b;
        if (uVar != null) {
            uVar.mo29973a((C4712j) new C4709g(jVar));
        } else if (jVar != null) {
            jVar.onComplete();
        }
    }
}
