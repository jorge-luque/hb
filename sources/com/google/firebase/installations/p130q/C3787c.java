package com.google.firebase.installations.p130q;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.installations.p130q.C3788d;
import com.google.firebase.installations.p130q.C3791e;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p124e.C3666c;
import com.loopj.android.http.C4250c;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.google.firebase.installations.q.c */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
public class C3787c {

    /* renamed from: d */
    private static final Pattern f10485d = Pattern.compile("[0-9]+s");

    /* renamed from: e */
    private static final Charset f10486e = Charset.forName(C4250c.DEFAULT_CHARSET);

    /* renamed from: a */
    private final Context f10487a;

    /* renamed from: b */
    private final C3687h f10488b;

    /* renamed from: c */
    private final C3666c f10489c;

    public C3787c(Context context, C3687h hVar, C3666c cVar) {
        this.f10487a = context;
        this.f10488b = hVar;
        this.f10489c = cVar;
    }

    /* renamed from: b */
    private C3788d m12796b(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f10486e));
        C3791e.C3792a d = C3791e.m12817d();
        C3788d.C3789a f = C3788d.m12804f();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
                f.mo27460c(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                f.mo27457a(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                f.mo27459b(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals("token")) {
                        d.mo27469a(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        d.mo27467a(m12788a(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                f.mo27456a(d.mo27470a());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        f.mo27455a(C3788d.C3790b.OK);
        return f.mo27458a();
    }

    /* renamed from: c */
    private static void m12799c() {
        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    /* renamed from: d */
    private C3791e m12800d(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f10486e));
        C3791e.C3792a d = C3791e.m12817d();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("token")) {
                d.mo27469a(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                d.mo27467a(m12788a(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        d.mo27468a(C3791e.C3793b.OK);
        return d.mo27470a();
    }

    /* renamed from: e */
    private void m12801e(HttpURLConnection httpURLConnection) throws IOException {
        m12794a((URLConnection) httpURLConnection, m12795a(m12790a()));
    }

    /* renamed from: a */
    public C3788d mo27471a(String str, String str2, String str3, String str4, String str5) throws IOException {
        int i = 0;
        URL url = new URL(String.format("https://%s/%s/%s", new Object[]{"firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations", new Object[]{str3})}));
        while (i <= 1) {
            HttpURLConnection a = m12789a(url, str);
            try {
                a.setRequestMethod("POST");
                a.setDoOutput(true);
                if (str5 != null) {
                    a.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                }
                m12793a(a, str2, str4);
                int responseCode = a.getResponseCode();
                if (responseCode == 200) {
                    C3788d b = m12796b(a);
                    a.disconnect();
                    return b;
                }
                m12792a(a);
                if (responseCode != 429) {
                    if (responseCode < 500 || responseCode >= 600) {
                        m12799c();
                        C3788d.C3789a f = C3788d.m12804f();
                        f.mo27455a(C3788d.C3790b.BAD_CONFIG);
                        C3788d a2 = f.mo27458a();
                        a.disconnect();
                        return a2;
                    }
                }
                i++;
            } finally {
                a.disconnect();
            }
        }
        throw new IOException();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004f */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m12798c(java.net.HttpURLConnection r7) {
        /*
            java.io.InputStream r0 = r7.getErrorStream()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            java.nio.charset.Charset r4 = f10486e
            r3.<init>(r0, r4)
            r2.<init>(r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r0.<init>()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
        L_0x0019:
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            if (r3 == 0) goto L_0x0028
            r0.append(r3)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r3 = 10
            r0.append(r3)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            goto L_0x0019
        L_0x0028:
            java.lang.String r3 = "Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r5 = 0
            int r6 = r7.getResponseCode()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r4[r5] = r6     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r5 = 1
            java.lang.String r7 = r7.getResponseMessage()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r4[r5] = r7     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r7 = 2
            r4[r7] = r0     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            java.lang.String r7 = java.lang.String.format(r3, r4)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            return r7
        L_0x004a:
            r7 = move-exception
            r2.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            throw r7
        L_0x004f:
            r2.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.p130q.C3787c.m12798c(java.net.HttpURLConnection):java.lang.String");
    }

    /* renamed from: a */
    private void m12793a(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        m12794a((URLConnection) httpURLConnection, m12795a(m12791a(str, str2)));
    }

    /* renamed from: a */
    private static byte[] m12795a(JSONObject jSONObject) throws IOException {
        return jSONObject.toString().getBytes(C4250c.DEFAULT_CHARSET);
    }

    /* renamed from: a */
    private static void m12794a(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
            } finally {
                try {
                    gZIPOutputStream.close();
                    outputStream.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
    }

    /* renamed from: a */
    private static JSONObject m12791a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:16.3.0");
            return jSONObject;
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: b */
    private String m12797b() {
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(this.f10487a, this.f10487a.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.f10487a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ContentValues", "No such package: " + this.f10487a.getPackageName(), e);
            return null;
        }
    }

    /* renamed from: a */
    private static JSONObject m12790a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:16.3.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: a */
    public C3791e mo27472a(String str, String str2, String str3, String str4) throws IOException {
        int i = 0;
        URL url = new URL(String.format("https://%s/%s/%s", new Object[]{"firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations/%s/authTokens:generate", new Object[]{str3, str2})}));
        while (i <= 1) {
            HttpURLConnection a = m12789a(url, str);
            try {
                a.setRequestMethod("POST");
                a.addRequestProperty("Authorization", "FIS_v2 " + str4);
                m12801e(a);
                int responseCode = a.getResponseCode();
                if (responseCode == 200) {
                    C3791e d = m12800d(a);
                    a.disconnect();
                    return d;
                }
                m12792a(a);
                if (responseCode != 401) {
                    if (responseCode != 404) {
                        if (responseCode != 429) {
                            if (responseCode < 500 || responseCode >= 600) {
                                m12799c();
                                C3791e.C3792a d2 = C3791e.m12817d();
                                d2.mo27468a(C3791e.C3793b.BAD_CONFIG);
                                C3791e a2 = d2.mo27470a();
                                a.disconnect();
                                return a2;
                            }
                        }
                        i++;
                    }
                }
                C3791e.C3792a d3 = C3791e.m12817d();
                d3.mo27468a(C3791e.C3793b.AUTH_ERROR);
                C3791e a3 = d3.mo27470a();
                a.disconnect();
                return a3;
            } finally {
                a.disconnect();
            }
        }
        throw new IOException();
    }

    /* renamed from: a */
    private HttpURLConnection m12789a(URL url, String str) throws IOException {
        C3666c.C3667a a;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(C6078a.DEFAULT_TIMEOUT);
        httpURLConnection.setReadTimeout(C6078a.DEFAULT_TIMEOUT);
        httpURLConnection.addRequestProperty("Content-Type", C6078a.ACCEPT_JSON_VALUE);
        httpURLConnection.addRequestProperty(C6078a.HEADER_ACCEPT, C6078a.ACCEPT_JSON_VALUE);
        httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.addRequestProperty("X-Android-Package", this.f10487a.getPackageName());
        C3666c cVar = this.f10489c;
        if (!(cVar == null || this.f10488b == null || (a = cVar.mo27265a("fire-installations-id")) == C3666c.C3667a.NONE)) {
            httpURLConnection.addRequestProperty("x-firebase-client", this.f10488b.mo27287a());
            httpURLConnection.addRequestProperty("x-firebase-client-log-type", Integer.toString(a.mo27266a()));
        }
        httpURLConnection.addRequestProperty("X-Android-Cert", m12797b());
        httpURLConnection.addRequestProperty("x-goog-api-key", str);
        return httpURLConnection;
    }

    @VisibleForTesting
    /* renamed from: a */
    static long m12788a(String str) {
        Preconditions.checkArgument(f10485d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    /* renamed from: a */
    private static void m12792a(HttpURLConnection httpURLConnection) {
        String c = m12798c(httpURLConnection);
        if (!TextUtils.isEmpty(c)) {
            Log.w("Firebase-Installations", c);
        }
    }
}
