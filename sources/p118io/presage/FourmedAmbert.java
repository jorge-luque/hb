package p118io.presage;

/* renamed from: io.presage.FourmedAmbert */
public final class FourmedAmbert {

    /* renamed from: a */
    public static final FourmedAmbert f16509a = new FourmedAmbert();

    private FourmedAmbert() {
    }

    /* renamed from: a */
    public static boolean m20379a() {
        return m20380a("androidx.fragment.app.Fragment");
    }

    /* renamed from: b */
    public static boolean m20381b() {
        return m20380a("androidx.fragment.app.Fragment");
    }

    /* renamed from: a */
    private static boolean m20380a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
