package com.applovin.impl.sdk.network;

import com.applovin.impl.mediation.p047d.C1728b;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.p051c.C1860h;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2032t;
import com.applovin.impl.sdk.utils.C2033u;
import com.applovin.sdk.AppLovinErrorCodes;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.network.a */
public class C1956a {

    /* renamed from: a */
    private final C1941j f6536a;

    /* renamed from: b */
    private final C1977q f6537b;

    /* renamed from: c */
    private C1958b f6538c;

    /* renamed from: com.applovin.impl.sdk.network.a$a */
    public static class C1957a {

        /* renamed from: a */
        private long f6539a;

        /* renamed from: b */
        private long f6540b;

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m7584a(long j) {
            this.f6539a = j;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m7586b(long j) {
            this.f6540b = j;
        }

        /* renamed from: a */
        public long mo8634a() {
            return this.f6539a;
        }

        /* renamed from: b */
        public long mo8635b() {
            return this.f6540b;
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.a$b */
    public static class C1958b {

        /* renamed from: a */
        private final long f6541a = System.currentTimeMillis();

        /* renamed from: b */
        private final String f6542b;

        /* renamed from: c */
        private final long f6543c;

        /* renamed from: d */
        private final long f6544d;

        C1958b(String str, long j, long j2) {
            this.f6542b = str;
            this.f6543c = j;
            this.f6544d = j2;
        }

        /* renamed from: a */
        public long mo8636a() {
            return this.f6541a;
        }

        /* renamed from: b */
        public String mo8637b() {
            return this.f6542b;
        }

        /* renamed from: c */
        public long mo8638c() {
            return this.f6543c;
        }

        /* renamed from: d */
        public long mo8639d() {
            return this.f6544d;
        }

        public String toString() {
            return "RequestMeasurement{timestampMillis=" + this.f6541a + ", urlHostAndPathString='" + this.f6542b + '\'' + ", responseSize=" + this.f6543c + ", connectionTimeMillis=" + this.f6544d + '}';
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.a$c */
    public interface C1959c<T> {
        /* renamed from: a */
        void mo7627a(int i);

        /* renamed from: a */
        void mo7628a(T t, int i);
    }

    public C1956a(C1941j jVar) {
        this.f6536a = jVar;
        this.f6537b = jVar.mo8602v();
    }

    /* renamed from: a */
    private int m7574a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return AppLovinErrorCodes.NO_NETWORK;
        }
        if (th instanceof SocketTimeoutException) {
            return AppLovinErrorCodes.FETCH_AD_TIMEOUT;
        }
        if (th instanceof IOException) {
            return -100;
        }
        return th instanceof JSONException ? -104 : -1;
    }

    /* renamed from: a */
    private <T> T m7575a(String str, T t) throws JSONException, SAXException, ClassCastException {
        if (t == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (t instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (t instanceof C2032t) {
                return C2033u.m8054a(str, this.f6536a);
            }
            if (t instanceof String) {
                return str;
            }
            C1977q qVar = this.f6537b;
            qVar.mo8746e("ConnectionManager", "Failed to process response of type '" + t.getClass().getName() + "'");
        }
        return t;
    }

    /* renamed from: a */
    private HttpURLConnection m7576a(String str, String str2, Map<String, String> map, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f6536a.mo8549a(C1841c.f6000dq)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f6536a.mo8549a(C1841c.f6001dr)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m7577a(int i, String str) {
        if (((Boolean) this.f6536a.mo8549a(C1841c.f5828ab)).booleanValue()) {
            try {
                C1964d.m7633a(i, str, this.f6536a.mo8527E());
            } catch (Throwable th) {
                C1977q v = this.f6536a.mo8602v();
                v.mo8743b("ConnectionManager", "Failed to track response code for URL: " + str, th);
            }
        }
    }

    /* renamed from: a */
    private void m7578a(String str) {
        C1860h hVar;
        C1859g gVar;
        if (C2025o.m7961a(str, C1992h.m7863g(this.f6536a)) || C2025o.m7961a(str, C1992h.m7865h(this.f6536a))) {
            hVar = this.f6536a.mo8534M();
            gVar = C1859g.f6193h;
        } else if (C2025o.m7961a(str, C1728b.m6614a(this.f6536a)) || C2025o.m7961a(str, C1728b.m6616b(this.f6536a))) {
            hVar = this.f6536a.mo8534M();
            gVar = C1859g.f6200o;
        } else {
            hVar = this.f6536a.mo8534M();
            gVar = C1859g.f6194i;
        }
        hVar.mo8387a(gVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.String} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=T, code=org.json.JSONObject, for r8v0, types: [T, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> void m7579a(java.lang.String r5, int r6, java.lang.String r7, org.json.JSONObject r8, boolean r9, com.applovin.impl.sdk.network.C1956a.C1959c<T> r10) {
        /*
            r4 = this;
            com.applovin.impl.sdk.q r0 = r4.f6537b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r2 = " received from \""
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ConnectionManager"
            r0.mo8742b(r2, r1)
            com.applovin.impl.sdk.q r0 = r4.f6537b
            r0.mo8740a(r2, r5)
            java.lang.String r0 = "\""
            r1 = 200(0xc8, float:2.8E-43)
            if (r6 < r1) goto L_0x00b7
            r1 = 300(0x12c, float:4.2E-43)
            if (r6 >= r1) goto L_0x00b7
            if (r9 == 0) goto L_0x0036
            com.applovin.impl.sdk.j r9 = r4.f6536a
            java.lang.String r9 = r9.mo8599t()
            java.lang.String r5 = com.applovin.impl.sdk.utils.C2023m.m7940a((java.lang.String) r5, (java.lang.String) r9)
        L_0x0036:
            if (r5 == 0) goto L_0x0041
            int r9 = r5.length()
            r1 = 2
            if (r9 <= r1) goto L_0x0041
            r9 = 1
            goto L_0x0042
        L_0x0041:
            r9 = 0
        L_0x0042:
            r1 = 204(0xcc, float:2.86E-43)
            if (r6 == r1) goto L_0x00b3
            if (r9 == 0) goto L_0x00b3
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            if (r9 == 0) goto L_0x004e
        L_0x004c:
            r8 = r5
            goto L_0x00b3
        L_0x004e:
            boolean r9 = r8 instanceof com.applovin.impl.sdk.utils.C2032t     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            if (r9 == 0) goto L_0x0059
            com.applovin.impl.sdk.j r9 = r4.f6536a     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            com.applovin.impl.sdk.utils.t r5 = com.applovin.impl.sdk.utils.C2033u.m8054a((java.lang.String) r5, (com.applovin.impl.sdk.C1941j) r9)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            goto L_0x004c
        L_0x0059:
            boolean r9 = r8 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            if (r9 == 0) goto L_0x0064
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r9.<init>(r5)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r8 = r9
            goto L_0x00b3
        L_0x0064:
            com.applovin.impl.sdk.q r5 = r4.f6537b     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r9.<init>()     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.String r1 = "Unable to handle '"
            r9.append(r1)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.Class r1 = r8.getClass()     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.String r1 = r1.getName()     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r9.append(r1)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.String r1 = "'"
            r9.append(r1)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            r5.mo8746e(r2, r9)     // Catch:{ JSONException -> 0x0096, SAXException -> 0x0088 }
            goto L_0x00b3
        L_0x0088:
            r5 = move-exception
            r4.m7578a((java.lang.String) r7)
            com.applovin.impl.sdk.q r9 = r4.f6537b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Invalid XML returned from \""
            goto L_0x00a3
        L_0x0096:
            r5 = move-exception
            r4.m7578a((java.lang.String) r7)
            com.applovin.impl.sdk.q r9 = r4.f6537b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Invalid JSON returned from \""
        L_0x00a3:
            r1.append(r3)
            r1.append(r7)
            r1.append(r0)
            java.lang.String r7 = r1.toString()
            r9.mo8743b(r2, r7, r5)
        L_0x00b3:
            r10.mo7628a(r8, r6)
            goto L_0x00d6
        L_0x00b7:
            com.applovin.impl.sdk.q r5 = r4.f6537b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            java.lang.String r9 = " error received from \""
            r8.append(r9)
            r8.append(r7)
            r8.append(r0)
            java.lang.String r7 = r8.toString()
            r5.mo8746e(r2, r7)
            r10.mo7627a(r6)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1956a.m7579a(java.lang.String, int, java.lang.String, java.lang.Object, boolean, com.applovin.impl.sdk.network.a$c):void");
    }

    /* renamed from: a */
    private void m7580a(String str, String str2, int i, long j) {
        C1977q qVar = this.f6537b;
        qVar.mo8744c("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C1992h.m7861f(this.f6536a) + " to \"" + str2 + "\"");
    }

    /* renamed from: a */
    private void m7581a(String str, String str2, int i, long j, Throwable th) {
        C1977q qVar = this.f6537b;
        qVar.mo8743b("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C1992h.m7861f(this.f6536a) + " to \"" + str2 + "\"", th);
    }

    /* renamed from: a */
    public C1958b mo8632a() {
        return this.f6538c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x037e, code lost:
        if (r27.mo8652h() == false) goto L_0x0387;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x037a A[SYNTHETIC, Splitter:B:170:0x037a] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03d6 A[SYNTHETIC, Splitter:B:197:0x03d6] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void mo8633a(com.applovin.impl.sdk.network.C1960b<T> r27, com.applovin.impl.sdk.network.C1956a.C1957a r28, com.applovin.impl.sdk.network.C1956a.C1959c<T> r29) {
        /*
            r26 = this;
            r8 = r26
            r0 = r28
            r9 = r29
            if (r27 == 0) goto L_0x041a
            java.lang.String r1 = r27.mo8641a()
            java.lang.String r10 = r27.mo8644b()
            if (r1 == 0) goto L_0x0412
            if (r10 == 0) goto L_0x040a
            if (r9 == 0) goto L_0x0402
            java.lang.String r2 = r1.toLowerCase()
            java.lang.String r3 = "http"
            boolean r2 = r2.startsWith(r3)
            java.lang.String r7 = "ConnectionManager"
            if (r2 != 0) goto L_0x0043
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Requested postback submission to non HTTP endpoint "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "; skipping..."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.applovin.impl.sdk.C1977q.m7751i(r7, r0)
            r0 = -900(0xfffffffffffffc7c, float:NaN)
            r9.mo7627a(r0)
            return
        L_0x0043:
            com.applovin.impl.sdk.j r2 = r8.f6536a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r3 = com.applovin.impl.sdk.p050b.C1841c.f6002ds
            java.lang.Object r2 = r2.mo8549a(r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x006c
            java.lang.String r2 = "https://"
            boolean r3 = r1.contains(r2)
            if (r3 != 0) goto L_0x006c
            com.applovin.impl.sdk.j r3 = r8.f6536a
            com.applovin.impl.sdk.q r3 = r3.mo8602v()
            java.lang.String r4 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r3.mo8745d(r7, r4)
            java.lang.String r3 = "http://"
            java.lang.String r1 = r1.replace(r3, r2)
        L_0x006c:
            boolean r11 = r27.mo8658m()
            com.applovin.impl.sdk.j r2 = r8.f6536a
            long r2 = com.applovin.impl.sdk.utils.C2029r.m7987a((com.applovin.impl.sdk.C1941j) r2)
            java.util.Map r4 = r27.mo8646c()
            if (r4 == 0) goto L_0x0086
            java.util.Map r4 = r27.mo8646c()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x008c
        L_0x0086:
            int r4 = r27.mo8654i()
            if (r4 < 0) goto L_0x00c0
        L_0x008c:
            java.util.Map r4 = r27.mo8646c()
            if (r4 == 0) goto L_0x00a5
            int r5 = r27.mo8654i()
            if (r5 < 0) goto L_0x00a5
            int r5 = r27.mo8654i()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = "current_retry_attempt"
            r4.put(r6, r5)
        L_0x00a5:
            if (r11 == 0) goto L_0x00bc
            java.lang.String r4 = com.applovin.impl.sdk.utils.C2029r.m7998a((java.util.Map<java.lang.String, java.lang.String>) r4)
            com.applovin.impl.sdk.j r5 = r8.f6536a
            java.lang.String r5 = r5.mo8599t()
            java.lang.String r4 = com.applovin.impl.sdk.utils.C2023m.m7941a((java.lang.String) r4, (java.lang.String) r5, (long) r2)
            java.lang.String r5 = "p"
            java.lang.String r1 = com.applovin.impl.sdk.utils.C2025o.m7957a(r1, r5, r4)
            goto L_0x00c0
        L_0x00bc:
            java.lang.String r1 = com.applovin.impl.sdk.utils.C2025o.m7962b(r1, r4)
        L_0x00c0:
            r12 = r1
            long r13 = java.lang.System.currentTimeMillis()
            com.applovin.impl.sdk.q r4 = r8.f6537b     // Catch:{ all -> 0x03cd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x03cd }
            r5.<init>()     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = "Sending "
            r5.append(r6)     // Catch:{ all -> 0x03cd }
            r5.append(r10)     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = " request to \""
            r5.append(r6)     // Catch:{ all -> 0x03cd }
            r5.append(r12)     // Catch:{ all -> 0x03cd }
            java.lang.String r6 = "\"..."
            r5.append(r6)     // Catch:{ all -> 0x03cd }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x03cd }
            r4.mo8744c(r7, r5)     // Catch:{ all -> 0x03cd }
            java.util.Map r4 = r27.mo8647d()     // Catch:{ all -> 0x03cd }
            int r5 = r27.mo8656k()     // Catch:{ all -> 0x03cd }
            java.net.HttpURLConnection r5 = r8.m7576a((java.lang.String) r12, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r4, (int) r5)     // Catch:{ all -> 0x03cd }
            org.json.JSONObject r4 = r27.mo8648e()     // Catch:{ all -> 0x03c4 }
            if (r4 == 0) goto L_0x016c
            if (r11 == 0) goto L_0x010f
            org.json.JSONObject r4 = r27.mo8648e()     // Catch:{ all -> 0x0165 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0165 }
            com.applovin.impl.sdk.j r6 = r8.f6536a     // Catch:{ all -> 0x0165 }
            java.lang.String r6 = r6.mo8599t()     // Catch:{ all -> 0x0165 }
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2023m.m7941a((java.lang.String) r4, (java.lang.String) r6, (long) r2)     // Catch:{ all -> 0x0165 }
            goto L_0x0117
        L_0x010f:
            org.json.JSONObject r2 = r27.mo8648e()     // Catch:{ all -> 0x0165 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0165 }
        L_0x0117:
            com.applovin.impl.sdk.q r3 = r8.f6537b     // Catch:{ all -> 0x0165 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r4.<init>()     // Catch:{ all -> 0x0165 }
            java.lang.String r6 = "Request to \""
            r4.append(r6)     // Catch:{ all -> 0x0165 }
            r4.append(r12)     // Catch:{ all -> 0x0165 }
            java.lang.String r6 = "\" is "
            r4.append(r6)     // Catch:{ all -> 0x0165 }
            r4.append(r2)     // Catch:{ all -> 0x0165 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0165 }
            r3.mo8742b(r7, r4)     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json; charset=utf-8"
            r5.setRequestProperty(r3, r4)     // Catch:{ all -> 0x0165 }
            r3 = 1
            r5.setDoOutput(r3)     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = "UTF-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x0165 }
            byte[] r3 = r2.getBytes(r3)     // Catch:{ all -> 0x0165 }
            int r3 = r3.length     // Catch:{ all -> 0x0165 }
            r5.setFixedLengthStreamingMode(r3)     // Catch:{ all -> 0x0165 }
            java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ all -> 0x0165 }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0165 }
            java.io.OutputStream r6 = r5.getOutputStream()     // Catch:{ all -> 0x0165 }
            java.lang.String r1 = "UTF8"
            r4.<init>(r6, r1)     // Catch:{ all -> 0x0165 }
            r3.<init>(r4)     // Catch:{ all -> 0x0165 }
            r3.print(r2)     // Catch:{ all -> 0x0165 }
            r3.close()     // Catch:{ all -> 0x0165 }
            goto L_0x016c
        L_0x0165:
            r0 = move-exception
            r7 = r0
            r15 = r5
            r24 = r10
            goto L_0x03ca
        L_0x016c:
            int r6 = r5.getResponseCode()     // Catch:{ MalformedURLException -> 0x035d, all -> 0x0353 }
            if (r6 <= 0) goto L_0x0332
            com.applovin.impl.sdk.j r1 = r8.f6536a     // Catch:{ MalformedURLException -> 0x032b, all -> 0x0324 }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p050b.C1841c.f6028eS     // Catch:{ MalformedURLException -> 0x032b, all -> 0x0324 }
            java.lang.Object r1 = r1.mo8549a(r2)     // Catch:{ MalformedURLException -> 0x032b, all -> 0x0324 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ MalformedURLException -> 0x032b, all -> 0x0324 }
            boolean r1 = r1.booleanValue()     // Catch:{ MalformedURLException -> 0x032b, all -> 0x0324 }
            if (r1 == 0) goto L_0x019b
            r1 = r26
            r2 = r10
            r3 = r12
            r4 = r6
            r17 = r5
            r15 = r6
            r5 = r13
            r1.m7580a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5)     // Catch:{ MalformedURLException -> 0x0195, all -> 0x018f }
            goto L_0x019e
        L_0x018f:
            r0 = move-exception
            r7 = r0
            r24 = r10
            goto L_0x034a
        L_0x0195:
            r0 = move-exception
            r7 = r0
            r24 = r10
            goto L_0x0351
        L_0x019b:
            r17 = r5
            r15 = r6
        L_0x019e:
            java.io.InputStream r6 = r17.getInputStream()     // Catch:{ MalformedURLException -> 0x0322, all -> 0x0320 }
            r8.m7577a((int) r15, (java.lang.String) r12)     // Catch:{ MalformedURLException -> 0x031a, all -> 0x0314 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x031a, all -> 0x0314 }
            long r4 = r1 - r13
            com.applovin.impl.sdk.j r1 = r8.f6536a     // Catch:{ MalformedURLException -> 0x031a, all -> 0x0314 }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p050b.C1841c.f6028eS     // Catch:{ MalformedURLException -> 0x031a, all -> 0x0314 }
            java.lang.Object r1 = r1.mo8549a(r2)     // Catch:{ MalformedURLException -> 0x031a, all -> 0x0314 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ MalformedURLException -> 0x031a, all -> 0x0314 }
            boolean r1 = r1.booleanValue()     // Catch:{ MalformedURLException -> 0x031a, all -> 0x0314 }
            if (r1 == 0) goto L_0x0251
            com.applovin.impl.sdk.j r1 = r8.f6536a     // Catch:{ MalformedURLException -> 0x0249, all -> 0x0241 }
            java.lang.String r2 = com.applovin.impl.sdk.utils.C1992h.m7845a((java.io.InputStream) r6, (com.applovin.impl.sdk.C1941j) r1)     // Catch:{ MalformedURLException -> 0x0249, all -> 0x0241 }
            boolean r1 = r27.mo8652h()     // Catch:{ MalformedURLException -> 0x0249, all -> 0x0241 }
            if (r1 == 0) goto L_0x0230
            if (r0 == 0) goto L_0x0211
            if (r2 == 0) goto L_0x01fa
            int r1 = r2.length()     // Catch:{ MalformedURLException -> 0x01f6, all -> 0x01f2 }
            r16 = r6
            long r6 = (long) r1
            r0.m7586b(r6)     // Catch:{ MalformedURLException -> 0x0209, all -> 0x0200 }
            boolean r1 = r27.mo8659n()     // Catch:{ MalformedURLException -> 0x0209, all -> 0x0200 }
            if (r1 == 0) goto L_0x01fc
            com.applovin.impl.sdk.network.a$b r1 = new com.applovin.impl.sdk.network.a$b     // Catch:{ MalformedURLException -> 0x0209, all -> 0x0200 }
            java.lang.String r19 = r27.mo8641a()     // Catch:{ MalformedURLException -> 0x0209, all -> 0x0200 }
            int r3 = r2.length()     // Catch:{ MalformedURLException -> 0x0209, all -> 0x0200 }
            long r6 = (long) r3     // Catch:{ MalformedURLException -> 0x0209, all -> 0x0200 }
            r18 = r1
            r20 = r6
            r22 = r4
            r18.<init>(r19, r20, r22)     // Catch:{ MalformedURLException -> 0x0209, all -> 0x0200 }
            r8.f6538c = r1     // Catch:{ MalformedURLException -> 0x0209, all -> 0x0200 }
            goto L_0x01fc
        L_0x01f2:
            r0 = move-exception
            r16 = r6
            goto L_0x0201
        L_0x01f6:
            r0 = move-exception
            r16 = r6
            goto L_0x020a
        L_0x01fa:
            r16 = r6
        L_0x01fc:
            r0.m7584a(r4)     // Catch:{ MalformedURLException -> 0x0209, all -> 0x0200 }
            goto L_0x0213
        L_0x0200:
            r0 = move-exception
        L_0x0201:
            r7 = r0
            r24 = r10
            r1 = r15
            r10 = r16
            goto L_0x0384
        L_0x0209:
            r0 = move-exception
        L_0x020a:
            r7 = r0
            r24 = r10
            r10 = r16
            goto L_0x0365
        L_0x0211:
            r16 = r6
        L_0x0213:
            int r3 = r17.getResponseCode()     // Catch:{ MalformedURLException -> 0x022c, all -> 0x0228 }
            java.lang.Object r5 = r27.mo8651g()     // Catch:{ MalformedURLException -> 0x022c, all -> 0x0228 }
            r1 = r26
            r4 = r12
            r7 = r16
            r6 = r11
            r11 = r7
            r7 = r29
            r1.m7579a(r2, r3, r4, r5, r6, r7)     // Catch:{ MalformedURLException -> 0x0239, all -> 0x0237 }
            goto L_0x023e
        L_0x0228:
            r0 = move-exception
            r11 = r16
            goto L_0x0243
        L_0x022c:
            r0 = move-exception
            r11 = r16
            goto L_0x024b
        L_0x0230:
            r11 = r6
            if (r0 == 0) goto L_0x023b
            r0.m7584a(r4)     // Catch:{ MalformedURLException -> 0x0239, all -> 0x0237 }
            goto L_0x023b
        L_0x0237:
            r0 = move-exception
            goto L_0x0243
        L_0x0239:
            r0 = move-exception
            goto L_0x024b
        L_0x023b:
            r9.mo7628a(r2, r15)     // Catch:{ MalformedURLException -> 0x0239, all -> 0x0237 }
        L_0x023e:
            r10 = r11
            goto L_0x03ac
        L_0x0241:
            r0 = move-exception
            r11 = r6
        L_0x0243:
            r7 = r0
            r24 = r10
            r10 = r11
            goto L_0x0383
        L_0x0249:
            r0 = move-exception
            r11 = r6
        L_0x024b:
            r7 = r0
            r24 = r10
            r10 = r11
            goto L_0x0365
        L_0x0251:
            r1 = 200(0xc8, float:2.8E-43)
            if (r15 < r1) goto L_0x02ff
            r1 = 400(0x190, float:5.6E-43)
            if (r15 >= r1) goto L_0x02ff
            if (r0 == 0) goto L_0x0270
            r0.m7584a(r4)     // Catch:{ MalformedURLException -> 0x0269, all -> 0x025f }
            goto L_0x0270
        L_0x025f:
            r0 = move-exception
            r7 = r0
            r24 = r10
            r1 = r15
            r15 = r17
            r10 = r6
            goto L_0x03d4
        L_0x0269:
            r0 = move-exception
            r7 = r0
            r24 = r10
            r10 = r6
            goto L_0x0365
        L_0x0270:
            r1 = r26
            r2 = r10
            r3 = r12
            r22 = r4
            r4 = r15
            r24 = r10
            r10 = r6
            r5 = r13
            r1.m7580a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5)     // Catch:{ MalformedURLException -> 0x0312 }
            com.applovin.impl.sdk.j r1 = r8.f6536a     // Catch:{ MalformedURLException -> 0x0312 }
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1992h.m7845a((java.io.InputStream) r10, (com.applovin.impl.sdk.C1941j) r1)     // Catch:{ MalformedURLException -> 0x0312 }
            if (r1 == 0) goto L_0x02f6
            com.applovin.impl.sdk.q r2 = r8.f6537b     // Catch:{ MalformedURLException -> 0x0312 }
            r2.mo8740a(r7, r1)     // Catch:{ MalformedURLException -> 0x0312 }
            if (r0 == 0) goto L_0x0295
            int r2 = r1.length()     // Catch:{ MalformedURLException -> 0x0312 }
            long r2 = (long) r2     // Catch:{ MalformedURLException -> 0x0312 }
            r0.m7586b(r2)     // Catch:{ MalformedURLException -> 0x0312 }
        L_0x0295:
            boolean r0 = r27.mo8659n()     // Catch:{ MalformedURLException -> 0x0312 }
            if (r0 == 0) goto L_0x02af
            com.applovin.impl.sdk.network.a$b r0 = new com.applovin.impl.sdk.network.a$b     // Catch:{ MalformedURLException -> 0x0312 }
            java.lang.String r19 = r27.mo8641a()     // Catch:{ MalformedURLException -> 0x0312 }
            int r2 = r1.length()     // Catch:{ MalformedURLException -> 0x0312 }
            long r2 = (long) r2     // Catch:{ MalformedURLException -> 0x0312 }
            r18 = r0
            r20 = r2
            r18.<init>(r19, r20, r22)     // Catch:{ MalformedURLException -> 0x0312 }
            r8.f6538c = r0     // Catch:{ MalformedURLException -> 0x0312 }
        L_0x02af:
            if (r11 == 0) goto L_0x02bb
            com.applovin.impl.sdk.j r0 = r8.f6536a     // Catch:{ MalformedURLException -> 0x0312 }
            java.lang.String r0 = r0.mo8599t()     // Catch:{ MalformedURLException -> 0x0312 }
            java.lang.String r1 = com.applovin.impl.sdk.utils.C2023m.m7940a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x0312 }
        L_0x02bb:
            java.lang.Object r0 = r27.mo8651g()     // Catch:{ all -> 0x02c8 }
            java.lang.Object r0 = r8.m7575a((java.lang.String) r1, r0)     // Catch:{ all -> 0x02c8 }
            r9.mo7628a(r0, r15)     // Catch:{ all -> 0x02c8 }
            goto L_0x03ac
        L_0x02c8:
            r0 = move-exception
            com.applovin.impl.sdk.q r1 = r8.f6537b     // Catch:{ MalformedURLException -> 0x0312 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0312 }
            r2.<init>()     // Catch:{ MalformedURLException -> 0x0312 }
            java.lang.String r3 = "Unable to parse response from \""
            r2.append(r3)     // Catch:{ MalformedURLException -> 0x0312 }
            r2.append(r12)     // Catch:{ MalformedURLException -> 0x0312 }
            java.lang.String r3 = "\""
            r2.append(r3)     // Catch:{ MalformedURLException -> 0x0312 }
            java.lang.String r2 = r2.toString()     // Catch:{ MalformedURLException -> 0x0312 }
            r1.mo8743b(r7, r2, r0)     // Catch:{ MalformedURLException -> 0x0312 }
            com.applovin.impl.sdk.j r0 = r8.f6536a     // Catch:{ MalformedURLException -> 0x0312 }
            com.applovin.impl.sdk.c.h r0 = r0.mo8534M()     // Catch:{ MalformedURLException -> 0x0312 }
            com.applovin.impl.sdk.c.g r1 = com.applovin.impl.sdk.p051c.C1859g.f6194i     // Catch:{ MalformedURLException -> 0x0312 }
            r0.mo8387a(r1)     // Catch:{ MalformedURLException -> 0x0312 }
            r0 = -800(0xfffffffffffffce0, float:NaN)
            r9.mo7627a(r0)     // Catch:{ MalformedURLException -> 0x0312 }
            goto L_0x03ac
        L_0x02f6:
            java.lang.Object r0 = r27.mo8651g()     // Catch:{ MalformedURLException -> 0x0312 }
            r9.mo7628a(r0, r15)     // Catch:{ MalformedURLException -> 0x0312 }
            goto L_0x03ac
        L_0x02ff:
            r24 = r10
            r10 = r6
            r7 = 0
            r1 = r26
            r2 = r24
            r3 = r12
            r4 = r15
            r5 = r13
            r1.m7581a(r2, r3, r4, r5, r7)     // Catch:{ MalformedURLException -> 0x0312 }
            r9.mo7627a(r15)     // Catch:{ MalformedURLException -> 0x0312 }
            goto L_0x03ac
        L_0x0312:
            r0 = move-exception
            goto L_0x031e
        L_0x0314:
            r0 = move-exception
            r24 = r10
            r10 = r6
            goto L_0x0382
        L_0x031a:
            r0 = move-exception
            r24 = r10
            r10 = r6
        L_0x031e:
            r7 = r0
            goto L_0x0365
        L_0x0320:
            r0 = move-exception
            goto L_0x0328
        L_0x0322:
            r0 = move-exception
            goto L_0x032f
        L_0x0324:
            r0 = move-exception
            r17 = r5
            r15 = r6
        L_0x0328:
            r24 = r10
            goto L_0x0349
        L_0x032b:
            r0 = move-exception
            r17 = r5
            r15 = r6
        L_0x032f:
            r24 = r10
            goto L_0x0350
        L_0x0332:
            r17 = r5
            r15 = r6
            r24 = r10
            r7 = 0
            r1 = r26
            r2 = r24
            r3 = r12
            r4 = r15
            r5 = r13
            r1.m7581a(r2, r3, r4, r5, r7)     // Catch:{ MalformedURLException -> 0x034f, all -> 0x0348 }
            r9.mo7627a(r15)     // Catch:{ MalformedURLException -> 0x034f, all -> 0x0348 }
            r15 = 0
            goto L_0x03ad
        L_0x0348:
            r0 = move-exception
        L_0x0349:
            r7 = r0
        L_0x034a:
            r1 = r15
            r15 = r17
            goto L_0x03cb
        L_0x034f:
            r0 = move-exception
        L_0x0350:
            r7 = r0
        L_0x0351:
            r10 = 0
            goto L_0x0365
        L_0x0353:
            r0 = move-exception
            r17 = r5
            r24 = r10
            r7 = r0
            r15 = r17
            goto L_0x03ca
        L_0x035d:
            r0 = move-exception
            r17 = r5
            r24 = r10
            r7 = r0
            r10 = 0
            r15 = 0
        L_0x0365:
            r0 = -901(0xfffffffffffffc7b, float:NaN)
            r8.m7577a((int) r0, (java.lang.String) r12)     // Catch:{ all -> 0x03ba }
            com.applovin.impl.sdk.j r1 = r8.f6536a     // Catch:{ all -> 0x03ba }
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p050b.C1841c.f6028eS     // Catch:{ all -> 0x03ba }
            java.lang.Object r1 = r1.mo8549a(r2)     // Catch:{ all -> 0x03ba }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x03ba }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x03ba }
            if (r1 == 0) goto L_0x0387
            boolean r1 = r27.mo8652h()     // Catch:{ all -> 0x0381 }
            if (r1 != 0) goto L_0x038d
            goto L_0x0387
        L_0x0381:
            r0 = move-exception
        L_0x0382:
            r7 = r0
        L_0x0383:
            r1 = r15
        L_0x0384:
            r15 = r17
            goto L_0x03d4
        L_0x0387:
            java.lang.Object r1 = r27.mo8651g()     // Catch:{ all -> 0x03ba }
            if (r1 == 0) goto L_0x039b
        L_0x038d:
            r1 = r26
            r2 = r24
            r3 = r12
            r4 = r15
            r5 = r13
            r1.m7581a(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x0381 }
            r9.mo7627a(r0)     // Catch:{ all -> 0x0381 }
            goto L_0x03ac
        L_0x039b:
            r1 = r26
            r2 = r24
            r3 = r12
            r4 = r15
            r5 = r13
            r1.m7580a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5)     // Catch:{ all -> 0x03ba }
            java.lang.Object r1 = r27.mo8651g()     // Catch:{ all -> 0x03ba }
            r9.mo7628a(r1, r0)     // Catch:{ all -> 0x03ba }
        L_0x03ac:
            r15 = r10
        L_0x03ad:
            com.applovin.impl.sdk.j r0 = r8.f6536a
            com.applovin.impl.sdk.utils.C2029r.m8009a((java.io.Closeable) r15, (com.applovin.impl.sdk.C1941j) r0)
            com.applovin.impl.sdk.j r0 = r8.f6536a
            r1 = r17
            com.applovin.impl.sdk.utils.C2029r.m8012a((java.net.HttpURLConnection) r1, (com.applovin.impl.sdk.C1941j) r0)
            goto L_0x03f5
        L_0x03ba:
            r0 = move-exception
            r1 = r17
            r7 = r0
            r25 = r15
            r15 = r1
            r1 = r25
            goto L_0x03d4
        L_0x03c4:
            r0 = move-exception
            r1 = r5
            r24 = r10
            r7 = r0
            r15 = r1
        L_0x03ca:
            r1 = 0
        L_0x03cb:
            r10 = 0
            goto L_0x03d4
        L_0x03cd:
            r0 = move-exception
            r24 = r10
            r7 = r0
            r1 = 0
            r10 = 0
            r15 = 0
        L_0x03d4:
            if (r1 != 0) goto L_0x03da
            int r1 = r8.m7574a((java.lang.Throwable) r7)     // Catch:{ all -> 0x03f6 }
        L_0x03da:
            r0 = r1
            r8.m7577a((int) r0, (java.lang.String) r12)     // Catch:{ all -> 0x03f6 }
            r1 = r26
            r2 = r24
            r3 = r12
            r4 = r0
            r5 = r13
            r1.m7581a(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x03f6 }
            r9.mo7627a(r0)     // Catch:{ all -> 0x03f6 }
            com.applovin.impl.sdk.j r0 = r8.f6536a
            com.applovin.impl.sdk.utils.C2029r.m8009a((java.io.Closeable) r10, (com.applovin.impl.sdk.C1941j) r0)
            com.applovin.impl.sdk.j r0 = r8.f6536a
            com.applovin.impl.sdk.utils.C2029r.m8012a((java.net.HttpURLConnection) r15, (com.applovin.impl.sdk.C1941j) r0)
        L_0x03f5:
            return
        L_0x03f6:
            r0 = move-exception
            com.applovin.impl.sdk.j r1 = r8.f6536a
            com.applovin.impl.sdk.utils.C2029r.m8009a((java.io.Closeable) r10, (com.applovin.impl.sdk.C1941j) r1)
            com.applovin.impl.sdk.j r1 = r8.f6536a
            com.applovin.impl.sdk.utils.C2029r.m8012a((java.net.HttpURLConnection) r15, (com.applovin.impl.sdk.C1941j) r1)
            throw r0
        L_0x0402:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No callback specified"
            r0.<init>(r1)
            throw r0
        L_0x040a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No method specified"
            r0.<init>(r1)
            throw r0
        L_0x0412:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No endpoint specified"
            r0.<init>(r1)
            throw r0
        L_0x041a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No request specified"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1956a.mo8633a(com.applovin.impl.sdk.network.b, com.applovin.impl.sdk.network.a$a, com.applovin.impl.sdk.network.a$c):void");
    }
}
