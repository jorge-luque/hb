package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.network.C1956a;
import com.applovin.impl.sdk.p048a.C1814c;
import com.applovin.impl.sdk.p050b.C1841c;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.af */
public abstract class C1873af extends C1869ac {
    protected C1873af(String str, C1941j jVar) {
        super(str, jVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7220b(JSONObject jSONObject) {
        C1814c c = m7221c(jSONObject);
        if (c != null) {
            mo7872a(c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001b */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.impl.sdk.p048a.C1814c m7221c(org.json.JSONObject r3) {
        /*
            r2 = this;
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.C1992h.m7848a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x002d }
            com.applovin.impl.sdk.j r1 = r2.f6217b     // Catch:{ JSONException -> 0x002d }
            com.applovin.impl.sdk.utils.C1992h.m7858d(r0, r1)     // Catch:{ JSONException -> 0x002d }
            com.applovin.impl.sdk.j r1 = r2.f6217b     // Catch:{ JSONException -> 0x002d }
            com.applovin.impl.sdk.utils.C1992h.m7857c(r3, r1)     // Catch:{ JSONException -> 0x002d }
            java.lang.String r3 = "params"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x001b }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ all -> 0x001b }
            java.util.Map r3 = com.applovin.impl.sdk.utils.C1993i.m7879a((org.json.JSONObject) r3)     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            java.util.Map r3 = java.util.Collections.emptyMap()     // Catch:{ JSONException -> 0x002d }
        L_0x001f:
            java.lang.String r1 = "result"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            java.lang.String r0 = "network_timeout"
        L_0x0028:
            com.applovin.impl.sdk.a.c r3 = com.applovin.impl.sdk.p048a.C1814c.m6809a(r0, r3)     // Catch:{ JSONException -> 0x002d }
            return r3
        L_0x002d:
            r3 = move-exception
            java.lang.String r0 = "Unable to parse API response"
            r2.mo8406a(r0, r3)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p052d.C1873af.m7221c(org.json.JSONObject):com.applovin.impl.sdk.a.c");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7872a(C1814c cVar);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract boolean mo7873b();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public int mo8414h() {
        return ((Integer) this.f6217b.mo8549a(C1841c.f5862bI)).intValue();
    }

    public void run() {
        mo8419a(mo8420i(), new C1956a.C1959c<JSONObject>() {
            /* renamed from: a */
            public void mo7627a(int i) {
                if (!C1873af.this.mo7873b()) {
                    C1873af.this.mo7867a(i);
                }
            }

            /* renamed from: a */
            public void mo7628a(JSONObject jSONObject, int i) {
                if (!C1873af.this.mo7873b()) {
                    C1873af.this.m7220b(jSONObject);
                }
            }
        });
    }
}
