package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.i */
public class C1993i {
    /* renamed from: a */
    public static float m7868a(JSONObject jSONObject, String str, float f, C1941j jVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return f;
        }
        try {
            double d = jSONObject.getDouble(str);
            return (-3.4028234663852886E38d >= d || d >= 3.4028234663852886E38d) ? f : (float) d;
        } catch (JSONException e) {
            if (jVar == null) {
                return f;
            }
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to retrieve float property for key = " + str, e);
            return f;
        }
    }

    /* renamed from: a */
    public static long m7869a(JSONObject jSONObject, String str, long j, C1941j jVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return j;
        }
        try {
            return jSONObject.getLong(str);
        } catch (JSONException e) {
            if (jVar == null) {
                return j;
            }
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to retrieve int property for key = " + str, e);
            return j;
        }
    }

    /* renamed from: a */
    public static Bundle m7870a(Object obj) {
        JSONObject jSONObject;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            if (obj instanceof String) {
                try {
                    jSONObject = new JSONObject((String) obj);
                } catch (JSONException unused) {
                }
            }
            jSONObject = null;
        }
        return m7903c(jSONObject);
    }

    /* renamed from: a */
    public static Boolean m7871a(JSONObject jSONObject, String str, Boolean bool, C1941j jVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return bool;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        } catch (JSONException unused) {
            boolean z = true;
            if (m7894b(jSONObject, str, (bool == null || !bool.booleanValue()) ? 0 : 1, jVar) <= 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: a */
    public static Object m7872a(JSONArray jSONArray, int i, Object obj, C1941j jVar) {
        if (jSONArray == null || jSONArray.length() <= i) {
            return obj;
        }
        try {
            return jSONArray.get(i);
        } catch (JSONException e) {
            if (jVar == null) {
                return obj;
            }
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to retrieve object at index " + i + " for JSON array", e);
            return obj;
        }
    }

    /* renamed from: a */
    public static String m7873a(Map<String, Object> map, String str, C1941j jVar) {
        try {
            return m7882a((Map<String, ?>) map).toString();
        } catch (JSONException e) {
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to convert map '" + map + "' to JSON string.", e);
            return str;
        }
    }

    /* renamed from: a */
    public static ArrayList<Bundle> m7874a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m7903c(jSONArray.optJSONObject(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <T> List<T> m7875a(JSONArray jSONArray, List<T> list) {
        try {
            return m7897b(jSONArray);
        } catch (JSONException unused) {
            return list;
        }
    }

    /* renamed from: a */
    public static List m7876a(JSONObject jSONObject, String str, List list, C1941j jVar) {
        try {
            JSONArray b = m7900b(jSONObject, str, (JSONArray) null, jVar);
            return b != null ? m7897b(b) : list;
        } catch (JSONException unused) {
            return list;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m7877a(Bundle bundle) {
        if (bundle == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(bundle.size());
        for (String str : bundle.keySet()) {
            hashMap.put(str, String.valueOf(bundle.get(str)));
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Map<String, Object> m7878a(String str, Map<String, Object> map, C1941j jVar) {
        try {
            return m7898b(new JSONObject(str));
        } catch (JSONException e) {
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to convert json string '" + str + "' to map", e);
            return map;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m7879a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, m7904c(jSONObject.get(next)).toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    public static JSONObject m7880a(String str, C1941j jVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            C1977q v = jVar.mo8602v();
            v.mo8746e("JsonUtils", "Failed to deserialize into JSON: " + str);
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m7881a(String str, JSONObject jSONObject, C1941j jVar) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            if (jVar != null) {
                C1977q v = jVar.mo8602v();
                v.mo8743b("JsonUtils", "Failed to convert JSON string '" + str + "' to JSONObject", e);
            }
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static JSONObject m7882a(Map<String, ?> map) throws JSONException {
        if (map == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            jSONObject.put((String) next.getKey(), next.getValue());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m7883a(JSONArray jSONArray, int i, JSONObject jSONObject, C1941j jVar) {
        if (jSONArray == null || i >= jSONArray.length()) {
            return jSONObject;
        }
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            if (jVar == null) {
                return jSONObject;
            }
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to retrieve JSON object from array for index = " + i, e);
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static void m7884a(JSONObject jSONObject, String str, int i, C1941j jVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, i);
            } catch (JSONException e) {
                if (jVar != null) {
                    C1977q v = jVar.mo8602v();
                    v.mo8743b("JsonUtils", "Failed to put int property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7885a(JSONObject jSONObject, String str, Object obj, C1941j jVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e) {
                if (jVar != null) {
                    C1977q v = jVar.mo8602v();
                    v.mo8743b("JsonUtils", "Failed to put Object property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7886a(JSONObject jSONObject, String str, String str2, C1941j jVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e) {
                if (jVar != null) {
                    C1977q v = jVar.mo8602v();
                    v.mo8743b("JsonUtils", "Failed to put String property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7887a(JSONObject jSONObject, String str, JSONArray jSONArray, C1941j jVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException e) {
                if (jVar != null) {
                    C1977q v = jVar.mo8602v();
                    v.mo8743b("JsonUtils", "Failed to put JSONArray property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7888a(JSONObject jSONObject, String str, JSONObject jSONObject2, C1941j jVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (JSONException e) {
                if (jVar != null) {
                    C1977q v = jVar.mo8602v();
                    v.mo8743b("JsonUtils", "Failed to put JSON property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7889a(JSONObject jSONObject, String str, boolean z, C1941j jVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, z);
            } catch (JSONException e) {
                if (jVar != null) {
                    C1977q v = jVar.mo8602v();
                    v.mo8743b("JsonUtils", "Failed to put boolean property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7890a(JSONObject jSONObject, JSONObject jSONObject2, C1941j jVar) {
        if (jSONObject != null && jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object b = m7895b(jSONObject2, next, (Object) null, jVar);
                if (b != null) {
                    m7885a(jSONObject, next, b, jVar);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7891a(JSONObject jSONObject, String[] strArr) {
        for (String remove : strArr) {
            jSONObject.remove(remove);
        }
    }

    /* renamed from: a */
    public static boolean m7892a(String str, JSONArray jSONArray) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                Object obj = jSONArray.get(i);
                if ((obj instanceof String) && ((String) obj).equalsIgnoreCase(str)) {
                    return true;
                }
                i++;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7893a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    /* renamed from: b */
    public static int m7894b(JSONObject jSONObject, String str, int i, C1941j jVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return i;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e) {
            if (jVar == null) {
                return i;
            }
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to retrieve int property for key = " + str, e);
            return i;
        }
    }

    /* renamed from: b */
    public static Object m7895b(JSONObject jSONObject, String str, Object obj, C1941j jVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return obj;
        }
        try {
            Object obj2 = jSONObject.get(str);
            return obj2 != null ? obj2 : obj;
        } catch (JSONException e) {
            if (jVar == null) {
                return obj;
            }
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to retrieve Object for key = " + str, e);
            return obj;
        }
    }

    /* renamed from: b */
    public static String m7896b(JSONObject jSONObject, String str, String str2, C1941j jVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return str2;
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            if (jVar == null) {
                return str2;
            }
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to retrieve string property for key = " + str, e);
            return str2;
        }
    }

    /* renamed from: b */
    public static List m7897b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m7904c(jSONArray.get(i)));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static Map<String, Object> m7898b(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, m7904c(jSONObject.get(next)));
        }
        return hashMap;
    }

    /* renamed from: b */
    public static JSONArray m7899b(Object obj) {
        if (obj == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(obj);
        return jSONArray;
    }

    /* renamed from: b */
    public static JSONArray m7900b(JSONObject jSONObject, String str, JSONArray jSONArray, C1941j jVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONArray;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e) {
            if (jVar == null) {
                return jSONArray;
            }
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to retrieve JSON array for key = " + str, e);
            return jSONArray;
        }
    }

    /* renamed from: b */
    public static JSONObject m7901b(JSONObject jSONObject, String str, JSONObject jSONObject2, C1941j jVar) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return jSONObject2;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            if (jVar == null) {
                return jSONObject2;
            }
            C1977q v = jVar.mo8602v();
            v.mo8743b("JsonUtils", "Failed to retrieve JSON property for key = " + str, e);
            return jSONObject2;
        }
    }

    /* renamed from: b */
    public static void m7902b(JSONObject jSONObject, String str, long j, C1941j jVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put(str, j);
            } catch (JSONException e) {
                if (jVar != null) {
                    C1977q v = jVar.mo8602v();
                    v.mo8743b("JsonUtils", "Failed to put long property for key = " + str, e);
                }
            }
        }
    }

    /* renamed from: c */
    public static Bundle m7903c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (jSONObject.isNull(next)) {
                bundle.putString(next, (String) null);
            } else {
                Object opt = jSONObject.opt(next);
                if (opt instanceof JSONObject) {
                    bundle.putBundle(next, m7903c((JSONObject) opt));
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (jSONArray.length() == 0) {
                        bundle.putStringArrayList(next, new ArrayList(0));
                    } else if (m7872a(jSONArray, 0, (Object) null, (C1941j) null) instanceof String) {
                        ArrayList arrayList = new ArrayList(jSONArray.length());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add((String) m7872a(jSONArray, i, (Object) null, (C1941j) null));
                        }
                        bundle.putStringArrayList(next, arrayList);
                    } else {
                        bundle.putParcelableArrayList(next, m7874a(jSONArray));
                    }
                } else if (opt instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) opt).booleanValue());
                } else if (opt instanceof String) {
                    bundle.putString(next, (String) opt);
                } else if (opt instanceof Integer) {
                    bundle.putInt(next, ((Integer) opt).intValue());
                } else if (opt instanceof Long) {
                    bundle.putLong(next, ((Long) opt).longValue());
                } else if (opt instanceof Double) {
                    bundle.putDouble(next, ((Double) opt).doubleValue());
                }
            }
        }
        return bundle;
    }

    /* renamed from: c */
    private static Object m7904c(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof JSONObject ? m7898b((JSONObject) obj) : obj instanceof JSONArray ? m7897b((JSONArray) obj) : obj;
    }

    /* renamed from: d */
    public static JSONObject m7905d(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.put(next, jSONObject.get(next));
            } catch (JSONException unused) {
                C1977q.m7750h("JsonUtils", "Failed to copy over item for key '" + next + "' to JSONObject copy");
            }
        }
        return jSONObject2;
    }

    /* renamed from: e */
    public static String m7906e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.toString(4);
        } catch (JSONException unused) {
            return jSONObject.toString();
        }
    }
}
