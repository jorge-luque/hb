package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.C1439u;
import com.applovin.sdk.AppLovinEventTypes;
import com.loopj.android.http.C4250c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.adcolony.sdk.l */
class C1362l implements Runnable {

    /* renamed from: a */
    private HttpURLConnection f4265a;

    /* renamed from: b */
    private InputStream f4266b;

    /* renamed from: c */
    private C1454x f4267c;

    /* renamed from: d */
    private C1363a f4268d;

    /* renamed from: e */
    private final int f4269e = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: f */
    private final int f4270f = 299;

    /* renamed from: g */
    private String f4271g;

    /* renamed from: h */
    private int f4272h = 0;

    /* renamed from: i */
    private boolean f4273i = false;

    /* renamed from: j */
    private Map<String, List<String>> f4274j;

    /* renamed from: k */
    private String f4275k = "";

    /* renamed from: l */
    private String f4276l = "";

    /* renamed from: m */
    String f4277m = "";

    /* renamed from: n */
    String f4278n = "";

    /* renamed from: o */
    boolean f4279o;

    /* renamed from: p */
    int f4280p;

    /* renamed from: q */
    int f4281q;

    /* renamed from: com.adcolony.sdk.l$a */
    interface C1363a {
        /* renamed from: a */
        void mo6527a(C1362l lVar, C1454x xVar, Map<String, List<String>> map);
    }

    C1362l(C1454x xVar, C1363a aVar) {
        this.f4267c = xVar;
        this.f4268d = aVar;
    }

