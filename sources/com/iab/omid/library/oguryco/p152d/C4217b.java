package com.iab.omid.library.oguryco.p152d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.iab.omid.library.oguryco.p150b.C4205c;
import com.iab.omid.library.oguryco.walking.C4232a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.d.b */
public class C4217b {

    /* renamed from: a */
    static float f11324a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    private static WindowManager f11325b;

    /* renamed from: c */
    private static String[] f11326c = {"x", "y", "width", "height"};

    /* renamed from: com.iab.omid.library.oguryco.d.b$a */
    static class C4218a {

        /* renamed from: a */
        final float f11327a;

        /* renamed from: b */
        final float f11328b;

        C4218a(float f, float f2) {
            this.f11327a = f;
            this.f11328b = f2;
        }
    }

    /* renamed from: a */
    static float m14208a(int i) {
        return ((float) i) / f11324a;
    }

    /* renamed from: a */
    public static JSONObject m14209a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) m14208a(i));
            jSONObject.put("y", (double) m14208a(i2));
            jSONObject.put("width", (double) m14208a(i3));
            jSONObject.put("height", (double) m14208a(i4));
        } catch (JSONException e) {
            C4219c.m14225a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m14210a(Context context) {
        if (context != null) {
            f11324a = context.getResources().getDisplayMetrics().density;
            f11325b = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m14211a(JSONObject jSONObject) {
        C4218a b = m14217b(jSONObject);
        try {
            jSONObject.put("width", (double) b.f11327a);
            jSONObject.put("height", (double) b.f11328b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m14212a(JSONObject jSONObject, C4232a.C4233a aVar) {
        C4205c a = aVar.mo28811a();
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.mo28813b()) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a.mo28732b());
            jSONObject.put("friendlyObstructionPurpose", a.mo28733c());
            jSONObject.put("friendlyObstructionReason", a.mo28734d());
        } catch (JSONException e) {
            C4219c.m14225a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m14213a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C4219c.m14225a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m14214a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            C4219c.m14225a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static void m14215a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m14216a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    private static C4218a m14217b(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (Build.VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f3 = 0.0f;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble("width");
                        double optDouble4 = optJSONObject.optDouble("height");
                        f2 = Math.max(f2, (float) (optDouble + optDouble3));
                        f3 = Math.max(f3, (float) (optDouble2 + optDouble4));
                    }
                }
                f = f3;
                return new C4218a(f2, f);
            }
        } else if (f11325b != null) {
            Point point = new Point(0, 0);
            f11325b.getDefaultDisplay().getRealSize(point);
            f2 = m14208a(point.x);
            f = m14208a(point.y);
            return new C4218a(f2, f);
        }
        f = 0.0f;
        return new C4218a(f2, f);
    }

    /* renamed from: b */
    public static void m14218b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C4219c.m14225a("Error with setting not visible reason", e);
        }
    }

    /* renamed from: b */
    public static boolean m14219b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m14220c(jSONObject, jSONObject2) && m14221d(jSONObject, jSONObject2) && m14222e(jSONObject, jSONObject2) && m14223f(jSONObject, jSONObject2);
    }

    /* renamed from: c */
    private static boolean m14220c(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f11326c) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m14221d(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    /* renamed from: e */
    private static boolean m14222e(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m14216a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!optJSONArray.optString(i, "").equals(optJSONArray2.optString(i, ""))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private static boolean m14223f(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m14216a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!m14219b(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }
}
