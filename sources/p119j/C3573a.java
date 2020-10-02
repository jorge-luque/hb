package p119j;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* renamed from: j.a */
/* compiled from: AsyncTimeout */
public class C3573a extends C3587v {

    /* renamed from: h */
    private static final long f10020h = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: i */
    private static final long f10021i = TimeUnit.MILLISECONDS.toNanos(f10020h);
    @Nullable

    /* renamed from: j */
    static C3573a f10022j;

    /* renamed from: e */
    private boolean f10023e;
    @Nullable

    /* renamed from: f */
    private C3573a f10024f;

    /* renamed from: g */
    private long f10025g;

    /* renamed from: j.a$a */
    /* compiled from: AsyncTimeout */
    class C3574a implements C3585t {

        /* renamed from: a */
        final /* synthetic */ C3585t f10026a;

        C3574a(C3585t tVar) {
            this.f10026a = tVar;
        }

        /* renamed from: a */
        public void mo19670a(C3577c cVar, long j) throws IOException {
            C6597w.m21673a(cVar.f10032b, 0, j);
            while (true) {
                long j2 = 0;
                if (j > 0) {
                    C3583q qVar = cVar.f10031a;
                    while (true) {
                        if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                            break;
                        }
                        j2 += (long) (qVar.f10042c - qVar.f10041b);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        qVar = qVar.f10045f;
                    }
                    C3573a.this.mo19668g();
                    try {
                        this.f10026a.mo19670a(cVar, j2);
                        j -= j2;
                        C3573a.this.mo19666a(true);
                    } catch (IOException e) {
                        throw C3573a.this.mo19665a(e);
                    } catch (Throwable th) {
                        C3573a.this.mo19666a(false);
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }

        public void close() throws IOException {
            C3573a.this.mo19668g();
            try {
                this.f10026a.close();
                C3573a.this.mo19666a(true);
            } catch (IOException e) {
                throw C3573a.this.mo19665a(e);
            } catch (Throwable th) {
                C3573a.this.mo19666a(false);
                throw th;
            }
        }

        public void flush() throws IOException {
            C3573a.this.mo19668g();
            try {
                this.f10026a.flush();
                C3573a.this.mo19666a(true);
            } catch (IOException e) {
                throw C3573a.this.mo19665a(e);
            } catch (Throwable th) {
                C3573a.this.mo19666a(false);
                throw th;
            }
        }

        public C3587v timeout() {
            return C3573a.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f10026a + ")";
        }
    }

    /* renamed from: j.a$b */
    /* compiled from: AsyncTimeout */
    class C3575b implements C3586u {

        /* renamed from: a */
        final /* synthetic */ C3586u f10028a;

        C3575b(C3586u uVar) {
            this.f10028a = uVar;
        }

        public void close() throws IOException {
            try {
                this.f10028a.close();
                C3573a.this.mo19666a(true);
            } catch (IOException e) {
                throw C3573a.this.mo19665a(e);
            } catch (Throwable th) {
                C3573a.this.mo19666a(false);
                throw th;
            }
        }

        public long read(C3577c cVar, long j) throws IOException {
            C3573a.this.mo19668g();
            try {
                long read = this.f10028a.read(cVar, j);
                C3573a.this.mo19666a(true);
                return read;
            } catch (IOException e) {
                throw C3573a.this.mo19665a(e);
            } catch (Throwable th) {
                C3573a.this.mo19666a(false);
                throw th;
            }
        }

        public C3587v timeout() {
            return C3573a.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f10028a + ")";
        }
    }

    /* renamed from: j.a$c */
    /* compiled from: AsyncTimeout */
    private static final class C3576c extends Thread {
        C3576c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.mo19594i();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<j.a> r0 = p119j.C3573a.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                j.a r1 = p119j.C3573a.m12084j()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                j.a r2 = p119j.C3573a.f10022j     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                p119j.C3573a.f10022j = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.mo19594i()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x001d
            L_0x001c:
                throw r1
            L_0x001d:
                goto L_0x001c
            */
            throw new UnsupportedOperationException("Method not decompiled: p119j.C3573a.C3576c.run():void");
        }
    }

    /* renamed from: a */
    private static synchronized void m12081a(C3573a aVar, long j, boolean z) {
        Class<C3573a> cls = C3573a.class;
        synchronized (cls) {
            if (f10022j == null) {
                f10022j = new C3573a();
                new C3576c().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.f10025g = Math.min(j, aVar.mo19775c() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.f10025g = j + nanoTime;
            } else if (z) {
                aVar.f10025g = aVar.mo19775c();
            } else {
                throw new AssertionError();
            }
            long b = aVar.m12083b(nanoTime);
            C3573a aVar2 = f10022j;
            while (true) {
                if (aVar2.f10024f == null) {
                    break;
                } else if (b < aVar2.f10024f.m12083b(nanoTime)) {
                    break;
                } else {
                    aVar2 = aVar2.f10024f;
                }
            }
            aVar.f10024f = aVar2.f10024f;
            aVar2.f10024f = aVar;
            if (aVar2 == f10022j) {
                cls.notify();
            }
        }
    }

    /* renamed from: b */
    private long m12083b(long j) {
        return this.f10025g - j;
    }

    @Nullable
    /* renamed from: j */
    static C3573a m12084j() throws InterruptedException {
        Class<C3573a> cls = C3573a.class;
        C3573a aVar = f10022j.f10024f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            cls.wait(f10020h);
            if (f10022j.f10024f != null || System.nanoTime() - nanoTime < f10021i) {
                return null;
            }
            return f10022j;
        }
        long b = aVar.m12083b(System.nanoTime());
        if (b > 0) {
            long j = b / 1000000;
            cls.wait(j, (int) (b - (1000000 * j)));
            return null;
        }
        f10022j.f10024f = aVar.f10024f;
        aVar.f10024f = null;
        return aVar;
    }

    /* renamed from: g */
    public final void mo19668g() {
        if (!this.f10023e) {
            long f = mo19778f();
            boolean d = mo19776d();
            if (f != 0 || d) {
                this.f10023e = true;
                m12081a(this, f, d);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* renamed from: h */
    public final boolean mo19669h() {
        if (!this.f10023e) {
            return false;
        }
        this.f10023e = false;
        return m12082a(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo19594i() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public IOException mo19667b(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: a */
    private static synchronized boolean m12082a(C3573a aVar) {
        synchronized (C3573a.class) {
            for (C3573a aVar2 = f10022j; aVar2 != null; aVar2 = aVar2.f10024f) {
                if (aVar2.f10024f == aVar) {
                    aVar2.f10024f = aVar.f10024f;
                    aVar.f10024f = null;
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    public final C3585t mo19663a(C3585t tVar) {
        return new C3574a(tVar);
    }

    /* renamed from: a */
    public final C3586u mo19664a(C3586u uVar) {
        return new C3575b(uVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo19666a(boolean z) throws IOException {
        if (mo19669h() && z) {
            throw mo19667b((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final IOException mo19665a(IOException iOException) throws IOException {
        if (!mo19669h()) {
            return iOException;
        }
        return mo19667b(iOException);
    }
}
