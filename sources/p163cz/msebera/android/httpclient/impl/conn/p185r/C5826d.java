package p163cz.msebera.android.httpclient.impl.conn.p185r;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import p163cz.msebera.android.httpclient.conn.C5626d;
import p163cz.msebera.android.httpclient.conn.C5637o;
import p163cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import p163cz.msebera.android.httpclient.conn.p173q.C5639a;
import p163cz.msebera.android.httpclient.conn.p173q.C5641b;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.r.d */
/* compiled from: ConnPoolByRoute */
public class C5826d extends C5823a {

    /* renamed from: c */
    public C5695b f15033c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Lock f15034d;

    /* renamed from: e */
    protected final C5626d f15035e;

    /* renamed from: f */
    protected final C5641b f15036f;

    /* renamed from: g */
    protected final Set<C5824b> f15037g;

    /* renamed from: h */
    protected final Queue<C5824b> f15038h;

    /* renamed from: i */
    protected final Queue<C5832h> f15039i;

    /* renamed from: j */
    protected final Map<C5645b, C5829f> f15040j;

    /* renamed from: k */
    private final long f15041k;

    /* renamed from: l */
    private final TimeUnit f15042l;

    /* renamed from: m */
    protected volatile boolean f15043m;

    /* renamed from: n */
    protected volatile int f15044n;

    /* renamed from: o */
    protected volatile int f15045o;

