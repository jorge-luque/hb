package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1987d;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C2029r;
import com.vungle.warren.AdLoader;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.d.s */
public class C1907s {

    /* renamed from: a */
    private final String f6280a = "TaskManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1941j f6281b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1977q f6282c;

    /* renamed from: d */
    private final ScheduledThreadPoolExecutor f6283d;

    /* renamed from: e */
    private final ScheduledThreadPoolExecutor f6284e;

    /* renamed from: f */
    private final ScheduledThreadPoolExecutor f6285f;

    /* renamed from: g */
    private final ScheduledThreadPoolExecutor f6286g;

    /* renamed from: h */
    private final ScheduledThreadPoolExecutor f6287h;

    /* renamed from: i */
    private final ScheduledThreadPoolExecutor f6288i;

    /* renamed from: j */
    private final ScheduledThreadPoolExecutor f6289j;

    /* renamed from: k */
    private final ScheduledThreadPoolExecutor f6290k;

    /* renamed from: l */
    private final ScheduledThreadPoolExecutor f6291l;

    /* renamed from: m */
    private final ScheduledThreadPoolExecutor f6292m;

    /* renamed from: n */
    private final ScheduledThreadPoolExecutor f6293n;

    /* renamed from: o */
    private final ScheduledThreadPoolExecutor f6294o;

    /* renamed from: p */
    private final ScheduledThreadPoolExecutor f6295p;

    /* renamed from: q */
    private final ScheduledThreadPoolExecutor f6296q;

    /* renamed from: r */
    private final ScheduledThreadPoolExecutor f6297r;

    /* renamed from: s */
    private final ScheduledThreadPoolExecutor f6298s;

    /* renamed from: t */
    private final ScheduledThreadPoolExecutor f6299t;

    /* renamed from: u */
    private final ScheduledThreadPoolExecutor f6300u;

    /* renamed from: v */
    private final ScheduledThreadPoolExecutor f6301v;

    /* renamed from: w */
    private final ScheduledThreadPoolExecutor f6302w;

    /* renamed from: x */
    private final List<C1912c> f6303x = new ArrayList(5);

    /* renamed from: y */
    private final Object f6304y = new Object();

    /* renamed from: z */
    private boolean f6305z;

    /* renamed from: com.applovin.impl.sdk.d.s$a */
    public enum C1909a {
        MAIN,
        f6310b,
        BACKGROUND,
        ADVERTISING_INFO_COLLECTION,
        POSTBACKS,
        CACHING_INTERSTITIAL,
        CACHING_INCENTIVIZED,
        CACHING_OTHER,
        REWARD,
        MEDIATION_MAIN,
        MEDIATION_TIMEOUT,
        MEDIATION_BACKGROUND,
        MEDIATION_POSTBACKS,
        MEDIATION_BANNER,
        MEDIATION_INTERSTITIAL,
        MEDIATION_INCENTIVIZED,
        MEDIATION_REWARD
    }

    /* renamed from: com.applovin.impl.sdk.d.s$b */
    private class C1910b implements ThreadFactory {

        /* renamed from: b */
        private final String f6328b;

