package com.applovin.impl.sdk.p052d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1945k;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.appevents.AppEventsConstants;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.p */
public class C1900p extends C1864a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1902a f6271a;

    /* renamed from: com.applovin.impl.sdk.d.p$a */
    public interface C1902a {
        /* renamed from: a */
        void mo8068a();
    }

    public C1900p(C1941j jVar, C1902a aVar) {
        super("TaskFetchVariables", jVar);
        this.f6271a = aVar;
    }

    /* renamed from: a */
    private Map<String, String> m7327a() {
        C1945k O = this.f6217b.mo8536O();
        C1945k.C1950d b = O.mo8613b();
        C1945k.C1948b c = O.mo8614c();
        HashMap hashMap = new HashMap();
        hashMap.put(TapjoyConstants.TJC_PLATFORM, C2025o.m7966e(b.f6498a));
        hashMap.put("model", C2025o.m7966e(b.f6501d));
        hashMap.put("api_level", String.valueOf(b.f6500c));
        hashMap.put("package_name", C2025o.m7966e(c.f6471c));
        hashMap.put("installer_name", C2025o.m7966e(c.f6472d));
        hashMap.put("ia", Long.toString(c.f6476h));
        hashMap.put("api_did", this.f6217b.mo8549a(C1841c.f5792S));
        hashMap.put("brand", C2025o.m7966e(b.f6502e));
        hashMap.put("brand_name", C2025o.m7966e(b.f6503f));
        hashMap.put("hardware", C2025o.m7966e(b.f6504g));
        hashMap.put("revision", C2025o.m7966e(b.f6505h));
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("os", C2025o.m7966e(b.f6499b));
        hashMap.put("orientation_lock", b.f6509l);
        hashMap.put(TapjoyConstants.TJC_APP_VERSION_NAME, C2025o.m7966e(c.f6470b));
        hashMap.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, C2025o.m7966e(b.f6506i));
        hashMap.put("carrier", C2025o.m7966e(b.f6507j));
        hashMap.put("tz_offset", String.valueOf(b.f6515r));
        hashMap.put("aida", String.valueOf(b.f6493N));
        String str = "1";
        hashMap.put("adr", b.f6517t ? str : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("volume", String.valueOf(b.f6521x));
        hashMap.put("sb", String.valueOf(b.f6522y));
        if (!b.f6480A) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        hashMap.put("sim", str);
        hashMap.put("gy", String.valueOf(b.f6481B));
        hashMap.put("is_tablet", String.valueOf(b.f6482C));
        hashMap.put("tv", String.valueOf(b.f6483D));
        hashMap.put("vs", String.valueOf(b.f6484E));
        hashMap.put("lpm", String.valueOf(b.f6485F));
        hashMap.put("tg", c.f6473e);
        hashMap.put("ltg", c.f6474f);
        hashMap.put("fs", String.valueOf(b.f6487H));
        hashMap.put("tds", String.valueOf(b.f6488I));
        hashMap.put("fm", String.valueOf(b.f6489J.f6525b));
        hashMap.put("tm", String.valueOf(b.f6489J.f6524a));
        hashMap.put("lmt", String.valueOf(b.f6489J.f6526c));
        hashMap.put("lm", String.valueOf(b.f6489J.f6527d));
        hashMap.put("adns", String.valueOf(b.f6510m));
        hashMap.put("adnsd", String.valueOf(b.f6511n));
        hashMap.put("xdpi", String.valueOf(b.f6512o));
        hashMap.put("ydpi", String.valueOf(b.f6513p));
        hashMap.put("screen_size_in", String.valueOf(b.f6514q));
        hashMap.put("debug", Boolean.toString(c.f6475g));
        hashMap.put("af", String.valueOf(b.f6519v));
        hashMap.put("font", String.valueOf(b.f6520w));
        hashMap.put("bt_ms", String.valueOf(b.f6496Q));
        hashMap.put("mute_switch", String.valueOf(b.f6497R));
        if (!((Boolean) this.f6217b.mo8549a(C1841c.f6020eK)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f6217b.mo8599t());
        }
        m7328a((Map<String, String>) hashMap);
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5968dK)).booleanValue()) {
            C2029r.m8011a("cuid", this.f6217b.mo8588i(), (Map<String, String>) hashMap);
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5971dN)).booleanValue()) {
            hashMap.put("compass_random_token", this.f6217b.mo8589j());
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5973dP)).booleanValue()) {
            hashMap.put("applovin_random_token", this.f6217b.mo8590k());
        }
        Boolean bool = b.f6490K;
        if (bool != null) {
            hashMap.put("huc", bool.toString());
        }
        Boolean bool2 = b.f6491L;
        if (bool2 != null) {
            hashMap.put("aru", bool2.toString());
        }
        Boolean bool3 = b.f6492M;
        if (bool3 != null) {
            hashMap.put("dns", bool3.toString());
        }
        C1945k.C1949c cVar = b.f6518u;
        if (cVar != null) {
            hashMap.put("act", String.valueOf(cVar.f6478a));
            hashMap.put("acm", String.valueOf(cVar.f6479b));
        }
        String str2 = b.f6523z;
        if (C2025o.m7963b(str2)) {
            hashMap.put("ua", C2025o.m7966e(str2));
        }
        String str3 = b.f6486G;
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("so", C2025o.m7966e(str3));
        }
        float f = b.f6494O;
        if (f > 0.0f) {
            hashMap.put("da", String.valueOf(f));
        }
        float f2 = b.f6495P;
        if (f2 > 0.0f) {
            hashMap.put("dm", String.valueOf(f2));
        }
        hashMap.put("sc", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5796W)));
        hashMap.put("sc2", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5797X)));
        hashMap.put("sc3", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5798Y)));
        hashMap.put("server_installed_at", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5799Z)));
        C2029r.m8011a("persisted_data", C2025o.m7966e((String) this.f6217b.mo8550a(C1843e.f6111y)), (Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: a */
    private void m7328a(Map<String, String> map) {
        try {
            C1945k.C1947a d = this.f6217b.mo8536O().mo8615d();
            String str = d.f6468b;
            if (C2025o.m7963b(str)) {
                map.put(QumparaOfferwallUtil.COLUMN_IDFA, str);
            }
            map.put("dnt", Boolean.toString(d.f6467a));
        } catch (Throwable th) {
            mo8406a("Failed to populate advertising info", th);
        }
    }

    public void run() {
        C19011 r1 = new C1921y<JSONObject>(C1960b.m7596a(this.f6217b).mo8663a(C1992h.m7866i(this.f6217b)).mo8673c(C1992h.m7867j(this.f6217b)).mo8664a(m7327a()).mo8669b("GET").mo8662a(new JSONObject()).mo8668b(((Integer) this.f6217b.mo8549a(C1841c.f5960dC)).intValue()).mo8667a(), this.f6217b) {
            /* renamed from: a */
            public void mo7627a(int i) {
                mo8410d("Unable to fetch variables: server returned " + i);
                C1977q.m7751i("AppLovinVariableService", "Failed to load variables.");
                C1900p.this.f6271a.mo8068a();
            }

            /* renamed from: a */
            public void mo7628a(JSONObject jSONObject, int i) {
                C1992h.m7858d(jSONObject, this.f6217b);
                C1992h.m7857c(jSONObject, this.f6217b);
                C1992h.m7864g(jSONObject, this.f6217b);
                C1900p.this.f6271a.mo8068a();
            }
        };
        r1.mo8496a(C1841c.f5815aO);
        r1.mo8498b(C1841c.f5816aP);
        this.f6217b.mo8533L().mo8474a((C1864a) r1);
    }
}
