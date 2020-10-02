package com.moat.analytics.mobile.ogury;

import android.app.Application;
import android.content.Context;
import com.moat.analytics.mobile.ogury.C4311d;
import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.C4346q;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.ogury.i */
final class C4328i extends MoatAnalytics implements C4346q.C4350b {

    /* renamed from: ʻ */
    private MoatOptions f11577;

    /* renamed from: ʼ */
    private String f11578;

    /* renamed from: ˊ */
    C4311d f11579;

    /* renamed from: ˋ */
    boolean f11580 = false;

    /* renamed from: ˎ */
    boolean f11581 = false;

    /* renamed from: ˏ */
    WeakReference<Context> f11582;

    /* renamed from: ॱ */
    boolean f11583 = false;

    /* renamed from: ॱॱ */
    private boolean f11584 = false;

    C4328i() {
    }

    /* renamed from: ॱ */
    private void m14491() {
        if (this.f11579 == null) {
            C4311d dVar = new C4311d(C4307a.m14408(), C4311d.C4314b.f11513);
            this.f11579 = dVar;
            dVar.mo29121(this.f11578);
            StringBuilder sb = new StringBuilder("Preparing native display tracking with partner code ");
            sb.append(this.f11578);
            C4315e.C43161.m14442(3, "Analytics", this, sb.toString());
            StringBuilder sb2 = new StringBuilder("Prepared for native display tracking with partner code ");
            sb2.append(this.f11578);
            C4315e.C43161.m14446("[SUCCESS] ", sb2.toString());
        }
    }

    public final void prepareNativeDisplayTracking(String str) {
        this.f11578 = str;
        if (C4346q.m14542().f11640 != C4346q.C4354e.f11656) {
            try {
                m14491();
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }
    }

    public final void start(Application application) {
        start(new MoatOptions(), application);
    }

    /* renamed from: ˋ */
    public final void mo29162() throws C4332l {
        C4332l.m14508();
        C4333m.m14517();
        if (this.f11578 != null) {
            try {
                m14491();
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ */
    public final boolean mo29163() {
        MoatOptions moatOptions = this.f11577;
        return moatOptions != null && moatOptions.disableLocationServices;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public final boolean mo29164() {
        return this.f11584;
    }

    public final void start(MoatOptions moatOptions, Application application) {
        try {
            if (this.f11584) {
                C4315e.C43161.m14442(3, "Analytics", this, "Moat SDK has already been started.");
                return;
            }
            this.f11577 = moatOptions;
            C4346q.m14542().mo29182();
            this.f11580 = moatOptions.disableLocationServices;
            if (application != null) {
                if (moatOptions.loggingEnabled && C4356s.m14579(application.getApplicationContext())) {
                    this.f11581 = true;
                }
                this.f11582 = new WeakReference<>(application.getApplicationContext());
                this.f11584 = true;
                this.f11583 = moatOptions.autoTrackGMAInterstitials;
                C4307a.m14405(application);
                C4346q.m14542().mo29181((C4346q.C4350b) this);
                if (!moatOptions.disableAdIdCollection) {
                    C4356s.m14576((Context) application);
                }
                C4315e.C43161.m14446("[SUCCESS] ", "Moat Analytics SDK Version 2.4.3 started");
                return;
            }
            throw new C4332l("Moat Analytics SDK didn't start, application was null");
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }
}
