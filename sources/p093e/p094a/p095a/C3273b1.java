package p093e.p094a.p095a;

import android.net.Uri;
import com.facebook.GraphRequest;
import com.loopj.android.http.C4250c;
import com.tapjoy.TapjoyConstants;
import com.vungle.warren.model.Cookie;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: e.a.a.b1 */
/* compiled from: UtilNetworking */
public class C3273b1 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f9104a;

    /* renamed from: e.a.a.b1$a */
    /* compiled from: UtilNetworking */
    static class C3274a implements C3275b {
        C3274a() {
        }

        /* renamed from: a */
        public void mo18953a(HttpsURLConnection httpsURLConnection, String str) {
            httpsURLConnection.setRequestProperty("Client-SDK", str);
            httpsURLConnection.setConnectTimeout(60000);
            httpsURLConnection.setReadTimeout(60000);
            if (C3273b1.f9104a != null) {
                httpsURLConnection.setRequestProperty(C6078a.HEADER_USER_AGENT, C3273b1.f9104a);
            }
        }
    }

    /* renamed from: e.a.a.b1$b */
    /* compiled from: UtilNetworking */
    public interface C3275b {
        /* renamed from: a */
        void mo18953a(HttpsURLConnection httpsURLConnection, String str);
    }

    /* renamed from: b */
    private static C3364y m10881b() {
        return C3309k.m11002d();
    }

    /* renamed from: c */
    private static String m10883c(Map<String, String> map) {
        return map.remove("secret_id");
    }

    /* renamed from: d */
    private static String m10884d(Map<String, String> map) {
        if (map.get("gps_adid") != null) {
            return "gps_adid";
        }
        if (map.get("fire_adid") != null) {
            return "fire_adid";
        }
        if (map.get(TapjoyConstants.TJC_ANDROID_ID) != null) {
            return TapjoyConstants.TJC_ANDROID_ID;
        }
        if (map.get("mac_sha1") != null) {
            return "mac_sha1";
        }
        if (map.get("mac_md5") != null) {
            return "mac_md5";
        }
        if (map.get("android_uuid") != null) {
            return "android_uuid";
        }
        return null;
    }

    /* renamed from: a */
    public static void m10880a(String str) {
        f9104a = str;
    }

    /* renamed from: b */
    private static void m10882b(Map<String, String> map) {
        map.remove("event_callback_id");
    }

    /* renamed from: a */
    public static C3346t0 m10873a(String str, C3276c cVar, int i) throws Exception {
        DataOutputStream dataOutputStream = null;
        try {
            HttpsURLConnection a = C3309k.m10998a(new URL(str));
            HashMap hashMap = new HashMap(cVar.mo18973i());
            C3309k.m10999b().mo18953a(a, cVar.mo18967e());
            String a2 = m10876a((Map<String, String>) hashMap);
            String c = m10883c(hashMap);
            m10882b(hashMap);
            String a3 = m10878a(hashMap, a2, c, cVar.mo18954a().toString());
            if (a3 != null) {
                a.setRequestProperty("Authorization", a3);
            }
            a.setRequestMethod("POST");
            a.setUseCaches(false);
            a.setDoInput(true);
            a.setDoOutput(true);
            DataOutputStream dataOutputStream2 = new DataOutputStream(a.getOutputStream());
            try {
                dataOutputStream2.writeBytes(m10877a((Map<String, String>) hashMap, i));
                C3346t0 a4 = m10874a(a, cVar);
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (Exception unused) {
                }
                return a4;
            } catch (Exception e) {
                e = e;
                dataOutputStream = dataOutputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = dataOutputStream2;
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            throw e;
        }
    }

    /* renamed from: a */
    public static C3346t0 m10872a(C3276c cVar, String str) throws Exception {
        try {
            HashMap hashMap = new HashMap(cVar.mo18973i());
            String a = m10876a((Map<String, String>) hashMap);
            String c = m10883c(hashMap);
            m10882b(hashMap);
            HttpsURLConnection a2 = C3309k.m10998a(new URL(m10871a(cVar.mo18975k(), (Map<String, String>) hashMap, str).toString()));
            C3309k.m10999b().mo18953a(a2, cVar.mo18967e());
            String a3 = m10878a(hashMap, a, c, cVar.mo18954a().toString());
            if (a3 != null) {
                a2.setRequestProperty("Authorization", a3);
            }
            a2.setRequestMethod("GET");
            return m10874a(a2, cVar);
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: a */
    private static C3346t0 m10874a(HttpsURLConnection httpsURLConnection, C3276c cVar) throws Exception {
        InputStream inputStream;
        JSONObject jSONObject;
        StringBuffer stringBuffer = new StringBuffer();
        C3364y b = m10881b();
        C3346t0 a = C3346t0.m11150a(cVar);
        try {
            httpsURLConnection.connect();
            Integer valueOf = Integer.valueOf(httpsURLConnection.getResponseCode());
            if (valueOf.intValue() >= 400) {
                inputStream = httpsURLConnection.getErrorStream();
            } else {
                inputStream = httpsURLConnection.getInputStream();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            String stringBuffer2 = stringBuffer.toString();
            b.mo19024e("Response: %s", stringBuffer2);
            if (valueOf.intValue() == 429) {
                b.mo19022c("Too frequent requests to the endpoint (429)", new Object[0]);
                return a;
            }
            if (!(stringBuffer2 == null || stringBuffer2.length() == 0)) {
                try {
                    jSONObject = new JSONObject(stringBuffer2);
                } catch (JSONException e) {
                    String a2 = C3268a1.m10834a("Failed to parse json response. (%s)", e.getMessage());
                    b.mo19022c(a2, new Object[0]);
                    a.f9394d = a2;
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    return a;
                }
                a.f9396f = jSONObject;
                String optString = jSONObject.optString("message", (String) null);
                a.f9394d = optString;
                a.f9395e = jSONObject.optString("timestamp", (String) null);
                a.f9393c = jSONObject.optString("adid", (String) null);
                String optString2 = jSONObject.optString("tracking_state", (String) null);
                if (optString2 != null && optString2.equals(Cookie.CONSENT_STATUS_OPTED_OUT)) {
                    a.f9397g = C3367z0.OPTED_OUT;
                }
                if (optString == null) {
                    optString = "No message found";
                }
                if (valueOf == null || valueOf.intValue() != 200) {
                    b.mo19022c("%s", optString);
                } else {
                    b.mo19025f("%s", optString);
                    a.f9391a = true;
                }
            }
            return a;
        } catch (Exception e2) {
            b.mo19022c("Failed to read response. (%s)", e2.getMessage());
            throw e2;
        } catch (Throwable th) {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static String m10877a(Map<String, String> map, int i) throws UnsupportedEncodingException {
        String str;
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            String encode = URLEncoder.encode((String) next.getKey(), C4250c.DEFAULT_CHARSET);
            String str2 = (String) next.getValue();
            if (str2 != null) {
                str = URLEncoder.encode(str2, C4250c.DEFAULT_CHARSET);
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(encode);
            sb.append("=");
            sb.append(str);
        }
        String format = C3268a1.f9092b.format(Long.valueOf(System.currentTimeMillis()));
        sb.append("&");
        sb.append(URLEncoder.encode("sent_at", C4250c.DEFAULT_CHARSET));
        sb.append("=");
        sb.append(URLEncoder.encode(format, C4250c.DEFAULT_CHARSET));
        if (i > 0) {
            sb.append("&");
            sb.append(URLEncoder.encode("queue_size", C4250c.DEFAULT_CHARSET));
            sb.append("=");
            sb.append(URLEncoder.encode(str + i, C4250c.DEFAULT_CHARSET));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static Uri m10871a(String str, Map<String, String> map, String str2) {
        String str3;
        Uri.Builder builder = new Uri.Builder();
        String str4 = "https";
        String str5 = "app.adjust.com";
        try {
            String a = C3309k.m10997a();
            if (str2 != null) {
                a = a + str2;
            }
            URL url = new URL(a);
            str4 = url.getProtocol();
            str5 = url.getAuthority();
            str3 = url.getPath();
        } catch (MalformedURLException e) {
            m10881b().mo19022c("Unable to parse endpoint (%s)", e.getMessage());
            str3 = "";
        }
        builder.scheme(str4);
        builder.encodedAuthority(str5);
        builder.path(str3);
        builder.appendPath(str);
        for (Map.Entry next : map.entrySet()) {
            builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        builder.appendQueryParameter("sent_at", C3268a1.f9092b.format(Long.valueOf(System.currentTimeMillis())));
        return builder.build();
    }

    /* renamed from: a */
    private static String m10876a(Map<String, String> map) {
        return map.remove("app_secret");
    }

    /* renamed from: a */
    private static String m10878a(Map<String, String> map, String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Map<String, String> a = m10879a(map, str3, str);
        String f = C3268a1.m10866f(a.get("clear_signature"));
        String a2 = C3268a1.m10834a("Signature %s,%s,%s,%s", C3268a1.m10834a("secret_id=\"%s\"", str2), C3268a1.m10834a("signature=\"%s\"", f), C3268a1.m10834a("algorithm=\"%s\"", "sha256"), C3268a1.m10834a("headers=\"%s\"", a.get(GraphRequest.FIELDS_PARAM)));
        m10881b().mo19024e("authorizationHeader: %s", a2);
        return a2;
    }

    /* renamed from: a */
    private static Map<String, String> m10879a(Map<String, String> map, String str, String str2) {
        String d = m10884d(map);
        HashMap hashMap = new HashMap();
        hashMap.put("app_secret", str2);
        hashMap.put("created_at", map.get("created_at"));
        hashMap.put("activity_kind", str);
        hashMap.put(d, map.get(d));
        String str3 = "";
        String str4 = str3;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                str3 = str3 + ((String) entry.getKey()) + " ";
                str4 = str4 + ((String) entry.getValue());
            }
        }
        String substring = str3.substring(0, str3.length() - 1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("clear_signature", str4);
        hashMap2.put(GraphRequest.FIELDS_PARAM, substring);
        return hashMap2;
    }
}
