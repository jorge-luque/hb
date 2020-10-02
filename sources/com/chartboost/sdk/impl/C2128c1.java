package com.chartboost.sdk.impl;

import admost.sdk.base.AdMost;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Libraries.C2073c;
import com.chartboost.sdk.Libraries.C2074d;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C2092g;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.facebook.GraphResponse;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.ShareConstants;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.chartboost.sdk.impl.c1 */
public class C2128c1 extends C2203r0<JSONObject> {

    /* renamed from: j */
    private final String f7127j;

    /* renamed from: k */
    public JSONObject f7128k = new JSONObject();

    /* renamed from: l */
    public final C2129a f7129l;

    /* renamed from: m */
    public boolean f7130m = false;

    /* renamed from: n */
    protected final C2092g f7131n;

    /* renamed from: o */
    private final C2098a f7132o;

    /* renamed from: com.chartboost.sdk.impl.c1$a */
    public interface C2129a {
        /* renamed from: a */
        void mo9299a(C2128c1 c1Var, CBError cBError);

        /* renamed from: a */
        void mo9300a(C2128c1 c1Var, JSONObject jSONObject);
    }

    public C2128c1(String str, String str2, C2092g gVar, C2098a aVar, int i, C2129a aVar2) {
        super("POST", C2124b1.m8448a(str, str2), i, (File) null);
        this.f7127j = str2;
        this.f7131n = gVar;
        this.f7132o = aVar;
        this.f7129l = aVar2;
    }

    /* renamed from: a */
    public void mo9293a(String str) {
    }

