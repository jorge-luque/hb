package com.onesignal;

import org.json.JSONException;
import org.json.JSONObject;

public class OSSubscriptionState implements Cloneable {

    /* renamed from: a */
    C4729y0<Object, OSSubscriptionState> f12244a = new C4729y0<>("changed", false);

    /* renamed from: b */
    private boolean f12245b;

    /* renamed from: c */
    private boolean f12246c;

    /* renamed from: d */
    private String f12247d;

    /* renamed from: e */
    private String f12248e;

    OSSubscriptionState(boolean z, boolean z2) {
        if (z) {
            this.f12246c = C4698w1.m16348a(C4698w1.f12761a, "ONESIGNAL_SUBSCRIPTION_LAST", false);
            this.f12247d = C4698w1.m16344a(C4698w1.f12761a, "ONESIGNAL_PLAYER_ID_LAST", (String) null);
            this.f12248e = C4698w1.m16344a(C4698w1.f12761a, "ONESIGNAL_PUSH_TOKEN_LAST", (String) null);
            this.f12245b = C4698w1.m16348a(C4698w1.f12761a, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", false);
            return;
        }
        this.f12246c = C4742z1.m16476f();
        this.f12247d = C4564n1.m15759I();
        this.f12248e = C4742z1.m16470c();
        this.f12245b = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29668a(String str) {
        if (str != null) {
            boolean z = !str.equals(this.f12248e);
            this.f12248e = str;
            if (z) {
                this.f12244a.mo30031c(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29671b(String str) {
        boolean z = true;
        if (str != null ? str.equals(this.f12247d) : this.f12247d == null) {
            z = false;
        }
        this.f12247d = str;
        if (z) {
            this.f12244a.mo30031c(this);
        }
    }

    /* renamed from: c */
    public String mo29673c() {
        return this.f12247d;
    }

    /* access modifiers changed from: package-private */
    public void changed(C4741z0 z0Var) {
        m15356b(z0Var.mo30039a());
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo29676d() {
        C4698w1.m16355b(C4698w1.f12761a, "ONESIGNAL_SUBSCRIPTION_LAST", this.f12246c);
        C4698w1.m16353b(C4698w1.f12761a, "ONESIGNAL_PLAYER_ID_LAST", this.f12247d);
        C4698w1.m16353b(C4698w1.f12761a, "ONESIGNAL_PUSH_TOKEN_LAST", this.f12248e);
        C4698w1.m16355b(C4698w1.f12761a, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", this.f12245b);
    }

    /* renamed from: e */
    public JSONObject mo29677e() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f12247d != null) {
                jSONObject.put("userId", this.f12247d);
            } else {
                jSONObject.put("userId", JSONObject.NULL);
            }
            if (this.f12248e != null) {
                jSONObject.put("pushToken", this.f12248e);
            } else {
                jSONObject.put("pushToken", JSONObject.NULL);
            }
            jSONObject.put("userSubscriptionSetting", this.f12246c);
            jSONObject.put("subscribed", mo29672b());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return mo29677e().toString();
    }

    /* renamed from: a */
    public String mo29667a() {
        return this.f12248e;
    }

    /* renamed from: b */
    private void m15356b(boolean z) {
        boolean b = mo29672b();
        this.f12245b = z;
        if (b != mo29672b()) {
            this.f12244a.mo30031c(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29669a(boolean z) {
        boolean z2 = this.f12246c != z;
        this.f12246c = z;
        if (z2) {
            this.f12244a.mo30031c(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo29670a(OSSubscriptionState oSSubscriptionState) {
        if (this.f12246c == oSSubscriptionState.f12246c) {
            String str = this.f12247d;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            String str3 = oSSubscriptionState.f12247d;
            if (str3 == null) {
                str3 = str2;
            }
            if (str.equals(str3)) {
                String str4 = this.f12248e;
                if (str4 == null) {
                    str4 = str2;
                }
                String str5 = oSSubscriptionState.f12248e;
                if (str5 != null) {
                    str2 = str5;
                }
                return !str4.equals(str2) || this.f12245b != oSSubscriptionState.f12245b;
            }
        }
    }

    /* renamed from: b */
    public boolean mo29672b() {
        return this.f12247d != null && this.f12248e != null && this.f12246c && this.f12245b;
    }
}
