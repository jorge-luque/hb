package com.tapjoy.internal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* renamed from: com.tapjoy.internal.kd */
public final class C5258kd {

    /* renamed from: a */
    private static final Logger f14442a = Logger.getLogger(C5258kd.class.getName());

    /* renamed from: b */
    private final Queue f14443b = new LinkedList();

    /* renamed from: c */
    private boolean f14444c = false;

    /* renamed from: com.tapjoy.internal.kd$a */
    static class C5259a {

        /* renamed from: a */
        final Runnable f14445a;

        /* renamed from: b */
        final Executor f14446b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (r6.f14443b.isEmpty() != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        r0 = (com.tapjoy.internal.C5258kd.C5259a) r6.f14443b.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.f14446b.execute(r0.f14445a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r2 = f14442a;
        r3 = java.util.logging.Level.SEVERE;
        r2.log(r3, "RuntimeException while executing runnable " + r0.f14445a + " with executor " + r0.f14446b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo31478a() {
        /*
            r6 = this;
            java.util.Queue r0 = r6.f14443b
            monitor-enter(r0)
            boolean r1 = r6.f14444c     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0009:
            r1 = 1
            r6.f14444c = r1     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
        L_0x000d:
            java.util.Queue r0 = r6.f14443b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0048
            java.util.Queue r0 = r6.f14443b
            java.lang.Object r0 = r0.poll()
            com.tapjoy.internal.kd$a r0 = (com.tapjoy.internal.C5258kd.C5259a) r0
            java.util.concurrent.Executor r1 = r0.f14446b     // Catch:{ RuntimeException -> 0x0025 }
            java.lang.Runnable r2 = r0.f14445a     // Catch:{ RuntimeException -> 0x0025 }
            r1.execute(r2)     // Catch:{ RuntimeException -> 0x0025 }
            goto L_0x000d
        L_0x0025:
            r1 = move-exception
            java.util.logging.Logger r2 = f14442a
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "RuntimeException while executing runnable "
            r4.<init>(r5)
            java.lang.Runnable r5 = r0.f14445a
            r4.append(r5)
            java.lang.String r5 = " with executor "
            r4.append(r5)
            java.util.concurrent.Executor r0 = r0.f14446b
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.log(r3, r0, r1)
            goto L_0x000d
        L_0x0048:
            return
        L_0x0049:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x004c:
            throw r1
        L_0x004d:
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5258kd.mo31478a():void");
    }
}
