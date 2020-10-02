package p093e.p094a.p095a.p096c1;

import java.text.DecimalFormat;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p093e.p094a.p095a.C3268a1;
import p093e.p094a.p095a.C3309k;
import p093e.p094a.p095a.C3364y;

/* renamed from: e.a.a.c1.i */
/* compiled from: TimerOnce */
public class C3292i {

    /* renamed from: a */
    private C3278a f9140a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ScheduledFuture f9141b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f9142c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f9143d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C3364y f9144e = C3309k.m11002d();

    /* renamed from: e.a.a.c1.i$a */
    /* compiled from: TimerOnce */
    class C3293a implements Runnable {
        C3293a() {
        }

        public void run() {
            C3292i.this.f9144e.mo19024e("%s fired", C3292i.this.f9142c);
            C3292i.this.f9143d.run();
            ScheduledFuture unused = C3292i.this.f9141b = null;
        }
    }

    public C3292i(Runnable runnable, String str) {
        this.f9142c = str;
        this.f9140a = new C3284d(str, true);
        this.f9143d = runnable;
    }

    /* renamed from: b */
    public long mo19001b() {
        ScheduledFuture scheduledFuture = this.f9141b;
        if (scheduledFuture == null) {
            return 0;
        }
        return scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public void mo19000a(long j) {
        m10932a(false);
        DecimalFormat decimalFormat = C3268a1.f9091a;
        double d = (double) j;
        Double.isNaN(d);
        String format = decimalFormat.format(d / 1000.0d);
        this.f9144e.mo19024e("%s starting. Launching in %s seconds", this.f9142c, format);
        this.f9141b = this.f9140a.mo18985a(new C3293a(), j);
    }

    /* renamed from: a */
    private void m10932a(boolean z) {
        ScheduledFuture scheduledFuture = this.f9141b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(z);
        }
        this.f9141b = null;
        this.f9144e.mo19024e("%s canceled", this.f9142c);
    }

    /* renamed from: a */
    public void mo18999a() {
        m10932a(false);
    }
}
