package com.chartboost.sdk.Model;

import admost.sdk.AdMostInterstitial;
import android.os.Build;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C2169j1;
import com.chartboost.sdk.impl.C2196p0;
import com.facebook.appevents.UserDataStore;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.f */
public class C2091f {

    /* renamed from: i */
    private static final String f6953i = "f";

    /* renamed from: j */
    private static Integer f6954j = C2169j1.m8620c(C2242k.f7612l);

    /* renamed from: k */
    private static String f6955k = Build.VERSION.RELEASE;

    /* renamed from: l */
    private static String f6956l = "Android";

    /* renamed from: m */
    private static String f6957m = "Chartboost-Android-SDK";

    /* renamed from: n */
    private static String f6958n = "USD";

    /* renamed from: o */
    private static int f6959o = 1;

    /* renamed from: p */
    private static int f6960p = 1;

    /* renamed from: q */
    private static int f6961q = 0;

    /* renamed from: a */
    private final JSONObject f6962a = new JSONObject();

    /* renamed from: b */
    private final JSONObject f6963b = new JSONObject();

    /* renamed from: c */
    private final JSONArray f6964c = new JSONArray();

    /* renamed from: d */
    private final JSONObject f6965d = new JSONObject();

    /* renamed from: e */
    private final JSONObject f6966e = new JSONObject();

    /* renamed from: f */
    private final JSONObject f6967f = new JSONObject();

    /* renamed from: g */
    private final C2092g f6968g;

    /* renamed from: h */
    private final C2196p0 f6969h;

    public C2091f(C2092g gVar, C2196p0 p0Var) {
        this.f6968g = gVar;
        this.f6969h = p0Var;
        m8276i();
        m8273f();
        m8274g();
        m8272e();
        m8275h();
        m8277j();
    }

    /* renamed from: b */
    private JSONObject m8269b() {
        JSONObject jSONObject = new JSONObject();
        C2076e.m8187a(jSONObject, "lat", JSONObject.NULL);
        C2076e.m8187a(jSONObject, "lon", JSONObject.NULL);
        C2076e.m8187a(jSONObject, UserDataStore.COUNTRY, this.f6968g.f6977h);
        C2076e.m8187a(jSONObject, "type", 2);
        return jSONObject;
    }

    /* renamed from: c */
    private String m8270c() {
        int i = this.f6969h.f7419a;
        if (i == 0) {
            CBLogging.m8154b(f6953i, "INTERSTITIAL NOT COMPATIBLE WITH OPENRTB");
            return AdMostInterstitial.ZONE_TYPE_INTERSTITIAL;
        } else if (i == 1) {
            CBLogging.m8154b(f6953i, "REWARDED_VIDEO NOT COMPATIBLE WITH OPENRTB");
            return AdMostInterstitial.ZONE_TYPE_REWARDED;
        } else if (i != 2) {
            return i != 3 ? "" : "banner";
        } else {
            CBLogging.m8154b(f6953i, "IN_PLAY NOT COMPATIBLE WITH OPENRTB");
            return "";
        }
    }

    /* renamed from: d */
    private Integer m8271d() {
        int i = this.f6969h.f7419a;
        if (i == 0 || i == 1) {
            return Integer.valueOf(f6960p);
        }
        return Integer.valueOf(f6961q);
    }

    /* renamed from: e */
    private void m8272e() {
        C2076e.m8187a(this.f6965d, "id", this.f6968g.f6988s);
        C2076e.m8187a(this.f6965d, "name", JSONObject.NULL);
        C2076e.m8187a(this.f6965d, TJAdUnitConstants.String.BUNDLE, this.f6968g.f6980k);
        C2076e.m8187a(this.f6965d, "storeurl", JSONObject.NULL);
        JSONObject jSONObject = new JSONObject();
        C2076e.m8187a(jSONObject, "id", JSONObject.NULL);
        C2076e.m8187a(jSONObject, "name", JSONObject.NULL);
        C2076e.m8187a(this.f6965d, "publisher", jSONObject);
        C2076e.m8187a(this.f6965d, "cat", JSONObject.NULL);
        C2076e.m8187a(this.f6962a, TapjoyConstants.TJC_APP_PLACEMENT, this.f6965d);
    }

