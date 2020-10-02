package com.onesignal;

import android.os.Build;
import com.onesignal.C4497e1;
import com.onesignal.C4564n1;
import com.onesignal.C4720x1;
import com.tapjoy.TapjoyConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.g2 */
/* compiled from: OutcomesUtils */
class C4513g2 {
    /* renamed from: a */
    static void m15539a(C4497e1.C4498a aVar) {
        C4698w1.m16353b(C4698w1.f12761a, "PREFS_OS_OUTCOMES_CURRENT_SESSION", aVar.toString());
    }

    /* renamed from: b */
    static C4497e1.C4498a m15542b() {
        return C4497e1.C4498a.m15498a(C4698w1.m16344a(C4698w1.f12761a, "PREFS_OS_OUTCOMES_CURRENT_SESSION", C4497e1.C4498a.UNATTRIBUTED.toString()));
    }

    /* renamed from: c */
    static int m15544c() {
        return C4698w1.m16340a(C4698w1.f12761a, "PREFS_OS_INDIRECT_ATTRIBUTION_WINDOW", 1440);
    }

    /* renamed from: d */
    static JSONArray m15545d() {
        try {
            return new JSONArray(C4698w1.m16344a(C4698w1.f12761a, "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", "[]"));
        } catch (JSONException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating last notifications received data:JSON Failed.", (Throwable) e);
            return new JSONArray();
        }
    }

    /* renamed from: e */
    static int m15546e() {
        return C4698w1.m16340a(C4698w1.f12761a, "PREFS_OS_NOTIFICATION_LIMIT", 10);
    }

    /* renamed from: f */
    static boolean m15547f() {
        return C4698w1.m16348a(C4698w1.f12761a, "PREFS_OS_DIRECT_ENABLED", false);
    }

    /* renamed from: g */
    static boolean m15548g() {
        return C4698w1.m16348a(C4698w1.f12761a, "PREFS_OS_INDIRECT_ENABLED", false);
    }

    /* renamed from: h */
    static boolean m15549h() {
        return C4698w1.m16348a(C4698w1.f12761a, "PREFS_OS_UNATTRIBUTED_ENABLED", false);
    }

    /* renamed from: a */
    static void m15541a(String str) {
        C4698w1.m16353b(C4698w1.f12761a, "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN", str);
    }

    /* renamed from: a */
    static String m15538a() {
        return C4698w1.m16344a(C4698w1.f12761a, "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN", (String) null);
    }

    /* renamed from: b */
    static void m15543b(String str) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
        C4564n1.m15789a(a0Var, "Notification markLastNotificationReceived with id: " + str);
        if (str != null && !str.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(C4698w1.m16344a(C4698w1.f12761a, "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", "[]"));
                jSONArray.put(new JSONObject().put(TapjoyConstants.TJC_NOTIFICATION_ID, str).put("time", System.currentTimeMillis()));
                int e = m15546e();
                if (jSONArray.length() > e) {
                    int length = jSONArray.length() - e;
                    if (Build.VERSION.SDK_INT >= 19) {
                        for (int i = 0; i < length; i++) {
                            jSONArray.remove(i);
                        }
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        while (length < jSONArray.length()) {
                            jSONArray2.put(jSONArray.get(length));
                            length++;
                        }
                        jSONArray = jSONArray2;
                    }
                }
                C4698w1.m16353b(C4698w1.f12761a, "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", jSONArray.toString());
            } catch (JSONException e2) {
                C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating direct notification arrived:JSON Failed.", (Throwable) e2);
            }
        }
    }

    /* renamed from: a */
    static void m15540a(C4720x1.C4726e eVar) {
        C4698w1.m16355b(C4698w1.f12761a, "PREFS_OS_DIRECT_ENABLED", eVar.f12824c);
        C4698w1.m16355b(C4698w1.f12761a, "PREFS_OS_INDIRECT_ENABLED", eVar.f12825d);
        C4698w1.m16355b(C4698w1.f12761a, "PREFS_OS_UNATTRIBUTED_ENABLED", eVar.f12826e);
        C4698w1.m16351b(C4698w1.f12761a, "PREFS_OS_NOTIFICATION_LIMIT", eVar.f12823b);
        C4698w1.m16351b(C4698w1.f12761a, "PREFS_OS_INDIRECT_ATTRIBUTION_WINDOW", eVar.f12822a);
    }
}