    /* renamed from: a */
    private boolean m5342a() throws IOException {
        JSONObject b = this.f4267c.mo6830b();
        String h = C1437s.m5613h(b, "content_type");
        String h2 = C1437s.m5613h(b, AppLovinEventTypes.USER_VIEWED_CONTENT);
        boolean d = C1437s.m5608d(b, "no_redirect");
        this.f4277m = C1437s.m5613h(b, "url");
        this.f4275k = C1437s.m5613h(b, "filepath");
        StringBuilder sb = new StringBuilder();
        sb.append(C1199a.m4880c().mo6555v().mo6512d());
        String str = this.f4275k;
        sb.append(str.substring(str.lastIndexOf("/") + 1));
        this.f4276l = sb.toString();
        this.f4271g = C1437s.m5613h(b, "encoding");
        int a = C1437s.m5578a(b, "max_size", 0);
        this.f4272h = a;
        this.f4273i = a != 0;
        this.f4280p = 0;
        this.f4266b = null;
        this.f4265a = null;
        this.f4274j = null;
        if (!this.f4277m.startsWith("file://")) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4277m).openConnection();
            this.f4265a = httpURLConnection;
            httpURLConnection.setInstanceFollowRedirects(!d);
            this.f4265a.setRequestProperty("Accept-Charset", C4250c.DEFAULT_CHARSET);
            String G = C1199a.m4880c().mo6542h().mo6607G();
            if (G != null && !G.equals("")) {
                this.f4265a.setRequestProperty(C6078a.HEADER_USER_AGENT, G);
            }
            if (!h.equals("")) {
                this.f4265a.setRequestProperty("Content-Type", h);
            }
            if (this.f4267c.mo6833c().equals("WebServices.post")) {
                this.f4265a.setDoOutput(true);
                this.f4265a.setFixedLengthStreamingMode(h2.getBytes(StandardCharsets.UTF_8).length);
                new PrintStream(this.f4265a.getOutputStream()).print(h2);
            }
        } else if (this.f4277m.startsWith("file:///android_asset/")) {
            Context b2 = C1199a.m4878b();
            if (b2 != null) {
                this.f4266b = b2.getAssets().open(this.f4277m.substring(22));
            }
        } else {
            this.f4266b = new FileInputStream(this.f4277m.substring(7));
        }
        if (this.f4265a == null && this.f4266b == null) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m5344c() throws Exception {
        OutputStream outputStream;
        String c = this.f4267c.mo6833c();
        if (this.f4266b != null) {
            outputStream = this.f4275k.length() == 0 ? new ByteArrayOutputStream(CodedOutputStream.DEFAULT_BUFFER_SIZE) : new FileOutputStream(new File(this.f4275k).getAbsolutePath());
        } else if (c.equals("WebServices.download")) {
            this.f4266b = this.f4265a.getInputStream();
            outputStream = new FileOutputStream(this.f4276l);
        } else if (c.equals("WebServices.get")) {
            this.f4266b = this.f4265a.getInputStream();
            outputStream = new ByteArrayOutputStream(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        } else if (c.equals("WebServices.post")) {
            this.f4265a.connect();
            this.f4266b = (this.f4265a.getResponseCode() < 200 || this.f4265a.getResponseCode() > 299) ? this.f4265a.getErrorStream() : this.f4265a.getInputStream();
            outputStream = new ByteArrayOutputStream(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        } else {
            outputStream = null;
        }
        HttpURLConnection httpURLConnection = this.f4265a;
        if (httpURLConnection != null) {
            this.f4281q = httpURLConnection.getResponseCode();
            this.f4274j = this.f4265a.getHeaderFields();
        }
        return m5343a(this.f4266b, outputStream);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1454x mo6677b() {
        return this.f4267c;
    }

    public void run() {
        boolean z = false;
        this.f4279o = false;
        try {
            if (m5342a()) {
                this.f4279o = m5344c();
                if (this.f4267c.mo6833c().equals("WebServices.post") && this.f4281q != 200) {
                    this.f4279o = false;
                }
            }
        } catch (MalformedURLException e) {
            new C1439u.C1440a().mo6801a("MalformedURLException: ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
            this.f4279o = true;
        } catch (OutOfMemoryError unused) {
            C1439u.C1440a a = new C1439u.C1440a().mo6801a("Out of memory error - disabling AdColony. (").mo6799a(this.f4280p).mo6801a("/").mo6799a(this.f4272h);
            a.mo6801a("): " + this.f4277m).mo6803a(C1439u.f4516i);
            C1199a.m4880c().mo6533b(true);
        } catch (IOException e2) {
            new C1439u.C1440a().mo6801a("Download of ").mo6801a(this.f4277m).mo6801a(" failed: ").mo6801a(e2.toString()).mo6803a(C1439u.f4515h);
            int i = this.f4281q;
            if (i == 0) {
                i = 504;
            }
            this.f4281q = i;
        } catch (IllegalStateException e3) {
            new C1439u.C1440a().mo6801a("okhttp error: ").mo6801a(e3.toString()).mo6803a(C1439u.f4516i);
            e3.printStackTrace();
        } catch (Exception e4) {
            new C1439u.C1440a().mo6801a("Exception: ").mo6801a(e4.toString()).mo6803a(C1439u.f4516i);
            e4.printStackTrace();
        }
        z = true;
        if (z) {
            if (this.f4267c.mo6833c().equals("WebServices.download")) {
                m5341a(this.f4276l, this.f4275k);
            }
            this.f4268d.mo6527a(this, this.f4267c, this.f4274j);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        if (r8.f4271g == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        if (r8.f4271g.isEmpty() != false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        r0 = r8.f4271g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        r0 = com.loopj.android.http.C4250c.DEFAULT_CHARSET;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        if ((r10 instanceof java.io.ByteArrayOutputStream) == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
        r8.f4278n = ((java.io.ByteArrayOutputStream) r10).toString(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        if (r10 == null) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        if (r9 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0085, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5343a(java.io.InputStream r9, java.io.OutputStream r10) throws java.lang.Exception {
        /*
            r8 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x008a, all -> 0x0088 }
            r1.<init>(r9)     // Catch:{ Exception -> 0x008a, all -> 0x0088 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r0]     // Catch:{ Exception -> 0x0086 }
        L_0x000a:
            r3 = 0
            int r4 = r1.read(r2, r3, r0)     // Catch:{ Exception -> 0x0086 }
            r5 = -1
            if (r4 == r5) goto L_0x0059
            int r5 = r8.f4280p     // Catch:{ Exception -> 0x0086 }
            int r5 = r5 + r4
            r8.f4280p = r5     // Catch:{ Exception -> 0x0086 }
            boolean r6 = r8.f4273i     // Catch:{ Exception -> 0x0086 }
            if (r6 == 0) goto L_0x0055
            int r6 = r8.f4272h     // Catch:{ Exception -> 0x0086 }
            if (r5 > r6) goto L_0x0020
            goto L_0x0055
        L_0x0020:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0086 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            r2.<init>()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r3 = "Data exceeds expected maximum ("
            r2.append(r3)     // Catch:{ Exception -> 0x0086 }
            int r3 = r8.f4280p     // Catch:{ Exception -> 0x0086 }
            r2.append(r3)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r3 = "/"
            r2.append(r3)     // Catch:{ Exception -> 0x0086 }
            int r3 = r8.f4272h     // Catch:{ Exception -> 0x0086 }
            r2.append(r3)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r3 = "): "
            r2.append(r3)     // Catch:{ Exception -> 0x0086 }
            java.net.HttpURLConnection r3 = r8.f4265a     // Catch:{ Exception -> 0x0086 }
            java.net.URL r3 = r3.getURL()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0086 }
            r2.append(r3)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0086 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0086 }
            throw r0     // Catch:{ Exception -> 0x0086 }
        L_0x0055:
            r10.write(r2, r3, r4)     // Catch:{ Exception -> 0x0086 }
            goto L_0x000a
        L_0x0059:
            java.lang.String r0 = r8.f4271g     // Catch:{ Exception -> 0x0086 }
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = r8.f4271g     // Catch:{ Exception -> 0x0086 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0086 }
            if (r0 != 0) goto L_0x0068
            java.lang.String r0 = r8.f4271g     // Catch:{ Exception -> 0x0086 }
            goto L_0x006a
        L_0x0068:
            java.lang.String r0 = "UTF-8"
        L_0x006a:
            boolean r2 = r10 instanceof java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0086 }
            if (r2 == 0) goto L_0x0077
            r2 = r10
            java.io.ByteArrayOutputStream r2 = (java.io.ByteArrayOutputStream) r2     // Catch:{ Exception -> 0x0086 }
            java.lang.String r0 = r2.toString(r0)     // Catch:{ Exception -> 0x0086 }
            r8.f4278n = r0     // Catch:{ Exception -> 0x0086 }
        L_0x0077:
            r0 = 1
            if (r10 == 0) goto L_0x007d
            r10.close()
        L_0x007d:
            if (r9 == 0) goto L_0x0082
            r9.close()
        L_0x0082:
            r1.close()
            return r0
        L_0x0086:
            r0 = move-exception
            goto L_0x008e
        L_0x0088:
            r1 = move-exception
            goto L_0x0093
        L_0x008a:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x008e:
            throw r0     // Catch:{ all -> 0x008f }
        L_0x008f:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x0093:
            if (r10 == 0) goto L_0x0098
            r10.close()
        L_0x0098:
            if (r9 == 0) goto L_0x009d
            r9.close()
        L_0x009d:
            if (r0 == 0) goto L_0x00a2
            r0.close()
        L_0x00a2:
            goto L_0x00a4
        L_0x00a3:
            throw r1
        L_0x00a4:
            goto L_0x00a3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1362l.m5343a(java.io.InputStream, java.io.OutputStream):boolean");
    }

    /* renamed from: a */
    private void m5341a(String str, String str2) {
        try {
            String substring = str2.substring(0, str2.lastIndexOf("/") + 1);
            if (!str2.equals("") && !substring.equals(C1199a.m4880c().mo6555v().mo6512d()) && !new File(str).renameTo(new File(str2))) {
                new C1439u.C1440a().mo6801a("Moving of ").mo6801a(str).mo6801a(" failed.").mo6803a(C1439u.f4515h);
            }
        } catch (Exception e) {
            new C1439u.C1440a().mo6801a("Exception: ").mo6801a(e.toString()).mo6803a(C1439u.f4516i);
            e.printStackTrace();
        }
    }
}
