package com.onesignal;

import org.json.JSONException;

/* renamed from: com.onesignal.t2 */
/* compiled from: UserStatePush */
class C4656t2 extends C4629q2 {
    C4656t2(String str, boolean z) {
        super(str, z);
    }

    /* renamed from: d */
    private int m16171d() {
        int optInt = this.f12624b.optInt("subscribableStatus", 1);
        if (optInt < -2) {
            return optInt;
        }
        if (!this.f12624b.optBoolean("androidPermission", true)) {
            return 0;
        }
        return !this.f12624b.optBoolean("userSubscribePref", true) ? -2 : 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29926a() {
        try {
            this.f12625c.put("notification_types", m16171d());
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C4629q2 mo29929b(String str) {
        return new C4656t2(str, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo29931b() {
        return m16171d() > 0;
    }
}
