package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.C3137gf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.fm */
public class C5086fm extends C5093fq {

    /* renamed from: c */
    private static final String f13926c = "fm";

    public C5086fm(String str, String str2) {
        super(str, str2, "ad");
    }

    /* renamed from: a */
    public final C3137gf.C3139a mo31245a(String str, JSONObject jSONObject) {
        return mo31257a(str, m17196a(jSONObject), m17197b(jSONObject));
    }

    /* renamed from: b */
    public final C3137gf.C3139a mo31246b(String str, JSONObject jSONObject) {
        return mo31260b(str, m17196a(jSONObject), m17197b(jSONObject));
    }

    /* renamed from: a */
    public static Map m17196a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(TJAdUnitConstants.String.USAGE_TRACKER_DIMENSIONS);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.get(next));
                }
            } catch (JSONException e) {
                String str = f13926c;
                TapjoyLog.m16649d(str, "Unable to getAdUnitDimensions. Invalid params: " + e);
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static Map m17197b(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(TJAdUnitConstants.String.USAGE_TRACKER_VALUES);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, Long.valueOf(jSONObject2.getLong(next)));
                }
            } catch (JSONException e) {
                String str = f13926c;
                TapjoyLog.m16649d(str, "Unable to getAdUnitValues. Invalid params: " + e);
            }
        }
        return hashMap;
    }
}
