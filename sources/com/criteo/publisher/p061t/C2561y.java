package com.criteo.publisher.p061t;

import android.util.AtomicFile;
import com.criteo.publisher.p061t.C2540m;
import com.criteo.publisher.p061t.C2548r;
import java.io.IOException;
import java.lang.ref.SoftReference;

/* renamed from: com.criteo.publisher.t.y */
class C2561y {

    /* renamed from: a */
    private final String f8102a;

    /* renamed from: b */
    private final AtomicFile f8103b;

    /* renamed from: c */
    private final Object f8104c = new Object();

    /* renamed from: d */
    private final C2547q f8105d;

    /* renamed from: e */
    private volatile SoftReference<C2540m> f8106e;

    C2561y(String str, AtomicFile atomicFile, C2547q qVar) {
        this.f8102a = str;
        this.f8103b = atomicFile;
        this.f8105d = qVar;
        this.f8106e = new SoftReference<>((Object) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|19|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0037 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.criteo.publisher.p061t.C2540m m9611c() throws java.io.IOException {
        /*
            r3 = this;
            android.util.AtomicFile r0 = r3.f8103b
            java.io.File r0 = r0.getBaseFile()
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = r3.f8102a
            com.criteo.publisher.t.m$a r0 = com.criteo.publisher.p061t.C2540m.m9536a((java.lang.String) r0)
            com.criteo.publisher.t.m r0 = r0.mo10538a()
            return r0
        L_0x0017:
            android.util.AtomicFile r0 = r3.f8103b
            java.io.FileInputStream r0 = r0.openRead()
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0038 }
            r1.<init>(r0)     // Catch:{ all -> 0x0038 }
            com.criteo.publisher.t.q r2 = r3.f8105d     // Catch:{ all -> 0x0031 }
            com.criteo.publisher.t.m r2 = r2.mo10592a(r1)     // Catch:{ all -> 0x0031 }
            r1.close()     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0030
            r0.close()
        L_0x0030:
            return r2
        L_0x0031:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x0037 }
        L_0x0037:
            throw r2     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003a }
        L_0x003a:
            r1 = move-exception
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ all -> 0x0040 }
        L_0x0040:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p061t.C2561y.m9611c():com.criteo.publisher.t.m");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10598a(C2540m mVar) throws IOException {
        synchronized (this.f8104c) {
            this.f8106e = new SoftReference<>((Object) null);
            m9610b(mVar);
            this.f8106e = new SoftReference<>(mVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C2540m mo10601b() throws IOException {
        synchronized (this.f8104c) {
            C2540m mVar = this.f8106e.get();
            if (mVar != null) {
                return mVar;
            }
            C2540m c = m9611c();
            this.f8106e = new SoftReference<>(c);
            return c;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10600a(C2548r.C2549a aVar) throws IOException {
        synchronized (this.f8104c) {
            C2540m.C2541a i = mo10601b().mo10533i();
            aVar.mo10580a(i);
            mo10598a(i.mo10538a());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002c */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9610b(com.criteo.publisher.p061t.C2540m r4) throws java.io.IOException {
        /*
            r3 = this;
            android.util.AtomicFile r0 = r3.f8103b
            java.io.FileOutputStream r0 = r0.startWrite()
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x002d }
            r1.<init>(r0)     // Catch:{ all -> 0x002d }
            com.criteo.publisher.t.q r2 = r3.f8105d     // Catch:{ IOException -> 0x0020 }
            r2.mo10593a(r4, r1)     // Catch:{ IOException -> 0x0020 }
            android.util.AtomicFile r4 = r3.f8103b     // Catch:{ IOException -> 0x0020 }
            r4.finishWrite(r0)     // Catch:{ IOException -> 0x0020 }
            r1.close()     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x001d
            r0.close()
        L_0x001d:
            return
        L_0x001e:
            r4 = move-exception
            goto L_0x0027
        L_0x0020:
            r4 = move-exception
            android.util.AtomicFile r2 = r3.f8103b     // Catch:{ all -> 0x001e }
            r2.failWrite(r0)     // Catch:{ all -> 0x001e }
            throw r4     // Catch:{ all -> 0x001e }
        L_0x0027:
            throw r4     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r4 = move-exception
            r1.close()     // Catch:{ all -> 0x002c }
        L_0x002c:
            throw r4     // Catch:{ all -> 0x002d }
        L_0x002d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x002f }
        L_0x002f:
            r4 = move-exception
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ all -> 0x0035 }
        L_0x0035:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p061t.C2561y.m9610b(com.criteo.publisher.t.m):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10599a(C2544o oVar) throws IOException {
        synchronized (this.f8104c) {
            C2540m b = mo10601b();
            mo10597a();
            try {
                if (!oVar.mo10586a(b)) {
                }
            } finally {
                mo10598a(b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10597a() {
        synchronized (this.f8104c) {
            this.f8106e = new SoftReference<>((Object) null);
            this.f8103b.delete();
        }
    }
}