    public C5826d(C5626d dVar, C5641b bVar, int i) {
        this(dVar, bVar, i, -1, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Map<C5645b, C5829f> mo33586b() {
        return new HashMap();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Queue<C5832h> mo33587c() {
        return new LinkedList();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo33588d() {
        this.f15034d.lock();
        try {
            C5824b remove = this.f15038h.remove();
            if (remove != null) {
                mo33583a(remove);
            } else if (this.f15033c.mo33168a()) {
                this.f15033c.mo33166a("No free connection to delete");
            }
        } finally {
            this.f15034d.unlock();
        }
    }

    /* renamed from: e */
    public void mo33589e() {
        this.f15034d.lock();
        try {
            if (!this.f15043m) {
                this.f15043m = true;
                Iterator<C5824b> it = this.f15037g.iterator();
                while (it.hasNext()) {
                    it.remove();
                    m18664b(it.next());
                }
                Iterator it2 = this.f15038h.iterator();
                while (it2.hasNext()) {
                    C5824b bVar = (C5824b) it2.next();
                    it2.remove();
                    if (this.f15033c.mo33168a()) {
                        C5695b bVar2 = this.f15033c;
                        bVar2.mo33166a("Closing connection [" + bVar.mo33574d() + "][" + bVar.mo33541a() + "]");
                    }
                    m18664b(bVar);
                }
                Iterator it3 = this.f15039i.iterator();
                while (it3.hasNext()) {
                    it3.remove();
                    ((C5832h) it3.next()).mo33610b();
                }
                this.f15040j.clear();
                this.f15034d.unlock();
            }
        } finally {
            this.f15034d.unlock();
        }
    }

    public C5826d(C5626d dVar, C5641b bVar, int i, long j, TimeUnit timeUnit) {
        this.f15033c = new C5695b(C5826d.class);
        C5886a.m18894a(dVar, "Connection operator");
        C5886a.m18894a(bVar, "Connections per route");
        this.f15034d = this.f15027a;
        this.f15037g = this.f15028b;
        this.f15035e = dVar;
        this.f15036f = bVar;
        this.f15044n = i;
        this.f15038h = mo33582a();
        this.f15039i = mo33587c();
        this.f15040j = mo33586b();
        this.f15041k = j;
        this.f15042l = timeUnit;
    }

    /* renamed from: b */
    private void m18664b(C5824b bVar) {
        C5637o c = bVar.mo33573c();
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                this.f15033c.mo33167a("I/O error closing connection", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Queue<C5824b> mo33582a() {
        return new LinkedList();
    }

    /* renamed from: cz.msebera.android.httpclient.impl.conn.r.d$a */
    /* compiled from: ConnPoolByRoute */
    class C5827a implements C5828e {

        /* renamed from: a */
        final /* synthetic */ C5833i f15046a;

        /* renamed from: b */
        final /* synthetic */ C5645b f15047b;

        /* renamed from: c */
        final /* synthetic */ Object f15048c;

        C5827a(C5833i iVar, C5645b bVar, Object obj) {
            this.f15046a = iVar;
            this.f15047b = bVar;
            this.f15048c = obj;
        }

        /* renamed from: a */
        public void mo33591a() {
            C5826d.this.f15034d.lock();
            try {
                this.f15046a.mo33611a();
            } finally {
                C5826d.this.f15034d.unlock();
            }
        }

        /* renamed from: a */
        public C5824b mo33590a(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
            return C5826d.this.mo33575a(this.f15047b, this.f15048c, j, timeUnit, this.f15046a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5829f mo33579a(C5645b bVar) {
        return new C5829f(bVar, this.f15036f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5832h mo33581a(Condition condition, C5829f fVar) {
        return new C5832h(condition, fVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5829f mo33580a(C5645b bVar, boolean z) {
        this.f15034d.lock();
        try {
            C5829f fVar = this.f15040j.get(bVar);
            if (fVar == null && z) {
                fVar = mo33579a(bVar);
                this.f15040j.put(bVar, fVar);
            }
            return fVar;
        } finally {
            this.f15034d.unlock();
        }
    }

    /* renamed from: a */
    public C5828e mo33578a(C5645b bVar, Object obj) {
        return new C5827a(new C5833i(), bVar, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5824b mo33575a(C5645b bVar, Object obj, long j, TimeUnit timeUnit, C5833i iVar) throws ConnectionPoolTimeoutException, InterruptedException {
        C5829f a;
        C5832h hVar;
        C5824b bVar2 = null;
        Date date = j > 0 ? new Date(System.currentTimeMillis() + timeUnit.toMillis(j)) : null;
        this.f15034d.lock();
        try {
            a = mo33580a(bVar, true);
            hVar = null;
            while (true) {
                if (bVar2 != null) {
                    break;
                }
                boolean z = false;
                C5887b.m18902a(!this.f15043m, "Connection pool shut down");
                if (this.f15033c.mo33168a()) {
                    this.f15033c.mo33166a("[" + bVar + "] total kept alive: " + this.f15038h.size() + ", total issued: " + this.f15037g.size() + ", total allocated: " + this.f15045o + " out of " + this.f15044n);
                }
                bVar2 = mo33577a(a, obj);
                if (bVar2 != null) {
                    break;
                }
                if (a.mo33596b() > 0) {
                    z = true;
                }
                if (this.f15033c.mo33168a()) {
                    this.f15033c.mo33166a("Available capacity: " + a.mo33596b() + " out of " + a.mo33599c() + " [" + bVar + "][" + obj + "]");
                }
                if (z && this.f15045o < this.f15044n) {
                    bVar2 = mo33576a(a, this.f15035e);
                } else if (!z || this.f15038h.isEmpty()) {
                    if (this.f15033c.mo33168a()) {
                        this.f15033c.mo33166a("Need to wait for connection [" + bVar + "][" + obj + "]");
                    }
                    if (hVar == null) {
                        hVar = mo33581a(this.f15034d.newCondition(), a);
                        iVar.mo33612a(hVar);
                    }
                    a.mo33595a(hVar);
                    this.f15039i.add(hVar);
                    boolean a2 = hVar.mo33609a(date);
                    a.mo33597b(hVar);
                    this.f15039i.remove(hVar);
                    if (!a2 && date != null) {
                        if (date.getTime() <= System.currentTimeMillis()) {
                            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
                        }
                    }
                } else {
                    mo33588d();
                    a = mo33580a(bVar, true);
                    bVar2 = mo33576a(a, this.f15035e);
                }
            }
            this.f15034d.unlock();
            return bVar2;
        } catch (Throwable th) {
            this.f15034d.unlock();
            throw th;
        }
    }

    @Deprecated
    public C5826d(C5626d dVar, C5759e eVar) {
        this(dVar, C5639a.m17959a(eVar), C5639a.m17963b(eVar));
    }

    /* renamed from: a */
    public void mo33584a(C5824b bVar, boolean z, long j, TimeUnit timeUnit) {
        String str;
        C5645b d = bVar.mo33574d();
        if (this.f15033c.mo33168a()) {
            this.f15033c.mo33166a("Releasing connection [" + d + "][" + bVar.mo33541a() + "]");
        }
        this.f15034d.lock();
        try {
            if (this.f15043m) {
                m18664b(bVar);
                return;
            }
            this.f15037g.remove(bVar);
            C5829f a = mo33580a(d, true);
            if (!z || a.mo33596b() < 0) {
                m18664b(bVar);
                a.mo33593a();
                this.f15045o--;
            } else {
                if (this.f15033c.mo33168a()) {
                    if (j > 0) {
                        str = "for " + j + " " + timeUnit;
                    } else {
                        str = "indefinitely";
                    }
                    this.f15033c.mo33166a("Pooling connection [" + d + "][" + bVar.mo33541a() + "]; keep alive " + str);
                }
                a.mo33600c(bVar);
                bVar.mo33571a(j, timeUnit);
                this.f15038h.add(bVar);
            }
            mo33585a(a);
            this.f15034d.unlock();
        } finally {
            this.f15034d.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5824b mo33577a(C5829f fVar, Object obj) {
        this.f15034d.lock();
        boolean z = false;
        C5824b bVar = null;
        while (!z) {
            try {
                bVar = fVar.mo33592a(obj);
                if (bVar != null) {
                    if (this.f15033c.mo33168a()) {
                        this.f15033c.mo33166a("Getting free connection [" + fVar.mo33601d() + "][" + obj + "]");
                    }
                    this.f15038h.remove(bVar);
                    if (bVar.mo33572a(System.currentTimeMillis())) {
                        if (this.f15033c.mo33168a()) {
                            this.f15033c.mo33166a("Closing expired free connection [" + fVar.mo33601d() + "][" + obj + "]");
                        }
                        m18664b(bVar);
                        fVar.mo33593a();
                        this.f15045o--;
                    } else {
                        this.f15037g.add(bVar);
                    }
                } else if (this.f15033c.mo33168a()) {
                    this.f15033c.mo33166a("No free connections [" + fVar.mo33601d() + "][" + obj + "]");
                }
                z = true;
            } catch (Throwable th) {
                this.f15034d.unlock();
                throw th;
            }
        }
        this.f15034d.unlock();
        return bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5824b mo33576a(C5829f fVar, C5626d dVar) {
        if (this.f15033c.mo33168a()) {
            this.f15033c.mo33166a("Creating new connection [" + fVar.mo33601d() + "]");
        }
        C5824b bVar = new C5824b(dVar, fVar.mo33601d(), this.f15041k, this.f15042l);
        this.f15034d.lock();
        try {
            fVar.mo33594a(bVar);
            this.f15045o++;
            this.f15037g.add(bVar);
            return bVar;
        } finally {
            this.f15034d.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33583a(C5824b bVar) {
        C5645b d = bVar.mo33574d();
        if (this.f15033c.mo33168a()) {
            this.f15033c.mo33166a("Deleting connection [" + d + "][" + bVar.mo33541a() + "]");
        }
        this.f15034d.lock();
        try {
            m18664b(bVar);
            C5829f a = mo33580a(d, true);
            a.mo33598b(bVar);
            this.f15045o--;
            if (a.mo33603f()) {
                this.f15040j.remove(d);
            }
        } finally {
            this.f15034d.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[Catch:{ all -> 0x0074 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo33585a(p163cz.msebera.android.httpclient.impl.conn.p185r.C5829f r4) {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.f15034d
            r0.lock()
            if (r4 == 0) goto L_0x0039
            boolean r0 = r4.mo33602e()     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0039
            cz.msebera.android.httpclient.d0.b r0 = r3.f15033c     // Catch:{ all -> 0x0074 }
            boolean r0 = r0.mo33168a()     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0034
            cz.msebera.android.httpclient.d0.b r0 = r3.f15033c     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r1.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "Notifying thread waiting on pool ["
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            cz.msebera.android.httpclient.conn.r.b r2 = r4.mo33601d()     // Catch:{ all -> 0x0074 }
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "]"
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
            r0.mo33166a(r1)     // Catch:{ all -> 0x0074 }
        L_0x0034:
            cz.msebera.android.httpclient.impl.conn.r.h r4 = r4.mo33604g()     // Catch:{ all -> 0x0074 }
            goto L_0x0069
        L_0x0039:
            java.util.Queue<cz.msebera.android.httpclient.impl.conn.r.h> r4 = r3.f15039i     // Catch:{ all -> 0x0074 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0074 }
            if (r4 != 0) goto L_0x0059
            cz.msebera.android.httpclient.d0.b r4 = r3.f15033c     // Catch:{ all -> 0x0074 }
            boolean r4 = r4.mo33168a()     // Catch:{ all -> 0x0074 }
            if (r4 == 0) goto L_0x0050
            cz.msebera.android.httpclient.d0.b r4 = r3.f15033c     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = "Notifying thread waiting on any pool"
            r4.mo33166a(r0)     // Catch:{ all -> 0x0074 }
        L_0x0050:
            java.util.Queue<cz.msebera.android.httpclient.impl.conn.r.h> r4 = r3.f15039i     // Catch:{ all -> 0x0074 }
            java.lang.Object r4 = r4.remove()     // Catch:{ all -> 0x0074 }
            cz.msebera.android.httpclient.impl.conn.r.h r4 = (p163cz.msebera.android.httpclient.impl.conn.p185r.C5832h) r4     // Catch:{ all -> 0x0074 }
            goto L_0x0069
        L_0x0059:
            cz.msebera.android.httpclient.d0.b r4 = r3.f15033c     // Catch:{ all -> 0x0074 }
            boolean r4 = r4.mo33168a()     // Catch:{ all -> 0x0074 }
            if (r4 == 0) goto L_0x0068
            cz.msebera.android.httpclient.d0.b r4 = r3.f15033c     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = "Notifying no-one, there are no waiting threads"
            r4.mo33166a(r0)     // Catch:{ all -> 0x0074 }
        L_0x0068:
            r4 = 0
        L_0x0069:
            if (r4 == 0) goto L_0x006e
            r4.mo33610b()     // Catch:{ all -> 0x0074 }
        L_0x006e:
            java.util.concurrent.locks.Lock r4 = r3.f15034d
            r4.unlock()
            return
        L_0x0074:
            r4 = move-exception
            java.util.concurrent.locks.Lock r0 = r3.f15034d
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.conn.p185r.C5826d.mo33585a(cz.msebera.android.httpclient.impl.conn.r.f):void");
    }
}
