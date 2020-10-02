package com.applovin.impl.sdk.p050b;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.b.d */
public class C1842d {

    /* renamed from: a */
    protected final C1941j f6078a;

    /* renamed from: b */
    protected final C1977q f6079b;

    /* renamed from: c */
    protected final Context f6080c;

    /* renamed from: d */
    protected final SharedPreferences f6081d;

    /* renamed from: e */
    private final Map<String, Object> f6082e = new HashMap();

    /* renamed from: f */
    private final Object f6083f = new Object();

    /* renamed from: g */
    private Map<String, Object> f6084g;

    /* renamed from: h */
    private final C1839a f6085h;

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|7) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1842d(com.applovin.impl.sdk.C1941j r4) {
        /*
            r3 = this;
            r3.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r3.f6082e = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.f6083f = r0
            r3.f6078a = r4
            com.applovin.impl.sdk.q r0 = r4.mo8602v()
            r3.f6079b = r0
            android.content.Context r0 = r4.mo8527E()
            r3.f6080c = r0
            java.lang.String r1 = "com.applovin.sdk.1"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            r3.f6081d = r0
            java.lang.Class<com.applovin.impl.sdk.b.c> r0 = com.applovin.impl.sdk.p050b.C1841c.class
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x003a }
            java.lang.Class.forName(r0)     // Catch:{ all -> 0x003a }
            java.lang.Class<com.applovin.impl.sdk.b.b> r0 = com.applovin.impl.sdk.p050b.C1840b.class
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x003a }
            java.lang.Class.forName(r0)     // Catch:{ all -> 0x003a }
        L_0x003a:
            com.applovin.sdk.AppLovinSdkSettings r0 = r4.mo8591l()     // Catch:{ all -> 0x0058 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = "localSettings"
            java.lang.reflect.Field r0 = com.applovin.impl.sdk.utils.C2029r.m8000a((java.lang.Class) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0058 }
            r1 = 1
            r0.setAccessible(r1)     // Catch:{ all -> 0x0058 }
            com.applovin.sdk.AppLovinSdkSettings r1 = r4.mo8591l()     // Catch:{ all -> 0x0058 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0058 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ all -> 0x0058 }
            r3.f6084g = r0     // Catch:{ all -> 0x0058 }
        L_0x0058:
            com.applovin.impl.sdk.b.a r0 = new com.applovin.impl.sdk.b.a
            r0.<init>(r3, r4)
            r3.f6085h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p050b.C1842d.<init>(com.applovin.impl.sdk.j):void");
    }

    /* renamed from: a */
    private static Object m7040a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    /* renamed from: f */
    private String m7041f() {
        return "com.applovin.sdk." + C2029r.m7997a(this.f6078a.mo8599t()) + ".";
    }

    /* renamed from: a */
    public <T> C1841c<T> mo8301a(String str, C1841c<T> cVar) {
        synchronized (this.f6083f) {
            for (C1841c<T> next : C1841c.m7036c()) {
                if (next.mo8298a().equals(str)) {
                    return next;
                }
            }
            return cVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        return r4;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T mo8302a(com.applovin.impl.sdk.p050b.C1841c<T> r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x002d
            java.lang.Object r0 = r3.f6083f
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Object> r1 = r3.f6082e     // Catch:{ all -> 0x002a }
            java.lang.String r2 = r4.mo8298a()     // Catch:{ all -> 0x002a }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0024
            com.applovin.impl.sdk.b.a r1 = r3.f6085h     // Catch:{ all -> 0x002a }
            java.lang.Object r1 = r1.mo8295a(r4)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x001e
            java.lang.Object r4 = r4.mo8297a(r1)     // Catch:{ all -> 0x002a }
            goto L_0x0022
        L_0x001e:
            java.lang.Object r4 = r4.mo8299b()     // Catch:{ all -> 0x002a }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return r4
        L_0x0024:
            java.lang.Object r4 = r4.mo8297a(r1)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return r4
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        L_0x002d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "No setting type specified"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p050b.C1842d.mo8302a(com.applovin.impl.sdk.b.c):java.lang.Object");
    }

    /* renamed from: a */
    public void mo8303a() {
        this.f6085h.mo8296a();
    }

    /* renamed from: a */
    public <T> void mo8304a(C1841c<?> cVar, Object obj) {
        if (cVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj != null) {
            synchronized (this.f6083f) {
                this.f6082e.put(cVar.mo8298a(), obj);
            }
        } else {
            throw new IllegalArgumentException("No new value specified");
        }
    }

    /* renamed from: a */
    public void mo8305a(JSONObject jSONObject) {
        C1977q qVar;
        String str;
        String str2;
        synchronized (this.f6083f) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && next.length() > 0) {
                    try {
                        C1841c<Long> a = mo8301a(next, (C1841c) null);
                        if (a != null) {
                            this.f6082e.put(a.mo8298a(), m7040a(next, jSONObject, a.mo8299b()));
                            if (a == C1841c.f6022eM) {
                                this.f6082e.put(C1841c.f6023eN.mo8298a(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                    } catch (JSONException e) {
                        th = e;
                        qVar = this.f6079b;
                        str = "SettingsManager";
                        str2 = "Unable to parse JSON settingsValues array";
                        qVar.mo8743b(str, str2, th);
                    } catch (Throwable th) {
                        th = th;
                        qVar = this.f6079b;
                        str = "SettingsManager";
                        str2 = "Unable to convert setting object ";
                        qVar.mo8743b(str, str2, th);
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.applovin.impl.sdk.b.c<java.lang.String>, com.applovin.impl.sdk.b.c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo8306b(com.applovin.impl.sdk.p050b.C1841c<java.lang.String> r1) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.mo8302a(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r1 = com.applovin.impl.sdk.utils.C1989e.m7831a((java.lang.String) r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p050b.C1842d.mo8306b(com.applovin.impl.sdk.b.c):java.util.List");
    }

    /* renamed from: b */
    public void mo8307b() {
        if (this.f6080c != null) {
            String f = m7041f();
            synchronized (this.f6083f) {
                SharedPreferences.Editor edit = this.f6081d.edit();
                for (C1841c next : C1841c.m7036c()) {
                    Object obj = this.f6082e.get(next.mo8298a());
                    if (obj != null) {
                        this.f6078a.mo8562a(f + next.mo8298a(), obj, edit);
                    }
                }
                edit.apply();
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* renamed from: c */
    public List<MaxAdFormat> mo8308c(C1841c<String> cVar) {
        ArrayList arrayList = new ArrayList(6);
        for (String c : mo8306b(cVar)) {
            arrayList.add(C2029r.m8031c(c));
        }
        return arrayList;
    }

    /* renamed from: c */
    public void mo8309c() {
        if (this.f6080c != null) {
            String f = m7041f();
            synchronized (this.f6083f) {
                for (C1841c next : C1841c.m7036c()) {
                    try {
                        Object a = this.f6078a.mo8551a(f + next.mo8298a(), null, next.mo8299b().getClass(), this.f6081d);
                        if (a != null) {
                            this.f6082e.put(next.mo8298a(), a);
                        }
                    } catch (Exception e) {
                        C1977q qVar = this.f6079b;
                        qVar.mo8743b("SettingsManager", "Unable to load \"" + next.mo8298a() + "\"", e);
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* renamed from: d */
    public void mo8310d() {
        synchronized (this.f6083f) {
            this.f6082e.clear();
        }
        this.f6078a.mo8554a(this.f6081d);
    }

    /* renamed from: e */
    public boolean mo8311e() {
        return this.f6078a.mo8591l().isVerboseLoggingEnabled() || ((Boolean) mo8302a(C1841c.f5795V)).booleanValue();
    }
}
