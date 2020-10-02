package com.applovin.impl.sdk.p052d;

import android.os.Build;
import com.applovin.impl.mediation.p047d.C1728b;
import com.applovin.impl.mediation.p047d.C1729c;
import com.applovin.impl.sdk.C1928g;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1945k;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.security.ProviderInstaller;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.k */
public class C1892k extends C1864a {

    /* renamed from: a */
    private static int f6259a;

    /* renamed from: c */
    private static final AtomicBoolean f6260c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AtomicBoolean f6261d = new AtomicBoolean();

    /* renamed from: com.applovin.impl.sdk.d.k$a */
    private class C1894a extends C1864a {
        public C1894a(C1941j jVar) {
            super("TaskTimeoutFetchBasicSettings", jVar, true);
        }

        public void run() {
            if (!C1892k.this.f6261d.get()) {
                mo8410d("Timing out fetch basic settings...");
                C1892k.this.m7293a(new JSONObject());
            }
        }
    }

    public C1892k(C1941j jVar) {
        super("TaskFetchBasicSettings", jVar, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7293a(JSONObject jSONObject) {
        boolean z = true;
        if (this.f6261d.compareAndSet(false, true)) {
            C1992h.m7858d(jSONObject, this.f6217b);
            C1992h.m7857c(jSONObject, this.f6217b);
            if (jSONObject.length() <= 0) {
                z = false;
            }
            C1992h.m7850a(jSONObject, z, this.f6217b);
            C1728b.m6615a(jSONObject, this.f6217b);
            C1728b.m6617b(jSONObject, this.f6217b);
            mo8407b("Executing initialize SDK...");
            this.f6217b.mo8523A().mo7630a(C1993i.m7871a(jSONObject, "smd", (Boolean) false, this.f6217b).booleanValue());
            C1992h.m7864g(jSONObject, this.f6217b);
            C1992h.m7860e(jSONObject, this.f6217b);
            this.f6217b.mo8563a(jSONObject);
            this.f6217b.mo8533L().mo8474a((C1864a) new C1905r(this.f6217b));
            C1992h.m7862f(jSONObject, this.f6217b);
            mo8407b("Finished executing initialize SDK");
        }
    }

    /* renamed from: c */
    private String m7294c() {
        return C1992h.m7847a((String) this.f6217b.mo8549a(C1841c.f5807aG), "5.0/i", mo8409d());
    }

    /* renamed from: h */
    private String m7295h() {
        return C1992h.m7847a((String) this.f6217b.mo8549a(C1841c.f5808aH), "5.0/i", mo8409d());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo8454a() {
        HashMap hashMap = new HashMap();
        hashMap.put("rid", UUID.randomUUID().toString());
        if (!((Boolean) this.f6217b.mo8549a(C1841c.f6020eK)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f6217b.mo8599t());
        }
        Boolean a = C1928g.m7409a(mo8412f());
        if (a != null) {
            hashMap.put("huc", a.toString());
        }
        Boolean b = C1928g.m7413b(mo8412f());
        if (b != null) {
            hashMap.put("aru", b.toString());
        }
        Boolean c = C1928g.m7415c(mo8412f());
        if (c != null) {
            hashMap.put("dns", c.toString());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONObject mo8455b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            jSONObject.put("build", String.valueOf(131));
            int i = f6259a + 1;
            f6259a = i;
            jSONObject.put("init_count", String.valueOf(i));
            jSONObject.put("server_installed_at", C2025o.m7966e((String) this.f6217b.mo8549a(C1841c.f5799Z)));
            if (this.f6217b.mo8530I()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f6217b.mo8531J()) {
                jSONObject.put("first_install_v2", true);
            }
            String str = (String) this.f6217b.mo8549a(C1841c.f5975dR);
            if (C2025o.m7963b(str)) {
                jSONObject.put("plugin_version", C2025o.m7966e(str));
            }
            String n = this.f6217b.mo8593n();
            if (C2025o.m7963b(n)) {
                jSONObject.put("mediation_provider", C2025o.m7966e(n));
            }
            C1729c.C1731a a = C1729c.m6620a(this.f6217b);
            jSONObject.put("installed_mediation_adapters", a.mo7874a());
            jSONObject.put("uninstalled_mediation_adapter_classnames", a.mo7875b());
            C1945k.C1948b c = this.f6217b.mo8536O().mo8614c();
            jSONObject.put("package_name", C2025o.m7966e(c.f6471c));
            jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, C2025o.m7966e(c.f6470b));
            jSONObject.put("test_ads", c.f6477i);
            jSONObject.put("debug", String.valueOf(c.f6475g));
            jSONObject.put(TapjoyConstants.TJC_PLATFORM, "android");
            jSONObject.put("os", C2025o.m7966e(Build.VERSION.RELEASE));
            jSONObject.put("tg", C2029r.m7996a(C1843e.f6093g, this.f6217b));
            jSONObject.put("ltg", C2029r.m7996a(C1843e.f6094h, this.f6217b));
            if (((Boolean) this.f6217b.mo8549a(C1841c.f5970dM)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f6217b.mo8589j());
            }
            if (((Boolean) this.f6217b.mo8549a(C1841c.f5972dO)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f6217b.mo8590k());
            }
        } catch (JSONException e) {
            mo8406a("Failed to construct JSON body", e);
        }
        return jSONObject;
    }

    public void run() {
        if (f6260c.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(this.f6217b.mo8527E());
            } catch (Throwable th) {
                mo8406a("Cannot update security provider", th);
            }
        }
        Map<String, String> a = mo8454a();
        C1960b<T> a2 = C1960b.m7596a(this.f6217b).mo8663a(m7294c()).mo8673c(m7295h()).mo8664a(a).mo8665a(mo8455b()).mo8669b("POST").mo8662a(new JSONObject()).mo8661a(((Integer) this.f6217b.mo8549a(C1841c.f6008dy)).intValue()).mo8672c(((Integer) this.f6217b.mo8549a(C1841c.f5959dB)).intValue()).mo8668b(((Integer) this.f6217b.mo8549a(C1841c.f6007dx)).intValue()).mo8671b(true).mo8667a();
        this.f6217b.mo8533L().mo8476a(new C1894a(this.f6217b), C1907s.C1909a.f6310b, ((long) ((Integer) this.f6217b.mo8549a(C1841c.f6007dx)).intValue()) + 250);
        C18931 r1 = new C1921y<JSONObject>(a2, this.f6217b, mo8413g()) {
            /* renamed from: a */
            public void mo7627a(int i) {
                mo8410d("Unable to fetch basic SDK settings: server returned " + i);
                C1892k.this.m7293a(new JSONObject());
            }

            /* renamed from: a */
            public void mo7628a(JSONObject jSONObject, int i) {
                C1892k.this.m7293a(jSONObject);
            }
        };
        r1.mo8496a(C1841c.f5809aI);
        r1.mo8498b(C1841c.f5810aJ);
        this.f6217b.mo8533L().mo8474a((C1864a) r1);
    }
}
