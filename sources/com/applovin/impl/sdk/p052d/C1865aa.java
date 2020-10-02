package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.network.C1956a;
import com.applovin.impl.sdk.p048a.C1814c;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1993i;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.aa */
public abstract class C1865aa extends C1869ac {
    protected C1865aa(String str, C1941j jVar) {
        super(str, jVar);
    }

    /* renamed from: a */
    private JSONObject m7190a(C1814c cVar) {
        JSONObject i = mo8420i();
        C1993i.m7886a(i, "result", cVar.mo8102b(), this.f6217b);
        Map<String, String> a = cVar.mo8101a();
        if (a != null) {
            C1993i.m7888a(i, NativeProtocol.WEB_DIALOG_PARAMS, new JSONObject(a), this.f6217b);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract C1814c mo7869b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo7870b(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo7871c();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public int mo8414h() {
        return ((Integer) this.f6217b.mo8549a(C1841c.f5863bJ)).intValue();
    }

    public void run() {
        C1814c b = mo7869b();
        if (b != null) {
            mo8419a(m7190a(b), new C1956a.C1959c<JSONObject>() {
                /* renamed from: a */
                public void mo7627a(int i) {
                    C1865aa.this.mo7867a(i);
                }

                /* renamed from: a */
                public void mo7628a(JSONObject jSONObject, int i) {
                    C1865aa.this.mo7870b(jSONObject);
                }
            });
        } else {
            mo7871c();
        }
    }
}
