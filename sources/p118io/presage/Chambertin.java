package p118io.presage;

import android.app.Application;

/* renamed from: io.presage.Chambertin */
public final class Chambertin {

    /* renamed from: a */
    private final BleudeGex f16461a;

    public Chambertin(BleudeGex bleudeGex) {
        this.f16461a = bleudeGex;
    }

    /* renamed from: a */
    public final CendreduBeauzac mo34521a(Application application, CremeuxduJura cremeuxduJura, EtivazGruyereSuisse etivazGruyereSuisse) {
        return new CendreduBeauzac(application, new CoeurdeNeufchatel(cremeuxduJura, etivazGruyereSuisse), this.f16461a);
    }
}
