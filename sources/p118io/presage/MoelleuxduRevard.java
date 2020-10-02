package p118io.presage;

import android.content.Context;
import p118io.presage.Montbriac;

/* renamed from: io.presage.MoelleuxduRevard */
public final class MoelleuxduRevard {

    /* renamed from: a */
    public static final MoelleuxduRevard f16573a = new MoelleuxduRevard();

    /* renamed from: b */
    private static Montbriac f16574b;

    private MoelleuxduRevard() {
    }

    /* renamed from: a */
    public static void m20486a(Context context) {
        if (f16574b == null) {
            Montbriac.CamembertauCalvados camembertauCalvados = Montbriac.f16575a;
            f16574b = Montbriac.CamembertauCalvados.m20506a(context);
        }
    }

    /* renamed from: a */
    public static void m20487a(Mimolette24mois mimolette24mois) {
        Montbriac montbriac = f16574b;
        if (montbriac != null) {
            montbriac.mo34584a(mimolette24mois);
        }
    }
}
