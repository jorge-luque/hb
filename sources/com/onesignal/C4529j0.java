package com.onesignal;

import org.json.JSONObject;

/* renamed from: com.onesignal.j0 */
/* compiled from: OSEmailSubscriptionState */
public class C4529j0 implements Cloneable {

    /* renamed from: a */
    C4729y0<Object, C4529j0> f12378a = new C4729y0<>("changed", false);

    /* renamed from: b */
    private String f12379b;

    /* renamed from: c */
    private String f12380c;

    C4529j0(boolean z) {
        if (z) {
            this.f12379b = C4698w1.m16344a(C4698w1.f12761a, "PREFS_ONESIGNAL_EMAIL_ID_LAST", (String) null);
            this.f12380c = C4698w1.m16344a(C4698w1.f12761a, "PREFS_ONESIGNAL_EMAIL_ADDRESS_LAST", (String) null);
            return;
        }
        this.f12379b = C4564n1.m15878t();
        this.f12380c = C4742z1.m16462a().mo30002d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29799a(String str) {
        boolean z = true;
        if (str != null ? str.equals(this.f12379b) : this.f12379b == null) {
            z = false;
        }
        this.f12379b = str;
        if (z) {
            this.f12378a.mo30031c(this);
        }
    }

    /* renamed from: b */
    public JSONObject mo29801b() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f12379b != null) {
                jSONObject.put("emailUserId", this.f12379b);
            } else {
                jSONObject.put("emailUserId", JSONObject.NULL);
            }
            if (this.f12380c != null) {
                jSONObject.put("emailAddress", this.f12380c);
            } else {
                jSONObject.put("emailAddress", JSONObject.NULL);
            }
            jSONObject.put("subscribed", mo29800a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        return mo29801b().toString();
    }

    /* renamed from: a */
    public boolean mo29800a() {
        return (this.f12379b == null || this.f12380c == null) ? false : true;
    }
}
