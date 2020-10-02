package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.C1941j;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.applovin.impl.sdk.utils.p */
public class C2026p {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f6728a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Timer f6729b;

    /* renamed from: c */
    private long f6730c;

    /* renamed from: d */
    private long f6731d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Runnable f6732e;

    /* renamed from: f */
    private long f6733f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Object f6734g = new Object();

    private C2026p(C1941j jVar, Runnable runnable) {
        this.f6728a = jVar;
        this.f6732e = runnable;
    }

    /* renamed from: a */
    public static C2026p m7968a(long j, C1941j jVar, Runnable runnable) {
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j + ".");
        } else if (runnable != null) {
            C2026p pVar = new C2026p(jVar, runnable);
            pVar.f6730c = System.currentTimeMillis();
            pVar.f6731d = j;
            try {
                Timer timer = new Timer();
                pVar.f6729b = timer;
                timer.schedule(pVar.m7973e(), j);
            } catch (OutOfMemoryError e) {
                jVar.mo8602v().mo8743b("Timer", "Failed to create timer due to OOM error", e);
            }
            return pVar;
        } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
    }

    /* renamed from: e */
    private TimerTask m7973e() {
        return new TimerTask() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    r0 = 0
                    com.applovin.impl.sdk.utils.p r1 = com.applovin.impl.sdk.utils.C2026p.this     // Catch:{ all -> 0x001b }
                    java.lang.Runnable r1 = r1.f6732e     // Catch:{ all -> 0x001b }
                    r1.run()     // Catch:{ all -> 0x001b }
                    com.applovin.impl.sdk.utils.p r1 = com.applovin.impl.sdk.utils.C2026p.this
                    java.lang.Object r1 = r1.f6734g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C2026p.this     // Catch:{ all -> 0x0018 }
                    java.util.Timer unused = r2.f6729b = r0     // Catch:{ all -> 0x0018 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    goto L_0x0042
                L_0x0018:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    throw r0
                L_0x001b:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C2026p.this     // Catch:{ all -> 0x0046 }
                    com.applovin.impl.sdk.j r2 = r2.f6728a     // Catch:{ all -> 0x0046 }
                    if (r2 == 0) goto L_0x0035
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C2026p.this     // Catch:{ all -> 0x0046 }
                    com.applovin.impl.sdk.j r2 = r2.f6728a     // Catch:{ all -> 0x0046 }
                    com.applovin.impl.sdk.q r2 = r2.mo8602v()     // Catch:{ all -> 0x0046 }
                    java.lang.String r3 = "Timer"
                    java.lang.String r4 = "Encountered error while executing timed task"
                    r2.mo8743b(r3, r4, r1)     // Catch:{ all -> 0x0046 }
                L_0x0035:
                    com.applovin.impl.sdk.utils.p r1 = com.applovin.impl.sdk.utils.C2026p.this
                    java.lang.Object r1 = r1.f6734g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C2026p.this     // Catch:{ all -> 0x0043 }
                    java.util.Timer unused = r2.f6729b = r0     // Catch:{ all -> 0x0043 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                L_0x0042:
                    return
                L_0x0043:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                    throw r0
                L_0x0046:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.p r2 = com.applovin.impl.sdk.utils.C2026p.this
                    java.lang.Object r2 = r2.f6734g
                    monitor-enter(r2)
                    com.applovin.impl.sdk.utils.p r3 = com.applovin.impl.sdk.utils.C2026p.this     // Catch:{ all -> 0x0055 }
                    java.util.Timer unused = r3.f6729b = r0     // Catch:{ all -> 0x0055 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                    throw r1
                L_0x0055:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C2026p.C20271.run():void");
            }
        };
    }

    /* renamed from: a */
    public long mo8811a() {
        if (this.f6729b == null) {
            return this.f6731d - this.f6733f;
        }
        return this.f6731d - (System.currentTimeMillis() - this.f6730c);
    }

    /* renamed from: b */
    public void mo8812b() {
        synchronized (this.f6734g) {
            if (this.f6729b != null) {
                try {
                    this.f6729b.cancel();
                    this.f6733f = System.currentTimeMillis() - this.f6730c;
                } catch (Throwable th) {
                    this.f6729b = null;
                    throw th;
                }
                this.f6729b = null;
            }
        }
    }

    /* renamed from: c */
    public void mo8813c() {
        synchronized (this.f6734g) {
            if (this.f6733f > 0) {
                try {
                    long j = this.f6731d - this.f6733f;
                    this.f6731d = j;
                    if (j < 0) {
                        this.f6731d = 0;
                    }
                    Timer timer = new Timer();
                    this.f6729b = timer;
                    timer.schedule(m7973e(), this.f6731d);
                    this.f6730c = System.currentTimeMillis();
                } catch (Throwable th) {
                    this.f6733f = 0;
                    throw th;
                }
                this.f6733f = 0;
            }
        }
    }

    /* renamed from: d */
    public void mo8814d() {
        synchronized (this.f6734g) {
            if (this.f6729b != null) {
                try {
                    this.f6729b.cancel();
                    this.f6729b = null;
                } catch (Throwable th) {
                    this.f6729b = null;
                    this.f6733f = 0;
                    throw th;
                }
                this.f6733f = 0;
            }
        }
    }
}
