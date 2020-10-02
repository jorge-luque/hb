package admost.adserver.videocache;

import admost.adserver.videocache.p002r.C0095a;
import admost.adserver.videocache.p002r.C0096b;
import admost.adserver.videocache.p003s.C0099c;
import admost.adserver.videocache.p003s.C0100d;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* renamed from: admost.adserver.videocache.h */
/* compiled from: HttpUrlSource */
public class C0072h implements C0082n {

    /* renamed from: a */
    private final C0099c f210a;

    /* renamed from: b */
    private final C0096b f211b;

    /* renamed from: c */
    private C0083o f212c;

    /* renamed from: d */
    private HttpURLConnection f213d;

    /* renamed from: e */
    private InputStream f214e;

    public C0072h(String str) {
        this(str, C0100d.m291a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m219c() throws admost.adserver.videocache.ProxyCacheException {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Read content info from "
            r0.append(r1)
            admost.adserver.videocache.o r1 = r7.f212c
            java.lang.String r1 = r1.f232a
            r0.append(r1)
            r0.toString()
            r0 = 0
            r2 = 10000(0x2710, float:1.4013E-41)
            r3 = 0
            java.net.HttpURLConnection r0 = r7.m217a((long) r0, (int) r2)     // Catch:{ IOException -> 0x005a, all -> 0x0057 }
            long r1 = r7.m215a((java.net.HttpURLConnection) r0)     // Catch:{ IOException -> 0x0055 }
            java.lang.String r4 = r0.getContentType()     // Catch:{ IOException -> 0x0055 }
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ IOException -> 0x0055 }
            admost.adserver.videocache.o r5 = new admost.adserver.videocache.o     // Catch:{ IOException -> 0x0055 }
            admost.adserver.videocache.o r6 = r7.f212c     // Catch:{ IOException -> 0x0055 }
            java.lang.String r6 = r6.f232a     // Catch:{ IOException -> 0x0055 }
            r5.<init>(r6, r1, r4)     // Catch:{ IOException -> 0x0055 }
            r7.f212c = r5     // Catch:{ IOException -> 0x0055 }
            admost.adserver.videocache.s.c r1 = r7.f210a     // Catch:{ IOException -> 0x0055 }
            java.lang.String r2 = r5.f232a     // Catch:{ IOException -> 0x0055 }
            r1.mo156a(r2, r5)     // Catch:{ IOException -> 0x0055 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0055 }
            r1.<init>()     // Catch:{ IOException -> 0x0055 }
            java.lang.String r2 = "Source info fetched: "
            r1.append(r2)     // Catch:{ IOException -> 0x0055 }
            admost.adserver.videocache.o r2 = r7.f212c     // Catch:{ IOException -> 0x0055 }
            r1.append(r2)     // Catch:{ IOException -> 0x0055 }
            r1.toString()     // Catch:{ IOException -> 0x0055 }
            admost.adserver.videocache.C0081m.m253a((java.io.Closeable) r3)
            if (r0 == 0) goto L_0x007e
            goto L_0x007b
        L_0x0053:
            r1 = move-exception
            goto L_0x007f
        L_0x0055:
            r1 = move-exception
            goto L_0x005c
        L_0x0057:
            r1 = move-exception
            r0 = r3
            goto L_0x007f
        L_0x005a:
            r1 = move-exception
            r0 = r3
        L_0x005c:
            java.lang.String r2 = "ADMOST-VIDEO"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r4.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.String r5 = "Error fetching info from "
            r4.append(r5)     // Catch:{ all -> 0x0053 }
            admost.adserver.videocache.o r5 = r7.f212c     // Catch:{ all -> 0x0053 }
            java.lang.String r5 = r5.f232a     // Catch:{ all -> 0x0053 }
            r4.append(r5)     // Catch:{ all -> 0x0053 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0053 }
            android.util.Log.w(r2, r4, r1)     // Catch:{ all -> 0x0053 }
            admost.adserver.videocache.C0081m.m253a((java.io.Closeable) r3)
            if (r0 == 0) goto L_0x007e
        L_0x007b:
            r0.disconnect()
        L_0x007e:
            return
        L_0x007f:
            admost.adserver.videocache.C0081m.m253a((java.io.Closeable) r3)
            if (r0 == 0) goto L_0x0087
            r0.disconnect()
        L_0x0087:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.adserver.videocache.C0072h.m219c():void");
    }

    /* renamed from: a */
    public void mo131a(long j) throws ProxyCacheException {
        try {
            HttpURLConnection a = m217a(j, -1);
            this.f213d = a;
            String contentType = a.getContentType();
            this.f214e = new BufferedInputStream(this.f213d.getInputStream(), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            C0083o oVar = new C0083o(this.f212c.f232a, m216a(this.f213d, j, this.f213d.getResponseCode()), contentType);
            this.f212c = oVar;
            this.f210a.mo156a(oVar.f232a, oVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.f212c.f232a + " with offset " + j, e);
        }
    }

    /* renamed from: b */
    public String mo132b() {
        return this.f212c.f232a;
    }

    public void close() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.f213d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (IllegalArgumentException | NullPointerException e) {
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (ArrayIndexOutOfBoundsException e2) {
                Log.w("ADMOST-VIDEO", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(" + e2);
            }
        }
    }

    public synchronized long length() throws ProxyCacheException {
        if (this.f212c.f233b == -2147483648L) {
            m219c();
        }
        return this.f212c.f233b;
    }

    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.f214e;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                throw new InterruptedProxyCacheException("Reading source " + this.f212c.f232a + " is interrupted", e);
            } catch (IOException e2) {
                throw new ProxyCacheException("Error reading data from " + this.f212c.f232a, e2);
            }
        } else {
            throw new ProxyCacheException("Error reading data from " + this.f212c.f232a + ": connection is absent!");
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f212c + "}";
    }

    public C0072h(String str, C0099c cVar) {
        this(str, cVar, new C0095a());
    }

    public C0072h(String str, C0099c cVar, C0096b bVar) {
        C0077k.m231a(cVar);
        this.f210a = cVar;
        C0077k.m231a(bVar);
        this.f211b = bVar;
        C0083o oVar = cVar.get(str);
        this.f212c = oVar == null ? new C0083o(str, -2147483648L, C0081m.m257d(str)) : oVar;
    }

    public C0072h(C0072h hVar) {
        this.f212c = hVar.f212c;
        this.f210a = hVar.f210a;
        this.f211b = hVar.f211b;
    }

    /* renamed from: a */
    private long m216a(HttpURLConnection httpURLConnection, long j, int i) throws IOException {
        long a = m215a(httpURLConnection);
        if (i == 200) {
            return a;
        }
        if (i == 206) {
            return a + j;
        }
        return this.f212c.f233b;
    }

    /* renamed from: a */
    private long m215a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1;
        }
        return Long.parseLong(headerField);
    }

    /* renamed from: a */
    private HttpURLConnection m217a(long j, int i) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.f212c.f232a;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            sb.toString();
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            m218a(httpURLConnection, str2);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m218a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry next : this.f211b.mo155a(str).entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
    }

    /* renamed from: a */
    public synchronized String mo130a() throws ProxyCacheException {
        if (TextUtils.isEmpty(this.f212c.f234c)) {
            m219c();
        }
        return this.f212c.f234c;
    }
}
