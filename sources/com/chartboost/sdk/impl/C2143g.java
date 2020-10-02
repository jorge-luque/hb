package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import com.chartboost.sdk.C2102d;
import com.chartboost.sdk.C2107e;
import com.chartboost.sdk.C2116i;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.ChartboostBanner;
import com.chartboost.sdk.Events.C2068a;
import com.chartboost.sdk.Events.C2070b;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.C2078f;
import com.chartboost.sdk.Libraries.C2082i;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C2086a;
import com.chartboost.sdk.Model.C2087b;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.C2092g;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2117a;
import com.chartboost.sdk.impl.C2128c1;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.g */
public class C2143g {

    /* renamed from: A */
    private final long f7165A = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: B */
    private final long f7166B = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: C */
    private final String[] f7167C = {"ASKED_TO_CACHE", "ASKED_TO_SHOW", "REQUESTING_TO_CACHE", "REQUESTING_TO_SHOW", "DOWNLOADING_TO_CACHE", "DOWNLOADING_TO_SHOW", "READY", "ASKING_UI_TO_SHOW_AD", "DONE"};

    /* renamed from: a */
    public final ScheduledExecutorService f7168a;

    /* renamed from: b */
    private final C2181n f7169b;

    /* renamed from: c */
    public final C2078f f7170c;

    /* renamed from: d */
    private final C2218v0 f7171d;

    /* renamed from: e */
    private final C2222w0 f7172e;

    /* renamed from: f */
    private final C2092g f7173f;

    /* renamed from: g */
    private final AtomicReference<C2093h> f7174g;

    /* renamed from: h */
    private final SharedPreferences f7175h;

    /* renamed from: i */
    final C2082i f7176i;

    /* renamed from: j */
    private final C2098a f7177j;

    /* renamed from: k */
    final Handler f7178k;

    /* renamed from: l */
    final C2102d f7179l;

    /* renamed from: m */
    private final C2225x0 f7180m;

    /* renamed from: n */
    private final C2107e f7181n;

    /* renamed from: o */
    private final C2234y0 f7182o;

    /* renamed from: p */
    final C2117a f7183p;

    /* renamed from: q */
    protected ChartboostBanner f7184q;

    /* renamed from: r */
    int f7185r = 0;

    /* renamed from: s */
    private int f7186s;

    /* renamed from: t */
    private boolean f7187t;

    /* renamed from: u */
    final Map<String, C2151h> f7188u;

    /* renamed from: v */
    final SortedSet<C2151h> f7189v;

    /* renamed from: w */
    final SortedSet<C2151h> f7190w;

    /* renamed from: x */
    private final Map<String, Long> f7191x;

    /* renamed from: y */
    private final Map<String, Integer> f7192y;

    /* renamed from: z */
    ScheduledFuture<?> f7193z;

    /* renamed from: com.chartboost.sdk.impl.g$b */
    public class C2145b implements Runnable {

        /* renamed from: a */
        final int f7200a;

        /* renamed from: b */
        final String f7201b;

        /* renamed from: c */
        final C2151h f7202c;

        /* renamed from: d */
        final CBError.CBImpressionError f7203d;

        public C2145b(int i, String str, C2151h hVar, CBError.CBImpressionError cBImpressionError) {
            this.f7200a = i;
            this.f7201b = str;
            this.f7202c = hVar;
            this.f7203d = cBImpressionError;
        }

