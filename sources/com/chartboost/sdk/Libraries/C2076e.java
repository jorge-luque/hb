package com.chartboost.sdk.Libraries;

import com.chartboost.sdk.Tracking.C2098a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.e */
public class C2076e {

    /* renamed from: com.chartboost.sdk.Libraries.e$a */
    public static class C2077a {

        /* renamed from: a */
        final String f6861a;

        /* renamed from: b */
        final Object f6862b;

        public C2077a(String str, Object obj) {
            this.f6861a = str;
            this.f6862b = obj;
        }
    }

    /* renamed from: a */
    public static JSONObject m8185a(JSONObject jSONObject, String... strArr) {
        for (String str : strArr) {
            if (jSONObject == null) {
                break;
            }
            jSONObject = jSONObject.optJSONObject(str);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m8187a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            C2098a.m8288a(C2076e.class, "put (" + str + ")", (Exception) e);
        }
    }

    /* renamed from: a */
    public static JSONObject m8186a(C2077a... aVarArr) {
        JSONObject jSONObject = new JSONObject();
        for (C2077a aVar : aVarArr) {
            m8187a(jSONObject, aVar.f6861a, aVar.f6862b);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static C2077a m8184a(String str, Object obj) {
        return new C2077a(str, obj);
    }
}
