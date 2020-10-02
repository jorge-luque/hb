package com.applovin.impl.sdk.p049ad;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

/* renamed from: com.applovin.impl.sdk.ad.d */
public final class C1821d {

    /* renamed from: a */
    private static final Map<String, C1821d> f5666a = new HashMap();

    /* renamed from: b */
    private static final Object f5667b = new Object();

    /* renamed from: c */
    private C1941j f5668c;

    /* renamed from: d */
    private C1977q f5669d;

    /* renamed from: e */
    private JSONObject f5670e;

    /* renamed from: f */
    private final String f5671f;

    /* renamed from: g */
    private String f5672g;

    /* renamed from: h */
    private AppLovinAdSize f5673h;

    /* renamed from: i */
    private AppLovinAdType f5674i;

    private C1821d(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, C1941j jVar) {
        if (!TextUtils.isEmpty(str) || !(appLovinAdType == null || appLovinAdSize == null)) {
            this.f5668c = jVar;
            this.f5669d = jVar != null ? jVar.mo8602v() : null;
            this.f5673h = appLovinAdSize;
            this.f5674i = appLovinAdType;
            if (!TextUtils.isEmpty(str)) {
                this.f5671f = str.toLowerCase(Locale.ENGLISH);
                this.f5672g = str.toLowerCase(Locale.ENGLISH);
                return;
            }
            this.f5671f = (appLovinAdSize.getLabel() + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + appLovinAdType.getLabel()).toLowerCase(Locale.ENGLISH);
            return;
        }
        throw new IllegalArgumentException("No zone identifier or type or size specified");
    }

