package com.onesignal;

import com.onesignal.C4686w;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.q2 */
/* compiled from: UserState */
abstract class C4629q2 {

    /* renamed from: d */
    private static final String[] f12620d = {"lat", "long", "loc_acc", "loc_type", "loc_bg", "loc_time_stamp", "ad_id"};

    /* renamed from: e */
    private static final Set<String> f12621e = new HashSet(Arrays.asList(f12620d));

    /* renamed from: f */
    private static final Object f12622f = new C4630a();

    /* renamed from: a */
    private String f12623a;

    /* renamed from: b */
    JSONObject f12624b;

    /* renamed from: c */
    JSONObject f12625c;

    /* renamed from: com.onesignal.q2$a */
    /* compiled from: UserState */
    static class C4630a {
        C4630a() {
        }
    }

    C4629q2(String str, boolean z) {
        this.f12623a = str;
        if (z) {
            m16020d();
            return;
        }
        this.f12624b = new JSONObject();
        this.f12625c = new JSONObject();
    }

    /* renamed from: d */
    private void m16020d() {
        int i;
        boolean z;
        String str = C4698w1.f12761a;
        String a = C4698w1.m16344a(str, "ONESIGNAL_USERSTATE_DEPENDVALYES_" + this.f12623a, (String) null);
        if (a == null) {
            this.f12624b = new JSONObject();
            try {
                int i2 = 1;
                if (this.f12623a.equals("CURRENT_STATE")) {
                    i = C4698w1.m16340a(C4698w1.f12761a, "ONESIGNAL_SUBSCRIPTION", 1);
                } else {
                    i = C4698w1.m16340a(C4698w1.f12761a, "ONESIGNAL_SYNCED_SUBSCRIPTION", 1);
                }
                if (i == -2) {
                    z = false;
                } else {
                    i2 = i;
                    z = true;
                }
                this.f12624b.put("subscribableStatus", i2);
                this.f12624b.put("userSubscribePref", z);
            } catch (JSONException unused) {
            }
        } else {
            try {
                this.f12624b = new JSONObject(a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String str2 = C4698w1.f12761a;
        String a2 = C4698w1.m16344a(str2, "ONESIGNAL_USERSTATE_SYNCVALYES_" + this.f12623a, (String) null);
        if (a2 == null) {
            try {
                this.f12625c = new JSONObject();
                this.f12625c.put("identifier", C4698w1.m16344a(C4698w1.f12761a, "GT_REGISTRATION_ID", (String) null));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            this.f12625c = new JSONObject(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C4629q2 mo29924a(String str) {
        C4629q2 b = mo29929b(str);
        try {
            b.f12624b = new JSONObject(this.f12624b.toString());
            b.f12625c = new JSONObject(this.f12625c.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo29926a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract C4629q2 mo29929b(String str);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29930b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            JSONObject jSONObject3 = this.f12624b;
            m16019a(jSONObject3, jSONObject, jSONObject3, (Set<String>) null);
        }
        if (jSONObject2 != null) {
            JSONObject jSONObject4 = this.f12625c;
            m16019a(jSONObject4, jSONObject2, jSONObject4, (Set<String>) null);
            mo29928a(jSONObject2, (JSONObject) null);
        }
        if (jSONObject != null || jSONObject2 != null) {
            mo29932c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo29931b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo29932c() {
        synchronized (f12622f) {
            String str = C4698w1.f12761a;
            C4698w1.m16353b(str, "ONESIGNAL_USERSTATE_SYNCVALYES_" + this.f12623a, this.f12625c.toString());
            String str2 = C4698w1.f12761a;
            C4698w1.m16353b(str2, "ONESIGNAL_USERSTATE_DEPENDVALYES_" + this.f12623a, this.f12624b.toString());
        }
    }

    /* renamed from: a */
    private Set<String> m16018a(C4629q2 q2Var) {
        try {
            if (this.f12624b.optLong("loc_time_stamp") == q2Var.f12624b.getLong("loc_time_stamp")) {
                return null;
            }
            q2Var.f12625c.put("loc_bg", q2Var.f12624b.opt("loc_bg"));
            q2Var.f12625c.put("loc_time_stamp", q2Var.f12624b.opt("loc_time_stamp"));
            return f12621e;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29927a(C4686w.C4693g gVar) {
        try {
            this.f12625c.put("lat", gVar.f12749a);
            this.f12625c.put("long", gVar.f12750b);
            this.f12625c.put("loc_acc", gVar.f12751c);
            this.f12625c.put("loc_type", gVar.f12752d);
            this.f12624b.put("loc_bg", gVar.f12753e);
            this.f12624b.put("loc_time_stamp", gVar.f12754f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo29925a(C4629q2 q2Var, boolean z) {
        mo29926a();
        q2Var.mo29926a();
        JSONObject a = m16019a(this.f12625c, q2Var.f12625c, (JSONObject) null, m16018a(q2Var));
        if (!z && a.toString().equals("{}")) {
            return null;
        }
        try {
            if (!a.has("app_id")) {
                a.put("app_id", this.f12625c.optString("app_id"));
            }
            if (this.f12625c.has("email_auth_hash")) {
                a.put("email_auth_hash", this.f12625c.optString("email_auth_hash"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0023 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007f */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo29928a(org.json.JSONObject r7, org.json.JSONObject r8) {
        /*
            r6 = this;
            java.lang.Object r0 = f12622f
            monitor-enter(r0)
            java.lang.String r1 = "tags"
            boolean r1 = r7.has(r1)     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x007f
            org.json.JSONObject r1 = r6.f12625c     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "tags"
            boolean r1 = r1.has(r2)     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0029
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0023 }
            org.json.JSONObject r2 = r6.f12625c     // Catch:{ JSONException -> 0x0023 }
            java.lang.String r3 = "tags"
            java.lang.String r2 = r2.optString(r3)     // Catch:{ JSONException -> 0x0023 }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x0023 }
            goto L_0x002e
        L_0x0023:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0081 }
            r1.<init>()     // Catch:{ all -> 0x0081 }
            goto L_0x002e
        L_0x0029:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0081 }
            r1.<init>()     // Catch:{ all -> 0x0081 }
        L_0x002e:
            java.lang.String r2 = "tags"
            org.json.JSONObject r7 = r7.optJSONObject(r2)     // Catch:{ all -> 0x0081 }
            java.util.Iterator r2 = r7.keys()     // Catch:{ all -> 0x0081 }
        L_0x0038:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x007f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x007f }
            java.lang.String r4 = ""
            java.lang.String r5 = r7.optString(r3)     // Catch:{ all -> 0x007f }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x007f }
            if (r4 == 0) goto L_0x0054
            r1.remove(r3)     // Catch:{ all -> 0x007f }
            goto L_0x0038
        L_0x0054:
            if (r8 == 0) goto L_0x005c
            boolean r4 = r8.has(r3)     // Catch:{ all -> 0x007f }
            if (r4 != 0) goto L_0x0038
        L_0x005c:
            java.lang.String r4 = r7.optString(r3)     // Catch:{ all -> 0x007f }
            r1.put(r3, r4)     // Catch:{ all -> 0x007f }
            goto L_0x0038
        L_0x0064:
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x007f }
            java.lang.String r8 = "{}"
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x007f }
            if (r7 == 0) goto L_0x0078
            org.json.JSONObject r7 = r6.f12625c     // Catch:{ all -> 0x007f }
            java.lang.String r8 = "tags"
            r7.remove(r8)     // Catch:{ all -> 0x007f }
            goto L_0x007f
        L_0x0078:
            org.json.JSONObject r7 = r6.f12625c     // Catch:{ all -> 0x007f }
            java.lang.String r8 = "tags"
            r7.put(r8, r1)     // Catch:{ all -> 0x007f }
        L_0x007f:
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            return
        L_0x0081:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            goto L_0x0085
        L_0x0084:
            throw r7
        L_0x0085:
            goto L_0x0084
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4629q2.mo29928a(org.json.JSONObject, org.json.JSONObject):void");
    }

    /* renamed from: a */
    private static JSONObject m16019a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        JSONObject a;
        synchronized (f12622f) {
            a = C4673v.m16247a(jSONObject, jSONObject2, jSONObject3, set);
        }
        return a;
    }
}
