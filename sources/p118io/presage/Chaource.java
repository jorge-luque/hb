package p118io.presage;

import android.app.Activity;

/* renamed from: io.presage.Chaource */
public final class Chaource {

    /* renamed from: a */
    private final CamembertdeNormandie f16462a;

    /* renamed from: b */
    private final AbbayedeCiteauxentiere f16463b;

    /* renamed from: c */
    private final AffideliceauChablis f16464c;

    private Chaource(CamembertdeNormandie camembertdeNormandie, AbbayedeCiteauxentiere abbayedeCiteauxentiere, AffideliceauChablis affideliceauChablis) {
        this.f16462a = camembertdeNormandie;
        this.f16463b = abbayedeCiteauxentiere;
        this.f16464c = affideliceauChablis;
    }

    /* renamed from: b */
    private final void m20321b(Activity activity) {
        if (activity.hasWindowFocus()) {
            this.f16463b.mo34396m();
        } else {
            this.f16463b.mo34395l();
        }
    }

    /* renamed from: a */
    public final void mo34523a(Activity activity) {
        if (AffideliceauChablis.m20201c() && this.f16462a.getParent() == null && this.f16463b.mo34390g()) {
            AffideliceauChablis.m20197a(true);
            CamembertdeNormandie camembertdeNormandie = this.f16462a;
            activity.addContentView(camembertdeNormandie, camembertdeNormandie.getLayoutParams());
            m20321b(activity);
        }
    }

    public /* synthetic */ Chaource(CamembertdeNormandie camembertdeNormandie, AbbayedeCiteauxentiere abbayedeCiteauxentiere) {
        this(camembertdeNormandie, abbayedeCiteauxentiere, AffideliceauChablis.f16369a);
    }

    /* renamed from: a */
    public final void mo34522a() {
        if (this.f16462a.getParent() != null && !this.f16463b.mo34401r()) {
            this.f16463b.mo34395l();
            this.f16462a.mo34472a();
        }
    }
}
