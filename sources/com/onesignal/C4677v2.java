package com.onesignal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.games.Games;
import com.onesignal.C4564n1;
import com.onesignal.C4686w;
import com.onesignal.C4731y1;
import com.onesignal.C4742z1;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.v2 */
/* compiled from: UserStateSynchronizer */
abstract class C4677v2 {

    /* renamed from: a */
    private C4742z1.C4743a f12711a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f12712b;

    /* renamed from: c */
    protected final Object f12713c = new C4678a(this);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicBoolean f12714d = new AtomicBoolean();

    /* renamed from: e */
    private final Queue<C4564n1.C4593s> f12715e = new ConcurrentLinkedQueue();

    /* renamed from: f */
    private final Queue<C4564n1.C4574e0> f12716f = new ConcurrentLinkedQueue();

    /* renamed from: g */
    HashMap<Integer, C4684g> f12717g = new HashMap<>();

    /* renamed from: h */
    private final Object f12718h = new C4679b(this);

    /* renamed from: i */
    protected boolean f12719i = false;

    /* renamed from: j */
    protected C4629q2 f12720j;

    /* renamed from: k */
    protected C4629q2 f12721k;

    /* renamed from: com.onesignal.v2$a */
    /* compiled from: UserStateSynchronizer */
    class C4678a {
        C4678a(C4677v2 v2Var) {
        }
    }

    /* renamed from: com.onesignal.v2$b */
    /* compiled from: UserStateSynchronizer */
    class C4679b {
        C4679b(C4677v2 v2Var) {
        }
    }

    /* renamed from: com.onesignal.v2$f */
    /* compiled from: UserStateSynchronizer */
    static class C4683f {

        /* renamed from: a */
        boolean f12730a;

        /* renamed from: b */
        JSONObject f12731b;

        C4683f(boolean z, JSONObject jSONObject) {
            this.f12730a = z;
            this.f12731b = jSONObject;
        }
    }

    /* renamed from: com.onesignal.v2$g */
    /* compiled from: UserStateSynchronizer */
    class C4684g extends HandlerThread {

        /* renamed from: a */
        int f12732a;

        /* renamed from: b */
        Handler f12733b = null;

        /* renamed from: c */
        int f12734c;

        /* renamed from: com.onesignal.v2$g$a */
        /* compiled from: UserStateSynchronizer */
        class C4685a implements Runnable {
            C4685a() {
            }

            public void run() {
                if (!C4677v2.this.f12714d.get()) {
                    C4677v2.this.mo30001b(false);
                }
            }
        }

        C4684g(int i) {
            super("OSH_NetworkHandlerThread");
            this.f12732a = i;
            start();
            this.f12733b = new Handler(getLooper());
        }

