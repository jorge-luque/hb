package com.criteo.publisher.p058q;

import com.criteo.publisher.model.C2450k;
import com.criteo.publisher.model.C2451l;
import com.criteo.publisher.model.C2454o;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.p064w.C2571a;
import com.criteo.publisher.p064w.C2572b;

/* renamed from: com.criteo.publisher.q.c */
public class C2505c implements C2503a {

    /* renamed from: a */
    private final C2571a f7997a = C2572b.m9650b(C2505c.class);

    /* renamed from: a */
    public void mo10509a() {
        this.f7997a.mo10611a("onSdkInitialized", new Object[0]);
    }

    /* renamed from: a */
    public void mo10511a(C2451l lVar) {
        this.f7997a.mo10611a("onCdbCallStarted: %s", lVar);
    }

    /* renamed from: a */
    public void mo10512a(C2451l lVar, C2454o oVar) {
        this.f7997a.mo10611a("onCdbCallFinished: %s", oVar);
    }

    /* renamed from: a */
    public void mo10513a(C2451l lVar, Exception exc) {
        this.f7997a.mo10610a("onCdbCallFailed", (Throwable) exc);
    }

    /* renamed from: a */
    public void mo10510a(C2450k kVar, C2465w wVar) {
        this.f7997a.mo10611a("onBidConsumed: %s", wVar);
    }
}
