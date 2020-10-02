package com.onesignal;

import com.onesignal.C4497e1;
import com.onesignal.C4564n1;
import com.onesignal.C4731y1;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: com.onesignal.d2 */
/* compiled from: OutcomeEventsController */
class C4487d2 {

    /* renamed from: a */
    private Set<String> f12303a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C4502e2 f12304b;

    /* renamed from: c */
    private final C4497e1 f12305c;

    /* renamed from: com.onesignal.d2$a */
    /* compiled from: OutcomeEventsController */
    class C4488a implements Runnable {
        C4488a() {
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            for (C4478b2 a : C4487d2.this.f12304b.mo29764a()) {
                C4487d2.this.m15462a(a);
            }
        }
    }

    /* renamed from: com.onesignal.d2$b */
    /* compiled from: OutcomeEventsController */
    class C4489b extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ C4478b2 f12307a;

        C4489b(C4478b2 b2Var) {
            this.f12307a = b2Var;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            super.mo29737a(str);
            C4487d2.this.f12304b.mo29766a(this.f12307a);
        }
    }

    /* renamed from: com.onesignal.d2$d */
    /* compiled from: OutcomeEventsController */
    class C4492d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ JSONArray f12316a;

        /* renamed from: b */
        final /* synthetic */ String f12317b;

        C4492d(JSONArray jSONArray, String str) {
            this.f12316a = jSONArray;
            this.f12317b = str;
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            C4487d2.this.f12304b.mo29768a(this.f12316a, this.f12317b);
        }
    }

    /* renamed from: com.onesignal.d2$e */
    /* compiled from: OutcomeEventsController */
    static /* synthetic */ class C4493e {

        /* renamed from: a */
        static final /* synthetic */ int[] f12319a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.onesignal.e1$a[] r0 = com.onesignal.C4497e1.C4498a.m15499f()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12319a = r0
                com.onesignal.e1$a r1 = com.onesignal.C4497e1.C4498a.DIRECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12319a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.e1$a r1 = com.onesignal.C4497e1.C4498a.INDIRECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12319a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.e1$a r1 = com.onesignal.C4497e1.C4498a.UNATTRIBUTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12319a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.onesignal.e1$a r1 = com.onesignal.C4497e1.C4498a.DISABLED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4487d2.C4493e.<clinit>():void");
        }
    }

    C4487d2(C4497e1 e1Var, C4655t1 t1Var) {
        this.f12304b = new C4502e2(t1Var);
        this.f12305c = e1Var;
        m15470c();
    }

    /* renamed from: c */
    private void m15470c() {
        this.f12303a = C4536k1.m15642k();
        Set<String> a = C4698w1.m16345a(C4698w1.f12761a, "PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT", (Set<String>) null);
        if (a != null) {
            this.f12303a.addAll(a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m15471d() {
        C4698w1.m16354b(C4698w1.f12761a, "PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT", this.f12303a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29742b() {
        new Thread(new C4488a(), "OS_SEND_SAVED_OUTCOMES").start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29739a() {
        this.f12303a = C4536k1.m15642k();
        m15471d();
    }

    /* renamed from: com.onesignal.d2$c */
    /* compiled from: OutcomeEventsController */
    class C4490c extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ C4497e1.C4498a f12309a;

        /* renamed from: b */
        final /* synthetic */ JSONArray f12310b;

        /* renamed from: c */
        final /* synthetic */ String f12311c;

        /* renamed from: d */
        final /* synthetic */ C4564n1.C4578g0 f12312d;

        /* renamed from: e */
        final /* synthetic */ C4478b2 f12313e;

        /* renamed from: com.onesignal.d2$c$a */
        /* compiled from: OutcomeEventsController */
        class C4491a implements Runnable {
            C4491a() {
            }

            public void run() {
                Thread.currentThread().setPriority(10);
                C4487d2.this.f12304b.mo29769b(C4490c.this.f12313e);
            }
        }

        C4490c(C4497e1.C4498a aVar, JSONArray jSONArray, String str, C4564n1.C4578g0 g0Var, C4478b2 b2Var) {
            this.f12309a = aVar;
            this.f12310b = jSONArray;
            this.f12311c = str;
            this.f12312d = g0Var;
            this.f12313e = b2Var;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            super.mo29737a(str);
            if (this.f12309a.mo29755a()) {
                C4487d2.this.m15468a(this.f12310b, this.f12311c);
            } else {
                C4487d2.this.m15471d();
            }
            C4564n1.C4578g0 g0Var = this.f12312d;
            if (g0Var != null) {
                g0Var.mo29867a(this.f12313e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            super.mo29736a(i, str, th);
            new Thread(new C4491a(), "OS_SAVE_OUTCOMES").start();
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.WARN;
            C4564n1.m15815b(a0Var, "Sending outcome with name: " + this.f12311c + " failed with status code: " + i + " and response: " + str + "\nOutcome event was cached and will be reattempted on app cold start");
            C4564n1.C4578g0 g0Var = this.f12312d;
            if (g0Var != null) {
                g0Var.mo29867a((C4478b2) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29740a(String str) {
        m15467a(str, this.f12305c.mo29750b(), C4497e1.C4498a.UNATTRIBUTED, (C4564n1.C4578g0) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29741a(String str, float f) {
        C4497e1.C4500c b = this.f12305c.mo29750b();
        m15466a(str, f, b.f12333b, b.f12332a, (C4564n1.C4578g0) null);
    }

    /* renamed from: a */
    private void m15467a(String str, C4497e1.C4500c cVar, C4497e1.C4498a aVar, C4564n1.C4578g0 g0Var) {
        C4497e1.C4498a aVar2 = cVar.f12332a;
        JSONArray jSONArray = cVar.f12333b;
        if (aVar.mo29755a()) {
            JSONArray a = m15461a(str, jSONArray);
            if (a == null) {
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
                C4564n1.m15789a(a0Var, "Measure endpoint will not send because unique outcome already sent for: \nSession: " + this.f12305c.mo29752d().toString() + "\nOutcome name: " + str + "\nnotificationIds: " + jSONArray);
                if (g0Var != null) {
                    g0Var.mo29867a((C4478b2) null);
                    return;
                }
                return;
            }
            m15466a(str, 0.0f, a, aVar2, g0Var);
        } else if (!aVar.mo29759e()) {
            C4564n1.m15789a(C4564n1.C4566a0.DEBUG, "Unique Outcome for current session is disabled");
        } else if (this.f12303a.contains(str)) {
            C4564n1.C4566a0 a0Var2 = C4564n1.C4566a0.DEBUG;
            C4564n1.m15789a(a0Var2, "Measure endpoint will not send because unique outcome already sent for: \nSession: " + this.f12305c.mo29752d().toString() + "\nOutcome name: " + str);
            if (g0Var != null) {
                g0Var.mo29867a((C4478b2) null);
            }
        } else {
            this.f12303a.add(str);
            m15466a(str, 0.0f, (JSONArray) null, aVar2, g0Var);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15462a(C4478b2 b2Var) {
        m15463a(b2Var, (C4731y1.C4738g) new C4489b(b2Var));
    }

    /* renamed from: a */
    private void m15466a(String str, float f, JSONArray jSONArray, C4497e1.C4498a aVar, C4564n1.C4578g0 g0Var) {
        C4478b2 b2Var = new C4478b2(aVar, jSONArray, str, System.currentTimeMillis() / 1000, f);
        m15463a(b2Var, (C4731y1.C4738g) new C4490c(aVar, jSONArray, str, g0Var, b2Var));
    }

    /* renamed from: a */
    private void m15463a(C4478b2 b2Var, C4731y1.C4738g gVar) {
        String str = C4564n1.f12493c;
        int c = new C4536k1().mo29827c();
        int i = C4493e.f12319a[b2Var.mo29725c().ordinal()];
        if (i == 1) {
            this.f12304b.mo29767a(str, c, b2Var, gVar);
        } else if (i == 2) {
            this.f12304b.mo29770b(str, c, b2Var, gVar);
        } else if (i == 3) {
            this.f12304b.mo29771c(str, c, b2Var, gVar);
        } else if (i == 4) {
            C4564n1.m15789a(C4564n1.C4566a0.VERBOSE, "Outcomes for current session are disabled");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15468a(JSONArray jSONArray, String str) {
        new Thread(new C4492d(jSONArray, str), "OS_SAVE_UNIQUE_OUTCOME_NOTIFICATIONS").start();
    }

    /* renamed from: a */
    private JSONArray m15461a(String str, JSONArray jSONArray) {
        JSONArray a = this.f12304b.mo29765a(str, jSONArray);
        if (a.length() == 0) {
            return null;
        }
        return a;
    }
}
