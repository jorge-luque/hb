package p163cz.msebera.android.httpclient.p184i0;

import java.util.concurrent.TimeUnit;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.i0.a */
/* compiled from: PoolEntry */
public abstract class C5763a<T, C> {

    /* renamed from: a */
    private final String f14854a;

    /* renamed from: b */
    private final T f14855b;

    /* renamed from: c */
    private final C f14856c;

    /* renamed from: d */
    private final long f14857d;

    /* renamed from: e */
    private final long f14858e;

    /* renamed from: f */
    private long f14859f;

    /* renamed from: g */
    private long f14860g;

    /* renamed from: h */
    private volatile Object f14861h;

    public C5763a(String str, T t, C c, long j, TimeUnit timeUnit) {
        C5886a.m18894a(t, "Route");
        C5886a.m18894a(c, "Connection");
        C5886a.m18894a(timeUnit, "Time unit");
        this.f14854a = str;
        this.f14855b = t;
        this.f14856c = c;
        long currentTimeMillis = System.currentTimeMillis();
        this.f14857d = currentTimeMillis;
        if (j > 0) {
            this.f14858e = currentTimeMillis + timeUnit.toMillis(j);
        } else {
            this.f14858e = Long.MAX_VALUE;
        }
        this.f14860g = this.f14858e;
    }

    /* renamed from: a */
    public C mo33427a() {
        return this.f14856c;
    }

    /* renamed from: b */
    public synchronized long mo33431b() {
        return this.f14860g;
    }

    /* renamed from: c */
    public T mo33432c() {
        return this.f14855b;
    }

    public String toString() {
        return "[id:" + this.f14854a + "][route:" + this.f14855b + "][state:" + this.f14861h + "]";
    }

    /* renamed from: a */
    public void mo33429a(Object obj) {
        this.f14861h = obj;
    }

    /* renamed from: a */
    public synchronized void mo33428a(long j, TimeUnit timeUnit) {
        C5886a.m18894a(timeUnit, "Time unit");
        long currentTimeMillis = System.currentTimeMillis();
        this.f14859f = currentTimeMillis;
        this.f14860g = Math.min(j > 0 ? currentTimeMillis + timeUnit.toMillis(j) : Long.MAX_VALUE, this.f14858e);
    }

    /* renamed from: a */
    public synchronized boolean mo33430a(long j) {
        return j >= this.f14860g;
    }
}
