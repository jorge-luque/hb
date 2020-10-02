package com.chartboost.sdk.impl;

import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2093h;
import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.impl.q */
public class C2198q {

    /* renamed from: a */
    private C2208s f7424a = null;

    /* renamed from: b */
    private C2214u f7425b = null;

    /* renamed from: c */
    private WeakReference<C2202r> f7426c;

    /* renamed from: d */
    private WeakReference<C2211t> f7427d;

    /* renamed from: e */
    private boolean f7428e = true;

    /* renamed from: l */
    private void m8733l() {
        WeakReference<C2202r> weakReference = this.f7426c;
        if (weakReference != null) {
            weakReference.clear();
            this.f7426c = null;
        }
    }

    /* renamed from: m */
    private void m8734m() {
        WeakReference<C2211t> weakReference = this.f7427d;
        if (weakReference != null) {
            weakReference.clear();
            this.f7427d = null;
        }
    }

    /* renamed from: n */
    private C2093h.C2094a m8735n() {
        C2239j n = C2239j.m8897n();
        if (n != null) {
            return n.mo9605c();
        }
        return null;
    }

    /* renamed from: a */
    public void mo9480a(C2202r rVar) {
        m8733l();
        this.f7426c = new WeakReference<>(rVar);
    }

    /* renamed from: b */
    public C2214u mo9484b(WeakReference<C2211t> weakReference, double d) {
        return new C2214u(weakReference, d);
    }

    /* renamed from: c */
    public double mo9485c() {
        C2093h.C2094a n = m8735n();
        if (n != null) {
            return n.mo9154b();
        }
        return 30.0d;
    }

    /* renamed from: d */
    public void mo9486d() {
        if (this.f7424a != null) {
            CBLogging.m8152a("BannerAutoRefreshManager", "Auto-refreshed is paused at: " + this.f7424a.mo9532b());
            this.f7424a.mo9534d();
        }
    }

    /* renamed from: e */
    public void mo9487e() {
        C2214u uVar = this.f7425b;
        if (uVar != null) {
            uVar.mo9534d();
        }
    }

    /* renamed from: f */
    public void mo9488f() {
        WeakReference<C2202r> weakReference;
        mo9492j();
        if (this.f7424a == null && this.f7428e && (weakReference = this.f7426c) != null) {
            C2208s a = mo9478a(weakReference, mo9483b());
            this.f7424a = a;
            a.mo9536f();
        }
    }

    /* renamed from: g */
    public void mo9489g() {
        WeakReference<C2211t> weakReference;
        mo9493k();
        if (this.f7425b == null && this.f7428e && (weakReference = this.f7427d) != null) {
            C2214u b = mo9484b(weakReference, mo9485c());
            this.f7425b = b;
            b.mo9536f();
        }
    }

    /* renamed from: h */
    public void mo9490h() {
        if (this.f7424a != null) {
            CBLogging.m8152a("BannerAutoRefreshManager", "Auto-refreshed is resumed at: " + this.f7424a.mo9532b());
            this.f7424a.mo9535e();
        }
    }

    /* renamed from: i */
    public void mo9491i() {
        C2214u uVar = this.f7425b;
        if (uVar != null) {
            uVar.mo9535e();
        }
    }

    /* renamed from: j */
    public void mo9492j() {
        C2208s sVar = this.f7424a;
        if (sVar != null) {
            sVar.mo9511g();
            this.f7424a = null;
        }
    }

    /* renamed from: k */
    public void mo9493k() {
        C2214u uVar = this.f7425b;
        if (uVar != null) {
            uVar.mo9511g();
            this.f7425b = null;
        }
    }

    /* renamed from: b */
    public double mo9483b() {
        C2093h.C2094a n = m8735n();
        if (n != null) {
            return n.mo9153a();
        }
        return 30.0d;
    }

    /* renamed from: a */
    public void mo9481a(C2211t tVar) {
        m8734m();
        this.f7427d = new WeakReference<>(tVar);
    }

    /* renamed from: a */
    public C2208s mo9478a(WeakReference<C2202r> weakReference, double d) {
        return new C2208s(weakReference, d);
    }

    /* renamed from: a */
    public void mo9482a(boolean z) {
        this.f7428e = z;
        if (z) {
            mo9491i();
            mo9490h();
            return;
        }
        mo9487e();
        mo9486d();
    }

    /* renamed from: a */
    public void mo9479a() {
        m8733l();
        m8734m();
    }
}
