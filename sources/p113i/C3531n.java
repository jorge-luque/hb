package p113i;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import p113i.C3545x;
import p113i.p114e0.C3500c;

/* renamed from: i.n */
/* compiled from: Dispatcher */
public final class C3531n {

    /* renamed from: a */
    private int f9842a = 64;

    /* renamed from: b */
    private int f9843b = 5;
    @Nullable

    /* renamed from: c */
    private Runnable f9844c;
    @Nullable

    /* renamed from: d */
    private ExecutorService f9845d;

    /* renamed from: e */
    private final Deque<C3545x.C3547b> f9846e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<C3545x.C3547b> f9847f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<C3545x> f9848g = new ArrayDeque();

    /* renamed from: c */
    private boolean m11795c() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<C3545x.C3547b> it = this.f9846e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C3545x.C3547b next = it.next();
                if (this.f9847f.size() >= this.f9842a) {
                    break;
                } else if (m11794c(next) < this.f9843b) {
                    it.remove();
                    arrayList.add(next);
                    this.f9847f.add(next);
                }
            }
            z = mo19470b() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((C3545x.C3547b) arrayList.get(i)).mo19595a(mo19467a());
        }
        return z;
    }

    /* renamed from: a */
    public synchronized ExecutorService mo19467a() {
        if (this.f9845d == null) {
            this.f9845d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C3500c.m11646a("OkHttp Dispatcher", false));
        }
        return this.f9845d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo19471b(C3545x.C3547b bVar) {
        m11793a(this.f9847f, bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo19472b(C3545x xVar) {
        m11793a(this.f9848g, xVar);
    }

    /* renamed from: b */
    public synchronized int mo19470b() {
        return this.f9847f.size() + this.f9848g.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19468a(C3545x.C3547b bVar) {
        synchronized (this) {
            this.f9846e.add(bVar);
        }
        m11795c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo19469a(C3545x xVar) {
        this.f9848g.add(xVar);
    }

    /* renamed from: a */
    private <T> void m11793a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f9844c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!m11795c() && runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: c */
    private int m11794c(C3545x.C3547b bVar) {
        int i = 0;
        for (C3545x.C3547b next : this.f9847f) {
            if (!next.mo19597c().f9942f && next.mo19598d().equals(bVar.mo19598d())) {
                i++;
            }
        }
        return i;
    }
}
