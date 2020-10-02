package p118io.presage;

import admost.sdk.AdMostInterstitial;
import com.tapjoy.TJAdUnitConstants;

/* renamed from: io.presage.cw */
public final class C6390cw implements C6392cy {

    /* renamed from: a */
    private final Taleggio f16956a;

    /* renamed from: b */
    private final C6392cy f16957b;

    /* renamed from: c */
    private final PontlEveque f16958c;

    public C6390cw(Taleggio taleggio, C6392cy cyVar, PontlEveque pontlEveque) {
        this.f16956a = taleggio;
        this.f16957b = cyVar;
        this.f16958c = pontlEveque;
    }

    /* renamed from: a */
    public final void mo35329a(C6233ax axVar) {
        C6396db c = axVar.mo34768c();
        int a = C6215af.m20775a(c.getWidth());
        int a2 = C6215af.m20775a(c.getHeight());
        int a3 = C6215af.m20774a(c.getX());
        int a4 = C6215af.m20774a(c.getY());
        this.f16957b.mo35329a(axVar);
        axVar.mo34758a(SaintNectaire.m20661a(this.f16958c) ? AdMostInterstitial.ZONE_TYPE_INTERSTITIAL : TJAdUnitConstants.String.INLINE);
        axVar.mo34761a(false);
        axVar.mo34754a(this.f16956a.mo34699l());
        axVar.mo34753a();
        axVar.mo34756a(a, a2, a3, a4);
        axVar.mo34765b(a, a2, a3, a4);
        axVar.mo34770c(a, a2, a3, a4);
        axVar.mo34769c(a, a2);
        axVar.mo34766b("default");
    }
}
