package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p045b.C1699c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C1987d;

/* renamed from: com.applovin.impl.mediation.c */
public class C1705c {

    /* renamed from: a */
    private final C1941j f5312a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1977q f5313b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1707a f5314c;

    /* renamed from: d */
    private C1987d f5315d;

    /* renamed from: com.applovin.impl.mediation.c$a */
    public interface C1707a {
        /* renamed from: c */
        void mo7762c(C1699c cVar);
    }

    C1705c(C1941j jVar, C1707a aVar) {
        this.f5312a = jVar;
        this.f5313b = jVar.mo8602v();
        this.f5314c = aVar;
    }

    /* renamed from: a */
    public void mo7850a() {
        this.f5313b.mo8742b("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        C1987d dVar = this.f5315d;
        if (dVar != null) {
            dVar.mo8773a();
            this.f5315d = null;
        }
    }

    /* renamed from: a */
    public void mo7851a(final C1699c cVar, long j) {
        C1977q qVar = this.f5313b;
        qVar.mo8742b("AdHiddenCallbackTimeoutManager", "Scheduling in " + j + "ms...");
        this.f5315d = C1987d.m7825a(j, this.f5312a, new Runnable() {
            public void run() {
                C1705c.this.f5313b.mo8742b("AdHiddenCallbackTimeoutManager", "Timing out...");
                C1705c.this.f5314c.mo7762c(cVar);
            }
        });
    }
}
