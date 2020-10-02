package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.p045b.C1699c;
import com.applovin.impl.sdk.C1798a;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C1984a;

/* renamed from: com.applovin.impl.mediation.a */
public class C1643a extends C1984a {

    /* renamed from: a */
    private final C1798a f5124a;

    /* renamed from: b */
    private final C1977q f5125b;

    /* renamed from: c */
    private C1644a f5126c;

    /* renamed from: d */
    private C1699c f5127d;

    /* renamed from: e */
    private int f5128e;

    /* renamed from: f */
    private boolean f5129f;

    /* renamed from: com.applovin.impl.mediation.a$a */
    public interface C1644a {
        /* renamed from: a */
        void mo7626a(C1699c cVar);
    }

    C1643a(C1941j jVar) {
        this.f5125b = jVar.mo8602v();
        this.f5124a = jVar.mo8565aa();
    }

    /* renamed from: a */
    public void mo7624a() {
        this.f5125b.mo8742b("AdActivityObserver", "Cancelling...");
        this.f5124a.mo8073b(this);
        this.f5126c = null;
        this.f5127d = null;
        this.f5128e = 0;
        this.f5129f = false;
    }

    /* renamed from: a */
    public void mo7625a(C1699c cVar, C1644a aVar) {
        C1977q qVar = this.f5125b;
        qVar.mo8742b("AdActivityObserver", "Starting for ad " + cVar.getAdUnitId() + "...");
        mo7624a();
        this.f5126c = aVar;
        this.f5127d = cVar;
        this.f5124a.mo8071a(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f5129f) {
            this.f5129f = true;
        }
        this.f5128e++;
        this.f5125b.mo8742b("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.f5128e);
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.f5129f) {
            this.f5128e--;
            this.f5125b.mo8742b("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.f5128e);
            if (this.f5128e <= 0) {
                this.f5125b.mo8742b("AdActivityObserver", "Last ad Activity destroyed");
                if (this.f5126c != null) {
                    this.f5125b.mo8742b("AdActivityObserver", "Invoking callback...");
                    this.f5126c.mo7626a(this.f5127d);
                }
                mo7624a();
            }
        }
    }
}
