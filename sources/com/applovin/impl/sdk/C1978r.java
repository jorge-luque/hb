package com.applovin.impl.sdk;

import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.mediation.p045b.C1701e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.r */
public class C1978r {

    /* renamed from: a */
    private final C1941j f6623a;

    /* renamed from: b */
    private final C1977q f6624b;

    /* renamed from: c */
    private final Map<String, C1697a> f6625c = new HashMap(4);

    /* renamed from: d */
    private final Object f6626d = new Object();

    C1978r(C1941j jVar) {
        this.f6623a = jVar;
        this.f6624b = jVar.mo8602v();
    }

    /* renamed from: a */
    public String mo8747a(String str) {
        String E;
        synchronized (this.f6626d) {
            C1697a aVar = this.f6625c.get(str);
            E = aVar != null ? aVar.mo7813E() : null;
        }
        return E;
    }

    /* renamed from: a */
    public void mo8748a(C1697a aVar) {
        synchronized (this.f6626d) {
            C1977q qVar = this.f6624b;
            qVar.mo8742b("MediationWaterfallWinnerTracker", "Tracking winning ad: " + aVar);
            this.f6625c.put(aVar.getAdUnitId(), aVar);
        }
    }

    /* renamed from: b */
    public void mo8749b(C1697a aVar) {
        synchronized (this.f6626d) {
            String adUnitId = aVar.getAdUnitId();
            C1701e eVar = this.f6625c.get(adUnitId);
            if (aVar == eVar) {
                C1977q qVar = this.f6624b;
                qVar.mo8742b("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + eVar);
                this.f6625c.remove(adUnitId);
            } else {
                C1977q qVar2 = this.f6624b;
                qVar2.mo8742b("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + aVar + " , since it could have already been updated with a new ad: " + eVar);
            }
        }
    }
}
