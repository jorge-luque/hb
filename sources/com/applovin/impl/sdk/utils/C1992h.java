package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1842d;
import com.applovin.impl.sdk.p050b.C1843e;
import com.loopj.android.http.C4250c;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.h */
public class C1992h {

    /* renamed from: a */
    private static final int[] f6650a = {7, 4, 2, 1, 11};

    /* renamed from: b */
    private static final int[] f6651b = {5, 6, 10, 3, 9, 8, 14};

    /* renamed from: c */
    private static final int[] f6652c = {15, 12, 13};

    /* renamed from: a */
    public static String m7845a(InputStream inputStream, C1941j jVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) jVar.mo8549a(C1841c.f6006dw)).intValue()];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toString(C4250c.DEFAULT_CHARSET);
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static String m7846a(String str, C1941j jVar) {
        return m7847a((String) jVar.mo8549a(C1841c.f5811aK), str, jVar);
    }

    /* renamed from: a */
    public static String m7847a(String str, String str2, C1941j jVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (jVar != null) {
            return str + str2;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    public static JSONObject m7848a(JSONObject jSONObject) throws JSONException {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    /* renamed from: a */
    public static void m7849a(int i, C1941j jVar) {
        StringBuilder sb;
        String str;
        C1842d D = jVar.mo8526D();
        if (i == 401) {
            D.mo8304a((C1841c<?>) C1841c.f5792S, (Object) "");
            D.mo8304a((C1841c<?>) C1841c.f5793T, (Object) "");
            D.mo8307b();
            sb = new StringBuilder();
            sb.append("SDK key \"");
            sb.append(jVar.mo8599t());
            str = "\" is rejected by AppLovin. Please make sure the SDK key is correct.";
        } else if (i == 418) {
            D.mo8304a((C1841c<?>) C1841c.f5791R, (Object) true);
            D.mo8307b();
            sb = new StringBuilder();
            sb.append("SDK key \"");
            sb.append(jVar.mo8599t());
            str = "\" has been blocked. Please contact AppLovin support at support@applovin.com.";
        } else if ((i >= 400 && i < 500) || i == -1) {
            jVar.mo8586g();
            return;
        } else {
            return;
        }
        sb.append(str);
        C1977q.m7751i("AppLovinSdk", sb.toString());
    }

    /* renamed from: a */
    public static void m7850a(JSONObject jSONObject, boolean z, C1941j jVar) {
        jVar.mo8567ac().mo8508a(jSONObject, z);
    }

    /* renamed from: a */
    public static boolean m7851a() {
        return m7854a((String) null);
    }

    /* renamed from: a */
    private static boolean m7852a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7853a(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo b = m7855b(context);
        if (b != null) {
            return b.isConnected();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7854a(String str) {
        if (C1991g.m7842e()) {
            return (!C1991g.m7843f() || TextUtils.isEmpty(str)) ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        return true;
    }

    /* renamed from: b */
    private static NetworkInfo m7855b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: b */
    public static String m7856b(String str, C1941j jVar) {
        return m7847a((String) jVar.mo8549a(C1841c.f5812aL), str, jVar);
    }

    /* renamed from: c */
    public static void m7857c(JSONObject jSONObject, C1941j jVar) {
        String b = C1993i.m7896b(jSONObject, "persisted_data", (String) null, jVar);
        if (C2025o.m7963b(b)) {
            jVar.mo8556a(C1843e.f6111y, b);
            jVar.mo8602v().mo8744c("ConnectionUtils", "Updated persisted data");
        }
    }

    /* renamed from: d */
    public static void m7858d(JSONObject jSONObject, C1941j jVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (jVar != null) {
            try {
                if (jSONObject.has("settings")) {
                    C1842d D = jVar.mo8526D();
                    if (!jSONObject.isNull("settings")) {
                        D.mo8305a(jSONObject.getJSONObject("settings"));
                        D.mo8307b();
                    }
                }
            } catch (JSONException e) {
                jVar.mo8602v().mo8743b("ConnectionUtils", "Unable to parse settings out of API response", e);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: e */
    public static Map<String, String> m7859e(C1941j jVar) {
        String str;
        HashMap hashMap = new HashMap();
        String str2 = (String) jVar.mo8549a(C1841c.f5793T);
        if (C2025o.m7963b(str2)) {
            str = "device_token";
        } else {
            if (!((Boolean) jVar.mo8549a(C1841c.f6020eK)).booleanValue()) {
                str2 = jVar.mo8599t();
                str = TapjoyConstants.TJC_API_KEY;
            }
            hashMap.put("sc", C2025o.m7966e((String) jVar.mo8549a(C1841c.f5796W)));
            hashMap.put("sc2", C2025o.m7966e((String) jVar.mo8549a(C1841c.f5797X)));
            hashMap.put("sc3", C2025o.m7966e((String) jVar.mo8549a(C1841c.f5798Y)));
            hashMap.put("server_installed_at", C2025o.m7966e((String) jVar.mo8549a(C1841c.f5799Z)));
            C2029r.m8011a("persisted_data", C2025o.m7966e((String) jVar.mo8550a(C1843e.f6111y)), (Map<String, String>) hashMap);
            return hashMap;
        }
        hashMap.put(str, str2);
        hashMap.put("sc", C2025o.m7966e((String) jVar.mo8549a(C1841c.f5796W)));
        hashMap.put("sc2", C2025o.m7966e((String) jVar.mo8549a(C1841c.f5797X)));
        hashMap.put("sc3", C2025o.m7966e((String) jVar.mo8549a(C1841c.f5798Y)));
        hashMap.put("server_installed_at", C2025o.m7966e((String) jVar.mo8549a(C1841c.f5799Z)));
        C2029r.m8011a("persisted_data", C2025o.m7966e((String) jVar.mo8550a(C1843e.f6111y)), (Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: e */
    public static void m7860e(JSONObject jSONObject, C1941j jVar) {
        JSONArray b = C1993i.m7900b(jSONObject, "zones", (JSONArray) null, jVar);
        if (b != null && b.length() > 0) {
            jVar.mo8544W().mo8191a(b);
        }
    }

    /* renamed from: f */
    public static String m7861f(C1941j jVar) {
        NetworkInfo b = m7855b(jVar.mo8527E());
        if (b == null) {
            return "unknown";
        }
        int type = b.getType();
        int subtype = b.getSubtype();
        return type == 1 ? TapjoyConstants.TJC_CONNECTION_TYPE_WIFI : type == 0 ? m7852a(subtype, f6650a) ? "2g" : m7852a(subtype, f6651b) ? "3g" : m7852a(subtype, f6652c) ? "4g" : TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE : "unknown";
    }

    /* renamed from: f */
    public static void m7862f(JSONObject jSONObject, C1941j jVar) {
        JSONArray b = C1993i.m7900b(jSONObject, "zones", (JSONArray) null, jVar);
        if (b != null) {
            Iterator it = jVar.mo8544W().mo8192b(b).iterator();
            while (it.hasNext()) {
                C1821d dVar = (C1821d) it.next();
                if (dVar.mo8178e()) {
                    jVar.mo8595p().preloadAds(dVar);
                } else {
                    jVar.mo8594o().preloadAds(dVar);
                }
            }
            jVar.mo8541T().mo8329a((LinkedHashSet) jVar.mo8544W().mo8187a());
            jVar.mo8542U().mo8329a((LinkedHashSet) jVar.mo8544W().mo8187a());
        }
    }

    /* renamed from: g */
    public static String m7863g(C1941j jVar) {
        return m7847a((String) jVar.mo8549a(C1841c.f5809aI), "4.0/ad", jVar);
    }

    /* renamed from: g */
    public static void m7864g(JSONObject jSONObject, C1941j jVar) {
        JSONObject b = C1993i.m7901b(jSONObject, "variables", (JSONObject) null, jVar);
        if (b != null) {
            jVar.mo8598s().updateVariables(b);
        }
    }

    /* renamed from: h */
    public static String m7865h(C1941j jVar) {
        return m7847a((String) jVar.mo8549a(C1841c.f5810aJ), "4.0/ad", jVar);
    }

    /* renamed from: i */
    public static String m7866i(C1941j jVar) {
        return m7847a((String) jVar.mo8549a(C1841c.f5815aO), "1.0/variable_config", jVar);
    }

    /* renamed from: j */
    public static String m7867j(C1941j jVar) {
        return m7847a((String) jVar.mo8549a(C1841c.f5816aP), "1.0/variable_config", jVar);
    }
}
