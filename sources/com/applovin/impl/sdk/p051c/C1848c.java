package com.applovin.impl.sdk.p051c;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.p052d.C1921y;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.c */
public class C1848c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f6153a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1977q f6154b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f6155c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1853c f6156d = new C1853c();

    /* renamed from: com.applovin.impl.sdk.c.c$a */
    private static class C1851a {

        /* renamed from: a */
        private final C1941j f6159a;

        /* renamed from: b */
        private final JSONObject f6160b;

        private C1851a(String str, String str2, String str3, C1941j jVar) {
            JSONObject jSONObject = new JSONObject();
            this.f6160b = jSONObject;
            this.f6159a = jVar;
            C1993i.m7886a(jSONObject, "pk", str, jVar);
            C1993i.m7902b(this.f6160b, "ts", System.currentTimeMillis(), jVar);
            if (C2025o.m7963b(str2)) {
                C1993i.m7886a(this.f6160b, "sk1", str2, jVar);
            }
            if (C2025o.m7963b(str3)) {
                C1993i.m7886a(this.f6160b, "sk2", str3, jVar);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m7113a() throws OutOfMemoryError {
            return this.f6160b.toString();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8350a(String str, long j) {
            mo8352b(str, C1993i.m7869a(this.f6160b, str, 0, this.f6159a) + j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8351a(String str, String str2) {
            JSONArray b = C1993i.m7900b(this.f6160b, str, new JSONArray(), this.f6159a);
            b.put(str2);
            C1993i.m7887a(this.f6160b, str, b, this.f6159a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo8352b(String str, long j) {
            C1993i.m7902b(this.f6160b, str, j, this.f6159a);
        }

        public String toString() {
            return "AdEventStats{stats='" + this.f6160b + '\'' + '}';
        }
    }

    /* renamed from: com.applovin.impl.sdk.c.c$b */
    public class C1852b {

        /* renamed from: b */
        private final AppLovinAdBase f6162b;

        /* renamed from: c */
        private final C1848c f6163c;

        public C1852b(AppLovinAdBase appLovinAdBase, C1848c cVar) {
            this.f6162b = appLovinAdBase;
            this.f6163c = cVar;
        }

        /* renamed from: a */
        public C1852b mo8354a(C1847b bVar) {
            this.f6163c.m7093a(bVar, 1, this.f6162b);
            return this;
        }

        /* renamed from: a */
        public C1852b mo8355a(C1847b bVar, long j) {
            this.f6163c.m7100b(bVar, j, this.f6162b);
            return this;
        }

        /* renamed from: a */
        public C1852b mo8356a(C1847b bVar, String str) {
            this.f6163c.m7094a(bVar, str, this.f6162b);
            return this;
        }

        /* renamed from: a */
        public void mo8357a() {
            this.f6163c.m7106e();
        }
    }

    /* renamed from: com.applovin.impl.sdk.c.c$c */
    private class C1853c extends LinkedHashMap<String, C1851a> {
        private C1853c() {
        }

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<String, C1851a> entry) {
            return size() > ((Integer) C1848c.this.f6153a.mo8549a(C1841c.f6057ev)).intValue();
        }
    }

    public C1848c(C1941j jVar) {
        if (jVar != null) {
            this.f6153a = jVar;
            this.f6154b = jVar.mo8602v();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7093a(C1847b bVar, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (bVar == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (((Boolean) this.f6153a.mo8549a(C1841c.f6054es)).booleanValue()) {
            synchronized (this.f6155c) {
                m7098b(appLovinAdBase).mo8350a(((Boolean) this.f6153a.mo8549a(C1841c.f6058ew)).booleanValue() ? bVar.mo8345b() : bVar.mo8344a(), j);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7094a(C1847b bVar, String str, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (bVar == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (((Boolean) this.f6153a.mo8549a(C1841c.f6054es)).booleanValue()) {
            synchronized (this.f6156d) {
                m7098b(appLovinAdBase).mo8351a(((Boolean) this.f6153a.mo8549a(C1841c.f6058ew)).booleanValue() ? bVar.mo8345b() : bVar.mo8344a(), str);
            }
        }
    }

    /* renamed from: a */
    private void m7097a(JSONObject jSONObject) {
        C18491 r0 = new C1921y<Object>(C1960b.m7596a(this.f6153a).mo8663a(m7103c()).mo8673c(m7105d()).mo8664a(C1992h.m7859e(this.f6153a)).mo8669b("POST").mo8665a(jSONObject).mo8668b(((Integer) this.f6153a.mo8549a(C1841c.f6055et)).intValue()).mo8661a(((Integer) this.f6153a.mo8549a(C1841c.f6056eu)).intValue()).mo8667a(), this.f6153a) {
            /* renamed from: a */
            public void mo7627a(int i) {
                C1977q a = C1848c.this.f6154b;
                a.mo8746e("AdEventStatsManager", "Failed to submitted ad stats: " + i);
            }

            /* renamed from: a */
            public void mo7628a(Object obj, int i) {
                C1977q a = C1848c.this.f6154b;
                a.mo8742b("AdEventStatsManager", "Ad stats submitted: " + i);
            }
        };
        r0.mo8496a(C1841c.f5811aK);
        r0.mo8498b(C1841c.f5812aL);
        this.f6153a.mo8533L().mo8475a((C1864a) r0, C1907s.C1909a.BACKGROUND);
    }

    /* renamed from: b */
    private C1851a m7098b(AppLovinAdBase appLovinAdBase) {
        C1851a aVar;
        synchronized (this.f6155c) {
            String primaryKey = appLovinAdBase.getPrimaryKey();
            aVar = (C1851a) this.f6156d.get(primaryKey);
            if (aVar == null) {
                C1851a aVar2 = new C1851a(primaryKey, appLovinAdBase.getSecondaryKey1(), appLovinAdBase.getSecondaryKey2(), this.f6153a);
                this.f6156d.put(primaryKey, aVar2);
                aVar = aVar2;
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7100b(C1847b bVar, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (bVar == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (((Boolean) this.f6153a.mo8549a(C1841c.f6054es)).booleanValue()) {
            synchronized (this.f6155c) {
                m7098b(appLovinAdBase).mo8352b(((Boolean) this.f6153a.mo8549a(C1841c.f6058ew)).booleanValue() ? bVar.mo8345b() : bVar.mo8344a(), j);
            }
        }
    }

    /* renamed from: c */
    private String m7103c() {
        return C1992h.m7846a("2.0/s", this.f6153a);
    }

    /* renamed from: d */
    private String m7105d() {
        return C1992h.m7856b("2.0/s", this.f6153a);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7106e() {
        if (((Boolean) this.f6153a.mo8549a(C1841c.f6054es)).booleanValue()) {
            this.f6153a.mo8533L().mo8479b().execute(new Runnable() {
                public void run() {
                    HashSet hashSet;
                    synchronized (C1848c.this.f6155c) {
                        hashSet = new HashSet(C1848c.this.f6156d.size());
                        for (C1851a aVar : C1848c.this.f6156d.values()) {
                            try {
                                hashSet.add(aVar.m7113a());
                            } catch (OutOfMemoryError e) {
                                C1977q a = C1848c.this.f6154b;
                                a.mo8743b("AdEventStatsManager", "Failed to serialize " + aVar + " due to OOM error", e);
                                C1848c.this.mo8348b();
                            }
                        }
                    }
                    C1848c.this.f6153a.mo8556a(C1843e.f6106t, hashSet);
                }
            });
        }
    }

    /* renamed from: a */
    public C1852b mo8346a(AppLovinAdBase appLovinAdBase) {
        return new C1852b(appLovinAdBase, this);
    }

    /* renamed from: a */
    public void mo8347a() {
        if (((Boolean) this.f6153a.mo8549a(C1841c.f6054es)).booleanValue()) {
            Set<String> set = (Set) this.f6153a.mo8574b(C1843e.f6106t, new HashSet(0));
            this.f6153a.mo8578b(C1843e.f6106t);
            if (set == null || set.isEmpty()) {
                this.f6154b.mo8742b("AdEventStatsManager", "No serialized ad events found");
                return;
            }
            C1977q qVar = this.f6154b;
            qVar.mo8742b("AdEventStatsManager", "De-serializing " + set.size() + " stat ad events");
            JSONArray jSONArray = new JSONArray();
            for (String str : set) {
                try {
                    jSONArray.put(new JSONObject(str));
                } catch (JSONException e) {
                    C1977q qVar2 = this.f6154b;
                    qVar2.mo8743b("AdEventStatsManager", "Failed to parse: " + str, e);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("stats", jSONArray);
                m7097a(jSONObject);
            } catch (JSONException e2) {
                this.f6154b.mo8743b("AdEventStatsManager", "Failed to create stats to submit", e2);
            }
        }
    }

    /* renamed from: b */
    public void mo8348b() {
        synchronized (this.f6155c) {
            this.f6154b.mo8742b("AdEventStatsManager", "Clearing ad stats...");
            this.f6156d.clear();
        }
    }
}
