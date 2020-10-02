package com.applovin.impl.p033a;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2032t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.j */
public class C1490j {

    /* renamed from: a */
    private List<C1493k> f4660a;

    /* renamed from: b */
    private List<String> f4661b;

    /* renamed from: c */
    private int f4662c;

    /* renamed from: d */
    private Uri f4663d;

    /* renamed from: e */
    private final Set<C1487g> f4664e = new HashSet();

    /* renamed from: f */
    private final Map<String, Set<C1487g>> f4665f = new HashMap();

    /* renamed from: com.applovin.impl.a.j$a */
    public enum C1492a {
        UNSPECIFIED,
        LOW,
        MEDIUM,
        HIGH
    }

    private C1490j() {
        List<C1493k> list = Collections.EMPTY_LIST;
        this.f4660a = list;
        this.f4661b = list;
    }

    private C1490j(C1482c cVar) {
        List<C1493k> list = Collections.EMPTY_LIST;
        this.f4660a = list;
        this.f4661b = list;
        this.f4661b = cVar.mo7197h();
    }

    /* renamed from: a */
    private static int m5795a(String str, C1941j jVar) {
        try {
            List<String> a = C1989e.m7832a(str, ":");
            if (a.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds((long) C2025o.m7953a(a.get(0))) + TimeUnit.MINUTES.toSeconds((long) C2025o.m7953a(a.get(1))) + ((long) C2025o.m7953a(a.get(2))));
            }
        } catch (Throwable unused) {
            C1977q v = jVar.mo8602v();
            v.mo8746e("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
        }
        return 0;
    }

    /* renamed from: a */
    public static C1490j m5796a(C2032t tVar, C1490j jVar, C1482c cVar, C1941j jVar2) {
        C2032t b;
        List<C1493k> a;
        C2032t b2;
        int a2;
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (cVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (jVar2 != null) {
            if (jVar == null) {
                try {
                    jVar = new C1490j(cVar);
                } catch (Throwable th) {
                    jVar2.mo8602v().mo8743b("VastVideoCreative", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (jVar.f4662c == 0 && (b2 = tVar.mo8825b("Duration")) != null && (a2 = m5795a(b2.mo8828c(), jVar2)) > 0) {
                jVar.f4662c = a2;
            }
            C2032t b3 = tVar.mo8825b("MediaFiles");
            if (!(b3 == null || (a = m5797a(b3, jVar2)) == null || a.size() <= 0)) {
                if (jVar.f4660a != null) {
                    a.addAll(jVar.f4660a);
                }
                jVar.f4660a = a;
            }
            C2032t b4 = tVar.mo8825b("VideoClicks");
            if (b4 != null) {
                if (jVar.f4663d == null && (b = b4.mo8825b("ClickThrough")) != null) {
                    String c = b.mo8828c();
                    if (C2025o.m7963b(c)) {
                        jVar.f4663d = Uri.parse(c);
                    }
                }
                C1489i.m5786a(b4.mo8824a("ClickTracking"), jVar.f4664e, cVar, jVar2);
            }
            C1489i.m5785a(tVar, jVar.f4665f, cVar, jVar2);
            return jVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    private static List<C1493k> m5797a(C2032t tVar, C1941j jVar) {
        List<C2032t> a = tVar.mo8824a("MediaFile");
        ArrayList arrayList = new ArrayList(a.size());
        List<String> a2 = C1989e.m7831a((String) jVar.mo8549a(C1841c.f6015eF));
        List<String> a3 = C1989e.m7831a((String) jVar.mo8549a(C1841c.f6014eE));
        for (C2032t a4 : a) {
            C1493k a5 = C1493k.m5806a(a4, jVar);
            if (a5 != null) {
                try {
                    String c = a5.mo7231c();
                    if (!C2025o.m7963b(c) || a2.contains(c)) {
                        if (((Boolean) jVar.mo8549a(C1841c.f6016eG)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a5.mo7230b().toString());
                            if (C2025o.m7963b(fileExtensionFromUrl) && !a3.contains(fileExtensionFromUrl)) {
                            }
                        }
                        C1977q v = jVar.mo8602v();
                        v.mo8745d("VastVideoCreative", "Video file not supported: " + a5);
                    }
                    arrayList.add(a5);
                } catch (Throwable th) {
                    C1977q v2 = jVar.mo8602v();
                    v2.mo8743b("VastVideoCreative", "Failed to validate video file: " + a5, th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C1493k mo7217a(C1492a aVar) {
        List<C1493k> list = this.f4660a;
        if (list == null || list.size() == 0) {
            return null;
        }
        List arrayList = new ArrayList(3);
        for (String next : this.f4661b) {
            for (C1493k next2 : this.f4660a) {
                String c = next2.mo7231c();
                if (C2025o.m7963b(c) && next.equalsIgnoreCase(c)) {
                    arrayList.add(next2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f4660a;
        }
        if (C1991g.m7840c()) {
            Collections.sort(arrayList, new Comparator<C1493k>() {
                @TargetApi(19)
                /* renamed from: a */
                public int compare(C1493k kVar, C1493k kVar2) {
                    return C0000a.m0a(kVar.mo7232d(), kVar2.mo7232d());
                }
            });
        }
        return (C1493k) arrayList.get(aVar == C1492a.LOW ? 0 : aVar == C1492a.MEDIUM ? arrayList.size() / 2 : arrayList.size() - 1);
    }

    /* renamed from: a */
    public List<C1493k> mo7218a() {
        return this.f4660a;
    }

    /* renamed from: b */
    public int mo7219b() {
        return this.f4662c;
    }

    /* renamed from: c */
    public Uri mo7220c() {
        return this.f4663d;
    }

    /* renamed from: d */
    public Set<C1487g> mo7221d() {
        return this.f4664e;
    }

    /* renamed from: e */
    public Map<String, Set<C1487g>> mo7222e() {
        return this.f4665f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1490j)) {
            return false;
        }
        C1490j jVar = (C1490j) obj;
        if (this.f4662c != jVar.f4662c) {
            return false;
        }
        List<C1493k> list = this.f4660a;
        if (list == null ? jVar.f4660a != null : !list.equals(jVar.f4660a)) {
            return false;
        }
        Uri uri = this.f4663d;
        if (uri == null ? jVar.f4663d != null : !uri.equals(jVar.f4663d)) {
            return false;
        }
        Set<C1487g> set = this.f4664e;
        if (set == null ? jVar.f4664e != null : !set.equals(jVar.f4664e)) {
            return false;
        }
        Map<String, Set<C1487g>> map = this.f4665f;
        Map<String, Set<C1487g>> map2 = jVar.f4665f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        List<C1493k> list = this.f4660a;
        int i = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f4662c) * 31;
        Uri uri = this.f4663d;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<C1487g> set = this.f4664e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C1487g>> map = this.f4665f;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f4660a + ", durationSeconds=" + this.f4662c + ", destinationUri=" + this.f4663d + ", clickTrackers=" + this.f4664e + ", eventTrackers=" + this.f4665f + '}';
    }
}
