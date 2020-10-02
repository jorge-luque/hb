package p113i;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.C3589c;
import okhttp3.internal.connection.C6608a;
import okhttp3.internal.connection.C6613f;
import p113i.p114e0.C5927b;
import p113i.p114e0.p115e.C5929a;
import p113i.p114e0.p116f.C5934a;
import p113i.p114e0.p116f.C5935b;
import p113i.p114e0.p116f.C5937c;
import p113i.p114e0.p116f.C5942g;
import p113i.p114e0.p116f.C5944j;
import p113i.p114e0.p117i.C3521f;
import p119j.C3573a;

/* renamed from: i.x */
/* compiled from: RealCall */
final class C3545x implements C3497e {

    /* renamed from: a */
    final C3542v f9937a;

    /* renamed from: b */
    final C5944j f9938b;

    /* renamed from: c */
    final C3573a f9939c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d */
    public C3532p f9940d;

    /* renamed from: e */
    final C3548y f9941e;

    /* renamed from: f */
    final boolean f9942f;

    /* renamed from: g */
    private boolean f9943g;

    /* renamed from: i.x$a */
    /* compiled from: RealCall */
    class C3546a extends C3573a {
        C3546a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public void mo19594i() {
            C3545x.this.cancel();
        }
    }

    /* renamed from: i.x$b */
    /* compiled from: RealCall */
    final class C3547b extends C5927b {

        /* renamed from: b */
        private final C5963f f9945b;

        static {
            Class<C3545x> cls = C3545x.class;
        }

