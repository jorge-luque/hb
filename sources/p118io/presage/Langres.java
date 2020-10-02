package p118io.presage;

/* renamed from: io.presage.Langres */
public final class Langres {

    /* renamed from: a */
    public static final Langres f16542a = new Langres();

    /* renamed from: b */
    private static int f16543b = -1;

    private Langres() {
    }

    /* renamed from: a */
    public static int m20427a() {
        if (f16543b == -1) {
            f16543b = m20429b();
        }
        return f16543b;
    }

    /* renamed from: b */
    private static int m20429b() {
        if (m20430c()) {
            return 1;
        }
        if (m20431d()) {
            return 2;
        }
        if (m20433f()) {
            return 3;
        }
        return m20432e() ? 4 : 0;
    }

    /* renamed from: c */
    private static boolean m20430c() {
        return m20428a("com.unity3d.player.UnityPlayer");
    }

    /* renamed from: d */
    private static boolean m20431d() {
        return m20428a("org.apache.cordova.CordovaWebView");
    }

    /* renamed from: e */
    private static boolean m20432e() {
        return m20428a("com.adobe.fre.FREFunction");
    }

    /* renamed from: f */
    private static boolean m20433f() {
        return m20428a("mono.android.Runtime");
    }

    /* renamed from: a */
    private static boolean m20428a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
