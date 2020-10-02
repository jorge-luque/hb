package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.C3845f;
import com.google.firebase.remoteconfig.internal.C3852k;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class ConfigFetchHttpClient {

    /* renamed from: h */
    private static final Pattern f10598h = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* renamed from: a */
    private final Context f10599a;

    /* renamed from: b */
    private final String f10600b;

    /* renamed from: c */
    private final String f10601c;

    /* renamed from: d */
    private final String f10602d;

    /* renamed from: e */
    private final String f10603e;

    /* renamed from: f */
    private final long f10604f;

    /* renamed from: g */
    private final long f10605g;

    public ConfigFetchHttpClient(Context context, String str, String str2, String str3, long j, long j2) {
        this.f10599a = context;
        this.f10600b = str;
        this.f10601c = str2;
        this.f10602d = m12974a(str);
        this.f10603e = str3;
        this.f10604f = j;
        this.f10605g = j2;
    }

    /* renamed from: a */
    private static String m12974a(String str) {
        Matcher matcher = f10598h.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    /* renamed from: b */
    private String m12983b() {
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(this.f10599a, this.f10599a.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e("FirebaseRemoteConfig", "Could not get fingerprint hash for package: " + this.f10599a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("FirebaseRemoteConfig", "No such package: " + this.f10599a.getPackageName(), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @Keep
    public C3852k.C3853a fetch(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map, String str3, Map<String, String> map2, Date date) throws FirebaseRemoteConfigException {
        m12979a(httpURLConnection, str3, map2);
        try {
            m12981a(httpURLConnection, m12976a(str, str2, map).toString().getBytes("utf-8"));
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String headerField = httpURLConnection.getHeaderField("ETag");
                JSONObject a = m12977a((URLConnection) httpURLConnection);
                httpURLConnection.disconnect();
                try {
                    httpURLConnection.getInputStream().close();
                } catch (IOException unused) {
                }
                if (!m12982a(a)) {
                    return C3852k.C3853a.m13037a(date);
                }
                return C3852k.C3853a.m13036a(m12973a(a, date), headerField);
            }
            throw new FirebaseRemoteConfigServerException(responseCode, httpURLConnection.getResponseMessage());
        } catch (IOException | JSONException e) {
            throw new FirebaseRemoteConfigClientException("The client had an error while calling the backend!", e);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo27556a() throws FirebaseRemoteConfigException {
        try {
            return (HttpURLConnection) new URL(m12975a(this.f10602d, this.f10603e)).openConnection();
        } catch (IOException e) {
            throw new FirebaseRemoteConfigException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m12979a(HttpURLConnection httpURLConnection, String str, Map<String, String> map) {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(this.f10604f));
        httpURLConnection.setReadTimeout((int) TimeUnit.SECONDS.toMillis(this.f10605g));
        httpURLConnection.setRequestProperty("If-None-Match", str);
        m12978a(httpURLConnection);
        m12980a(httpURLConnection, map);
    }

    /* renamed from: a */
    private String m12975a(String str, String str2) {
        return String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", new Object[]{str, str2});
    }

    /* renamed from: a */
    private void m12978a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.f10601c);
        httpURLConnection.setRequestProperty("X-Android-Package", this.f10599a.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", m12983b());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty("Content-Type", C6078a.ACCEPT_JSON_VALUE);
        httpURLConnection.setRequestProperty(C6078a.HEADER_ACCEPT, C6078a.ACCEPT_JSON_VALUE);
    }

    /* renamed from: a */
    private void m12980a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
    }

    /* renamed from: a */
    private JSONObject m12976a(String str, String str2, Map<String, String> map) throws FirebaseRemoteConfigClientException {
        String str3;
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("appInstanceId", str);
            hashMap.put("appInstanceIdToken", str2);
            hashMap.put("appId", this.f10600b);
            Locale locale = this.f10599a.getResources().getConfiguration().locale;
            hashMap.put("countryCode", locale.getCountry());
            if (Build.VERSION.SDK_INT >= 21) {
                str3 = locale.toLanguageTag();
            } else {
                str3 = locale.toString();
            }
            hashMap.put("languageCode", str3);
            hashMap.put("platformVersion", Integer.toString(Build.VERSION.SDK_INT));
            hashMap.put("timeZone", TimeZone.getDefault().getID());
            try {
                PackageInfo packageInfo = this.f10599a.getPackageManager().getPackageInfo(this.f10599a.getPackageName(), 0);
                if (packageInfo != null) {
                    hashMap.put("appVersion", packageInfo.versionName);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            hashMap.put("packageName", this.f10599a.getPackageName());
            hashMap.put("sdkVersion", "19.1.4");
            hashMap.put("analyticsUserProperties", new JSONObject(map));
            return new JSONObject(hashMap);
        }
        throw new FirebaseRemoteConfigClientException("Fetch failed: Firebase instance id is null.");
    }

    /* renamed from: a */
    private void m12981a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    /* renamed from: a */
    private JSONObject m12977a(URLConnection uRLConnection) throws IOException, JSONException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read();
            if (read == -1) {
                return new JSONObject(sb.toString());
            }
            sb.append((char) read);
        }
    }

    /* renamed from: a */
    private boolean m12982a(JSONObject jSONObject) {
        try {
            return !jSONObject.get("state").equals("NO_CHANGE");
        } catch (JSONException unused) {
            return true;
        }
    }

    /* renamed from: a */
    private static C3845f m12973a(JSONObject jSONObject, Date date) throws FirebaseRemoteConfigClientException {
        JSONObject jSONObject2;
        try {
            C3845f.C3847b e = C3845f.m13003e();
            e.mo27574a(date);
            JSONArray jSONArray = null;
            try {
                jSONObject2 = jSONObject.getJSONObject("entries");
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                e.mo27577a(jSONObject2);
            }
            try {
                jSONArray = jSONObject.getJSONArray("experimentDescriptions");
            } catch (JSONException unused2) {
            }
            if (jSONArray != null) {
                e.mo27576a(jSONArray);
            }
            return e.mo27578a();
        } catch (JSONException e2) {
            throw new FirebaseRemoteConfigClientException("Fetch failed: fetch response could not be parsed.", e2);
        }
    }
}
