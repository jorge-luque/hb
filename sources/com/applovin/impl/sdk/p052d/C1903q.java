package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1945k;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p049ad.C1823f;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.q */
public class C1903q extends C1864a {

    /* renamed from: a */
    private final C1823f.C1826b f6273a;

    /* renamed from: c */
    private final C1823f.C1826b f6274c;

    /* renamed from: d */
    private final JSONArray f6275d;

    /* renamed from: e */
    private final MaxAdFormat f6276e;

    public C1903q(C1823f.C1826b bVar, C1823f.C1826b bVar2, JSONArray jSONArray, MaxAdFormat maxAdFormat, C1941j jVar) {
        super("TaskFlushZones", jVar);
        this.f6273a = bVar;
        this.f6274c = bVar2;
        this.f6275d = jSONArray;
        this.f6276e = maxAdFormat;
    }

    /* renamed from: a */
    private Map<String, String> m7333a() {
        Map<String, String> a = this.f6217b.mo8536O().mo8614c().mo8617a();
        a.putAll(this.f6217b.mo8536O().mo8613b().mo8618a());
        if (!((Boolean) this.f6217b.mo8549a(C1841c.f6020eK)).booleanValue()) {
            a.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f6217b.mo8599t());
        }
        a.put("api_did", this.f6217b.mo8549a(C1841c.f5792S));
        m7334a(a);
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5968dK)).booleanValue()) {
            C2029r.m8011a("cuid", this.f6217b.mo8588i(), a);
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5971dN)).booleanValue()) {
            a.put("compass_random_token", this.f6217b.mo8589j());
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5973dP)).booleanValue()) {
            a.put("applovin_random_token", this.f6217b.mo8590k());
        }
        a.put("sc", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5796W)));
        a.put("sc2", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5797X)));
        a.put("sc3", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5798Y)));
        a.put("server_installed_at", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5799Z)));
        C2029r.m8011a("persisted_data", C2025o.m7966e((String) this.f6217b.mo8550a(C1843e.f6111y)), a);
        return a;
    }

    /* renamed from: a */
    private void m7334a(Map<String, String> map) {
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

    /* renamed from: b */
    private JSONObject m7335b() {
        JSONObject jSONObject = new JSONObject();
        C1993i.m7902b(jSONObject, "ts_s", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), this.f6217b);
        if (this.f6273a != C1823f.C1826b.UNKNOWN_ZONE) {
            C1993i.m7886a(jSONObject, "format", this.f6276e.getLabel(), this.f6217b);
            C1993i.m7884a(jSONObject, "previous_trigger_code", this.f6274c.mo8199a(), this.f6217b);
            C1993i.m7886a(jSONObject, "previous_trigger_reason", this.f6274c.mo8200b(), this.f6217b);
        }
        C1993i.m7884a(jSONObject, "trigger_code", this.f6273a.mo8199a(), this.f6217b);
        C1993i.m7886a(jSONObject, "trigger_reason", this.f6273a.mo8200b(), this.f6217b);
        C1993i.m7887a(jSONObject, "zones", this.f6275d, this.f6217b);
        return jSONObject;
    }

    public void run() {
        Map<String, String> a = m7333a();
        JSONObject b = m7335b();
        String a2 = C1992h.m7847a((String) this.f6217b.mo8549a(C1841c.f6068fg), "1.0/flush_zones", this.f6217b);
        C19041 r1 = new C1921y<JSONObject>(C1960b.m7596a(this.f6217b).mo8663a(a2).mo8673c(C1992h.m7847a((String) this.f6217b.mo8549a(C1841c.f6069fh), "1.0/flush_zones", this.f6217b)).mo8664a(a).mo8665a(b).mo8669b("POST").mo8662a(new JSONObject()).mo8668b(((Integer) this.f6217b.mo8549a(C1841c.f6070fi)).intValue()).mo8667a(), this.f6217b) {
            /* renamed from: a */
            public void mo7627a(int i) {
            }

            /* renamed from: a */
            public void mo7628a(JSONObject jSONObject, int i) {
                C1992h.m7858d(jSONObject, this.f6217b);
            }
        };
        r1.mo8496a(C1841c.f5815aO);
        r1.mo8498b(C1841c.f5816aP);
        this.f6217b.mo8533L().mo8474a((C1864a) r1);
    }
}
