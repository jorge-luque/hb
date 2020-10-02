package com.chartboost.sdk.Banner;

import android.content.SharedPreferences;
import android.os.Handler;
import com.chartboost.sdk.C2101c;
import com.chartboost.sdk.C2102d;
import com.chartboost.sdk.C2107e;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.ChartboostBanner;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Libraries.C2078f;
import com.chartboost.sdk.Libraries.C2082i;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2092g;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2117a;
import com.chartboost.sdk.impl.C2131d;
import com.chartboost.sdk.impl.C2143g;
import com.chartboost.sdk.impl.C2181n;
import com.chartboost.sdk.impl.C2218v0;
import com.chartboost.sdk.impl.C2222w0;
import com.chartboost.sdk.impl.C2224x;
import com.chartboost.sdk.impl.C2225x0;
import com.chartboost.sdk.impl.C2234y0;
import com.chartboost.sdk.impl.C2236z;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.chartboost.sdk.Banner.a */
public class C2061a extends C2143g implements C2062b {

    /* renamed from: D */
    private C2131d f6816D;

    /* renamed from: E */
    private Handler f6817E;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2061a(C2131d dVar, ScheduledExecutorService scheduledExecutorService, C2181n nVar, C2078f fVar, C2218v0 v0Var, C2222w0 w0Var, C2092g gVar, AtomicReference<C2093h> atomicReference, SharedPreferences sharedPreferences, C2082i iVar, C2098a aVar, Handler handler, C2102d dVar2, C2225x0 x0Var, C2107e eVar, C2234y0 y0Var) {
        super(dVar, scheduledExecutorService, nVar, fVar, v0Var, w0Var, gVar, atomicReference, sharedPreferences, iVar, aVar, handler, dVar2, x0Var, eVar, y0Var);
        this.f6816D = dVar;
        this.f6817E = handler;
    }

    /* renamed from: f */
    private boolean m8101f(String str) {
        if (!C2224x.m8805e().mo9549a((CharSequence) str)) {
            return true;
        }
        CBLogging.m8154b("AdUnitBannerManager", "Location cannot be empty");
        ChartboostCacheError chartboostCacheError = new ChartboostCacheError(0);
        Handler handler = this.f6817E;
        C2131d dVar = this.f6816D;
        dVar.getClass();
        handler.post(new C2117a.C2118a(6, str, (CBError.CBImpressionError) null, chartboostCacheError));
        return false;
    }

    /* renamed from: i */
    private void m8102i() {
        ChartboostCacheError chartboostCacheError = new ChartboostCacheError(7);
        C2131d dVar = this.f6816D;
        dVar.getClass();
        this.f6817E.post(new C2117a.C2118a(6, this.f7184q.getLocation(), (CBError.CBImpressionError) null, chartboostCacheError));
    }

    /* renamed from: j */
    private void m8103j() {
        ChartboostShowError chartboostShowError = new ChartboostShowError(7, false);
        C2131d dVar = this.f6816D;
        dVar.getClass();
        this.f6817E.post(new C2117a.C2118a(7, this.f7184q.getLocation(), (CBError.CBImpressionError) null, chartboostShowError));
    }

    /* renamed from: a */
    public void mo8998a(String str) {
        if (mo9004h()) {
            C2236z.m8883a(this.f7184q.getLocation(), str, 3);
        } else {
            m8103j();
        }
    }

    /* renamed from: b */
    public void mo9000b() {
        if (mo9004h()) {
            ChartboostBanner chartboostBanner = this.f7184q;
            chartboostBanner.didClickBanner(chartboostBanner.getLocation(), (ChartboostClickError) null);
        }
    }

    /* renamed from: c */
    public void mo9001c() {
        if (mo9004h()) {
            this.f7168a.execute(new C2143g.C2145b(3, this.f7184q.getLocation(), (C2151h) null, (CBError.CBImpressionError) null));
            return;
        }
        m8102i();
    }

    /* renamed from: d */
    public void mo9002d() {
        if (mo9004h()) {
            this.f7168a.execute(new C2143g.C2145b(4, this.f7184q.getLocation(), (C2151h) null, (CBError.CBImpressionError) null));
            return;
        }
        m8103j();
    }

    /* renamed from: g */
    public C2131d mo9003g() {
        return this.f6816D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo9004h() {
        ChartboostBanner chartboostBanner;
        if (!m8100a(C2239j.m8897n()) || (chartboostBanner = this.f7184q) == null) {
            return false;
        }
        return m8101f(chartboostBanner.getLocation());
    }

    /* renamed from: a */
    private boolean m8100a(C2239j jVar) {
        if (jVar == null || !C2101c.m8331c()) {
            return false;
        }
        return C2239j.m8899p();
    }

    /* renamed from: a */
    public boolean mo8999a() {
        return mo9342d(this.f7184q.getLocation()) != null;
    }

    /* renamed from: a */
    public void mo8997a(ChartboostBanner chartboostBanner) {
        this.f7184q = chartboostBanner;
    }
}
