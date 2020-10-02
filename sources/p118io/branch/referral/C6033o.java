package p118io.branch.referral;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.branch.referral.o */
/* compiled from: DeviceInfo */
class C6033o {

    /* renamed from: p */
    private static C6033o f15625p;

    /* renamed from: a */
    private final String f15626a;

    /* renamed from: b */
    private final boolean f15627b;

    /* renamed from: c */
    private final String f15628c;

    /* renamed from: d */
    private final String f15629d;

    /* renamed from: e */
    private final int f15630e;

    /* renamed from: f */
    private final int f15631f;

    /* renamed from: g */
    private final int f15632g;

    /* renamed from: h */
    private final boolean f15633h;

    /* renamed from: i */
    private final String f15634i;

    /* renamed from: j */
    private final String f15635j;

    /* renamed from: k */
    private final int f15636k;

    /* renamed from: l */
    private final String f15637l;

    /* renamed from: m */
    private final String f15638m;

    /* renamed from: n */
    private final String f15639n;

    /* renamed from: o */
    private final String f15640o;

    private C6033o(boolean z, C6005g0 g0Var, boolean z2) {
        if (z2) {
            this.f15626a = g0Var.mo33870a(true);
        } else {
            this.f15626a = g0Var.mo33870a(z);
        }
        this.f15627b = g0Var.mo33882l();
        this.f15628c = g0Var.mo33877g();
        this.f15629d = g0Var.mo33878h();
        DisplayMetrics i = g0Var.mo33879i();
        this.f15630e = i.densityDpi;
        this.f15631f = i.heightPixels;
        this.f15632g = i.widthPixels;
        this.f15633h = g0Var.mo33881k();
        this.f15634i = C6005g0.m19287n();
        this.f15635j = g0Var.mo33874d();
        this.f15636k = g0Var.mo33875e();
        g0Var.mo33876f();
        this.f15638m = g0Var.mo33869a();
        this.f15639n = g0Var.mo33872b();
        this.f15640o = g0Var.mo33873c();
        this.f15637l = g0Var.mo33880j();
    }

    /* renamed from: a */
    public static C6033o m19379a(boolean z, C6005g0 g0Var, boolean z2) {
        if (f15625p == null) {
            f15625p = new C6033o(z, g0Var, z2);
        }
        return f15625p;
    }

    /* renamed from: e */
    public static C6033o m19381e() {
        return f15625p;
    }

    /* renamed from: b */
    public String mo33933b() {
        if (this.f15626a.equals("bnc_no_value")) {
            return null;
        }
        return this.f15626a;
    }

    /* renamed from: c */
    public String mo33934c() {
        return this.f15635j;
    }

    /* renamed from: d */
    public boolean mo33935d() {
        return this.f15627b;
    }

    /* renamed from: a */
    public void mo33932a(JSONObject jSONObject) {
        try {
            if (!this.f15626a.equals("bnc_no_value")) {
                jSONObject.put(C6028l.HardwareID.mo33920a(), this.f15626a);
                jSONObject.put(C6028l.IsHardwareIDReal.mo33920a(), this.f15627b);
            }
            if (!this.f15628c.equals("bnc_no_value")) {
                jSONObject.put(C6028l.Brand.mo33920a(), this.f15628c);
            }
            if (!this.f15629d.equals("bnc_no_value")) {
                jSONObject.put(C6028l.Model.mo33920a(), this.f15629d);
            }
            jSONObject.put(C6028l.ScreenDpi.mo33920a(), this.f15630e);
            jSONObject.put(C6028l.ScreenHeight.mo33920a(), this.f15631f);
            jSONObject.put(C6028l.ScreenWidth.mo33920a(), this.f15632g);
            jSONObject.put(C6028l.WiFi.mo33920a(), this.f15633h);
            jSONObject.put(C6028l.UIMode.mo33920a(), this.f15637l);
            if (!this.f15635j.equals("bnc_no_value")) {
                jSONObject.put(C6028l.OS.mo33920a(), this.f15635j);
            }
            jSONObject.put(C6028l.OSVersion.mo33920a(), this.f15636k);
            if (!TextUtils.isEmpty(this.f15639n)) {
                jSONObject.put(C6028l.Country.mo33920a(), this.f15639n);
            }
            if (!TextUtils.isEmpty(this.f15640o)) {
                jSONObject.put(C6028l.Language.mo33920a(), this.f15640o);
            }
            if (!TextUtils.isEmpty(this.f15634i)) {
                jSONObject.put(C6028l.LocalIP.mo33920a(), this.f15634i);
            }
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public void mo33931a(Context context, C6035q qVar, JSONObject jSONObject) {
        try {
            if (this.f15626a.equals("bnc_no_value") || !this.f15627b) {
                jSONObject.put(C6028l.UnidentifiedDevice.mo33920a(), true);
            } else {
                jSONObject.put(C6028l.AndroidID.mo33920a(), this.f15626a);
            }
            if (!this.f15628c.equals("bnc_no_value")) {
                jSONObject.put(C6028l.Brand.mo33920a(), this.f15628c);
            }
            if (!this.f15629d.equals("bnc_no_value")) {
                jSONObject.put(C6028l.Model.mo33920a(), this.f15629d);
            }
            jSONObject.put(C6028l.ScreenDpi.mo33920a(), this.f15630e);
            jSONObject.put(C6028l.ScreenHeight.mo33920a(), this.f15631f);
            jSONObject.put(C6028l.ScreenWidth.mo33920a(), this.f15632g);
            if (!this.f15635j.equals("bnc_no_value")) {
                jSONObject.put(C6028l.OS.mo33920a(), this.f15635j);
            }
            jSONObject.put(C6028l.OSVersion.mo33920a(), this.f15636k);
            if (!TextUtils.isEmpty(this.f15639n)) {
                jSONObject.put(C6028l.Country.mo33920a(), this.f15639n);
            }
            if (!TextUtils.isEmpty(this.f15640o)) {
                jSONObject.put(C6028l.Language.mo33920a(), this.f15640o);
            }
            if (!TextUtils.isEmpty(this.f15634i)) {
                jSONObject.put(C6028l.LocalIP.mo33920a(), this.f15634i);
            }
            if (qVar != null && !qVar.mo33975i().equals("bnc_no_value")) {
                jSONObject.put(C6028l.DeviceFingerprintID.mo33920a(), qVar.mo33975i());
            }
            String o = qVar.mo33987o();
            if (o != null && !o.equals("bnc_no_value")) {
                jSONObject.put(C6028l.DeveloperIdentity.mo33920a(), qVar.mo33987o());
            }
            jSONObject.put(C6028l.AppVersion.mo33920a(), m19381e().mo33930a());
            jSONObject.put(C6028l.SDK.mo33920a(), "android");
            jSONObject.put(C6028l.SdkVersion.mo33920a(), "2.19.5");
            jSONObject.put(C6028l.UserAgent.mo33920a(), m19380a(context));
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    public String mo33930a() {
        return this.f15638m;
    }

    /* renamed from: a */
    private String m19380a(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return WebSettings.getDefaultUserAgent(context);
            } catch (Exception unused) {
            }
        }
        return "";
    }
}
