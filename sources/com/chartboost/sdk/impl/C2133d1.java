package com.chartboost.sdk.impl;

import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Libraries.C2074d;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C2092g;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2128c1;
import com.facebook.appevents.UserDataStore;
import com.facebook.places.model.PlaceFields;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.d1 */
public final class C2133d1 extends C2128c1 {

    /* renamed from: p */
    private final JSONObject f7140p = new JSONObject();

    /* renamed from: q */
    private final JSONObject f7141q = new JSONObject();

    /* renamed from: r */
    private final JSONObject f7142r = new JSONObject();

    /* renamed from: s */
    private final JSONObject f7143s = new JSONObject();

    public C2133d1(String str, C2092g gVar, C2098a aVar, int i, C2128c1.C2129a aVar2) {
        super("https://live.chartboost.com", str, gVar, aVar, i, aVar2);
    }

    /* renamed from: a */
    public void mo9315a(String str, Object obj, int i) {
        if (i == 0) {
            C2076e.m8187a(this.f7143s, str, obj);
            mo9294a("ad", (Object) this.f7143s);
        }
    }

    /* renamed from: c */
    public void mo9296c() {
        C2076e.m8187a(this.f7141q, TapjoyConstants.TJC_APP_PLACEMENT, this.f7131n.f6988s);
        C2076e.m8187a(this.f7141q, TJAdUnitConstants.String.BUNDLE, this.f7131n.f6979j);
        C2076e.m8187a(this.f7141q, "bundle_id", this.f7131n.f6980k);
        C2076e.m8187a(this.f7141q, "custom_id", C2242k.f7602b);
        C2076e.m8187a(this.f7141q, TapjoyConstants.TJC_SESSION_ID, "");
        C2076e.m8187a(this.f7141q, "ui", -1);
        C2076e.m8187a(this.f7141q, "test_mode", false);
        mo9294a(TapjoyConstants.TJC_APP_PLACEMENT, (Object) this.f7141q);
        boolean z = true;
        C2076e.m8187a(this.f7142r, "carrier", C2076e.m8186a(C2076e.m8184a((String) TapjoyConstants.TJC_CARRIER_NAME, (Object) this.f7131n.f6991v.optString("carrier-name")), C2076e.m8184a((String) TapjoyConstants.TJC_MOBILE_COUNTRY_CODE, (Object) this.f7131n.f6991v.optString("mobile-country-code")), C2076e.m8184a((String) TapjoyConstants.TJC_MOBILE_NETWORK_CODE, (Object) this.f7131n.f6991v.optString("mobile-network-code")), C2076e.m8184a("iso_country_code", (Object) this.f7131n.f6991v.optString("iso-country-code")), C2076e.m8184a("phone_type", (Object) Integer.valueOf(this.f7131n.f6991v.optInt("phone-type")))));
        C2076e.m8187a(this.f7142r, "model", this.f7131n.f6975f);
        C2076e.m8187a(this.f7142r, TapjoyConstants.TJC_DEVICE_TYPE_NAME, this.f7131n.f6989t);
        C2076e.m8187a(this.f7142r, "actual_device_type", this.f7131n.f6990u);
        C2076e.m8187a(this.f7142r, "os", this.f7131n.f6976g);
        C2076e.m8187a(this.f7142r, UserDataStore.COUNTRY, this.f7131n.f6977h);
        C2076e.m8187a(this.f7142r, "language", this.f7131n.f6978i);
        C2076e.m8187a(this.f7142r, "timestamp", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.f7131n.f6974e.mo9110a())));
        C2076e.m8187a(this.f7142r, "reachability", Integer.valueOf(this.f7131n.f6971b.mo9537a()));
        C2076e.m8187a(this.f7142r, "scale", this.f7131n.f6987r);
        C2076e.m8187a(this.f7142r, "is_portrait", Boolean.valueOf(CBUtility.m8171b(CBUtility.m8174e())));
        C2076e.m8187a(this.f7142r, "rooted_device", Boolean.valueOf(this.f7131n.f6993x));
        C2076e.m8187a(this.f7142r, TapjoyConstants.TJC_DEVICE_TIMEZONE, this.f7131n.f6994y);
        C2076e.m8187a(this.f7142r, "mobile_network", this.f7131n.f6995z);
        C2076e.m8187a(this.f7142r, "dw", this.f7131n.f6984o);
        C2076e.m8187a(this.f7142r, "dh", this.f7131n.f6985p);
        C2076e.m8187a(this.f7142r, "dpi", this.f7131n.f6986q);
        C2076e.m8187a(this.f7142r, "w", this.f7131n.f6982m);
        C2076e.m8187a(this.f7142r, "h", this.f7131n.f6983n);
        C2076e.m8187a(this.f7142r, "user_agent", C2242k.f7621u);
        C2076e.m8187a(this.f7142r, "device_family", "");
        C2076e.m8187a(this.f7142r, "retina", false);
        C2074d.C2075a a = this.f7131n.f6970a.mo9086a();
        C2076e.m8187a(this.f7142r, "identity", a.f6859b);
        int i = a.f6858a;
        if (i != -1) {
            if (i != 1) {
                z = false;
            }
            C2076e.m8187a(this.f7142r, "limit_ad_tracking", Boolean.valueOf(z));
        }
        C2076e.m8187a(this.f7142r, "pidatauseconsent", Integer.valueOf(C2242k.f7622v.getValue()));
        mo9294a(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, (Object) this.f7142r);
        C2076e.m8187a(this.f7140p, "sdk", this.f7131n.f6981l);
        if (C2242k.f7605e != null) {
            C2076e.m8187a(this.f7140p, "framework_version", C2242k.f7607g);
            C2076e.m8187a(this.f7140p, "wrapper_version", C2242k.f7603c);
        }
        C2149g1 g1Var = C2242k.f7609i;
        if (g1Var != null) {
            C2076e.m8187a(this.f7140p, "mediation", g1Var.mo9352b());
            C2076e.m8187a(this.f7140p, "mediation_version", C2242k.f7609i.mo9353c());
            C2076e.m8187a(this.f7140p, TapjoyConstants.TJC_ADAPTER_VERSION, C2242k.f7609i.mo9351a());
        }
        C2076e.m8187a(this.f7140p, "commit_hash", "a33bc81418271394db93ac3fa0ad3842e5511659");
        String str = this.f7131n.f6972c.get().f7001a;
        if (!C2224x.m8805e().mo9549a((CharSequence) str)) {
            C2076e.m8187a(this.f7140p, "config_variant", str);
        }
        mo9294a("sdk", (Object) this.f7140p);
        C2076e.m8187a(this.f7143s, "session", Integer.valueOf(this.f7131n.f6973d.getInt("cbPrefSessionCount", 0)));
        if (this.f7143s.isNull("cache")) {
            C2076e.m8187a(this.f7143s, "cache", false);
        }
        if (this.f7143s.isNull("amount")) {
            C2076e.m8187a(this.f7143s, "amount", 0);
        }
        if (this.f7143s.isNull("retry_count")) {
            C2076e.m8187a(this.f7143s, "retry_count", 0);
        }
        if (this.f7143s.isNull(PlaceFields.LOCATION)) {
            C2076e.m8187a(this.f7143s, PlaceFields.LOCATION, "");
        }
        mo9294a("ad", (Object) this.f7143s);
    }
}
