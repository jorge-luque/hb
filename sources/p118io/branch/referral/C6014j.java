package p118io.branch.referral;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinErrorCodes;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONObject;

/* renamed from: io.branch.referral.j */
/* compiled from: BranchViewHandler */
public class C6014j {

    /* renamed from: h */
    private static C6014j f15394h;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f15395a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f15396b;

    /* renamed from: c */
    private C6017c f15397c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f15398d = false;

    /* renamed from: e */
    private String f15399e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f15400f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Dialog f15401g;

    /* renamed from: io.branch.referral.j$d */
    /* compiled from: BranchViewHandler */
    public interface C3571d {
        /* renamed from: a */
        void mo19625a(int i, String str, String str2);

        /* renamed from: a */
        void mo19627a(String str, String str2);

        /* renamed from: b */
        void mo19632b(String str, String str2);

        /* renamed from: c */
        void mo19634c(String str, String str2);
    }

    /* renamed from: io.branch.referral.j$a */
    /* compiled from: BranchViewHandler */
    class C6015a extends WebViewClient {

        /* renamed from: a */
        final /* synthetic */ C6017c f15402a;

        /* renamed from: b */
        final /* synthetic */ C3571d f15403b;

        /* renamed from: c */
        final /* synthetic */ WebView f15404c;

        C6015a(C6017c cVar, C3571d dVar, WebView webView) {
            this.f15402a = cVar;
            this.f15403b = dVar;
            this.f15404c = webView;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C6014j.this.m19324a(this.f15402a, this.f15403b, this.f15404c);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            boolean unused = C6014j.this.f15400f = true;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean a = C6014j.this.m19330a(str);
            if (!a) {
                webView.loadUrl(str);
            } else if (C6014j.this.f15401g != null) {
                C6014j.this.f15401g.dismiss();
            }
            return a;
        }
    }

    /* renamed from: io.branch.referral.j$b */
    /* compiled from: BranchViewHandler */
    class C6016b implements DialogInterface.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ C3571d f15406a;

        /* renamed from: b */
        final /* synthetic */ C6017c f15407b;

