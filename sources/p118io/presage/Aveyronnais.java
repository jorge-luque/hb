package p118io.presage;

import android.content.Context;

/* renamed from: io.presage.Aveyronnais */
public final class Aveyronnais {

    /* renamed from: a */
    private boolean f16372a;

    /* renamed from: b */
    private final PavedAremberg f16373b;

    /* renamed from: c */
    private final C6238bb f16374c;

    /* renamed from: d */
    private final MoelleuxduRevard f16375d;

    private Aveyronnais(PavedAremberg pavedAremberg, C6238bb bbVar, MoelleuxduRevard moelleuxduRevard) {
        this.f16373b = pavedAremberg;
        this.f16374c = bbVar;
        this.f16375d = moelleuxduRevard;
        this.f16372a = true;
    }

    /* renamed from: b */
    private final void m20203b(PontlEveque pontlEveque) {
        if (pontlEveque.mo34616e().length() > 0) {
            this.f16373b.mo34598b(pontlEveque.mo34616e());
        } else {
            MoelleuxduRevard.m20487a((Mimolette24mois) new Munster("shown", pontlEveque));
        }
        C6238bb.m20878a(new C6237ba(pontlEveque.mo34607b(), "impression"));
    }

    /* renamed from: a */
    public final void mo34451a(PontlEveque pontlEveque) {
        if (this.f16372a && pontlEveque != null) {
            this.f16372a = false;
            m20203b(pontlEveque);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Aveyronnais(Context context) {
        this(PersilledumontBlanc.m20539a(context), C6238bb.f16782a, MoelleuxduRevard.f16573a);
        PersilledumontBlanc persilledumontBlanc = PersilledumontBlanc.f16609a;
    }
}
