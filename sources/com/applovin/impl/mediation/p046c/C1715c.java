package com.applovin.impl.mediation.p046c;

import admost.sdk.base.AdMostExperimentManager;
import android.app.Activity;
import android.graphics.Point;
import com.applovin.impl.adview.C1548c;
import com.applovin.impl.mediation.C1733f;
import com.applovin.impl.mediation.p047d.C1728b;
import com.applovin.impl.mediation.p047d.C1729c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1945k;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.network.C1956a;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.p051c.C1860h;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1921y;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.c */
public class C1715c extends C1864a {

    /* renamed from: a */
    private final String f5334a;

    /* renamed from: c */
    private final MaxAdFormat f5335c;

    /* renamed from: d */
    private final C1733f f5336d;

    /* renamed from: e */
    private final JSONArray f5337e;

    /* renamed from: f */
    private final Activity f5338f;

    /* renamed from: g */
    private final MaxAdListener f5339g;

    public C1715c(String str, MaxAdFormat maxAdFormat, C1733f fVar, JSONArray jSONArray, Activity activity, C1941j jVar, MaxAdListener maxAdListener) {
        super("TaskFetchMediatedAd " + str, jVar);
        this.f5334a = str;
        this.f5335c = maxAdFormat;
        this.f5336d = fVar;
        this.f5337e = jSONArray;
        this.f5338f = activity;
        this.f5339g = maxAdListener;
    }

