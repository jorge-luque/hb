package com.applovin.impl.p033a;

import android.net.Uri;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2032t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.a.b */
public class C1481b {

    /* renamed from: a */
    private int f4614a;

    /* renamed from: b */
    private int f4615b;

    /* renamed from: c */
    private Uri f4616c;

    /* renamed from: d */
    private C1484e f4617d;

    /* renamed from: e */
    private Set<C1487g> f4618e = new HashSet();

    /* renamed from: f */
    private Map<String, Set<C1487g>> f4619f = new HashMap();

    private C1481b() {
    }

    /* renamed from: a */
    public static C1481b m5748a(C2032t tVar, C1481b bVar, C1482c cVar, C1941j jVar) {
        C2032t b;
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (jVar != null) {
            if (bVar == null) {
                try {
                    bVar = new C1481b();
                } catch (Throwable th) {
                    jVar.mo8602v().mo8743b("VastCompanionAd", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (bVar.f4614a == 0 && bVar.f4615b == 0) {
                int a = C2025o.m7953a(tVar.mo8826b().get("width"));
                int a2 = C2025o.m7953a(tVar.mo8826b().get("height"));
                if (a > 0 && a2 > 0) {
                    bVar.f4614a = a;
                    bVar.f4615b = a2;
                }
            }
            bVar.f4617d = C1484e.m5763a(tVar, bVar.f4617d, jVar);
            if (bVar.f4616c == null && (b = tVar.mo8825b("CompanionClickThrough")) != null) {
                String c = b.mo8828c();
                if (C2025o.m7963b(c)) {
                    bVar.f4616c = Uri.parse(c);
                }
            }
            C1489i.m5786a(tVar.mo8824a("CompanionClickTracking"), bVar.f4618e, cVar, jVar);
            C1489i.m5785a(tVar, bVar.f4619f, cVar, jVar);
            return bVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public Uri mo7183a() {
        return this.f4616c;
    }

    /* renamed from: b */
    public C1484e mo7184b() {
        return this.f4617d;
    }

    /* renamed from: c */
    public Set<C1487g> mo7185c() {
        return this.f4618e;
    }

    /* renamed from: d */
    public Map<String, Set<C1487g>> mo7186d() {
        return this.f4619f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1481b)) {
            return false;
        }
        C1481b bVar = (C1481b) obj;
        if (this.f4614a != bVar.f4614a || this.f4615b != bVar.f4615b) {
            return false;
        }
        Uri uri = this.f4616c;
        if (uri == null ? bVar.f4616c != null : !uri.equals(bVar.f4616c)) {
            return false;
        }
        C1484e eVar = this.f4617d;
        if (eVar == null ? bVar.f4617d != null : !eVar.equals(bVar.f4617d)) {
            return false;
        }
        Set<C1487g> set = this.f4618e;
        if (set == null ? bVar.f4618e != null : !set.equals(bVar.f4618e)) {
            return false;
        }
        Map<String, Set<C1487g>> map = this.f4619f;
        Map<String, Set<C1487g>> map2 = bVar.f4619f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        int i = ((this.f4614a * 31) + this.f4615b) * 31;
        Uri uri = this.f4616c;
        int i2 = 0;
        int hashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        C1484e eVar = this.f4617d;
        int hashCode2 = (hashCode + (eVar != null ? eVar.hashCode() : 0)) * 31;
        Set<C1487g> set = this.f4618e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C1487g>> map = this.f4619f;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f4614a + ", height=" + this.f4615b + ", destinationUri=" + this.f4616c + ", nonVideoResource=" + this.f4617d + ", clickTrackers=" + this.f4618e + ", eventTrackers=" + this.f4619f + '}';
    }
}
