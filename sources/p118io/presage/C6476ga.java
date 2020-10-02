package p118io.presage;

import java.io.File;
import java.nio.charset.Charset;

/* renamed from: io.presage.ga */
class C6476ga extends C6474fz {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        p118io.presage.C6472fx.m21362a(r0, r1);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m21369a(java.io.File r1, byte[] r2) {
        /*
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r1)
            r0.write(r2)     // Catch:{ all -> 0x000f }
            io.presage.ep r1 = p118io.presage.C6437ep.f17017a     // Catch:{ all -> 0x000f }
            r1 = 0
            p118io.presage.C6472fx.m21362a(r0, r1)
            return
        L_0x000f:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0011 }
        L_0x0011:
            r2 = move-exception
            p118io.presage.C6472fx.m21362a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.C6476ga.m21369a(java.io.File, byte[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        p118io.presage.C6472fx.m21362a(r1, r2);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String m21366a(java.io.File r1, java.nio.charset.Charset r2) {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r0, r2)
            java.lang.String r2 = p118io.presage.C6479gd.m21371a(r1)     // Catch:{ all -> 0x0013 }
            r0 = 0
            p118io.presage.C6472fx.m21362a(r1, r0)
            return r2
        L_0x0013:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0015 }
        L_0x0015:
            r0 = move-exception
            p118io.presage.C6472fx.m21362a(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.C6476ga.m21366a(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    /* renamed from: a */
    public static final void m21368a(File file, String str, Charset charset) {
        byte[] bytes = str.getBytes(charset);
        C6514hl.m21414a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        m21369a(file, bytes);
    }
}
