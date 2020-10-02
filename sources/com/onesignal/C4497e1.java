package com.onesignal;

import com.onesignal.C4564n1;
import com.tapjoy.TapjoyConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.e1 */
/* compiled from: OSSessionManager */
class C4497e1 {

    /* renamed from: a */
    protected C4498a f12323a;

    /* renamed from: b */
    private String f12324b;

    /* renamed from: c */
    private JSONArray f12325c;

    /* renamed from: d */
    private C4499b f12326d;

    /* renamed from: com.onesignal.e1$a */
    /* compiled from: OSSessionManager */
    public enum C4498a {
        DIRECT,
        INDIRECT,
        UNATTRIBUTED,
        DISABLED;

        /* renamed from: f */
        public static C4498a[] m15499f() {
            return (C4498a[]) f12331e.clone();
        }

        /* renamed from: a */
        public boolean mo29755a() {
            return mo29756b() || mo29758d();
        }

        /* renamed from: b */
        public boolean mo29756b() {
            return equals(DIRECT);
        }

        /* renamed from: c */
        public boolean mo29757c() {
            return equals(DISABLED);
        }

        /* renamed from: d */
        public boolean mo29758d() {
            return equals(INDIRECT);
        }

        /* renamed from: e */
        public boolean mo29759e() {
            return equals(UNATTRIBUTED);
        }