    /* renamed from: c */
    public void mo9296c() {
        mo9294a(TapjoyConstants.TJC_APP_PLACEMENT, (Object) this.f7131n.f6988s);
        mo9294a("model", (Object) this.f7131n.f6975f);
        mo9294a(TapjoyConstants.TJC_DEVICE_TYPE_NAME, (Object) this.f7131n.f6989t);
        mo9294a("actual_device_type", (Object) this.f7131n.f6990u);
        mo9294a("os", (Object) this.f7131n.f6976g);
        mo9294a(UserDataStore.COUNTRY, (Object) this.f7131n.f6977h);
        mo9294a("language", (Object) this.f7131n.f6978i);
        mo9294a("sdk", (Object) this.f7131n.f6981l);
        mo9294a("user_agent", (Object) C2242k.f7621u);
        mo9294a("timestamp", (Object) String.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.f7131n.f6974e.mo9110a())));
        boolean z = false;
        mo9294a("session", (Object) Integer.valueOf(this.f7131n.f6973d.getInt("cbPrefSessionCount", 0)));
        mo9294a("reachability", (Object) Integer.valueOf(this.f7131n.f6971b.mo9537a()));
        mo9294a("scale", (Object) this.f7131n.f6987r);
        mo9294a("is_portrait", (Object) Boolean.valueOf(CBUtility.m8171b(CBUtility.m8174e())));
        mo9294a(TJAdUnitConstants.String.BUNDLE, (Object) this.f7131n.f6979j);
        mo9294a("bundle_id", (Object) this.f7131n.f6980k);
        mo9294a("carrier", (Object) this.f7131n.f6991v);
        mo9294a("custom_id", (Object) C2242k.f7602b);
        C2149g1 g1Var = C2242k.f7609i;
        if (g1Var != null) {
            mo9294a("mediation", (Object) g1Var.mo9352b());
            mo9294a("mediation_version", (Object) C2242k.f7609i.mo9353c());
            mo9294a(TapjoyConstants.TJC_ADAPTER_VERSION, (Object) C2242k.f7609i.mo9351a());
        }
        if (C2242k.f7605e != null) {
            mo9294a("framework_version", (Object) C2242k.f7607g);
            mo9294a("wrapper_version", (Object) C2242k.f7603c);
        }
        mo9294a("rooted_device", (Object) Boolean.valueOf(this.f7131n.f6993x));
        mo9294a(TapjoyConstants.TJC_DEVICE_TIMEZONE, (Object) this.f7131n.f6994y);
        mo9294a("mobile_network", (Object) this.f7131n.f6995z);
        mo9294a("dw", (Object) this.f7131n.f6984o);
        mo9294a("dh", (Object) this.f7131n.f6985p);
        mo9294a("dpi", (Object) this.f7131n.f6986q);
        mo9294a("w", (Object) this.f7131n.f6982m);
        mo9294a("h", (Object) this.f7131n.f6983n);
        mo9294a("commit_hash", (Object) "a33bc81418271394db93ac3fa0ad3842e5511659");
        C2074d.C2075a a = this.f7131n.f6970a.mo9086a();
        mo9294a("identity", (Object) a.f6859b);
        int i = a.f6858a;
        if (i != -1) {
            if (i == 1) {
                z = true;
            }
            mo9294a("limit_ad_tracking", (Object) Boolean.valueOf(z));
        }
        mo9294a("pidatauseconsent", (Object) Integer.valueOf(C2242k.f7622v.getValue()));
        String str = this.f7131n.f6972c.get().f7001a;
        if (!C2224x.m8805e().mo9549a((CharSequence) str)) {
            mo9294a("config_variant", (Object) str);
        }
    }

    /* renamed from: d */
    public String mo9297d() {
        String str = "/";
        if (this.f7127j == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f7127j.startsWith(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(this.f7127j);
        return sb.toString();
    }

    /* renamed from: e */
    public String mo9298e() {
        return mo9297d();
    }

    /* renamed from: a */
    public void mo9294a(String str, Object obj) {
        C2076e.m8187a(this.f7128k, str, obj);
    }

    /* renamed from: a */
    private void m8454a(C2215u0 u0Var, CBError cBError) {
        Object obj;
        String str;
        C2076e.C2077a[] aVarArr = new C2076e.C2077a[5];
        aVarArr[0] = C2076e.m8184a("endpoint", (Object) mo9297d());
        String str2 = AdMost.CONSENT_ZONE_NONE;
        if (u0Var == null) {
            obj = str2;
        } else {
            obj = Integer.valueOf(u0Var.f7464a);
        }
        aVarArr[1] = C2076e.m8184a("statuscode", obj);
        if (cBError == null) {
            str = str2;
        } else {
            str = cBError.mo9114a().toString();
        }
        aVarArr[2] = C2076e.m8184a("error", (Object) str);
        if (cBError != null) {
            str2 = cBError.mo9115b();
        }
        aVarArr[3] = C2076e.m8184a("errorDescription", (Object) str2);
        aVarArr[4] = C2076e.m8184a("retryCount", (Object) 0);
        this.f7132o.mo9165a("request_manager", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, cBError == null ? GraphResponse.SUCCESS_KEY : "failure", (String) null, (String) null, (String) null, C2076e.m8186a(aVarArr));
    }

    /* renamed from: a */
    public C2209s0 mo9289a() {
        mo9296c();
        String jSONObject = this.f7128k.toString();
        String str = C2242k.f7610j;
        String str2 = C2242k.f7611k;
        String a = C2073c.m8177a(C2073c.m8178b(String.format(Locale.US, "%s %s\n%s\n%s", new Object[]{this.f7432a, mo9298e(), str2, jSONObject}).getBytes()));
        HashMap hashMap = new HashMap();
        hashMap.put(C6078a.HEADER_ACCEPT, C6078a.ACCEPT_JSON_VALUE);
        hashMap.put("X-Chartboost-Client", CBUtility.m8175f());
        hashMap.put("X-Chartboost-API", "8.0.3");
        hashMap.put("X-Chartboost-App", str);
        hashMap.put("X-Chartboost-Signature", a);
        return new C2209s0(hashMap, jSONObject.getBytes(), C6078a.ACCEPT_JSON_VALUE);
    }

    /* renamed from: a */
    public C2212t0<JSONObject> mo9290a(C2215u0 u0Var) {
        try {
            if (u0Var.f7465b == null) {
                return C2212t0.m8773a(new CBError(CBError.C2085b.INVALID_RESPONSE, "Response is not a valid json object"));
            }
            JSONObject jSONObject = new JSONObject(new String(u0Var.f7465b));
            CBLogging.m8158d("CBRequest", "Request " + mo9297d() + " succeeded. Response code: " + u0Var.f7464a + ", body: " + jSONObject.toString(4));
            if (this.f7130m) {
                int optInt = jSONObject.optInt("status");
                if (optInt == 404) {
                    return C2212t0.m8773a(new CBError(CBError.C2085b.HTTP_NOT_FOUND, "404 error from server"));
                }
                if (optInt < 200 || optInt > 299) {
                    String str = "Request failed due to status code " + optInt + " in message";
                    CBLogging.m8154b("CBRequest", str);
                    return C2212t0.m8773a(new CBError(CBError.C2085b.UNEXPECTED_RESPONSE, str));
                }
            }
            return C2212t0.m8774a(jSONObject);
        } catch (Exception e) {
            C2098a.m8288a((Class) getClass(), "parseServerResponse", e);
            return C2212t0.m8773a(new CBError(CBError.C2085b.MISCELLANEOUS, e.getLocalizedMessage()));
        }
    }

    /* renamed from: a */
    public void mo9292a(JSONObject jSONObject, C2215u0 u0Var) {
        CBLogging.m8158d("CBRequest", "Request success: " + this.f7433b + " status: " + u0Var.f7464a);
        C2129a aVar = this.f7129l;
        if (!(aVar == null || jSONObject == null)) {
            aVar.mo9300a(this, jSONObject);
        }
        if (this.f7132o != null) {
            m8454a(u0Var, (CBError) null);
        }
    }

    /* renamed from: a */
    public void mo9291a(CBError cBError, C2215u0 u0Var) {
        if (cBError != null) {
            CBLogging.m8158d("CBRequest", "Request failure: " + this.f7433b + " status: " + cBError.mo9115b());
            C2129a aVar = this.f7129l;
            if (aVar != null) {
                aVar.mo9299a(this, cBError);
            }
            if (this.f7132o != null) {
                m8454a(u0Var, cBError);
            }
        }
    }
}
