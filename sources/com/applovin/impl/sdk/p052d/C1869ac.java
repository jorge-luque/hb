package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.network.C1956a;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.ac */
public abstract class C1869ac extends C1864a {
    protected C1869ac(String str, C1941j jVar) {
        super(str, jVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo7866a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7867a(int i) {
        C1992h.m7849a(i, this.f6217b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7868a(JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8419a(JSONObject jSONObject, final C1956a.C1959c<JSONObject> cVar) {
        C18701 r0 = new C1921y<JSONObject>(C1960b.m7596a(this.f6217b).mo8663a(C1992h.m7846a(mo7866a(), this.f6217b)).mo8673c(C1992h.m7856b(mo7866a(), this.f6217b)).mo8664a(C1992h.m7859e(this.f6217b)).mo8669b("POST").mo8665a(jSONObject).mo8662a(new JSONObject()).mo8661a(mo8414h()).mo8667a(), this.f6217b) {
            /* renamed from: a */
            public void mo7627a(int i) {
                cVar.mo7627a(i);
            }

            /* renamed from: a */
            public void mo7628a(JSONObject jSONObject, int i) {
                cVar.mo7628a(jSONObject, i);
            }
        };
        r0.mo8496a(C1841c.f5811aK);
        r0.mo8498b(C1841c.f5812aL);
        this.f6217b.mo8533L().mo8474a((C1864a) r0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public abstract int mo8414h();

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public JSONObject mo8420i() {
        JSONObject jSONObject = new JSONObject();
        String i = this.f6217b.mo8588i();
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5969dL)).booleanValue() && C2025o.m7963b(i)) {
            C1993i.m7886a(jSONObject, "cuid", i, this.f6217b);
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5971dN)).booleanValue()) {
            C1993i.m7886a(jSONObject, "compass_random_token", this.f6217b.mo8589j(), this.f6217b);
        }
        if (((Boolean) this.f6217b.mo8549a(C1841c.f5973dP)).booleanValue()) {
            C1993i.m7886a(jSONObject, "applovin_random_token", this.f6217b.mo8590k(), this.f6217b);
        }
        mo7868a(jSONObject);
        return jSONObject;
    }
}
