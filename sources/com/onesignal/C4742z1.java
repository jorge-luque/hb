package com.onesignal;

import com.onesignal.C4564n1;
import com.onesignal.C4677v2;
import com.onesignal.C4686w;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.z1 */
/* compiled from: OneSignalStateSynchronizer */
class C4742z1 {

    /* renamed from: a */
    private static HashMap<C4743a, C4677v2> f12869a = new HashMap<>();

    /* renamed from: com.onesignal.z1$a */
    /* compiled from: OneSignalStateSynchronizer */
    enum C4743a {
        PUSH,
        EMAIL;

        static {
            PUSH = new C4743a("PUSH", 0);
            EMAIL = new C4743a("EMAIL", 1);
        }
    }

    /* renamed from: a */
    static C4643s2 m16462a() {
        if (!f12869a.containsKey(C4743a.EMAIL) || f12869a.get(C4743a.EMAIL) == null) {
            f12869a.put(C4743a.EMAIL, new C4643s2());
        }
        return (C4643s2) f12869a.get(C4743a.EMAIL);
    }

    /* renamed from: b */
    static C4671u2 m16467b() {
        if (!f12869a.containsKey(C4743a.PUSH) || f12869a.get(C4743a.PUSH) == null) {
            f12869a.put(C4743a.PUSH, new C4671u2());
        }
        return (C4671u2) f12869a.get(C4743a.PUSH);
    }

    /* renamed from: c */
    static void m16471c(boolean z) {
        m16467b().mo29990d(z);
    }

    /* renamed from: d */
    static void m16472d(boolean z) {
        m16467b().mo29992e(z);
    }

    /* renamed from: e */
    static void m16474e(boolean z) {
        m16467b().mo30001b(z);
        m16462a().mo30001b(z);
    }

    /* renamed from: f */
    static boolean m16476f() {
        return m16467b().mo29993n();
    }

    /* renamed from: g */
    static void m16477g() {
        m16467b().mo30007h();
        m16462a().mo30007h();
    }

    /* renamed from: h */
    static boolean m16478h() {
        boolean i = m16467b().mo30008i();
        boolean i2 = m16462a().mo30008i();
        if (i2) {
            i2 = m16462a().mo30002d() != null;
        }
        if (i || i2) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    static void m16479i() {
        m16462a().mo29953m();
    }

    /* renamed from: j */
    static void m16480j() {
        m16467b().mo30009j();
        m16462a().mo30009j();
        C4564n1.m15838e((String) null);
        C4564n1.m15832d((String) null);
        C4564n1.m15825c(-3660);
    }

    /* renamed from: k */
    static void m16481k() {
        m16467b().mo30010l();
        m16462a().mo30010l();
    }

    /* renamed from: l */
    static void m16482l() {
        m16462a().mo30010l();
    }

    /* renamed from: c */
    static String m16470c() {
        return m16467b().mo30002d();
    }

    /* renamed from: d */
    static boolean m16473d() {
        return m16467b().mo29953m();
    }

    /* renamed from: e */
    static boolean m16475e() {
        return m16467b().mo30004e() || m16462a().mo30004e();
    }

    /* renamed from: a */
    static void m16466a(JSONObject jSONObject, C4564n1.C4593s sVar) {
        try {
            JSONObject put = new JSONObject().put("tags", jSONObject);
            m16467b().mo29998a(put, sVar);
            m16462a().mo29998a(put, sVar);
        } catch (JSONException e) {
            if (sVar != null) {
                sVar.mo29883a(new C4564n1.C4583i0(-1, "Encountered an error attempting to serialize your tags into JSON: " + e.getMessage() + "\n" + e.getStackTrace()));
            }
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    static void m16468b(JSONObject jSONObject) {
        m16467b().mo29991e(jSONObject);
    }

    /* renamed from: b */
    static void m16469b(boolean z) {
        m16467b().mo29999a(z);
        m16462a().mo29999a(z);
    }

    /* renamed from: a */
    static void m16464a(C4686w.C4693g gVar) {
        m16467b().mo29997a(gVar);
        m16462a().mo29997a(gVar);
    }

    /* renamed from: a */
    static C4677v2.C4683f m16463a(boolean z) {
        return m16467b().mo29989c(z);
    }

    /* renamed from: a */
    static void m16465a(JSONObject jSONObject) {
        m16467b().mo30003d(jSONObject);
        m16462a().mo30003d(jSONObject);
    }
}
