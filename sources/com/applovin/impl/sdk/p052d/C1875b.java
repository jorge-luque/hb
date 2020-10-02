package com.applovin.impl.sdk.p052d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1945k;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.network.C1964d;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TapjoyConstants;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.b */
class C1875b extends C1864a {
    C1875b(C1941j jVar) {
        super("TaskApiSubmitData", jVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7229a(JSONObject jSONObject) {
        try {
            this.f6217b.mo8537P().mo8384c();
            JSONObject a = C1992h.m7848a(jSONObject);
            this.f6217b.mo8526D().mo8304a((C1841c<?>) C1841c.f5792S, (Object) a.getString("device_id"));
            this.f6217b.mo8526D().mo8304a((C1841c<?>) C1841c.f5793T, (Object) a.getString("device_token"));
            this.f6217b.mo8526D().mo8304a((C1841c<?>) C1841c.f5794U, (Object) Long.valueOf(a.getLong("publisher_id")));
            this.f6217b.mo8526D().mo8307b();
            C1992h.m7858d(a, this.f6217b);
            C1992h.m7862f(a, this.f6217b);
            String b = C1993i.m7896b(a, "latest_version", "", this.f6217b);
            if (!TextUtils.isEmpty(b) && !AppLovinSdk.VERSION.equals(b)) {
                String str = "Current SDK version (" + AppLovinSdk.VERSION + ") is outdated. Please integrate the latest version of the AppLovin SDK (" + b + "). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.";
                if (C1993i.m7893a(a, "sdk_update_message")) {
                    str = C1993i.m7896b(a, "sdk_update_message", str, this.f6217b);
                }
                C1977q.m7750h("AppLovinSdk", str);
            }
            this.f6217b.mo8534M().mo8391b();
        } catch (Throwable th) {
            mo8406a("Unable to parse API response", th);
        }
    }

    /* renamed from: b */
    private void m7230b(JSONObject jSONObject) throws JSONException {
        C1945k O = this.f6217b.mo8536O();
        C1945k.C1948b c = O.mo8614c();
        C1945k.C1950d b = O.mo8613b();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("model", b.f6501d);
        jSONObject2.put("os", b.f6499b);
        jSONObject2.put("brand", b.f6502e);
        jSONObject2.put("brand_name", b.f6503f);
        jSONObject2.put("hardware", b.f6504g);
        jSONObject2.put("sdk_version", b.f6500c);
        jSONObject2.put("revision", b.f6505h);
        jSONObject2.put("adns", (double) b.f6510m);
        jSONObject2.put("adnsd", b.f6511n);
        jSONObject2.put("xdpi", String.valueOf(b.f6512o));
        jSONObject2.put("ydpi", String.valueOf(b.f6513p));
        jSONObject2.put("screen_size_in", String.valueOf(b.f6514q));
        jSONObject2.put("gy", C2025o.m7959a(b.f6481B));
        jSONObject2.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, b.f6506i);
        jSONObject2.put("carrier", b.f6507j);
        jSONObject2.put("orientation_lock", b.f6509l);
        jSONObject2.put("tz_offset", b.f6515r);
        jSONObject2.put("aida", String.valueOf(b.f6493N));
        jSONObject2.put("adr", C2025o.m7959a(b.f6517t));
        jSONObject2.put("wvvc", b.f6516s);
        jSONObject2.put("volume", b.f6521x);
        jSONObject2.put("sb", b.f6522y);
        jSONObject2.put("type", "android");
        jSONObject2.put("sim", C2025o.m7959a(b.f6480A));
        jSONObject2.put("is_tablet", C2025o.m7959a(b.f6482C));
        jSONObject2.put("lpm", b.f6485F);
        jSONObject2.put("tv", C2025o.m7959a(b.f6483D));
        jSONObject2.put("vs", C2025o.m7959a(b.f6484E));
        jSONObject2.put("fs", b.f6487H);
        jSONObject2.put("tds", b.f6488I);
        jSONObject2.put("fm", String.valueOf(b.f6489J.f6525b));
        jSONObject2.put("tm", String.valueOf(b.f6489J.f6524a));
        jSONObject2.put("lmt", String.valueOf(b.f6489J.f6526c));
        jSONObject2.put("lm", String.valueOf(b.f6489J.f6527d));
        jSONObject2.put("af", String.valueOf(b.f6519v));
        jSONObject2.put("font", String.valueOf(b.f6520w));
        jSONObject2.put("bt_ms", String.valueOf(b.f6496Q));
        jSONObject2.put("mute_switch", String.valueOf(b.f6497R));
        m7234f(jSONObject2);
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
        C1945k.C1949c cVar = b.f6518u;
        if (cVar != null) {
            jSONObject2.put("act", cVar.f6478a);
            jSONObject2.put("acm", cVar.f6479b);
        }
        String str = b.f6523z;
        if (C2025o.m7963b(str)) {
            jSONObject2.put("ua", C2025o.m7966e(str));
        }
        String str2 = b.f6486G;
        if (!TextUtils.isEmpty(str2)) {
            jSONObject2.put("so", C2025o.m7966e(str2));
        }
        Locale locale = b.f6508k;
        if (locale != null) {
            jSONObject2.put("locale", C2025o.m7966e(locale.toString()));
        }
        float f = b.f6494O;
        if (f > 0.0f) {
            jSONObject2.put("da", (double) f);
        }
        float f2 = b.f6495P;
        if (f2 > 0.0f) {
            jSONObject2.put("dm", (double) f2);
        }
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("package_name", c.f6471c);
        jSONObject3.put("installer_name", c.f6472d);
        jSONObject3.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, c.f6469a);
        jSONObject3.put(TapjoyConstants.TJC_APP_VERSION_NAME, c.f6470b);
        jSONObject3.put("installed_at", c.f6476h);
        jSONObject3.put("tg", c.f6473e);
        jSONObject3.put("ltg", c.f6474f);
        jSONObject3.put("applovin_sdk_version", AppLovinSdk.VERSION);
        jSONObject3.put("first_install", String.valueOf(this.f6217b.mo8530I()));
        jSONObject3.put("first_install_v2", String.valueOf(!this.f6217b.mo8531J()));
        jSONObject3.put("test_ads", c.f6477i);
        jSONObject3.put("debug", Boolean.toString(c.f6475g));
        String str3 = (String) this.f6217b.mo8549a(C1841c.f5975dR);
        if (C2025o.m7963b(str3)) {
            jSONObject3.put("plugin_version", str3);
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5968dK)).booleanValue() && C2025o.m7963b(this.f6217b.mo8588i())) {
            jSONObject3.put("cuid", this.f6217b.mo8588i());
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5971dN)).booleanValue()) {
            jSONObject3.put("compass_random_token", this.f6217b.mo8589j());
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5973dP)).booleanValue()) {
            jSONObject3.put("applovin_random_token", this.f6217b.mo8590k());
        }
        jSONObject.put("app_info", jSONObject3);
    }

    /* renamed from: c */
    private void m7231c(JSONObject jSONObject) throws JSONException {
        if (((Boolean) this.f6217b.mo8549a(C1841c.f6053er)).booleanValue()) {
            jSONObject.put("stats", this.f6217b.mo8534M().mo8393c());
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5829ac)).booleanValue()) {
            JSONObject b = C1964d.m7636b(mo8412f());
            if (b.length() > 0) {
                jSONObject.put("network_response_codes", b);
            }
            if (((Boolean) this.f6217b.mo8549a(C1841c.f5830ad)).booleanValue()) {
                C1964d.m7634a(mo8412f());
            }
        }
    }

    /* renamed from: d */
    private void m7232d(JSONObject jSONObject) throws JSONException {
        JSONArray a;
        if (((Boolean) this.f6217b.mo8549a(C1841c.f6059ex)).booleanValue() && (a = this.f6217b.mo8537P().mo8381a()) != null && a.length() > 0) {
            jSONObject.put(ReportDBAdapter.ReportColumns.COLUMN_ERRORS, a);
        }
    }

    /* renamed from: e */
    private void m7233e(JSONObject jSONObject) {
        C18761 r0 = new C1921y<JSONObject>(C1960b.m7596a(this.f6217b).mo8663a(C1992h.m7846a("2.0/device", this.f6217b)).mo8673c(C1992h.m7856b("2.0/device", this.f6217b)).mo8664a(C1992h.m7859e(this.f6217b)).mo8669b("POST").mo8665a(jSONObject).mo8662a(new JSONObject()).mo8661a(((Integer) this.f6217b.mo8549a(C1841c.f6005dv)).intValue()).mo8667a(), this.f6217b) {
            /* renamed from: a */
            public void mo7627a(int i) {
                C1992h.m7849a(i, this.f6217b);
            }

            /* renamed from: a */
            public void mo7628a(JSONObject jSONObject, int i) {
                C1875b.this.m7229a(jSONObject);
            }
        };
        r0.mo8496a(C1841c.f5811aK);
        r0.mo8498b(C1841c.f5812aL);
        this.f6217b.mo8533L().mo8474a((C1864a) r0);
    }

    /* renamed from: f */
    private void m7234f(JSONObject jSONObject) {
        try {
            C1945k.C1947a d = this.f6217b.mo8536O().mo8615d();
            String str = d.f6468b;
            if (C2025o.m7963b(str)) {
                jSONObject.put(QumparaOfferwallUtil.COLUMN_IDFA, str);
            }
            jSONObject.put("dnt", Boolean.toString(d.f6467a));
        } catch (Throwable th) {
            mo8406a("Failed to populate advertising info", th);
        }
    }

    public void run() {
        try {
            mo8407b("Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            m7230b(jSONObject);
            m7231c(jSONObject);
            m7232d(jSONObject);
            m7233e(jSONObject);
        } catch (JSONException e) {
            mo8406a("Unable to build JSON message with collected data", e);
        }
    }
}
