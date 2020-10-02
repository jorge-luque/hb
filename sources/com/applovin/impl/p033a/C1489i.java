package com.applovin.impl.p033a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.network.C1968f;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.impl.sdk.utils.C2032t;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.tapjoy.TapjoyConstants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.i */
public class C1489i {

    /* renamed from: a */
    private static DateFormat f4658a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    /* renamed from: b */
    private static Random f4659b = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static Uri m5776a(String str, long j, Uri uri, C1483d dVar, C1941j jVar) {
        if (URLUtil.isValidUrl(str)) {
            try {
                String replace = str.replace("[ERRORCODE]", Integer.toString(dVar.mo7199a()));
                if (j >= 0) {
                    replace = replace.replace("[CONTENTPLAYHEAD]", m5779a(j));
                }
                if (uri != null) {
                    replace = replace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(replace.replace("[CACHEBUSTING]", m5778a()).replace("[TIMESTAMP]", m5791b()));
            } catch (Throwable th) {
                C1977q v = jVar.mo8602v();
                v.mo8743b("VastUtils", "Unable to replace macros in URL string " + str, th);
                return null;
            }
        } else {
            jVar.mo8602v().mo8746e("VastUtils", "Unable to replace macros in invalid URL string.");
            return null;
        }
    }

    /* renamed from: a */
    public static C1483d m5777a(C1476a aVar) {
        if (m5792b(aVar) || m5794c(aVar)) {
            return null;
        }
        return C1483d.GENERAL_WRAPPER_ERROR;
    }

    /* renamed from: a */
    private static String m5778a() {
        return Integer.toString(f4659b.nextInt(89999999) + 10000000);
    }

    /* renamed from: a */
    private static String m5779a(long j) {
        if (j <= 0) {
            return "00:00:00.000";
        }
        long hours = TimeUnit.SECONDS.toHours(j);
        long seconds = j % TimeUnit.MINUTES.toSeconds(1);
        return String.format(Locale.US, "%02d:%02d:%02d.000", new Object[]{Long.valueOf(hours), Long.valueOf(TimeUnit.SECONDS.toMinutes(j) % TimeUnit.MINUTES.toSeconds(1)), Long.valueOf(seconds)});
    }

    /* renamed from: a */
    public static String m5780a(C1482c cVar) {
        C2032t c;
        if (cVar != null) {
            List<C2032t> b = cVar.mo7191b();
            int size = cVar.mo7191b().size();
            if (size <= 0 || (c = b.get(size - 1).mo8827c("VASTAdTagURI")) == null) {
                return null;
            }
            return c.mo8828c();
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    /* renamed from: a */
    public static String m5781a(C2032t tVar, String str, String str2) {
        C2032t b = tVar.mo8825b(str);
        if (b != null) {
            String c = b.mo8828c();
            if (C2025o.m7963b(c)) {
                return c;
            }
        }
        return str2;
    }

    /* renamed from: a */
    private static Set<C1487g> m5782a(C1482c cVar, C1941j jVar) {
        if (cVar == null) {
            return null;
        }
        List<C2032t> b = cVar.mo7191b();
        Set<C1487g> hashSet = new HashSet<>(b.size());
        for (C2032t next : b) {
            C2032t c = next.mo8827c("Wrapper");
            if (c == null) {
                c = next.mo8827c("InLine");
            }
            hashSet = m5783a(hashSet, c != null ? c.mo8824a("Error") : next.mo8824a("Error"), cVar, jVar);
        }
        C1977q v = jVar.mo8602v();
        v.mo8742b("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
        return hashSet;
    }

    /* renamed from: a */
    private static Set<C1487g> m5783a(Set<C1487g> set, List<C2032t> list, C1482c cVar, C1941j jVar) {
        if (list != null) {
            for (C2032t a : list) {
                C1487g a2 = C1487g.m5772a(a, cVar, jVar);
                if (a2 != null) {
                    set.add(a2);
                }
            }
        }
        return set;
    }

    /* renamed from: a */
    public static void m5784a(C1482c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1483d dVar, int i, C1941j jVar) {
        if (jVar != null) {
            C2029r.m8008a(appLovinAdLoadListener, cVar.mo7196g(), i, jVar);
            m5788a(m5782a(cVar, jVar), dVar, jVar);
            return;
        }
        throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
    }

    /* renamed from: a */
    public static void m5785a(C2032t tVar, Map<String, Set<C1487g>> map, C1482c cVar, C1941j jVar) {
        List<C2032t> a;
        C1977q v;
        String str;
        if (jVar != null) {
            if (tVar == null) {
                v = jVar.mo8602v();
                str = "Unable to render event trackers; null node provided";
            } else if (map == null) {
                v = jVar.mo8602v();
                str = "Unable to render event trackers; null event trackers provided";
            } else {
                C2032t b = tVar.mo8825b("TrackingEvents");
                if (b != null && (a = b.mo8824a("Tracking")) != null) {
                    for (C2032t next : a) {
                        String str2 = next.mo8826b().get(TapjoyConstants.TJC_SDK_TYPE_DEFAULT);
                        if (C2025o.m7963b(str2)) {
                            C1487g a2 = C1487g.m5772a(next, cVar, jVar);
                            if (a2 != null) {
                                Set set = map.get(str2);
                                if (set != null) {
                                    set.add(a2);
                                } else {
                                    HashSet hashSet = new HashSet();
                                    hashSet.add(a2);
                                    map.put(str2, hashSet);
                                }
                            }
                        } else {
                            C1977q v2 = jVar.mo8602v();
                            v2.mo8746e("VastUtils", "Could not find event for tracking node = " + next);
                        }
                    }
                    return;
                }
                return;
            }
            v.mo8746e("VastUtils", str);
            return;
        }
        throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m5786a(List<C2032t> list, Set<C1487g> set, C1482c cVar, C1941j jVar) {
        C1977q v;
        String str;
        if (jVar != null) {
            if (list == null) {
                v = jVar.mo8602v();
                str = "Unable to render trackers; null nodes provided";
            } else if (set == null) {
                v = jVar.mo8602v();
                str = "Unable to render trackers; null trackers provided";
            } else {
                for (C2032t a : list) {
                    C1487g a2 = C1487g.m5772a(a, cVar, jVar);
                    if (a2 != null) {
                        set.add(a2);
                    }
                }
                return;
            }
            v.mo8746e("VastUtils", str);
            return;
        }
        throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m5787a(Set<C1487g> set, long j, Uri uri, C1483d dVar, C1941j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        } else if (set != null && !set.isEmpty()) {
            for (C1487g b : set) {
                Uri a = m5776a(b.mo7213b(), j, uri, dVar, jVar);
                if (a != null) {
                    jVar.mo8535N().mo8679a(C1968f.m7656m().mo8703c(a.toString()).mo8699a(false).mo8700a(), false);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m5788a(Set<C1487g> set, C1483d dVar, C1941j jVar) {
        m5787a(set, -1, (Uri) null, dVar, jVar);
    }

    /* renamed from: a */
    public static void m5789a(Set<C1487g> set, C1941j jVar) {
        m5787a(set, -1, (Uri) null, C1483d.UNSPECIFIED, jVar);
    }

    /* renamed from: a */
    public static boolean m5790a(C2032t tVar) {
        if (tVar != null) {
            return tVar.mo8827c("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    /* renamed from: b */
    private static String m5791b() {
        f4658a.setTimeZone(TimeZone.getDefault());
        return f4658a.format(new Date());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r1 = (r1 = r1.mo7165k()).mo7218a();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m5792b(com.applovin.impl.p033a.C1476a r1) {
        /*
            r0 = 0
            if (r1 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.applovin.impl.a.j r1 = r1.mo7165k()
            if (r1 == 0) goto L_0x0017
            java.util.List r1 = r1.mo7218a()
            if (r1 == 0) goto L_0x0017
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0017
            r0 = 1
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.p033a.C1489i.m5792b(com.applovin.impl.a.a):boolean");
    }

    /* renamed from: b */
    public static boolean m5793b(C2032t tVar) {
        if (tVar != null) {
            return tVar.mo8827c("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    /* renamed from: c */
    public static boolean m5794c(C1476a aVar) {
        C1481b m;
        C1484e b;
        if (aVar == null || (m = aVar.mo7167m()) == null || (b = m.mo7184b()) == null) {
            return false;
        }
        return b.mo7203b() != null || C2025o.m7963b(b.mo7204c());
    }
}
