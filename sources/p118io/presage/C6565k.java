package p118io.presage;

import android.content.Context;
import p118io.presage.C6502h;

/* renamed from: io.presage.k */
public final class C6565k {

    /* renamed from: a */
    public static final C6565k f17116a = new C6565k();

    /* renamed from: b */
    private static C6556j f17117b;

    private C6565k() {
    }

    /* renamed from: a */
    public static void m21539a(C6556j jVar) {
        f17117b = jVar;
    }

    /* renamed from: b */
    public static void m21540b(Context context) throws Salers {
        TommedAuvergne.f16707a.mo34711a(context).m20730b(false);
    }

    /* renamed from: a */
    public static C6556j m21538a(Context context) {
        if (f17117b == null) {
            C6502h.CamembertauCalvados camembertauCalvados = C6502h.f17033a;
            String d = C6502h.CamembertauCalvados.m21397a(context).mo35505d();
            C6566l lVar = C6566l.f17118a;
            f17117b = C6566l.m21541a(d);
        }
        return f17117b;
    }
}
