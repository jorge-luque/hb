package p118io.branch.referral;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p118io.branch.referral.C3555b;
import p118io.branch.referral.C6036r;

/* renamed from: io.branch.referral.z */
/* compiled from: ServerRequestQueue */
class C6052z {

    /* renamed from: d */
    private static C6052z f15947d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Object f15948e = new Object();

    /* renamed from: a */
    private SharedPreferences f15949a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SharedPreferences.Editor f15950b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final List<C6036r> f15951c;

    /* renamed from: io.branch.referral.z$a */
    /* compiled from: ServerRequestQueue */
    class C6053a implements Runnable {
        C6053a() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:13|23|24|25|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(4:6|(2:10|33)|30|4)|(2:11|12)|20|21) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0074 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0089 */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0074=Splitter:B:20:0x0074, B:25:0x0089=Splitter:B:25:0x0089} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.Object r0 = p118io.branch.referral.C6052z.f15948e
                monitor-enter(r0)
                org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x008a }
                r1.<init>()     // Catch:{ all -> 0x008a }
                io.branch.referral.z r2 = p118io.branch.referral.C6052z.this     // Catch:{ all -> 0x008a }
                java.util.List r2 = r2.f15951c     // Catch:{ all -> 0x008a }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x008a }
            L_0x0014:
                boolean r3 = r2.hasNext()     // Catch:{ all -> 0x008a }
                if (r3 == 0) goto L_0x0030
                java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x008a }
                io.branch.referral.r r3 = (p118io.branch.referral.C6036r) r3     // Catch:{ all -> 0x008a }
                boolean r4 = r3.mo33820l()     // Catch:{ all -> 0x008a }
                if (r4 == 0) goto L_0x0014
                org.json.JSONObject r3 = r3.mo34031t()     // Catch:{ all -> 0x008a }
                if (r3 == 0) goto L_0x0014
                r1.put(r3)     // Catch:{ all -> 0x008a }
                goto L_0x0014
            L_0x0030:
                io.branch.referral.z r2 = p118io.branch.referral.C6052z.this     // Catch:{ Exception -> 0x0046 }
                android.content.SharedPreferences$Editor r2 = r2.f15950b     // Catch:{ Exception -> 0x0046 }
                java.lang.String r3 = "BNCServerRequestQueue"
                java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0046 }
                android.content.SharedPreferences$Editor r2 = r2.putString(r3, r4)     // Catch:{ Exception -> 0x0046 }
                r2.commit()     // Catch:{ Exception -> 0x0046 }
                goto L_0x0074
            L_0x0044:
                r2 = move-exception
                goto L_0x0076
            L_0x0046:
                r2 = move-exception
                java.lang.String r3 = "Persisting Queue: "
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
                r4.<init>()     // Catch:{ all -> 0x0044 }
                java.lang.String r5 = "Failed to persit queue "
                r4.append(r5)     // Catch:{ all -> 0x0044 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0044 }
                r4.append(r2)     // Catch:{ all -> 0x0044 }
                java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0044 }
                p118io.branch.referral.C6035q.m19397b((java.lang.String) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0044 }
                io.branch.referral.z r2 = p118io.branch.referral.C6052z.this     // Catch:{ Exception -> 0x0074 }
                android.content.SharedPreferences$Editor r2 = r2.f15950b     // Catch:{ Exception -> 0x0074 }
                java.lang.String r3 = "BNCServerRequestQueue"
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0074 }
                android.content.SharedPreferences$Editor r1 = r2.putString(r3, r1)     // Catch:{ Exception -> 0x0074 }
                r1.commit()     // Catch:{ Exception -> 0x0074 }
            L_0x0074:
                monitor-exit(r0)     // Catch:{ all -> 0x008a }
                return
            L_0x0076:
                io.branch.referral.z r3 = p118io.branch.referral.C6052z.this     // Catch:{ Exception -> 0x0089 }
                android.content.SharedPreferences$Editor r3 = r3.f15950b     // Catch:{ Exception -> 0x0089 }
                java.lang.String r4 = "BNCServerRequestQueue"
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0089 }
                android.content.SharedPreferences$Editor r1 = r3.putString(r4, r1)     // Catch:{ Exception -> 0x0089 }
                r1.commit()     // Catch:{ Exception -> 0x0089 }
            L_0x0089:
                throw r2     // Catch:{ all -> 0x008a }
            L_0x008a:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x008a }
                goto L_0x008e
            L_0x008d:
                throw r1
            L_0x008e:
                goto L_0x008d
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C6052z.C6053a.run():void");
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private C6052z(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BNC_Server_Request_Queue", 0);
        this.f15949a = sharedPreferences;
        this.f15950b = sharedPreferences.edit();
        this.f15951c = m19584b(context);
    }

    /* renamed from: i */
    private void m19586i() {
        new Thread(new C6053a()).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo34069c() {
        synchronized (f15948e) {
            for (C6036r next : this.f15951c) {
                if (next != null && ((next instanceof C5992c0) || (next instanceof C5994d0))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C6036r mo34070d() {
        C6036r rVar;
        synchronized (f15948e) {
            C6036r rVar2 = null;
            try {
                rVar = this.f15951c.remove(0);
                try {
                    m19586i();
                } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                    rVar2 = rVar;
                }
            } catch (IndexOutOfBoundsException | NoSuchElementException unused2) {
                rVar = rVar2;
                return rVar;
            }
        }
        return rVar;
    }

    /* renamed from: e */
    public int mo34071e() {
        int size;
        synchronized (f15948e) {
            size = this.f15951c.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C6036r mo34072f() {
        C6036r rVar;
        synchronized (f15948e) {
            try {
                rVar = this.f15951c.get(0);
            } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                rVar = null;
            }
        }
        return rVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo34073g() {
        synchronized (f15948e) {
            for (C6036r next : this.f15951c) {
                if (next != null && (next instanceof C6050x)) {
                    next.mo34012a(C6036r.C6038b.STRONG_MATCH_PENDING_WAIT_LOCK);
                }
            }
        }
    }

    /* renamed from: a */
    public static C6052z m19581a(Context context) {
        if (f15947d == null) {
            synchronized (C6052z.class) {
                if (f15947d == null) {
                    f15947d = new C6052z(context);
                }
            }
        }
        return f15947d;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0039 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<p118io.branch.referral.C6036r> m19584b(android.content.Context r7) {
        /*
            r6 = this;
            android.content.SharedPreferences r0 = r6.f15949a
            java.lang.String r1 = "BNCServerRequestQueue"
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            java.util.List r1 = java.util.Collections.synchronizedList(r1)
            java.lang.Object r2 = f15948e
            monitor-enter(r2)
            if (r0 == 0) goto L_0x0039
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0039 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0039 }
            r0 = 0
            int r4 = r3.length()     // Catch:{ JSONException -> 0x0039 }
            r5 = 25
            int r4 = java.lang.Math.min(r4, r5)     // Catch:{ JSONException -> 0x0039 }
        L_0x0027:
            if (r0 >= r4) goto L_0x0039
            org.json.JSONObject r5 = r3.getJSONObject(r0)     // Catch:{ JSONException -> 0x0039 }
            io.branch.referral.r r5 = p118io.branch.referral.C6036r.m19475a((org.json.JSONObject) r5, (android.content.Context) r7)     // Catch:{ JSONException -> 0x0039 }
            if (r5 == 0) goto L_0x0036
            r1.add(r5)     // Catch:{ JSONException -> 0x0039 }
        L_0x0036:
            int r0 = r0 + 1
            goto L_0x0027
        L_0x0039:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return r1
        L_0x003b:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            goto L_0x003f
        L_0x003e:
            throw r7
        L_0x003f:
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C6052z.m19584b(android.content.Context):java.util.List");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo34064a(C6036r rVar) {
        synchronized (f15948e) {
            if (rVar != null) {
                this.f15951c.add(rVar);
                if (mo34071e() >= 25) {
                    this.f15951c.remove(1);
                }
                m19586i();
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0010 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo34068b(p118io.branch.referral.C6036r r4) {
        /*
            r3 = this;
            java.lang.Object r0 = f15948e
            monitor-enter(r0)
            r1 = 0
            java.util.List<io.branch.referral.r> r2 = r3.f15951c     // Catch:{ UnsupportedOperationException -> 0x0010 }
            boolean r1 = r2.remove(r4)     // Catch:{ UnsupportedOperationException -> 0x0010 }
            r3.m19586i()     // Catch:{ UnsupportedOperationException -> 0x0010 }
            goto L_0x0010
        L_0x000e:
            r4 = move-exception
            goto L_0x0012
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return r1
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C6052z.mo34068b(io.branch.referral.r):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C6036r mo34060a(int i) {
        C6036r rVar;
        synchronized (f15948e) {
            try {
                rVar = this.f15951c.get(i);
            } catch (IndexOutOfBoundsException | NoSuchElementException unused) {
                rVar = null;
            }
        }
        return rVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo34067b() {
        synchronized (f15948e) {
            for (C6036r next : this.f15951c) {
                if (next != null && next.mo34022h().equals(C6030n.RegisterClose.mo33924a())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001c */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo34065a(p118io.branch.referral.C6036r r3, int r4) {
        /*
            r2 = this;
            java.lang.Object r0 = f15948e
            monitor-enter(r0)
            java.util.List<io.branch.referral.r> r1 = r2.f15951c     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            int r1 = r1.size()     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            if (r1 >= r4) goto L_0x0011
            java.util.List<io.branch.referral.r> r4 = r2.f15951c     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            int r4 = r4.size()     // Catch:{ IndexOutOfBoundsException -> 0x001c }
        L_0x0011:
            java.util.List<io.branch.referral.r> r1 = r2.f15951c     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            r1.add(r4, r3)     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            r2.m19586i()     // Catch:{ IndexOutOfBoundsException -> 0x001c }
            goto L_0x001c
        L_0x001a:
            r3 = move-exception
            goto L_0x001e
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C6052z.mo34065a(io.branch.referral.r, int):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000e */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo34061a() {
        /*
            r2 = this;
            java.lang.Object r0 = f15948e
            monitor-enter(r0)
            java.util.List<io.branch.referral.r> r1 = r2.f15951c     // Catch:{ UnsupportedOperationException -> 0x000e }
            r1.clear()     // Catch:{ UnsupportedOperationException -> 0x000e }
            r2.m19586i()     // Catch:{ UnsupportedOperationException -> 0x000e }
            goto L_0x000e
        L_0x000c:
            r1 = move-exception
            goto L_0x0010
        L_0x000e:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C6052z.mo34061a():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo34066a(C6036r rVar, int i, C3555b.C3562g gVar) {
        synchronized (f15948e) {
            Iterator<C6036r> it = this.f15951c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C6036r next = it.next();
                if (next == null || (!(next instanceof C5992c0) && !(next instanceof C5994d0))) {
                }
            }
            it.remove();
        }
        mo34065a(rVar, i == 0 ? 0 : 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo34062a(C3555b.C3562g gVar) {
        synchronized (f15948e) {
            for (C6036r next : this.f15951c) {
                if (next != null) {
                    if (next instanceof C5992c0) {
                        ((C5992c0) next).mo33822a(gVar);
                    } else if (next instanceof C5994d0) {
                        ((C5994d0) next).mo33828a(gVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo34063a(C6036r.C6038b bVar) {
        synchronized (f15948e) {
            for (C6036r next : this.f15951c) {
                if (next != null) {
                    next.mo34016b(bVar);
                }
            }
        }
    }
}
