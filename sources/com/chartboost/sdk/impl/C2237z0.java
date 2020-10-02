package com.chartboost.sdk.impl;

import android.os.Handler;
import com.chartboost.sdk.Libraries.C2082i;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.chartboost.sdk.impl.z0 */
public class C2237z0<T> implements Runnable, Comparable<C2237z0> {

    /* renamed from: a */
    private final Executor f7551a;

    /* renamed from: b */
    private final C2120a1 f7552b;

    /* renamed from: c */
    private final C2222w0 f7553c;

    /* renamed from: d */
    private final C2082i f7554d;

    /* renamed from: e */
    private final Handler f7555e;

    /* renamed from: f */
    public final C2203r0<T> f7556f;

    /* renamed from: g */
    private C2212t0<T> f7557g;

    /* renamed from: h */
    private C2215u0 f7558h;

    C2237z0(Executor executor, C2120a1 a1Var, C2222w0 w0Var, C2082i iVar, Handler handler, C2203r0<T> r0Var) {
        this.f7551a = executor;
        this.f7552b = a1Var;
        this.f7553c = w0Var;
        this.f7554d = iVar;
        this.f7555e = handler;
        this.f7556f = r0Var;
    }

    /* renamed from: a */
    private C2215u0 m8886a(C2203r0<T> r0Var) throws IOException {
        int i = C6078a.DEFAULT_TIMEOUT;
        int i2 = 0;
        while (true) {
            try {
                return m8887a(r0Var, i);
            } catch (SocketTimeoutException e) {
                if (i2 < 1) {
                    i *= 2;
                    i2++;
                } else {
                    throw e;
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m8888a(int i) {
        return ((100 <= i && i < 200) || i == 204 || i == 304) ? false : true;
    }

    public void run() {
        C2212t0<T> t0Var = this.f7557g;
        if (t0Var != null) {
            try {
                if (t0Var.f7460b == null) {
                    this.f7556f.mo9292a(t0Var.f7459a, this.f7558h);
                } else {
                    this.f7556f.mo9291a(t0Var.f7460b, this.f7558h);
                }
            } catch (Exception e) {
                C2098a.m8288a(C2237z0.class, "deliver result", e);
            }
        } else if (this.f7556f.f7435d.compareAndSet(0, 1)) {
            long b = this.f7554d.mo9111b();
            try {
                if (this.f7553c.mo9539c()) {
                    C2215u0 a = m8886a(this.f7556f);
                    this.f7558h = a;
                    int i = a.f7464a;
                    if (i < 200 || i >= 300) {
                        CBError.C2085b bVar = CBError.C2085b.NETWORK_FAILURE;
                        this.f7557g = C2212t0.m8773a(new CBError(bVar, "Failure due to HTTP status code " + i));
                    } else {
                        this.f7557g = this.f7556f.mo9290a(a);
                    }
                } else {
                    this.f7557g = C2212t0.m8773a(new CBError(CBError.C2085b.INTERNET_UNAVAILABLE, "Internet Unavailable"));
                }
                this.f7556f.f7437f = this.f7554d.mo9111b() - b;
                int i2 = this.f7556f.f7440i;
                if (i2 != 0) {
                    if (i2 != 1) {
                        return;
                    }
                    this.f7551a.execute(this);
                    return;
                }
            } catch (Throwable th) {
                this.f7556f.f7437f = this.f7554d.mo9111b() - b;
                int i3 = this.f7556f.f7440i;
                if (i3 == 0) {
                    this.f7555e.post(this);
                } else if (i3 == 1) {
                    this.f7551a.execute(this);
                }
                throw th;
            }
            this.f7555e.post(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.DataOutputStream} */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:82|83) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:81|(2:91|92)|93|94) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|23|(2:26|27)|28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:64|65|(2:70|71)|(2:74|75)|76|77) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:38|39|(2:41|(13:43|44|45|46|47|48|49|(2:51|52)|53|54|55|56|(2:58|(2:60|61)(2:62|63)))(5:78|79|80|(1:85)(1:86)|(2:88|89)))(1:95)|96|97|98|99) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:48|49|(2:51|52)|53|54|55|56|(2:58|(2:60|61)(2:62|63))) */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r0 = r2.getErrorStream();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00d4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00d7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x014a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x0153 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0171 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:96:0x0174 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a A[SYNTHETIC, Splitter:B:26:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00df A[Catch:{ all -> 0x0151, all -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0140 A[SYNTHETIC, Splitter:B:70:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0147 A[SYNTHETIC, Splitter:B:74:0x0147] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:93:0x0171=Splitter:B:93:0x0171, B:55:0x00d7=Splitter:B:55:0x00d7, B:76:0x014a=Splitter:B:76:0x014a} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:96:0x0174=Splitter:B:96:0x0174, B:28:0x007d=Splitter:B:28:0x007d} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.chartboost.sdk.impl.C2215u0 m8887a(com.chartboost.sdk.impl.C2203r0<T> r10, int r11) throws java.io.IOException {
        /*
            r9 = this;
            com.chartboost.sdk.impl.s0 r0 = r10.mo9289a()
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.f7450a
            com.chartboost.sdk.impl.a1 r2 = r9.f7552b
            java.net.HttpURLConnection r2 = r2.mo9279a(r10)
            r2.setConnectTimeout(r11)
            r2.setReadTimeout(r11)
            r11 = 0
            r2.setUseCaches(r11)
            r3 = 1
            r2.setDoInput(r3)
            if (r1 == 0) goto L_0x003a
            java.util.Set r4 = r1.keySet()     // Catch:{ all -> 0x01a4 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x01a4 }
        L_0x0024:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x01a4 }
            if (r5 == 0) goto L_0x003a
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x01a4 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x01a4 }
            java.lang.Object r6 = r1.get(r5)     // Catch:{ all -> 0x01a4 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x01a4 }
            r2.addRequestProperty(r5, r6)     // Catch:{ all -> 0x01a4 }
            goto L_0x0024
        L_0x003a:
            java.lang.String r1 = r10.f7432a     // Catch:{ all -> 0x01a4 }
            r2.setRequestMethod(r1)     // Catch:{ all -> 0x01a4 }
            java.lang.String r1 = r10.f7432a     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = "POST"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x01a4 }
            r4 = 0
            if (r1 == 0) goto L_0x007e
            byte[] r1 = r0.f7451b     // Catch:{ all -> 0x01a4 }
            if (r1 == 0) goto L_0x007e
            r2.setDoOutput(r3)     // Catch:{ all -> 0x01a4 }
            byte[] r1 = r0.f7451b     // Catch:{ all -> 0x01a4 }
            int r1 = r1.length     // Catch:{ all -> 0x01a4 }
            r2.setFixedLengthStreamingMode(r1)     // Catch:{ all -> 0x01a4 }
            java.lang.String r1 = r0.f7452c     // Catch:{ all -> 0x01a4 }
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = "Content-Type"
            java.lang.String r3 = r0.f7452c     // Catch:{ all -> 0x01a4 }
            r2.addRequestProperty(r1, r3)     // Catch:{ all -> 0x01a4 }
        L_0x0062:
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ all -> 0x0077 }
            java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ all -> 0x0077 }
            r1.<init>(r3)     // Catch:{ all -> 0x0077 }
            byte[] r0 = r0.f7451b     // Catch:{ all -> 0x0074 }
            r1.write(r0)     // Catch:{ all -> 0x0074 }
            r1.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x007e
        L_0x0074:
            r10 = move-exception
            r4 = r1
            goto L_0x0078
        L_0x0077:
            r10 = move-exception
        L_0x0078:
            if (r4 == 0) goto L_0x007d
            r4.close()     // Catch:{ IOException -> 0x007d }
        L_0x007d:
            throw r10     // Catch:{ all -> 0x01a4 }
        L_0x007e:
            com.chartboost.sdk.Libraries.i r0 = r9.f7554d     // Catch:{ all -> 0x01a4 }
            long r0 = r0.mo9111b()     // Catch:{ all -> 0x01a4 }
            int r3 = r2.getResponseCode()     // Catch:{ all -> 0x0199 }
            com.chartboost.sdk.Libraries.i r5 = r9.f7554d     // Catch:{ all -> 0x01a4 }
            long r5 = r5.mo9111b()     // Catch:{ all -> 0x01a4 }
            long r0 = r5 - r0
            r10.f7438g = r0     // Catch:{ all -> 0x01a4 }
            r0 = -1
            if (r3 == r0) goto L_0x0191
            boolean r0 = m8888a((int) r3)     // Catch:{ all -> 0x0186 }
            if (r0 == 0) goto L_0x0172
            java.io.File r0 = r10.f7436e     // Catch:{ all -> 0x0186 }
            if (r0 == 0) goto L_0x014b
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0186 }
            java.io.File r1 = r10.f7436e     // Catch:{ all -> 0x0186 }
            java.io.File r1 = r1.getParentFile()     // Catch:{ all -> 0x0186 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0186 }
            r7.<init>()     // Catch:{ all -> 0x0186 }
            java.io.File r8 = r10.f7436e     // Catch:{ all -> 0x0186 }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0186 }
            r7.append(r8)     // Catch:{ all -> 0x0186 }
            java.lang.String r8 = ".tmp"
            r7.append(r8)     // Catch:{ all -> 0x0186 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0186 }
            r0.<init>(r1, r7)     // Catch:{ all -> 0x0186 }
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0186 }
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{ all -> 0x013c }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x013a }
            r7.<init>(r0)     // Catch:{ all -> 0x013a }
            com.chartboost.sdk.impl.C2121a2.m8435a((java.io.InputStream) r1, (java.io.OutputStream) r7)     // Catch:{ all -> 0x0137 }
            if (r1 == 0) goto L_0x00d4
            r1.close()     // Catch:{ IOException -> 0x00d4 }
        L_0x00d4:
            r7.close()     // Catch:{ IOException -> 0x00d7 }
        L_0x00d7:
            java.io.File r1 = r10.f7436e     // Catch:{ all -> 0x0186 }
            boolean r1 = r0.renameTo(r1)     // Catch:{ all -> 0x0186 }
            if (r1 != 0) goto L_0x0174
            boolean r11 = r0.delete()     // Catch:{ all -> 0x0186 }
            if (r11 != 0) goto L_0x010e
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x0186 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0186 }
            r1.<init>()     // Catch:{ all -> 0x0186 }
            java.lang.String r3 = "Unable to delete "
            r1.append(r3)     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0186 }
            r1.append(r0)     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = " after failing to rename to "
            r1.append(r0)     // Catch:{ all -> 0x0186 }
            java.io.File r0 = r10.f7436e     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0186 }
            r1.append(r0)     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0186 }
            r11.<init>(r0)     // Catch:{ all -> 0x0186 }
            throw r11     // Catch:{ all -> 0x0186 }
        L_0x010e:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x0186 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0186 }
            r1.<init>()     // Catch:{ all -> 0x0186 }
            java.lang.String r3 = "Unable to move "
            r1.append(r3)     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0186 }
            r1.append(r0)     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = " to "
            r1.append(r0)     // Catch:{ all -> 0x0186 }
            java.io.File r0 = r10.f7436e     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0186 }
            r1.append(r0)     // Catch:{ all -> 0x0186 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0186 }
            r11.<init>(r0)     // Catch:{ all -> 0x0186 }
            throw r11     // Catch:{ all -> 0x0186 }
        L_0x0137:
            r11 = move-exception
            r4 = r7
            goto L_0x013e
        L_0x013a:
            r11 = move-exception
            goto L_0x013e
        L_0x013c:
            r11 = move-exception
            r1 = r4
        L_0x013e:
            if (r1 == 0) goto L_0x0145
            r1.close()     // Catch:{ IOException -> 0x0144 }
            goto L_0x0145
        L_0x0144:
        L_0x0145:
            if (r4 == 0) goto L_0x014a
            r4.close()     // Catch:{ IOException -> 0x014a }
        L_0x014a:
            throw r11     // Catch:{ all -> 0x0186 }
        L_0x014b:
            java.io.InputStream r0 = r2.getInputStream()     // Catch:{ IOException -> 0x0153 }
        L_0x014f:
            r4 = r0
            goto L_0x0158
        L_0x0151:
            r11 = move-exception
            goto L_0x016c
        L_0x0153:
            java.io.InputStream r0 = r2.getErrorStream()     // Catch:{ all -> 0x0151 }
            goto L_0x014f
        L_0x0158:
            if (r4 == 0) goto L_0x0164
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0151 }
            r11.<init>(r4)     // Catch:{ all -> 0x0151 }
            byte[] r11 = com.chartboost.sdk.impl.C2121a2.m8442b(r11)     // Catch:{ all -> 0x0151 }
            goto L_0x0166
        L_0x0164:
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0151 }
        L_0x0166:
            if (r4 == 0) goto L_0x0174
            r4.close()     // Catch:{ IOException -> 0x0174 }
            goto L_0x0174
        L_0x016c:
            if (r4 == 0) goto L_0x0171
            r4.close()     // Catch:{ IOException -> 0x0171 }
        L_0x0171:
            throw r11     // Catch:{ all -> 0x0186 }
        L_0x0172:
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0186 }
        L_0x0174:
            com.chartboost.sdk.Libraries.i r0 = r9.f7554d     // Catch:{ all -> 0x01a4 }
            long r0 = r0.mo9111b()     // Catch:{ all -> 0x01a4 }
            long r0 = r0 - r5
            r10.f7439h = r0     // Catch:{ all -> 0x01a4 }
            com.chartboost.sdk.impl.u0 r10 = new com.chartboost.sdk.impl.u0     // Catch:{ all -> 0x01a4 }
            r10.<init>(r3, r11)     // Catch:{ all -> 0x01a4 }
            r2.disconnect()
            return r10
        L_0x0186:
            r11 = move-exception
            com.chartboost.sdk.Libraries.i r0 = r9.f7554d     // Catch:{ all -> 0x01a4 }
            long r0 = r0.mo9111b()     // Catch:{ all -> 0x01a4 }
            long r0 = r0 - r5
            r10.f7439h = r0     // Catch:{ all -> 0x01a4 }
            throw r11     // Catch:{ all -> 0x01a4 }
        L_0x0191:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x01a4 }
            java.lang.String r11 = "Could not retrieve response code from HttpUrlConnection."
            r10.<init>(r11)     // Catch:{ all -> 0x01a4 }
            throw r10     // Catch:{ all -> 0x01a4 }
        L_0x0199:
            r11 = move-exception
            com.chartboost.sdk.Libraries.i r3 = r9.f7554d     // Catch:{ all -> 0x01a4 }
            long r3 = r3.mo9111b()     // Catch:{ all -> 0x01a4 }
            long r3 = r3 - r0
            r10.f7438g = r3     // Catch:{ all -> 0x01a4 }
            throw r11     // Catch:{ all -> 0x01a4 }
        L_0x01a4:
            r10 = move-exception
            r2.disconnect()
            goto L_0x01aa
        L_0x01a9:
            throw r10
        L_0x01aa:
            goto L_0x01a9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2237z0.m8887a(com.chartboost.sdk.impl.r0, int):com.chartboost.sdk.impl.u0");
    }

    /* renamed from: a */
    public int compareTo(C2237z0 z0Var) {
        return this.f7556f.f7434c - z0Var.f7556f.f7434c;
    }
}
