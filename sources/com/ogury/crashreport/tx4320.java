package com.ogury.crashreport;

import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;

/* compiled from: Closeable.kt */
public class tx4320 {
    /* renamed from: a */
    public static final void m15323a(Closeable closeable, Throwable th) {
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            tx7920.m15333b(th, "receiver$0");
            tx7920.m15333b(th2, "exception");
            tx2880.f12231a.mo29615a(th, th2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        m15323a(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        throw r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m15324a(java.io.File r7) {
        /*
            java.lang.String r0 = "receiver$0"
            com.ogury.crashreport.tx7920.m15333b(r7, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r7)
            r1 = 0
            long r2 = r7.length()     // Catch:{ all -> 0x0056 }
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0035
            int r7 = (int) r2     // Catch:{ all -> 0x0056 }
            byte[] r2 = new byte[r7]     // Catch:{ all -> 0x0056 }
        L_0x0019:
            if (r7 <= 0) goto L_0x0024
            int r3 = r0.read(r2, r1, r7)     // Catch:{ all -> 0x0056 }
            if (r3 < 0) goto L_0x0024
            int r7 = r7 - r3
            int r1 = r1 + r3
            goto L_0x0019
        L_0x0024:
            if (r7 != 0) goto L_0x0027
            goto L_0x0030
        L_0x0027:
            byte[] r2 = java.util.Arrays.copyOf(r2, r1)     // Catch:{ all -> 0x0056 }
            java.lang.String r7 = "java.util.Arrays.copyOf(this, newSize)"
            com.ogury.crashreport.tx7920.m15330a((java.lang.Object) r2, (java.lang.String) r7)     // Catch:{ all -> 0x0056 }
        L_0x0030:
            r7 = 0
            m15323a(r0, r7)
            return r2
        L_0x0035:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError     // Catch:{ all -> 0x0056 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
            java.lang.String r5 = "File "
            r4.<init>(r5)     // Catch:{ all -> 0x0056 }
            r4.append(r7)     // Catch:{ all -> 0x0056 }
            java.lang.String r7 = " is too big ("
            r4.append(r7)     // Catch:{ all -> 0x0056 }
            r4.append(r2)     // Catch:{ all -> 0x0056 }
            java.lang.String r7 = " bytes) to fit in memory."
            r4.append(r7)     // Catch:{ all -> 0x0056 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0056 }
            r1.<init>(r7)     // Catch:{ all -> 0x0056 }
            throw r1     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r1 = move-exception
            m15323a(r0, r7)
            goto L_0x005e
        L_0x005d:
            throw r1
        L_0x005e:
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ogury.crashreport.tx4320.m15324a(java.io.File):byte[]");
    }

    /* renamed from: a */
    public static /* synthetic */ String m15322a(File file, Charset charset, int i) {
        Charset charset2 = C4452dd.f12200a;
        tx7920.m15333b(file, "receiver$0");
        tx7920.m15333b(charset2, "charset");
        return new String(m15324a(file), charset2);
    }
}
