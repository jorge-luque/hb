package p093e.p094a.p095a.p096c1;

import java.text.DecimalFormat;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p093e.p094a.p095a.C3268a1;
import p093e.p094a.p095a.C3309k;
import p093e.p094a.p095a.C3364y;

/* renamed from: e.a.a.c1.h */
/* compiled from: TimerCycle */
public class C3290h {

    /* renamed from: a */
    private C3278a f9131a;

    /* renamed from: b */
    private ScheduledFuture f9132b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f9133c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f9134d;

    /* renamed from: e */
    private long f9135e;

    /* renamed from: f */
    private long f9136f;

    /* renamed from: g */
    private boolean f9137g = true;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C3364y f9138h = C3309k.m11002d();

    /* renamed from: e.a.a.c1.h$a */
    /* compiled from: TimerCycle */
    class C3291a implements Runnable {
        C3291a() {
        }

        public void run() {
            C3290h.this.f9138h.mo19024e("%s fired", C3290h.this.f9133c);
            C3290h.this.f9134d.run();
        }
    }

    public C3290h(Runnable runnable, long j, long j2, String str) {
        this.f9131a = new C3284d(str, true);
        this.f9133c = str;
        this.f9134d = runnable;
        this.f9135e = j;
        this.f9136f = j2;
        DecimalFormat decimalFormat = C3268a1.f9091a;
        double d = (double) j2;
        Double.isNaN(d);
        String format = decimalFormat.format(d / 1000.0d);
        DecimalFormat decimalFormat2 = C3268a1.f9091a;
        double d2 = (double) j;
        Double.isNaN(d2);
        String format2 = decimalFormat2.format(d2 / 1000.0d);
        this.f9138h.mo19024e("%s configured to fire after %s seconds of starting and cycles every %s seconds", str, format2, format);
    }

    /* renamed from: a */
    public void mo18996a() {
        if (!this.f9137g) {
            this.f9138h.mo19024e("%s is already started", this.f9133c);
            return;
        }
        this.f9138h.mo19024e("%s starting", this.f9133c);
        this.f9132b = this.f9131a.mo18986a(new C3291a(), this.f9135e, this.f9136f);
        this.f9137g = false;
    }

    /* renamed from: b */
    public void mo18997b() {
        if (this.f9137g) {
            this.f9138h.mo19024e("%s is already suspended", this.f9133c);
            return;
        }
        this.f9135e = this.f9132b.getDelay(TimeUnit.MILLISECONDS);
        this.f9132b.cancel(false);
        DecimalFormat decimalFormat = C3268a1.f9091a;
        double d = (double) this.f9135e;
        Double.isNaN(d);
        String format = decimalFormat.format(d / 1000.0d);
        this.f9138h.mo19024e("%s suspended with %s seconds left", this.f9133c, format);
        this.f9137g = true;
    }
}
