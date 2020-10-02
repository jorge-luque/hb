package com.tapjoy.internal;

import java.io.File;

/* renamed from: com.tapjoy.internal.gx */
public final class C5140gx implements Runnable {

    /* renamed from: a */
    final C3152hl f14056a;

    /* renamed from: b */
    C4933cd f14057b;

    /* renamed from: c */
    private final Object f14058c;

    /* renamed from: d */
    private final Thread f14059d;

    /* renamed from: e */
    private boolean f14060e;

    public C5140gx(File file) {
        C3152hl hlVar = new C3152hl(file);
        this.f14056a = hlVar;
        this.f14058c = hlVar;
        hlVar.mo18603b();
        Thread thread = new Thread(this, "5Rocks");
        this.f14059d = thread;
        thread.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo31317a(boolean z) {
        synchronized (this.f14058c) {
            this.f14060e = z;
            this.f14058c.notify();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r2.mo31373g();
        r2 = 300000;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00cb */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A[Catch:{ Exception | InterruptedException -> 0x0108 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
        L_0x0000:
            r0 = 0
            r2 = r0
        L_0x0003:
            com.tapjoy.internal.cd r4 = r11.f14057b     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r5 = 0
            if (r4 == 0) goto L_0x00d3
            com.tapjoy.internal.hl r4 = r11.f14056a     // Catch:{ Exception | InterruptedException -> 0x0108 }
            int r4 = r4.mo18603b()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            if (r4 <= 0) goto L_0x00d3
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x00d3
            com.tapjoy.internal.hl r4 = r11.f14056a     // Catch:{ Exception | InterruptedException -> 0x0108 }
            int r4 = r4.mo18603b()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r6 = 10000(0x2710, float:1.4013E-41)
            if (r4 <= r6) goto L_0x002a
            com.tapjoy.internal.hl r4 = r11.f14056a     // Catch:{ Exception | InterruptedException -> 0x0108 }
            com.tapjoy.internal.hl r7 = r11.f14056a     // Catch:{ Exception | InterruptedException -> 0x0108 }
            int r7 = r7.mo18603b()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            int r7 = r7 - r6
            r4.mo18602a(r7)     // Catch:{ Exception | InterruptedException -> 0x0108 }
        L_0x002a:
            com.tapjoy.internal.hl r4 = r11.f14056a     // Catch:{ Exception | InterruptedException -> 0x0108 }
            com.tapjoy.internal.ev r4 = r4.mo18604b(r5)     // Catch:{ Exception | InterruptedException -> 0x0108 }
            if (r4 == 0) goto L_0x00d3
            com.tapjoy.internal.fh r2 = r4.f13689w     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r5 = 3
            if (r2 == 0) goto L_0x0043
            java.lang.String r2 = r2.f13868G     // Catch:{ Exception | InterruptedException -> 0x0108 }
            if (r2 != 0) goto L_0x0043
            java.util.concurrent.CountDownLatch r2 = com.tapjoy.internal.C5162hn.f14147c     // Catch:{ Exception | InterruptedException -> 0x0108 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r2.await(r5, r3)     // Catch:{ Exception | InterruptedException -> 0x0108 }
        L_0x0043:
            boolean r2 = com.tapjoy.internal.C5271v.m17677c()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            if (r2 != 0) goto L_0x0050
            java.util.concurrent.CountDownLatch r2 = com.tapjoy.internal.C5162hn.f14146b     // Catch:{ Exception | InterruptedException -> 0x0108 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r2.await(r5, r3)     // Catch:{ Exception | InterruptedException -> 0x0108 }
        L_0x0050:
            boolean r2 = r11.f14060e     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r3 = 100
            if (r2 != 0) goto L_0x008b
            com.tapjoy.internal.ey r2 = r4.f13680n     // Catch:{ Exception | InterruptedException -> 0x0108 }
            com.tapjoy.internal.ey r5 = com.tapjoy.internal.C5050ey.APP     // Catch:{ Exception | InterruptedException -> 0x0108 }
            if (r2 == r5) goto L_0x008b
            com.tapjoy.internal.hl r2 = r11.f14056a     // Catch:{ Exception | InterruptedException -> 0x0108 }
            int r2 = r2.mo18603b()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            if (r2 >= r3) goto L_0x008b
            java.lang.Long r2 = r4.f13682p     // Catch:{ Exception | InterruptedException -> 0x0108 }
            long r5 = r2.longValue()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0073
            goto L_0x008b
        L_0x0073:
            java.lang.Long r2 = r4.f13682p     // Catch:{ Exception | InterruptedException -> 0x0108 }
            long r5 = r2.longValue()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r7 = 60000(0xea60, double:2.9644E-319)
            long r5 = r5 + r7
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            long r5 = r5 - r9
            long r5 = java.lang.Math.max(r5, r0)     // Catch:{ Exception | InterruptedException -> 0x0108 }
            long r5 = java.lang.Math.min(r5, r7)     // Catch:{ Exception | InterruptedException -> 0x0108 }
            goto L_0x008c
        L_0x008b:
            r5 = r0
        L_0x008c:
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00c8
            com.tapjoy.internal.ik r2 = new com.tapjoy.internal.ik     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r2.<init>()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r2.mo31372a(r4)     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r4 = 1
        L_0x0099:
            if (r4 >= r3) goto L_0x00b4
            com.tapjoy.internal.hl r7 = r11.f14056a     // Catch:{ Exception | InterruptedException -> 0x0108 }
            int r7 = r7.mo18603b()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            if (r4 >= r7) goto L_0x00b4
            com.tapjoy.internal.hl r7 = r11.f14056a     // Catch:{ Exception | InterruptedException -> 0x0108 }
            com.tapjoy.internal.ev r7 = r7.mo18604b(r4)     // Catch:{ Exception | InterruptedException -> 0x0108 }
            if (r7 == 0) goto L_0x00b4
            boolean r7 = r2.mo31372a(r7)     // Catch:{ Exception | InterruptedException -> 0x0108 }
            if (r7 == 0) goto L_0x00b4
            int r4 = r4 + 1
            goto L_0x0099
        L_0x00b4:
            r2.mo31373g()     // Catch:{ Exception -> 0x00cb }
            com.tapjoy.internal.cd r3 = r11.f14057b     // Catch:{ Exception -> 0x00cb }
            r3.mo31022a(r2)     // Catch:{ Exception -> 0x00cb }
            com.tapjoy.internal.hl r3 = r11.f14056a     // Catch:{ Exception -> 0x00cb }
            int r4 = r2.mo31373g()     // Catch:{ Exception -> 0x00cb }
            r3.mo18602a(r4)     // Catch:{ Exception -> 0x00cb }
            r2.mo31373g()     // Catch:{ Exception -> 0x00cb }
        L_0x00c8:
            r2 = r5
            goto L_0x0003
        L_0x00cb:
            r2.mo31373g()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r2 = 300000(0x493e0, double:1.482197E-318)
            goto L_0x0003
        L_0x00d3:
            com.tapjoy.internal.hl r4 = r11.f14056a     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r4.flush()     // Catch:{ Exception | InterruptedException -> 0x0108 }
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x00ec
            java.lang.Object r0 = r11.f14058c     // Catch:{ Exception | InterruptedException -> 0x0108 }
            monitor-enter(r0)     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r11.f14060e = r5     // Catch:{ all -> 0x00e9 }
            java.lang.Object r1 = r11.f14058c     // Catch:{ all -> 0x00e9 }
            r1.wait(r2)     // Catch:{ all -> 0x00e9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e9 }
            goto L_0x0000
        L_0x00e9:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e9 }
            throw r1     // Catch:{ Exception | InterruptedException -> 0x0108 }
        L_0x00ec:
            java.lang.Object r0 = r11.f14058c     // Catch:{ Exception | InterruptedException -> 0x0108 }
            monitor-enter(r0)     // Catch:{ Exception | InterruptedException -> 0x0108 }
            r11.f14060e = r5     // Catch:{ all -> 0x0105 }
            com.tapjoy.internal.cd r1 = r11.f14057b     // Catch:{ all -> 0x0105 }
            if (r1 == 0) goto L_0x00fd
            com.tapjoy.internal.hl r1 = r11.f14056a     // Catch:{ all -> 0x0105 }
            boolean r1 = r1.mo18605c()     // Catch:{ all -> 0x0105 }
            if (r1 == 0) goto L_0x0102
        L_0x00fd:
            java.lang.Object r1 = r11.f14058c     // Catch:{ all -> 0x0105 }
            r1.wait()     // Catch:{ all -> 0x0105 }
        L_0x0102:
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            goto L_0x0000
        L_0x0105:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0105 }
            throw r1     // Catch:{ Exception | InterruptedException -> 0x0108 }
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5140gx.run():void");
    }

    /* renamed from: a */
    public final void mo31316a() {
        if (this.f14057b != null && !this.f14056a.mo18605c()) {
            mo31317a(true);
        }
    }
}
