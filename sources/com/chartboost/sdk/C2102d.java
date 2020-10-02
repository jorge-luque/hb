package com.chartboost.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.C2083j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2166i1;
import com.chartboost.sdk.impl.C2216u1;
import com.chartboost.sdk.impl.C2222w0;
import com.google.android.gms.drive.DriveFile;

/* renamed from: com.chartboost.sdk.d */
public class C2102d {

    /* renamed from: a */
    final C2239j f7042a;

    /* renamed from: b */
    private final C2098a f7043b;

    /* renamed from: c */
    final Handler f7044c;

    /* renamed from: d */
    public final C2107e f7045d;

    /* renamed from: e */
    CBImpressionActivity f7046e = null;

    /* renamed from: f */
    C2088c f7047f = null;

    /* renamed from: g */
    private boolean f7048g = false;

    /* renamed from: h */
    Runnable f7049h;

    /* renamed from: i */
    final Application.ActivityLifecycleCallbacks f7050i;

    /* renamed from: j */
    private C2083j f7051j;

    @TargetApi(14)
    /* renamed from: com.chartboost.sdk.d$b */
    private class C2104b implements Application.ActivityLifecycleCallbacks {
        private C2104b() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            C2166i1.m8610a("CBUIManager.ActivityCallbackListener.onActivityCreated", (Object) activity);
            CBLogging.m8152a("CBUIManager", "######## onActivityCreated callback called");
            if (!(activity instanceof CBImpressionActivity)) {
                C2102d.this.mo9192b(activity);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            C2166i1.m8610a("CBUIManager.ActivityCallbackListener.onActivityDestroyed", (Object) activity);
            if (!(activity instanceof CBImpressionActivity)) {
                CBLogging.m8152a("CBUIManager", "######## onActivityDestroyed callback called from developer side");
                C2102d.this.mo9196c(activity);
                return;
            }
            CBLogging.m8152a("CBUIManager", "######## onActivityDestroyed callback called from CBImpressionactivity");
            C2102d.this.mo9199d(activity);
        }

        public void onActivityPaused(Activity activity) {
            C2166i1.m8610a("CBUIManager.ActivityCallbackListener.onActivityPaused", (Object) activity);
            if (!(activity instanceof CBImpressionActivity)) {
                CBLogging.m8152a("CBUIManager", "######## onActivityPaused callback called from developer side");
                C2102d.this.mo9201e(activity);
                return;
            }
            CBLogging.m8152a("CBUIManager", "######## onActivityPaused callback called from CBImpressionactivity");
            C2102d.this.mo9187a(activity);
            C2102d.this.mo9210j();
        }

        public void onActivityResumed(Activity activity) {
            C2166i1.m8610a("CBUIManager.ActivityCallbackListener.onActivityResumed", (Object) activity);
            if (!(activity instanceof CBImpressionActivity)) {
                CBLogging.m8152a("CBUIManager", "######## onActivityResumed callback called from developer side");
                C2102d.this.mo9202f(activity);
                return;
            }
            CBLogging.m8152a("CBUIManager", "######## onActivityResumed callback called from CBImpressionactivity");
            C2102d.this.mo9187a(activity);
            C2102d.this.mo9212k();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            C2166i1.m8610a("CBUIManager.ActivityCallbackListener.onActivityStarted", (Object) activity);
            if (!(activity instanceof CBImpressionActivity)) {
                CBLogging.m8152a("CBUIManager", "######## onActivityStarted callback called from developer side");
                C2102d.this.mo9204g(activity);
                return;
            }
            CBLogging.m8152a("CBUIManager", "######## onActivityStarted callback called from CBImpressionactivity");
            C2102d.this.mo9206h(activity);
        }

