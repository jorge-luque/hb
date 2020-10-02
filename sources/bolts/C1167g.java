package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: bolts.g */
/* compiled from: Task */
public class C1167g<TResult> {

    /* renamed from: i */
    private static final Executor f3197i = C1162d.m4767b();

    /* renamed from: j */
    private static volatile C1175g f3198j;

    /* renamed from: k */
    private static C1167g<?> f3199k = new C1167g<>((Object) null);

    /* renamed from: l */
    private static C1167g<Boolean> f3200l = new C1167g<>(true);

    /* renamed from: m */
    private static C1167g<Boolean> f3201m = new C1167g<>(false);

    /* renamed from: n */
    private static C1167g<?> f3202n = new C1167g<>(true);

    /* renamed from: a */
    private final Object f3203a = new Object();

    /* renamed from: b */
    private boolean f3204b;

    /* renamed from: c */
    private boolean f3205c;

    /* renamed from: d */
    private TResult f3206d;

    /* renamed from: e */
    private Exception f3207e;

    /* renamed from: f */
    private boolean f3208f;

    /* renamed from: g */
    private C1177i f3209g;

    /* renamed from: h */
    private List<C1166f<TResult, Void>> f3210h = new ArrayList();

    /* renamed from: bolts.g$a */
    /* compiled from: Task */
    class C1168a implements C1166f<TResult, Void> {

        /* renamed from: a */
        final /* synthetic */ C1176h f3211a;

        /* renamed from: b */
        final /* synthetic */ C1166f f3212b;

        /* renamed from: c */
        final /* synthetic */ Executor f3213c;

        /* renamed from: d */
        final /* synthetic */ C1165e f3214d;

        C1168a(C1167g gVar, C1176h hVar, C1166f fVar, Executor executor, C1165e eVar) {
            this.f3211a = hVar;
            this.f3212b = fVar;
            this.f3213c = executor;
            this.f3214d = eVar;
        }

        public Void then(C1167g<TResult> gVar) {
            C1167g.m4777d(this.f3211a, this.f3212b, gVar, this.f3213c, this.f3214d);
            return null;
        }
    }

    /* renamed from: bolts.g$b */
    /* compiled from: Task */
    class C1169b implements C1166f<TResult, Void> {

        /* renamed from: a */
        final /* synthetic */ C1176h f3215a;

        /* renamed from: b */
        final /* synthetic */ C1166f f3216b;

        /* renamed from: c */
        final /* synthetic */ Executor f3217c;

        /* renamed from: d */
        final /* synthetic */ C1165e f3218d;

        C1169b(C1167g gVar, C1176h hVar, C1166f fVar, Executor executor, C1165e eVar) {
            this.f3215a = hVar;
            this.f3216b = fVar;
            this.f3217c = executor;
            this.f3218d = eVar;
        }

        public Void then(C1167g<TResult> gVar) {
            C1167g.m4776c(this.f3215a, this.f3216b, gVar, this.f3217c, this.f3218d);
            return null;
        }
    }

    /* renamed from: bolts.g$c */
    /* compiled from: Task */
    class C1170c implements C1166f<TResult, C1167g<TContinuationResult>> {

        /* renamed from: a */
        final /* synthetic */ C1165e f3219a;

        /* renamed from: b */
        final /* synthetic */ C1166f f3220b;

        C1170c(C1167g gVar, C1165e eVar, C1166f fVar) {
            this.f3219a = eVar;
            this.f3220b = fVar;
        }

        public C1167g<TContinuationResult> then(C1167g<TResult> gVar) {
            C1165e eVar = this.f3219a;
            if (eVar != null) {
                eVar.mo6177a();
                throw null;
            } else if (gVar.mo6191e()) {
                return C1167g.m4773b(gVar.mo6182a());
            } else {
                if (gVar.mo6189c()) {
                    return C1167g.m4778g();
                }
                return gVar.mo6179a((C1166f<TResult, TContinuationResult>) this.f3220b);
            }
        }
    }

    /* renamed from: bolts.g$d */
    /* compiled from: Task */
    static class C1171d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1165e f3221a;

        /* renamed from: b */
        final /* synthetic */ C1176h f3222b;

        /* renamed from: c */
        final /* synthetic */ C1166f f3223c;

        /* renamed from: d */
        final /* synthetic */ C1167g f3224d;

        C1171d(C1165e eVar, C1176h hVar, C1166f fVar, C1167g gVar) {
            this.f3221a = eVar;
            this.f3222b = hVar;
            this.f3223c = fVar;
            this.f3224d = gVar;
        }

