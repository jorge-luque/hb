package p113i;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.C3589c;
import okhttp3.internal.connection.C6610d;
import okhttp3.internal.connection.C6613f;
import p113i.p114e0.C3500c;
import p113i.p114e0.p117i.C3521f;

/* renamed from: i.j */
/* compiled from: ConnectionPool */
public final class C3526j {

    /* renamed from: g */
    private static final Executor f9809g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C3500c.m11646a("OkHttp ConnectionPool", true));

    /* renamed from: a */
    private final int f9810a;

    /* renamed from: b */
    private final long f9811b;

    /* renamed from: c */
    private final Runnable f9812c;

    /* renamed from: d */
    private final Deque<C3589c> f9813d;

    /* renamed from: e */
    final C6610d f9814e;

    /* renamed from: f */
    boolean f9815f;

    /* renamed from: i.j$a */
    /* compiled from: ConnectionPool */
    class C3527a implements Runnable {
        C3527a() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                i.j r0 = p113i.C3526j.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.mo19440a((long) r1)
                r2 = -1
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 != 0) goto L_0x0011
                return
            L_0x0011:
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0000
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r4 = r0 / r2
                long r2 = r2 * r4
                long r0 = r0 - r2
                i.j r2 = p113i.C3526j.this
                monitor-enter(r2)
                i.j r3 = p113i.C3526j.this     // Catch:{ InterruptedException -> 0x002b }
                int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
                goto L_0x002b
            L_0x0029:
                r0 = move-exception
                goto L_0x002d
            L_0x002b:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                goto L_0x0000
            L_0x002d:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                goto L_0x0030
            L_0x002f:
                throw r0
            L_0x0030:
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: p113i.C3526j.C3527a.run():void");
        }
    }

    public C3526j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public C3589c mo19442a(C3479a aVar, C6613f fVar, C3494c0 c0Var) {
        for (C3589c next : this.f9813d) {
            if (next.mo19784a(aVar, c0Var)) {
                fVar.mo35662a(next, true);
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo19444b(C3589c cVar) {
        if (!this.f9815f) {
            this.f9815f = true;
            f9809g.execute(this.f9812c);
        }
        this.f9813d.add(cVar);
    }

    public C3526j(int i, long j, TimeUnit timeUnit) {
        this.f9812c = new C3527a();
        this.f9813d = new ArrayDeque();
        this.f9814e = new C6610d();
        this.f9810a = i;
        this.f9811b = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public Socket mo19441a(C3479a aVar, C6613f fVar) {
        for (C3589c next : this.f9813d) {
            if (next.mo19784a(aVar, (C3494c0) null) && next.mo19788c() && next != fVar.mo35665c()) {
                return fVar.mo35659a(next);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo19443a(C3589c cVar) {
        if (cVar.f10062k || this.f9810a == 0) {
            this.f9813d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo19440a(long j) {
        synchronized (this) {
            C3589c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (C3589c next : this.f9813d) {
                if (m11763a(next, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.f10066o;
                    if (j3 > j2) {
                        cVar = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f9811b) {
                if (i <= this.f9810a) {
                    if (i > 0) {
                        long j4 = this.f9811b - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.f9811b;
                        return j5;
                    } else {
                        this.f9815f = false;
                        return -1;
                    }
                }
            }
            this.f9813d.remove(cVar);
            C3500c.m11651a(cVar.mo19790e());
            return 0;
        }
    }

    /* renamed from: a */
    private int m11763a(C3589c cVar, long j) {
        List<Reference<C6613f>> list = cVar.f10065n;
        int i = 0;
        while (i < list.size()) {
            Reference reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                C3521f.m11740d().mo19410a("A connection to " + cVar.mo19789d().mo19340a().mo19272k() + " was leaked. Did you forget to close a response body?", ((C6613f.C6614a) reference).f17313a);
                list.remove(i);
                cVar.f10062k = true;
                if (list.isEmpty()) {
                    cVar.f10066o = j - this.f9811b;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