        /* renamed from: a */
        public static C4498a m15498a(String str) {
            if (str == null || str.isEmpty()) {
                return UNATTRIBUTED;
            }
            for (C4498a aVar : m15499f()) {
                if (aVar.name().equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return UNATTRIBUTED;
        }
    }

    /* renamed from: com.onesignal.e1$b */
    /* compiled from: OSSessionManager */
    interface C4499b {
        /* renamed from: a */
        void mo29760a(C4500c cVar);
    }

    /* renamed from: com.onesignal.e1$c */
    /* compiled from: OSSessionManager */
    public static class C4500c {

        /* renamed from: a */
        C4498a f12332a;

        /* renamed from: b */
        JSONArray f12333b;

        /* renamed from: com.onesignal.e1$c$a */
        /* compiled from: OSSessionManager */
        public static class C4501a {
            /* access modifiers changed from: private */

            /* renamed from: a */
            public JSONArray f12334a;
            /* access modifiers changed from: private */

            /* renamed from: b */
            public C4498a f12335b;

            private C4501a() {
            }

            /* renamed from: b */
            public static C4501a m15508b() {
                return new C4501a();
            }

            /* renamed from: a */
            public C4501a mo29762a(JSONArray jSONArray) {
                this.f12334a = jSONArray;
                return this;
            }

            /* renamed from: a */
            public C4501a mo29761a(C4498a aVar) {
                this.f12335b = aVar;
                return this;
            }

            /* renamed from: a */
            public C4500c mo29763a() {
                return new C4500c(this);
            }
        }

        C4500c(C4501a aVar) {
            this.f12333b = aVar.f12334a;
            this.f12332a = aVar.f12335b;
        }
    }

    public C4497e1(C4499b bVar) {
        this.f12326d = bVar;
        m15489g();
    }

    /* renamed from: b */
    private boolean m15488b(C4498a aVar, String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        String str2;
        if (!aVar.equals(this.f12323a)) {
            return true;
        }
        if (this.f12323a.mo29756b() && (str2 = this.f12324b) != null && !str2.equals(str)) {
            return true;
        }
        if (!this.f12323a.mo29758d() || (jSONArray2 = this.f12325c) == null || jSONArray2.length() <= 0 || C4673v.m16249a(this.f12325c, jSONArray)) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    private void m15489g() {
        C4498a b = C4513g2.m15542b();
        this.f12323a = b;
        if (b.mo29758d()) {
            this.f12325c = mo29751c();
        } else if (this.f12323a.mo29756b()) {
            this.f12324b = C4513g2.m15538a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29749a(JSONObject jSONObject) {
        if (!this.f12323a.mo29759e()) {
            try {
                if (this.f12323a.mo29756b()) {
                    jSONObject.put("direct", true);
                    jSONObject.put("notification_ids", new JSONArray().put(this.f12324b));
                } else if (this.f12323a.mo29758d()) {
                    jSONObject.put("direct", false);
                    jSONObject.put("notification_ids", this.f12325c);
                }
            } catch (JSONException e) {
                C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating addNotificationId:JSON Failed.", (Throwable) e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public JSONArray mo29751c() {
        JSONArray d = C4513g2.m15545d();
        JSONArray jSONArray = new JSONArray();
        long c = ((long) (C4513g2.m15544c() * 60)) * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < d.length(); i++) {
            try {
                JSONObject jSONObject = d.getJSONObject(i);
                if (currentTimeMillis - jSONObject.getLong("time") <= c) {
                    jSONArray.put(jSONObject.getString(TapjoyConstants.TJC_NOTIFICATION_ID));
                }
            } catch (JSONException e) {
                C4564n1.m15790a(C4564n1.C4566a0.ERROR, "From getting notification from array:JSON Failed.", (Throwable) e);
            }
        }
        return jSONArray;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C4498a mo29752d() {
        return this.f12323a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C4500c mo29753e() {
        if (this.f12323a.mo29756b()) {
            if (C4513g2.m15547f()) {
                JSONArray put = new JSONArray().put(this.f12324b);
                C4500c.C4501a b = C4500c.C4501a.m15508b();
                b.mo29762a(put);
                b.mo29761a(C4498a.DIRECT);
                return b.mo29763a();
            }
        } else if (this.f12323a.mo29758d()) {
            if (C4513g2.m15548g()) {
                C4500c.C4501a b2 = C4500c.C4501a.m15508b();
                b2.mo29762a(this.f12325c);
                b2.mo29761a(C4498a.INDIRECT);
                return b2.mo29763a();
            }
        } else if (C4513g2.m15549h()) {
            C4500c.C4501a b3 = C4500c.C4501a.m15508b();
            b3.mo29761a(C4498a.UNATTRIBUTED);
            return b3.mo29763a();
        }
        C4500c.C4501a b4 = C4500c.C4501a.m15508b();
        b4.mo29761a(C4498a.DISABLED);
        return b4.mo29763a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo29754f() {
        if (!C4564n1.m15875q().mo29878b()) {
            JSONArray c = mo29751c();
            if (c.length() > 0) {
                m15487a(C4498a.INDIRECT, (String) null, c);
            } else {
                m15487a(C4498a.UNATTRIBUTED, (String) null, (JSONArray) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C4500c mo29750b() {
        if (C4513g2.m15549h()) {
            C4500c.C4501a b = C4500c.C4501a.m15508b();
            b.mo29761a(C4498a.UNATTRIBUTED);
            return b.mo29763a();
        }
        C4500c.C4501a b2 = C4500c.C4501a.m15508b();
        b2.mo29761a(C4498a.DISABLED);
        return b2.mo29763a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29748a(String str) {
        m15487a(C4498a.DIRECT, str, (JSONArray) null);
    }

    /* renamed from: a */
    private void m15487a(C4498a aVar, String str, JSONArray jSONArray) {
        if (m15488b(aVar, str, jSONArray)) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15789a(a0Var, "OSSession changed\nfrom:\nsession: " + this.f12323a + ", directNotificationId: " + this.f12324b + ", indirectNotificationIds: " + this.f12325c + "\nto:\nsession: " + aVar + ", directNotificationId: " + str + ", indirectNotificationIds: " + jSONArray);
            C4513g2.m15539a(aVar);
            C4513g2.m15541a(str);
            this.f12326d.mo29760a(mo29753e());
            this.f12323a = aVar;
            this.f12324b = str;
            this.f12325c = jSONArray;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29747a() {
        if (C4564n1.m15875q().mo29878b()) {
            m15487a(C4498a.DIRECT, this.f12324b, (JSONArray) null);
        } else if (this.f12323a.mo29759e()) {
            JSONArray c = mo29751c();
            if (c.length() > 0 && C4564n1.m15875q().mo29877a()) {
                m15487a(C4498a.INDIRECT, (String) null, c);
            }
        }
    }
}
