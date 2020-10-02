package com.chartboost.sdk;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C2102d;
import com.chartboost.sdk.C2109f;
import com.chartboost.sdk.Events.C2070b;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2117a;
import com.chartboost.sdk.impl.C2181n;
import com.chartboost.sdk.impl.C2193o1;
import com.chartboost.sdk.impl.C2216u1;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.chartboost.sdk.e */
public class C2107e {

    /* renamed from: a */
    final C2193o1 f7058a;

    /* renamed from: b */
    private final C2181n f7059b;

    /* renamed from: c */
    private final AtomicReference<C2093h> f7060c;

    /* renamed from: d */
    private final Handler f7061d;

    /* renamed from: e */
    C2216u1 f7062e = null;

    /* renamed from: f */
    private int f7063f = -1;

    /* renamed from: com.chartboost.sdk.e$a */
    class C2108a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C2088c f7064a;

        /* renamed from: b */
        final /* synthetic */ Activity f7065b;

        C2108a(C2088c cVar, Activity activity) {
            this.f7064a = cVar;
            this.f7065b = activity;
        }

        public void run() {
            C2088c cVar = this.f7064a;
            cVar.f6922b = 4;
            int i = 1;
            if (cVar.f6938r.f6896b == 1) {
                i = 6;
            }
            Integer a = C2193o1.m8724a(this.f7064a.f6938r.f6909o);
            if (a != null) {
                i = a.intValue();
            }
            C2102d dVar = this.f7064a.f6929i;
            dVar.getClass();
            C2102d.C2106d dVar2 = new C2102d.C2106d(13);
            C2088c cVar2 = this.f7064a;
            dVar2.f7056c = cVar2;
            dVar2.f7055b = this.f7065b;
            C2107e.this.f7058a.mo9471a(i, cVar2, (Runnable) dVar2);
        }
    }

    public C2107e(C2193o1 o1Var, C2181n nVar, AtomicReference<C2093h> atomicReference, Handler handler) {
        this.f7058a = o1Var;
        this.f7059b = nVar;
        this.f7060c = atomicReference;
        this.f7061d = handler;
    }

    /* renamed from: f */
    private void m8366f(C2088c cVar) {
        int i;
        C2216u1 u1Var = this.f7062e;
        if (u1Var == null || u1Var.mo9519d() == cVar) {
            int i2 = 1;
            boolean z = cVar.f6922b != 2;
            cVar.f6922b = 2;
            Activity d = cVar.f6929i.mo9198d();
            CBError.CBImpressionError cBImpressionError = d == null ? CBError.CBImpressionError.NO_HOST_ACTIVITY : null;
            if (cBImpressionError == null) {
                cBImpressionError = cVar.mo9118a((RelativeLayout) null);
            }
            if (cBImpressionError != null) {
                CBLogging.m8154b("CBViewController", "Unable to create the view while trying th display the impression");
                cVar.mo9120a(cBImpressionError);
                return;
            }
            if (this.f7062e == null) {
                C2216u1 u1Var2 = (C2216u1) C2116i.m8407a().mo9266a(new C2216u1(d, cVar));
                this.f7062e = u1Var2;
                d.addContentView(u1Var2, new FrameLayout.LayoutParams(-1, -1));
            }
            CBUtility.m8164a(d, cVar.f6938r.f6896b, this.f7060c.get());
            if (this.f7063f == -1 && ((i = cVar.f6921a) == 1 || i == 2)) {
                this.f7063f = d.getWindow().getDecorView().getSystemUiVisibility();
                Chartboost.setActivityAttrs(d);
            }
            this.f7062e.mo9521f();
            CBLogging.m8156c("CBViewController", "Displaying the impression");
            C2216u1 u1Var3 = this.f7062e;
            cVar.f6945y = u1Var3;
            if (z) {
                if (cVar.f6938r.f6896b == 0) {
                    u1Var3.mo9517b().mo9477a(this.f7058a, cVar.f6938r);
                }
                if (cVar.f6938r.f6896b == 1) {
                    i2 = 6;
                }
                Integer a = C2193o1.m8724a(cVar.f6938r.f6909o);
                if (a != null) {
                    i2 = a.intValue();
                }
                cVar.mo9131h();
                C2102d dVar = cVar.f6929i;
                dVar.getClass();
                C2102d.C2106d dVar2 = new C2102d.C2106d(12);
                dVar2.f7056c = cVar;
                this.f7058a.mo9472a(i2, cVar, (Runnable) dVar2, this);
                this.f7059b.mo9431a();
                return;
            }
            return;
        }
        CBLogging.m8154b("CBViewController", "Impression already visible");
        cVar.mo9120a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
    }

    /* renamed from: a */
    public void mo9224a(C2088c cVar) {
        CBLogging.m8156c("CBViewController", "Dismissing impression");
        C2108a aVar = new C2108a(cVar, cVar.f6929i.mo9198d());
        if (cVar.f6917A) {
            cVar.mo9121a((Runnable) aVar);
        } else {
            aVar.run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9227b(C2088c cVar) {
        if (cVar.f6922b != 0) {
            m8366f(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9228c(C2088c cVar) {
        RelativeLayout d = cVar.mo9127d();
        CBError.CBImpressionError a = cVar.mo9118a(d);
        C2109f.C2111b f = cVar.mo9129f();
        if (d == null || f == null) {
            cVar.mo9120a(CBError.CBImpressionError.ERROR_DISPLAYING_VIEW);
        } else if (a != null) {
            cVar.mo9120a(a);
        } else {
            cVar.f6922b = 2;
            d.addView(f);
            this.f7059b.mo9431a();
        }
    }

    /* renamed from: d */
    public void mo9229d(C2088c cVar) {
        CBLogging.m8156c("CBViewController", "Removing impression");
        cVar.f6922b = 5;
        cVar.mo9124b();
        this.f7062e = null;
        this.f7059b.mo9436c();
        Handler handler = this.f7061d;
        C2117a aVar = cVar.f6923c;
        aVar.getClass();
        handler.post(new C2117a.C2118a(3, cVar.f6934n, (CBError.CBImpressionError) null, (C2070b) null));
        if (cVar.mo9146w()) {
            Handler handler2 = this.f7061d;
            C2117a aVar2 = cVar.f6923c;
            aVar2.getClass();
            handler2.post(new C2117a.C2118a(2, cVar.f6934n, (CBError.CBImpressionError) null, (C2070b) null));
        }
        mo9226a(cVar.f6929i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo9230e(C2088c cVar) {
        CBLogging.m8156c("CBViewController", "Removing impression silently");
        cVar.mo9119a();
        try {
            ((ViewGroup) this.f7062e.getParent()).removeView(this.f7062e);
        } catch (Exception e) {
            CBLogging.m8153a("CBViewController", "Exception removing impression silently", e);
            C2098a.m8288a(C2107e.class, "removeImpressionSilently", e);
        }
        this.f7062e = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9225a(C2088c cVar, Activity activity) {
        C2102d dVar = cVar.f6929i;
        dVar.getClass();
        C2102d.C2106d dVar2 = new C2102d.C2106d(14);
        dVar2.f7056c = cVar;
        this.f7061d.post(dVar2);
        cVar.mo9136m();
        CBUtility.m8169b(activity, cVar.f6938r.f6896b, this.f7060c.get());
        if (this.f7063f != -1) {
            int i = cVar.f6921a;
            if (i == 1 || i == 2) {
                activity.getWindow().getDecorView().setSystemUiVisibility(this.f7063f);
                this.f7063f = -1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9226a(C2102d dVar) {
        CBLogging.m8156c("CBViewController", "Attempting to close impression activity");
        Activity d = dVar.mo9198d();
        if (d != null && (d instanceof CBImpressionActivity)) {
            CBLogging.m8156c("CBViewController", "Closing impression activity");
            dVar.mo9188a();
            d.finish();
        }
    }

    /* renamed from: a */
    public C2216u1 mo9223a() {
        return this.f7062e;
    }
}
