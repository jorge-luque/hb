package com.applovin.impl.p033a;

import android.net.Uri;
import com.applovin.impl.p033a.C1490j;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1818b;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1846a;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.a */
public class C1476a extends C1827g {

    /* renamed from: a */
    private final String f4583a;

    /* renamed from: b */
    private final String f4584b;

    /* renamed from: c */
    private final C1486f f4585c;

    /* renamed from: d */
    private final long f4586d;

    /* renamed from: e */
    private final C1490j f4587e;

    /* renamed from: f */
    private final C1481b f4588f;

    /* renamed from: g */
    private final String f4589g;

    /* renamed from: h */
    private final Set<C1487g> f4590h;

    /* renamed from: i */
    private final Set<C1487g> f4591i;

    /* renamed from: com.applovin.impl.a.a$a */
    public static class C1478a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public JSONObject f4592a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public JSONObject f4593b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public C1818b f4594c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public C1941j f4595d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public long f4596e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public String f4597f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public String f4598g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public C1486f f4599h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public C1490j f4600i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public C1481b f4601j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public Set<C1487g> f4602k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public Set<C1487g> f4603l;

        private C1478a() {
        }

        /* renamed from: a */
        public C1478a mo7170a(long j) {
            this.f4596e = j;
            return this;
        }

        /* renamed from: a */
        public C1478a mo7171a(C1481b bVar) {
            this.f4601j = bVar;
            return this;
        }

        /* renamed from: a */
        public C1478a mo7172a(C1486f fVar) {
            this.f4599h = fVar;
            return this;
        }

        /* renamed from: a */
        public C1478a mo7173a(C1490j jVar) {
            this.f4600i = jVar;
            return this;
        }

        /* renamed from: a */
        public C1478a mo7174a(C1818b bVar) {
            this.f4594c = bVar;
            return this;
        }

        /* renamed from: a */
        public C1478a mo7175a(C1941j jVar) {
            if (jVar != null) {
                this.f4595d = jVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        /* renamed from: a */
        public C1478a mo7176a(String str) {
            this.f4597f = str;
            return this;
        }

        /* renamed from: a */
        public C1478a mo7177a(Set<C1487g> set) {
            this.f4602k = set;
            return this;
        }

        /* renamed from: a */
        public C1478a mo7178a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f4592a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        /* renamed from: a */
        public C1476a mo7179a() {
            return new C1476a(this);
        }

        /* renamed from: b */
        public C1478a mo7180b(String str) {
            this.f4598g = str;
            return this;
        }

        /* renamed from: b */
        public C1478a mo7181b(Set<C1487g> set) {
            this.f4603l = set;
            return this;
        }

        /* renamed from: b */
        public C1478a mo7182b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f4593b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }
    }

    /* renamed from: com.applovin.impl.a.a$b */
    public enum C1479b {
        COMPANION_AD,
        VIDEO
    }

    /* renamed from: com.applovin.impl.a.a$c */
    public enum C1480c {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        ERROR
    }

    private C1476a(C1478a aVar) {
        super(aVar.f4592a, aVar.f4593b, aVar.f4594c, aVar.f4595d);
        this.f4583a = aVar.f4597f;
        this.f4585c = aVar.f4599h;
        this.f4584b = aVar.f4598g;
        this.f4587e = aVar.f4600i;
        this.f4588f = aVar.f4601j;
        this.f4590h = aVar.f4602k;
        this.f4591i = aVar.f4603l;
        Uri f = mo7157f();
        this.f4589g = f != null ? f.toString() : "";
        this.f4586d = aVar.f4596e;
    }