        C6016b(C3571d dVar, C6017c cVar) {
            this.f15406a = dVar;
            this.f15407b = cVar;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            boolean unused = C6014j.this.f15395a = false;
            Dialog unused2 = C6014j.this.f15401g = null;
            if (this.f15406a == null) {
                return;
            }
            if (C6014j.this.f15396b) {
                this.f15406a.mo19632b(this.f15407b.f15410b, this.f15407b.f15409a);
            } else {
                this.f15406a.mo19627a(this.f15407b.f15410b, this.f15407b.f15409a);
            }
        }
    }

    /* renamed from: io.branch.referral.j$c */
    /* compiled from: BranchViewHandler */
    private class C6017c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f15409a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f15410b;

        /* renamed from: c */
        private int f15411c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f15412d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public String f15413e;

        /* synthetic */ C6017c(C6014j jVar, JSONObject jSONObject, String str, C6015a aVar) {
            this(jVar, jSONObject, str);
        }

        private C6017c(C6014j jVar, JSONObject jSONObject, String str) {
            this.f15409a = "";
            this.f15410b = "";
            this.f15411c = 1;
            this.f15412d = "";
            this.f15413e = "";
            try {
                this.f15410b = str;
                if (jSONObject.has(C6028l.BranchViewID.mo33920a())) {
                    this.f15409a = jSONObject.getString(C6028l.BranchViewID.mo33920a());
                }
                if (jSONObject.has(C6028l.BranchViewNumOfUse.mo33920a())) {
                    this.f15411c = jSONObject.getInt(C6028l.BranchViewNumOfUse.mo33920a());
                }
                if (jSONObject.has(C6028l.BranchViewUrl.mo33920a())) {
                    this.f15412d = jSONObject.getString(C6028l.BranchViewUrl.mo33920a());
                }
                if (jSONObject.has(C6028l.BranchViewHtml.mo33920a())) {
                    this.f15413e = jSONObject.getString(C6028l.BranchViewHtml.mo33920a());
                }
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m19342a(Context context) {
            int b = C6035q.m19395a(context).mo33956b(this.f15409a);
            int i = this.f15411c;
            return i > b || i == -1;
        }

        /* renamed from: a */
        public void mo33909a(Context context, String str) {
            C6035q.m19395a(context).mo34008y(str);
        }
    }

    private C6014j() {
    }

    /* renamed from: b */
    public boolean mo33903b(Context context) {
        boolean b = m19332b(this.f15397c, context, (C3571d) null);
        if (b) {
            this.f15397c = null;
        }
        return b;
    }

    /* renamed from: b */
    private boolean m19332b(C6017c cVar, Context context, C3571d dVar) {
        if (this.f15395a || this.f15398d) {
            if (dVar != null) {
                dVar.mo19625a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES, "Unable to create a Branch view. A Branch view is already showing", cVar.f15410b);
            }
            return false;
        }
        this.f15395a = false;
        this.f15396b = false;
        if (!(context == null || cVar == null)) {
            if (cVar.m19342a(context)) {
                if (!TextUtils.isEmpty(cVar.f15413e)) {
                    m19323a(cVar, context, dVar);
                } else {
                    this.f15398d = true;
                    new C6018e(cVar, context, dVar).execute(new Void[0]);
                }
                return true;
            } else if (dVar != null) {
                dVar.mo19625a(-203, "Unable to create this Branch view. Reached maximum usage limit ", cVar.f15410b);
            }
        }
        return false;
    }

    /* renamed from: a */
    public static C6014j m19321a() {
        if (f15394h == null) {
            f15394h = new C6014j();
        }
        return f15394h;
    }

    /* renamed from: a */
    public boolean mo33902a(JSONObject jSONObject, String str, Context context, C3571d dVar) {
        return m19332b(new C6017c(this, jSONObject, str, (C6015a) null), context, dVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19323a(C6017c cVar, Context context, C3571d dVar) {
        if (context != null && cVar != null) {
            WebView webView = new WebView(context);
            webView.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 19) {
                webView.setLayerType(2, (Paint) null);
            }
            this.f15400f = false;
            if (!TextUtils.isEmpty(cVar.f15413e)) {
                webView.loadDataWithBaseURL((String) null, cVar.f15413e, "text/html", "utf-8", (String) null);
                webView.setWebViewClient(new C6015a(cVar, dVar, webView));
            }
        }
    }

    /* renamed from: io.branch.referral.j$e */
    /* compiled from: BranchViewHandler */
    private class C6018e extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a */
        private final C6017c f15414a;

        /* renamed from: b */
        private final Context f15415b;

        /* renamed from: c */
        private final C3571d f15416c;

        public C6018e(C6017c cVar, Context context, C3571d dVar) {
            this.f15414a = cVar;
            this.f15415b = context;
            this.f15416c = dVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0050  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(java.lang.Void... r8) {
            /*
                r7 = this;
                r8 = 0
                r0 = 200(0xc8, float:2.8E-43)
                r1 = -1
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x004d }
                io.branch.referral.j$c r3 = r7.f15414a     // Catch:{ Exception -> 0x004d }
                java.lang.String r3 = r3.f15412d     // Catch:{ Exception -> 0x004d }
                r2.<init>(r3)     // Catch:{ Exception -> 0x004d }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x004d }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x004d }
                java.lang.String r3 = "GET"
                r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x004d }
                r2.connect()     // Catch:{ Exception -> 0x004d }
                int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x004d }
                if (r3 != r0) goto L_0x004e
                java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x004c }
                r4.<init>()     // Catch:{ Exception -> 0x004c }
                java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x004c }
                r5 = 1024(0x400, float:1.435E-42)
                byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x004c }
            L_0x0030:
                int r6 = r2.read(r5)     // Catch:{ Exception -> 0x004c }
                if (r6 == r1) goto L_0x003a
                r4.write(r5, r8, r6)     // Catch:{ Exception -> 0x004c }
                goto L_0x0030
            L_0x003a:
                io.branch.referral.j$c r1 = r7.f15414a     // Catch:{ Exception -> 0x004c }
                java.lang.String r5 = "UTF-8"
                java.lang.String r5 = r4.toString(r5)     // Catch:{ Exception -> 0x004c }
                java.lang.String unused = r1.f15413e = r5     // Catch:{ Exception -> 0x004c }
                r4.close()     // Catch:{ Exception -> 0x004c }
                r2.close()     // Catch:{ Exception -> 0x004c }
                goto L_0x004e
            L_0x004c:
                r1 = r3
            L_0x004d:
                r3 = r1
            L_0x004e:
                if (r3 != r0) goto L_0x0051
                r8 = 1
            L_0x0051:
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C6014j.C6018e.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                C6014j.this.m19323a(this.f15414a, this.f15415b, this.f15416c);
            } else {
                C3571d dVar = this.f15416c;
                if (dVar != null) {
                    dVar.mo19625a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES, "Unable to create a Branch view due to a temporary network error", this.f15414a.f15410b);
                }
            }
            boolean unused = C6014j.this.f15398d = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19324a(C6017c cVar, C3571d dVar, WebView webView) {
        if (this.f15400f || C3555b.m12034k() == null || C3555b.m12034k().f9994p == null) {
            this.f15395a = false;
            if (dVar != null) {
                dVar.mo19625a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES, "Unable to create a Branch view due to a temporary network error", cVar.f15410b);
                return;
            }
            return;
        }
        Activity activity = (Activity) C3555b.m12034k().f9994p.get();
        if (activity != null) {
            cVar.mo33909a(activity.getApplicationContext(), cVar.f15409a);
            this.f15399e = activity.getClass().getName();
            RelativeLayout relativeLayout = new RelativeLayout(activity);
            relativeLayout.setVisibility(8);
            relativeLayout.addView(webView, new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.setBackgroundColor(0);
            Dialog dialog = this.f15401g;
            if (dialog == null || !dialog.isShowing()) {
                Dialog dialog2 = new Dialog(activity, 16973834);
                this.f15401g = dialog2;
                dialog2.setContentView(relativeLayout);
                relativeLayout.setVisibility(0);
                webView.setVisibility(0);
                this.f15401g.show();
                m19322a((View) relativeLayout);
                m19322a((View) webView);
                this.f15395a = true;
                if (dVar != null) {
                    dVar.mo19634c(cVar.f15410b, cVar.f15409a);
                }
                this.f15401g.setOnDismissListener(new C6016b(dVar, cVar));
            } else if (dVar != null) {
                dVar.mo19625a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES, "Unable to create a Branch view. A Branch view is already showing", cVar.f15410b);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19330a(String str) {
        try {
            URI uri = new URI(str);
            if (!uri.getScheme().equalsIgnoreCase("branch-cta")) {
                return false;
            }
            if (uri.getHost().equalsIgnoreCase("accept")) {
                this.f15396b = true;
            } else if (!uri.getHost().equalsIgnoreCase("cancel")) {
                return false;
            } else {
                this.f15396b = false;
            }
            return true;
        } catch (URISyntaxException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m19322a(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setStartOffset(10);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }

    /* renamed from: a */
    public boolean mo33901a(JSONObject jSONObject, String str) {
        Activity activity;
        C6017c cVar = new C6017c(this, jSONObject, str, (C6015a) null);
        if (C3555b.m12034k().f9994p == null || (activity = (Activity) C3555b.m12034k().f9994p.get()) == null || !cVar.m19342a((Context) activity)) {
            return false;
        }
        this.f15397c = new C6017c(this, jSONObject, str, (C6015a) null);
        return true;
    }

    /* renamed from: a */
    public boolean mo33900a(Context context) {
        C6017c cVar = this.f15397c;
        return cVar != null && cVar.m19342a(context);
    }

    /* renamed from: a */
    public void mo33899a(Activity activity) {
        String str = this.f15399e;
        if (str != null && str.equalsIgnoreCase(activity.getClass().getName())) {
            this.f15395a = false;
        }
    }
}
