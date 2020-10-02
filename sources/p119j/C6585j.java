package p119j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: j.j */
/* compiled from: ForwardingTimeout */
public class C6585j extends C3587v {

    /* renamed from: e */
    private C3587v f17143e;

    public C6585j(C3587v vVar) {
        if (vVar != null) {
            this.f17143e = vVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final C6585j mo35611a(C3587v vVar) {
        if (vVar != null) {
            this.f17143e = vVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: b */
    public C3587v mo19774b() {
        return this.f17143e.mo19774b();
    }

    /* renamed from: c */
    public long mo19775c() {
        return this.f17143e.mo19775c();
    }

    /* renamed from: d */
    public boolean mo19776d() {
        return this.f17143e.mo19776d();
    }

    /* renamed from: e */
    public void mo19777e() throws IOException {
        this.f17143e.mo19777e();
    }

    /* renamed from: f */
    public long mo19778f() {
        return this.f17143e.mo19778f();
    }

    /* renamed from: g */
    public final C3587v mo35612g() {
        return this.f17143e;
    }

    /* renamed from: a */
    public C3587v mo19773a(long j, TimeUnit timeUnit) {
        return this.f17143e.mo19773a(j, timeUnit);
    }

    /* renamed from: a */
    public C3587v mo19772a(long j) {
        return this.f17143e.mo19772a(j);
    }

    /* renamed from: a */
    public C3587v mo19771a() {
        return this.f17143e.mo19771a();
    }
}
