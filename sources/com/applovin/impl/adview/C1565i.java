package com.applovin.impl.adview;

import android.os.Handler;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.applovin.impl.adview.i */
public final class C1565i {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1977q f4917a;

    /* renamed from: b */
    private final Handler f4918b;

    /* renamed from: c */
    private final Set<C1568b> f4919c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AtomicInteger f4920d = new AtomicInteger();

    /* renamed from: com.applovin.impl.adview.i$a */
    public interface C1567a {
        /* renamed from: a */
        void mo7350a();

        /* renamed from: b */
        boolean mo7351b();
    }

    /* renamed from: com.applovin.impl.adview.i$b */
    private static class C1568b {

        /* renamed from: a */
        private final String f4924a;

        /* renamed from: b */
        private final C1567a f4925b;

        /* renamed from: c */
        private final long f4926c;

        private C1568b(String str, long j, C1567a aVar) {
            this.f4924a = str;
            this.f4926c = j;
            this.f4925b = aVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m6029a() {
            return this.f4924a;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public long m6031b() {
            return this.f4926c;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public C1567a m6034c() {
            return this.f4925b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1568b)) {
                return false;
            }
            String str = this.f4924a;
            String str2 = ((C1568b) obj).f4924a;
            return str != null ? str.equalsIgnoreCase(str2) : str2 == null;
        }

        public int hashCode() {
            String str = this.f4924a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "CountdownProxy{identifier='" + this.f4924a + '\'' + ", countdownStepMillis=" + this.f4926c + '}';
        }
    }

    public C1565i(Handler handler, C1941j jVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else if (jVar != null) {
            this.f4918b = handler;
            this.f4917a = jVar.mo8602v();
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6020a(final C1568b bVar, final int i) {
        this.f4918b.postDelayed(new Runnable() {
            public void run() {
                C1567a b = bVar.m6034c();
                if (!b.mo7351b()) {
                    C1977q b2 = C1565i.this.f4917a;
                    b2.mo8742b("CountdownManager", "Ending countdown for " + bVar.m6029a());
                } else if (C1565i.this.f4920d.get() == i) {
                    try {
                        b.mo7350a();
                    } catch (Throwable th) {
                        C1977q b3 = C1565i.this.f4917a;
                        b3.mo8743b("CountdownManager", "Encountered error on countdown step for: " + bVar.m6029a(), th);
                    }
                    C1565i.this.m6020a(bVar, i);
                } else {
                    C1977q b4 = C1565i.this.f4917a;
                    b4.mo8745d("CountdownManager", "Killing duplicate countdown from previous generation: " + bVar.m6029a());
                }
            }
        }, bVar.m6031b());
    }

    /* renamed from: a */
    public void mo7441a() {
        HashSet<C1568b> hashSet = new HashSet<>(this.f4919c);
        C1977q qVar = this.f4917a;
        qVar.mo8742b("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        int incrementAndGet = this.f4920d.incrementAndGet();
        for (C1568b bVar : hashSet) {
            C1977q qVar2 = this.f4917a;
            qVar2.mo8742b("CountdownManager", "Starting countdown: " + bVar.m6029a() + " for generation " + incrementAndGet + "...");
            m6020a(bVar, incrementAndGet);
        }
    }

    /* renamed from: a */
    public void mo7442a(String str, long j, C1567a aVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        } else if (this.f4918b != null) {
            C1977q qVar = this.f4917a;
            qVar.mo8742b("CountdownManager", "Adding countdown: " + str);
            this.f4919c.add(new C1568b(str, j, aVar));
        } else {
            throw new IllegalArgumentException("No handler specified.");
        }
    }

    /* renamed from: b */
    public void mo7443b() {
        this.f4917a.mo8742b("CountdownManager", "Removing all countdowns...");
        mo7444c();
        this.f4919c.clear();
    }

    /* renamed from: c */
    public void mo7444c() {
        this.f4917a.mo8742b("CountdownManager", "Stopping countdowns...");
        this.f4920d.incrementAndGet();
        this.f4918b.removeCallbacksAndMessages((Object) null);
    }
}
