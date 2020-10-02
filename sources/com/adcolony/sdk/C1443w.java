package com.adcolony.sdk;

import android.util.Log;
import com.applovin.sdk.AppLovinEventTypes;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.w */
class C1443w {

    /* renamed from: e */
    static boolean f4529e = false;

    /* renamed from: f */
    private static final int f4530f = 4000;

    /* renamed from: g */
    private static final int f4531g = 4;

    /* renamed from: h */
    static final int f4532h = 3;

    /* renamed from: i */
    static final int f4533i = 2;

    /* renamed from: j */
    static final int f4534j = 1;

    /* renamed from: k */
    static final int f4535k = 0;

    /* renamed from: l */
    static final int f4536l = -1;

    /* renamed from: m */
    static int f4537m = 3;

    /* renamed from: n */
    static int f4538n = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public JSONObject f4539a = C1437s.m5599b();

    /* renamed from: b */
    private ExecutorService f4540b = null;

    /* renamed from: c */
    private final Queue<Runnable> f4541c = new ConcurrentLinkedQueue();

    /* renamed from: d */
    C1282e0 f4542d;

    /* renamed from: com.adcolony.sdk.w$a */
    class C1444a implements C1458z {
        C1444a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1443w.this.mo6823b(C1437s.m5611f(xVar.mo6830b(), "module"), 0, C1437s.m5613h(xVar.mo6830b(), "message"), true);
        }
    }

    /* renamed from: com.adcolony.sdk.w$b */
    class C1445b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f4544a;

        /* renamed from: b */
        final /* synthetic */ String f4545b;

        /* renamed from: c */
        final /* synthetic */ int f4546c;

        /* renamed from: d */
        final /* synthetic */ boolean f4547d;

        C1445b(int i, String str, int i2, boolean z) {
            this.f4544a = i;
            this.f4545b = str;
            this.f4546c = i2;
            this.f4547d = z;
        }

        public void run() {
            C1443w.this.m5643a(this.f4544a, this.f4545b, this.f4546c);
            int i = 0;
            while (i <= this.f4545b.length() / 4000) {
                int i2 = i * 4000;
                i++;
                int min = Math.min(i * 4000, this.f4545b.length());
                if (this.f4546c == 3) {
                    C1443w wVar = C1443w.this;
                    if (wVar.mo6821a(C1437s.m5612g(wVar.f4539a, Integer.toString(this.f4544a)), 3, this.f4547d)) {
                        this.f4545b.substring(i2, min);
                    }
                }
                if (this.f4546c == 2) {
                    C1443w wVar2 = C1443w.this;
                    if (wVar2.mo6821a(C1437s.m5612g(wVar2.f4539a, Integer.toString(this.f4544a)), 2, this.f4547d)) {
                        this.f4545b.substring(i2, min);
                    }
                }
                if (this.f4546c == 1) {
                    C1443w wVar3 = C1443w.this;
                    if (wVar3.mo6821a(C1437s.m5612g(wVar3.f4539a, Integer.toString(this.f4544a)), 1, this.f4547d)) {
                        Log.w("AdColony [WARNING]", this.f4545b.substring(i2, min));
                    }
                }
                if (this.f4546c == 0) {
                    C1443w wVar4 = C1443w.this;
                    if (wVar4.mo6821a(C1437s.m5612g(wVar4.f4539a, Integer.toString(this.f4544a)), 0, this.f4547d)) {
                        Log.e("AdColony [ERROR]", this.f4545b.substring(i2, min));
                    }
                }
                if (this.f4546c == -1 && C1443w.f4537m >= -1) {
                    Log.e("AdColony [FATAL]", this.f4545b.substring(i2, min));
                }
            }
        }
    }

    /* renamed from: com.adcolony.sdk.w$c */
    class C1446c implements C1458z {
        C1446c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1443w.f4537m = C1437s.m5611f(xVar.mo6830b(), AppLovinEventTypes.USER_COMPLETED_LEVEL);
        }
    }

    /* renamed from: com.adcolony.sdk.w$d */
    class C1447d implements C1458z {
        C1447d() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1443w.this.mo6823b(C1437s.m5611f(xVar.mo6830b(), "module"), 3, C1437s.m5613h(xVar.mo6830b(), "message"), false);
        }
    }

    /* renamed from: com.adcolony.sdk.w$e */
    class C1448e implements C1458z {
        C1448e() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1443w.this.mo6823b(C1437s.m5611f(xVar.mo6830b(), "module"), 3, C1437s.m5613h(xVar.mo6830b(), "message"), true);
        }
    }

    /* renamed from: com.adcolony.sdk.w$f */
    class C1449f implements C1458z {
        C1449f() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1443w.this.mo6823b(C1437s.m5611f(xVar.mo6830b(), "module"), 2, C1437s.m5613h(xVar.mo6830b(), "message"), false);
        }
    }

    /* renamed from: com.adcolony.sdk.w$g */
    class C1450g implements C1458z {
        C1450g() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1443w.this.mo6823b(C1437s.m5611f(xVar.mo6830b(), "module"), 2, C1437s.m5613h(xVar.mo6830b(), "message"), true);
        }
    }

    /* renamed from: com.adcolony.sdk.w$h */
    class C1451h implements C1458z {
        C1451h() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1443w.this.mo6823b(C1437s.m5611f(xVar.mo6830b(), "module"), 1, C1437s.m5613h(xVar.mo6830b(), "message"), false);
        }
    }

    /* renamed from: com.adcolony.sdk.w$i */
    class C1452i implements C1458z {
        C1452i() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1443w.this.mo6823b(C1437s.m5611f(xVar.mo6830b(), "module"), 1, C1437s.m5613h(xVar.mo6830b(), "message"), true);
        }
    }

    /* renamed from: com.adcolony.sdk.w$j */
    class C1453j implements C1458z {
        C1453j() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1443w.this.mo6823b(C1437s.m5611f(xVar.mo6830b(), "module"), 0, C1437s.m5613h(xVar.mo6830b(), "message"), false);
        }
    }

    C1443w() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6823b(int i, int i2, String str, boolean z) {
        if (!m5645a(m5641a(i, i2, str, z))) {
            synchronized (this.f4541c) {
                this.f4541c.add(m5641a(i, i2, str, z));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6825c() {
        ExecutorService executorService = this.f4540b;
        if (executorService == null || executorService.isShutdown() || this.f4540b.isTerminated()) {
            this.f4540b = Executors.newSingleThreadExecutor();
        }
        synchronized (this.f4541c) {
            while (!this.f4541c.isEmpty()) {
                m5645a(this.f4541c.poll());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6818a(int i, String str, boolean z) {
        mo6823b(0, i, str, z);
    }

    /* renamed from: a */
    private Runnable m5641a(int i, int i2, String str, boolean z) {
        return new C1445b(i, str, i2, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6821a(JSONObject jSONObject, int i, boolean z) {
        int f = C1437s.m5611f(jSONObject, "print_level");
        boolean d = C1437s.m5608d(jSONObject, "log_private");
        if (jSONObject.length() == 0) {
            f = f4537m;
            d = f4529e;
        }
        return (!z || d) && f != 4 && f >= i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6822b() {
        C1199a.m4876a("Log.set_log_level", (C1458z) new C1446c());
        C1199a.m4876a("Log.public.trace", (C1458z) new C1447d());
        C1199a.m4876a("Log.private.trace", (C1458z) new C1448e());
        C1199a.m4876a("Log.public.info", (C1458z) new C1449f());
        C1199a.m4876a("Log.private.info", (C1458z) new C1450g());
        C1199a.m4876a("Log.public.warning", (C1458z) new C1451h());
        C1199a.m4876a("Log.private.warning", (C1458z) new C1452i());
        C1199a.m4876a("Log.public.error", (C1458z) new C1453j());
        C1199a.m4876a("Log.private.error", (C1458z) new C1444a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6820a(JSONObject jSONObject, int i) {
        int f = C1437s.m5611f(jSONObject, "send_level");
        if (jSONObject.length() == 0) {
            f = f4538n;
        }
        return f >= i && f != 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6819a(HashMap<String, Object> hashMap) {
        try {
            C1282e0 e0Var = new C1282e0(new C1438t(new URL("https://wd.adcolony.com/logs")), Executors.newSingleThreadScheduledExecutor(), hashMap);
            this.f4542d = e0Var;
            e0Var.mo6478a(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6824b(JSONArray jSONArray) {
        this.f4539a = mo6817a(jSONArray);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5643a(int i, String str, int i2) {
        if (this.f4542d != null) {
            if (i2 == 3 && mo6820a(C1437s.m5612g(this.f4539a, Integer.toString(i)), 3)) {
                this.f4542d.mo6481a(str);
            } else if (i2 == 2 && mo6820a(C1437s.m5612g(this.f4539a, Integer.toString(i)), 2)) {
                this.f4542d.mo6485c(str);
            } else if (i2 == 1 && mo6820a(C1437s.m5612g(this.f4539a, Integer.toString(i)), 1)) {
                this.f4542d.mo6486d(str);
            } else if (i2 == 0 && mo6820a(C1437s.m5612g(this.f4539a, Integer.toString(i)), 0)) {
                this.f4542d.mo6484b(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo6817a(JSONArray jSONArray) {
        JSONObject b = C1437s.m5599b();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject c = C1437s.m5606c(jSONArray, i);
            C1437s.m5594a(b, Integer.toString(C1437s.m5611f(c, "id")), c);
        }
        return b;
    }

    /* renamed from: a */
    private boolean m5645a(Runnable runnable) {
        try {
            if (this.f4540b == null || this.f4540b.isShutdown() || this.f4540b.isTerminated()) {
                return false;
            }
            this.f4540b.submit(runnable);
            return true;
        } catch (RejectedExecutionException unused) {
            Log.e("ADCLogError", "Internal error when submitting log to executor service.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1282e0 mo6816a() {
        return this.f4542d;
    }
}
