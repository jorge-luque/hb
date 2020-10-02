package com.applovin.impl.sdk.p052d;

import com.applovin.impl.adview.C1548c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1955n;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p049ad.C1818b;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p049ad.C1823f;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.p051c.C1860h;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.m */
public class C1896m extends C1864a {

    /* renamed from: a */
    private final C1821d f6265a;

    /* renamed from: c */
    private final AppLovinAdLoadListener f6266c;

    /* renamed from: d */
    private boolean f6267d;

    public C1896m(C1821d dVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        this(dVar, appLovinAdLoadListener, "TaskFetchNextAd", jVar);
    }

    C1896m(C1821d dVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, C1941j jVar) {
        super(str, jVar);
        this.f6267d = false;
        this.f6265a = dVar;
        this.f6266c = appLovinAdLoadListener;
    }

    /* renamed from: a */
    private void m7304a(C1860h hVar) {
        long b = hVar.mo8390b(C1859g.f6188c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.f6217b.mo8549a(C1841c.f5961dD)).intValue())) {
            hVar.mo8392b(C1859g.f6188c, currentTimeMillis);
            hVar.mo8394c(C1859g.f6189d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7307b(int i) {
        boolean z = i != 204;
        C1977q v = mo8409d().mo8602v();
        String e = mo8411e();
        Boolean valueOf = Boolean.valueOf(z);
        v.mo8738a(e, valueOf, "Unable to fetch " + this.f6265a + " ad: server returned " + i);
        if (i == -800) {
            this.f6217b.mo8534M().mo8387a(C1859g.f6193h);
        }
        this.f6217b.mo8544W().mo8189a(this.f6265a, m7309i(), i);
        try {
            mo8462a(i);
        } catch (Throwable th) {
            C1977q.m7747c(mo8411e(), "Unable process a failure to receive an ad", th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7308b(JSONObject jSONObject) {
        C1992h.m7858d(jSONObject, this.f6217b);
        C1992h.m7857c(jSONObject, this.f6217b);
        C1992h.m7862f(jSONObject, this.f6217b);
        C1821d.m6863a(jSONObject, this.f6217b);
        this.f6217b.mo8533L().mo8474a(mo8461a(jSONObject));
    }

    /* renamed from: i */
    private boolean m7309i() {
        return (this instanceof C1899o) || (this instanceof C1895l);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1864a mo8461a(JSONObject jSONObject) {
        C1823f.C1825a aVar = new C1823f.C1825a(this.f6265a, this.f6266c, this.f6217b);
        aVar.mo8198a(m7309i());
        return new C1913t(jSONObject, this.f6265a, mo8460b(), aVar, this.f6217b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, String> mo8459a() {
        HashMap hashMap = new HashMap(4);
        hashMap.put("zone_id", C2025o.m7966e(this.f6265a.mo8174a()));
        if (this.f6265a.mo8176c() != null) {
            hashMap.put("size", this.f6265a.mo8176c().getLabel());
        }
        if (this.f6265a.mo8177d() != null) {
            hashMap.put("require", this.f6265a.mo8177d().getLabel());
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5827aa)).booleanValue()) {
            hashMap.put("n", String.valueOf(this.f6217b.mo8566ab().mo8845a(this.f6265a.mo8174a())));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8462a(int i) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f6266c;
        if (appLovinAdLoadListener == null) {
            return;
        }
        if (appLovinAdLoadListener instanceof C1955n) {
            ((C1955n) appLovinAdLoadListener).mo8326a(this.f6265a, i);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
    }

    /* renamed from: a */
    public void mo8463a(boolean z) {
        this.f6267d = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1818b mo8460b() {
        return this.f6265a.mo8185j() ? C1818b.APPLOVIN_PRIMARY_ZONE : C1818b.APPLOVIN_CUSTOM_ZONE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo8464c() {
        return C1992h.m7863g(this.f6217b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo8465h() {
        return C1992h.m7865h(this.f6217b);
    }

    public void run() {
        String str;
        StringBuilder sb;
        if (this.f6267d) {
            sb = new StringBuilder();
            str = "Preloading next ad of zone: ";
        } else {
            sb = new StringBuilder();
            str = "Fetching next ad of zone: ";
        }
        sb.append(str);
        sb.append(this.f6265a);
        mo8405a(sb.toString());
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5982dY)).booleanValue() && C2029r.m8036d()) {
            mo8405a("User is connected to a VPN");
        }
        C1860h M = this.f6217b.mo8534M();
        M.mo8387a(C1859g.f6186a);
        if (M.mo8390b(C1859g.f6188c) == 0) {
            M.mo8392b(C1859g.f6188c, System.currentTimeMillis());
        }
        try {
            Map<String, String> a = this.f6217b.mo8536O().mo8612a(mo8459a(), this.f6267d, false);
            Map<String, String> map = null;
            if (((Boolean) this.f6217b.mo8549a(C1841c.f6045ej)).booleanValue()) {
                map = C1548c.m5992b(((Long) this.f6217b.mo8549a(C1841c.f6046ek)).longValue());
            }
            m7304a(M);
            C18971 r2 = new C1921y<JSONObject>(C1960b.m7596a(this.f6217b).mo8663a(mo8464c()).mo8664a(a).mo8673c(mo8465h()).mo8669b("GET").mo8670b(map).mo8662a(new JSONObject()).mo8661a(((Integer) this.f6217b.mo8549a(C1841c.f6004du)).intValue()).mo8668b(((Integer) this.f6217b.mo8549a(C1841c.f6003dt)).intValue()).mo8671b(true).mo8667a(), this.f6217b) {
                /* renamed from: a */
                public void mo7627a(int i) {
                    C1896m.this.m7307b(i);
                }

                /* renamed from: a */
                public void mo7628a(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        C1993i.m7902b(jSONObject, "ad_fetch_latency_millis", this.f6352d.mo8634a(), this.f6217b);
                        C1993i.m7902b(jSONObject, "ad_fetch_response_size", this.f6352d.mo8635b(), this.f6217b);
                        C1896m.this.m7308b(jSONObject);
                        return;
                    }
                    C1896m.this.m7307b(i);
                }
            };
            r2.mo8496a(C1841c.f5809aI);
            r2.mo8498b(C1841c.f5810aJ);
            this.f6217b.mo8533L().mo8474a((C1864a) r2);
        } catch (Throwable th) {
            mo8406a("Unable to fetch ad " + this.f6265a, th);
            m7307b(0);
        }
    }
}
