package com.onesignal;

import com.onesignal.C4564n1;
import com.vungle.warren.model.AdvertisementDBAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.n0 */
/* compiled from: OSInAppMessageDisplayStats */
class C4563n0 {

    /* renamed from: a */
    private long f12464a;

    /* renamed from: b */
    private int f12465b;

    /* renamed from: c */
    private int f12466c;

    /* renamed from: d */
    private long f12467d;

    /* renamed from: e */
    private boolean f12468e;

    C4563n0() {
        this.f12464a = -1;
        this.f12465b = 0;
        this.f12466c = Integer.MAX_VALUE;
        this.f12467d = 0;
        this.f12468e = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29852a(C4563n0 n0Var) {
        mo29851a(n0Var.mo29853b());
        mo29850a(n0Var.mo29849a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo29853b() {
        return this.f12464a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo29854c() {
        this.f12465b++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo29855d() {
        if (this.f12464a < 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = currentTimeMillis - this.f12464a;
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
        C4564n1.m15789a(a0Var, "OSInAppMessage lastDisplayTime: " + this.f12464a + " currentTimeInSeconds: " + currentTimeMillis + " diffInSeconds: " + j + " displayDelay: " + this.f12467d);
        if (j >= this.f12467d) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public boolean mo29856e() {
        return this.f12468e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo29857f() {
        return this.f12465b < this.f12466c;
    }

    public String toString() {
        return "OSInAppMessageDisplayStats{lastDisplayTime=" + this.f12464a + ", displayQuantity=" + this.f12465b + ", displayLimit=" + this.f12466c + ", displayDelay=" + this.f12467d + '}';
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29851a(long j) {
        this.f12464a = j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo29849a() {
        return this.f12465b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29850a(int i) {
        this.f12465b = i;
    }

    C4563n0(int i, long j) {
        this.f12464a = -1;
        this.f12465b = 0;
        this.f12466c = Integer.MAX_VALUE;
        this.f12467d = 0;
        this.f12468e = false;
        this.f12465b = i;
        this.f12464a = j;
    }

    C4563n0(JSONObject jSONObject) throws JSONException {
        this.f12464a = -1;
        this.f12465b = 0;
        this.f12466c = Integer.MAX_VALUE;
        this.f12467d = 0;
        this.f12468e = false;
        this.f12468e = true;
        Object obj = jSONObject.get("limit");
        Object obj2 = jSONObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY);
        if (obj instanceof Integer) {
            this.f12466c = ((Integer) obj).intValue();
        }
        if (obj2 instanceof Long) {
            this.f12467d = ((Long) obj2).longValue();
        } else if (obj2 instanceof Integer) {
            this.f12467d = (long) ((Integer) obj2).intValue();
        }
    }
}
