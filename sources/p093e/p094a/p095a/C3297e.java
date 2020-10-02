package p093e.p094a.p095a;

import android.content.Context;

/* renamed from: e.a.a.e */
/* compiled from: Adjust */
public class C3297e {

    /* renamed from: a */
    private static C3311l f9174a;

    /* renamed from: a */
    public static void m10956a(C3301g gVar) {
        m10959b().mo19036a(gVar);
    }

    /* renamed from: b */
    public static synchronized C3311l m10959b() {
        C3311l lVar;
        synchronized (C3297e.class) {
            if (f9174a == null) {
                f9174a = new C3311l();
            }
            lVar = f9174a;
        }
        return lVar;
    }

    /* renamed from: c */
    public static boolean m10960c() {
        return m10959b().mo19040b();
    }

    /* renamed from: d */
    public static void m10961d() {
        m10959b().mo19041c();
    }

    /* renamed from: e */
    public static void m10962e() {
        m10959b().mo19042d();
    }

    /* renamed from: a */
    public static void m10957a(C3303h hVar) {
        m10959b().mo19037a(hVar);
    }

    /* renamed from: a */
    public static void m10958a(String str, Context context) {
        m10959b().mo19039b(str, context);
    }

    /* renamed from: a */
    public static String m10955a() {
        return m10959b().mo19035a();
    }
}
