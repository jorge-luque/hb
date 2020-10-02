package com.applovin.impl.sdk.network;

import android.content.SharedPreferences;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1871ad;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.e */
public class C1965e {

    /* renamed from: a */
    private final C1941j f6574a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1977q f6575b;

    /* renamed from: c */
    private final SharedPreferences f6576c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f6577d = new Object();

    /* renamed from: e */
    private final ArrayList<C1968f> f6578e;

    /* renamed from: f */
    private final ArrayList<C1968f> f6579f = new ArrayList<>();

    /* renamed from: g */
    private final Set<C1968f> f6580g = new HashSet();

    public C1965e(C1941j jVar) {
        if (jVar != null) {
            this.f6574a = jVar;
            this.f6575b = jVar.mo8602v();
            this.f6576c = jVar.mo8527E().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
            this.f6578e = m7642b();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r0 = ((java.lang.Integer) r4.f6574a.mo8549a(com.applovin.impl.sdk.p050b.C1841c.f5998do)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        if (r5.mo8692i() <= r0) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        r6 = r4.f6575b;
        r6.mo8745d("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + r0 + ". Dequeuing postback: " + r5);
        m7650d(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0092, code lost:
        r1 = r4.f6577d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0094, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.f6580g.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009a, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009f, code lost:
        if (r5.mo8688f() == null) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a1, code lost:
        r0 = new org.json.JSONObject(r5.mo8688f());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ab, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ac, code lost:
        r4.f6574a.mo8539R().dispatchPostbackRequest(com.applovin.impl.sdk.network.C1971g.m7686b(r4.f6574a).mo8714d(r5.mo8683b()).mo8717e(r5.mo8684c()).mo8711c(r5.mo8685d()).mo8719f(r5.mo8682a()).mo8715d(r5.mo8686e()).mo8709b(r0).mo8712c(r5.mo8689g()).mo8720g(r5.mo8690h()).mo8710b(), new com.applovin.impl.sdk.network.C1965e.C19672(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7640a(final com.applovin.impl.sdk.network.C1968f r5, final com.applovin.sdk.AppLovinPostbackListener r6) {
        /*
            r4 = this;
            com.applovin.impl.sdk.q r0 = r4.f6575b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Preparing to submit postback..."
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "PersistentPostbackManager"
            r0.mo8742b(r2, r1)
            com.applovin.impl.sdk.j r0 = r4.f6574a
            boolean r0 = r0.mo8582c()
            if (r0 == 0) goto L_0x002a
            com.applovin.impl.sdk.q r5 = r4.f6575b
            java.lang.String r6 = "PersistentPostbackManager"
            java.lang.String r0 = "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards"
            r5.mo8742b(r6, r0)
            return
        L_0x002a:
            java.lang.Object r0 = r4.f6577d
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.network.f> r1 = r4.f6580g     // Catch:{ all -> 0x0104 }
            boolean r1 = r1.contains(r5)     // Catch:{ all -> 0x0104 }
            if (r1 == 0) goto L_0x0053
            com.applovin.impl.sdk.q r6 = r4.f6575b     // Catch:{ all -> 0x0104 }
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            r2.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.String r3 = "Skip pending postback: "
            r2.append(r3)     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = r5.mo8683b()     // Catch:{ all -> 0x0104 }
            r2.append(r5)     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0104 }
            r6.mo8742b(r1, r5)     // Catch:{ all -> 0x0104 }
            monitor-exit(r0)     // Catch:{ all -> 0x0104 }
            return
        L_0x0053:
            r5.mo8693j()     // Catch:{ all -> 0x0104 }
            r4.m7645c()     // Catch:{ all -> 0x0104 }
            monitor-exit(r0)     // Catch:{ all -> 0x0104 }
            com.applovin.impl.sdk.j r0 = r4.f6574a
            com.applovin.impl.sdk.b.c<java.lang.Integer> r1 = com.applovin.impl.sdk.p050b.C1841c.f5998do
            java.lang.Object r0 = r0.mo8549a(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r1 = r5.mo8692i()
            if (r1 <= r0) goto L_0x0092
            com.applovin.impl.sdk.q r6 = r4.f6575b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Exceeded maximum persisted attempt count of "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = ". Dequeuing postback: "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "PersistentPostbackManager"
            r6.mo8745d(r1, r0)
            r4.m7650d(r5)
            goto L_0x0100
        L_0x0092:
            java.lang.Object r1 = r4.f6577d
            monitor-enter(r1)
            java.util.Set<com.applovin.impl.sdk.network.f> r0 = r4.f6580g     // Catch:{ all -> 0x0101 }
            r0.add(r5)     // Catch:{ all -> 0x0101 }
            monitor-exit(r1)     // Catch:{ all -> 0x0101 }
            java.util.Map r0 = r5.mo8688f()
            if (r0 == 0) goto L_0x00ab
            org.json.JSONObject r0 = new org.json.JSONObject
            java.util.Map r1 = r5.mo8688f()
            r0.<init>(r1)
            goto L_0x00ac
        L_0x00ab:
            r0 = 0
        L_0x00ac:
            com.applovin.impl.sdk.j r1 = r4.f6574a
            com.applovin.impl.sdk.network.g$a r1 = com.applovin.impl.sdk.network.C1971g.m7686b(r1)
            java.lang.String r2 = r5.mo8683b()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo8663a((java.lang.String) r2)
            java.lang.String r2 = r5.mo8684c()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo8673c((java.lang.String) r2)
            java.util.Map r2 = r5.mo8685d()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo8664a((java.util.Map<java.lang.String, java.lang.String>) r2)
            java.lang.String r2 = r5.mo8682a()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo8669b((java.lang.String) r2)
            java.util.Map r2 = r5.mo8686e()
            com.applovin.impl.sdk.network.g$a r1 = r1.mo8670b((java.util.Map<java.lang.String, java.lang.String>) r2)
            com.applovin.impl.sdk.network.g$a r0 = r1.mo8665a((org.json.JSONObject) r0)
            boolean r1 = r5.mo8689g()
            com.applovin.impl.sdk.network.g$a r0 = r0.mo8666a((boolean) r1)
            java.lang.String r1 = r5.mo8690h()
            com.applovin.impl.sdk.network.g$a r0 = r0.mo8720g(r1)
            com.applovin.impl.sdk.network.g r0 = r0.mo8667a()
            com.applovin.impl.sdk.j r1 = r4.f6574a
            com.applovin.impl.sdk.network.PostbackServiceImpl r1 = r1.mo8539R()
            com.applovin.impl.sdk.network.e$2 r2 = new com.applovin.impl.sdk.network.e$2
            r2.<init>(r5, r6)
            r1.dispatchPostbackRequest(r0, r2)
        L_0x0100:
            return
        L_0x0101:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0101 }
            throw r5
        L_0x0104:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0104 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1965e.m7640a(com.applovin.impl.sdk.network.f, com.applovin.sdk.AppLovinPostbackListener):void");
    }

    /* renamed from: b */
    private ArrayList<C1968f> m7642b() {
        Set<String> set = (Set) this.f6574a.mo8575b(C1843e.f6099m, new LinkedHashSet(0), this.f6576c);
        ArrayList<C1968f> arrayList = new ArrayList<>(Math.max(1, set.size()));
        int intValue = ((Integer) this.f6574a.mo8549a(C1841c.f5998do)).intValue();
        C1977q qVar = this.f6575b;
        qVar.mo8742b("PersistentPostbackManager", "Deserializing " + set.size() + " postback(s).");
        for (String str : set) {
            try {
                C1968f fVar = new C1968f(new JSONObject(str), this.f6574a);
                if (fVar.mo8692i() < intValue) {
                    arrayList.add(fVar);
                } else {
                    C1977q qVar2 = this.f6575b;
                    qVar2.mo8742b("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + fVar);
                }
            } catch (Throwable th) {
                C1977q qVar3 = this.f6575b;
                qVar3.mo8743b("PersistentPostbackManager", "Unable to deserialize postback request from json: " + str, th);
            }
        }
        C1977q qVar4 = this.f6575b;
        qVar4.mo8742b("PersistentPostbackManager", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7644b(C1968f fVar) {
        synchronized (this.f6577d) {
            this.f6578e.add(fVar);
            m7645c();
            C1977q qVar = this.f6575b;
            qVar.mo8742b("PersistentPostbackManager", "Enqueued postback: " + fVar);
        }
    }

    /* renamed from: c */
    private void m7645c() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f6578e.size());
        Iterator<C1968f> it = this.f6578e.iterator();
        while (it.hasNext()) {
            try {
                linkedHashSet.add(it.next().mo8695l().toString());
            } catch (Throwable th) {
                this.f6575b.mo8743b("PersistentPostbackManager", "Unable to serialize postback request to JSON.", th);
            }
        }
        this.f6574a.mo8557a(C1843e.f6099m, linkedHashSet, this.f6576c);
        this.f6575b.mo8742b("PersistentPostbackManager", "Wrote updated postback queue to disk.");
    }

    /* renamed from: c */
    private void m7648c(C1968f fVar) {
        m7640a(fVar, (AppLovinPostbackListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7649d() {
        synchronized (this.f6577d) {
            Iterator<C1968f> it = this.f6579f.iterator();
            while (it.hasNext()) {
                m7648c(it.next());
            }
            this.f6579f.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7650d(C1968f fVar) {
        synchronized (this.f6577d) {
            this.f6580g.remove(fVar);
            this.f6578e.remove(fVar);
            m7645c();
        }
        C1977q qVar = this.f6575b;
        qVar.mo8742b("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + fVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7651e(C1968f fVar) {
        synchronized (this.f6577d) {
            this.f6580g.remove(fVar);
            this.f6579f.add(fVar);
        }
    }

    /* renamed from: a */
    public void mo8677a() {
        synchronized (this.f6577d) {
            if (this.f6578e != null) {
                for (C1968f c : new ArrayList(this.f6578e)) {
                    m7648c(c);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo8678a(C1968f fVar) {
        mo8679a(fVar, true);
    }

    /* renamed from: a */
    public void mo8679a(C1968f fVar, boolean z) {
        mo8680a(fVar, z, (AppLovinPostbackListener) null);
    }

    /* renamed from: a */
    public void mo8680a(final C1968f fVar, boolean z, final AppLovinPostbackListener appLovinPostbackListener) {
        if (C2025o.m7963b(fVar.mo8683b())) {
            if (z) {
                fVar.mo8694k();
            }
            C19661 r3 = new Runnable() {
                public void run() {
                    synchronized (C1965e.this.f6577d) {
                        C1965e.this.m7644b(fVar);
                        C1965e.this.m7640a(fVar, appLovinPostbackListener);
                    }
                }
            };
            if (C2029r.m8028b()) {
                this.f6574a.mo8533L().mo8475a((C1864a) new C1871ad(this.f6574a, r3), C1907s.C1909a.POSTBACKS);
                return;
            }
            r3.run();
        }
    }
}
