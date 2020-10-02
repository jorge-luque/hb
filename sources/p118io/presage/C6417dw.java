package p118io.presage;

import android.content.Context;
import com.iab.omid.library.oguryco.Omid;

/* renamed from: io.presage.dw */
public final class C6417dw {

    /* renamed from: a */
    public static final C6417dw f17004a = new C6417dw();

    private C6417dw() {
    }

    /* renamed from: a */
    public static void m21285a(Context context) {
        try {
            Omid.activate(context.getApplicationContext());
        } catch (IllegalArgumentException e) {
            C6416dv dvVar = C6416dv.f17002a;
            C6416dv.m21284a(e);
        }
    }

    /* renamed from: b */
    public static C6418dx m21287b() {
        return new C6418dx();
    }

    /* renamed from: a */
    public static boolean m21286a() {
        return Omid.isActive();
    }
}
