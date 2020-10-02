package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dm */
public final class C4972dm {

    /* renamed from: a */
    static float f13509a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    private static WindowManager f13510b;

    /* renamed from: c */
    private static String[] f13511c = {"x", "y", "width", "height"};

    /* renamed from: com.tapjoy.internal.dm$a */
    static class C4973a {

        /* renamed from: a */
        final float f13512a;

        /* renamed from: b */
        final float f13513b;

        C4973a(float f, float f2) {
            this.f13512a = f;
            this.f13513b = f2;
        }
    }

    /* renamed from: a */
    public static JSONObject m16841a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) (((float) i) / f13509a));
            jSONObject.put("y", (double) (((float) i2) / f13509a));
            jSONObject.put("width", (double) (((float) i3) / f13509a));
            jSONObject.put("height", (double) (((float) i4) / f13509a));
        } catch (JSONException e) {
            C4974dn.m16851a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m16842a(Context context) {
        if (context != null) {
            f13509a = context.getResources().getDisplayMetrics().density;
            f13510b = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m16844a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C4974dn.m16851a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m16845a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            C4974dn.m16851a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static void m16846a(JSONObject jSONObject, List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException e) {
            C4974dn.m16851a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m16847a(JSONObject jSONObject, JSONObject jSONObject2) {
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
    private static boolean m16848a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    public static void m16849b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C4974dn.m16851a("Error with setting not visible reason", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009f A[RETURN] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m16850b(org.json.JSONObject r10, org.json.JSONObject r11) {
        /*
            r0 = 1
            if (r10 != 0) goto L_0x0006
            if (r11 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            if (r10 == 0) goto L_0x00a0
            if (r11 != 0) goto L_0x000d
            goto L_0x00a0
        L_0x000d:
            java.lang.String[] r2 = f13511c
            int r3 = r2.length
            r4 = 0
        L_0x0011:
            if (r4 >= r3) goto L_0x0026
            r5 = r2[r4]
            double r6 = r10.optDouble(r5)
            double r8 = r11.optDouble(r5)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0023
            r2 = 0
            goto L_0x0027
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0026:
            r2 = 1
        L_0x0027:
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r10.optString(r2, r3)
            java.lang.String r2 = r11.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r10.optJSONArray(r2)
            org.json.JSONArray r2 = r11.optJSONArray(r2)
            if (r4 != 0) goto L_0x0049
            if (r2 == 0) goto L_0x006a
        L_0x0049:
            boolean r5 = m16848a((org.json.JSONArray) r4, (org.json.JSONArray) r2)
            if (r5 != 0) goto L_0x0051
        L_0x004f:
            r2 = 0
            goto L_0x006b
        L_0x0051:
            r5 = 0
        L_0x0052:
            int r6 = r4.length()
            if (r5 >= r6) goto L_0x006a
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0067
            goto L_0x004f
        L_0x0067:
            int r5 = r5 + 1
            goto L_0x0052
        L_0x006a:
            r2 = 1
        L_0x006b:
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "childViews"
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            org.json.JSONArray r11 = r11.optJSONArray(r2)
            if (r10 != 0) goto L_0x007b
            if (r11 == 0) goto L_0x009c
        L_0x007b:
            boolean r2 = m16848a((org.json.JSONArray) r10, (org.json.JSONArray) r11)
            if (r2 != 0) goto L_0x0083
        L_0x0081:
            r10 = 0
            goto L_0x009d
        L_0x0083:
            r2 = 0
        L_0x0084:
            int r3 = r10.length()
            if (r2 >= r3) goto L_0x009c
            org.json.JSONObject r3 = r10.optJSONObject(r2)
            org.json.JSONObject r4 = r11.optJSONObject(r2)
            boolean r3 = m16850b((org.json.JSONObject) r3, (org.json.JSONObject) r4)
            if (r3 != 0) goto L_0x0099
            goto L_0x0081
        L_0x0099:
            int r2 = r2 + 1
            goto L_0x0084
        L_0x009c:
            r10 = 1
        L_0x009d:
            if (r10 == 0) goto L_0x00a0
            return r0
        L_0x00a0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4972dm.m16850b(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    /* renamed from: a */
    public static void m16843a(JSONObject jSONObject) {
        float f;
        JSONObject jSONObject2 = jSONObject;
        float f2 = 0.0f;
        if (Build.VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject2.optJSONArray("childViews");
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
                C4973a aVar = new C4973a(f2, f);
                jSONObject2.put("width", (double) aVar.f13512a);
                jSONObject2.put("height", (double) aVar.f13513b);
            }
        } else if (f13510b != null) {
            Point point = new Point(0, 0);
            f13510b.getDefaultDisplay().getRealSize(point);
            float f4 = f13509a;
            f2 = ((float) point.x) / f4;
            f = ((float) point.y) / f4;
            C4973a aVar2 = new C4973a(f2, f);
            jSONObject2.put("width", (double) aVar2.f13512a);
            jSONObject2.put("height", (double) aVar2.f13513b);
        }
        f = 0.0f;
        C4973a aVar22 = new C4973a(f2, f);
        try {
            jSONObject2.put("width", (double) aVar22.f13512a);
            jSONObject2.put("height", (double) aVar22.f13513b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
