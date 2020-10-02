package p093e.p094a.p095a;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: e.a.a.y0 */
/* compiled from: SharedPreferencesManager */
public class C3365y0 {

    /* renamed from: a */
    private final SharedPreferences f9428a;

    public C3365y0(Context context) {
        this.f9428a = context.getSharedPreferences("adjust_preferences", 0);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int m11215e(java.lang.String r8, long r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            org.json.JSONArray r0 = r7.mo19124f()     // Catch:{ JSONException -> 0x0033, all -> 0x0030 }
            r1 = 0
            r2 = 0
        L_0x0007:
            int r3 = r0.length()     // Catch:{ JSONException -> 0x0033, all -> 0x0030 }
            if (r2 >= r3) goto L_0x0033
            org.json.JSONArray r3 = r0.getJSONArray(r2)     // Catch:{ JSONException -> 0x0033, all -> 0x0030 }
            r4 = 0
            java.lang.String r4 = r3.optString(r1, r4)     // Catch:{ JSONException -> 0x0033, all -> 0x0030 }
            if (r4 == 0) goto L_0x002d
            boolean r4 = r4.equals(r8)     // Catch:{ JSONException -> 0x0033, all -> 0x0030 }
            if (r4 != 0) goto L_0x001f
            goto L_0x002d
        L_0x001f:
            r4 = -1
            r6 = 1
            long r3 = r3.optLong(r6, r4)     // Catch:{ JSONException -> 0x0033, all -> 0x0030 }
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            monitor-exit(r7)
            return r2
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x0007
        L_0x0030:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x0033:
            r8 = -1
            monitor-exit(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3365y0.m11215e(java.lang.String, long):int");
    }

    /* renamed from: a */
    public synchronized void mo19117a(JSONArray jSONArray) {
        try {
            m11209a("raw_referrers", jSONArray.toString());
        } catch (Throwable unused) {
            m11213c("raw_referrers");
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003e, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo19119b(java.lang.String r3, long r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x003d
            int r0 = r3.length()     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x000a
            goto L_0x003d
        L_0x000a:
            int r3 = r2.m11215e(r3, r4)     // Catch:{ all -> 0x003a }
            if (r3 >= 0) goto L_0x0012
            monitor-exit(r2)
            return
        L_0x0012:
            org.json.JSONArray r4 = r2.mo19124f()     // Catch:{ all -> 0x003a }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ all -> 0x003a }
            r5.<init>()     // Catch:{ all -> 0x003a }
            r0 = 0
        L_0x001c:
            int r1 = r4.length()     // Catch:{ all -> 0x003a }
            if (r0 >= r1) goto L_0x002f
            if (r0 != r3) goto L_0x0025
            goto L_0x002c
        L_0x0025:
            org.json.JSONArray r1 = r4.getJSONArray(r0)     // Catch:{ JSONException -> 0x002c }
            r5.put(r1)     // Catch:{ JSONException -> 0x002c }
        L_0x002c:
            int r0 = r0 + 1
            goto L_0x001c
        L_0x002f:
            java.lang.String r3 = "raw_referrers"
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x003a }
            r2.m11209a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x003d:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3365y0.mo19119b(java.lang.String, long):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo19120c(java.lang.String r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            org.json.JSONArray r0 = r3.mo19115a((java.lang.String) r4, (long) r5)     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            org.json.JSONArray r0 = r3.mo19124f()     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            int r1 = r0.length()     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            r2 = 10
            if (r1 != r2) goto L_0x0017
            monitor-exit(r3)
            return
        L_0x0017:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            r1.<init>()     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            r2 = 0
            r1.put(r2, r4)     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            r4 = 1
            r1.put(r4, r5)     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            r4 = 2
            r1.put(r4, r2)     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            r0.put(r1)     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            r3.mo19117a((org.json.JSONArray) r0)     // Catch:{ JSONException -> 0x0032, all -> 0x002f }
            goto L_0x0032
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0032:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3365y0.mo19120c(java.lang.String, long):void");
    }

    /* renamed from: d */
    public synchronized boolean mo19122d() {
        return m11210a("install_tracked", false);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|3|(3:5|6|(6:8|(1:10)|25|11|12|13)(4:14|15|16|17))|18|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0034 */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.json.JSONArray mo19124f() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "raw_referrers"
            java.lang.String r0 = r5.m11211b(r0)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0034
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0034 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0034 }
            int r2 = r1.length()     // Catch:{ JSONException -> 0x0034 }
            r3 = 10
            if (r2 <= r3) goto L_0x002d
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0034 }
            r0.<init>()     // Catch:{ JSONException -> 0x0034 }
            r2 = 0
        L_0x001c:
            if (r2 >= r3) goto L_0x0028
            java.lang.Object r4 = r1.get(r2)     // Catch:{ JSONException -> 0x0034 }
            r0.put(r4)     // Catch:{ JSONException -> 0x0034 }
            int r2 = r2 + 1
            goto L_0x001c
        L_0x0028:
            r5.mo19117a((org.json.JSONArray) r0)     // Catch:{ JSONException -> 0x0034 }
            monitor-exit(r5)
            return r0
        L_0x002d:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0034 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0034 }
            monitor-exit(r5)
            return r1
        L_0x0034:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x003b }
            r0.<init>()     // Catch:{ all -> 0x003b }
            monitor-exit(r5)
            return r0
        L_0x003b:
            r0 = move-exception
            monitor-exit(r5)
            goto L_0x003f
        L_0x003e:
            throw r0
        L_0x003f:
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3365y0.mo19124f():org.json.JSONArray");
    }