        public void onActivityStopped(Activity activity) {
            C2166i1.m8610a("CBUIManager.ActivityCallbackListener.onActivityStopped", (Object) activity);
            if (!(activity instanceof CBImpressionActivity)) {
                CBLogging.m8152a("CBUIManager", "######## onActivityStopped callback called from developer side");
                C2102d.this.mo9209i(activity);
                return;
            }
            CBLogging.m8152a("CBUIManager", "######## onActivityStopped callback called from CBImpressionactivity");
            C2102d.this.mo9211j(activity);
        }
    }

    /* renamed from: com.chartboost.sdk.d$c */
    class C2105c implements Runnable {

        /* renamed from: a */
        private final int f7053a;

        C2105c(C2102d dVar) {
            int i;
            C2099a a = m8365a();
            CBImpressionActivity cBImpressionActivity = dVar.f7046e;
            if (cBImpressionActivity != null) {
                cBImpressionActivity.hashCode();
            }
            if (a == null) {
                i = -1;
            } else {
                i = a.hashCode();
            }
            this.f7053a = i;
        }

        /* renamed from: a */
        private C2099a m8365a() {
            return C2242k.f7604d;
        }

        public void run() {
            C2166i1.m8609a("ClearMemoryRunnable.run");
            C2099a a = m8365a();
            if (a != null && a.hashCode() == this.f7053a) {
                C2242k.f7604d = null;
                C2166i1.m8609a("SdkSettings.clearDelegate");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.d$d */
    public class C2106d implements Runnable {

        /* renamed from: a */
        public final int f7054a;

        /* renamed from: b */
        Activity f7055b = null;

        /* renamed from: c */
        public C2088c f7056c = null;

        public C2106d(int i) {
            this.f7054a = i;
        }

        public void run() {
            try {
                switch (this.f7054a) {
                    case 0:
                        C2102d.this.mo9208i();
                        return;
                    case 1:
                        C2102d.this.f7044c.removeCallbacks(C2102d.this.f7049h);
                        C2102d.this.mo9213l();
                        C2102d.this.f7042a.mo9614l();
                        C2102d.this.f7042a.mo9602a(this.f7055b);
                        C2102d.this.mo9206h(this.f7055b);
                        return;
                    case 2:
                        if (CBUtility.m8168a(Chartboost.CBFramework.CBFrameworkUnity)) {
                            C2102d.this.f7042a.mo9614l();
                            return;
                        }
                        return;
                    case 3:
                        C2102d.this.mo9210j();
                        return;
                    case 4:
                        C2102d.this.mo9213l();
                        return;
                    case 5:
                        C2102d.this.f7049h = new C2105c(C2102d.this);
                        C2102d.this.f7049h.run();
                        C2102d.this.mo9199d(this.f7055b);
                        return;
                    case 7:
                        C2102d.this.mo9194b();
                        return;
                    case 9:
                        C2102d.this.mo9197c(this.f7056c);
                        return;
                    case 10:
                        if (this.f7056c.mo9142s()) {
                            this.f7056c.mo9130g().mo9253m();
                            return;
                        }
                        return;
                    case 11:
                        C2107e c = C2102d.this.mo9195c();
                        if (this.f7056c.f6922b == 2 && c != null) {
                            c.mo9224a(this.f7056c);
                            return;
                        }
                        return;
                    case 12:
                        this.f7056c.mo9132i();
                        return;
                    case 13:
                        C2102d.this.f7045d.mo9225a(this.f7056c, this.f7055b);
                        return;
                    case 14:
                        C2102d.this.f7045d.mo9229d(this.f7056c);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                C2098a.m8288a(C2106d.class, "run (" + this.f7054a + ")", e);
            }
        }
    }

    public C2102d(C2222w0 w0Var, C2239j jVar, C2098a aVar, Handler handler, C2107e eVar) {
        this.f7042a = jVar;
        this.f7043b = aVar;
        this.f7044c = handler;
        this.f7045d = eVar;
        this.f7049h = new C2105c(this);
        this.f7050i = new C2104b();
    }

    /* renamed from: a */
    private void m8332a(C2083j jVar, boolean z) {
    }

    /* renamed from: k */
    private boolean m8336k(Activity activity) {
        return this.f7046e == activity;
    }

    /* renamed from: m */
    private boolean m8337m() {
        C2166i1.m8609a("CBUIManager.closeImpressionImpl");
        C2088c e = mo9200e();
        if (e == null || e.f6922b != 2) {
            return false;
        }
        if (e.mo9133j()) {
            return true;
        }
        C2239j.m8896b((Runnable) new C2106d(7));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2083j mo9187a(Activity activity) {
        C2083j jVar = this.f7051j;
        if (jVar == null || jVar.f6881a != activity.hashCode()) {
            this.f7051j = new C2083j(activity);
        }
        return this.f7051j;
    }

    /* renamed from: b */
    public void mo9193b(C2088c cVar) {
        C2166i1.m8610a("CBUIManager.queueDisplayView", (Object) cVar);
        if (cVar.mo9128e().booleanValue()) {
            m8334d(cVar);
        } else {
            m8335e(cVar);
        }
    }

    /* renamed from: c */
    public C2107e mo9195c() {
        if (mo9198d() == null) {
            return null;
        }
        return this.f7045d;
    }

    /* renamed from: d */
    public Activity mo9198d() {
        return this.f7046e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C2088c mo9200e() {
        C2216u1 u1Var;
        C2107e c = mo9195c();
        if (c == null) {
            u1Var = null;
        } else {
            u1Var = c.mo9223a();
        }
        if (u1Var == null || !u1Var.mo9520e()) {
            return null;
        }
        return u1Var.mo9519d();
    }

    /* renamed from: f */
    public boolean mo9203f() {
        return mo9200e() != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo9204g(Activity activity) {
        C2166i1.m8610a("CBUIManager.onStartCallback", (Object) activity);
        if (C2101c.m8325a() && C2101c.m8326a(activity)) {
            C2106d dVar = new C2106d(1);
            dVar.f7055b = activity;
            C2239j.m8896b((Runnable) dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo9206h(Activity activity) {
        C2166i1.m8610a("CBUIManager.onStartImpl", (Object) activity);
        C2242k.f7612l = activity.getApplicationContext();
        boolean z = activity instanceof CBImpressionActivity;
        if (z) {
            mo9189a((CBImpressionActivity) activity);
        }
        this.f7044c.removeCallbacks(this.f7049h);
        Chartboost.CBFramework cBFramework = C2242k.f7605e;
        boolean z2 = cBFramework != null && cBFramework.doesWrapperUseCustomBackgroundingBehavior();
        if (activity == null) {
            return;
        }
        if (z2 || m8336k(activity)) {
            m8332a(mo9187a(activity), true);
            if (z) {
                this.f7048g = false;
            }
            if (mo9191a(activity, this.f7047f)) {
                this.f7047f = null;
            }
            C2088c e = mo9200e();
            if (e != null) {
                e.mo9141r();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo9208i() {
        C2166i1.m8609a("CBUIManager.onCreateImpl");
        mo9213l();
        this.f7044c.removeCallbacks(this.f7049h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo9210j() {
        C2166i1.m8611a("CBUIManager.onPauseImpl", (String) null);
        C2088c e = mo9200e();
        if (e != null) {
            e.mo9137n();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo9213l() {
        C2166i1.m8609a("CBUIManager.onStop");
        this.f7042a.mo9601a();
    }

    /* renamed from: d */
    private void m8334d(C2088c cVar) {
        this.f7045d.mo9228c(cVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo9202f(Activity activity) {
        C2166i1.m8610a("CBUIManager.onResumeCallback", (Object) activity);
        if (C2101c.m8325a() && C2101c.m8326a(activity)) {
            this.f7042a.mo9612j();
            C2106d dVar = new C2106d(2);
            dVar.f7055b = activity;
            C2239j.m8896b((Runnable) dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo9212k() {
        C2166i1.m8611a("CBUIManager.onResumeImpl", (String) null);
        C2088c e = mo9200e();
        if (CBUtility.m8168a(Chartboost.CBFramework.CBFrameworkUnity)) {
            this.f7042a.mo9614l();
        }
        if (e != null) {
            e.mo9140q();
        }
    }

    /* renamed from: c */
    public void mo9197c(C2088c cVar) {
        Intent intent = new Intent(C2242k.f7612l, CBImpressionActivity.class);
        intent.putExtra("isChartboost", true);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        try {
            C2242k.f7612l.startActivity(intent);
            this.f7048g = true;
        } catch (ActivityNotFoundException unused) {
            CBLogging.m8154b("CBUIManager", "Please add CBImpressionActivity in AndroidManifest.xml following README.md instructions.");
            this.f7047f = null;
            cVar.mo9120a(CBError.CBImpressionError.ACTIVITY_MISSING_IN_MANIFEST);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo9199d(Activity activity) {
        C2088c cVar;
        C2166i1.m8610a("CBUIManager.onDestroyImpl", (Object) activity);
        m8332a(mo9187a(activity), false);
        C2088c e = mo9200e();
        if (e == null && activity == this.f7046e && (cVar = this.f7047f) != null) {
            e = cVar;
        }
        C2107e c = mo9195c();
        if (!(c == null || e == null)) {
            c.mo9229d(e);
        }
        this.f7047f = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9189a(CBImpressionActivity cBImpressionActivity) {
        C2166i1.m8610a("CBUIManager.setImpressionActivity", (Object) cBImpressionActivity);
        if (this.f7046e == null) {
            C2242k.f7612l = cBImpressionActivity.getApplicationContext();
            this.f7046e = cBImpressionActivity;
        }
        this.f7044c.removeCallbacks(this.f7049h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo9209i(Activity activity) {
        C2166i1.m8610a("CBUIManager.onStopCallback", (Object) activity);
        if (C2101c.m8325a() && C2101c.m8326a(activity)) {
            C2106d dVar = new C2106d(4);
            dVar.f7055b = activity;
            C2239j.m8896b((Runnable) dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo9211j(Activity activity) {
        C2083j a = mo9187a(activity);
        C2166i1.m8610a("CBUIManager.onStopImpl", (Object) a);
        C2088c e = mo9200e();
        if (e != null && e.f6938r.f6896b == 0) {
            C2107e c = mo9195c();
            if (m8333a(a) && c != null) {
                c.mo9230e(e);
                this.f7047f = e;
                m8332a(a, false);
            }
        }
    }

    /* renamed from: e */
    private void m8335e(C2088c cVar) {
        if (mo9203f()) {
            cVar.mo9120a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        } else if (this.f7046e != null) {
            this.f7045d.mo9227b(cVar);
        } else {
            C2088c cVar2 = this.f7047f;
            if (cVar2 == null || cVar2 == cVar) {
                this.f7047f = cVar;
                C2099a aVar = C2242k.f7604d;
                if (aVar != null) {
                    int i = cVar.f6921a;
                    if (i == 1 || i == 2) {
                        C2242k.f7604d.willDisplayVideo(cVar.f6934n);
                    } else if (i == 0) {
                        aVar.willDisplayInterstitial(cVar.f6934n);
                    }
                }
                if (C2242k.f7605e != null) {
                    C2106d dVar = new C2106d(9);
                    dVar.f7056c = cVar;
                    this.f7044c.postDelayed(dVar, (long) 1);
                    return;
                }
                mo9197c(cVar);
                return;
            }
            cVar.mo9120a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9192b(Activity activity) {
        C2166i1.m8610a("CBUIManager.onCreateCallback", (Object) activity);
        if (C2101c.m8325a() && C2101c.m8326a(activity)) {
            C2106d dVar = new C2106d(0);
            dVar.f7055b = activity;
            C2239j.m8896b((Runnable) dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo9205g() {
        C2166i1.m8609a("CBUIManager.onBackPressedCallback");
        if (!C2101c.m8325a() || !this.f7048g) {
            return false;
        }
        this.f7048g = false;
        mo9207h();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9188a() {
        C2166i1.m8609a("CBUIManager.clearImpressionActivity");
        this.f7046e = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo9194b() {
        C2088c e = mo9200e();
        if (e == null) {
            return false;
        }
        e.f6920D = true;
        mo9190a(e);
        return true;
    }

    /* renamed from: a */
    private boolean m8333a(C2083j jVar) {
        if (jVar == null) {
            return this.f7046e == null;
        }
        return jVar.mo9112a(this.f7046e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9196c(Activity activity) {
        C2166i1.m8610a("CBUIManager.onDestroyCallback", (Object) activity);
        if (C2101c.m8325a() && C2101c.m8326a(activity)) {
            C2106d dVar = new C2106d(5);
            dVar.f7055b = activity;
            C2239j.m8896b((Runnable) dVar);
        }
    }

    /* renamed from: a */
    public void mo9190a(C2088c cVar) {
        C2107e c;
        int i = cVar.f6922b;
        if (i == 2) {
            C2107e c2 = mo9195c();
            if (c2 != null) {
                c2.mo9224a(cVar);
            }
        } else if (cVar.f6938r.f6896b == 1 && i == 1 && (c = mo9195c()) != null) {
            c.mo9229d(cVar);
        }
        if (cVar.mo9146w()) {
            this.f7043b.mo9171b(cVar.f6923c.mo9267a(cVar.f6938r.f6896b), cVar.f6934n, cVar.mo9126c());
        } else {
            this.f7043b.mo9174c(cVar.f6923c.mo9267a(cVar.f6938r.f6896b), cVar.f6934n, cVar.mo9126c());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo9207h() {
        C2166i1.m8609a("CBUIManager.onBackPressedImpl");
        return m8337m();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo9201e(Activity activity) {
        C2166i1.m8610a("CBUIManager.onPauseCallback", (Object) activity);
        if (C2101c.m8325a() && C2101c.m8326a(activity)) {
            C2106d dVar = new C2106d(3);
            dVar.f7055b = activity;
            C2239j.m8896b((Runnable) dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        if (r1 != 3) goto L_0x0049;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9191a(android.app.Activity r4, com.chartboost.sdk.Model.C2088c r5) {
        /*
            r3 = this;
            r0 = 1
            if (r5 == 0) goto L_0x0049
            int r1 = r5.f6922b
            if (r1 == r0) goto L_0x0046
            r2 = 2
            if (r1 == r2) goto L_0x000e
            r4 = 3
            if (r1 == r4) goto L_0x0046
            goto L_0x0049
        L_0x000e:
            boolean r1 = r5.mo9143t()
            if (r1 != 0) goto L_0x0049
            com.chartboost.sdk.Chartboost$CBFramework r1 = com.chartboost.sdk.C2242k.f7605e
            if (r1 == 0) goto L_0x0024
            boolean r1 = r1.doesWrapperUseCustomBackgroundingBehavior()
            if (r1 == 0) goto L_0x0024
            boolean r4 = r4 instanceof com.chartboost.sdk.CBImpressionActivity
            if (r4 != 0) goto L_0x0024
            r4 = 0
            return r4
        L_0x0024:
            com.chartboost.sdk.e r4 = r3.mo9195c()
            if (r4 == 0) goto L_0x0049
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error onActivityStart "
            r1.append(r2)
            int r2 = r5.f6922b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CBUIManager"
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r2, r1)
            r4.mo9229d(r5)
            goto L_0x0049
        L_0x0046:
            r3.mo9193b((com.chartboost.sdk.Model.C2088c) r5)
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.C2102d.mo9191a(android.app.Activity, com.chartboost.sdk.Model.c):boolean");
    }
}
