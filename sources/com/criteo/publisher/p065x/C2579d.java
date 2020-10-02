package com.criteo.publisher.p065x;

import android.util.Log;
import com.criteo.publisher.model.C2451l;
import com.criteo.publisher.model.C2454o;
import com.criteo.publisher.p054a0.C2327g;
import com.criteo.publisher.p054a0.C2330h;
import com.criteo.publisher.p054a0.C2339n;
import com.criteo.publisher.p054a0.C2344s;
import com.criteo.publisher.p054a0.C2345t;
import com.criteo.publisher.p061t.C2551t;
import com.criteo.publisher.p066y.p067b.C2584c;
import com.loopj.android.http.C4250c;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.criteo.publisher.x.d */
public class C2579d {

    /* renamed from: c */
    private static final String f8144c = "d";

    /* renamed from: a */
    private final C2330h f8145a;

    /* renamed from: b */
    private final C2339n f8146b;

    public C2579d(C2330h hVar, C2339n nVar) {
        this.f8145a = hVar;
        this.f8146b = nVar;
    }

    /* renamed from: b */
    private InputStream m9674b(URL url, String str) throws IOException {
        return m9666a(m9668a(url, str, "GET"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        if (r4 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        r0 = move-exception;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.criteo.publisher.model.C2464v mo10623a(com.criteo.publisher.model.C2462t r4) throws java.io.IOException {
        /*
            r3 = this;
            java.net.URL r0 = new java.net.URL
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.criteo.publisher.a0.h r2 = r3.f8145a
            java.lang.String r2 = r2.mo10130c()
            r1.append(r2)
            java.lang.String r2 = "/config/app"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r1 = 0
            java.lang.String r2 = "POST"
            java.net.HttpURLConnection r0 = r3.m9668a((java.net.URL) r0, (java.lang.String) r1, (java.lang.String) r2)
            r3.m9672a((java.net.HttpURLConnection) r0, (java.lang.Object) r4)
            java.io.InputStream r4 = m9666a((java.net.HttpURLConnection) r0)
            com.criteo.publisher.a0.n r0 = r3.f8146b     // Catch:{ all -> 0x003a }
            java.lang.Class<com.criteo.publisher.model.v> r1 = com.criteo.publisher.model.C2464v.class
            java.lang.Object r0 = r0.mo10162a(r1, (java.io.InputStream) r4)     // Catch:{ all -> 0x003a }
            com.criteo.publisher.model.v r0 = (com.criteo.publisher.model.C2464v) r0     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0039
            r4.close()
        L_0x0039:
            return r0
        L_0x003a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            if (r4 == 0) goto L_0x0042
            r4.close()     // Catch:{ all -> 0x0042 }
        L_0x0042:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p065x.C2579d.mo10623a(com.criteo.publisher.model.t):com.criteo.publisher.model.v");
    }

    /* renamed from: a */
    public C2454o mo10622a(C2451l lVar, String str) throws Exception {
        return C2454o.m9272a(m9671a(new URL(this.f8145a.mo10130c() + "/inapp/v2"), lVar.mo10372b(), str));
    }

    /* renamed from: a */
    public JSONObject mo10626a(int i, String str, String str2, String str3, int i2, String str4, C2584c cVar) {
        String a;
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        if (str2 != null) {
            hashMap.put("gaid", str2);
        }
        hashMap.put("eventType", str3);
        hashMap.put("limitedAdTracking", String.valueOf(i2));
        if (!(cVar == null || (a = mo10625a(cVar)) == null || a.isEmpty())) {
            hashMap.put("gdprString", a);
        }
        try {
            return m9670a(new URL(this.f8145a.mo10134g() + "/appevent/v1/" + i + "?" + m9667a((Map<String, String>) hashMap)), str4);
        } catch (IOException | JSONException e) {
            "Unable to process request to post app event:" + e.getMessage();
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10625a(C2584c cVar) {
        String str;
        try {
            str = cVar.mo10644c().toString();
        } catch (JSONException e) {
            "Unable to convert gdprString to JSONObject when sending to GUM:" + e.getMessage();
            str = null;
        }
        if (str == null) {
            return null;
        }
        try {
            return C2327g.m8957b(str.getBytes(C4250c.DEFAULT_CHARSET), 2);
        } catch (UnsupportedEncodingException e2) {
            "Unable to encode gdprString to base64:" + e2.getMessage();
            return null;
        }
    }

    /* renamed from: a */
    public InputStream mo10624a(URL url) throws IOException {
        return m9674b(url, (String) null);
    }

    /* renamed from: a */
    public void mo10627a(C2551t tVar) throws IOException {
        HttpURLConnection a = m9668a(new URL(this.f8145a.mo10130c() + "/csm"), (String) null, "POST");
        m9672a(a, (Object) tVar);
        m9666a(a).close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r2 != null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        r3 = move-exception;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject m9671a(java.net.URL r2, org.json.JSONObject r3, java.lang.String r4) throws java.io.IOException, org.json.JSONException {
        /*
            r1 = this;
            java.lang.String r0 = "POST"
            java.net.HttpURLConnection r2 = r1.m9668a((java.net.URL) r2, (java.lang.String) r4, (java.lang.String) r0)
            m9673a((java.net.HttpURLConnection) r2, (org.json.JSONObject) r3)
            java.io.InputStream r2 = m9666a((java.net.HttpURLConnection) r2)
            org.json.JSONObject r3 = m9669a((java.io.InputStream) r2)     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x0016
            r2.close()
        L_0x0016:
            return r3
        L_0x0017:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r3 = move-exception
            if (r2 == 0) goto L_0x001f
            r2.close()     // Catch:{ all -> 0x001f }
        L_0x001f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p065x.C2579d.m9671a(java.net.URL, org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        if (r1 != null) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r2 = move-exception;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject m9670a(java.net.URL r1, java.lang.String r2) throws java.io.IOException, org.json.JSONException {
        /*
            r0 = this;
            java.io.InputStream r1 = r0.m9674b(r1, r2)
            org.json.JSONObject r2 = m9669a((java.io.InputStream) r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000d
            r1.close()
        L_0x000d:
            return r2
        L_0x000e:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r2 = move-exception
            if (r1 == 0) goto L_0x0016
            r1.close()     // Catch:{ all -> 0x0016 }
        L_0x0016:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p065x.C2579d.m9670a(java.net.URL, java.lang.String):org.json.JSONObject");
    }

    /* renamed from: a */
    private HttpURLConnection m9668a(URL url, String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setReadTimeout(this.f8145a.mo10138k());
        httpURLConnection.setConnectTimeout(this.f8145a.mo10138k());
        httpURLConnection.setRequestProperty("Content-Type", "text/plain");
        if (!C2345t.m9006a((CharSequence) str)) {
            httpURLConnection.setRequestProperty(C6078a.HEADER_USER_AGENT, str);
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private static InputStream m9666a(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200 || responseCode == 204) {
            return httpURLConnection.getInputStream();
        }
        throw new C2578c(responseCode);
    }

    /* renamed from: a */
    private static JSONObject m9669a(InputStream inputStream) throws IOException, JSONException {
        String a = C2344s.m9004a(inputStream);
        if (!C2345t.m9006a((CharSequence) a)) {
            return new JSONObject(a);
        }
        return new JSONObject();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r1 != null) goto L_0x0027;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m9673a(java.net.HttpURLConnection r1, org.json.JSONObject r2) throws java.io.IOException {
        /*
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = "UTF-8"
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
            byte[] r2 = r2.getBytes(r0)
            r0 = 1
            r1.setDoOutput(r0)
            java.io.OutputStream r1 = r1.getOutputStream()
            r1.write(r2)     // Catch:{ all -> 0x0022 }
            r1.flush()     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0021
            r1.close()
        L_0x0021:
            return
        L_0x0022:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r2 = move-exception
            if (r1 == 0) goto L_0x002a
            r1.close()     // Catch:{ all -> 0x002a }
        L_0x002a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p065x.C2579d.m9673a(java.net.HttpURLConnection, org.json.JSONObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        if (r2 != null) goto L_0x0018;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9672a(java.net.HttpURLConnection r2, java.lang.Object r3) throws java.io.IOException {
        /*
            r1 = this;
            r0 = 1
            r2.setDoOutput(r0)
            java.io.OutputStream r2 = r2.getOutputStream()
            com.criteo.publisher.a0.n r0 = r1.f8146b     // Catch:{ all -> 0x0013 }
            r0.mo10163a((java.lang.Object) r3, (java.io.OutputStream) r2)     // Catch:{ all -> 0x0013 }
            if (r2 == 0) goto L_0x0012
            r2.close()
        L_0x0012:
            return
        L_0x0013:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0015 }
        L_0x0015:
            r3 = move-exception
            if (r2 == 0) goto L_0x001b
            r2.close()     // Catch:{ all -> 0x001b }
        L_0x001b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p065x.C2579d.m9672a(java.net.HttpURLConnection, java.lang.Object):void");
    }

    /* renamed from: a */
    private static String m9667a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey(), Charset.forName(C4250c.DEFAULT_CHARSET).name()));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), Charset.forName(C4250c.DEFAULT_CHARSET).name()));
                sb.append("&");
            }
        } catch (Exception e) {
            Log.e(f8144c, e.getMessage());
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }
}
