package com.adcolony.sdk;

import com.adcolony.sdk.C1439u;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.s */
class C1437s {
    C1437s() {
    }

    /* renamed from: a */
    static JSONObject m5583a(String str, String str2) {
        String str3;
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2 + ": " + e.toString();
            }
            new C1439u.C1440a().mo6801a(str3).mo6803a(C1439u.f4517j);
            return new JSONObject();
        }
    }

    /* renamed from: b */
    static JSONObject m5599b() {
        return new JSONObject();
    }

    /* renamed from: c */
    static JSONObject m5606c(JSONArray jSONArray, int i) {
        JSONObject optJSONObject = jSONArray.optJSONObject(i);
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    /* renamed from: d */
    static String m5607d(JSONArray jSONArray, int i) {
        return jSONArray.optString(i);
    }

    /* renamed from: e */
    static double m5609e(JSONObject jSONObject, String str) {
        return jSONObject.optDouble(str, 0.0d);
    }

    /* renamed from: f */
    static int m5611f(JSONObject jSONObject, String str) {
        return jSONObject.optInt(str);
    }

    /* renamed from: g */
    static JSONObject m5612g(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    /* renamed from: h */
    static String m5613h(JSONObject jSONObject, String str) {
        return jSONObject.optString(str);
    }

    /* renamed from: i */
    static boolean m5614i(JSONObject jSONObject, String str) {
        try {
            C1199a.m4880c().mo6545k().mo6778a(str, jSONObject.toString(), false);
            return true;
        } catch (IOException e) {
            new C1439u.C1440a().mo6801a("IOException in ADCJSON's saveObject: ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: b */
    static JSONObject m5600b(String str) {
        return m5583a(str, (String) null);
    }

    /* renamed from: d */
    static boolean m5608d(JSONObject jSONObject, String str) {
        return jSONObject.optBoolean(str);
    }

    /* renamed from: e */
    static void m5610e(JSONArray jSONArray, int i) {
        jSONArray.put(i);
    }

    /* renamed from: b */
    static Object m5598b(JSONObject jSONObject, String str) {
        Object opt = jSONObject.opt(str);
        return opt == null ? Boolean.FALSE : opt;
    }

    /* renamed from: c */
    static JSONArray m5604c(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        return optJSONArray == null ? new JSONArray() : optJSONArray;
    }

    /* renamed from: b */
    static Object m5597b(JSONArray jSONArray, int i) {
        Object opt = jSONArray.opt(i);
        return opt == null ? Boolean.FALSE : opt;
    }

    /* renamed from: c */
    static JSONObject m5605c(String str) {
        try {
            String sb = C1199a.m4880c().mo6545k().mo6777a(str, false).toString();
            return m5583a(sb, "loadObject from filepath " + str);
        } catch (IOException e) {
            new C1439u.C1440a().mo6801a("IOException in ADCJSON's loadObject: ").mo6801a(e.toString()).mo6803a(C1439u.f4517j);
            return m5599b();
        }
    }

    /* renamed from: a */
    static JSONArray m5579a() {
        return new JSONArray();
    }

    /* renamed from: b */
    static boolean m5602b(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
            return true;
        } catch (JSONException e) {
            C1439u.C1440a a = new C1439u.C1440a().mo6801a("JSON error in ADCJSON putInteger(): ").mo6801a(e.toString());
            C1439u.C1440a a2 = a.mo6801a(" with key: " + str);
            a2.mo6801a(" and value: " + i).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: a */
    static JSONArray m5580a(String str) {
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            new C1439u.C1440a().mo6801a(e.toString()).mo6803a(C1439u.f4517j);
            return new JSONArray();
        }
    }

    /* renamed from: a */
    static JSONObject m5584a(JSONArray jSONArray, int i) {
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            new C1439u.C1440a().mo6801a(e.toString()).mo6803a(C1439u.f4517j);
            return new JSONObject();
        }
    }

    /* renamed from: b */
    static boolean m5603b(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
            return true;
        } catch (JSONException e) {
            C1439u.C1440a a = new C1439u.C1440a().mo6801a("JSON error in ADCJSON putBoolean(): ").mo6801a(e.toString());
            C1439u.C1440a a2 = a.mo6801a(" with key: " + str);
            a2.mo6801a(" and value: " + z).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: a */
    static int m5578a(JSONObject jSONObject, String str, int i) {
        return jSONObject.optInt(str, i);
    }

    /* renamed from: a */
    static boolean m5595a(JSONObject jSONObject, String str, boolean z) {
        return jSONObject.optBoolean(str, z);
    }

    /* renamed from: a */
    static boolean m5592a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
            return true;
        } catch (JSONException e) {
            C1439u.C1440a a = new C1439u.C1440a().mo6801a("JSON error in ADCJSON putString(): ").mo6801a(e.toString());
            C1439u.C1440a a2 = a.mo6801a(" with key: " + str);
            a2.mo6801a(" and value: " + str2).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: b */
    static void m5601b(JSONArray jSONArray, String str) {
        jSONArray.put(str);
    }

    /* renamed from: a */
    static boolean m5591a(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
            return true;
        } catch (JSONException e) {
            C1439u.C1440a a = new C1439u.C1440a().mo6801a("JSON error in ADCJSON putLong(): ").mo6801a(e.toString());
            C1439u.C1440a a2 = a.mo6801a(" with key: " + str);
            a2.mo6801a(" and value: " + j).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m5593a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            jSONObject.put(str, jSONArray);
            return true;
        } catch (JSONException e) {
            C1439u.C1440a a = new C1439u.C1440a().mo6801a("JSON error in ADCJSON putArray(): ").mo6801a(e.toString());
            C1439u.C1440a a2 = a.mo6801a(" with key: " + str);
            a2.mo6801a(" and value: " + jSONArray).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m5594a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            jSONObject.put(str, jSONObject2);
            return true;
        } catch (JSONException e) {
            C1439u.C1440a a = new C1439u.C1440a().mo6801a("JSON error in ADCJSON putObject(): ").mo6801a(e.toString());
            C1439u.C1440a a2 = a.mo6801a(" with key: " + str);
            a2.mo6801a(" and value: " + jSONObject2).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m5590a(JSONObject jSONObject, String str, double d) {
        try {
            jSONObject.put(str, d);
            return true;
        } catch (JSONException unused) {
            C1439u.C1440a a = new C1439u.C1440a().mo6801a("JSON error in ADCJSON putDouble(): ");
            C1439u.C1440a a2 = a.mo6801a(" with key: " + str);
            a2.mo6801a(" and value: " + d).mo6803a(C1439u.f4517j);
            return false;
        }
    }

    /* renamed from: a */
    static void m5587a(JSONArray jSONArray, boolean z) {
        jSONArray.put(z);
    }

    /* renamed from: a */
    static void m5586a(JSONArray jSONArray, Object obj) {
        jSONArray.put(obj);
    }

    /* renamed from: a */
    static String[] m5596a(JSONArray jSONArray) {
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = m5607d(jSONArray, i);
        }
        return strArr;
    }

    /* renamed from: a */
    static JSONArray m5582a(String[] strArr) {
        JSONArray a = m5579a();
        for (String b : strArr) {
            m5601b(a, b);
        }
        return a;
    }

    /* renamed from: a */
    static boolean m5588a(JSONArray jSONArray, String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (m5607d(jSONArray, i).equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m5589a(JSONObject jSONObject, String str) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            if (str.equals(keys.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static JSONArray m5581a(JSONArray jSONArray, String[] strArr, boolean z) {
        for (String str : strArr) {
            if (!z || !m5588a(jSONArray, str)) {
                m5601b(jSONArray, str);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    static JSONObject m5585a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