    /* renamed from: g */
    public synchronized void mo19125g() {
        m11213c("deeplink_url");
        m11213c("deeplink_click_time");
    }

    /* renamed from: h */
    public synchronized void mo19126h() {
        m11213c("gdpr_forget_me");
    }

    /* renamed from: i */
    public synchronized void mo19127i() {
        m11213c("push_token");
    }

    /* renamed from: j */
    public synchronized void mo19128j() {
        m11212b("install_tracked", true);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo19129k() {
        /*
            r8 = this;
            monitor-enter(r8)
            org.json.JSONArray r0 = r8.mo19124f()     // Catch:{ JSONException -> 0x002b, all -> 0x0028 }
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0008:
            int r4 = r0.length()     // Catch:{ JSONException -> 0x002b, all -> 0x0028 }
            if (r2 >= r4) goto L_0x0022
            org.json.JSONArray r4 = r0.getJSONArray(r2)     // Catch:{ JSONException -> 0x002b, all -> 0x0028 }
            r5 = -1
            r6 = 2
            int r5 = r4.optInt(r6, r5)     // Catch:{ JSONException -> 0x002b, all -> 0x0028 }
            r7 = 1
            if (r5 != r7) goto L_0x001f
            r4.put(r6, r1)     // Catch:{ JSONException -> 0x002b, all -> 0x0028 }
            r3 = 1
        L_0x001f:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0022:
            if (r3 == 0) goto L_0x002b
            r8.mo19117a((org.json.JSONArray) r0)     // Catch:{ JSONException -> 0x002b, all -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x002b:
            monitor-exit(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3365y0.mo19129k():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000d, code lost:
        return r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long m11214d(java.lang.String r2, long r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.SharedPreferences r0 = r1.f9428a     // Catch:{ ClassCastException -> 0x000c, all -> 0x0009 }
            long r2 = r0.getLong(r2, r3)     // Catch:{ ClassCastException -> 0x000c, all -> 0x0009 }
            monitor-exit(r1)
            return r2
        L_0x0009:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x000c:
            monitor-exit(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3365y0.m11214d(java.lang.String, long):long");
    }

    /* renamed from: a */
    public synchronized JSONArray mo19115a(String str, long j) {
        int e = m11215e(str, j);
        if (e >= 0) {
            try {
                return mo19124f().getJSONArray(e);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized void mo19116a(String str) {
        m11209a("push_token", str);
    }

    /* renamed from: a */
    public synchronized long mo19114a() {
        return m11214d("deeplink_click_time", -1);
    }

    /* renamed from: e */
    public synchronized String mo19123e() {
        return m11211b("push_token");
    }

    /* renamed from: a */
    private synchronized void m11209a(String str, String str2) {
        this.f9428a.edit().putString(str, str2).apply();
    }

    /* renamed from: b */
    public synchronized String mo19118b() {
        return m11211b("deeplink_url");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000d, code lost:
        return r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m11210a(java.lang.String r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.SharedPreferences r0 = r1.f9428a     // Catch:{ ClassCastException -> 0x000c, all -> 0x0009 }
            boolean r2 = r0.getBoolean(r2, r3)     // Catch:{ ClassCastException -> 0x000c, all -> 0x0009 }
            monitor-exit(r1)
            return r2
        L_0x0009:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x000c:
            monitor-exit(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3365y0.m11210a(java.lang.String, boolean):boolean");
    }

    /* renamed from: b */
    private synchronized void m11212b(String str, boolean z) {
        this.f9428a.edit().putBoolean(str, z).apply();
    }

    /* renamed from: c */
    public synchronized boolean mo19121c() {
        return m11210a("gdpr_forget_me", false);
    }

    /* renamed from: b */
    private synchronized String m11211b(String str) {
        try {
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable unused2) {
            if (str.equals("raw_referrers")) {
                m11213c("raw_referrers");
            }
            return null;
        }
        return this.f9428a.getString(str, (String) null);
    }

    /* renamed from: c */
    private synchronized void m11213c(String str) {
        this.f9428a.edit().remove(str).apply();
    }
}
