package com.onesignal;

import android.os.Build;
import com.facebook.places.model.PlaceFields;
import com.onesignal.C4508g0;
import com.onesignal.C4516h1;
import com.onesignal.C4541l0;
import com.onesignal.C4564n1;
import com.onesignal.C4731y1;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.m0 */
/* compiled from: OSInAppMessageController */
class C4548m0 implements C4508g0.C4511c, C4516h1.C4518b {

    /* renamed from: o */
    private static ArrayList<String> f12428o = new C4551c();

    /* renamed from: p */
    private static C4548m0 f12429p;

    /* renamed from: a */
    C4530j1 f12430a = new C4530j1(this);

    /* renamed from: b */
    private C4516h1 f12431b = new C4516h1(this);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C4641s0 f12432c;

    /* renamed from: d */
    private ArrayList<C4535k0> f12433d = new ArrayList<>();

    /* renamed from: e */
    private final Set<String> f12434e = C4536k1.m15642k();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Set<String> f12435f = C4536k1.m15642k();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Set<String> f12436g = C4536k1.m15642k();

    /* renamed from: h */
    private final ArrayList<C4535k0> f12437h = new ArrayList<>();

    /* renamed from: i */
    private List<C4535k0> f12438i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C4636r0 f12439j = null;

    /* renamed from: k */
    private boolean f12440k = true;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f12441l = false;

    /* renamed from: m */
    Date f12442m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f12443n = 0;

    /* renamed from: com.onesignal.m0$c */
    /* compiled from: OSInAppMessageController */
    static class C4551c extends ArrayList<String> {
        C4551c() {
            add("android");
            add(TapjoyConstants.TJC_APP_PLACEMENT);
            add("all");
        }
    }

    /* renamed from: com.onesignal.m0$d */
    /* compiled from: OSInAppMessageController */
    class C4552d implements Runnable {
        C4552d() {
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            C4548m0.this.f12432c.mo29943a();
        }
    }

    /* renamed from: com.onesignal.m0$e */
    /* compiled from: OSInAppMessageController */
    class C4553e extends JSONObject {

        /* renamed from: a */
        final /* synthetic */ String f12448a;

