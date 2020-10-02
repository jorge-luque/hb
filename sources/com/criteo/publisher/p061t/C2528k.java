package com.criteo.publisher.p061t;

import com.criteo.publisher.C2379c;
import com.criteo.publisher.C2433m;
import com.criteo.publisher.model.C2450k;
import com.criteo.publisher.model.C2451l;
import com.criteo.publisher.model.C2453n;
import com.criteo.publisher.model.C2454o;
import com.criteo.publisher.model.C2455p;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.p058q.C2503a;
import com.criteo.publisher.p058q.C2506d;
import com.criteo.publisher.p061t.C2540m;
import com.criteo.publisher.p061t.C2548r;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;

/* renamed from: com.criteo.publisher.t.k */
public class C2528k implements C2503a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C2548r f8052a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C2559x f8053b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C2379c f8054c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C2506d f8055d;

    /* renamed from: e */
    private final C2455p f8056e;

    /* renamed from: f */
    private final Executor f8057f;

    /* renamed from: com.criteo.publisher.t.k$a */
    class C2529a extends C2433m {
        C2529a() {
        }

        /* renamed from: a */
        public void mo10204a() {
            C2528k.this.f8053b.mo10595a(C2528k.this.f8052a);
        }
    }

    /* renamed from: com.criteo.publisher.t.k$b */
    class C2530b extends C2433m {

        /* renamed from: c */
        final /* synthetic */ C2451l f8059c;

        /* renamed from: com.criteo.publisher.t.k$b$a */
        class C2531a implements C2548r.C2549a {

            /* renamed from: a */
            final /* synthetic */ String f8061a;

            /* renamed from: b */
            final /* synthetic */ long f8062b;

            C2531a(C2530b bVar, String str, long j) {
                this.f8061a = str;
                this.f8062b = j;
            }

            /* renamed from: a */
            public void mo10580a(C2540m.C2541a aVar) {
                aVar.mo10540b(this.f8061a);
                aVar.mo10539b(Long.valueOf(this.f8062b));
            }
        }

        C2530b(C2451l lVar) {
            this.f8059c = lVar;
        }

        /* renamed from: a */
        public void mo10204a() {
            long a = C2528k.this.f8054c.mo10237a();
            C2528k.this.m9505a(this.f8059c, (C2548r.C2549a) new C2531a(this, C2528k.this.f8055d.mo10515a(), a));
        }
    }

    /* renamed from: com.criteo.publisher.t.k$c */
    class C2532c extends C2433m {

        /* renamed from: c */
        final /* synthetic */ C2451l f8063c;

        /* renamed from: d */
        final /* synthetic */ C2454o f8064d;

        /* renamed from: com.criteo.publisher.t.k$c$a */
        class C2533a implements C2548r.C2549a {

            /* renamed from: a */
            final /* synthetic */ boolean f8066a;

            /* renamed from: b */
            final /* synthetic */ long f8067b;

            /* renamed from: c */
            final /* synthetic */ boolean f8068c;

            C2533a(C2532c cVar, boolean z, long j, boolean z2) {
                this.f8066a = z;
                this.f8067b = j;
                this.f8068c = z2;
            }

            /* renamed from: a */
            public void mo10580a(C2540m.C2541a aVar) {
                if (this.f8066a) {
                    aVar.mo10535a(Long.valueOf(this.f8067b));
                    aVar.mo10543c(true);
                } else if (this.f8068c) {
                    aVar.mo10543c(true);
                } else {
                    aVar.mo10535a(Long.valueOf(this.f8067b));
                    aVar.mo10537a(true);
                }
            }
        }

        C2532c(C2451l lVar, C2454o oVar) {
            this.f8063c = lVar;
            this.f8064d = oVar;
        }

        /* renamed from: a */
        public void mo10204a() {
            long a = C2528k.this.f8054c.mo10237a();
            for (C2453n a2 : this.f8063c.mo10371a()) {
                String a3 = a2.mo10319a();
                C2465w a4 = this.f8064d.mo10377a(a3);
                boolean z = a4 == null;
                boolean z2 = a4 != null && !a4.mo10415k();
                C2528k.this.f8052a.mo10574a(a3, (C2548r.C2549a) new C2533a(this, z, a, z2));
                if (z || z2) {
                    C2528k.this.f8053b.mo10596a(C2528k.this.f8052a, a3);
                }
            }
        }
    }

    /* renamed from: com.criteo.publisher.t.k$d */
    class C2534d extends C2433m {

        /* renamed from: c */
        final /* synthetic */ Exception f8069c;

        /* renamed from: d */
        final /* synthetic */ C2451l f8070d;

        C2534d(Exception exc, C2451l lVar) {
            this.f8069c = exc;
            this.f8070d = lVar;
        }

        /* renamed from: a */
        public void mo10204a() {
            Exception exc = this.f8069c;
            if ((exc instanceof SocketTimeoutException) || (exc instanceof InterruptedIOException)) {
                C2528k.this.m9513c(this.f8070d);
            } else {
                C2528k.this.m9509b(this.f8070d);
            }
            for (C2453n a : this.f8070d.mo10371a()) {
                C2528k.this.f8053b.mo10596a(C2528k.this.f8052a, a.mo10319a());
            }
        }
    }

    /* renamed from: com.criteo.publisher.t.k$e */
    class C2535e implements C2548r.C2549a {
        C2535e(C2528k kVar) {
        }

        /* renamed from: a */
        public void mo10580a(C2540m.C2541a aVar) {
            aVar.mo10543c(true);
        }
    }

    /* renamed from: com.criteo.publisher.t.k$f */
    class C2536f implements C2548r.C2549a {
        C2536f(C2528k kVar) {
        }

        /* renamed from: a */
        public void mo10580a(C2540m.C2541a aVar) {
            aVar.mo10541b(true);
            aVar.mo10543c(true);
        }
    }

    /* renamed from: com.criteo.publisher.t.k$g */
    class C2537g extends C2433m {

        /* renamed from: c */
        final /* synthetic */ C2465w f8072c;

        /* renamed from: com.criteo.publisher.t.k$g$a */
        class C2538a implements C2548r.C2549a {

            /* renamed from: a */
            final /* synthetic */ boolean f8074a;

            /* renamed from: b */
            final /* synthetic */ long f8075b;

            C2538a(C2537g gVar, boolean z, long j) {
                this.f8074a = z;
                this.f8075b = j;
            }

            /* renamed from: a */
            public void mo10580a(C2540m.C2541a aVar) {
                if (this.f8074a) {
                    aVar.mo10542c(Long.valueOf(this.f8075b));
                }
                aVar.mo10543c(true);
            }
        }

        C2537g(C2465w wVar) {
            this.f8072c = wVar;
        }

        /* renamed from: a */
        public void mo10204a() {
            String e = this.f8072c.mo10408e();
            if (e != null) {
                C2528k.this.f8052a.mo10574a(e, (C2548r.C2549a) new C2538a(this, !this.f8072c.mo10404a(C2528k.this.f8054c), C2528k.this.f8054c.mo10237a()));
                C2528k.this.f8053b.mo10596a(C2528k.this.f8052a, e);
            }
        }
    }

    public C2528k(C2548r rVar, C2559x xVar, C2379c cVar, C2506d dVar, C2455p pVar, Executor executor) {
        this.f8052a = rVar;
        this.f8053b = xVar;
        this.f8054c = cVar;
        this.f8055d = dVar;
        this.f8056e = pVar;
        this.f8057f = executor;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9513c(C2451l lVar) {
        m9505a(lVar, (C2548r.C2549a) new C2536f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9509b(C2451l lVar) {
        m9505a(lVar, (C2548r.C2549a) new C2535e(this));
    }

    /* renamed from: b */
    private boolean m9511b() {
        return !this.f8056e.mo10386e();
    }

    /* renamed from: a */
    public void mo10509a() {
        if (!m9511b()) {
            this.f8057f.execute(new C2529a());
        }
    }

    /* renamed from: a */
    public void mo10511a(C2451l lVar) {
        if (!m9511b()) {
            this.f8057f.execute(new C2530b(lVar));
        }
    }

    /* renamed from: a */
    public void mo10512a(C2451l lVar, C2454o oVar) {
        if (!m9511b()) {
            this.f8057f.execute(new C2532c(lVar, oVar));
        }
    }

    /* renamed from: a */
    public void mo10513a(C2451l lVar, Exception exc) {
        if (!m9511b()) {
            this.f8057f.execute(new C2534d(exc, lVar));
        }
    }

    /* renamed from: a */
    public void mo10510a(C2450k kVar, C2465w wVar) {
        if (!m9511b()) {
            this.f8057f.execute(new C2537g(wVar));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9505a(C2451l lVar, C2548r.C2549a aVar) {
        for (C2453n a : lVar.mo10371a()) {
            this.f8052a.mo10574a(a.mo10319a(), aVar);
        }
    }
}
