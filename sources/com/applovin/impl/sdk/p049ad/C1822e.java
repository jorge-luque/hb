package com.applovin.impl.sdk.p049ad;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.e */
public class C1822e {

    /* renamed from: a */
    private final C1941j f5675a;

    /* renamed from: b */
    private final C1977q f5676b;

    /* renamed from: c */
    private final AtomicBoolean f5677c;

    /* renamed from: d */
    private final Map<MaxAdFormat, C1823f> f5678d;

    /* renamed from: e */
    private LinkedHashSet<C1821d> f5679e = new LinkedHashSet<>();

    /* renamed from: f */
    private final Object f5680f = new Object();

    /* renamed from: g */
    private volatile boolean f5681g;

    public C1822e(C1941j jVar) {
        this.f5675a = jVar;
        this.f5676b = jVar.mo8602v();
        this.f5677c = new AtomicBoolean();
        HashMap hashMap = new HashMap(5);
        this.f5678d = hashMap;
        MaxAdFormat maxAdFormat = MaxAdFormat.BANNER;
        hashMap.put(maxAdFormat, new C1823f(maxAdFormat, jVar));
        Map<MaxAdFormat, C1823f> map = this.f5678d;
        MaxAdFormat maxAdFormat2 = MaxAdFormat.LEADER;
        map.put(maxAdFormat2, new C1823f(maxAdFormat2, jVar));
        Map<MaxAdFormat, C1823f> map2 = this.f5678d;
        MaxAdFormat maxAdFormat3 = MaxAdFormat.MREC;
        map2.put(maxAdFormat3, new C1823f(maxAdFormat3, jVar));
        Map<MaxAdFormat, C1823f> map3 = this.f5678d;
        MaxAdFormat maxAdFormat4 = MaxAdFormat.INTERSTITIAL;
        map3.put(maxAdFormat4, new C1823f(maxAdFormat4, jVar));
        Map<MaxAdFormat, C1823f> map4 = this.f5678d;
        MaxAdFormat maxAdFormat5 = MaxAdFormat.REWARDED;
        map4.put(maxAdFormat5, new C1823f(maxAdFormat5, jVar));
    }

    /* renamed from: b */
    private boolean m6883b() {
        return ((Boolean) this.f5675a.mo8549a(C1841c.f6067ff)).booleanValue() && this.f5677c.get();
    }

    /* renamed from: c */
    private LinkedHashSet<C1821d> m6884c(JSONArray jSONArray) {
        LinkedHashSet<C1821d> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject a = C1993i.m7883a(jSONArray, i, (JSONObject) null, this.f5675a);
            linkedHashSet.add(C1821d.m6860a(C1993i.m7896b(a, "id", (String) null, this.f5675a), a, this.f5675a));
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public LinkedHashSet<C1821d> mo8187a() {
        LinkedHashSet<C1821d> linkedHashSet;
        synchronized (this.f5680f) {
            linkedHashSet = this.f5679e;
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public void mo8188a(AppLovinAdBase appLovinAdBase, boolean z, boolean z2) {
        if (m6883b()) {
            this.f5678d.get(appLovinAdBase.getAdZone().mo8175b()).mo8194a(appLovinAdBase, z, z2);
        }
    }

    /* renamed from: a */
    public void mo8189a(C1821d dVar, boolean z, int i) {
        if (m6883b()) {
            MaxAdFormat b = dVar.mo8175b();
            if (b != null) {
                this.f5678d.get(b).mo8195a(dVar, z, i);
            } else {
                C1823f.m6893a(dVar, i, this.f5675a);
            }
        }
    }

    /* renamed from: a */
    public void mo8190a(C1827g gVar) {
        if (m6883b()) {
            this.f5678d.get(gVar.getAdZone().mo8175b()).mo8193a();
        }
    }

    /* renamed from: a */
    public void mo8191a(JSONArray jSONArray) {
        if (((Boolean) this.f5675a.mo8549a(C1841c.f6067ff)).booleanValue()) {
            if (this.f5677c.compareAndSet(false, true)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject a = C1993i.m7883a(jSONArray, i, (JSONObject) null, this.f5675a);
                    C1821d a2 = C1821d.m6860a(C1993i.m7896b(a, "id", (String) null, this.f5675a), a, this.f5675a);
                    MaxAdFormat b = a2.mo8175b();
                    if (b == MaxAdFormat.BANNER) {
                        arrayList.add(a2);
                    } else if (b == MaxAdFormat.LEADER) {
                        arrayList2.add(a2);
                    } else if (b == MaxAdFormat.MREC) {
                        arrayList3.add(a2);
                    } else if (b == MaxAdFormat.INTERSTITIAL) {
                        arrayList4.add(a2);
                    } else if (b == MaxAdFormat.REWARDED) {
                        arrayList5.add(a2);
                    }
                }
                this.f5678d.get(MaxAdFormat.BANNER).mo8196a((List<C1821d>) arrayList);
                this.f5678d.get(MaxAdFormat.LEADER).mo8196a((List<C1821d>) arrayList2);
                this.f5678d.get(MaxAdFormat.MREC).mo8196a((List<C1821d>) arrayList3);
                this.f5678d.get(MaxAdFormat.INTERSTITIAL).mo8196a((List<C1821d>) arrayList4);
                this.f5678d.get(MaxAdFormat.REWARDED).mo8196a((List<C1821d>) arrayList5);
            }
        }
    }

    /* renamed from: b */
    public LinkedHashSet<C1821d> mo8192b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new LinkedHashSet<>();
        }
        LinkedHashSet<C1821d> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        synchronized (this.f5680f) {
            if (!this.f5681g) {
                C1977q qVar = this.f5676b;
                qVar.mo8742b("AdZoneManager", "Found " + jSONArray.length() + " zone(s)...");
                linkedHashSet = m6884c(jSONArray);
                this.f5679e = linkedHashSet;
                this.f5681g = true;
            }
        }
        return linkedHashSet;
    }
}
