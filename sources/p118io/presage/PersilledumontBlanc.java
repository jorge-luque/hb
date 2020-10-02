package p118io.presage;

import android.content.Context;
import p118io.presage.ParmigianoReggiano;

/* renamed from: io.presage.PersilledumontBlanc */
public final class PersilledumontBlanc {

    /* renamed from: a */
    public static final PersilledumontBlanc f16609a = new PersilledumontBlanc();

    /* renamed from: b */
    private static PavedAremberg f16610b;

    private PersilledumontBlanc() {
    }

    /* renamed from: a */
    public static PavedAremberg m20539a(Context context) {
        if (f16610b == null) {
            Context applicationContext = context.getApplicationContext();
            ParmigianoReggiano.CamembertauCalvados camembertauCalvados = ParmigianoReggiano.f16605a;
            C6514hl.m21414a((Object) applicationContext, "appContext");
            f16610b = new PetitMorin(ParmigianoReggiano.CamembertauCalvados.m20529a(applicationContext), new TetedeMoine(applicationContext), new Taleggio(applicationContext), new C6409do(new OlivetCendre(C6565k.f17116a, applicationContext, C6567m.m21549a(3))));
        }
        PavedAremberg pavedAremberg = f16610b;
        if (pavedAremberg == null) {
            C6514hl.m21413a();
        }
        return pavedAremberg;
    }
}
