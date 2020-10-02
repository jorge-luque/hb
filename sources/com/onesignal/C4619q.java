package com.onesignal;

import android.os.SystemClock;
import com.onesignal.C4497e1;
import com.onesignal.C4564n1;
import com.onesignal.C4731y1;
import com.tapjoy.TapjoyConstants;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.q */
/* compiled from: FocusTimeController */
class C4619q {

    /* renamed from: c */
    private static C4619q f12605c;

    /* renamed from: a */
    private Long f12606a;

    /* renamed from: b */
    private List<C4623d> f12607b = Arrays.asList(new C4623d[]{new C4625e(), new C4622c()});

    /* renamed from: com.onesignal.q$b */
    /* compiled from: FocusTimeController */
    private enum C4621b {
        BACKGROUND,
        END_SESSION;

        static {
            BACKGROUND = new C4621b("BACKGROUND", 0);
            END_SESSION = new C4621b("END_SESSION", 1);
        }
    }

    /* renamed from: com.onesignal.q$c */
    /* compiled from: FocusTimeController */
    private static class C4622c extends C4623d {
        C4622c() {
            super();
            this.f12610a = 1;
            this.f12611b = "OS_UNSENT_ATTRIBUTED_ACTIVE_TIME";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo29916a(C4497e1.C4498a aVar) {
            return aVar.mo29755a();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo29915a(JSONObject jSONObject) {
            C4564n1.m15755E().mo29749a(jSONObject);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo29914a(C4621b bVar) {
            if (bVar.equals(C4621b.END_SESSION)) {
                mo29917a();
            } else {
                C4469a2.m15414c(C4564n1.f12495e);
            }
        }
    }

    /* renamed from: com.onesignal.q$e */
    /* compiled from: FocusTimeController */
    private static class C4625e extends C4623d {
        C4625e() {
            super();
            this.f12610a = 60;
            this.f12611b = "GT_UNSENT_ACTIVE_TIME";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo29916a(C4497e1.C4498a aVar) {
            return aVar.mo29759e() || aVar.mo29757c();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo29914a(C4621b bVar) {
            if (!bVar.equals(C4621b.END_SESSION)) {
                mo29918b();
            }
        }
    }

    private C4619q() {
    }

    /* renamed from: d */
    public static synchronized C4619q m15979d() {
        C4619q qVar;
        synchronized (C4619q.class) {
            if (f12605c == null) {
                f12605c = new C4619q();
            }
            qVar = f12605c;
        }
        return qVar;
    }

    /* renamed from: e */
    private Long m15980e() {
        if (this.f12606a == null) {
            return null;
        }
        double elapsedRealtime = (double) (SystemClock.elapsedRealtime() - this.f12606a.longValue());
        Double.isNaN(elapsedRealtime);
        long j = (long) ((elapsedRealtime / 1000.0d) + 0.5d);
        if (j < 1 || j > 86400) {
            return null;
        }
        return Long.valueOf(j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29910a() {
        m15978a(C4564n1.m15755E().mo29753e(), C4621b.BACKGROUND);
        this.f12606a = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29912b() {
        this.f12606a = Long.valueOf(SystemClock.elapsedRealtime());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo29913c() {
        if (!C4564n1.m15770T()) {
            for (C4623d a : this.f12607b) {
                a.m16000e();
            }
        }
    }

    /* renamed from: com.onesignal.q$d */
    /* compiled from: FocusTimeController */
    private static abstract class C4623d {

        /* renamed from: a */
        protected long f12610a;

        /* renamed from: b */
        protected String f12611b;

        /* renamed from: c */
        private Long f12612c;

        /* renamed from: d */
        private final AtomicBoolean f12613d;

        /* renamed from: com.onesignal.q$d$a */
        /* compiled from: FocusTimeController */
        class C4624a extends C4731y1.C4738g {
            C4624a() {
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo29736a(int i, String str, Throwable th) {
                C4564n1.m15796a("sending on_focus Failed", i, th, str);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo29737a(String str) {
                C4623d.this.m15995b(0);
            }
        }

        private C4623d() {
            this.f12612c = null;
            this.f12613d = new AtomicBoolean();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m15995b(long j) {
            this.f12612c = Long.valueOf(j);
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15789a(a0Var, getClass().getSimpleName() + ":saveUnsentActiveTime: " + this.f12612c);
            C4698w1.m16352b(C4698w1.f12761a, this.f12611b, j);
        }

        /* renamed from: c */
        private long m15997c() {
            if (this.f12612c == null) {
                this.f12612c = Long.valueOf(C4698w1.m16341a(C4698w1.f12761a, this.f12611b, 0));
            }
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15789a(a0Var, getClass().getSimpleName() + ":getUnsentActiveTime: " + this.f12612c);
            return this.f12612c.longValue();
        }

        /* renamed from: d */
        private boolean m15999d() {
            return m15997c() >= this.f12610a;
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void m16000e() {
            if (m15999d()) {
                mo29917a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo29914a(C4621b bVar);

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo29915a(JSONObject jSONObject) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract boolean mo29916a(C4497e1.C4498a aVar);

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m15996b(C4621b bVar) {
            if (C4564n1.m15766P()) {
                mo29914a(bVar);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m15989a(long j, C4497e1.C4498a aVar, C4621b bVar) {
            if (mo29916a(aVar)) {
                m15995b(m15997c() + j);
                m15996b(bVar);
            }
        }

        /* renamed from: c */
        private void m15998c(long j) {
            try {
                JSONObject a = m15988a(j);
                mo29915a(a);
                m15994a(C4564n1.m15759I(), a);
                if (C4564n1.m15765O()) {
                    m15994a(C4564n1.m15878t(), m15988a(j));
                }
            } catch (JSONException e) {
                C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating on_focus:JSON Failed.", (Throwable) e);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo29918b() {
            if (m15999d()) {
                C4469a2.m15414c(C4564n1.f12495e);
                mo29917a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo29917a() {
            if (!this.f12613d.get()) {
                synchronized (this.f12613d) {
                    this.f12613d.set(true);
                    if (m15999d()) {
                        m15998c(m15997c());
                    }
                    this.f12613d.set(false);
                }
            }
        }

        /* renamed from: a */
        private void m15994a(String str, JSONObject jSONObject) {
            C4624a aVar = new C4624a();
            C4731y1.m16449b("players/" + str + "/on_focus", jSONObject, (C4731y1.C4738g) aVar);
        }

        /* renamed from: a */
        private JSONObject m15988a(long j) throws JSONException {
            JSONObject put = new JSONObject().put("app_id", C4564n1.m15753C()).put("type", 1).put("state", "ping").put("active_time", j).put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, new C4536k1().mo29827c());
            C4564n1.m15800a(put);
            return put;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29911a(C4497e1.C4500c cVar) {
        C4621b bVar = C4621b.END_SESSION;
        if (!m15978a(cVar, bVar)) {
            for (C4623d a : this.f12607b) {
                a.m15996b(bVar);
            }
        }
    }

    /* renamed from: a */
    private boolean m15978a(C4497e1.C4500c cVar, C4621b bVar) {
        Long e = m15980e();
        if (e == null) {
            return false;
        }
        for (C4623d a : this.f12607b) {
            a.m15989a(e.longValue(), cVar.f12332a, bVar);
        }
        return true;
    }
}
