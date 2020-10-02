package com.criteo.publisher.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.criteo.publisher.p054a0.C2339n;
import com.criteo.publisher.p054a0.C2340o;

/* renamed from: com.criteo.publisher.model.p */
public class C2455p {

    /* renamed from: d */
    private static final String f7909d = "p";

    /* renamed from: a */
    private volatile C2464v f7910a;

    /* renamed from: b */
    private final Context f7911b;

    /* renamed from: c */
    private final C2339n f7912c;

    public C2455p() {
        this.f7911b = null;
        this.f7912c = null;
        this.f7910a = C2464v.m9309g();
    }

    /* renamed from: a */
    private C2464v m9277a(C2464v vVar, C2464v vVar2) {
        return C2464v.m9307a((Boolean) C2340o.m8995b(vVar2.mo10340f(), vVar.mo10340f()), (String) C2340o.m8995b(vVar2.mo10337d(), vVar.mo10337d()), (String) C2340o.m8995b(vVar2.mo10336c(), vVar.mo10336c()), (String) C2340o.m8995b(vVar2.mo10334a(), vVar.mo10334a()), (String) C2340o.m8995b(vVar2.mo10335b(), vVar.mo10335b()), (Boolean) C2340o.m8995b(vVar2.mo10338e(), vVar.mo10338e()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003e */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9278b(com.criteo.publisher.model.C2464v r4) {
        /*
            r3 = this;
            android.content.Context r0 = r3.f7911b
            if (r0 == 0) goto L_0x003f
            com.criteo.publisher.a0.n r0 = r3.f7912c
            if (r0 != 0) goto L_0x0009
            goto L_0x003f
        L_0x0009:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x003f }
            r0.<init>()     // Catch:{ Exception -> 0x003f }
            com.criteo.publisher.a0.n r1 = r3.f7912c     // Catch:{ all -> 0x0038 }
            r1.mo10163a((java.lang.Object) r4, (java.io.OutputStream) r0)     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0038 }
            byte[] r1 = r0.toByteArray()     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)     // Catch:{ all -> 0x0038 }
            r4.<init>(r1, r2)     // Catch:{ all -> 0x0038 }
            r0.close()     // Catch:{ Exception -> 0x003f }
            android.content.Context r0 = r3.f7911b
            android.content.SharedPreferences r0 = m9276a((android.content.Context) r0)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = "CriteoCachedConfig"
            r0.putString(r1, r4)
            r0.apply()
            return
        L_0x0038:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003a }
        L_0x003a:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x003e }
        L_0x003e:
            throw r4     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.model.C2455p.m9278b(com.criteo.publisher.model.v):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005a */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.criteo.publisher.model.C2464v m9279g() {
        /*
            r4 = this;
            com.criteo.publisher.model.v r0 = com.criteo.publisher.model.C2464v.m9309g()
            android.content.Context r1 = r4.f7911b
            if (r1 == 0) goto L_0x005b
            com.criteo.publisher.a0.n r2 = r4.f7912c
            if (r2 != 0) goto L_0x000d
            goto L_0x005b
        L_0x000d:
            android.content.SharedPreferences r1 = m9276a((android.content.Context) r1)
            com.criteo.publisher.a0.r r2 = new com.criteo.publisher.a0.r
            r2.<init>(r1)
            java.lang.String r3 = "CriteoCachedKillSwitch"
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto L_0x002b
            r1 = 0
            boolean r1 = r2.mo10166a((java.lang.String) r3, (boolean) r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            com.criteo.publisher.model.v r0 = r0.mo10400a((java.lang.Boolean) r1)
        L_0x002b:
            java.lang.String r1 = "CriteoCachedConfig"
            java.lang.String r3 = "{}"
            java.lang.String r1 = r2.mo10165a((java.lang.String) r1, (java.lang.String) r3)
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)
            byte[] r1 = r1.getBytes(r2)
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x005b }
            r2.<init>(r1)     // Catch:{ IOException -> 0x005b }
            com.criteo.publisher.a0.n r1 = r4.f7912c     // Catch:{ all -> 0x0054 }
            java.lang.Class<com.criteo.publisher.model.v> r3 = com.criteo.publisher.model.C2464v.class
            java.lang.Object r1 = r1.mo10162a(r3, (java.io.InputStream) r2)     // Catch:{ all -> 0x0054 }
            com.criteo.publisher.model.v r1 = (com.criteo.publisher.model.C2464v) r1     // Catch:{ all -> 0x0054 }
            r2.close()     // Catch:{ IOException -> 0x005b }
            com.criteo.publisher.model.v r0 = r4.m9277a(r0, r1)
            return r0
        L_0x0054:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r1 = move-exception
            r2.close()     // Catch:{ all -> 0x005a }
        L_0x005a:
            throw r1     // Catch:{ IOException -> 0x005b }
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.model.C2455p.m9279g():com.criteo.publisher.model.v");
    }

    /* renamed from: c */
    public String mo10384c() {
        return (String) C2340o.m8995b(this.f7910a.mo10336c(), "<html><body style='text-align:center; margin:0px; padding:0px; horizontal-align:center;'><script src=\"%%displayUrl%%\"></script></body></html>");
    }

    /* renamed from: d */
    public String mo10385d() {
        return (String) C2340o.m8995b(this.f7910a.mo10337d(), "%%displayUrl%%");
    }

    /* renamed from: e */
    public boolean mo10386e() {
        return ((Boolean) C2340o.m8995b(this.f7910a.mo10338e(), true)).booleanValue();
    }

    /* renamed from: f */
    public boolean mo10387f() {
        return ((Boolean) C2340o.m8995b(this.f7910a.mo10340f(), false)).booleanValue();
    }

    public C2455p(Context context, C2339n nVar) {
        this.f7911b = context;
        this.f7912c = nVar;
        this.f7910a = m9279g();
    }

    /* renamed from: b */
    public String mo10383b() {
        return (String) C2340o.m8995b(this.f7910a.mo10335b(), "<html><body style='text-align:center; margin:0px; padding:0px; horizontal-align:center;'><script>%%adTagData%%</script></body></html>");
    }

    /* renamed from: a */
    public void mo10382a(C2464v vVar) {
        this.f7910a = m9277a(this.f7910a, vVar);
        m9278b(this.f7910a);
    }

    /* renamed from: a */
    private static SharedPreferences m9276a(Context context) {
        return context.getSharedPreferences("com.criteo.publisher.sdkSharedPreferences", 0);
    }

    /* renamed from: a */
    public String mo10381a() {
        return (String) C2340o.m8995b(this.f7910a.mo10334a(), "%%adTagData%%");
    }
}