    /* renamed from: a */
    private Set<C1487g> m5694a(C1479b bVar, String[] strArr) {
        C1481b bVar2;
        C1490j jVar;
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptySet();
        }
        Map<String, Set<C1487g>> map = null;
        if (bVar == C1479b.VIDEO && (jVar = this.f4587e) != null) {
            map = jVar.mo7222e();
        } else if (bVar == C1479b.COMPANION_AD && (bVar2 = this.f4588f) != null) {
            map = bVar2.mo7186d();
        }
        HashSet hashSet = new HashSet();
        if (map != null && !map.isEmpty()) {
            for (String str : strArr) {
                if (map.containsKey(str)) {
                    hashSet.addAll(map.get(str));
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: aV */
    public static C1478a m5695aV() {
        return new C1478a();
    }

    /* renamed from: aW */
    private String m5696aW() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    /* renamed from: aX */
    private C1490j.C1492a m5697aX() {
        C1490j.C1492a[] values = C1490j.C1492a.values();
        int intValue = ((Integer) this.sdk.mo8549a(C1841c.f6017eH)).intValue();
        return (intValue < 0 || intValue >= values.length) ? C1490j.C1492a.UNSPECIFIED : values[intValue];
    }

    /* renamed from: aY */
    private Set<C1487g> m5698aY() {
        C1490j jVar = this.f4587e;
        return jVar != null ? jVar.mo7221d() : Collections.emptySet();
    }

    /* renamed from: aZ */
    private Set<C1487g> m5699aZ() {
        C1481b bVar = this.f4588f;
        return bVar != null ? bVar.mo7185c() : Collections.emptySet();
    }

    /* renamed from: a */
    public Set<C1487g> mo7142a(C1480c cVar, String str) {
        return mo7143a(cVar, new String[]{str});
    }

    /* renamed from: a */
    public Set<C1487g> mo7143a(C1480c cVar, String[] strArr) {
        C1977q v = this.sdk.mo8602v();
        v.mo8742b("VastAd", "Retrieving trackers of type '" + cVar + "' and events '" + strArr + "'...");
        if (cVar == C1480c.IMPRESSION) {
            return this.f4590h;
        }
        if (cVar == C1480c.VIDEO_CLICK) {
            return m5698aY();
        }
        if (cVar == C1480c.COMPANION_CLICK) {
            return m5699aZ();
        }
        if (cVar == C1480c.VIDEO) {
            return m5694a(C1479b.VIDEO, strArr);
        }
        if (cVar == C1480c.COMPANION) {
            return m5694a(C1479b.COMPANION_AD, strArr);
        }
        if (cVar == C1480c.ERROR) {
            return this.f4591i;
        }
        C1977q v2 = this.sdk.mo8602v();
        v2.mo8746e("VastAd", "Failed to retrieve trackers of invalid type '" + cVar + "' and events '" + strArr + "'");
        return Collections.emptySet();
    }

    /* renamed from: a */
    public void mo7144a() {
    }

    /* renamed from: a */
    public void mo7145a(String str) {
        synchronized (this.adObjectLock) {
            C1993i.m7886a(this.adObject, "html_template", str, this.sdk);
        }
    }

    /* renamed from: aQ */
    public boolean mo7146aQ() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", false);
    }

    /* renamed from: aR */
    public String mo7147aR() {
        return getStringFromAdObject("html_template", "");
    }

    /* renamed from: aS */
    public Uri mo7148aS() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", (String) null);
        if (C2025o.m7963b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aT */
    public boolean mo7149aT() {
        return getBooleanFromAdObject("cache_companion_ad", true);
    }

    /* renamed from: aU */
    public boolean mo7150aU() {
        return getBooleanFromAdObject("cache_video", true);
    }

    /* renamed from: az */
    public List<C1846a> mo7151az() {
        List<C1846a> a;
        synchronized (this.adObjectLock) {
            a = C2029r.m8003a("vimp_urls", this.adObject, getClCode(), C1989e.m7834a("{SOC}", String.valueOf(mo8268av())), m5696aW(), mo8231aA(), this.sdk);
        }
        return a;
    }

    /* renamed from: b */
    public void mo7152b() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    /* renamed from: c */
    public String mo7153c() {
        return this.f4589g;
    }

    /* renamed from: d */
    public boolean mo7154d() {
        return getBooleanFromAdObject("vast_is_streaming", false);
    }

    /* renamed from: e */
    public C1479b mo7155e() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? C1479b.COMPANION_AD : C1479b.VIDEO;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1476a) || !super.equals(obj)) {
            return false;
        }
        C1476a aVar = (C1476a) obj;
        String str = this.f4583a;
        if (str == null ? aVar.f4583a != null : !str.equals(aVar.f4583a)) {
            return false;
        }
        String str2 = this.f4584b;
        if (str2 == null ? aVar.f4584b != null : !str2.equals(aVar.f4584b)) {
            return false;
        }
        C1486f fVar = this.f4585c;
        if (fVar == null ? aVar.f4585c != null : !fVar.equals(aVar.f4585c)) {
            return false;
        }
        C1490j jVar = this.f4587e;
        if (jVar == null ? aVar.f4587e != null : !jVar.equals(aVar.f4587e)) {
            return false;
        }
        C1481b bVar = this.f4588f;
        if (bVar == null ? aVar.f4588f != null : !bVar.equals(aVar.f4588f)) {
            return false;
        }
        Set<C1487g> set = this.f4590h;
        if (set == null ? aVar.f4590h != null : !set.equals(aVar.f4590h)) {
            return false;
        }
        Set<C1487g> set2 = this.f4591i;
        Set<C1487g> set3 = aVar.f4591i;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    /* renamed from: f */
    public Uri mo7157f() {
        C1493k l = mo7166l();
        if (l != null) {
            return l.mo7230b();
        }
        return null;
    }

    /* renamed from: g */
    public boolean mo7158g() {
        return getBooleanFromAdObject("vast_immediate_ad_load", true);
    }

    public long getCreatedAtMillis() {
        return this.f4586d;
    }

    /* renamed from: h */
    public Uri mo7160h() {
        C1490j jVar = this.f4587e;
        if (jVar != null) {
            return jVar.mo7220c();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.mo7218a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasVideoUrl() {
        /*
            r2 = this;
            com.applovin.impl.a.j r0 = r2.f4587e
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = r0.mo7218a()
            if (r0 == 0) goto L_0x0012
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0012
            r1 = 1
        L_0x0012:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.p033a.C1476a.hasVideoUrl():boolean");
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f4583a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f4584b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        C1486f fVar = this.f4585c;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 31;
        C1490j jVar = this.f4587e;
        int hashCode5 = (hashCode4 + (jVar != null ? jVar.hashCode() : 0)) * 31;
        C1481b bVar = this.f4588f;
        int hashCode6 = (hashCode5 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        Set<C1487g> set = this.f4590h;
        int hashCode7 = (hashCode6 + (set != null ? set.hashCode() : 0)) * 31;
        Set<C1487g> set2 = this.f4591i;
        if (set2 != null) {
            i = set2.hashCode();
        }
        return hashCode7 + i;
    }

    /* renamed from: i */
    public Uri mo7163i() {
        return mo7160h();
    }

    /* renamed from: j */
    public C1486f mo7164j() {
        return this.f4585c;
    }

    /* renamed from: k */
    public C1490j mo7165k() {
        return this.f4587e;
    }

    /* renamed from: l */
    public C1493k mo7166l() {
        C1490j jVar = this.f4587e;
        if (jVar != null) {
            return jVar.mo7217a(m5697aX());
        }
        return null;
    }

    /* renamed from: m */
    public C1481b mo7167m() {
        return this.f4588f;
    }

    public String toString() {
        return "VastAd{title='" + this.f4583a + '\'' + ", adDescription='" + this.f4584b + '\'' + ", systemInfo=" + this.f4585c + ", videoCreative=" + this.f4587e + ", companionAd=" + this.f4588f + ", impressionTrackers=" + this.f4590h + ", errorTrackers=" + this.f4591i + '}';
    }

    /* renamed from: z */
    public boolean mo7169z() {
        return getBooleanFromAdObject("video_clickable", false) && mo7160h() != null;
    }
}
