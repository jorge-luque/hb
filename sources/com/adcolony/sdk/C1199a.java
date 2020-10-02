package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.C1439u;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.a */
class C1199a {

    /* renamed from: a */
    private static WeakReference<Context> f3336a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static C1290h f3337b;

    /* renamed from: c */
    static boolean f3338c;

    /* renamed from: d */
    static boolean f3339d;

    /* renamed from: com.adcolony.sdk.a$a */
    static class C1200a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f3340a;

        C1200a(Context context) {
            this.f3340a = context;
        }

        public void run() {
            C1199a.f3337b.mo6529a(this.f3340a, (C1454x) null);
        }
    }

    C1199a() {
    }

    /* renamed from: b */
    static Context m4878b() {
        WeakReference<Context> weakReference = f3336a;
        if (weakReference == null) {
            return null;
        }
        return (Context) weakReference.get();
    }

    /* renamed from: c */
    static C1290h m4880c() {
        if (!m4882e()) {
            Context b = m4878b();
            if (b == null) {
                return new C1290h();
            }
            f3337b = new C1290h();
            JSONObject c = C1437s.m5605c(b.getFilesDir().getAbsolutePath() + "/adc3/AppInfo");
            JSONArray c2 = C1437s.m5604c(c, "zoneIds");
            f3337b.mo6523a(new AdColonyAppOptions().mo6269a(C1437s.m5613h(c, "appId")).mo6270a(C1437s.m5596a(c2)), false);
        }
        return f3337b;
    }

    /* renamed from: d */
    static boolean m4881d() {
        WeakReference<Context> weakReference = f3336a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: e */
    static boolean m4882e() {
        return f3337b != null;
    }

    /* renamed from: f */
    static boolean m4883f() {
        return f3338c;
    }

    /* renamed from: g */
    static void m4884g() {
        m4880c().mo6548n().mo6845e();
    }

    /* renamed from: a */
    static void m4875a(Context context, AdColonyAppOptions adColonyAppOptions, boolean z) {
        m4874a(context);
        f3339d = true;
        C1290h hVar = f3337b;
        if (hVar == null) {
            C1290h hVar2 = new C1290h();
            f3337b = hVar2;
            hVar2.mo6523a(adColonyAppOptions, z);
        } else {
            hVar.mo6522a(adColonyAppOptions);
        }
        C1359k0.f4258b.execute(new C1200a(context));
        new C1439u.C1440a().mo6801a("Configuring AdColony").mo6803a(C1439u.f4512e);
        f3337b.mo6535c(false);
        f3337b.mo6554u().mo6498d(true);
        f3337b.mo6554u().mo6500e(true);
        f3337b.mo6554u().mo6502f(false);
        C1290h hVar3 = f3337b;
        hVar3.f4094F = true;
        hVar3.mo6554u().mo6497c(false);
    }

    /* renamed from: b */
    static void m4879b(String str, C1458z zVar) {
        m4880c().mo6548n().mo6842b(str, zVar);
    }

    /* renamed from: a */
    static void m4874a(Context context) {
        if (context == null) {
            f3336a.clear();
        } else {
            f3336a = new WeakReference<>(context);
        }
    }

    /* renamed from: a */
    static void m4876a(String str, C1458z zVar) {
        m4880c().mo6548n().mo6838a(str, zVar);
    }

    /* renamed from: a */
    static C1458z m4873a(String str, C1458z zVar, boolean z) {
        m4880c().mo6548n().mo6838a(str, zVar);
        return zVar;
    }

    /* renamed from: a */
    static void m4877a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = C1437s.m5599b();
        }
        C1437s.m5592a(jSONObject, "m_type", str);
        m4880c().mo6548n().mo6840a(jSONObject);
    }
}