    /* renamed from: f */
    private void m8273f() {
        C2076e.m8187a(this.f6963b, "devicetype", f6954j);
        C2076e.m8187a(this.f6963b, "w", this.f6968g.f6984o);
        C2076e.m8187a(this.f6963b, "h", this.f6968g.f6985p);
        C2076e.m8187a(this.f6963b, "ifa", this.f6968g.f6970a.mo9086a().f6860c);
        C2076e.m8187a(this.f6963b, "osv", f6955k);
        C2076e.m8187a(this.f6963b, "lmt", Integer.valueOf(this.f6968g.f6970a.mo9086a().mo9087a().booleanValue() ? 1 : 0));
        C2076e.m8187a(this.f6963b, "connectiontype", this.f6968g.f6971b.mo9538b());
        C2076e.m8187a(this.f6963b, "os", f6956l);
        C2076e.m8187a(this.f6963b, "geo", m8269b());
        C2076e.m8187a(this.f6963b, "ip", JSONObject.NULL);
        C2076e.m8187a(this.f6963b, "language", this.f6968g.f6978i);
        C2076e.m8187a(this.f6963b, "ua", C2242k.f7621u);
        C2076e.m8187a(this.f6963b, "model", this.f6968g.f6975f);
        C2076e.m8187a(this.f6963b, "carrier", this.f6968g.f6992w);
        C2076e.m8187a(this.f6962a, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, this.f6963b);
    }

    /* renamed from: g */
    private void m8274g() {
        JSONObject jSONObject = new JSONObject();
        C2076e.m8187a(jSONObject, "id", JSONObject.NULL);
        JSONObject jSONObject2 = new JSONObject();
        C2076e.m8187a(jSONObject2, "w", this.f6969h.f7421c);
        C2076e.m8187a(jSONObject2, "h", this.f6969h.f7420b);
        C2076e.m8187a(jSONObject2, "btype", JSONObject.NULL);
        C2076e.m8187a(jSONObject2, "battr", JSONObject.NULL);
        C2076e.m8187a(jSONObject2, "pos", JSONObject.NULL);
        C2076e.m8187a(jSONObject2, "topframe", JSONObject.NULL);
        C2076e.m8187a(jSONObject2, "api", JSONObject.NULL);
        JSONObject jSONObject3 = new JSONObject();
        C2076e.m8187a(jSONObject3, "placementtype", m8270c());
        C2076e.m8187a(jSONObject3, "playableonly", JSONObject.NULL);
        C2076e.m8187a(jSONObject3, "allowscustomclosebutton", JSONObject.NULL);
        C2076e.m8187a(jSONObject2, "ext", jSONObject3);
        C2076e.m8187a(jSONObject, "banner", jSONObject2);
        C2076e.m8187a(jSONObject, "instl", m8271d());
        C2076e.m8187a(jSONObject, "tagid", this.f6969h.f7422d);
        C2076e.m8187a(jSONObject, "displaymanager", f6957m);
        C2076e.m8187a(jSONObject, "displaymanagerver", this.f6968g.f6981l);
        C2076e.m8187a(jSONObject, "bidfloor", JSONObject.NULL);
        C2076e.m8187a(jSONObject, "bidfloorcur", f6958n);
        C2076e.m8187a(jSONObject, "secure", Integer.valueOf(f6959o));
        this.f6964c.put(jSONObject);
        C2076e.m8187a(this.f6962a, "imp", this.f6964c);
    }

    /* renamed from: h */
    private void m8275h() {
        int i = 0;
        C2076e.m8187a(this.f6966e, "coppa", 0);
        JSONObject jSONObject = new JSONObject();
        if (C2242k.f7622v != Chartboost.CBPIDataUseConsent.UNKNOWN) {
            i = 1;
        }
        C2076e.m8187a(jSONObject, "gdpr", Integer.valueOf(i));
        C2076e.m8187a(this.f6966e, "ext", jSONObject);
        C2076e.m8187a(this.f6962a, "regs", this.f6966e);
    }

    /* renamed from: i */
    private void m8276i() {
        C2076e.m8187a(this.f6962a, "id", JSONObject.NULL);
        C2076e.m8187a(this.f6962a, "test", JSONObject.NULL);
        C2076e.m8187a(this.f6962a, "cur", new JSONArray().put("USD"));
        C2076e.m8187a(this.f6962a, "at", 2);
    }

    /* renamed from: j */
    private void m8277j() {
        C2076e.m8187a(this.f6967f, "id", JSONObject.NULL);
        C2076e.m8187a(this.f6967f, "geo", m8269b());
        JSONObject jSONObject = new JSONObject();
        C2076e.m8187a(jSONObject, "consent", Integer.valueOf(Math.max(0, C2242k.f7622v.getValue())));
        C2076e.m8187a(this.f6967f, "ext", jSONObject);
        C2076e.m8187a(this.f6962a, QumparaOfferwallUtil.TABLE_NAME, this.f6967f);
    }

    /* renamed from: a */
    public JSONObject mo9151a() {
        return this.f6962a;
    }
}
