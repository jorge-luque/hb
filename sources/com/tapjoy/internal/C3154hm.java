package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tapjoy.internal.C5041ev;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hm */
public final class C3154hm {

    /* renamed from: a */
    final C3144gy f8797a;

    /* renamed from: b */
    final AtomicBoolean f8798b = new AtomicBoolean();
    @Nullable

    /* renamed from: c */
    ScheduledFuture f8799c;

    /* renamed from: d */
    private final Runnable f8800d = new Runnable() {
        public final void run() {
            if (C3154hm.this.f8798b.compareAndSet(true, false)) {
                C5139gw.m17323a("The session ended");
                C3144gy gyVar = C3154hm.this.f8797a;
                long elapsedRealtime = SystemClock.elapsedRealtime() - gyVar.f8750c;
                C3149hc hcVar = gyVar.f8748a;
                synchronized (hcVar) {
                    long a = hcVar.f8783c.f14121i.mo31479a() + elapsedRealtime;
                    hcVar.f8783c.f14121i.mo31482a(a);
                    hcVar.f8782b.f13896i = Long.valueOf(a);
                }
                C5041ev.C5042a a2 = gyVar.mo18538a(C5050ey.APP, "session");
                a2.f13700i = Long.valueOf(elapsedRealtime);
                gyVar.mo18539a(a2);
                gyVar.f8750c = 0;
                C3149hc hcVar2 = gyVar.f8748a;
                long longValue = a2.f13696e.longValue();
                synchronized (hcVar2) {
                    SharedPreferences.Editor a3 = hcVar2.f8783c.mo31334a();
                    hcVar2.f8783c.f14122j.mo31481a(a3, longValue);
                    hcVar2.f8783c.f14123k.mo31481a(a3, elapsedRealtime);
                    a3.apply();
                    hcVar2.f8782b.f13897j = Long.valueOf(longValue);
                    hcVar2.f8782b.f13898k = Long.valueOf(elapsedRealtime);
                }
                C5140gx gxVar = gyVar.f8749b;
                if (gxVar.f14057b != null) {
                    gxVar.mo31316a();
                    new C5200im() {
                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public final boolean mo31319a() {
                            return !C5140gx.this.f14056a.mo18605c();
                        }
                    }.run();
                }
                gxVar.f14056a.flush();
                C5096fs.f13951d.notifyObservers();
            }
        }
    };

    /* renamed from: e */
    private final Runnable f8801e = new Runnable() {
        public final void run() {
        }
    };

    C3154hm(C3144gy gyVar) {
        this.f8797a = gyVar;
    }

    /* renamed from: a */
    public final void mo18609a() {
        if (!this.f8798b.get()) {
            return;
        }
        if (Boolean.FALSE.booleanValue()) {
            ScheduledFuture scheduledFuture = this.f8799c;
            if (scheduledFuture == null || scheduledFuture.cancel(false)) {
                this.f8799c = C5162hn.f14145a.schedule(this.f8800d, 3000, TimeUnit.MILLISECONDS);
                return;
            }
            return;
        }
        this.f8800d.run();
    }
}
