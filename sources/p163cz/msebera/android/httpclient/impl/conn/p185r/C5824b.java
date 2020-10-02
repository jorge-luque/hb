package p163cz.msebera.android.httpclient.impl.conn.p185r;

import java.util.concurrent.TimeUnit;
import p163cz.msebera.android.httpclient.conn.C5626d;
import p163cz.msebera.android.httpclient.conn.C5637o;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.impl.conn.C5806b;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.r.b */
/* compiled from: BasicPoolEntry */
public class C5824b extends C5806b {

    /* renamed from: f */
    private final long f15029f;

    /* renamed from: g */
    private long f15030g;

    /* renamed from: h */
    private final long f15031h;

    /* renamed from: i */
    private long f15032i;

    public C5824b(C5626d dVar, C5645b bVar, long j, TimeUnit timeUnit) {
        super(dVar, bVar);
        C5886a.m18894a(bVar, "HTTP route");
        long currentTimeMillis = System.currentTimeMillis();
        this.f15029f = currentTimeMillis;
        if (j > 0) {
            this.f15031h = currentTimeMillis + timeUnit.toMillis(j);
        } else {
            this.f15031h = Long.MAX_VALUE;
        }
        this.f15032i = this.f15031h;
    }

    /* renamed from: a */
    public void mo33571a(long j, TimeUnit timeUnit) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f15030g = currentTimeMillis;
        this.f15032i = Math.min(this.f15031h, j > 0 ? currentTimeMillis + timeUnit.toMillis(j) : Long.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo33546b() {
        super.mo33546b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final C5637o mo33573c() {
        return this.f14981b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final C5645b mo33574d() {
        return this.f14982c;
    }

    /* renamed from: a */
    public boolean mo33572a(long j) {
        return j >= this.f15032i;
    }
}