    /* renamed from: a */
    public static C1821d m6857a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, C1941j jVar) {
        return m6858a(appLovinAdSize, appLovinAdType, (String) null, jVar);
    }

    /* renamed from: a */
    public static C1821d m6858a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, C1941j jVar) {
        C1821d dVar = new C1821d(appLovinAdSize, appLovinAdType, str, jVar);
        synchronized (f5667b) {
            String str2 = dVar.f5671f;
            if (f5666a.containsKey(str2)) {
                dVar = f5666a.get(str2);
            } else {
                f5666a.put(str2, dVar);
            }
        }
        return dVar;
    }

    /* renamed from: a */
    public static C1821d m6859a(String str, C1941j jVar) {
        return m6858a((AppLovinAdSize) null, (AppLovinAdType) null, str, jVar);
    }

    /* renamed from: a */
    public static C1821d m6860a(String str, JSONObject jSONObject, C1941j jVar) {
        C1821d a = m6859a(str, jVar);
        a.f5670e = jSONObject;
        return a;
    }

    /* renamed from: a */
    private <ST> C1841c<ST> m6861a(String str, C1841c<ST> cVar) {
        return this.f5668c.mo8548a(str + this.f5671f, cVar);
    }

    /* renamed from: a */
    public static Collection<C1821d> m6862a(C1941j jVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(8);
        Collections.addAll(linkedHashSet, new C1821d[]{m6865b(jVar), m6867c(jVar), m6868d(jVar), m6869e(jVar), m6870f(jVar), m6871g(jVar)});
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: a */
    public static void m6863a(JSONObject jSONObject, C1941j jVar) {
        if (jSONObject != null && jSONObject.has("ad_size") && jSONObject.has("ad_type")) {
            synchronized (f5667b) {
                C1821d dVar = f5666a.get(C1993i.m7896b(jSONObject, "zone_id", "", jVar));
                if (dVar != null) {
                    dVar.f5673h = AppLovinAdSize.fromString(C1993i.m7896b(jSONObject, "ad_size", "", jVar));
                    dVar.f5674i = AppLovinAdType.fromString(C1993i.m7896b(jSONObject, "ad_type", "", jVar));
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.applovin.impl.sdk.b.c<java.lang.String>, com.applovin.impl.sdk.b.c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m6864a(com.applovin.impl.sdk.p050b.C1841c<java.lang.String> r2, com.applovin.sdk.AppLovinAdSize r3) {
        /*
            r1 = this;
            com.applovin.impl.sdk.j r0 = r1.f5668c
            java.lang.Object r2 = r0.mo8549a(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r2 = r2.toUpperCase(r0)
            java.lang.String r3 = r3.getLabel()
            boolean r2 = r2.contains(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p049ad.C1821d.m6864a(com.applovin.impl.sdk.b.c, com.applovin.sdk.AppLovinAdSize):boolean");
    }

    /* renamed from: b */
    public static C1821d m6865b(C1941j jVar) {
        return m6857a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR, jVar);
    }

    /* renamed from: b */
    public static C1821d m6866b(String str, C1941j jVar) {
        return m6858a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str, jVar);
    }

    /* renamed from: c */
    public static C1821d m6867c(C1941j jVar) {
        return m6857a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR, jVar);
    }

    /* renamed from: d */
    public static C1821d m6868d(C1941j jVar) {
        return m6857a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR, jVar);
    }

    /* renamed from: e */
    public static C1821d m6869e(C1941j jVar) {
        return m6857a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR, jVar);
    }

    /* renamed from: f */
    public static C1821d m6870f(C1941j jVar) {
        return m6857a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, jVar);
    }

    /* renamed from: g */
    public static C1821d m6871g(C1941j jVar) {
        return m6857a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE, jVar);
    }

    /* renamed from: k */
    private boolean m6872k() {
        if (C2025o.m7963b(this.f5672g)) {
            return true;
        }
        return AppLovinAdType.INCENTIVIZED.equals(mo8177d()) ? ((Boolean) this.f5668c.mo8549a(C1841c.f5881bb)).booleanValue() : m6864a(C1841c.f5880ba, mo8176c());
    }

    /* renamed from: a */
    public String mo8174a() {
        return this.f5671f;
    }

    /* renamed from: b */
    public MaxAdFormat mo8175b() {
        AppLovinAdSize c = mo8176c();
        if (c == AppLovinAdSize.BANNER) {
            return MaxAdFormat.BANNER;
        }
        if (c == AppLovinAdSize.LEADER) {
            return MaxAdFormat.LEADER;
        }
        if (c == AppLovinAdSize.MREC) {
            return MaxAdFormat.MREC;
        }
        if (c == AppLovinAdSize.NATIVE) {
            return MaxAdFormat.NATIVE;
        }
        if (c != AppLovinAdSize.INTERSTITIAL) {
            return null;
        }
        if (mo8177d() == AppLovinAdType.REGULAR) {
            return MaxAdFormat.INTERSTITIAL;
        }
        if (mo8177d() == AppLovinAdType.INCENTIVIZED) {
            return MaxAdFormat.REWARDED;
        }
        return null;
    }

    /* renamed from: c */
    public AppLovinAdSize mo8176c() {
        if (this.f5673h == null && C1993i.m7893a(this.f5670e, "ad_size")) {
            this.f5673h = AppLovinAdSize.fromString(C1993i.m7896b(this.f5670e, "ad_size", (String) null, this.f5668c));
        }
        return this.f5673h;
    }

    /* renamed from: d */
    public AppLovinAdType mo8177d() {
        if (this.f5674i == null && C1993i.m7893a(this.f5670e, "ad_type")) {
            this.f5674i = AppLovinAdType.fromString(C1993i.m7896b(this.f5670e, "ad_type", (String) null, this.f5668c));
        }
        return this.f5674i;
    }

    /* renamed from: e */
    public boolean mo8178e() {
        return AppLovinAdSize.NATIVE.equals(mo8176c()) && AppLovinAdType.NATIVE.equals(mo8177d());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1821d.class != obj.getClass()) {
            return false;
        }
        return this.f5671f.equalsIgnoreCase(((C1821d) obj).f5671f);
    }

    /* renamed from: f */
    public int mo8180f() {
        if (C1993i.m7893a(this.f5670e, "capacity")) {
            return C1993i.m7894b(this.f5670e, "capacity", 0, this.f5668c);
        }
        if (!TextUtils.isEmpty(this.f5672g)) {
            return mo8178e() ? ((Integer) this.f5668c.mo8549a(C1841c.f5896bq)).intValue() : ((Integer) this.f5668c.mo8549a(C1841c.f5895bp)).intValue();
        }
        return ((Integer) this.f5668c.mo8549a(m6861a("preload_capacity_", C1841c.f5884be))).intValue();
    }

    /* renamed from: g */
    public int mo8181g() {
        if (C1993i.m7893a(this.f5670e, "extended_capacity")) {
            return C1993i.m7894b(this.f5670e, "extended_capacity", 0, this.f5668c);
        }
        if (TextUtils.isEmpty(this.f5672g)) {
            return ((Integer) this.f5668c.mo8549a(m6861a("extended_preload_capacity_", C1841c.f5890bk))).intValue();
        } else if (mo8178e()) {
            return 0;
        } else {
            return ((Integer) this.f5668c.mo8549a(C1841c.f5897br)).intValue();
        }
    }

    /* renamed from: h */
    public int mo8182h() {
        return C1993i.m7894b(this.f5670e, "preload_count", 0, this.f5668c);
    }

    public int hashCode() {
        return this.f5671f.hashCode();
    }

    /* renamed from: i */
    public boolean mo8184i() {
        if (!((Boolean) this.f5668c.mo8549a(C1841c.f5826aZ)).booleanValue() || !m6872k()) {
            return false;
        }
        if (TextUtils.isEmpty(this.f5672g)) {
            C1841c a = m6861a("preload_merge_init_tasks_", (C1841c) null);
            return a != null && ((Boolean) this.f5668c.mo8549a(a)).booleanValue() && mo8180f() > 0;
        } else if (this.f5670e != null && mo8182h() == 0) {
            return false;
        } else {
            String upperCase = ((String) this.f5668c.mo8549a(C1841c.f5880ba)).toUpperCase(Locale.ENGLISH);
            if (upperCase.contains(AppLovinAdSize.INTERSTITIAL.getLabel()) || upperCase.contains(AppLovinAdSize.BANNER.getLabel()) || upperCase.contains(AppLovinAdSize.MREC.getLabel()) || upperCase.contains(AppLovinAdSize.LEADER.getLabel())) {
                return ((Boolean) this.f5668c.mo8549a(C1841c.f5904by)).booleanValue();
            }
            return false;
        }
    }

    /* renamed from: j */
    public boolean mo8185j() {
        return m6862a(this.f5668c).contains(this);
    }

    public String toString() {
        return "AdZone{id=" + this.f5671f + ", zoneObject=" + this.f5670e + '}';
    }
}
