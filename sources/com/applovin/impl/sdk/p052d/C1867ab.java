package com.applovin.impl.sdk.p052d;

import com.applovin.impl.p033a.C1482c;
import com.applovin.impl.p033a.C1483d;
import com.applovin.impl.p033a.C1489i;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.impl.sdk.utils.C2032t;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.d.ab */
class C1867ab extends C1864a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1482c f6222a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinAdLoadListener f6223c;

    C1867ab(C1482c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        super("TaskResolveVastWrapper", jVar);
        this.f6223c = appLovinAdLoadListener;
        this.f6222a = cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7199a(int i) {
        mo8410d("Failed to resolve VAST wrapper due to error code " + i);
        if (i == -103) {
            C2029r.m8008a(this.f6223c, this.f6222a.mo7196g(), i, this.f6217b);
        } else {
            C1489i.m5784a(this.f6222a, this.f6223c, i == -102 ? C1483d.TIMED_OUT : C1483d.GENERAL_WRAPPER_ERROR, i, this.f6217b);
        }
    }

    public void run() {
        String a = C1489i.m5780a(this.f6222a);
        if (C2025o.m7963b(a)) {
            mo8405a("Resolving VAST ad with depth " + this.f6222a.mo7190a() + " at " + a);
            try {
                this.f6217b.mo8533L().mo8474a((C1864a) new C1921y<C2032t>(C1960b.m7596a(this.f6217b).mo8663a(a).mo8669b("GET").mo8662a(C2032t.f6742a).mo8661a(((Integer) this.f6217b.mo8549a(C1841c.f6018eI)).intValue()).mo8668b(((Integer) this.f6217b.mo8549a(C1841c.f6019eJ)).intValue()).mo8666a(false).mo8667a(), this.f6217b) {
                    /* renamed from: a */
                    public void mo7627a(int i) {
                        mo8410d("Unable to resolve VAST wrapper. Server returned " + i);
                        C1867ab.this.m7199a(i);
                    }

                    /* renamed from: a */
                    public void mo7628a(C2032t tVar, int i) {
                        this.f6217b.mo8533L().mo8474a((C1864a) C1914u.m7369a(tVar, C1867ab.this.f6222a, C1867ab.this.f6223c, C1867ab.this.f6217b));
                    }
                });
            } catch (Throwable th) {
                mo8406a("Unable to resolve VAST wrapper", th);
            }
        } else {
            mo8410d("Resolving VAST failed. Could not find resolution URL");
            m7199a(-1);
        }
    }
}