        /* renamed from: c */
        private Runnable m16313c() {
            if (this.f12732a != 0) {
                return null;
            }
            return new C4685a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo30011a() {
            boolean hasMessages;
            synchronized (this.f12733b) {
                boolean z = this.f12734c < 3;
                boolean hasMessages2 = this.f12733b.hasMessages(0);
                if (z && !hasMessages2) {
                    this.f12734c++;
                    this.f12733b.postDelayed(m16313c(), (long) (this.f12734c * 15000));
                }
                hasMessages = this.f12733b.hasMessages(0);
            }
            return hasMessages;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo30012b() {
            if (C4677v2.this.f12712b) {
                synchronized (this.f12733b) {
                    this.f12734c = 0;
                    this.f12733b.removeCallbacksAndMessages((Object) null);
                    this.f12733b.postDelayed(m16313c(), 5000);
                }
            }
        }
    }

    C4677v2(C4742z1.C4743a aVar) {
        this.f12711a = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void mo29953m() {
        while (true) {
            C4564n1.C4574e0 poll = this.f12716f.poll();
            if (poll != null) {
                poll.mo29865a(mo29995a(), false);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void mo29993n() {
        while (true) {
            C4564n1.C4574e0 poll = this.f12716f.poll();
            if (poll != null) {
                poll.mo29865a(mo29995a(), true);
            } else {
                return;
            }
        }
    }

    /* renamed from: o */
    private void m16277o() {
        JSONObject a = this.f12720j.mo29925a(this.f12721k, false);
        if (a != null) {
            mo29949b(a);
        }
        if (mo30005f().f12624b.optBoolean("logoutEmail", false)) {
            C4564n1.m15763M();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m16278p() {
        C4564n1.m15789a(C4564n1.C4566a0.WARN, "Creating new player based on missing player_id noted above.");
        C4564n1.m15764N();
        mo30009j();
        mo29947a((String) null);
        mo29952k();
    }

    /* renamed from: q */
    private boolean m16279q() {
        return (mo30005f().f12624b.optBoolean("session") || mo29950c() == null) && !this.f12719i;
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m16280r() {
        mo30005f().f12624b.remove("logoutEmail");
        this.f12721k.f12624b.remove("email_auth_hash");
        this.f12721k.f12625c.remove("parent_player_id");
        this.f12721k.mo29932c();
        this.f12720j.f12624b.remove("email_auth_hash");
        this.f12720j.f12625c.remove("parent_player_id");
        String optString = this.f12720j.f12625c.optString(Scopes.EMAIL);
        this.f12720j.f12625c.remove(Scopes.EMAIL);
        C4742z1.m16482l();
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.INFO;
        C4564n1.m15789a(a0Var, "Device successfully logged out of email: " + optString);
        C4564n1.m15764N();
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m16281s() {
        JSONObject jSONObject = C4742z1.m16463a(false).f12731b;
        while (true) {
            C4564n1.C4593s poll = this.f12715e.poll();
            if (poll != null) {
                poll.onSuccess(jSONObject);
            } else {
                return;
            }
        }
    }

    /* renamed from: t */
    private boolean m16282t() {
        return mo30005f().f12624b.optBoolean("logoutEmail", false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C4629q2 mo29946a(String str, boolean z);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo29947a(String str);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo29948a(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo29949b(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract String mo29950c();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo29951c(JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo30007h() {
        synchronized (this.f12713c) {
            if (this.f12720j == null) {
                this.f12720j = mo29946a("CURRENT_STATE", true);
            }
        }
        mo30005f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo30008i() {
        boolean z = false;
        if (this.f12721k == null) {
            return false;
        }
        synchronized (this.f12713c) {
            if (this.f12720j.mo29925a(this.f12721k, m16279q()) != null) {
                z = true;
            }
            this.f12721k.mo29932c();
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo30009j() {
        this.f12720j.f12625c = new JSONObject();
        this.f12720j.mo29932c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public abstract void mo29952k();

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo30010l() {
        try {
            synchronized (this.f12713c) {
                mo30006g().f12624b.put("session", true);
                mo30006g().mo29932c();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r7 != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        m16268b(r0, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        m16262a(r0, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mo29989c(boolean r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.mo29950c()
            boolean r1 = r6.m16282t()
            if (r1 == 0) goto L_0x0010
            if (r0 == 0) goto L_0x0010
            r6.m16267b((java.lang.String) r0)
            return
        L_0x0010:
            com.onesignal.q2 r1 = r6.f12720j
            if (r1 != 0) goto L_0x0017
            r6.mo30007h()
        L_0x0017:
            if (r7 != 0) goto L_0x0021
            boolean r7 = r6.m16279q()
            if (r7 == 0) goto L_0x0021
            r7 = 1
            goto L_0x0022
        L_0x0021:
            r7 = 0
        L_0x0022:
            java.lang.Object r1 = r6.f12713c
            monitor-enter(r1)
            com.onesignal.q2 r2 = r6.f12720j     // Catch:{ all -> 0x005f }
            com.onesignal.q2 r3 = r6.mo30005f()     // Catch:{ all -> 0x005f }
            org.json.JSONObject r2 = r2.mo29925a((com.onesignal.C4629q2) r3, (boolean) r7)     // Catch:{ all -> 0x005f }
            com.onesignal.q2 r3 = r6.f12720j     // Catch:{ all -> 0x005f }
            org.json.JSONObject r3 = r3.f12624b     // Catch:{ all -> 0x005f }
            com.onesignal.q2 r4 = r6.mo30005f()     // Catch:{ all -> 0x005f }
            org.json.JSONObject r4 = r4.f12624b     // Catch:{ all -> 0x005f }
            r5 = 0
            org.json.JSONObject r3 = r6.mo29996a((org.json.JSONObject) r3, (org.json.JSONObject) r4, (org.json.JSONObject) r5, (java.util.Set<java.lang.String>) r5)     // Catch:{ all -> 0x005f }
            if (r2 != 0) goto L_0x004d
            com.onesignal.q2 r7 = r6.f12720j     // Catch:{ all -> 0x005f }
            r7.mo29930b(r3, r5)     // Catch:{ all -> 0x005f }
            r6.m16281s()     // Catch:{ all -> 0x005f }
            r6.mo29993n()     // Catch:{ all -> 0x005f }
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            return
        L_0x004d:
            com.onesignal.q2 r4 = r6.mo30005f()     // Catch:{ all -> 0x005f }
            r4.mo29932c()     // Catch:{ all -> 0x005f }
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            if (r7 != 0) goto L_0x005b
            r6.m16268b(r0, r2, r3)
            goto L_0x005e
        L_0x005b:
            r6.m16262a((java.lang.String) r0, (org.json.JSONObject) r2, (org.json.JSONObject) r3)
        L_0x005e:
            return
        L_0x005f:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4677v2.mo29989c(boolean):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C4629q2 mo30000b() {
        synchronized (this.f12713c) {
            if (this.f12720j == null) {
                this.f12720j = mo29946a("CURRENT_STATE", true);
            }
        }
        return this.f12720j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo30002d() {
        return mo30005f().f12625c.optString("identifier", (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo30004e() {
        return mo30006g().f12624b.optBoolean("session");
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C4629q2 mo30005f() {
        synchronized (this.f12713c) {
            if (this.f12721k == null) {
                this.f12721k = mo29946a("TOSYNC_STATE", true);
            }
        }
        return this.f12721k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public C4629q2 mo30006g() {
        if (this.f12721k == null) {
            this.f12721k = mo30000b().mo29924a("TOSYNC_STATE");
        }
        mo29952k();
        return this.f12721k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo30003d(JSONObject jSONObject) {
        JSONObject jSONObject2 = mo30006g().f12625c;
        mo29996a(jSONObject2, jSONObject, jSONObject2, (Set<String>) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo29995a() {
        return this.f12711a.name().toLowerCase();
    }

    /* renamed from: com.onesignal.v2$c */
    /* compiled from: UserStateSynchronizer */
    class C4680c extends C4731y1.C4738g {
        C4680c() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.WARN;
            C4564n1.m15789a(a0Var, "Failed last request. statusCode: " + i + "\nresponse: " + str);
            if (C4677v2.this.m16263a(i, str, "already logged out of email")) {
                C4677v2.this.m16280r();
            } else if (C4677v2.this.m16263a(i, str, "not a valid device_type")) {
                C4677v2.this.m16278p();
            } else {
                C4677v2.this.m16258a(i);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            C4677v2.this.m16280r();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo29996a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        JSONObject a;
        synchronized (this.f12713c) {
            a = C4673v.m16247a(jSONObject, jSONObject2, jSONObject3, set);
        }
        return a;
    }

    /* renamed from: com.onesignal.v2$e */
    /* compiled from: UserStateSynchronizer */
    class C4682e extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ JSONObject f12726a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f12727b;

        /* renamed from: c */
        final /* synthetic */ String f12728c;

        C4682e(JSONObject jSONObject, JSONObject jSONObject2, String str) {
            this.f12726a = jSONObject;
            this.f12727b = jSONObject2;
            this.f12728c = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            synchronized (C4677v2.this.f12713c) {
                C4677v2.this.f12719i = false;
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.WARN;
                C4564n1.m15789a(a0Var, "Failed last request. statusCode: " + i + "\nresponse: " + str);
                if (C4677v2.this.m16263a(i, str, "not a valid device_type")) {
                    C4677v2.this.m16278p();
                } else {
                    C4677v2.this.m16258a(i);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            synchronized (C4677v2.this.f12713c) {
                C4677v2.this.f12719i = false;
                C4677v2.this.f12720j.mo29930b(this.f12726a, this.f12727b);
                try {
                    C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
                    C4564n1.m15815b(a0Var, "doCreateOrNewSession:response: " + str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("id")) {
                        String optString = jSONObject.optString("id");
                        C4677v2.this.mo29947a(optString);
                        C4564n1.C4566a0 a0Var2 = C4564n1.C4566a0.INFO;
                        C4564n1.m15789a(a0Var2, "Device registered, UserId = " + optString);
                    } else {
                        C4564n1.C4566a0 a0Var3 = C4564n1.C4566a0.INFO;
                        C4564n1.m15789a(a0Var3, "session sent, UserId = " + this.f12728c);
                    }
                    C4677v2.this.mo30006g().f12624b.put("session", false);
                    C4677v2.this.mo30006g().mo29932c();
                    if (jSONObject.has("in_app_messages")) {
                        C4548m0.m15715h().mo29835a(jSONObject.getJSONArray("in_app_messages"));
                    }
                    C4677v2.this.mo29951c(this.f12727b);
                } catch (JSONException e) {
                    C4564n1.m15790a(C4564n1.C4566a0.ERROR, "ERROR parsing on_session or create JSON Response.", (Throwable) e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo30001b(boolean z) {
        this.f12714d.set(true);
        mo29989c(z);
        this.f12714d.set(false);
    }

    /* renamed from: a */
    private void m16262a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        String str2;
        if (str == null) {
            str2 = Games.EXTRA_PLAYER_IDS;
        } else {
            str2 = "players/" + str + "/on_session";
        }
        this.f12719i = true;
        mo29948a(jSONObject);
        C4731y1.m16449b(str2, jSONObject, (C4731y1.C4738g) new C4682e(jSONObject2, jSONObject, str));
    }

    /* renamed from: b */
    private void m16267b(String str) {
        String str2 = "players/" + str + "/email_logout";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.f12720j.f12624b;
            if (jSONObject2.has("email_auth_hash")) {
                jSONObject.put("email_auth_hash", jSONObject2.optString("email_auth_hash"));
            }
            JSONObject jSONObject3 = this.f12720j.f12625c;
            if (jSONObject3.has("parent_player_id")) {
                jSONObject.put("parent_player_id", jSONObject3.optString("parent_player_id"));
            }
            jSONObject.put("app_id", jSONObject3.optString("app_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C4731y1.m16449b(str2, jSONObject, (C4731y1.C4738g) new C4680c());
    }

    /* renamed from: com.onesignal.v2$d */
    /* compiled from: UserStateSynchronizer */
    class C4681d extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ JSONObject f12723a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f12724b;

        C4681d(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f12723a = jSONObject;
            this.f12724b = jSONObject2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
            C4564n1.m15789a(a0Var, "Failed PUT sync request with status code: " + i + " and response: " + str);
            synchronized (C4677v2.this.f12713c) {
                if (C4677v2.this.m16263a(i, str, "No user with this id found")) {
                    C4677v2.this.m16278p();
                } else {
                    C4677v2.this.m16258a(i);
                }
            }
            if (this.f12723a.has("tags")) {
                C4677v2.this.m16259a(new C4564n1.C4583i0(i, str));
            }
            if (this.f12723a.has("external_user_id")) {
                C4564n1.C4566a0 a0Var2 = C4564n1.C4566a0.ERROR;
                C4564n1.m15815b(a0Var2, "Error setting external user id for push with status code: " + i + " and message: " + str);
                C4677v2.this.mo29953m();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            synchronized (C4677v2.this.f12713c) {
                C4677v2.this.f12720j.mo29930b(this.f12724b, this.f12723a);
                C4677v2.this.mo29951c(this.f12723a);
            }
            if (this.f12723a.has("tags")) {
                C4677v2.this.m16281s();
            }
            if (this.f12723a.has("external_user_id")) {
                C4677v2.this.mo29993n();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16258a(int i) {
        if (i == 403) {
            C4564n1.m15789a(C4564n1.C4566a0.FATAL, "403 error updating player, omitting further retries!");
            m16277o();
        } else if (!mo29994a((Integer) 0).mo30011a()) {
            m16277o();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16263a(int i, String str, String str2) {
        if (i == 400 && str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has(ReportDBAdapter.ReportColumns.COLUMN_ERRORS) || !jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_ERRORS).contains(str2)) {
                    return false;
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4684g mo29994a(Integer num) {
        C4684g gVar;
        synchronized (this.f12718h) {
            if (!this.f12717g.containsKey(num)) {
                this.f12717g.put(num, new C4684g(num.intValue()));
            }
            gVar = this.f12717g.get(num);
        }
        return gVar;
    }

    /* renamed from: b */
    private void m16268b(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (str == null) {
            C4564n1.m15815b(C4564n1.C4566a0.ERROR, "Error updating the user record because of th enull user id");
            m16259a(new C4564n1.C4583i0(-1, "Unable to update tags: the current user is not registered with OneSignal"));
            mo29953m();
            return;
        }
        C4731y1.m16453d("players/" + str, jSONObject, new C4681d(jSONObject, jSONObject2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29998a(JSONObject jSONObject, C4564n1.C4593s sVar) {
        if (sVar != null) {
            this.f12715e.add(sVar);
        }
        JSONObject jSONObject2 = mo30006g().f12625c;
        mo29996a(jSONObject2, jSONObject, jSONObject2, (Set<String>) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29997a(C4686w.C4693g gVar) {
        mo30006g().mo29927a(gVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29999a(boolean z) {
        boolean z2 = this.f12712b != z;
        this.f12712b = z;
        if (z2 && z) {
            mo29952k();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16259a(C4564n1.C4583i0 i0Var) {
        while (true) {
            C4564n1.C4593s poll = this.f12715e.poll();
            if (poll != null) {
                poll.mo29883a(i0Var);
            } else {
                return;
            }
        }
    }
}