        C4553e(C4548m0 m0Var, String str) throws JSONException {
            this.f12448a = str;
            put("app_id", C4564n1.f12493c);
            put("player_id", C4564n1.m15759I());
            put("variant_id", this.f12448a);
            put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, new C4536k1().mo29827c());
            put("first_impression", true);
        }
    }

    /* renamed from: com.onesignal.m0$g */
    /* compiled from: OSInAppMessageController */
    class C4555g implements C4564n1.C4576f0 {

        /* renamed from: a */
        final /* synthetic */ C4535k0 f12451a;

        /* renamed from: b */
        final /* synthetic */ List f12452b;

        C4555g(C4535k0 k0Var, List list) {
            this.f12451a = k0Var;
            this.f12452b = list;
        }

        /* renamed from: a */
        public void mo29841a(boolean z) {
            C4636r0 unused = C4548m0.this.f12439j = null;
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var, "IAM prompt to handle finished accepted: " + z);
            C4548m0.this.m15696b(this.f12451a, (List<C4636r0>) this.f12452b);
        }
    }

    /* renamed from: com.onesignal.m0$h */
    /* compiled from: OSInAppMessageController */
    class C4556h implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4541l0 f12454a;

        C4556h(C4548m0 m0Var, C4541l0 l0Var) {
            this.f12454a = l0Var;
        }

        public void run() {
            C4564n1.f12474F.f12544d.mo29889a(this.f12454a);
        }
    }

    /* renamed from: com.onesignal.m0$i */
    /* compiled from: OSInAppMessageController */
    class C4557i extends JSONObject {

        /* renamed from: a */
        final /* synthetic */ String f12455a;

        /* renamed from: b */
        final /* synthetic */ String f12456b;

        /* renamed from: c */
        final /* synthetic */ C4541l0 f12457c;

        C4557i(C4548m0 m0Var, String str, String str2, C4541l0 l0Var) throws JSONException {
            this.f12455a = str;
            this.f12456b = str2;
            this.f12457c = l0Var;
            put("app_id", C4564n1.m15753C());
            put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, new C4536k1().mo29827c());
            put("player_id", C4564n1.m15759I());
            put("click_id", this.f12455a);
            put("variant_id", this.f12456b);
            if (this.f12457c.f12417g) {
                put("first_click", true);
            }
        }
    }

    /* renamed from: com.onesignal.m0$k */
    /* compiled from: OSInAppMessageController */
    class C4559k implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4535k0 f12460a;

        C4559k(C4535k0 k0Var) {
            this.f12460a = k0Var;
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            C4548m0.this.f12432c.mo29944a(this.f12460a);
        }
    }

    protected C4548m0(C4655t1 t1Var) {
        Set<String> a = C4698w1.m16345a(C4698w1.f12761a, "PREFS_OS_DISPLAYED_IAMS", (Set<String>) null);
        if (a != null) {
            this.f12434e.addAll(a);
        }
        Set<String> a2 = C4698w1.m16345a(C4698w1.f12761a, "PREFS_OS_IMPRESSIONED_IAMS", (Set<String>) null);
        if (a2 != null) {
            this.f12435f.addAll(a2);
        }
        Set<String> a3 = C4698w1.m16345a(C4698w1.f12761a, "PREFS_OS_CLICKED_CLICK_IDS_IAMS", (Set<String>) null);
        if (a3 != null) {
            this.f12436g.addAll(a3);
        }
        mo29833a(t1Var);
    }

    /* renamed from: e */
    static /* synthetic */ int m15708e(C4548m0 m0Var) {
        int i = m0Var.f12443n;
        m0Var.f12443n = i + 1;
        return i;
    }

    /* renamed from: f */
    private void m15711f() {
        new Thread(new C4552d(), "OS_DELETE_IN_APP_MESSAGE").start();
    }

    /* renamed from: g */
    private void m15713g() {
        Iterator<C4535k0> it = this.f12433d.iterator();
        while (it.hasNext()) {
            C4535k0 next = it.next();
            m15716h(next);
            if (!this.f12434e.contains(next.f12392a) && this.f12430a.mo29804a(next)) {
                m15714g(next);
            }
        }
    }

    /* renamed from: h */
    public static C4548m0 m15715h() {
        C4655t1 s = C4564n1.m15877s();
        if (Build.VERSION.SDK_INT <= 18) {
            f12429p = new C4605o0((C4655t1) null);
        }
        if (f12429p == null) {
            f12429p = new C4548m0(s);
        }
        return f12429p;
    }

    /* renamed from: i */
    private void m15718i() {
        for (C4535k0 a : this.f12438i) {
            a.mo29812a(false);
        }
    }

    /* renamed from: com.onesignal.m0$b */
    /* compiled from: OSInAppMessageController */
    class C4550b extends C4731y1.C4738g {
        C4550b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            C4548m0.m15699b(TJAdUnitConstants.String.HTML, i, str);
            C4548m0.this.m15703c((C4535k0) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(TJAdUnitConstants.String.HTML);
                C4535k0 k0Var = new C4535k0(true);
                k0Var.mo29810a(jSONObject.optDouble("display_duration"));
                C4701w2.m16369a(k0Var, string);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private void m15707d(C4541l0 l0Var) {
        if (l0Var.f12416f != null) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var, "Tags detected inside of the action click payload, ignoring because action came from IAM preview:: " + l0Var.f12416f.toString());
        }
        if (l0Var.f12414d.size() > 0) {
            C4564n1.C4566a0 a0Var2 = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var2, "Outcomes detected inside of the action click payload, ignoring because action came from IAM preview: " + l0Var.f12414d.toString());
        }
    }

    /* renamed from: e */
    private void m15710e() {
        synchronized (this.f12437h) {
            if (!this.f12431b.mo29780a()) {
                C4564n1.m15815b(C4564n1.C4566a0.WARN, "In app message not showing due to system condition not correct");
                return;
            }
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var, "displayFirstIAMOnQueue: " + this.f12437h);
            if (this.f12437h.size() <= 0 || mo29839d()) {
                C4564n1.m15815b(C4564n1.C4566a0.DEBUG, "In app message is currently showing or there are no IAMs left in the queue!");
                return;
            }
            C4564n1.m15815b(C4564n1.C4566a0.DEBUG, "No IAM showing currently, showing first item in the queue!");
            m15706d(this.f12437h.get(0));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo29838c() {
        if (this.f12433d.isEmpty()) {
            String a = C4698w1.m16344a(C4698w1.f12761a, "PREFS_OS_CACHED_IAMS", (String) null);
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15789a(a0Var, "initWithCachedInAppMessages: " + a);
            if (a != null) {
                try {
                    m15701b(new JSONArray(a));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    private void m15701b(JSONArray jSONArray) throws JSONException {
        ArrayList<C4535k0> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C4535k0(jSONArray.getJSONObject(i)));
        }
        this.f12433d = arrayList;
        m15713g();
    }

    /* renamed from: f */
    private void m15712f(C4535k0 k0Var) {
        if (k0Var.mo29817d().mo29856e()) {
            k0Var.mo29817d().mo29851a(System.currentTimeMillis() / 1000);
            k0Var.mo29817d().mo29854c();
            k0Var.mo29814b(false);
            k0Var.mo29812a(true);
            new Thread(new C4559k(k0Var), "OS_SAVE_IN_APP_MESSAGE").start();
            int indexOf = this.f12438i.indexOf(k0Var);
            if (indexOf != -1) {
                this.f12438i.set(indexOf, k0Var);
            } else {
                this.f12438i.add(k0Var);
            }
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var, "persistInAppMessageForRedisplay: " + k0Var.toString() + " with msg array data: " + this.f12438i.toString());
        }
    }

    /* renamed from: i */
    private static String m15717i(C4535k0 k0Var) {
        String e = C4536k1.m15636e();
        Iterator<String> it = f12428o.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (k0Var.f12393b.containsKey(next)) {
                HashMap hashMap = k0Var.f12393b.get(next);
                if (hashMap.containsKey(e)) {
                    return (String) hashMap.get(e);
                }
                return (String) hashMap.get("default");
            }
        }
        return null;
    }

    /* renamed from: com.onesignal.m0$f */
    /* compiled from: OSInAppMessageController */
    class C4554f extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ C4535k0 f12449a;

        C4554f(C4535k0 k0Var) {
            this.f12449a = k0Var;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            C4548m0.m15700b("impression", str);
            C4698w1.m16354b(C4698w1.f12761a, "PREFS_OS_IMPRESSIONED_IAMS", (Set<String>) C4548m0.this.f12435f);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            C4548m0.m15699b("impression", i, str);
            C4548m0.this.f12435f.remove(this.f12449a.f12392a);
        }
    }

    /* renamed from: com.onesignal.m0$j */
    /* compiled from: OSInAppMessageController */
    class C4558j extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ C4541l0 f12458a;

        C4558j(C4541l0 l0Var) {
            this.f12458a = l0Var;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            C4548m0.m15700b(PlaceFields.ENGAGEMENT, str);
            C4698w1.m16354b(C4698w1.f12761a, "PREFS_OS_CLICKED_CLICK_IDS_IAMS", (Set<String>) C4548m0.this.f12436g);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            C4548m0.m15699b(PlaceFields.ENGAGEMENT, i, str);
            C4548m0.this.f12436g.remove(this.f12458a.f12411a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m15714g(C4535k0 k0Var) {
        synchronized (this.f12437h) {
            if (!this.f12437h.contains(k0Var)) {
                this.f12437h.add(k0Var);
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
                C4564n1.m15815b(a0Var, "In app message with id, " + k0Var.f12392a + ", added to the queue");
            }
            m15710e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo29839d() {
        return this.f12441l;
    }

    /* renamed from: com.onesignal.m0$a */
    /* compiled from: OSInAppMessageController */
    class C4549a extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ C4535k0 f12444a;

        C4549a(C4535k0 k0Var) {
            this.f12444a = k0Var;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            boolean unused = C4548m0.this.f12441l = false;
            C4548m0.m15699b(TJAdUnitConstants.String.HTML, i, str);
            if (!C4536k1.m15624a(i) || C4548m0.this.f12443n >= C4536k1.f12402a) {
                int unused2 = C4548m0.this.f12443n = 0;
                C4548m0.this.mo29831a(this.f12444a);
                return;
            }
            C4548m0.m15708e(C4548m0.this);
            C4548m0.this.m15714g(this.f12444a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            int unused = C4548m0.this.f12443n = 0;
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(TJAdUnitConstants.String.HTML);
                this.f12444a.mo29810a(jSONObject.optDouble("display_duration"));
                C4701w2.m16369a(this.f12444a, string);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m15704c(C4541l0 l0Var) {
        C4654t0 t0Var = l0Var.f12416f;
        if (t0Var != null) {
            if (t0Var.mo29960a() != null) {
                C4564n1.m15833d(t0Var.mo29960a());
            }
            if (t0Var.mo29961b() != null) {
                C4564n1.m15798a(t0Var.mo29961b(), (C4564n1.C4593s) null);
            }
        }
    }

    /* renamed from: d */
    private void m15706d(C4535k0 k0Var) {
        if (!this.f12440k) {
            C4564n1.m15815b(C4564n1.C4566a0.VERBOSE, "In app messaging is currently paused, iam will not be shown!");
            return;
        }
        this.f12441l = true;
        C4731y1.m16448b(m15709e(k0Var), (C4731y1.C4738g) new C4549a(k0Var), (String) null);
    }

    /* renamed from: h */
    private void m15716h(C4535k0 k0Var) {
        if (k0Var.mo29817d().mo29856e()) {
            boolean contains = this.f12434e.contains(k0Var.f12392a);
            int indexOf = this.f12438i.indexOf(k0Var);
            if (contains && indexOf != -1) {
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
                C4564n1.m15815b(a0Var, "setDataForRedisplay: " + k0Var.f12392a);
                C4535k0 k0Var2 = this.f12438i.get(indexOf);
                k0Var.mo29817d().mo29852a(k0Var2.mo29817d());
                if ((k0Var.mo29820f() || (!k0Var2.mo29818e() && k0Var.f12394c.isEmpty())) && k0Var.mo29817d().mo29855d() && k0Var.mo29817d().mo29857f()) {
                    this.f12434e.remove(k0Var.f12392a);
                    this.f12435f.remove(k0Var.f12392a);
                    k0Var.mo29809a();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29833a(C4655t1 t1Var) {
        C4641s0 s0Var = new C4641s0(t1Var);
        this.f12432c = s0Var;
        this.f12438i = s0Var.mo29945b();
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
        C4564n1.m15789a(a0Var, "redisplayedInAppMessages: " + this.f12438i.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m15700b(String str, String str2) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
        C4564n1.m15815b(a0Var, "Successful post for in-app message " + str + " request: " + str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m15699b(String str, int i, String str2) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
        C4564n1.m15815b(a0Var, "Encountered a " + i + " error while attempting in-app message " + str + " request: " + str2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0091, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15703c(com.onesignal.C4535k0 r6) {
        /*
            r5 = this;
            com.onesignal.r0 r0 = r5.f12439j
            if (r0 == 0) goto L_0x000c
            com.onesignal.n1$a0 r6 = com.onesignal.C4564n1.C4566a0.DEBUG
            java.lang.String r0 = "Stop evaluateMessageDisplayQueue because prompt is currently displayed"
            com.onesignal.C4564n1.m15815b((com.onesignal.C4564n1.C4566a0) r6, (java.lang.String) r0)
            return
        L_0x000c:
            r0 = 0
            r5.f12441l = r0
            java.util.ArrayList<com.onesignal.k0> r1 = r5.f12437h
            monitor-enter(r1)
            java.util.ArrayList<com.onesignal.k0> r2 = r5.f12437h     // Catch:{ all -> 0x0092 }
            int r2 = r2.size()     // Catch:{ all -> 0x0092 }
            if (r2 <= 0) goto L_0x0052
            if (r6 == 0) goto L_0x002d
            java.util.ArrayList<com.onesignal.k0> r2 = r5.f12437h     // Catch:{ all -> 0x0092 }
            boolean r6 = r2.contains(r6)     // Catch:{ all -> 0x0092 }
            if (r6 != 0) goto L_0x002d
            com.onesignal.n1$a0 r6 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = "Message already removed from the queue!"
            com.onesignal.C4564n1.m15815b((com.onesignal.C4564n1.C4566a0) r6, (java.lang.String) r0)     // Catch:{ all -> 0x0092 }
            monitor-exit(r1)     // Catch:{ all -> 0x0092 }
            return
        L_0x002d:
            java.util.ArrayList<com.onesignal.k0> r6 = r5.f12437h     // Catch:{ all -> 0x0092 }
            java.lang.Object r6 = r6.remove(r0)     // Catch:{ all -> 0x0092 }
            com.onesignal.k0 r6 = (com.onesignal.C4535k0) r6     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = r6.f12392a     // Catch:{ all -> 0x0092 }
            com.onesignal.n1$a0 r2 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x0092 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r3.<init>()     // Catch:{ all -> 0x0092 }
            java.lang.String r4 = "In app message with id, "
            r3.append(r4)     // Catch:{ all -> 0x0092 }
            r3.append(r6)     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = ", dismissed (removed) from the queue!"
            r3.append(r6)     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0092 }
            com.onesignal.C4564n1.m15815b((com.onesignal.C4564n1.C4566a0) r2, (java.lang.String) r6)     // Catch:{ all -> 0x0092 }
        L_0x0052:
            java.util.ArrayList<com.onesignal.k0> r6 = r5.f12437h     // Catch:{ all -> 0x0092 }
            int r6 = r6.size()     // Catch:{ all -> 0x0092 }
            if (r6 <= 0) goto L_0x0086
            com.onesignal.n1$a0 r6 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x0092 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r2.<init>()     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = "In app message on queue available: "
            r2.append(r3)     // Catch:{ all -> 0x0092 }
            java.util.ArrayList<com.onesignal.k0> r3 = r5.f12437h     // Catch:{ all -> 0x0092 }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0092 }
            com.onesignal.k0 r3 = (com.onesignal.C4535k0) r3     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = r3.f12392a     // Catch:{ all -> 0x0092 }
            r2.append(r3)     // Catch:{ all -> 0x0092 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0092 }
            com.onesignal.C4564n1.m15815b((com.onesignal.C4564n1.C4566a0) r6, (java.lang.String) r2)     // Catch:{ all -> 0x0092 }
            java.util.ArrayList<com.onesignal.k0> r6 = r5.f12437h     // Catch:{ all -> 0x0092 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ all -> 0x0092 }
            com.onesignal.k0 r6 = (com.onesignal.C4535k0) r6     // Catch:{ all -> 0x0092 }
            r5.m15706d((com.onesignal.C4535k0) r6)     // Catch:{ all -> 0x0092 }
            goto L_0x0090
        L_0x0086:
            com.onesignal.n1$a0 r6 = com.onesignal.C4564n1.C4566a0.DEBUG     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = "In app message dismissed evaluating messages"
            com.onesignal.C4564n1.m15815b((com.onesignal.C4564n1.C4566a0) r6, (java.lang.String) r0)     // Catch:{ all -> 0x0092 }
            r5.m15713g()     // Catch:{ all -> 0x0092 }
        L_0x0090:
            monitor-exit(r1)     // Catch:{ all -> 0x0092 }
            return
        L_0x0092:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0092 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4548m0.m15703c(com.onesignal.k0):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29835a(JSONArray jSONArray) throws JSONException {
        C4698w1.m16353b(C4698w1.f12761a, "PREFS_OS_CACHED_IAMS", jSONArray.toString());
        m15718i();
        m15701b(jSONArray);
        m15711f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29836b(C4535k0 k0Var) {
        if (!k0Var.f12401j && !this.f12435f.contains(k0Var.f12392a)) {
            this.f12435f.add(k0Var.f12392a);
            String i = m15717i(k0Var);
            if (i != null) {
                try {
                    C4553e eVar = new C4553e(this, i);
                    C4731y1.m16446a("in_app_messages/" + k0Var.f12392a + "/impression", (JSONObject) eVar, (C4731y1.C4738g) new C4554f(k0Var));
                } catch (JSONException e) {
                    e.printStackTrace();
                    C4564n1.m15815b(C4564n1.C4566a0.ERROR, "Unable to execute in-app message impression HTTP request due to invalid JSON");
                }
            }
        }
    }

    /* renamed from: e */
    private static String m15709e(C4535k0 k0Var) {
        String i = m15717i(k0Var);
        if (i == null) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
            C4564n1.m15815b(a0Var, "Unable to find a variant for in-app message " + k0Var.f12392a);
            return null;
        }
        return "in_app_messages/" + k0Var.f12392a + "/variants/" + i + "/html?app_id=" + C4564n1.f12493c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29832a(C4535k0 k0Var, JSONObject jSONObject) throws JSONException {
        C4541l0 l0Var = new C4541l0(jSONObject);
        l0Var.f12417g = k0Var.mo29821g();
        m15697b(l0Var);
        m15687a(k0Var, l0Var.f12415e);
        m15688a(l0Var);
        m15686a(k0Var, l0Var);
        m15704c(l0Var);
        m15693a(l0Var.f12414d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29837b(C4535k0 k0Var, JSONObject jSONObject) throws JSONException {
        C4541l0 l0Var = new C4541l0(jSONObject);
        l0Var.f12417g = k0Var.mo29821g();
        m15697b(l0Var);
        m15687a(k0Var, l0Var.f12415e);
        m15688a(l0Var);
        m15707d(l0Var);
    }

    /* renamed from: a */
    private void m15687a(C4535k0 k0Var, List<C4636r0> list) {
        if (list.size() > 0) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var, "IAM showing prompts from IAM: " + k0Var.toString());
            C4701w2.m16384c();
            m15696b(k0Var, list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15696b(C4535k0 k0Var, List<C4636r0> list) {
        Iterator<C4636r0> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C4636r0 next = it.next();
            if (!next.mo29937b()) {
                this.f12439j = next;
                break;
            }
        }
        if (this.f12439j != null) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var, "IAM prompt to handle: " + this.f12439j.toString());
            this.f12439j.mo29936a(true);
            this.f12439j.mo29904a((C4564n1.C4576f0) new C4555g(k0Var, list));
            return;
        }
        C4564n1.C4566a0 a0Var2 = C4564n1.C4566a0.DEBUG;
        C4564n1.m15815b(a0Var2, "No IAM prompt to handle, dismiss message: " + k0Var.f12392a);
        mo29831a(k0Var);
    }

    /* renamed from: a */
    private void m15693a(List<C4626q0> list) {
        for (C4626q0 next : list) {
            String a = next.mo29919a();
            if (next.mo29921c()) {
                C4564n1.m15849g(a);
            } else if (next.mo29920b() > 0.0f) {
                C4564n1.m15795a(a, next.mo29920b());
            } else {
                C4564n1.m15843f(a);
            }
        }
    }

    /* renamed from: b */
    private void m15697b(C4541l0 l0Var) {
        if (C4564n1.f12474F.f12544d != null) {
            C4536k1.m15622a((Runnable) new C4556h(this, l0Var));
        }
    }

    /* renamed from: a */
    private void m15688a(C4541l0 l0Var) {
        String str = l0Var.f12413c;
        if (str != null && !str.isEmpty()) {
            C4541l0.C4542a aVar = l0Var.f12412b;
            if (aVar == C4541l0.C4542a.BROWSER) {
                C4536k1.m15632b(l0Var.f12413c);
            } else if (aVar == C4541l0.C4542a.IN_APP_WEBVIEW) {
                C4637r1.m16078a(l0Var.f12413c, true);
            }
        }
    }

    /* renamed from: b */
    public void mo29782b() {
        m15710e();
    }

    /* renamed from: a */
    private void m15686a(C4535k0 k0Var, C4541l0 l0Var) {
        String i = m15717i(k0Var);
        if (i != null) {
            String str = l0Var.f12411a;
            if ((k0Var.mo29817d().mo29856e() && k0Var.mo29815b(str)) || !this.f12436g.contains(str)) {
                this.f12436g.add(str);
                k0Var.mo29811a(str);
                try {
                    C4557i iVar = new C4557i(this, str, i, l0Var);
                    C4731y1.m16446a("in_app_messages/" + k0Var.f12392a + "/click", (JSONObject) iVar, (C4731y1.C4738g) new C4558j(l0Var));
                } catch (JSONException e) {
                    e.printStackTrace();
                    C4564n1.m15815b(C4564n1.C4566a0.ERROR, "Unable to execute in-app message action HTTP request due to invalid JSON");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29831a(C4535k0 k0Var) {
        if (!k0Var.f12401j) {
            this.f12434e.add(k0Var.f12392a);
            C4698w1.m16354b(C4698w1.f12761a, "PREFS_OS_DISPLAYED_IAMS", this.f12434e);
            this.f12442m = new Date();
            m15712f(k0Var);
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15815b(a0Var, "OSInAppMessageController messageWasDismissed dismissedMessages: " + this.f12434e.toString());
        }
        m15703c(k0Var);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29834a(String str) {
        this.f12441l = true;
        C4731y1.m16444a("in_app_messages/device_preview?preview_id=" + str + "&app_id=" + C4564n1.f12493c, (C4731y1.C4738g) new C4550b(), (String) null);
    }

    /* renamed from: a */
    public void mo29775a() {
        m15713g();
    }
}
