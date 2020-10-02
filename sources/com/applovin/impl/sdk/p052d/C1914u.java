package com.applovin.impl.sdk.p052d;

import com.applovin.impl.p033a.C1482c;
import com.applovin.impl.p033a.C1483d;
import com.applovin.impl.p033a.C1489i;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1818b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2032t;
import com.applovin.impl.sdk.utils.C2033u;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.u */
abstract class C1914u extends C1864a {

    /* renamed from: a */
    private final AppLovinAdLoadListener f6338a;

    /* renamed from: c */
    private final C1915a f6339c;

    /* renamed from: com.applovin.impl.sdk.d.u$a */
    private static final class C1915a extends C1482c {
        C1915a(JSONObject jSONObject, JSONObject jSONObject2, C1818b bVar, C1941j jVar) {
            super(jSONObject, jSONObject2, bVar, jVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8490a(C2032t tVar) {
            if (tVar != null) {
                this.f4621a.add(tVar);
                return;
            }
            throw new IllegalArgumentException("No aggregated vast response specified");
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.u$b */
    private static final class C1916b extends C1914u {

        /* renamed from: a */
        private final JSONObject f6340a;

        C1916b(C1482c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
            super(cVar, appLovinAdLoadListener, jVar);
            if (appLovinAdLoadListener != null) {
                this.f6340a = cVar.mo7192c();
                return;
            }
            throw new IllegalArgumentException("No callback specified.");
        }

        public void run() {
            C1483d dVar;
            mo8405a("Processing SDK JSON response...");
            String b = C1993i.m7896b(this.f6340a, "xml", (String) null, this.f6217b);
            if (!C2025o.m7963b(b)) {
                mo8410d("No VAST response received.");
                dVar = C1483d.NO_WRAPPER_RESPONSE;
            } else if (b.length() < ((Integer) this.f6217b.mo8549a(C1841c.f6011eB)).intValue()) {
                try {
                    mo8489a(C2033u.m8054a(b, this.f6217b));
                    return;
                } catch (Throwable th) {
                    mo8406a("Unable to parse VAST response", th);
                }
            } else {
                mo8410d("VAST response is over max length");
                dVar = C1483d.XML_PARSING;
            }
            mo8488a(dVar);
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.u$c */
    private static final class C1917c extends C1914u {

        /* renamed from: a */
        private final C2032t f6341a;

        C1917c(C2032t tVar, C1482c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
            super(cVar, appLovinAdLoadListener, jVar);
            if (tVar == null) {
                throw new IllegalArgumentException("No response specified.");
            } else if (cVar == null) {
                throw new IllegalArgumentException("No context specified.");
            } else if (appLovinAdLoadListener != null) {
                this.f6341a = tVar;
            } else {
                throw new IllegalArgumentException("No callback specified.");
            }
        }

        public void run() {
            mo8405a("Processing VAST Wrapper response...");
            mo8489a(this.f6341a);
        }
    }

    C1914u(C1482c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        super("TaskProcessVastResponse", jVar);
        if (cVar != null) {
            this.f6338a = appLovinAdLoadListener;
            this.f6339c = (C1915a) cVar;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    /* renamed from: a */
    public static C1914u m7369a(C2032t tVar, C1482c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        return new C1917c(tVar, cVar, appLovinAdLoadListener, jVar);
    }

    /* renamed from: a */
    public static C1914u m7370a(JSONObject jSONObject, JSONObject jSONObject2, C1818b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        return new C1916b(new C1915a(jSONObject, jSONObject2, bVar, jVar), appLovinAdLoadListener, jVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8488a(C1483d dVar) {
        mo8410d("Failed to process VAST response due to VAST error code " + dVar);
        C1489i.m5784a((C1482c) this.f6339c, this.f6338a, dVar, -6, this.f6217b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8489a(C2032t tVar) {
        C1483d dVar;
        C1864a aVar;
        int a = this.f6339c.mo7190a();
        mo8405a("Finished parsing XML at depth " + a);
        this.f6339c.mo8490a(tVar);
        if (C1489i.m5790a(tVar)) {
            int intValue = ((Integer) this.f6217b.mo8549a(C1841c.f6012eC)).intValue();
            if (a < intValue) {
                mo8405a("VAST response is wrapper. Resolving...");
                aVar = new C1867ab(this.f6339c, this.f6338a, this.f6217b);
            } else {
                mo8410d("Reached beyond max wrapper depth of " + intValue);
                dVar = C1483d.WRAPPER_LIMIT_REACHED;
                mo8488a(dVar);
                return;
            }
        } else if (C1489i.m5793b(tVar)) {
            mo8405a("VAST response is inline. Rendering ad...");
            aVar = new C1920x(this.f6339c, this.f6338a, this.f6217b);
        } else {
            mo8410d("VAST response is an error");
            dVar = C1483d.NO_WRAPPER_RESPONSE;
            mo8488a(dVar);
            return;
        }
        this.f6217b.mo8533L().mo8474a(aVar);
    }
}