        public void run() {
            C1165e eVar = this.f3221a;
            if (eVar == null) {
                try {
                    this.f3222b.mo6198a(this.f3223c.then(this.f3224d));
                } catch (CancellationException unused) {
                    this.f3222b.mo6199b();
                } catch (Exception e) {
                    this.f3222b.mo6197a(e);
                }
            } else {
                eVar.mo6177a();
                throw null;
            }
        }
    }

    /* renamed from: bolts.g$e */
    /* compiled from: Task */
    static class C1172e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1165e f3225a;

        /* renamed from: b */
        final /* synthetic */ C1176h f3226b;

        /* renamed from: c */
        final /* synthetic */ C1166f f3227c;

        /* renamed from: d */
        final /* synthetic */ C1167g f3228d;

        /* renamed from: bolts.g$e$a */
        /* compiled from: Task */
        class C1173a implements C1166f<TContinuationResult, Void> {
            C1173a() {
            }

            public Void then(C1167g<TContinuationResult> gVar) {
                C1165e eVar = C1172e.this.f3225a;
                if (eVar == null) {
                    if (gVar.mo6189c()) {
                        C1172e.this.f3226b.mo6199b();
                    } else if (gVar.mo6191e()) {
                        C1172e.this.f3226b.mo6197a(gVar.mo6182a());
                    } else {
                        C1172e.this.f3226b.mo6198a(gVar.mo6187b());
                    }
                    return null;
                }
                eVar.mo6177a();
                throw null;
            }
        }

        C1172e(C1165e eVar, C1176h hVar, C1166f fVar, C1167g gVar) {
            this.f3225a = eVar;
            this.f3226b = hVar;
            this.f3227c = fVar;
            this.f3228d = gVar;
        }

        public void run() {
            C1165e eVar = this.f3225a;
            if (eVar == null) {
                try {
                    C1167g gVar = (C1167g) this.f3227c.then(this.f3228d);
                    if (gVar == null) {
                        this.f3226b.mo6198a(null);
                    } else {
                        gVar.mo6179a(new C1173a());
                    }
                } catch (CancellationException unused) {
                    this.f3226b.mo6199b();
                } catch (Exception e) {
                    this.f3226b.mo6197a(e);
                }
            } else {
                eVar.mo6177a();
                throw null;
            }
        }
    }

    /* renamed from: bolts.g$f */
    /* compiled from: Task */
    public class C1174f extends C1176h<TResult> {
        C1174f(C1167g gVar) {
        }
    }

    /* renamed from: bolts.g$g */
    /* compiled from: Task */
    public interface C1175g {
        /* renamed from: a */
        void mo6195a(C1167g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    static {
        C1162d.m4766a();
        C1156a.m4763b();
    }

    C1167g() {
    }

    /* renamed from: g */
    public static <TResult> C1167g<TResult> m4778g() {
        return f3202n;
    }

    /* renamed from: h */
    public static <TResult> C1167g<TResult>.f m4779h() {
        C1167g gVar = new C1167g();
        gVar.getClass();
        return new C1174f(gVar);
    }

    /* renamed from: i */
    public static C1175g m4780i() {
        return f3198j;
    }

    /* renamed from: j */
    private void m4781j() {
        synchronized (this.f3203a) {
            for (C1166f then : this.f3210h) {
                try {
                    then.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f3210h = null;
        }
    }

    /* renamed from: c */
    public boolean mo6189c() {
        boolean z;
        synchronized (this.f3203a) {
            z = this.f3205c;
        }
        return z;
    }

    /* renamed from: d */
    public boolean mo6190d() {
        boolean z;
        synchronized (this.f3203a) {
            z = this.f3204b;
        }
        return z;
    }

    /* renamed from: e */
    public boolean mo6191e() {
        boolean z;
        synchronized (this.f3203a) {
            z = mo6182a() != null;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo6192f() {
        synchronized (this.f3203a) {
            if (this.f3204b) {
                return false;
            }
            this.f3204b = true;
            this.f3205c = true;
            this.f3203a.notifyAll();
            m4781j();
            return true;
        }
    }

    /* renamed from: a */
    public Exception mo6182a() {
        Exception exc;
        synchronized (this.f3203a) {
            if (this.f3207e != null) {
                this.f3208f = true;
                if (this.f3209g != null) {
                    this.f3209g.mo6203a();
                    this.f3209g = null;
                }
            }
            exc = this.f3207e;
        }
        return exc;
    }

    /* renamed from: b */
    public TResult mo6187b() {
        TResult tresult;
        synchronized (this.f3203a) {
            tresult = this.f3206d;
        }
        return tresult;
    }

    private C1167g(TResult tresult) {
        mo6184a(tresult);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static <TContinuationResult, TResult> void m4777d(C1176h<TContinuationResult> hVar, C1166f<TResult, TContinuationResult> fVar, C1167g<TResult> gVar, Executor executor, C1165e eVar) {
        try {
            executor.execute(new C1171d(eVar, hVar, fVar, gVar));
        } catch (Exception e) {
            hVar.mo6197a((Exception) new ExecutorException(e));
        }
    }

    /* renamed from: c */
    public <TContinuationResult> C1167g<TContinuationResult> mo6188c(C1166f<TResult, TContinuationResult> fVar, Executor executor, C1165e eVar) {
        return mo6180a(new C1170c(this, eVar, fVar), executor);
    }

    /* renamed from: b */
    public static <TResult> C1167g<TResult> m4774b(TResult tresult) {
        if (tresult == null) {
            return f3199k;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? f3200l : f3201m;
        }
        C1176h hVar = new C1176h();
        hVar.mo6198a(tresult);
        return hVar.mo6196a();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static <TContinuationResult, TResult> void m4776c(C1176h<TContinuationResult> hVar, C1166f<TResult, C1167g<TContinuationResult>> fVar, C1167g<TResult> gVar, Executor executor, C1165e eVar) {
        try {
            executor.execute(new C1172e(eVar, hVar, fVar, gVar));
        } catch (Exception e) {
            hVar.mo6197a((Exception) new ExecutorException(e));
        }
    }

    private C1167g(boolean z) {
        if (z) {
            mo6192f();
        } else {
            mo6184a((Object) null);
        }
    }

    /* renamed from: a */
    public <TContinuationResult> C1167g<TContinuationResult> mo6181a(C1166f<TResult, TContinuationResult> fVar, Executor executor, C1165e eVar) {
        boolean d;
        C1176h hVar = new C1176h();
        synchronized (this.f3203a) {
            d = mo6190d();
            if (!d) {
                this.f3210h.add(new C1168a(this, hVar, fVar, executor, eVar));
            }
        }
        if (d) {
            m4777d(hVar, fVar, this, executor, eVar);
        }
        return hVar.mo6196a();
    }

    /* renamed from: b */
    public static <TResult> C1167g<TResult> m4773b(Exception exc) {
        C1176h hVar = new C1176h();
        hVar.mo6197a(exc);
        return hVar.mo6196a();
    }

    /* renamed from: b */
    public <TContinuationResult> C1167g<TContinuationResult> mo6186b(C1166f<TResult, C1167g<TContinuationResult>> fVar, Executor executor, C1165e eVar) {
        boolean d;
        C1176h hVar = new C1176h();
        synchronized (this.f3203a) {
            d = mo6190d();
            if (!d) {
                this.f3210h.add(new C1169b(this, hVar, fVar, executor, eVar));
            }
        }
        if (d) {
            m4776c(hVar, fVar, this, executor, eVar);
        }
        return hVar.mo6196a();
    }

    /* renamed from: a */
    public <TContinuationResult> C1167g<TContinuationResult> mo6179a(C1166f<TResult, TContinuationResult> fVar) {
        return mo6181a(fVar, f3197i, (C1165e) null);
    }

    /* renamed from: a */
    public <TContinuationResult> C1167g<TContinuationResult> mo6180a(C1166f<TResult, C1167g<TContinuationResult>> fVar, Executor executor) {
        return mo6186b(fVar, executor, (C1165e) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6184a(TResult tresult) {
        synchronized (this.f3203a) {
            if (this.f3204b) {
                return false;
            }
            this.f3204b = true;
            this.f3206d = tresult;
            this.f3203a.notifyAll();
            m4781j();
            return true;
        }
    }

    /* renamed from: b */
    public <TContinuationResult> C1167g<TContinuationResult> mo6185b(C1166f<TResult, TContinuationResult> fVar) {
        return mo6188c(fVar, f3197i, (C1165e) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo6183a(java.lang.Exception r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f3203a
            monitor-enter(r0)
            boolean r1 = r3.f3204b     // Catch:{ all -> 0x002c }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r2
        L_0x000a:
            r1 = 1
            r3.f3204b = r1     // Catch:{ all -> 0x002c }
            r3.f3207e = r4     // Catch:{ all -> 0x002c }
            r3.f3208f = r2     // Catch:{ all -> 0x002c }
            java.lang.Object r4 = r3.f3203a     // Catch:{ all -> 0x002c }
            r4.notifyAll()     // Catch:{ all -> 0x002c }
            r3.m4781j()     // Catch:{ all -> 0x002c }
            boolean r4 = r3.f3208f     // Catch:{ all -> 0x002c }
            if (r4 != 0) goto L_0x002a
            bolts.g$g r4 = m4780i()     // Catch:{ all -> 0x002c }
            if (r4 == 0) goto L_0x002a
            bolts.i r4 = new bolts.i     // Catch:{ all -> 0x002c }
            r4.<init>(r3)     // Catch:{ all -> 0x002c }
            r3.f3209g = r4     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r1
        L_0x002c:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bolts.C1167g.mo6183a(java.lang.Exception):boolean");
    }
}