        public void run() {
            try {
                synchronized (C2143g.this) {
                    int i = this.f7200a;
                    if (i != 0) {
                        switch (i) {
                            case 2:
                                C2143g.this.f7193z = null;
                                C2143g.this.mo9345f();
                                break;
                            case 3:
                                C2143g.this.mo9340b(this.f7201b);
                                break;
                            case 4:
                                C2143g.this.mo9344e(this.f7201b);
                                break;
                            case 5:
                                C2143g.this.mo9333a(this.f7202c);
                                break;
                            case 6:
                                C2143g.this.mo9334a(this.f7202c, this.f7203d);
                                break;
                            case 7:
                                C2143g.this.mo9339b(this.f7202c);
                                break;
                            case 8:
                                C2143g.this.mo9341c(this.f7201b);
                                break;
                        }
                    } else {
                        C2143g.this.mo9343e();
                    }
                }
            } catch (Exception e) {
                C2098a.m8288a(C2145b.class, "run", e);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.g$c */
    private class C2146c {

        /* renamed from: a */
        protected C2088c f7205a;

        /* renamed from: b */
        protected CBError.CBImpressionError f7206b;

        public C2146c(C2143g gVar, C2088c cVar, CBError.CBImpressionError cBImpressionError) {
            this.f7205a = cVar;
            this.f7206b = cBImpressionError;
        }
    }

    public C2143g(C2117a aVar, ScheduledExecutorService scheduledExecutorService, C2181n nVar, C2078f fVar, C2218v0 v0Var, C2222w0 w0Var, C2092g gVar, AtomicReference<C2093h> atomicReference, SharedPreferences sharedPreferences, C2082i iVar, C2098a aVar2, Handler handler, C2102d dVar, C2225x0 x0Var, C2107e eVar, C2234y0 y0Var) {
        this.f7168a = scheduledExecutorService;
        this.f7169b = nVar;
        this.f7170c = fVar;
        this.f7171d = v0Var;
        this.f7172e = w0Var;
        this.f7173f = gVar;
        this.f7174g = atomicReference;
        this.f7175h = sharedPreferences;
        this.f7176i = iVar;
        this.f7177j = aVar2;
        this.f7178k = handler;
        this.f7179l = dVar;
        this.f7180m = x0Var;
        this.f7181n = eVar;
        this.f7182o = y0Var;
        this.f7183p = aVar;
        this.f7186s = 1;
        this.f7188u = new HashMap();
        this.f7190w = new TreeSet();
        this.f7189v = new TreeSet();
        this.f7191x = new HashMap();
        this.f7192y = new HashMap();
        this.f7187t = false;
    }

    /* renamed from: a */
    private boolean m8513a(SortedSet<C2151h> sortedSet, int i, int i2, int i3, String str) {
        Iterator it = sortedSet.iterator();
        while (it.hasNext()) {
            C2151h hVar = (C2151h) it.next();
            if (hVar.f7223c != i || hVar.f7224d != null) {
                it.remove();
            } else if (m8525f(hVar.f7222b)) {
                continue;
            } else if (!this.f7183p.mo9277g(hVar.f7222b)) {
                hVar.f7223c = 8;
                this.f7188u.remove(hVar.f7222b);
                it.remove();
            } else {
                hVar.f7223c = i2;
                it.remove();
                m8511a(hVar, i3, str);
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private C2146c m8519c(C2151h hVar) {
        CBError.CBImpressionError cBImpressionError;
        String str;
        C2088c cVar = null;
        try {
            C2086a aVar = hVar.f7224d;
            File file = this.f7170c.mo9089a().f6867a;
            cBImpressionError = m8506a(aVar);
            if (cBImpressionError == null) {
                cBImpressionError = m8507a(aVar, file);
            }
            if (cBImpressionError == null) {
                str = m8514b(aVar, file);
                cBImpressionError = m8508a(str, aVar);
            } else {
                str = null;
            }
            if (cBImpressionError == null) {
                cVar = m8509a(hVar, str);
            }
        } catch (Exception e) {
            C2098a.m8288a((Class) getClass(), "showReady", e);
            cBImpressionError = CBError.CBImpressionError.INTERNAL;
        }
        return new C2146c(this, cVar, cBImpressionError);
    }

    /* renamed from: g */
    private void mo9003g() {
        long b = this.f7176i.mo9111b();
        Iterator<Long> it = this.f7191x.values().iterator();
        while (it.hasNext()) {
            if (b - it.next().longValue() >= 0) {
                it.remove();
            }
        }
    }

    /* renamed from: h */
    private void mo9004h() {
        Long l;
        boolean z = true;
        if (this.f7185r == 1) {
            long b = this.f7176i.mo9111b();
            l = null;
            for (Map.Entry next : this.f7191x.entrySet()) {
                if (this.f7188u.get((String) next.getKey()) != null) {
                    long max = Math.max(this.f7165A, ((Long) next.getValue()).longValue() - b);
                    if (l == null || max < l.longValue()) {
                        l = Long.valueOf(max);
                    }
                }
            }
        } else {
            l = null;
        }
        if (!(l == null || this.f7193z == null)) {
            if (Math.abs(l.longValue() - this.f7193z.getDelay(TimeUnit.NANOSECONDS)) > this.f7165A) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        ScheduledFuture<?> scheduledFuture = this.f7193z;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f7193z = null;
        }
        if (l != null) {
            this.f7193z = this.f7168a.schedule(new C2145b(2, (String) null, (C2151h) null, (CBError.CBImpressionError) null), l.longValue(), TimeUnit.NANOSECONDS);
        }
    }

    /* renamed from: i */
    private void m8530i(C2151h hVar) {
        this.f7188u.remove(hVar.f7222b);
        hVar.f7223c = 8;
        hVar.f7224d = null;
    }

    /* renamed from: j */
    private void m8532j(C2151h hVar) {
        if (!this.f7172e.mo9539c()) {
            m8515b(hVar, CBError.CBImpressionError.INTERNET_UNAVAILABLE_AT_SHOW);
            return;
        }
        C2146c c = m8519c(hVar);
        m8512a(hVar, c.f7205a, c.f7206b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9340b(String str) {
        if (m8531i()) {
            C2117a aVar = this.f7183p;
            aVar.getClass();
            this.f7178k.postDelayed(new C2117a.C2118a(4, str, CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED, (C2070b) null), this.f7166B);
            return;
        }
        C2151h hVar = this.f7188u.get(str);
        if (hVar != null && hVar.f7223c == 6 && !m8518b(hVar.f7224d)) {
            this.f7188u.remove(str);
            hVar = null;
        }
        if (hVar == null) {
            int i = this.f7186s;
            this.f7186s = i + 1;
            hVar = new C2151h(i, str, 0);
            this.f7188u.put(str, hVar);
            this.f7189v.add(hVar);
        }
        hVar.f7226f = true;
        if (hVar.f7228h == null) {
            hVar.f7228h = Long.valueOf(this.f7176i.mo9111b());
        }
        int i2 = hVar.f7223c;
        if (i2 == 6 || i2 == 7) {
            Handler handler = this.f7178k;
            C2117a aVar2 = this.f7183p;
            aVar2.getClass();
            handler.post(new C2117a.C2118a(0, str, (CBError.CBImpressionError) null, (C2070b) null));
        }
        mo9345f();
    }

    /* renamed from: d */
    public synchronized C2086a mo9342d(String str) {
        int i;
        C2151h hVar = this.f7188u.get(str);
        if (hVar == null || ((i = hVar.f7223c) != 6 && i != 7)) {
            return null;
        }
        return hVar.f7224d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo9343e() {
        if (this.f7185r == 0) {
            this.f7185r = 1;
            mo9345f();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo9345f() {
        if (!this.f7187t) {
            try {
                this.f7187t = true;
                mo9003g();
                if (this.f7185r == 1) {
                    if (!m8513a(this.f7190w, 1, 3, 1, "show")) {
                        m8513a(this.f7189v, 0, 2, 2, "cache");
                    }
                }
                mo9004h();
                this.f7187t = false;
            } catch (Throwable th) {
                this.f7187t = false;
                throw th;
            }
        }
    }

    /* renamed from: d */
    private void m8522d(C2151h hVar) {
        C2093h hVar2 = this.f7174g.get();
        long j = hVar2.f7017q;
        int i = hVar2.f7018r;
        Integer num = this.f7192y.get(hVar.f7222b);
        if (num == null) {
            num = 0;
        }
        Integer valueOf = Integer.valueOf(Math.min(num.intValue(), i));
        this.f7192y.put(hVar.f7222b, Integer.valueOf(valueOf.intValue() + 1));
        this.f7191x.put(hVar.f7222b, Long.valueOf(this.f7176i.mo9111b() + TimeUnit.MILLISECONDS.toNanos(j << valueOf.intValue())));
    }

    /* renamed from: e */
    private void m8523e(C2151h hVar) {
        if (hVar.f7224d != null) {
            int i = hVar.f7223c;
            if (i == 5 || i == 4) {
                int i2 = hVar.f7223c == 5 ? 1 : 2;
                if (hVar.f7227g > i2) {
                    C2138e2 e2Var = new C2138e2(this, hVar);
                    hVar.f7227g = i2;
                    this.f7169b.mo9432a(i2, hVar.f7224d.f6897c, new AtomicInteger(), (C2167j) C2116i.m8407a().mo9266a(e2Var));
                }
            }
        }
    }

    /* renamed from: i */
    private boolean m8531i() {
        if (this.f7183p.f7101a == 0 && !C2242k.f7619s && this.f7175h.getInt("cbPrefSessionCount", 0) == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    private void m8527g(C2151h hVar) {
        m8521c(hVar, CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
        m8530i(hVar);
        m8522d(hVar);
    }

    /* renamed from: f */
    private boolean m8525f(String str) {
        return this.f7191x.containsKey(str);
    }

    /* renamed from: c */
    private String m8520c(C2086a aVar, File file) {
        C2087b bVar = aVar.f6912r;
        if (bVar == null) {
            CBLogging.m8154b("AdUnitManager", "AdUnit does not have a template body");
            return null;
        }
        File a = bVar.mo9117a(file);
        HashMap hashMap = new HashMap(aVar.f6898d);
        for (Map.Entry next : aVar.f6897c.entrySet()) {
            hashMap.put(next.getKey(), ((C2087b) next.getValue()).f6915b);
        }
        try {
            return C2195p.m8731a(a, hashMap);
        } catch (Exception e) {
            C2098a.m8288a((Class) getClass(), "loadTemplateHtml", e);
            return null;
        }
    }

    /* renamed from: f */
    private void m8524f(C2151h hVar) {
        C2086a aVar = hVar.f7224d;
        String str = aVar.f6900f;
        String str2 = hVar.f7222b;
        this.f7171d.mo9524a(new C2141f1(this.f7183p.f7106f, this.f7177j, this.f7173f, new C2156h1(str, str2), new C2157i(this, str2)));
        this.f7177j.mo9176d(this.f7183p.mo9267a(aVar.f6896b), str2, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo9344e(String str) {
        if (m8531i()) {
            C2117a aVar = this.f7183p;
            aVar.getClass();
            this.f7178k.postDelayed(new C2117a.C2118a(4, str, CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED, (C2070b) null), this.f7166B);
            return;
        }
        C2151h hVar = this.f7188u.get(str);
        if (hVar == null) {
            int i = this.f7186s;
            this.f7186s = i + 1;
            hVar = new C2151h(i, str, 1);
            this.f7188u.put(str, hVar);
            this.f7190w.add(hVar);
        }
        if (hVar.f7229i == null) {
            hVar.f7229i = Long.valueOf(this.f7176i.mo9111b());
        }
        int i2 = hVar.f7223c;
        if (i2 == 0) {
            this.f7189v.remove(hVar);
            this.f7190w.add(hVar);
            hVar.f7223c = 1;
        } else if (i2 == 2) {
            hVar.f7223c = 3;
        } else if (i2 == 4) {
            hVar.f7223c = 5;
            m8523e(hVar);
        } else if (i2 == 6) {
            m8532j(hVar);
        }
        mo9345f();
    }

    /* renamed from: com.chartboost.sdk.impl.g$a */
    class C2144a implements C2128c1.C2129a {

        /* renamed from: a */
        final /* synthetic */ C2151h f7194a;

        /* renamed from: b */
        final /* synthetic */ long f7195b;

        /* renamed from: c */
        final /* synthetic */ boolean f7196c;

        /* renamed from: d */
        final /* synthetic */ boolean f7197d;

        /* renamed from: e */
        final /* synthetic */ boolean f7198e;

        C2144a(C2151h hVar, long j, boolean z, boolean z2, boolean z3) {
            this.f7194a = hVar;
            this.f7195b = j;
            this.f7196c = z;
            this.f7197d = z2;
            this.f7198e = z3;
        }

        /* renamed from: a */
        public void mo9300a(C2128c1 c1Var, JSONObject jSONObject) {
            C2086a aVar;
            try {
                this.f7194a.f7236p = Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(C2143g.this.f7176i.mo9111b() - this.f7195b));
                this.f7194a.f7237q = Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(c1Var.f7438g));
                this.f7194a.f7238r = Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(c1Var.f7439h));
                if (this.f7196c) {
                    aVar = new C2086a(0, jSONObject, true);
                } else if (this.f7197d) {
                    aVar = new C2233y(C2143g.this.f7183p.f7101a, jSONObject);
                } else if (this.f7198e) {
                    aVar = new C2086a(1, jSONObject, false);
                } else {
                    aVar = new C2086a(0, jSONObject, false);
                }
                C2143g.this.mo9336a(this.f7194a, aVar);
            } catch (JSONException e) {
                C2098a.m8288a(C2143g.class, "sendAdGetRequest.onSuccess", (Exception) e);
                C2143g.this.mo9335a(this.f7194a, new CBError(CBError.C2085b.UNEXPECTED_RESPONSE, "Response conversion failure"));
            }
        }

        /* renamed from: a */
        public void mo9299a(C2128c1 c1Var, CBError cBError) {
            C2143g.this.mo9335a(this.f7194a, cBError);
        }
    }

    /* renamed from: a */
    public synchronized boolean mo9338a(String str, C2233y yVar) {
        int i = this.f7186s;
        this.f7186s = i + 1;
        C2151h hVar = new C2151h(i, str, 6);
        hVar.f7225e = 1;
        hVar.f7224d = yVar;
        this.f7188u.put(str, hVar);
        this.f7189v.add(hVar);
        return true;
    }

    /* renamed from: b */
    private boolean m8518b(C2086a aVar) {
        File file = this.f7170c.mo9089a().f6867a;
        for (C2087b next : aVar.f6897c.values()) {
            if (!next.mo9117a(file).exists()) {
                CBLogging.m8154b("AdUnitManager", "Asset does not exist: " + next.f6915b);
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [com.chartboost.sdk.impl.r0] */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r17v4, types: [com.chartboost.sdk.impl.c1] */
    /* JADX WARNING: type inference failed for: r17v5, types: [com.chartboost.sdk.impl.d1] */
    /* JADX WARNING: type inference failed for: r17v6, types: [com.chartboost.sdk.impl.c1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8511a(com.chartboost.sdk.impl.C2151h r25, int r26, java.lang.String r27) {
        /*
            r24 = this;
            r9 = r24
            r10 = r25
            java.util.concurrent.atomic.AtomicReference<com.chartboost.sdk.Model.h> r0 = r9.f7174g     // Catch:{ Exception -> 0x0169 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Model.h r0 = (com.chartboost.sdk.Model.C2093h) r0     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.impl.a r1 = r9.f7183p     // Catch:{ Exception -> 0x0169 }
            int r1 = r1.f7101a     // Catch:{ Exception -> 0x0169 }
            r11 = 2
            r12 = 0
            r13 = 1
            if (r1 != r11) goto L_0x0017
            r14 = 1
            goto L_0x0018
        L_0x0017:
            r14 = 0
        L_0x0018:
            com.chartboost.sdk.impl.a r1 = r9.f7183p     // Catch:{ Exception -> 0x0169 }
            int r1 = r1.f7101a     // Catch:{ Exception -> 0x0169 }
            r2 = 3
            if (r1 != r2) goto L_0x0021
            r15 = 1
            goto L_0x0022
        L_0x0021:
            r15 = 0
        L_0x0022:
            boolean r1 = r0.f7023w     // Catch:{ Exception -> 0x0169 }
            if (r1 == 0) goto L_0x002b
            if (r14 != 0) goto L_0x002b
            r16 = 1
            goto L_0x002d
        L_0x002b:
            r16 = 0
        L_0x002d:
            com.chartboost.sdk.Libraries.i r1 = r9.f7176i     // Catch:{ Exception -> 0x0169 }
            long r4 = r1.mo9111b()     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.impl.g$a r23 = new com.chartboost.sdk.impl.g$a     // Catch:{ Exception -> 0x0169 }
            r1 = r23
            r2 = r24
            r3 = r25
            r6 = r14
            r7 = r15
            r8 = r16
            r1.<init>(r3, r4, r6, r7, r8)     // Catch:{ Exception -> 0x0169 }
            int r1 = r10.f7223c     // Catch:{ Exception -> 0x0169 }
            if (r1 != r11) goto L_0x0048
            r1 = 1
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            java.lang.String r2 = "cache"
            java.lang.String r3 = "location"
            if (r14 == 0) goto L_0x0087
            com.chartboost.sdk.impl.c1 r0 = new com.chartboost.sdk.impl.c1     // Catch:{ Exception -> 0x0169 }
            java.lang.String r18 = "https://live.chartboost.com"
            com.chartboost.sdk.impl.a r4 = r9.f7183p     // Catch:{ Exception -> 0x0169 }
            java.lang.String r4 = r4.f7104d     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Model.g r5 = r9.f7173f     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Tracking.a r6 = r9.f7177j     // Catch:{ Exception -> 0x0169 }
            r17 = r0
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r26
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0169 }
            r0.f7130m = r13     // Catch:{ Exception -> 0x0169 }
            java.lang.String r4 = r10.f7222b     // Catch:{ Exception -> 0x0169 }
            r0.mo9294a((java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0169 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0169 }
            r0.mo9294a((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r1 = "raw"
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r13)     // Catch:{ Exception -> 0x0169 }
            r0.mo9294a((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0169 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0169 }
            r10.f7225e = r1     // Catch:{ Exception -> 0x0169 }
            goto L_0x014a
        L_0x0087:
            if (r15 == 0) goto L_0x00cf
            com.chartboost.sdk.Model.e r0 = new com.chartboost.sdk.Model.e     // Catch:{ Exception -> 0x0169 }
            java.lang.String r18 = "https://da.chartboost.com"
            com.chartboost.sdk.impl.a r1 = r9.f7183p     // Catch:{ Exception -> 0x0169 }
            java.lang.String r1 = r1.f7105e     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Model.g r2 = r9.f7173f     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Tracking.a r3 = r9.f7177j     // Catch:{ Exception -> 0x0169 }
            r17 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r26
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.impl.p0 r1 = new com.chartboost.sdk.impl.p0     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.impl.a r2 = r9.f7183p     // Catch:{ Exception -> 0x0169 }
            int r2 = r2.f7101a     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.ChartboostBanner r3 = r9.f7184q     // Catch:{ Exception -> 0x0169 }
            int r3 = r3.getBannerHeight()     // Catch:{ Exception -> 0x0169 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.ChartboostBanner r4 = r9.f7184q     // Catch:{ Exception -> 0x0169 }
            int r4 = r4.getBannerWidth()     // Catch:{ Exception -> 0x0169 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r5 = r10.f7222b     // Catch:{ Exception -> 0x0169 }
            r1.<init>(r2, r3, r4, r5)     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.impl.e1 r2 = new com.chartboost.sdk.impl.e1     // Catch:{ Exception -> 0x0169 }
            r2.<init>(r0, r1)     // Catch:{ Exception -> 0x0169 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x0169 }
            r10.f7225e = r0     // Catch:{ Exception -> 0x0169 }
            r0 = r2
            goto L_0x014a
        L_0x00cf:
            if (r16 == 0) goto L_0x0112
            com.chartboost.sdk.impl.a r4 = r9.f7183p     // Catch:{ Exception -> 0x0169 }
            java.lang.String r4 = r4.f7105e     // Catch:{ Exception -> 0x0169 }
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0169 }
            java.lang.String r0 = r0.f6998C     // Catch:{ Exception -> 0x0169 }
            r5[r12] = r0     // Catch:{ Exception -> 0x0169 }
            java.lang.String r18 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.impl.d1 r0 = new com.chartboost.sdk.impl.d1     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Model.g r4 = r9.f7173f     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Tracking.a r5 = r9.f7177j     // Catch:{ Exception -> 0x0169 }
            r17 = r0
            r19 = r4
            r20 = r5
            r21 = r26
            r22 = r23
            r17.<init>(r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Libraries.f r4 = r9.f7170c     // Catch:{ Exception -> 0x0169 }
            org.json.JSONObject r4 = r4.mo9096d()     // Catch:{ Exception -> 0x0169 }
            java.lang.String r5 = "cache_assets"
            r0.mo9315a(r5, r4, r12)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r4 = r10.f7222b     // Catch:{ Exception -> 0x0169 }
            r0.mo9315a(r3, r4, r12)     // Catch:{ Exception -> 0x0169 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0169 }
            r0.mo9315a(r2, r1, r12)     // Catch:{ Exception -> 0x0169 }
            r0.f7130m = r13     // Catch:{ Exception -> 0x0169 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x0169 }
            r10.f7225e = r1     // Catch:{ Exception -> 0x0169 }
            goto L_0x014a
        L_0x0112:
            com.chartboost.sdk.impl.c1 r0 = new com.chartboost.sdk.impl.c1     // Catch:{ Exception -> 0x0169 }
            java.lang.String r18 = "https://live.chartboost.com"
            com.chartboost.sdk.impl.a r4 = r9.f7183p     // Catch:{ Exception -> 0x0169 }
            java.lang.String r4 = r4.f7104d     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Model.g r5 = r9.f7173f     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Tracking.a r6 = r9.f7177j     // Catch:{ Exception -> 0x0169 }
            r17 = r0
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r26
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r4 = "local-videos"
            com.chartboost.sdk.Libraries.f r5 = r9.f7170c     // Catch:{ Exception -> 0x0169 }
            org.json.JSONArray r5 = r5.mo9094c()     // Catch:{ Exception -> 0x0169 }
            r0.mo9294a((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0169 }
            r0.f7130m = r13     // Catch:{ Exception -> 0x0169 }
            java.lang.String r4 = r10.f7222b     // Catch:{ Exception -> 0x0169 }
            r0.mo9294a((java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0169 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0169 }
            r0.mo9294a((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0169 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0169 }
            r10.f7225e = r1     // Catch:{ Exception -> 0x0169 }
        L_0x014a:
            r0.f7440i = r13     // Catch:{ Exception -> 0x0169 }
            r9.f7185r = r11     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.impl.v0 r1 = r9.f7171d     // Catch:{ Exception -> 0x0169 }
            r1.mo9524a(r0)     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.Tracking.a r0 = r9.f7177j     // Catch:{ Exception -> 0x0169 }
            com.chartboost.sdk.impl.a r1 = r9.f7183p     // Catch:{ Exception -> 0x0169 }
            java.lang.Integer r2 = r10.f7225e     // Catch:{ Exception -> 0x0169 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0169 }
            java.lang.String r1 = r1.mo9267a((int) r2)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r2 = r10.f7222b     // Catch:{ Exception -> 0x0169 }
            r3 = r27
            r0.mo9178e(r1, r3, r2)     // Catch:{ Exception -> 0x0169 }
            goto L_0x017f
        L_0x0169:
            r0 = move-exception
            java.lang.Class r1 = r24.getClass()
            java.lang.String r2 = "sendAdGetRequest"
            com.chartboost.sdk.Tracking.C2098a.m8288a((java.lang.Class) r1, (java.lang.String) r2, (java.lang.Exception) r0)
            com.chartboost.sdk.Model.CBError r0 = new com.chartboost.sdk.Model.CBError
            com.chartboost.sdk.Model.CBError$b r1 = com.chartboost.sdk.Model.CBError.C2085b.MISCELLANEOUS
            java.lang.String r2 = "error sending ad-get request"
            r0.<init>(r1, r2)
            r9.mo9335a((com.chartboost.sdk.impl.C2151h) r10, (com.chartboost.sdk.Model.CBError) r0)
        L_0x017f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2143g.m8511a(com.chartboost.sdk.impl.h, int, java.lang.String):void");
    }

    /* renamed from: c */
    private void m8521c(C2151h hVar, CBError.CBImpressionError cBImpressionError) {
        String str;
        m8515b(hVar, cBImpressionError);
        if (cBImpressionError != CBError.CBImpressionError.NO_AD_FOUND) {
            C2086a aVar = hVar.f7224d;
            String str2 = null;
            String str3 = aVar != null ? aVar.f6900f : null;
            int i = hVar.f7223c;
            String str4 = (i == 0 || i == 2 || i == 4) ? "cache" : "show";
            C2086a aVar2 = hVar.f7224d;
            Integer valueOf = Integer.valueOf(aVar2 != null ? aVar2.f6896b : hVar.f7225e.intValue());
            if (valueOf != null) {
                str2 = valueOf.intValue() == 0 ? "native" : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB;
            }
            String str5 = str2;
            int i2 = hVar.f7223c;
            if (i2 >= 0) {
                String[] strArr = this.f7167C;
                if (i2 < strArr.length) {
                    str = strArr[i2];
                    this.f7177j.mo9164a(this.f7183p.f7102b, str4, str5, cBImpressionError.toString(), str3, hVar.f7222b, str);
                }
            }
            str = "Unknown state: " + hVar.f7223c;
            this.f7177j.mo9164a(this.f7183p.f7102b, str4, str5, cBImpressionError.toString(), str3, hVar.f7222b, str);
        }
    }

    /* renamed from: h */
    private void m8529h(C2151h hVar) {
        int i = hVar.f7223c;
        long b = this.f7176i.mo9111b();
        Long l = hVar.f7228h;
        if (l != null) {
            hVar.f7231k = Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(b - l.longValue()));
        }
        Long l2 = hVar.f7229i;
        if (l2 != null) {
            hVar.f7232l = Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(b - l2.longValue()));
        }
        m8516b(hVar, "ad-unit-cached");
        hVar.f7223c = 6;
        if (hVar.f7226f) {
            Handler handler = this.f7178k;
            C2117a aVar = this.f7183p;
            aVar.getClass();
            handler.post(new C2117a.C2118a(0, hVar.f7222b, (CBError.CBImpressionError) null, (C2070b) null));
        }
        if (i == 5) {
            m8532j(hVar);
        }
    }

    /* renamed from: b */
    private String m8514b(C2086a aVar, File file) {
        if (aVar.f6896b == 1) {
            return m8520c(aVar, file);
        }
        return null;
    }

    /* renamed from: b */
    private void m8515b(C2151h hVar, CBError.CBImpressionError cBImpressionError) {
        C2117a aVar = this.f7183p;
        if (aVar.f7101a == 3) {
            C2070b a = C2068a.m8151a(cBImpressionError);
            int a2 = m8505a(a);
            Handler handler = this.f7178k;
            C2117a aVar2 = this.f7183p;
            aVar2.getClass();
            handler.post(new C2117a.C2118a(a2, hVar.f7222b, (CBError.CBImpressionError) null, a));
            return;
        }
        Handler handler2 = this.f7178k;
        aVar.getClass();
        handler2.post(new C2117a.C2118a(4, hVar.f7222b, cBImpressionError, (C2070b) null));
    }

    /* renamed from: b */
    private void m8516b(C2151h hVar, String str) {
        Integer num;
        String str2;
        C2151h hVar2 = hVar;
        if (this.f7174g.get().f7015o) {
            C2086a aVar = hVar2.f7224d;
            String str3 = null;
            String str4 = aVar != null ? aVar.f6900f : null;
            int i = hVar2.f7223c;
            String str5 = (i == 0 || i == 2 || i == 4) ? "cache" : "show";
            C2086a aVar2 = hVar2.f7224d;
            if (aVar2 != null) {
                num = Integer.valueOf(aVar2.f6896b);
            } else {
                num = hVar2.f7225e;
            }
            if (num != null) {
                str3 = num.intValue() == 0 ? "native" : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB;
            }
            String str6 = str3;
            int i2 = hVar2.f7223c;
            if (i2 >= 0) {
                String[] strArr = this.f7167C;
                if (i2 < strArr.length) {
                    str2 = strArr[i2];
                    this.f7177j.mo9166a(str, this.f7183p.f7102b, str5, str6, (String) null, (String) null, C2076e.m8186a(C2076e.m8184a("adGetRequestSubmitToCallbackMs", (Object) hVar2.f7236p), C2076e.m8184a("downloadRequestToCompletionMs", (Object) hVar2.f7234n), C2076e.m8184a("downloadAccumulatedProcessingMs", (Object) hVar2.f7235o), C2076e.m8184a("adGetRequestGetResponseCodeMs", (Object) hVar2.f7237q), C2076e.m8184a("adGetRequestReadDataMs", (Object) hVar2.f7238r), C2076e.m8184a("cacheRequestToReadyMs", (Object) hVar2.f7231k), C2076e.m8184a("showRequestToReadyMs", (Object) hVar2.f7232l), C2076e.m8184a("showRequestToShownMs", (Object) hVar2.f7233m), C2076e.m8184a("adId", (Object) str4), C2076e.m8184a((String) PlaceFields.LOCATION, (Object) hVar2.f7222b), C2076e.m8184a("state", (Object) str2)), false);
                }
            }
            str2 = "Unknown state: " + hVar2.f7223c;
            this.f7177j.mo9166a(str, this.f7183p.f7102b, str5, str6, (String) null, (String) null, C2076e.m8186a(C2076e.m8184a("adGetRequestSubmitToCallbackMs", (Object) hVar2.f7236p), C2076e.m8184a("downloadRequestToCompletionMs", (Object) hVar2.f7234n), C2076e.m8184a("downloadAccumulatedProcessingMs", (Object) hVar2.f7235o), C2076e.m8184a("adGetRequestGetResponseCodeMs", (Object) hVar2.f7237q), C2076e.m8184a("adGetRequestReadDataMs", (Object) hVar2.f7238r), C2076e.m8184a("cacheRequestToReadyMs", (Object) hVar2.f7231k), C2076e.m8184a("showRequestToReadyMs", (Object) hVar2.f7232l), C2076e.m8184a("showRequestToShownMs", (Object) hVar2.f7233m), C2076e.m8184a("adId", (Object) str4), C2076e.m8184a((String) PlaceFields.LOCATION, (Object) hVar2.f7222b), C2076e.m8184a("state", (Object) str2)), false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9341c(String str) {
        C2151h hVar = this.f7188u.get(str);
        if (hVar != null && hVar.f7223c == 6) {
            m8530i(hVar);
            mo9345f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9339b(C2151h hVar) {
        if (hVar.f7223c == 7) {
            hVar.f7223c = 6;
            hVar.f7230j = null;
            hVar.f7229i = null;
            hVar.f7233m = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo9336a(C2151h hVar, C2086a aVar) {
        this.f7185r = 1;
        hVar.f7223c = hVar.f7223c == 2 ? 4 : 5;
        hVar.f7224d = aVar;
        m8523e(hVar);
        mo9345f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m8517b(C2151h hVar, boolean z, int i, int i2) {
        int i3 = hVar.f7223c;
        if (i3 == 4 || i3 == 5) {
            hVar.f7234n = Integer.valueOf(i);
            hVar.f7235o = Integer.valueOf(i2);
            if (z) {
                m8529h(hVar);
            } else {
                m8527g(hVar);
            }
        }
        mo9345f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo9335a(C2151h hVar, CBError cBError) {
        if (this.f7185r != 0) {
            this.f7185r = 1;
            m8521c(hVar, cBError.mo9116c());
            m8530i(hVar);
            m8522d(hVar);
            mo9345f();
        }
    }

    /* renamed from: a */
    private void m8512a(C2151h hVar, C2088c cVar, CBError.CBImpressionError cBImpressionError) {
        if (cBImpressionError == null) {
            hVar.f7223c = 7;
            C2102d dVar = this.f7179l;
            dVar.getClass();
            C2102d.C2106d dVar2 = new C2102d.C2106d(10);
            dVar2.f7056c = cVar;
            hVar.f7230j = Long.valueOf(this.f7176i.mo9111b());
            this.f7178k.post(dVar2);
            return;
        }
        m8521c(hVar, cBImpressionError);
        m8530i(hVar);
    }

    /* renamed from: a */
    private CBError.CBImpressionError m8506a(C2086a aVar) {
        if (aVar.f6896b != 0 || (!this.f7183p.f7107g && !aVar.f6910p.equals("video"))) {
            return null;
        }
        CBError.CBImpressionError a = mo9332a(aVar.f6895a);
        if (a == null) {
            return a;
        }
        CBLogging.m8154b("AdUnitManager", "Video media unavailable for the impression");
        return a;
    }

    /* renamed from: a */
    private CBError.CBImpressionError m8507a(C2086a aVar, File file) {
        CBError.CBImpressionError cBImpressionError = null;
        for (C2087b next : aVar.f6897c.values()) {
            if (!next.mo9117a(file).exists()) {
                CBLogging.m8154b("AdUnitManager", "Asset does not exist: " + next.f6915b);
                cBImpressionError = CBError.CBImpressionError.ASSET_MISSING;
            }
        }
        return cBImpressionError;
    }

    /* renamed from: a */
    private CBError.CBImpressionError m8508a(String str, C2086a aVar) {
        if (str == null && aVar.f6896b == 1) {
            return CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW;
        }
        return null;
    }

    /* renamed from: a */
    private C2088c m8509a(C2151h hVar, String str) {
        C2151h hVar2 = hVar;
        C2086a aVar = hVar2.f7224d;
        C2139f fVar = r5;
        C2139f fVar2 = new C2139f(this, hVar2);
        return new C2088c(aVar, fVar, this.f7170c, this.f7171d, this.f7173f, this.f7175h, this.f7177j, this.f7178k, this.f7179l, this.f7180m, this.f7181n, this.f7182o, this.f7183p, hVar2.f7222b, str, this.f7184q);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9334a(C2151h hVar, CBError.CBImpressionError cBImpressionError) {
        m8521c(hVar, cBImpressionError);
        if (hVar.f7223c != 7) {
            return;
        }
        if (cBImpressionError == CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE) {
            hVar.f7223c = 6;
            hVar.f7230j = null;
            hVar.f7229i = null;
            hVar.f7233m = null;
            return;
        }
        m8522d(hVar);
        m8530i(hVar);
        mo9345f();
    }

    /* renamed from: a */
    private int m8505a(C2070b bVar) {
        if (bVar != null) {
            return bVar.actionType == 1 ? 6 : 7;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9333a(C2151h hVar) {
        if (hVar.f7223c == 7) {
            if (hVar.f7229i != null && hVar.f7233m == null) {
                hVar.f7233m = Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(this.f7176i.mo9111b() - hVar.f7229i.longValue()));
            }
            m8516b(hVar, "ad-unit-shown");
            this.f7192y.remove(hVar.f7222b);
            Handler handler = this.f7178k;
            C2117a aVar = this.f7183p;
            aVar.getClass();
            handler.post(new C2117a.C2118a(5, hVar.f7222b, (CBError.CBImpressionError) null, (C2070b) null));
            m8524f(hVar);
            m8530i(hVar);
            mo9345f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CBError.CBImpressionError mo9332a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return CBError.CBImpressionError.INVALID_RESPONSE;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("assets");
        if (optJSONObject == null) {
            return CBError.CBImpressionError.INVALID_RESPONSE;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(CBUtility.m8171b(CBUtility.m8174e()) ? "video-portrait" : "video-landscape");
        if (optJSONObject2 == null) {
            return CBError.CBImpressionError.VIDEO_UNAVAILABLE_FOR_CURRENT_ORIENTATION;
        }
        String optString = optJSONObject2.optString("id");
        if (optString.isEmpty()) {
            return CBError.CBImpressionError.VIDEO_ID_MISSING;
        }
        if (new File(this.f7170c.mo9089a().f6870d, optString).exists()) {
            return null;
        }
        return CBError.CBImpressionError.VIDEO_UNAVAILABLE;
    }
}
