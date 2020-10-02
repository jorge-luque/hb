package com.moat.analytics.mobile.vng;

import android.app.Application;
import android.content.Context;
import com.moat.analytics.mobile.vng.C4383g;
import com.moat.analytics.mobile.vng.C4424w;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.vng.k */
class C4400k extends MoatAnalytics implements C4424w.C4430b {

    /* renamed from: a */
    boolean f11807a = false;

    /* renamed from: b */
    boolean f11808b = false;

    /* renamed from: c */
    C4383g f11809c;

    /* renamed from: d */
    WeakReference<Context> f11810d;

    /* renamed from: e */
    private boolean f11811e = false;

    /* renamed from: f */
    private String f11812f;

    /* renamed from: g */
    private MoatOptions f11813g;

    C4400k() {
    }

    /* renamed from: a */
    private void m14738a(MoatOptions moatOptions, Application application) {
        if (this.f11811e) {
            C4409p.m14772a(3, "Analytics", (Object) this, "Moat SDK has already been started.");
            return;
        }
        this.f11813g = moatOptions;
        C4424w.m14808a().mo29341b();
        if (application != null) {
            if (moatOptions.loggingEnabled && C4412s.m14784b(application.getApplicationContext())) {
                this.f11807a = true;
            }
            this.f11810d = new WeakReference<>(application.getApplicationContext());
            this.f11811e = true;
            this.f11808b = moatOptions.autoTrackGMAInterstitials;
            C4371a.m14616a(application);
            C4424w.m14808a().mo29340a((C4424w.C4430b) this);
            if (!moatOptions.disableAdIdCollection) {
                C4412s.m14782a((Context) application);
            }
            C4409p.m14775a("[SUCCESS] ", "Moat Analytics SDK Version 2.6.3 started");
            return;
        }
        throw new C4403n("Moat Analytics SDK didn't start, application was null");
    }

    /* renamed from: d */
    private void m14739d() {
        if (this.f11809c == null) {
            C4383g gVar = new C4383g(C4371a.m14615a(), C4383g.C4388a.DISPLAY);
            this.f11809c = gVar;
            gVar.mo29289a(this.f11812f);
            C4409p.m14772a(3, "Analytics", (Object) this, "Preparing native display tracking with partner code " + this.f11812f);
            C4409p.m14775a("[SUCCESS] ", "Prepared for native display tracking with partner code " + this.f11812f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo29326a() {
        return this.f11811e;
    }

    /* renamed from: b */
    public void mo29327b() {
        C4403n.m14757a();
        if (this.f11812f != null) {
            try {
                m14739d();
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }
    }

    /* renamed from: c */
    public void mo29328c() {
    }

    public void prepareNativeDisplayTracking(String str) {
        this.f11812f = str;
        if (C4424w.m14808a().f11856a != C4424w.C4432d.OFF) {
            try {
                m14739d();
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }
    }

    public void start(Application application) {
        start(new MoatOptions(), application);
    }

    public void start(MoatOptions moatOptions, Application application) {
        try {
            m14738a(moatOptions, application);
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
    }
}
