package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.z0 */
/* compiled from: OSPermissionState */
public class C4741z0 implements Cloneable {

    /* renamed from: a */
    C4729y0<Object, C4741z0> f12867a = new C4729y0<>("changed", false);

    /* renamed from: b */
    private boolean f12868b;

    C4741z0(boolean z) {
        if (z) {
            this.f12868b = C4698w1.m16348a(C4698w1.f12761a, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", false);
        } else {
            mo30041c();
        }
    }

    /* renamed from: a */
    public boolean mo30039a() {
        return this.f12868b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo30040b() {
        C4698w1.m16355b(C4698w1.f12761a, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", this.f12868b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo30041c() {
        m16457a(C4536k1.m15626a(C4564n1.f12495e));
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: d */
    public JSONObject mo30043d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enabled", this.f12868b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return mo30043d().toString();
    }

    /* renamed from: a */
    private void m16457a(boolean z) {
        boolean z2 = this.f12868b != z;
        this.f12868b = z;
        if (z2) {
            this.f12867a.mo30031c(this);
        }
    }
}