        C3547b(C5963f fVar) {
            super("OkHttp %s", C3545x.this.mo19591c());
            this.f9945b = fVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo19595a(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                C3545x.this.f9940d.mo19479a((C3497e) C3545x.this, (IOException) interruptedIOException);
                this.f9945b.onFailure(C3545x.this, interruptedIOException);
                C3545x.this.f9937a.mo19563i().mo19471b(this);
            } catch (Throwable th) {
                C3545x.this.f9937a.mo19563i().mo19471b(this);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[Catch:{ all -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x006a A[Catch:{ all -> 0x003d }] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo19596b() {
            /*
                r5 = this;
                i.x r0 = p113i.C3545x.this
                j.a r0 = r0.f9939c
                r0.mo19668g()
                r0 = 1
                r1 = 0
                i.x r2 = p113i.C3545x.this     // Catch:{ IOException -> 0x003f }
                i.a0 r2 = r2.mo19588a()     // Catch:{ IOException -> 0x003f }
                i.x r3 = p113i.C3545x.this     // Catch:{ IOException -> 0x003f }
                i.e0.f.j r3 = r3.f9938b     // Catch:{ IOException -> 0x003f }
                boolean r1 = r3.mo33742b()     // Catch:{ IOException -> 0x003f }
                if (r1 == 0) goto L_0x0028
                i.f r1 = r5.f9945b     // Catch:{ IOException -> 0x003b }
                i.x r2 = p113i.C3545x.this     // Catch:{ IOException -> 0x003b }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x003b }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x003b }
                r1.onFailure(r2, r3)     // Catch:{ IOException -> 0x003b }
                goto L_0x002f
            L_0x0028:
                i.f r1 = r5.f9945b     // Catch:{ IOException -> 0x003b }
                i.x r3 = p113i.C3545x.this     // Catch:{ IOException -> 0x003b }
                r1.onResponse(r3, r2)     // Catch:{ IOException -> 0x003b }
            L_0x002f:
                i.x r0 = p113i.C3545x.this
                i.v r0 = r0.f9937a
                i.n r0 = r0.mo19563i()
                r0.mo19471b((p113i.C3545x.C3547b) r5)
                goto L_0x007d
            L_0x003b:
                r1 = move-exception
                goto L_0x0042
            L_0x003d:
                r0 = move-exception
                goto L_0x007e
            L_0x003f:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x0042:
                i.x r2 = p113i.C3545x.this     // Catch:{ all -> 0x003d }
                java.io.IOException r1 = r2.mo19589a((java.io.IOException) r1)     // Catch:{ all -> 0x003d }
                if (r0 == 0) goto L_0x006a
                i.e0.i.f r0 = p113i.p114e0.p117i.C3521f.m11740d()     // Catch:{ all -> 0x003d }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
                r3.<init>()     // Catch:{ all -> 0x003d }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x003d }
                i.x r4 = p113i.C3545x.this     // Catch:{ all -> 0x003d }
                java.lang.String r4 = r4.mo19593d()     // Catch:{ all -> 0x003d }
                r3.append(r4)     // Catch:{ all -> 0x003d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x003d }
                r0.mo19409a((int) r2, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x003d }
                goto L_0x002f
            L_0x006a:
                i.x r0 = p113i.C3545x.this     // Catch:{ all -> 0x003d }
                i.p r0 = r0.f9940d     // Catch:{ all -> 0x003d }
                i.x r2 = p113i.C3545x.this     // Catch:{ all -> 0x003d }
                r0.mo19479a((p113i.C3497e) r2, (java.io.IOException) r1)     // Catch:{ all -> 0x003d }
                i.f r0 = r5.f9945b     // Catch:{ all -> 0x003d }
                i.x r2 = p113i.C3545x.this     // Catch:{ all -> 0x003d }
                r0.onFailure(r2, r1)     // Catch:{ all -> 0x003d }
                goto L_0x002f
            L_0x007d:
                return
            L_0x007e:
                i.x r1 = p113i.C3545x.this
                i.v r1 = r1.f9937a
                i.n r1 = r1.mo19563i()
                r1.mo19471b((p113i.C3545x.C3547b) r5)
                goto L_0x008b
            L_0x008a:
                throw r0
            L_0x008b:
                goto L_0x008a
            */
            throw new UnsupportedOperationException("Method not decompiled: p113i.C3545x.C3547b.mo19596b():void");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C3545x mo19597c() {
            return C3545x.this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public String mo19598d() {
            return C3545x.this.f9941e.mo19607g().mo19525g();
        }
    }

    private C3545x(C3542v vVar, C3548y yVar, boolean z) {
        this.f9937a = vVar;
        this.f9941e = yVar;
        this.f9942f = z;
        this.f9938b = new C5944j(vVar, z);
        C3546a aVar = new C3546a();
        this.f9939c = aVar;
        aVar.mo19773a((long) vVar.mo19557c(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: e */
    private void m11953e() {
        this.f9938b.mo33741a(C3521f.m11740d().mo19408a("response.body().close()"));
    }

    /* renamed from: b */
    public boolean mo19590b() {
        return this.f9938b.mo33742b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo19591c() {
        return this.f9941e.mo19607g().mo19532m();
    }

    public void cancel() {
        this.f9938b.mo33740a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo19593d() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo19590b() ? "canceled " : "");
        sb.append(this.f9942f ? "web socket" : "call");
        sb.append(" to ");
        sb.append(mo19591c());
        return sb.toString();
    }

    public C3480a0 execute() throws IOException {
        synchronized (this) {
            if (!this.f9943g) {
                this.f9943g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m11953e();
        this.f9939c.mo19668g();
        this.f9940d.mo19485b(this);
        try {
            this.f9937a.mo19563i().mo19469a(this);
            C3480a0 a = mo19588a();
            if (a != null) {
                this.f9937a.mo19563i().mo19472b(this);
                return a;
            }
            throw new IOException("Canceled");
        } catch (IOException e) {
            IOException a2 = mo19589a(e);
            this.f9940d.mo19479a((C3497e) this, a2);
            throw a2;
        } catch (Throwable th) {
            this.f9937a.mo19563i().mo19472b(this);
            throw th;
        }
    }

    /* renamed from: a */
    static C3545x m11952a(C3542v vVar, C3548y yVar, boolean z) {
        C3545x xVar = new C3545x(vVar, yVar, z);
        xVar.f9940d = vVar.mo19565k().mo19493a(xVar);
        return xVar;
    }

    public C3545x clone() {
        return m11952a(this.f9937a, this.f9941e, this.f9942f);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public IOException mo19589a(@Nullable IOException iOException) {
        if (!this.f9939c.mo19669h()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: a */
    public void mo19362a(C5963f fVar) {
        synchronized (this) {
            if (!this.f9943g) {
                this.f9943g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m11953e();
        this.f9940d.mo19485b(this);
        this.f9937a.mo19563i().mo19468a(new C3547b(fVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3480a0 mo19588a() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f9937a.mo19569o());
        arrayList.add(this.f9938b);
        arrayList.add(new C5934a(this.f9937a.mo19562h()));
        arrayList.add(new C5929a(this.f9937a.mo19570p()));
        arrayList.add(new C6608a(this.f9937a));
        if (!this.f9942f) {
            arrayList.addAll(this.f9937a.mo19571q());
        }
        arrayList.add(new C5935b(this.f9942f));
        return new C5942g(arrayList, (C6613f) null, (C5937c) null, (C3589c) null, 0, this.f9941e, this, this.f9940d, this.f9937a.mo19559e(), this.f9937a.mo19578x(), this.f9937a.mo19554B()).mo33730a(this.f9941e);
    }
}