        C1910b(String str) {
            this.f6328b = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f6328b + ":" + C2029r.m7997a(C1907s.this.f6281b.mo8599t()));
            thread.setDaemon(true);
            thread.setPriority(10);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    C1907s.this.f6282c.mo8743b("TaskManager", "Caught unhandled exception", th);
                }
            });
            return thread;
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.s$c */
    private class C1912c implements Runnable {

        /* renamed from: b */
        private final String f6331b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final C1864a f6332c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C1909a f6333d;

        C1912c(C1864a aVar, C1909a aVar2) {
            this.f6331b = aVar.mo8411e();
            this.f6332c = aVar;
            this.f6333d = aVar2;
        }

        public void run() {
            StringBuilder sb;
            C1977q qVar;
            long j;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                C1991g.m7837a();
                if (C1907s.this.f6281b.mo8582c()) {
                    if (!this.f6332c.mo8413g()) {
                        C1907s.this.f6282c.mo8744c(this.f6331b, "Task re-scheduled...");
                        C1907s.this.mo8476a(this.f6332c, this.f6333d, AdLoader.RETRY_DELAY);
                        j = C1907s.this.m7348a(this.f6333d) - 1;
                        qVar = C1907s.this.f6282c;
                        sb = new StringBuilder();
                        sb.append(this.f6333d);
                        sb.append(" queue finished task ");
                        sb.append(this.f6332c.mo8411e());
                        sb.append(" with queue size ");
                        sb.append(j);
                        qVar.mo8744c("TaskManager", sb.toString());
                    }
                }
                C1907s.this.f6282c.mo8744c(this.f6331b, "Task started execution...");
                this.f6332c.run();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                C1977q b = C1907s.this.f6282c;
                String str = this.f6331b;
                b.mo8744c(str, "Task finished executing in " + currentTimeMillis2 + " ms...");
                j = C1907s.this.m7348a(this.f6333d) - 1;
                qVar = C1907s.this.f6282c;
                sb = new StringBuilder();
            } catch (Throwable th) {
                C1977q b2 = C1907s.this.f6282c;
                b2.mo8744c("TaskManager", this.f6333d + " queue finished task " + this.f6332c.mo8411e() + " with queue size " + (C1907s.this.m7348a(this.f6333d) - 1));
                throw th;
            }
            sb.append(this.f6333d);
            sb.append(" queue finished task ");
            sb.append(this.f6332c.mo8411e());
            sb.append(" with queue size ");
            sb.append(j);
            qVar.mo8744c("TaskManager", sb.toString());
        }
    }

    public C1907s(C1941j jVar) {
        this.f6281b = jVar;
        this.f6282c = jVar.mo8602v();
        this.f6283d = m7351a("main");
        this.f6284e = m7351a("timeout");
        this.f6285f = m7351a("back");
        this.f6286g = m7351a("advertising_info_collection");
        this.f6287h = m7351a("postbacks");
        this.f6288i = m7351a("caching_interstitial");
        this.f6289j = m7351a("caching_incentivized");
        this.f6290k = m7351a("caching_other");
        this.f6291l = m7351a("reward");
        this.f6292m = m7351a("mediation_main");
        this.f6293n = m7351a("mediation_timeout");
        this.f6294o = m7351a("mediation_background");
        this.f6295p = m7351a("mediation_postbacks");
        this.f6296q = m7351a("mediation_banner");
        this.f6297r = m7351a("mediation_interstitial");
        this.f6298s = m7351a("mediation_incentivized");
        this.f6299t = m7351a("mediation_reward");
        this.f6300u = m7352a("auxiliary_operations", ((Integer) jVar.mo8549a(C1841c.f5951ct)).intValue());
        this.f6301v = m7352a("caching_operations", ((Integer) jVar.mo8549a(C1841c.f5952cu)).intValue());
        this.f6302w = m7352a("shared_thread_pool", ((Integer) jVar.mo8549a(C1841c.f5834ah)).intValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public long m7348a(C1909a aVar) {
        long taskCount;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (aVar == C1909a.MAIN) {
            taskCount = this.f6283d.getTaskCount();
            scheduledThreadPoolExecutor = this.f6283d;
        } else if (aVar == C1909a.f6310b) {
            taskCount = this.f6284e.getTaskCount();
            scheduledThreadPoolExecutor = this.f6284e;
        } else if (aVar == C1909a.BACKGROUND) {
            taskCount = this.f6285f.getTaskCount();
            scheduledThreadPoolExecutor = this.f6285f;
        } else if (aVar == C1909a.ADVERTISING_INFO_COLLECTION) {
            taskCount = this.f6286g.getTaskCount();
            scheduledThreadPoolExecutor = this.f6286g;
        } else if (aVar == C1909a.POSTBACKS) {
            taskCount = this.f6287h.getTaskCount();
            scheduledThreadPoolExecutor = this.f6287h;
        } else if (aVar == C1909a.CACHING_INTERSTITIAL) {
            taskCount = this.f6288i.getTaskCount();
            scheduledThreadPoolExecutor = this.f6288i;
        } else if (aVar == C1909a.CACHING_INCENTIVIZED) {
            taskCount = this.f6289j.getTaskCount();
            scheduledThreadPoolExecutor = this.f6289j;
        } else if (aVar == C1909a.CACHING_OTHER) {
            taskCount = this.f6290k.getTaskCount();
            scheduledThreadPoolExecutor = this.f6290k;
        } else if (aVar == C1909a.REWARD) {
            taskCount = this.f6291l.getTaskCount();
            scheduledThreadPoolExecutor = this.f6291l;
        } else if (aVar == C1909a.MEDIATION_MAIN) {
            taskCount = this.f6292m.getTaskCount();
            scheduledThreadPoolExecutor = this.f6292m;
        } else if (aVar == C1909a.MEDIATION_TIMEOUT) {
            taskCount = this.f6293n.getTaskCount();
            scheduledThreadPoolExecutor = this.f6293n;
        } else if (aVar == C1909a.MEDIATION_BACKGROUND) {
            taskCount = this.f6294o.getTaskCount();
            scheduledThreadPoolExecutor = this.f6294o;
        } else if (aVar == C1909a.MEDIATION_POSTBACKS) {
            taskCount = this.f6295p.getTaskCount();
            scheduledThreadPoolExecutor = this.f6295p;
        } else if (aVar == C1909a.MEDIATION_BANNER) {
            taskCount = this.f6296q.getTaskCount();
            scheduledThreadPoolExecutor = this.f6296q;
        } else if (aVar == C1909a.MEDIATION_INTERSTITIAL) {
            taskCount = this.f6297r.getTaskCount();
            scheduledThreadPoolExecutor = this.f6297r;
        } else if (aVar == C1909a.MEDIATION_INCENTIVIZED) {
            taskCount = this.f6298s.getTaskCount();
            scheduledThreadPoolExecutor = this.f6298s;
        } else if (aVar != C1909a.MEDIATION_REWARD) {
            return 0;
        } else {
            taskCount = this.f6299t.getTaskCount();
            scheduledThreadPoolExecutor = this.f6299t;
        }
        return taskCount - scheduledThreadPoolExecutor.getCompletedTaskCount();
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m7351a(String str) {
        return m7352a(str, 1);
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m7352a(String str, int i) {
        return new ScheduledThreadPoolExecutor(i, new C1910b(str));
    }

    /* renamed from: a */
    private void m7353a(final Runnable runnable, long j, final ScheduledExecutorService scheduledExecutorService, boolean z) {
        if (j <= 0) {
            scheduledExecutorService.submit(runnable);
        } else if (z) {
            C1987d.m7825a(j, this.f6281b, new Runnable() {
                public void run() {
                    scheduledExecutorService.execute(runnable);
                }
            });
        } else {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    private boolean m7354a(C1912c cVar) {
        if (cVar.f6332c.mo8413g()) {
            return false;
        }
        synchronized (this.f6304y) {
            if (this.f6305z) {
                return false;
            }
            this.f6303x.add(cVar);
            return true;
        }
    }

    /* renamed from: a */
    public void mo8474a(C1864a aVar) {
        if (aVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                C1977q qVar = this.f6282c;
                qVar.mo8744c("TaskManager", "Executing " + aVar.mo8411e() + " immediately...");
                aVar.run();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                C1977q qVar2 = this.f6282c;
                qVar2.mo8744c("TaskManager", aVar.mo8411e() + " finished executing in " + currentTimeMillis2 + " ms...");
            } catch (Throwable th) {
                this.f6282c.mo8743b(aVar.mo8411e(), "Task failed execution", th);
            }
        } else {
            this.f6282c.mo8746e("TaskManager", "Attempted to execute null task immediately");
        }
    }

    /* renamed from: a */
    public void mo8475a(C1864a aVar, C1909a aVar2) {
        mo8476a(aVar, aVar2, 0);
    }

    /* renamed from: a */
    public void mo8476a(C1864a aVar, C1909a aVar2, long j) {
        mo8477a(aVar, aVar2, j, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.applovin.impl.sdk.d.s$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: com.applovin.impl.sdk.d.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: com.applovin.impl.sdk.d.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: com.applovin.impl.sdk.d.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8477a(com.applovin.impl.sdk.p052d.C1864a r12, com.applovin.impl.sdk.p052d.C1907s.C1909a r13, long r14, boolean r16) {
        /*
            r11 = this;
            r6 = r11
            r1 = r12
            r0 = r13
            r2 = r14
            if (r1 == 0) goto L_0x0124
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x010d
            com.applovin.impl.sdk.d.s$c r4 = new com.applovin.impl.sdk.d.s$c
            r4.<init>(r12, r13)
            boolean r5 = r11.m7354a((com.applovin.impl.sdk.p052d.C1907s.C1912c) r4)
            if (r5 != 0) goto L_0x00e9
            com.applovin.impl.sdk.j r5 = r6.f6281b
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r7 = com.applovin.impl.sdk.p050b.C1841c.f5835ai
            java.lang.Object r5 = r5.mo8549a(r7)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0033
            java.util.concurrent.ScheduledThreadPoolExecutor r4 = r6.f6302w
            r0 = r11
            r1 = r12
            r2 = r14
        L_0x002c:
            r5 = r16
            r0.m7353a((java.lang.Runnable) r1, (long) r2, (java.util.concurrent.ScheduledExecutorService) r4, (boolean) r5)
            goto L_0x010c
        L_0x0033:
            long r7 = r11.m7348a((com.applovin.impl.sdk.p052d.C1907s.C1909a) r13)
            r9 = 1
            long r7 = r7 + r9
            com.applovin.impl.sdk.q r5 = r6.f6282c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Scheduling "
            r9.append(r10)
            java.lang.String r1 = r12.mo8411e()
            r9.append(r1)
            java.lang.String r1 = " on "
            r9.append(r1)
            r9.append(r13)
            java.lang.String r1 = " queue in "
            r9.append(r1)
            r9.append(r14)
            java.lang.String r1 = "ms with new queue size "
            r9.append(r1)
            r9.append(r7)
            java.lang.String r1 = r9.toString()
            java.lang.String r7 = "TaskManager"
            r5.mo8742b(r7, r1)
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.MAIN
            if (r0 != r1) goto L_0x0079
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6283d
        L_0x0074:
            r0 = r11
            r1 = r4
            r2 = r14
            r4 = r5
            goto L_0x002c
        L_0x0079:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.f6310b
            if (r0 != r1) goto L_0x0080
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6284e
            goto L_0x0074
        L_0x0080:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.BACKGROUND
            if (r0 != r1) goto L_0x0087
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6285f
            goto L_0x0074
        L_0x0087:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.ADVERTISING_INFO_COLLECTION
            if (r0 != r1) goto L_0x008e
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6286g
            goto L_0x0074
        L_0x008e:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.POSTBACKS
            if (r0 != r1) goto L_0x0095
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6287h
            goto L_0x0074
        L_0x0095:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.CACHING_INTERSTITIAL
            if (r0 != r1) goto L_0x009c
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6288i
            goto L_0x0074
        L_0x009c:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.CACHING_INCENTIVIZED
            if (r0 != r1) goto L_0x00a3
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6289j
            goto L_0x0074
        L_0x00a3:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.CACHING_OTHER
            if (r0 != r1) goto L_0x00aa
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6290k
            goto L_0x0074
        L_0x00aa:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.REWARD
            if (r0 != r1) goto L_0x00b1
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6291l
            goto L_0x0074
        L_0x00b1:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.MEDIATION_MAIN
            if (r0 != r1) goto L_0x00b8
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6292m
            goto L_0x0074
        L_0x00b8:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.MEDIATION_TIMEOUT
            if (r0 != r1) goto L_0x00bf
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6293n
            goto L_0x0074
        L_0x00bf:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.MEDIATION_BACKGROUND
            if (r0 != r1) goto L_0x00c6
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6294o
            goto L_0x0074
        L_0x00c6:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.MEDIATION_POSTBACKS
            if (r0 != r1) goto L_0x00cd
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6295p
            goto L_0x0074
        L_0x00cd:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.MEDIATION_BANNER
            if (r0 != r1) goto L_0x00d4
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6296q
            goto L_0x0074
        L_0x00d4:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.MEDIATION_INTERSTITIAL
            if (r0 != r1) goto L_0x00db
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6297r
            goto L_0x0074
        L_0x00db:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.MEDIATION_INCENTIVIZED
            if (r0 != r1) goto L_0x00e2
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6298s
            goto L_0x0074
        L_0x00e2:
            com.applovin.impl.sdk.d.s$a r1 = com.applovin.impl.sdk.p052d.C1907s.C1909a.MEDIATION_REWARD
            if (r0 != r1) goto L_0x010c
            java.util.concurrent.ScheduledThreadPoolExecutor r5 = r6.f6299t
            goto L_0x0074
        L_0x00e9:
            com.applovin.impl.sdk.q r0 = r6.f6282c
            java.lang.String r2 = r12.mo8411e()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Task "
            r3.append(r4)
            java.lang.String r1 = r12.mo8411e()
            r3.append(r1)
            java.lang.String r1 = " execution delayed until after init"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.mo8744c(r2, r1)
        L_0x010c:
            return
        L_0x010d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Invalid delay specified: "
            r1.append(r4)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0124:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No task specified"
            r0.<init>(r1)
            goto L_0x012d
        L_0x012c:
            throw r0
        L_0x012d:
            goto L_0x012c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p052d.C1907s.mo8477a(com.applovin.impl.sdk.d.a, com.applovin.impl.sdk.d.s$a, long, boolean):void");
    }

    /* renamed from: a */
    public boolean mo8478a() {
        return this.f6305z;
    }

    /* renamed from: b */
    public ScheduledExecutorService mo8479b() {
        return this.f6300u;
    }

    /* renamed from: c */
    public ScheduledExecutorService mo8480c() {
        return this.f6301v;
    }

    /* renamed from: d */
    public void mo8481d() {
        synchronized (this.f6304y) {
            this.f6305z = false;
        }
    }

    /* renamed from: e */
    public void mo8482e() {
        synchronized (this.f6304y) {
            this.f6305z = true;
            for (C1912c next : this.f6303x) {
                mo8475a(next.f6332c, next.f6333d);
            }
            this.f6303x.clear();
        }
    }
}