    /* renamed from: a */
    private String m6552a() {
        return C1728b.m6614a(this.f6217b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6553a(int i) {
        boolean z = i != 204;
        C1977q v = this.f6217b.mo8602v();
        String e = mo8411e();
        Boolean valueOf = Boolean.valueOf(z);
        v.mo8738a(e, valueOf, "Unable to fetch " + this.f5334a + " ad: server returned " + i);
        if (i == -800) {
            this.f6217b.mo8534M().mo8387a(C1859g.f6200o);
        }
        m6560b(i);
    }

    /* renamed from: a */
    private void m6556a(C1860h hVar) {
        long b = hVar.mo8390b(C1859g.f6188c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f6217b.mo8549a(C1841c.f5961dD)).intValue())) {
            hVar.mo8392b(C1859g.f6188c, currentTimeMillis);
            hVar.mo8394c(C1859g.f6189d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6557a(JSONObject jSONObject) {
        try {
            C1992h.m7858d(jSONObject, this.f6217b);
            C1992h.m7857c(jSONObject, this.f6217b);
            C1992h.m7864g(jSONObject, this.f6217b);
            C1728b.m6615a(jSONObject, this.f6217b);
            C1728b.m6617b(jSONObject, this.f6217b);
            this.f6217b.mo8533L().mo8474a((C1864a) m6558b(jSONObject));
        } catch (Throwable th) {
            mo8406a("Unable to process mediated ad response", th);
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    /* renamed from: b */
    private C1720f m6558b(JSONObject jSONObject) {
        return new C1720f(this.f5334a, this.f5335c, jSONObject, this.f5338f, this.f6217b, this.f5339g);
    }

    /* renamed from: b */
    private String m6559b() {
        return C1728b.m6616b(this.f6217b);
    }

    /* renamed from: b */
    private void m6560b(int i) {
        C1994j.m7912a(this.f5339g, this.f5334a, i);
    }

    /* renamed from: c */
    private JSONObject m6561c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        m6564e(jSONObject);
        m6565f(jSONObject);
        m6563d(jSONObject);
        m6562c(jSONObject);
        jSONObject.put("sc", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5796W)));
        jSONObject.put("sc2", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5797X)));
        jSONObject.put("sc3", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5798Y)));
        jSONObject.put("server_installed_at", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5799Z)));
        String str = (String) this.f6217b.mo8550a(C1843e.f6111y);
        if (C2025o.m7963b(str)) {
            jSONObject.put("persisted_data", C2025o.m7966e(str));
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f6053er)).booleanValue()) {
            m6567h(jSONObject);
        }
        jSONObject.put("mediation_provider", this.f6217b.mo8593n());
        return jSONObject;
    }

    /* renamed from: c */
    private void m6562c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("loaded", new JSONArray(this.f6217b.mo8603w().mo7894a()));
            jSONObject2.put("failed", new JSONArray(this.f6217b.mo8603w().mo7895b()));
            jSONObject.put("classname_info", jSONObject2);
            jSONObject.put("initialized_adapters", this.f6217b.mo8604x().mo7892c());
            jSONObject.put("initialized_adapter_classnames", new JSONArray(this.f6217b.mo8604x().mo7891b()));
            jSONObject.put("installed_mediation_adapters", C1729c.m6620a(this.f6217b).mo7874a());
        } catch (Exception e) {
            mo8406a("Failed to populate adapter classnames", e);
            throw new RuntimeException("Failed to populate classnames: " + e);
        }
    }

    /* renamed from: d */
    private void m6563d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f5337e;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    /* renamed from: e */
    private void m6564e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.f5334a);
        jSONObject2.put("ad_format", C1729c.m6624b(this.f5335c));
        Map<String, String> a = C1993i.m7877a(this.f5336d.mo7879a());
        String a2 = this.f6217b.mo8606z().mo8747a(this.f5334a);
        if (C2025o.m7963b(a2)) {
            a.put("previous_winning_network", a2);
        }
        jSONObject2.put("extra_parameters", C1993i.m7882a((Map<String, ?>) a));
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5827aa)).booleanValue()) {
            jSONObject2.put("n", String.valueOf(this.f6217b.mo8566ab().mo8845a(this.f5334a)));
        }
        jSONObject.put("ad_info", jSONObject2);
    }

    /* renamed from: f */
    private void m6565f(JSONObject jSONObject) throws JSONException {
        C1945k O = this.f6217b.mo8536O();
        C1945k.C1950d b = O.mo8613b();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("brand", b.f6502e);
        jSONObject2.put("brand_name", b.f6503f);
        jSONObject2.put("hardware", b.f6504g);
        jSONObject2.put("api_level", b.f6500c);
        jSONObject2.put("carrier", b.f6507j);
        jSONObject2.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, b.f6506i);
        jSONObject2.put("locale", b.f6508k);
        jSONObject2.put("model", b.f6501d);
        jSONObject2.put("os", b.f6499b);
        jSONObject2.put(TapjoyConstants.TJC_PLATFORM, b.f6498a);
        jSONObject2.put("revision", b.f6505h);
        jSONObject2.put("orientation_lock", b.f6509l);
        jSONObject2.put("tz_offset", b.f6515r);
        jSONObject2.put("aida", C2025o.m7959a(b.f6493N));
        jSONObject2.put("wvvc", b.f6516s);
        jSONObject2.put("adns", (double) b.f6510m);
        jSONObject2.put("adnsd", b.f6511n);
        jSONObject2.put("xdpi", (double) b.f6512o);
        jSONObject2.put("ydpi", (double) b.f6513p);
        jSONObject2.put("screen_size_in", b.f6514q);
        jSONObject2.put("sim", C2025o.m7959a(b.f6480A));
        jSONObject2.put("gy", C2025o.m7959a(b.f6481B));
        jSONObject2.put("is_tablet", C2025o.m7959a(b.f6482C));
        jSONObject2.put("tv", C2025o.m7959a(b.f6483D));
        jSONObject2.put("vs", C2025o.m7959a(b.f6484E));
        jSONObject2.put("lpm", b.f6485F);
        jSONObject2.put("fs", b.f6487H);
        jSONObject2.put("tds", b.f6488I);
        jSONObject2.put("fm", b.f6489J.f6525b);
        jSONObject2.put("tm", b.f6489J.f6524a);
        jSONObject2.put("lmt", b.f6489J.f6526c);
        jSONObject2.put("lm", b.f6489J.f6527d);
        jSONObject2.put("adr", C2025o.m7959a(b.f6517t));
        jSONObject2.put("volume", b.f6521x);
        jSONObject2.put("sb", b.f6522y);
        jSONObject2.put(AdMostExperimentManager.TYPE_NETWORK, C1992h.m7861f(this.f6217b));
        jSONObject2.put("af", b.f6519v);
        jSONObject2.put("font", (double) b.f6520w);
        if (C2025o.m7963b(b.f6523z)) {
            jSONObject2.put("ua", b.f6523z);
        }
        if (C2025o.m7963b(b.f6486G)) {
            jSONObject2.put("so", b.f6486G);
        }
        jSONObject2.put("bt_ms", String.valueOf(b.f6496Q));
        jSONObject2.put("mute_switch", String.valueOf(b.f6497R));
        C1945k.C1949c cVar = b.f6518u;
        if (cVar != null) {
            jSONObject2.put("act", cVar.f6478a);
            jSONObject2.put("acm", cVar.f6479b);
        }
        Boolean bool = b.f6490K;
        if (bool != null) {
            jSONObject2.put("huc", bool.toString());
        }
        Boolean bool2 = b.f6491L;
        if (bool2 != null) {
            jSONObject2.put("aru", bool2.toString());
        }
        Boolean bool3 = b.f6492M;
        if (bool3 != null) {
            jSONObject2.put("dns", bool3.toString());
        }
        Point a = C1991g.m7836a(mo8412f());
        jSONObject2.put("dx", Integer.toString(a.x));
        jSONObject2.put("dy", Integer.toString(a.y));
        float f = b.f6494O;
        if (f > 0.0f) {
            jSONObject2.put("da", (double) f);
        }
        float f2 = b.f6495P;
        if (f2 > 0.0f) {
            jSONObject2.put("dm", (double) f2);
        }
        m6566g(jSONObject2);
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, jSONObject2);
        C1945k.C1948b c = O.mo8614c();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("package_name", c.f6471c);
        jSONObject3.put("installer_name", c.f6472d);
        jSONObject3.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, c.f6469a);
        jSONObject3.put(TapjoyConstants.TJC_APP_VERSION_NAME, c.f6470b);
        jSONObject3.put("installed_at", c.f6476h);
        jSONObject3.put("tg", c.f6473e);
        jSONObject3.put("ltg", c.f6474f);
        jSONObject3.put("api_did", this.f6217b.mo8549a(C1841c.f5792S));
        jSONObject3.put("sdk_version", AppLovinSdk.VERSION);
        jSONObject3.put("build", 131);
        jSONObject3.put("first_install", String.valueOf(this.f6217b.mo8530I()));
        jSONObject3.put("first_install_v2", String.valueOf(!this.f6217b.mo8531J()));
        jSONObject3.put("test_ads", c.f6477i);
        jSONObject3.put("debug", Boolean.toString(c.f6475g));
        String i = this.f6217b.mo8588i();
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5968dK)).booleanValue() && C2025o.m7963b(i)) {
            jSONObject3.put("cuid", i);
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5971dN)).booleanValue()) {
            jSONObject3.put("compass_random_token", this.f6217b.mo8589j());
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5973dP)).booleanValue()) {
            jSONObject3.put("applovin_random_token", this.f6217b.mo8590k());
        }
        String str = (String) this.f6217b.mo8549a(C1841c.f5975dR);
        if (C2025o.m7963b(str)) {
            jSONObject3.put("plugin_version", str);
        }
        jSONObject.put("app_info", jSONObject3);
        C1956a.C1958b a2 = this.f6217b.mo8532K().mo8632a();
        if (a2 != null) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("lrm_ts_ms", String.valueOf(a2.mo8636a()));
            jSONObject4.put("lrm_url", a2.mo8637b());
            jSONObject4.put("lrm_ct_ms", String.valueOf(a2.mo8639d()));
            jSONObject4.put("lrm_rs", String.valueOf(a2.mo8638c()));
            jSONObject.put("connection_info", jSONObject4);
        }
    }

    /* renamed from: g */
    private void m6566g(JSONObject jSONObject) throws JSONException {
        C1945k.C1947a d = this.f6217b.mo8536O().mo8615d();
        String str = d.f6468b;
        if (C2025o.m7963b(str)) {
            jSONObject.put(QumparaOfferwallUtil.COLUMN_IDFA, str);
        }
        jSONObject.put("dnt", d.f6467a);
    }

    /* renamed from: h */
    private void m6567h(JSONObject jSONObject) throws JSONException {
        C1860h M = this.f6217b.mo8534M();
        jSONObject.put("li", String.valueOf(M.mo8390b(C1859g.f6187b)));
        jSONObject.put("si", String.valueOf(M.mo8390b(C1859g.f6189d)));
        jSONObject.put("pf", String.valueOf(M.mo8390b(C1859g.f6193h)));
        jSONObject.put("mpf", String.valueOf(M.mo8390b(C1859g.f6200o)));
        jSONObject.put("gpf", String.valueOf(M.mo8390b(C1859g.f6194i)));
        jSONObject.put("asoac", String.valueOf(M.mo8390b(C1859g.f6198m)));
    }

    public void run() {
        mo8405a("Fetching next ad for ad unit id: " + this.f5334a + " and format: " + this.f5335c);
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5982dY)).booleanValue() && C2029r.m8036d()) {
            mo8405a("User is connected to a VPN");
        }
        C1860h M = this.f6217b.mo8534M();
        M.mo8387a(C1859g.f6199n);
        if (M.mo8390b(C1859g.f6188c) == 0) {
            M.mo8392b(C1859g.f6188c, System.currentTimeMillis());
        }
        try {
            JSONObject c = m6561c();
            HashMap hashMap = new HashMap();
            hashMap.put("rid", UUID.randomUUID().toString());
            if (c.has("huc")) {
                hashMap.put("huc", String.valueOf(C1993i.m7871a(c, "huc", (Boolean) false, this.f6217b)));
            }
            if (c.has("aru")) {
                hashMap.put("aru", String.valueOf(C1993i.m7871a(c, "aru", (Boolean) false, this.f6217b)));
            }
            if (c.has("dns")) {
                hashMap.put("dns", String.valueOf(C1993i.m7871a(c, "dns", (Boolean) false, this.f6217b)));
            }
            if (!((Boolean) this.f6217b.mo8549a(C1841c.f6020eK)).booleanValue()) {
                hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f6217b.mo8599t());
            }
            Map<String, String> map = null;
            if (((Boolean) this.f6217b.mo8549a(C1841c.f6045ej)).booleanValue()) {
                map = C1548c.m5992b(((Long) this.f6217b.mo8549a(C1841c.f6046ek)).longValue());
            }
            m6556a(M);
            C17161 r1 = new C1921y<JSONObject>(C1960b.m7596a(this.f6217b).mo8669b("POST").mo8670b(map).mo8663a(m6552a()).mo8673c(m6559b()).mo8664a((Map<String, String>) hashMap).mo8665a(c).mo8662a(new JSONObject()).mo8668b(((Long) this.f6217b.mo8549a(C1840b.f5768f)).intValue()).mo8661a(((Integer) this.f6217b.mo8549a(C1841c.f6004du)).intValue()).mo8672c(((Long) this.f6217b.mo8549a(C1840b.f5767e)).intValue()).mo8671b(true).mo8667a(), this.f6217b) {
                /* renamed from: a */
                public void mo7627a(int i) {
                    C1715c.this.m6553a(i);
                }

                /* renamed from: a */
                public void mo7628a(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        C1993i.m7902b(jSONObject, "ad_fetch_latency_millis", this.f6352d.mo8634a(), this.f6217b);
                        C1993i.m7902b(jSONObject, "ad_fetch_response_size", this.f6352d.mo8635b(), this.f6217b);
                        C1715c.this.m6557a(jSONObject);
                        return;
                    }
                    C1715c.this.m6553a(i);
                }
            };
            r1.mo8496a(C1840b.f5765c);
            r1.mo8498b(C1840b.f5766d);
            this.f6217b.mo8533L().mo8474a((C1864a) r1);
        } catch (Throwable th) {
            mo8406a("Unable to fetch ad " + this.f5334a, th);
            throw new RuntimeException("Unable to fetch ad: " + th);
        }
    }
}
