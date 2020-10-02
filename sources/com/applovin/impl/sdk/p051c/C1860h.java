package com.applovin.impl.sdk.p051c;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1843e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.h */
public class C1860h {

    /* renamed from: a */
    private final C1941j f6208a;

    /* renamed from: b */
    private final Map<String, Long> f6209b = new HashMap();

    public C1860h(C1941j jVar) {
        if (jVar != null) {
            this.f6208a = jVar;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: e */
    private void m7158e() {
        try {
            this.f6208a.mo8556a(C1843e.f6100n, mo8393c().toString());
        } catch (Throwable th) {
            this.f6208a.mo8602v().mo8743b("GlobalStatsManager", "Unable to save stats", th);
        }
    }

    /* renamed from: a */
    public long mo8387a(C1859g gVar) {
        return mo8388a(gVar, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo8388a(C1859g gVar, long j) {
        long longValue;
        synchronized (this.f6209b) {
            Long l = this.f6209b.get(gVar.mo8386a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue() + j;
            this.f6209b.put(gVar.mo8386a(), Long.valueOf(longValue));
        }
        m7158e();
        return longValue;
    }

    /* renamed from: a */
    public void mo8389a() {
        synchronized (this.f6209b) {
            this.f6209b.clear();
        }
        m7158e();
    }

    /* renamed from: b */
    public long mo8390b(C1859g gVar) {
        long longValue;
        synchronized (this.f6209b) {
            Long l = this.f6209b.get(gVar.mo8386a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    /* renamed from: b */
    public void mo8391b() {
        synchronized (this.f6209b) {
            for (C1859g a : C1859g.m7156b()) {
                this.f6209b.remove(a.mo8386a());
            }
            m7158e();
        }
    }

    /* renamed from: b */
    public void mo8392b(C1859g gVar, long j) {
        synchronized (this.f6209b) {
            this.f6209b.put(gVar.mo8386a(), Long.valueOf(j));
        }
        m7158e();
    }

    /* renamed from: c */
    public JSONObject mo8393c() throws JSONException {
        JSONObject jSONObject;
        synchronized (this.f6209b) {
            jSONObject = new JSONObject();
            for (Map.Entry next : this.f6209b.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        }
        return jSONObject;
    }

    /* renamed from: c */
    public void mo8394c(C1859g gVar) {
        synchronized (this.f6209b) {
            this.f6209b.remove(gVar.mo8386a());
        }
        m7158e();
    }

    /* renamed from: d */
    public void mo8395d() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.f6208a.mo8574b(C1843e.f6100n, "{}"));
            synchronized (this.f6209b) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        this.f6209b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f6208a.mo8602v().mo8743b("GlobalStatsManager", "Unable to load stats", th);
        }
    }
}
