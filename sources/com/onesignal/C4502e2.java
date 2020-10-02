package com.onesignal;

import com.onesignal.C4564n1;
import com.onesignal.C4731y1;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.e2 */
/* compiled from: OutcomeEventsRepository */
class C4502e2 {

    /* renamed from: a */
    private final C4506f2 f12336a = new C4506f2();

    /* renamed from: b */
    private final C4655t1 f12337b;

    C4502e2(C4655t1 t1Var) {
        this.f12337b = t1Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C4478b2> mo29764a() {
        return C4483c2.m15444a(this.f12337b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29769b(C4478b2 b2Var) {
        C4483c2.m15448b(b2Var, this.f12337b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo29771c(String str, int i, C4478b2 b2Var, C4731y1.C4738g gVar) {
        JSONObject f = b2Var.mo29729f();
        try {
            f.put("app_id", str);
            f.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, i);
            this.f12336a.mo29772a(f, gVar);
        } catch (JSONException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating unattributed outcome:JSON Failed.", (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29766a(C4478b2 b2Var) {
        C4483c2.m15446a(b2Var, this.f12337b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29770b(String str, int i, C4478b2 b2Var, C4731y1.C4738g gVar) {
        JSONObject f = b2Var.mo29729f();
        try {
            f.put("app_id", str);
            f.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, i);
            f.put("direct", false);
            this.f12336a.mo29772a(f, gVar);
        } catch (JSONException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating indirect outcome:JSON Failed.", (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29767a(String str, int i, C4478b2 b2Var, C4731y1.C4738g gVar) {
        JSONObject f = b2Var.mo29729f();
        try {
            f.put("app_id", str);
            f.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, i);
            f.put("direct", true);
            this.f12336a.mo29772a(f, gVar);
        } catch (JSONException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating direct outcome:JSON Failed.", (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29768a(JSONArray jSONArray, String str) {
        C4483c2.m15447a(jSONArray, str, this.f12337b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONArray mo29765a(String str, JSONArray jSONArray) {
        return C4483c2.m15445a(str, jSONArray, this.f12337b);
    }
}
