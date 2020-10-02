package com.onesignal;

import com.onesignal.C4497e1;
import com.onesignal.C4564n1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.b2 */
/* compiled from: OutcomeEvent */
public class C4478b2 {

    /* renamed from: a */
    private C4497e1.C4498a f12294a;

    /* renamed from: b */
    private JSONArray f12295b;

    /* renamed from: c */
    private String f12296c;

    /* renamed from: d */
    private long f12297d;

    /* renamed from: e */
    private Float f12298e;

    public C4478b2(C4497e1.C4498a aVar, JSONArray jSONArray, String str, long j, float f) {
        this.f12294a = aVar;
        this.f12295b = jSONArray;
        this.f12296c = str;
        this.f12297d = j;
        this.f12298e = Float.valueOf(f);
    }

    /* renamed from: a */
    public String mo29723a() {
        return this.f12296c;
    }

    /* renamed from: b */
    public JSONArray mo29724b() {
        return this.f12295b;
    }

    /* renamed from: c */
    public C4497e1.C4498a mo29725c() {
        return this.f12294a;
    }

    /* renamed from: d */
    public long mo29726d() {
        return this.f12297d;
    }

    /* renamed from: e */
    public float mo29727e() {
        return this.f12298e.floatValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4478b2.class != obj.getClass()) {
            return false;
        }
        C4478b2 b2Var = (C4478b2) obj;
        if (!this.f12294a.equals(b2Var.f12294a) || !this.f12295b.equals(b2Var.f12295b) || !this.f12296c.equals(b2Var.f12296c) || this.f12297d != b2Var.f12297d || !this.f12298e.equals(b2Var.f12298e)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public JSONObject mo29729f() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f12295b != null && this.f12295b.length() > 0) {
                jSONObject.put("notification_ids", this.f12295b);
            }
            jSONObject.put("id", this.f12296c);
            if (this.f12298e.floatValue() > 0.0f) {
                jSONObject.put("weight", this.f12298e);
            }
        } catch (JSONException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating OutcomeEvent toJSONObject ", (Throwable) e);
        }
        return jSONObject;
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        Object[] objArr = {this.f12294a, this.f12295b, this.f12296c, Long.valueOf(this.f12297d), this.f12298e};
        for (int i3 = 0; i3 < 5; i3++) {
            Object obj = objArr[i3];
            int i4 = i2 * 31;
            if (obj == null) {
                i = 0;
            } else {
                i = obj.hashCode();
            }
            i2 = i4 + i;
        }
        return i2;
    }

    public String toString() {
        return "OutcomeEvent{session=" + this.f12294a + ", notificationIds=" + this.f12295b + ", name='" + this.f12296c + '\'' + ", timestamp=" + this.f12297d + ", weight=" + this.f12298e + '}';
    }
}
