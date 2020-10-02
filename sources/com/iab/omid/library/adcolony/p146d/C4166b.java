package com.iab.omid.library.adcolony.p146d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.iab.omid.library.adcolony.p144b.C4154c;
import com.iab.omid.library.adcolony.walking.C4181a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.d.b */
public class C4166b {

    /* renamed from: a */
    private static WindowManager f11203a;

    /* renamed from: b */
    private static String[] f11204b = {"x", "y", "width", "height"};

    /* renamed from: c */
    static float f11205c = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: com.iab.omid.library.adcolony.d.b$a */
    private static class C4167a {

        /* renamed from: a */
        final float f11206a;

        /* renamed from: b */
        final float f11207b;

        C4167a(float f, float f2) {
            this.f11206a = f;
            this.f11207b = f2;
        }
    }

    /* renamed from: a */
    static float m13979a(int i) {
        return ((float) i) / f11205c;
    }

    /* renamed from: a */
    public static JSONObject m13980a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) m13979a(i));
            jSONObject.put("y", (double) m13979a(i2));
            jSONObject.put("width", (double) m13979a(i3));
            jSONObject.put("height", (double) m13979a(i4));
        } catch (JSONException e) {
            C4168c.m13996a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m13981a(Context context) {
        if (context != null) {
            f11205c = context.getResources().getDisplayMetrics().density;
            f11203a = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m13982a(JSONObject jSONObject) {
        C4167a b = m13988b(jSONObject);
        try {
            jSONObject.put("width", (double) b.f11206a);
            jSONObject.put("height", (double) b.f11207b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m13983a(JSONObject jSONObject, C4181a.C4182a aVar) {
        C4154c a = aVar.mo28597a();
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.mo28599b()) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a.mo28518b());
            jSONObject.put("friendlyObstructionPurpose", a.mo28519c());
            jSONObject.put("friendlyObstructionReason", a.mo28520d());
        } catch (JSONException e) {
            C4168c.m13996a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m13984a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C4168c.m13996a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m13985a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            C4168c.m13996a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static void m13986a(JSONObject jSONObject, JSONObject jSONObject2) {
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
    private static boolean m13987a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    private static C4167a m13988b(JSONObject jSONObject) {
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
                return new C4167a(f2, f);
            }
        } else if (f11203a != null) {
            Point point = new Point(0, 0);
            f11203a.getDefaultDisplay().getRealSize(point);
            f2 = m13979a(point.x);
            f = m13979a(point.y);
            return new C4167a(f2, f);
        }
        f = 0.0f;
        return new C4167a(f2, f);
    }

    /* renamed from: b */
    public static void m13989b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C4168c.m13996a("Error with setting not visible reason", e);
        }
    }

    /* renamed from: b */
    public static boolean m13990b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m13991c(jSONObject, jSONObject2) && m13992d(jSONObject, jSONObject2) && m13993e(jSONObject, jSONObject2) && m13994f(jSONObject, jSONObject2);
    }

    /* renamed from: c */
    private static boolean m13991c(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f11204b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m13992d(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    /* renamed from: e */
    private static boolean m13993e(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m13987a(optJSONArray, optJSONArray2)) {
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
    private static boolean m13994f(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m13987a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!m13990b(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }
}
