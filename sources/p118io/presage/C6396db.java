package p118io.presage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import p118io.presage.C6383cp;
import p118io.presage.C6391cx;

@SuppressLint({"ViewConstructor"})
/* renamed from: io.presage.db */
public final class C6396db extends WebView {

    /* renamed from: a */
    private boolean f16970a;

    /* renamed from: b */
    private String f16971b;

    /* renamed from: c */
    private C6233ax f16972c;

    /* renamed from: d */
    private boolean f16973d;

    /* renamed from: e */
    private C6241be f16974e;

    /* renamed from: f */
    private C6398dd f16975f;

    /* renamed from: g */
    private boolean f16976g;

    /* renamed from: h */
    private boolean f16977h;

    /* renamed from: i */
    private C6397dc f16978i;

    /* renamed from: j */
    private C6261by f16979j;

    /* renamed from: k */
    private C6219aj f16980k;

    /* renamed from: l */
    private C6391cx f16981l;

    /* renamed from: m */
    private final C6550iu f16982m;

    /* renamed from: n */
    private PontlEveque f16983n;

    /* renamed from: o */
    private MutableContextWrapper f16984o;

    public /* synthetic */ C6396db(Context context, PontlEveque pontlEveque) {
        this(context, pontlEveque, new MutableContextWrapper(context));
    }

    /* renamed from: i */
    private final void m21226i() {
        this.f16981l.mo35331b(this);
    }

    private final void setAdUnit(SaintFelicien saintFelicien) {
        C6398dd ddVar = this.f16975f;
        if (ddVar != null) {
            ddVar.mo34779a(saintFelicien);
        }
    }

    /* renamed from: a */
    public final boolean mo35335a() {
        return this.f16976g;
    }

    /* renamed from: b */
    public final boolean mo35336b() {
        return this.f16977h;
    }

    /* renamed from: c */
    public final void mo35337c() {
        this.f16981l.mo35330a(this);
    }

    /* renamed from: d */
    public final void mo35338d() {
        this.f16981l.mo35332c(this);
    }

    /* renamed from: e */
    public final void mo35339e() {
        this.f16981l.mo35333d(this);
    }

    /* renamed from: f */
    public final void mo35340f() {
        getMraidCommandExecutor().mo34763b();
    }

    /* renamed from: g */
    public final void mo35341g() {
        C6261by.m21022a(this.f16983n.mo34607b());
        C6397dc dcVar = this.f16978i;
        if (dcVar != null) {
            dcVar.mo34865b();
        }
    }

    public final String getAdState() {
        return this.f16971b;
    }

    public final C6397dc getClientAdapter() {
        return this.f16978i;
    }

    public final boolean getContainsMraid() {
        return this.f16973d;
    }

    public final C6233ax getMraidCommandExecutor() {
        C6233ax axVar = this.f16972c;
        return axVar == null ? new C6233ax(this) : axVar;
    }

    public final C6241be getMraidUrlHandler() {
        return this.f16974e;
    }

    public final C6398dd getMraidWebViewClient() {
        return this.f16975f;
    }

    public final boolean getShowSdkCloseButton() {
        return this.f16970a;
    }

    /* renamed from: h */
    public final void mo35349h() {
        setClientAdapter((C6397dc) null);
        C6383cp.CamembertauCalvados camembertauCalvados = C6383cp.f16933a;
        this.f16974e = C6383cp.CamembertauCalvados.m21168a();
        this.f16972c = null;
        setWebViewClient((WebViewClient) null);
        this.f16975f = null;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Activity a = C6219aj.m20783a();
        if (a != null) {
            this.f16984o.setBaseContext(a);
        }
    }

    public final void setAdState(String str) {
        this.f16971b = str;
    }

    public final void setClientAdapter(C6397dc dcVar) {
        this.f16978i = dcVar;
        C6398dd ddVar = this.f16975f;
        if (ddVar != null) {
            ddVar.mo35364a(dcVar);
        }
    }

    public final void setContainsMraid(boolean z) {
        this.f16973d = z;
    }

    public final void setMraidUrlHandler(C6241be beVar) {
        this.f16974e = beVar;
    }

    public final void setMultiBrowserNotOpened(boolean z) {
        this.f16977h = z;
    }

    public final void setResumed(boolean z) {
        this.f16976g = z;
    }

    public final void setShowSdkCloseButton(boolean z) {
        this.f16970a = z;
    }

    public final void setTestCacheStore(C6261by byVar) {
        this.f16979j = byVar;
    }

    public final void setTestMraidLifecycle(C6391cx cxVar) {
        this.f16981l = cxVar;
    }

    public final void setTestMraidViewClientWrapper(C6398dd ddVar) {
        this.f16975f = ddVar;
    }

    public final void setTestTopActivityMonitor(C6219aj ajVar) {
        this.f16980k = ajVar;
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient != null && (!C6514hl.m21416a((Object) this.f16975f, (Object) webViewClient))) {
            new IllegalAccessError("Cannot change the webview client for MraidWebView");
        }
        super.setWebViewClient(webViewClient);
    }

    public final String toString() {
        return "MraidWebView>> " + Integer.toHexString(System.identityHashCode(this));
    }

    private C6396db(Context context, PontlEveque pontlEveque, MutableContextWrapper mutableContextWrapper) {
        super(mutableContextWrapper);
        this.f16983n = pontlEveque;
        this.f16984o = mutableContextWrapper;
        this.f16970a = true;
        this.f16971b = "loading";
        this.f16972c = new C6233ax(this);
        this.f16974e = new C6277cn(this);
        this.f16975f = new C6398dd(this);
        this.f16977h = true;
        this.f16979j = C6261by.f16869a;
        this.f16980k = C6219aj.f16747a;
        C6391cx.CamembertauCalvados camembertauCalvados = C6391cx.f16959a;
        this.f16981l = C6391cx.CamembertauCalvados.m21217a(context, this.f16983n);
        this.f16982m = new C6550iu("bunaZiua");
        setAdUnit(this.f16983n.mo34635m());
        setWebViewClient(this.f16975f);
    }

    /* renamed from: a */
    public final void mo35334a(String str) {
        if (this.f16982m.mo35561a(str)) {
            this.f16973d = true;
            m21226i();
            C6397dc dcVar = this.f16978i;
            if (dcVar != null) {
                dcVar.mo34449a((WebView) this);
            }
        }
        this.f16974e.mo34777a(str, this, this.f16983n.mo34635m());
    }
}
