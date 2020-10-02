package p118io.presage;

import java.util.Arrays;

/* renamed from: io.presage.PlaisirauChablis */
public final class PlaisirauChablis {

    /* renamed from: a */
    public static final PlaisirauChablis f16632a = new PlaisirauChablis();

    /* renamed from: b */
    private static String f16633b = "https://%s-%s.presage.io/%s";

    private PlaisirauChablis() {
    }

    /* renamed from: a */
    public static String m20562a() {
        return m20563a("ad_sync", "sy", "v1");
    }

    /* renamed from: b */
    public static String m20565b() {
        return m20563a("pl", "pl", "v2");
    }

    /* renamed from: c */
    public static String m20566c() {
        return m20563a("track", "tr", "v1");
    }

    /* renamed from: d */
    public static String m20567d() {
        return m20563a("ad_history", "ah", "v1");
    }

    /* renamed from: a */
    public static String m20564a(boolean z) {
        String a = m20563a("p", "pad", "v3");
        return z ? C6561je.m21508a(a, "https://", "http://") : a;
    }

    /* renamed from: a */
    private static String m20563a(String str, String str2, String str3) {
        C6518hp hpVar = C6518hp.f17054a;
        String format = String.format(f16633b + '/' + str, Arrays.copyOf(new Object[]{str2, str3, str3}, 3));
        C6514hl.m21414a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }
}
