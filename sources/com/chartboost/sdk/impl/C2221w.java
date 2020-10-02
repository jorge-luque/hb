package com.chartboost.sdk.impl;

import android.os.Handler;
import com.chartboost.sdk.Libraries.CBLogging;

/* renamed from: com.chartboost.sdk.impl.w */
abstract class C2221w implements C2217v {

    /* renamed from: a */
    private Handler f7484a;

    /* renamed from: b */
    private double f7485b = 0.0d;

    /* renamed from: c */
    private double f7486c;

    /* renamed from: d */
    private Runnable f7487d = new C2134d2(this);

    C2221w(double d) {
        this.f7486c = d;
    }

    /* renamed from: h */
    private void m8790h() {
        if (this.f7484a == null) {
            this.f7484a = new Handler();
        }
    }

    /* renamed from: i */
    private void m8791i() {
        m8790h();
        Runnable runnable = this.f7487d;
        if (runnable != null) {
            this.f7484a.postDelayed(runnable, 1000);
        }
    }

    /* renamed from: j */
    private void m8792j() {
        Runnable runnable;
        Handler handler = this.f7484a;
        if (handler != null && (runnable = this.f7487d) != null) {
            handler.removeCallbacks(runnable);
            this.f7484a = null;
        }
    }

    /* renamed from: b */
    public Double mo9532b() {
        return Double.valueOf(this.f7485b);
    }

    /* renamed from: c */
    public void mo9533c() {
        double d = this.f7485b + 1.0d;
        this.f7485b = d;
        if (d >= this.f7486c) {
            mo9510a();
        } else {
            m8791i();
        }
    }

    /* renamed from: d */
    public void mo9534d() {
        m8792j();
    }

    /* renamed from: e */
    public void mo9535e() {
        if (this.f7485b > 0.0d) {
            CBLogging.m8152a("BannerTimer", "Resume timer at: " + this.f7485b + " sec");
            mo9536f();
        }
    }

    /* renamed from: f */
    public void mo9536f() {
        m8791i();
    }

    /* renamed from: g */
    public void mo9511g() {
        m8792j();
        this.f7485b = 0.0d;
    }
}
