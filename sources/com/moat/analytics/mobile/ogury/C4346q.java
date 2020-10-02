package com.moat.analytics.mobile.ogury;

import android.os.Handler;
import android.os.Looper;
import com.moat.analytics.mobile.ogury.C4315e;
import com.tapjoy.TapjoyConstants;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.moat.analytics.mobile.ogury.q */
final class C4346q {

    /* renamed from: ʻ */
    private static C4346q f11630;
    /* access modifiers changed from: private */

    /* renamed from: ʼ */
    public static final Queue<C4349a> f11631 = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */

    /* renamed from: ʽ */
    public Handler f11632;

    /* renamed from: ˊ */
    volatile int f11633 = 10;
    /* access modifiers changed from: private */

    /* renamed from: ˊॱ */
    public final AtomicInteger f11634 = new AtomicInteger(0);

    /* renamed from: ˋ */
    volatile int f11635 = 200;
    /* access modifiers changed from: private */

    /* renamed from: ˋॱ */
    public volatile long f11636 = 0;

    /* renamed from: ˎ */
    volatile boolean f11637 = false;

    /* renamed from: ˏ */
    volatile boolean f11638 = false;
    /* access modifiers changed from: private */

    /* renamed from: ͺ */
    public final AtomicBoolean f11639 = new AtomicBoolean(false);

    /* renamed from: ॱ */
    volatile int f11640 = C4354e.f11656;
    /* access modifiers changed from: private */

    /* renamed from: ॱˊ */
    public final AtomicBoolean f11641 = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: ॱॱ */
    public long f11642 = 60000;

    /* renamed from: ᐝ */
    private long f11643 = TapjoyConstants.SESSION_ID_INACTIVITY_TIME;

    /* renamed from: com.moat.analytics.mobile.ogury.q$a */
    class C4349a {

        /* renamed from: ˋ */
        final Long f11647;

        /* renamed from: ॱ */
        final C4350b f11649;

        C4349a(Long l, C4350b bVar) {
            this.f11647 = l;
            this.f11649 = bVar;
        }
    }

    /* renamed from: com.moat.analytics.mobile.ogury.q$b */
    interface C4350b {
        /* renamed from: ˋ */
        void mo29162() throws C4332l;
    }

    /* renamed from: com.moat.analytics.mobile.ogury.q$c */
    interface C4351c {
        /* renamed from: ॱ */
        void mo29185(C4329j jVar) throws C4332l;
    }

    /* renamed from: com.moat.analytics.mobile.ogury.q$d */
    class C4352d implements Runnable {

        /* renamed from: ˋ */
        private final String f11651;
        /* access modifiers changed from: private */

        /* renamed from: ˎ */
        public final C4351c f11652;

        /* renamed from: ॱ */
        private final Handler f11653;

        /* synthetic */ C4352d(C4346q qVar, String str, Handler handler, C4351c cVar, byte b) {
            this(str, handler, cVar);
        }

