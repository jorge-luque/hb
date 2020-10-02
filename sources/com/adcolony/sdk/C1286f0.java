package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.C1359k0;
import com.adcolony.sdk.C1439u;
import com.facebook.login.widget.ToolTipPopup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.f0 */
class C1286f0 implements Runnable {

    /* renamed from: a */
    private final int f4055a = 17;

    /* renamed from: b */
    private final int f4056b = 15000;

    /* renamed from: c */
    private final int f4057c = 1000;

    /* renamed from: d */
    private long f4058d = 30000;

    /* renamed from: e */
    private int f4059e;

    /* renamed from: f */
    private long f4060f;

    /* renamed from: g */
    private long f4061g;

    /* renamed from: h */
    private long f4062h;

    /* renamed from: i */
    private long f4063i;

    /* renamed from: j */
    private long f4064j;

    /* renamed from: k */
    private long f4065k;

    /* renamed from: l */
    private long f4066l;

    /* renamed from: m */
    private long f4067m;

    /* renamed from: n */
    private boolean f4068n = true;

    /* renamed from: o */
    private boolean f4069o = true;

    /* renamed from: p */
    private boolean f4070p;

    /* renamed from: q */
    private boolean f4071q;

    /* renamed from: r */
    private boolean f4072r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f4073s;

    /* renamed from: t */
    private boolean f4074t;

    /* renamed from: com.adcolony.sdk.f0$a */
    class C1287a implements C1458z {
        C1287a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            boolean unused = C1286f0.this.f4073s = true;
        }
    }

    C1286f0() {
    }

    /* renamed from: f */
    private void m5043f() {
        mo6493a(false);
    }

    /* renamed from: g */
    private void m5044g() {
        mo6495b(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6495b(boolean z) {
        C1290h c = C1199a.m4880c();
        ArrayList<C1201a0> b = c.mo6548n().mo6841b();
        synchronized (b) {
            Iterator<C1201a0> it = b.iterator();
            while (it.hasNext()) {
                C1201a0 next = it.next();
                JSONObject b2 = C1437s.m5599b();
                C1437s.m5603b(b2, "from_window_focus", z);
                new C1454x("SessionInfo.on_resume", next.mo6390d(), b2).mo6834d();
            }
        }
        c.mo6547m().mo6825c();
        this.f4069o = false;
    }

    /* renamed from: c */
    public void mo6496c() {
        C1199a.m4876a("SessionInfo.stopped", (C1458z) new C1287a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6498d(boolean z) {
        this.f4068n = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6500e(boolean z) {
        this.f4070p = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6503h() {
        C1282e0 a = C1199a.m4880c().mo6547m().mo6816a();
        this.f4071q = false;
        this.f4068n = false;
        if (a != null) {
            a.mo6482b();
        }
        JSONObject b = C1437s.m5599b();
        double d = (double) this.f4060f;
        Double.isNaN(d);
        C1437s.m5590a(b, "session_length", d / 1000.0d);
        new C1454x("SessionInfo.on_stop", 1, b).mo6834d();
        C1199a.m4884g();
        AdColony.f3234a.shutdown();
    }

    public void run() {
        long j;
        while (true) {
            this.f4063i = System.currentTimeMillis();
            C1199a.m4884g();
            if (this.f4061g > this.f4058d) {
                break;
            }
            if (!this.f4068n) {
                if (this.f4070p && !this.f4069o) {
                    this.f4070p = false;
                    m5043f();
                }
                long j2 = this.f4061g;
                if (this.f4067m == 0) {
                    j = 0;
                } else {
                    j = System.currentTimeMillis() - this.f4067m;
                }
                this.f4061g = j2 + j;
                this.f4067m = System.currentTimeMillis();
            } else {
                if (this.f4070p && this.f4069o) {
                    this.f4070p = false;
                    m5044g();
                }
                this.f4061g = 0;
                this.f4067m = 0;
            }
            this.f4062h = 17;
            m5041a(17);
            long currentTimeMillis = System.currentTimeMillis() - this.f4063i;
            this.f4064j = currentTimeMillis;
            if (currentTimeMillis > 0 && currentTimeMillis < ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
                this.f4060f += currentTimeMillis;
            }
            C1290h c = C1199a.m4880c();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis2 - this.f4066l > 15000) {
                this.f4066l = currentTimeMillis2;
            }
            if (C1199a.m4881d() && currentTimeMillis2 - this.f4065k > 1000) {
                this.f4065k = currentTimeMillis2;
                String a = c.mo6549o().mo6396a();
                if (!a.equals(c.mo6550p())) {
                    c.mo6532b(a);
                    JSONObject b = C1437s.m5599b();
                    C1437s.m5592a(b, "network_type", c.mo6550p());
                    new C1454x("Network.on_status_change", 1, b).mo6834d();
                }
            }
        }
        new C1439u.C1440a().mo6801a("AdColony session ending, releasing Context.").mo6803a(C1439u.f4512e);
        C1199a.m4880c().mo6535c(true);
        C1199a.m4874a((Context) null);
        this.f4072r = true;
        this.f4074t = true;
        mo6503h();
        C1359k0.C1361b bVar = new C1359k0.C1361b(10.0d);
        while (!this.f4073s && !bVar.mo6673a() && this.f4074t) {
            C1199a.m4884g();
            m5041a(100);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6493a(boolean z) {
        ArrayList<C1201a0> b = C1199a.m4880c().mo6548n().mo6841b();
        synchronized (b) {
            Iterator<C1201a0> it = b.iterator();
            while (it.hasNext()) {
                C1201a0 next = it.next();
                JSONObject b2 = C1437s.m5599b();
                C1437s.m5603b(b2, "from_window_focus", z);
                new C1454x("SessionInfo.on_pause", next.mo6390d(), b2).mo6834d();
            }
        }
        this.f4069o = true;
        C1199a.m4884g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6497c(boolean z) {
        C1290h c = C1199a.m4880c();
        if (!this.f4071q) {
            if (this.f4072r) {
                c.mo6535c(false);
                this.f4072r = false;
            }
            this.f4059e = 0;
            this.f4060f = 0;
            this.f4061g = 0;
            this.f4071q = true;
            this.f4068n = true;
            this.f4073s = false;
            new Thread(this).start();
            if (z) {
                JSONObject b = C1437s.m5599b();
                C1437s.m5592a(b, "id", C1359k0.m5301a());
                new C1454x("SessionInfo.on_start", 1, b).mo6834d();
                C1379m0 m0Var = (C1379m0) C1199a.m4880c().mo6548n().mo6843c().get(1);
                if (m0Var != null) {
                    m0Var.mo6734w();
                }
            }
            if (AdColony.f3234a.isShutdown()) {
                AdColony.f3234a = Executors.newSingleThreadExecutor();
            }
            c.mo6547m().mo6825c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo6499d() {
        return this.f4068n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo6501e() {
        return this.f4071q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6502f(boolean z) {
        this.f4074t = z;
    }

    /* renamed from: a */
    private void m5041a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6494b() {
        this.f4059e++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6492a(int i) {
        this.f4058d = i <= 0 ? this.f4058d : (long) (i * 1000);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6491a() {
        return this.f4059e;
    }
}
