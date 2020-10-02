package p119j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: j.v */
/* compiled from: Timeout */
public class C3587v {

    /* renamed from: d */
    public static final C3587v f10049d = new C3588a();

    /* renamed from: a */
    private boolean f10050a;

    /* renamed from: b */
    private long f10051b;

    /* renamed from: c */
    private long f10052c;

    /* renamed from: j.v$a */
    /* compiled from: Timeout */
    class C3588a extends C3587v {
        C3588a() {
        }

        /* renamed from: a */
        public C3587v mo19772a(long j) {
            return this;
        }

        /* renamed from: a */
        public C3587v mo19773a(long j, TimeUnit timeUnit) {
            return this;
        }

        /* renamed from: e */
        public void mo19777e() throws IOException {
        }
    }

    /* renamed from: a */
    public C3587v mo19773a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit != null) {
            this.f10052c = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    /* renamed from: b */
    public C3587v mo19774b() {
        this.f10052c = 0;
        return this;
    }

    /* renamed from: c */
    public long mo19775c() {
        if (this.f10050a) {
            return this.f10051b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: d */
    public boolean mo19776d() {
        return this.f10050a;
    }

    /* renamed from: e */
    public void mo19777e() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f10050a && this.f10051b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    /* renamed from: f */
    public long mo19778f() {
        return this.f10052c;
    }

    /* renamed from: a */
    public C3587v mo19772a(long j) {
        this.f10050a = true;
        this.f10051b = j;
        return this;
    }

    /* renamed from: a */
    public C3587v mo19771a() {
        this.f10050a = false;
        return this;
    }
}
