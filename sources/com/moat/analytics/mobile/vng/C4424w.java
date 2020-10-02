package com.moat.analytics.mobile.vng;

import android.os.Handler;
import android.os.Looper;
import com.tapjoy.TapjoyConstants;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.moat.analytics.mobile.vng.w */
class C4424w {

    /* renamed from: h */
    private static C4424w f11854h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Queue<C4431c> f11855i = new ConcurrentLinkedQueue();

    /* renamed from: a */
    volatile C4432d f11856a = C4432d.OFF;

    /* renamed from: b */
    volatile boolean f11857b = false;

    /* renamed from: c */
    volatile boolean f11858c = false;

    /* renamed from: d */
    volatile int f11859d = 200;

    /* renamed from: e */
    volatile int f11860e = 10;

    /* renamed from: f */
    private long f11861f = TapjoyConstants.SESSION_ID_INACTIVITY_TIME;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f11862g = 60000;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f11863j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final AtomicBoolean f11864k = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public volatile long f11865l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final AtomicInteger f11866m = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final AtomicBoolean f11867n = new AtomicBoolean(false);

    /* renamed from: com.moat.analytics.mobile.vng.w$a */
    private class C4428a implements Runnable {

        /* renamed from: b */
        private final Handler f11873b;

        /* renamed from: c */
        private final String f11874c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C4433e f11875d;

        private C4428a(String str, Handler handler, C4433e eVar) {
            this.f11875d = eVar;
            this.f11873b = handler;
            this.f11874c = "https://z.moatads.com/" + str + "/android/" + "fe5b19d" + "/status.json";
        }

        /* renamed from: a */
        private void m14824a() {
            String b = m14825b();
            final C4402m mVar = new C4402m(b);
            C4424w.this.f11857b = mVar.mo29330a();
            C4424w.this.f11858c = mVar.mo29331b();
            C4424w.this.f11859d = mVar.mo29332c();
            C4424w.this.f11860e = mVar.mo29333d();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    try {
                        C4428a.this.f11875d.mo29343a(mVar);
                    } catch (Exception e) {
                        C4403n.m14758a(e);
                    }
                }
            });
            long unused = C4424w.this.f11865l = System.currentTimeMillis();
            C4424w.this.f11867n.compareAndSet(true, false);
            if (b != null) {
                C4424w.this.f11866m.set(0);
            } else if (C4424w.this.f11866m.incrementAndGet() < 10) {
                C4424w wVar = C4424w.this;
                wVar.m14809a(wVar.f11862g);
            }
        }

        /* renamed from: b */
        private String m14825b() {
            try {
                return C4410q.m14777a(this.f11874c + "?ts=" + System.currentTimeMillis() + "&v=" + "2.6.3").mo29251b();
            } catch (Exception unused) {
                return null;
            }
        }

        public void run() {
            try {
                m14824a();
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
            this.f11873b.removeCallbacks(this);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                myLooper.quit();
            }
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.w$b */
    interface C4430b {
        /* renamed from: b */
        void mo29327b();

        /* renamed from: c */
        void mo29328c();
    }

    /* renamed from: com.moat.analytics.mobile.vng.w$c */
    private class C4431c {

        /* renamed from: a */
        final Long f11878a;

        /* renamed from: b */
        final C4430b f11879b;

        C4431c(Long l, C4430b bVar) {
            this.f11878a = l;
            this.f11879b = bVar;
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.w$d */
    enum C4432d {
        OFF,
        ON
    }

    /* renamed from: com.moat.analytics.mobile.vng.w$e */
    interface C4433e {
        /* renamed from: a */
        void mo29343a(C4402m mVar);
    }

    private C4424w() {
        try {
            this.f11863j = new Handler(Looper.getMainLooper());
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
    }

    /* renamed from: a */
    static synchronized C4424w m14808a() {
        C4424w wVar;
        synchronized (C4424w.class) {
            if (f11854h == null) {
                f11854h = new C4424w();
            }
            wVar = f11854h;
        }
        return wVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14809a(final long j) {
        if (this.f11867n.compareAndSet(false, true)) {
            C4409p.m14772a(3, "OnOff", (Object) this, "Performing status check.");
            new Thread() {
                public void run() {
                    Looper.prepare();
                    Handler handler = new Handler();
                    handler.postDelayed(new C4428a("VNG", handler, new C4433e() {
                        /* renamed from: a */
                        public void mo29343a(C4402m mVar) {
                            synchronized (C4424w.f11855i) {
                                boolean z = ((C4400k) MoatAnalytics.getInstance()).f11807a;
                                if (C4424w.this.f11856a != mVar.mo29334e() || (C4424w.this.f11856a == C4432d.OFF && z)) {
                                    C4424w.this.f11856a = mVar.mo29334e();
                                    if (C4424w.this.f11856a == C4432d.OFF && z) {
                                        C4424w.this.f11856a = C4432d.ON;
                                    }
                                    if (C4424w.this.f11856a == C4432d.ON && !C4392i.m14686a().mo29309b()) {
                                        C4424w.this.f11856a = C4432d.OFF;
                                    }
                                    if (C4424w.this.f11856a == C4432d.ON) {
                                        C4409p.m14772a(3, "OnOff", (Object) this, "Moat enabled - Version 2.6.3");
                                    }
                                    for (C4431c cVar : C4424w.f11855i) {
                                        if (C4424w.this.f11856a == C4432d.ON) {
                                            cVar.f11879b.mo29327b();
                                        } else {
                                            cVar.f11879b.mo29328c();
                                        }
                                    }
                                }
                                while (!C4424w.f11855i.isEmpty()) {
                                    C4424w.f11855i.remove();
                                }
                            }
                        }
                    }), j);
                    Looper.loop();
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m14816d() {
        synchronized (f11855i) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = f11855i.iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - ((C4431c) it.next()).f11878a.longValue() >= 60000) {
                    it.remove();
                }
            }
            if (f11855i.size() >= 15) {
                for (int i = 0; i < 5; i++) {
                    f11855i.remove();
                }
            }
        }
    }

    /* renamed from: e */
    private void m14818e() {
        if (this.f11864k.compareAndSet(false, true)) {
            this.f11863j.postDelayed(new Runnable() {
                public void run() {
                    try {
                        if (C4424w.f11855i.size() > 0) {
                            C4424w.this.m14816d();
                            C4424w.this.f11863j.postDelayed(this, 60000);
                            return;
                        }
                        C4424w.this.f11864k.compareAndSet(true, false);
                        C4424w.this.f11863j.removeCallbacks(this);
                    } catch (Exception e) {
                        C4403n.m14758a(e);
                    }
                }
            }, 60000);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29340a(C4430b bVar) {
        if (this.f11856a == C4432d.ON) {
            bVar.mo29327b();
            return;
        }
        m14816d();
        f11855i.add(new C4431c(Long.valueOf(System.currentTimeMillis()), bVar));
        m14818e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29341b() {
        if (System.currentTimeMillis() - this.f11865l > this.f11861f) {
            m14809a(0);
        }
    }
}
