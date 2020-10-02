package p113i.p114e0.p116f;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import p113i.C3480a0;
import p113i.C3530l;
import p113i.C3537r;
import p113i.C3539s;
import p113i.C3548y;
import p113i.C5966m;
import p113i.p114e0.C3500c;
import p119j.C3581f;

/* renamed from: i.e0.f.e */
/* compiled from: HttpHeaders */
public final class C5940e {
    static {
        C3581f.m12177d("\"\\");
        C3581f.m12177d("\t ,=");
    }

    /* renamed from: a */
    public static long m19028a(C3480a0 a0Var) {
        return m19029a(a0Var.mo19290x());
    }

    /* renamed from: b */
    public static boolean m19036b(C3537r rVar) {
        return m19037c(rVar).contains("*");
    }

    /* renamed from: c */
    public static boolean m19038c(C3480a0 a0Var) {
        return m19036b(a0Var.mo19290x());
    }

    /* renamed from: d */
    private static Set<String> m19039d(C3480a0 a0Var) {
        return m19037c(a0Var.mo19290x());
    }

    /* renamed from: e */
    public static C3537r m19040e(C3480a0 a0Var) {
        return m19031a(a0Var.mo19274A().mo19281b0().mo19603c(), a0Var.mo19290x());
    }

    /* renamed from: a */
    public static long m19029a(C3537r rVar) {
        return m19030a(rVar.mo19502a("Content-Length"));
    }

    /* renamed from: b */
    public static boolean m19035b(C3480a0 a0Var) {
        if (a0Var.mo19281b0().mo19605e().equals("HEAD")) {
            return false;
        }
        int v = a0Var.mo19288v();
        if (((v >= 100 && v < 200) || v == 204 || v == 304) && m19028a(a0Var) == -1 && !"chunked".equalsIgnoreCase(a0Var.mo19278a("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static Set<String> m19037c(C3537r rVar) {
        Set<String> emptySet = Collections.emptySet();
        int b = rVar.mo19503b();
        for (int i = 0; i < b; i++) {
            if ("Vary".equalsIgnoreCase(rVar.mo19501a(i))) {
                String b2 = rVar.mo19504b(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b2.split(",")) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    /* renamed from: a */
    private static long m19030a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static boolean m19033a(C3480a0 a0Var, C3537r rVar, C3548y yVar) {
        for (String next : m19039d(a0Var)) {
            if (!C3500c.m11654a((Object) rVar.mo19505b(next), (Object) yVar.mo19602b(next))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static C3537r m19031a(C3537r rVar, C3537r rVar2) {
        Set<String> c = m19037c(rVar2);
        if (c.isEmpty()) {
            return new C3537r.C3538a().mo19511a();
        }
        C3537r.C3538a aVar = new C3537r.C3538a();
        int b = rVar.mo19503b();
        for (int i = 0; i < b; i++) {
            String a = rVar.mo19501a(i);
            if (c.contains(a)) {
                aVar.mo19510a(a, rVar.mo19504b(i));
            }
        }
        return aVar.mo19511a();
    }

    /* renamed from: b */
    public static int m19034b(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == 9)) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static void m19032a(C5966m mVar, C3539s sVar, C3537r rVar) {
        if (mVar != C5966m.f15252a) {
            List<C3530l> a = C3530l.m11787a(sVar, rVar);
            if (!a.isEmpty()) {
                mVar.mo33780a(sVar, a);
            }
        }
    }

    /* renamed from: a */
    public static int m19027a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m19026a(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