        /* renamed from: ˊ */
        private String m14559() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11651);
            sb.append("?ts=");
            sb.append(System.currentTimeMillis());
            sb.append("&v=2.4.3");
            try {
                return C4330k.m14504(sb.toString()).get();
            } catch (Exception unused) {
                return null;
            }
        }

        public final void run() {
            try {
                String r0 = m14559();
                final C4329j jVar = new C4329j(r0);
                C4346q.this.f11638 = jVar.mo29166();
                C4346q.this.f11637 = jVar.mo29168();
                C4346q.this.f11635 = jVar.mo29165();
                C4346q.this.f11633 = jVar.mo29167();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        try {
                            C4352d.this.f11652.mo29185(jVar);
                        } catch (Exception e) {
                            C4332l.m14509(e);
                        }
                    }
                });
                long unused = C4346q.this.f11636 = System.currentTimeMillis();
                C4346q.this.f11639.compareAndSet(true, false);
                if (r0 != null) {
                    C4346q.this.f11634.set(0);
                } else if (C4346q.this.f11634.incrementAndGet() < 10) {
                    C4346q.this.m14553(C4346q.this.f11642);
                }
            } catch (Exception e) {
                C4332l.m14509(e);
            }
            this.f11653.removeCallbacks(this);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                myLooper.quit();
            }
        }

        private C4352d(String str, Handler handler, C4351c cVar) {
            this.f11652 = cVar;
            this.f11653 = handler;
            StringBuilder sb = new StringBuilder("https://z.moatads.com/");
            sb.append(str);
            sb.append("/android/");
            sb.append("5e29fb7");
            sb.append("/status.json");
            this.f11651 = sb.toString();
        }
    }

    /* renamed from: com.moat.analytics.mobile.ogury.q$e */
    enum C4354e {
        ;
        

        /* renamed from: ˊ */
        public static final int f11656 = 1;

        /* renamed from: ˎ */
        public static final int f11657 = 2;

        static {
            f11658 = new int[]{1, 2};
        }

        public static int[] values$160b2863() {
            return (int[]) f11658.clone();
        }
    }

    private C4346q() {
        try {
            this.f11632 = new Handler(Looper.getMainLooper());
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    /* renamed from: ˊ */
    static synchronized C4346q m14542() {
        C4346q qVar;
        synchronized (C4346q.class) {
            if (f11630 == null) {
                f11630 = new C4346q();
            }
            qVar = f11630;
        }
        return qVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ */
    public final void mo29182() {
        if (System.currentTimeMillis() - this.f11636 > this.f11643) {
            m14553(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ */
    public static void m14549() {
        synchronized (f11631) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = f11631.iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - ((C4349a) it.next()).f11647.longValue() >= 60000) {
                    it.remove();
                }
            }
            if (f11631.size() >= 15) {
                for (int i = 0; i < 5; i++) {
                    f11631.remove();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ */
    public void m14553(final long j) {
        if (this.f11639.compareAndSet(false, true)) {
            C4315e.C43161.m14442(3, "OnOff", this, "Performing status check.");
            new C4351c() {
                public final void run() {
                    Looper.prepare();
                    Handler handler = new Handler();
                    handler.postDelayed(new C4352d(C4346q.this, "OGURY", handler, this, (byte) 0), j);
                    Looper.loop();
                }

                /* renamed from: ॱ */
                public final void mo29185(C4329j jVar) throws C4332l {
                    synchronized (C4346q.f11631) {
                        boolean z = ((C4328i) MoatAnalytics.getInstance()).f11581;
                        if (C4346q.this.f11640 != jVar.mo29169() || (C4346q.this.f11640 == C4354e.f11656 && z)) {
                            C4346q.this.f11640 = jVar.mo29169();
                            if (C4346q.this.f11640 == C4354e.f11656 && z) {
                                C4346q.this.f11640 = C4354e.f11657;
                            }
                            if (C4346q.this.f11640 == C4354e.f11657) {
                                C4315e.C43161.m14442(3, "OnOff", this, "Moat enabled - Version 2.4.3");
                            }
                            for (C4349a aVar : C4346q.f11631) {
                                if (C4346q.this.f11640 == C4354e.f11657) {
                                    aVar.f11649.mo29162();
                                }
                            }
                        }
                        while (!C4346q.f11631.isEmpty()) {
                            C4346q.f11631.remove();
                        }
                    }
                }
            }.start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public final void mo29181(C4350b bVar) throws C4332l {
        if (this.f11640 == C4354e.f11657) {
            bVar.mo29162();
            return;
        }
        m14549();
        f11631.add(new C4349a(Long.valueOf(System.currentTimeMillis()), bVar));
        if (this.f11641.compareAndSet(false, true)) {
            this.f11632.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        if (C4346q.f11631.size() > 0) {
                            C4346q.m14549();
                            C4346q.this.f11632.postDelayed(this, 60000);
                            return;
                        }
                        C4346q.this.f11641.compareAndSet(true, false);
                        C4346q.this.f11632.removeCallbacks(this);
                    } catch (Exception e) {
                        C4332l.m14509(e);
                    }
                }
            }, 60000);
        }
    }
}
