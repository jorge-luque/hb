package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p050b.C1844f;

/* renamed from: com.applovin.impl.sdk.utils.q */
public final class C2028q {

    /* renamed from: a */
    private final C1941j f6736a;

    /* renamed from: b */
    private String f6737b = m7979d();

    /* renamed from: c */
    private final String f6738c;

    /* renamed from: d */
    private final String f6739d;

    public C2028q(C1941j jVar) {
        this.f6736a = jVar;
        this.f6738c = m7978a(C1843e.f6091e, (String) C1844f.m7060b(C1843e.f6090d, null, jVar.mo8527E()));
        this.f6739d = m7978a(C1843e.f6092f, (String) jVar.mo8549a(C1841c.f5792S));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.applovin.impl.sdk.b.e, com.applovin.impl.sdk.b.e<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m7978a(com.applovin.impl.sdk.p050b.C1843e<java.lang.String> r3, java.lang.String r4) {
        /*
            r2 = this;
            com.applovin.impl.sdk.j r0 = r2.f6736a
            android.content.Context r0 = r0.mo8527E()
            r1 = 0
            java.lang.Object r0 = com.applovin.impl.sdk.p050b.C1844f.m7060b(r3, r1, (android.content.Context) r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = com.applovin.impl.sdk.utils.C2025o.m7963b(r0)
            if (r1 == 0) goto L_0x0014
            return r0
        L_0x0014:
            boolean r0 = com.applovin.impl.sdk.utils.C2025o.m7963b(r4)
            if (r0 == 0) goto L_0x001b
            goto L_0x0029
        L_0x001b:
            java.util.UUID r4 = java.util.UUID.randomUUID()
            java.lang.String r4 = r4.toString()
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r4 = r4.toLowerCase(r0)
        L_0x0029:
            com.applovin.impl.sdk.j r0 = r2.f6736a
            android.content.Context r0 = r0.mo8527E()
            com.applovin.impl.sdk.p050b.C1844f.m7058a(r3, r4, (android.content.Context) r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C2028q.m7978a(com.applovin.impl.sdk.b.e, java.lang.String):java.lang.String");
    }

    /* renamed from: d */
    private String m7979d() {
        if (!((Boolean) this.f6736a.mo8549a(C1841c.f5974dQ)).booleanValue()) {
            this.f6736a.mo8578b(C1843e.f6089c);
        }
        String str = (String) this.f6736a.mo8550a(C1843e.f6089c);
        if (!C2025o.m7963b(str)) {
            return null;
        }
        C1977q v = this.f6736a.mo8602v();
        v.mo8742b("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        this.f6737b = str;
        return null;
    }

    /* renamed from: a */
    public String mo8816a() {
        return this.f6737b;
    }

    /* renamed from: a */
    public void mo8817a(String str) {
        if (((Boolean) this.f6736a.mo8549a(C1841c.f5974dQ)).booleanValue()) {
            this.f6736a.mo8556a(C1843e.f6089c, str);
        }
        this.f6737b = str;
    }

    /* renamed from: b */
    public String mo8818b() {
        return this.f6738c;
    }

    /* renamed from: c */
    public String mo8819c() {
        return this.f6739d;
    }
}
