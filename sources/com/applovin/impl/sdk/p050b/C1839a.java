package com.applovin.impl.sdk.p050b;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C2029r;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.b.a */
public class C1839a {

    /* renamed from: a */
    private final C1941j f5743a;

    /* renamed from: b */
    private final C1842d f5744b;

    /* renamed from: c */
    private final List<C1841c> f5745c = new ArrayList(25);

    /* renamed from: d */
    private final List<Object> f5746d = new ArrayList(25);

    /* renamed from: e */
    private final Object f5747e = new Object();

    public C1839a(C1842d dVar, C1941j jVar) {
        this.f5743a = jVar;
        this.f5744b = dVar;
        C2029r.m8007a(C1843e.f6094h, 25, jVar);
        m7032a(C1841c.f5827aa, true);
        m7032a(C1841c.f5925cT, true);
        m7032a(C1841c.f6032eW, true);
        m7032a(C1841c.f6033eX, true);
        m7032a(C1841c.f6035eZ, true);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
        m7032a(C1841c.f5789P, (Object) null);
    }

    /* renamed from: a */
    private void m7032a(C1841c cVar, Object obj) {
        this.f5745c.add(cVar);
        this.f5746d.add(obj);
    }

    /* renamed from: a */
    public Object mo8295a(C1841c cVar) {
        synchronized (this.f5747e) {
            int indexOf = this.f5745c.indexOf(cVar);
            if (indexOf == -1) {
                return null;
            }
            Object obj = this.f5746d.get(indexOf);
            return obj;
        }
    }

    /* renamed from: a */
    public void mo8296a() {
        List<String> b = this.f5744b.mo8306b(C1841c.f5790Q);
        int intValue = Integer.valueOf(C2029r.m7996a(C1843e.f6094h, this.f5743a)).intValue();
        int i = 0;
        while (i < 25) {
            C1841c cVar = this.f5745c.get(i);
            int i2 = i + 1;
            if (i2 != intValue || b.contains(cVar.mo8298a())) {
                C1977q v = this.f5743a.mo8602v();
                v.mo8742b("LocalSettingsProvider", "Disabling local setting: " + cVar.mo8298a());
                this.f5745c.set(i, C1841c.f5789P);
            }
            i = i2;
        }
        C1977q v2 = this.f5743a.mo8602v();
        v2.mo8742b("LocalSettingsProvider", "Enabled local settings: " + this.f5745c);
    }
}
