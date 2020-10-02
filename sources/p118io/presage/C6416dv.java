package p118io.presage;

import android.util.Log;

/* renamed from: io.presage.dv */
public final class C6416dv {

    /* renamed from: a */
    public static final C6416dv f17002a = new C6416dv();

    /* renamed from: b */
    private static boolean f17003b;

    private C6416dv() {
    }

    /* renamed from: a */
    public static void m21284a(Throwable th) {
        if (f17003b) {
            Log.e("omid", "caught_error", th);
        }
    }
}
