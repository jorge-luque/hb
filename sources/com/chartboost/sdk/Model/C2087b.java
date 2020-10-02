package com.chartboost.sdk.Model;

import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Tracking.C2098a;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.b */
public class C2087b {

    /* renamed from: a */
    public final String f6914a;

    /* renamed from: b */
    public final String f6915b;

    /* renamed from: c */
    public final String f6916c;

    public C2087b(String str, String str2, String str3) {
        this.f6914a = str;
        this.f6915b = str2;
        this.f6916c = str3;
    }

    /* renamed from: a */
    private static Map<String, C2087b> m8218a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(next2);
                hashMap.put(next2, new C2087b(next, jSONObject3.getString("filename"), jSONObject3.getString("url")));
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static Map<String, C2087b> m8221b(JSONObject jSONObject) {
        Class<C2087b> cls = C2087b.class;
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("videos");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("id");
                    hashMap.put(string, new C2087b("videos", string, jSONObject2.getString("video")));
                } catch (JSONException e) {
                    C2098a.m8288a((Class) cls, "deserializeNativeVideos (file)", (Exception) e);
                }
            }
        } catch (JSONException e2) {
            C2098a.m8288a((Class) cls, "deserializeNativeVideos (videos array)", (Exception) e2);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static JSONObject m8220a(JSONArray jSONArray) throws JSONException {
        JSONObject a = C2076e.m8186a(new C2076e.C2077a[0]);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String optString = jSONObject.optString("name");
            String optString2 = jSONObject.optString("type");
            String optString3 = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            String optString4 = jSONObject.optString("param");
            if (!optString2.equals("param") && optString4.isEmpty()) {
                JSONObject optJSONObject = a.optJSONObject(optString2);
                if (optJSONObject == null) {
                    optJSONObject = C2076e.m8186a(new C2076e.C2077a[0]);
                    a.put(optString2, optJSONObject);
                }
                optJSONObject.put(optString2.equals(TJAdUnitConstants.String.HTML) ? "body" : optString, C2076e.m8186a(C2076e.m8184a("filename", (Object) optString), C2076e.m8184a("url", (Object) optString3)));
            }
        }
        return a;
    }

    /* renamed from: a */
    public static Map<String, C2087b> m8219a(JSONObject jSONObject, int i) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("cache_assets");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                int i2 = 0;
                if (next.equals("templates")) {
                    JSONArray optJSONArray = jSONObject2.optJSONArray("templates");
                    if (optJSONArray != null) {
                        int min = Math.min(i, optJSONArray.length());
                        while (i2 < min) {
                            for (Map.Entry<String, C2087b> value : m8218a(m8220a(optJSONArray.getJSONObject(i2).getJSONArray(MessengerShareContentUtility.ELEMENTS))).entrySet()) {
                                C2087b bVar = (C2087b) value.getValue();
                                hashMap.put(bVar.f6915b, bVar);
                            }
                            i2++;
                        }
                    }
                } else {
                    JSONArray jSONArray = jSONObject2.getJSONArray(next);
                    while (i2 < jSONArray.length()) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                        String string = jSONObject3.getString("name");
                        hashMap.put(string, new C2087b(next, string, jSONObject3.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE)));
                        i2++;
                    }
                }
            }
        } catch (JSONException e) {
            C2098a.m8288a(C2087b.class, "v2PrefetchToAssets", (Exception) e);
        }
        return hashMap;
    }

    /* renamed from: a */
    public File mo9117a(File file) {
        return new File(file, this.f6914a + "/" + this.f6915b);
    }
}
