package com.onesignal;

import java.io.IOException;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: com.onesignal.y1 */
/* compiled from: OneSignalRestClient */
class C4731y1 {

    /* renamed from: com.onesignal.y1$a */
    /* compiled from: OneSignalRestClient */
    static class C4732a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f12843a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f12844b;

        /* renamed from: c */
        final /* synthetic */ C4738g f12845c;

        C4732a(String str, JSONObject jSONObject, C4738g gVar) {
            this.f12843a = str;
            this.f12844b = jSONObject;
            this.f12845c = gVar;
        }

        public void run() {
            C4731y1.m16450c(this.f12843a, "PUT", this.f12844b, this.f12845c, 120000, (String) null);
        }
    }

    /* renamed from: com.onesignal.y1$b */
    /* compiled from: OneSignalRestClient */
    static class C4733b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f12846a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f12847b;

        /* renamed from: c */
        final /* synthetic */ C4738g f12848c;

        C4733b(String str, JSONObject jSONObject, C4738g gVar) {
            this.f12846a = str;
            this.f12847b = jSONObject;
            this.f12848c = gVar;
        }

        public void run() {
            C4731y1.m16450c(this.f12846a, "POST", this.f12847b, this.f12848c, 120000, (String) null);
        }
    }

    /* renamed from: com.onesignal.y1$c */
    /* compiled from: OneSignalRestClient */
    static class C4734c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f12849a;

        /* renamed from: b */
        final /* synthetic */ C4738g f12850b;

        /* renamed from: c */
        final /* synthetic */ String f12851c;

        C4734c(String str, C4738g gVar, String str2) {
            this.f12849a = str;
            this.f12850b = gVar;
            this.f12851c = str2;
        }

        public void run() {
            C4731y1.m16450c(this.f12849a, (String) null, (JSONObject) null, this.f12850b, 60000, this.f12851c);
        }
    }

    /* renamed from: com.onesignal.y1$d */
    /* compiled from: OneSignalRestClient */
    static class C4735d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Thread[] f12852a;

        /* renamed from: b */
        final /* synthetic */ String f12853b;

        /* renamed from: c */
        final /* synthetic */ String f12854c;

        /* renamed from: d */
        final /* synthetic */ JSONObject f12855d;

        /* renamed from: e */
        final /* synthetic */ C4738g f12856e;

        /* renamed from: f */
        final /* synthetic */ int f12857f;

        /* renamed from: g */
        final /* synthetic */ String f12858g;

        C4735d(Thread[] threadArr, String str, String str2, JSONObject jSONObject, C4738g gVar, int i, String str3) {
            this.f12852a = threadArr;
            this.f12853b = str;
            this.f12854c = str2;
            this.f12855d = jSONObject;
            this.f12856e = gVar;
            this.f12857f = i;
            this.f12858g = str3;
        }

        public void run() {
            this.f12852a[0] = C4731y1.m16452d(this.f12853b, this.f12854c, this.f12855d, this.f12856e, this.f12857f, this.f12858g);
        }
    }

    /* renamed from: com.onesignal.y1$e */
    /* compiled from: OneSignalRestClient */
    static class C4736e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4738g f12859a;

        /* renamed from: b */
        final /* synthetic */ String f12860b;

        C4736e(C4738g gVar, String str) {
            this.f12859a = gVar;
            this.f12860b = str;
        }

        public void run() {
            this.f12859a.mo29737a(this.f12860b);
        }
    }

    /* renamed from: com.onesignal.y1$f */
    /* compiled from: OneSignalRestClient */
    static class C4737f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4738g f12861a;

        /* renamed from: b */
        final /* synthetic */ int f12862b;

        /* renamed from: c */
        final /* synthetic */ String f12863c;

        /* renamed from: d */
        final /* synthetic */ Throwable f12864d;

        C4737f(C4738g gVar, int i, String str, Throwable th) {
            this.f12861a = gVar;
            this.f12862b = i;
            this.f12863c = str;
            this.f12864d = th;
        }

        public void run() {
            this.f12861a.mo29736a(this.f12862b, this.f12863c, this.f12864d);
        }
    }

    /* renamed from: com.onesignal.y1$g */
    /* compiled from: OneSignalRestClient */
    static abstract class C4738g {
        C4738g() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
        }
    }

    /* renamed from: a */
    private static int m16440a(int i) {
        return i + 5000;
    }

    /* renamed from: c */
    public static void m16451c(String str, JSONObject jSONObject, C4738g gVar) {
        new Thread(new C4732a(str, jSONObject, gVar), "OS_REST_ASYNC_PUT").start();
    }

    /* renamed from: d */
    public static void m16453d(String str, JSONObject jSONObject, C4738g gVar) {
        m16450c(str, "PUT", jSONObject, gVar, 120000, (String) null);
    }

    /* renamed from: a */
    public static void m16446a(String str, JSONObject jSONObject, C4738g gVar) {
        new Thread(new C4733b(str, jSONObject, gVar), "OS_REST_ASYNC_POST").start();
    }

    /* renamed from: b */
    public static void m16448b(String str, C4738g gVar, String str2) {
        m16450c(str, (String) null, (JSONObject) null, gVar, 60000, str2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0250, code lost:
        if (r8 != null) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0252, code lost:
        r8.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02a8, code lost:
        if (r8 == null) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02ab, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0266 A[Catch:{ all -> 0x02ac }] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Thread m16452d(java.lang.String r16, java.lang.String r17, org.json.JSONObject r18, com.onesignal.C4731y1.C4738g r19, int r20, java.lang.String r21) {
        /*
            r0 = r16
            r1 = r17
            r2 = r19
            r3 = r20
            r4 = r21
            java.lang.String r5 = "OneSignalRestClient: "
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 26
            if (r6 < r7) goto L_0x0017
            r6 = 10000(0x2710, float:1.4013E-41)
            android.net.TrafficStats.setThreadStatsTag(r6)
        L_0x0017:
            r6 = 0
            r7 = -1
            com.onesignal.n1$a0 r8 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x0260 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0260 }
            r9.<init>()     // Catch:{ all -> 0x0260 }
            java.lang.String r10 = "OneSignalRestClient: Making request to: https://api.onesignal.com/"
            r9.append(r10)     // Catch:{ all -> 0x0260 }
            r9.append(r0)     // Catch:{ all -> 0x0260 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0260 }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r8, (java.lang.String) r9)     // Catch:{ all -> 0x0260 }
            java.net.HttpURLConnection r8 = m16443a((java.lang.String) r16)     // Catch:{ all -> 0x0260 }
            r9 = 0
            r8.setUseCaches(r9)     // Catch:{ all -> 0x025e }
            r8.setConnectTimeout(r3)     // Catch:{ all -> 0x025e }
            r8.setReadTimeout(r3)     // Catch:{ all -> 0x025e }
            java.lang.String r3 = "SDK-Version"
            java.lang.String r9 = "onesignal/android/031302"
            r8.setRequestProperty(r3, r9)     // Catch:{ all -> 0x025e }
            java.lang.String r3 = "Accept"
            java.lang.String r9 = "application/vnd.onesignal.v1+json"
            r8.setRequestProperty(r3, r9)     // Catch:{ all -> 0x025e }
            r3 = 1
            if (r18 == 0) goto L_0x0051
            r8.setDoInput(r3)     // Catch:{ all -> 0x025e }
        L_0x0051:
            if (r1 == 0) goto L_0x0060
            java.lang.String r9 = "Content-Type"
            java.lang.String r10 = "application/json; charset=UTF-8"
            r8.setRequestProperty(r9, r10)     // Catch:{ all -> 0x025e }
            r8.setRequestMethod(r1)     // Catch:{ all -> 0x025e }
            r8.setDoOutput(r3)     // Catch:{ all -> 0x025e }
        L_0x0060:
            java.lang.String r3 = "UTF-8"
            if (r18 == 0) goto L_0x0093
            java.lang.String r9 = r18.toString()     // Catch:{ all -> 0x025e }
            com.onesignal.n1$a0 r10 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x025e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x025e }
            r11.<init>()     // Catch:{ all -> 0x025e }
            r11.append(r5)     // Catch:{ all -> 0x025e }
            r11.append(r1)     // Catch:{ all -> 0x025e }
            java.lang.String r12 = " SEND JSON: "
            r11.append(r12)     // Catch:{ all -> 0x025e }
            r11.append(r9)     // Catch:{ all -> 0x025e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x025e }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r10, (java.lang.String) r11)     // Catch:{ all -> 0x025e }
            byte[] r9 = r9.getBytes(r3)     // Catch:{ all -> 0x025e }
            int r10 = r9.length     // Catch:{ all -> 0x025e }
            r8.setFixedLengthStreamingMode(r10)     // Catch:{ all -> 0x025e }
            java.io.OutputStream r10 = r8.getOutputStream()     // Catch:{ all -> 0x025e }
            r10.write(r9)     // Catch:{ all -> 0x025e }
        L_0x0093:
            java.lang.String r9 = "PREFS_OS_ETAG_PREFIX_"
            if (r4 == 0) goto L_0x00c9
            java.lang.String r10 = com.onesignal.C4698w1.f12761a     // Catch:{ all -> 0x025e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x025e }
            r11.<init>()     // Catch:{ all -> 0x025e }
            r11.append(r9)     // Catch:{ all -> 0x025e }
            r11.append(r4)     // Catch:{ all -> 0x025e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x025e }
            java.lang.String r10 = com.onesignal.C4698w1.m16344a((java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r6)     // Catch:{ all -> 0x025e }
            if (r10 == 0) goto L_0x00c9
            java.lang.String r11 = "if-none-match"
            r8.setRequestProperty(r11, r10)     // Catch:{ all -> 0x025e }
            com.onesignal.n1$a0 r11 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x025e }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x025e }
            r12.<init>()     // Catch:{ all -> 0x025e }
            java.lang.String r13 = "OneSignalRestClient: Adding header if-none-match: "
            r12.append(r13)     // Catch:{ all -> 0x025e }
            r12.append(r10)     // Catch:{ all -> 0x025e }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x025e }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r11, (java.lang.String) r10)     // Catch:{ all -> 0x025e }
        L_0x00c9:
            int r7 = r8.getResponseCode()     // Catch:{ all -> 0x025e }
            com.onesignal.n1$a0 r10 = com.onesignal.C4564n1.C4566a0.VERBOSE     // Catch:{ all -> 0x025a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x025a }
            r11.<init>()     // Catch:{ all -> 0x025a }
            java.lang.String r12 = "OneSignalRestClient: After con.getResponseCode to: https://api.onesignal.com/"
            r11.append(r12)     // Catch:{ all -> 0x025a }
            r11.append(r0)     // Catch:{ all -> 0x025a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x025a }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r10, (java.lang.String) r11)     // Catch:{ all -> 0x025a }
            r10 = 200(0xc8, float:2.8E-43)
            java.lang.String r11 = " RECEIVED JSON: "
            java.lang.String r12 = ""
            java.lang.String r13 = "GET"
            java.lang.String r14 = "\\A"
            java.lang.String r15 = "PREFS_OS_HTTP_CACHE_PREFIX_"
            if (r7 == r10) goto L_0x01af
            r10 = 202(0xca, float:2.83E-43)
            if (r7 == r10) goto L_0x01af
            r9 = 304(0x130, float:4.26E-43)
            if (r7 == r9) goto L_0x0174
            com.onesignal.n1$a0 r4 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x025e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x025e }
            r9.<init>()     // Catch:{ all -> 0x025e }
            java.lang.String r10 = "OneSignalRestClient: Failed request to: https://api.onesignal.com/"
            r9.append(r10)     // Catch:{ all -> 0x025e }
            r9.append(r0)     // Catch:{ all -> 0x025e }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x025e }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r4, (java.lang.String) r0)     // Catch:{ all -> 0x025e }
            java.io.InputStream r0 = r8.getErrorStream()     // Catch:{ all -> 0x025e }
            if (r0 != 0) goto L_0x0119
            java.io.InputStream r0 = r8.getInputStream()     // Catch:{ all -> 0x025e }
        L_0x0119:
            if (r0 == 0) goto L_0x014c
            java.util.Scanner r4 = new java.util.Scanner     // Catch:{ all -> 0x025e }
            r4.<init>(r0, r3)     // Catch:{ all -> 0x025e }
            java.util.Scanner r0 = r4.useDelimiter(r14)     // Catch:{ all -> 0x025e }
            boolean r0 = r0.hasNext()     // Catch:{ all -> 0x025e }
            if (r0 == 0) goto L_0x012e
            java.lang.String r12 = r4.next()     // Catch:{ all -> 0x025e }
        L_0x012e:
            r4.close()     // Catch:{ all -> 0x025e }
            com.onesignal.n1$a0 r0 = com.onesignal.C4564n1.C4566a0.WARN     // Catch:{ all -> 0x025e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x025e }
            r3.<init>()     // Catch:{ all -> 0x025e }
            r3.append(r5)     // Catch:{ all -> 0x025e }
            r3.append(r1)     // Catch:{ all -> 0x025e }
            r3.append(r11)     // Catch:{ all -> 0x025e }
            r3.append(r12)     // Catch:{ all -> 0x025e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x025e }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r0, (java.lang.String) r3)     // Catch:{ all -> 0x025e }
            goto L_0x016e
        L_0x014c:
            com.onesignal.n1$a0 r0 = com.onesignal.C4564n1.C4566a0.WARN     // Catch:{ all -> 0x025e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x025e }
            r3.<init>()     // Catch:{ all -> 0x025e }
            r3.append(r5)     // Catch:{ all -> 0x025e }
            r3.append(r1)     // Catch:{ all -> 0x025e }
            java.lang.String r4 = " HTTP Code: "
            r3.append(r4)     // Catch:{ all -> 0x025e }
            r3.append(r7)     // Catch:{ all -> 0x025e }
            java.lang.String r4 = " No response body!"
            r3.append(r4)     // Catch:{ all -> 0x025e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x025e }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r0, (java.lang.String) r3)     // Catch:{ all -> 0x025e }
            r12 = r6
        L_0x016e:
            java.lang.Thread r0 = m16441a(r2, r7, r12, r6)     // Catch:{ all -> 0x025e }
            goto L_0x0250
        L_0x0174:
            java.lang.String r0 = com.onesignal.C4698w1.f12761a     // Catch:{ all -> 0x025e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x025e }
            r3.<init>()     // Catch:{ all -> 0x025e }
            r3.append(r15)     // Catch:{ all -> 0x025e }
            r3.append(r4)     // Catch:{ all -> 0x025e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x025e }
            java.lang.String r0 = com.onesignal.C4698w1.m16344a((java.lang.String) r0, (java.lang.String) r3, (java.lang.String) r6)     // Catch:{ all -> 0x025e }
            com.onesignal.n1$a0 r3 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x025e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x025e }
            r4.<init>()     // Catch:{ all -> 0x025e }
            r4.append(r5)     // Catch:{ all -> 0x025e }
            if (r1 != 0) goto L_0x0196
            goto L_0x0197
        L_0x0196:
            r13 = r1
        L_0x0197:
            r4.append(r13)     // Catch:{ all -> 0x025e }
            java.lang.String r9 = " - Using Cached response due to 304: "
            r4.append(r9)     // Catch:{ all -> 0x025e }
            r4.append(r0)     // Catch:{ all -> 0x025e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x025e }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r3, (java.lang.String) r4)     // Catch:{ all -> 0x025e }
            java.lang.Thread r0 = m16442a(r2, r0)     // Catch:{ all -> 0x025e }
            goto L_0x0250
        L_0x01af:
            com.onesignal.n1$a0 r10 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x025a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x025a }
            r6.<init>()     // Catch:{ all -> 0x025a }
            r18 = r7
            java.lang.String r7 = "OneSignalRestClient: Successfully finished request to: https://api.onesignal.com/"
            r6.append(r7)     // Catch:{ all -> 0x0256 }
            r6.append(r0)     // Catch:{ all -> 0x0256 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0256 }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r10, (java.lang.String) r0)     // Catch:{ all -> 0x0256 }
            java.io.InputStream r0 = r8.getInputStream()     // Catch:{ all -> 0x0256 }
            java.util.Scanner r6 = new java.util.Scanner     // Catch:{ all -> 0x0256 }
            r6.<init>(r0, r3)     // Catch:{ all -> 0x0256 }
            java.util.Scanner r0 = r6.useDelimiter(r14)     // Catch:{ all -> 0x0256 }
            boolean r0 = r0.hasNext()     // Catch:{ all -> 0x0256 }
            if (r0 == 0) goto L_0x01de
            java.lang.String r12 = r6.next()     // Catch:{ all -> 0x0256 }
        L_0x01de:
            r6.close()     // Catch:{ all -> 0x0256 }
            com.onesignal.n1$a0 r0 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x0256 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0256 }
            r3.<init>()     // Catch:{ all -> 0x0256 }
            r3.append(r5)     // Catch:{ all -> 0x0256 }
            if (r1 != 0) goto L_0x01ee
            goto L_0x01ef
        L_0x01ee:
            r13 = r1
        L_0x01ef:
            r3.append(r13)     // Catch:{ all -> 0x0256 }
            r3.append(r11)     // Catch:{ all -> 0x0256 }
            r3.append(r12)     // Catch:{ all -> 0x0256 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0256 }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r0, (java.lang.String) r3)     // Catch:{ all -> 0x0256 }
            if (r4 == 0) goto L_0x024c
            java.lang.String r0 = "etag"
            java.lang.String r0 = r8.getHeaderField(r0)     // Catch:{ all -> 0x0256 }
            if (r0 == 0) goto L_0x024c
            com.onesignal.n1$a0 r3 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x0256 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0256 }
            r6.<init>()     // Catch:{ all -> 0x0256 }
            java.lang.String r7 = "OneSignalRestClient: Response has etag of "
            r6.append(r7)     // Catch:{ all -> 0x0256 }
            r6.append(r0)     // Catch:{ all -> 0x0256 }
            java.lang.String r7 = " so caching the response."
            r6.append(r7)     // Catch:{ all -> 0x0256 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0256 }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r3, (java.lang.String) r6)     // Catch:{ all -> 0x0256 }
            java.lang.String r3 = com.onesignal.C4698w1.f12761a     // Catch:{ all -> 0x0256 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0256 }
            r6.<init>()     // Catch:{ all -> 0x0256 }
            r6.append(r9)     // Catch:{ all -> 0x0256 }
            r6.append(r4)     // Catch:{ all -> 0x0256 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0256 }
            com.onesignal.C4698w1.m16353b((java.lang.String) r3, (java.lang.String) r6, (java.lang.String) r0)     // Catch:{ all -> 0x0256 }
            java.lang.String r0 = com.onesignal.C4698w1.f12761a     // Catch:{ all -> 0x0256 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0256 }
            r3.<init>()     // Catch:{ all -> 0x0256 }
            r3.append(r15)     // Catch:{ all -> 0x0256 }
            r3.append(r4)     // Catch:{ all -> 0x0256 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0256 }
            com.onesignal.C4698w1.m16353b((java.lang.String) r0, (java.lang.String) r3, (java.lang.String) r12)     // Catch:{ all -> 0x0256 }
        L_0x024c:
            java.lang.Thread r0 = m16442a(r2, r12)     // Catch:{ all -> 0x0256 }
        L_0x0250:
            if (r8 == 0) goto L_0x02ab
        L_0x0252:
            r8.disconnect()
            goto L_0x02ab
        L_0x0256:
            r0 = move-exception
            r7 = r18
            goto L_0x0262
        L_0x025a:
            r0 = move-exception
            r18 = r7
            goto L_0x0262
        L_0x025e:
            r0 = move-exception
            goto L_0x0262
        L_0x0260:
            r0 = move-exception
            r8 = 0
        L_0x0262:
            boolean r3 = r0 instanceof java.net.ConnectException     // Catch:{ all -> 0x02ac }
            if (r3 != 0) goto L_0x0285
            boolean r3 = r0 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x02ac }
            if (r3 == 0) goto L_0x026b
            goto L_0x0285
        L_0x026b:
            com.onesignal.n1$a0 r3 = com.onesignal.C4564n1.C4566a0.WARN     // Catch:{ all -> 0x02ac }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ac }
            r4.<init>()     // Catch:{ all -> 0x02ac }
            r4.append(r5)     // Catch:{ all -> 0x02ac }
            r4.append(r1)     // Catch:{ all -> 0x02ac }
            java.lang.String r1 = " Error thrown from network stack. "
            r4.append(r1)     // Catch:{ all -> 0x02ac }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x02ac }
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r3, (java.lang.String) r1, (java.lang.Throwable) r0)     // Catch:{ all -> 0x02ac }
            goto L_0x02a3
        L_0x0285:
            com.onesignal.n1$a0 r1 = com.onesignal.C4564n1.C4566a0.INFO     // Catch:{ all -> 0x02ac }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ac }
            r3.<init>()     // Catch:{ all -> 0x02ac }
            java.lang.String r4 = "OneSignalRestClient: Could not send last request, device is offline. Throwable: "
            r3.append(r4)     // Catch:{ all -> 0x02ac }
            java.lang.Class r4 = r0.getClass()     // Catch:{ all -> 0x02ac }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x02ac }
            r3.append(r4)     // Catch:{ all -> 0x02ac }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02ac }
            com.onesignal.C4564n1.m15789a((com.onesignal.C4564n1.C4566a0) r1, (java.lang.String) r3)     // Catch:{ all -> 0x02ac }
        L_0x02a3:
            r1 = 0
            java.lang.Thread r0 = m16441a(r2, r7, r1, r0)     // Catch:{ all -> 0x02ac }
            if (r8 == 0) goto L_0x02ab
            goto L_0x0252
        L_0x02ab:
            return r0
        L_0x02ac:
            r0 = move-exception
            if (r8 == 0) goto L_0x02b2
            r8.disconnect()
        L_0x02b2:
            goto L_0x02b4
        L_0x02b3:
            throw r0
        L_0x02b4:
            goto L_0x02b3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4731y1.m16452d(java.lang.String, java.lang.String, org.json.JSONObject, com.onesignal.y1$g, int, java.lang.String):java.lang.Thread");
    }

    /* renamed from: b */
    public static void m16449b(String str, JSONObject jSONObject, C4738g gVar) {
        m16450c(str, "POST", jSONObject, gVar, 120000, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m16450c(String str, String str2, JSONObject jSONObject, C4738g gVar, int i, String str3) {
        if (str2 == null || !C4564n1.m15854h((String) null)) {
            Thread[] threadArr = new Thread[1];
            Thread thread = new Thread(new C4735d(threadArr, str, str2, jSONObject, gVar, i, str3), "OS_HTTPConnection");
            thread.start();
            try {
                thread.join((long) m16440a(i));
                if (thread.getState() != Thread.State.TERMINATED) {
                    thread.interrupt();
                }
                if (threadArr[0] != null) {
                    threadArr[0].join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m16444a(String str, C4738g gVar, String str2) {
        new Thread(new C4734c(str, gVar, str2), "OS_REST_ASYNC_GET").start();
    }

    /* renamed from: a */
    private static Thread m16442a(C4738g gVar, String str) {
        if (gVar == null) {
            return null;
        }
        Thread thread = new Thread(new C4736e(gVar, str), "OS_REST_SUCCESS_CALLBACK");
        thread.start();
        return thread;
    }

    /* renamed from: a */
    private static Thread m16441a(C4738g gVar, int i, String str, Throwable th) {
        if (gVar == null) {
            return null;
        }
        Thread thread = new Thread(new C4737f(gVar, i, str, th), "OS_REST_FAILURE_CALLBACK");
        thread.start();
        return thread;
    }

    /* renamed from: a */
    private static HttpURLConnection m16443a(String str) throws IOException {
        return (HttpURLConnection) new URL("https://api.onesignal.com/" + str).openConnection();
    }
}
