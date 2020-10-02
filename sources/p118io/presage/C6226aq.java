package p118io.presage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import java.util.List;
import p118io.presage.interstitial.p207ui.InterstitialActivity;

/* renamed from: io.presage.aq */
public final class C6226aq {

    /* renamed from: a */
    private CamembertdeNormandie f16753a;

    /* renamed from: b */
    private AbbayedeCiteauxentiere f16754b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final InterstitialActivity f16755c;

    /* renamed from: d */
    private final Intent f16756d;

    /* renamed from: e */
    private final PontlEveque f16757e;

    /* renamed from: f */
    private final List<PontlEveque> f16758f;

    /* renamed from: g */
    private final C6225ap f16759g;

    /* renamed from: h */
    private final Bouyssou f16760h;

    /* renamed from: io.presage.aq$CamembertauCalvados */
    public static final class CamembertauCalvados implements Bethmale {

        /* renamed from: a */
        final /* synthetic */ C6226aq f16761a;

        /* renamed from: b */
        final /* synthetic */ Bethmale f16762b;

        CamembertauCalvados(C6226aq aqVar, Bethmale bethmale) {
            this.f16761a = aqVar;
            this.f16762b = bethmale;
        }

        /* renamed from: a */
        public final void mo34454a(CamembertdeNormandie camembertdeNormandie, AbbayedeCiteauxentiere abbayedeCiteauxentiere) {
            Bethmale bethmale = this.f16762b;
            if (bethmale != null) {
                bethmale.mo34454a(camembertdeNormandie, abbayedeCiteauxentiere);
            }
            this.f16761a.f16755c.finish();
        }
    }

    /* renamed from: io.presage.aq$CamembertdeNormandie */
    public static final class CamembertdeNormandie implements Bethmale {

        /* renamed from: a */
        final /* synthetic */ C6226aq f16763a;

        CamembertdeNormandie(C6226aq aqVar) {
            this.f16763a = aqVar;
        }

        /* renamed from: a */
        public final void mo34454a(CamembertdeNormandie camembertdeNormandie, AbbayedeCiteauxentiere abbayedeCiteauxentiere) {
            this.f16763a.f16755c.mo35550a(abbayedeCiteauxentiere.mo34387d());
        }
    }

    private C6226aq(InterstitialActivity interstitialActivity, Intent intent, PontlEveque pontlEveque, List<PontlEveque> list, C6225ap apVar, Bouyssou bouyssou) {
        this.f16755c = interstitialActivity;
        this.f16756d = intent;
        this.f16757e = pontlEveque;
        this.f16758f = list;
        this.f16759g = apVar;
        this.f16760h = bouyssou;
        int intExtra = intent.getIntExtra("mode", 0);
        if (intExtra == 0) {
            m20806c();
        } else if (intExtra == 1) {
            m20807d();
        } else {
            throw new IllegalStateException("Wrong mode ".concat(String.valueOf(intExtra)));
        }
        m20808e();
        m20809f();
    }

    /* renamed from: c */
    private final void m20806c() {
        Context applicationContext = this.f16755c.getApplicationContext();
        C6514hl.m21414a((Object) applicationContext, "activity.applicationContext");
        CamembertdeNormandie camembertdeNormandie = new CamembertdeNormandie(applicationContext);
        this.f16753a = camembertdeNormandie;
        InterstitialActivity interstitialActivity = this.f16755c;
        if (camembertdeNormandie == null) {
            C6514hl.m21415a("adLayout");
        }
        AbbayedeCiteauxentiere a = C6225ap.m20804a(interstitialActivity, camembertdeNormandie, new BleudAuvergnebio(InterstitialActivity.f17069a));
        this.f16754b = a;
        if (a == null) {
            C6514hl.m21415a("adController");
        }
        a.mo34379a((Bofavre) new C6228as());
        AbbayedeCiteauxentiere abbayedeCiteauxentiere = this.f16754b;
        if (abbayedeCiteauxentiere == null) {
            C6514hl.m21415a("adController");
        }
        Application application = this.f16755c.getApplication();
        C6514hl.m21414a((Object) application, "activity.application");
        abbayedeCiteauxentiere.mo34378a((Bethmale) new BleudeLaqueuille(new VacherinSuisse(application), this.f16755c, new BleudAuvergne()));
        AbbayedeCiteauxentiere abbayedeCiteauxentiere2 = this.f16754b;
        if (abbayedeCiteauxentiere2 == null) {
            C6514hl.m21415a("adController");
        }
        abbayedeCiteauxentiere2.mo34380a(this.f16757e, this.f16758f);
    }

    /* renamed from: d */
    private final void m20807d() {
        VacherinSuisse vacherinSuisse;
        String stringExtra = this.f16756d.getStringExtra("expand_cache_item_id");
        C6514hl.m21414a((Object) stringExtra, "expandCacheItemId");
        BoulettedAvesnes a = Bouyssou.m20219a(stringExtra);
        if (a != null) {
            this.f16753a = a.mo34458a();
            this.f16754b = a.mo34459b();
            if (SaintNectaire.m20661a(this.f16757e)) {
                Application application = this.f16755c.getApplication();
                C6514hl.m21414a((Object) application, "activity.application");
                vacherinSuisse = new VacherinSuisse(application);
            } else {
                vacherinSuisse = null;
            }
            AbbayedeCiteauxentiere abbayedeCiteauxentiere = this.f16754b;
            if (abbayedeCiteauxentiere == null) {
                C6514hl.m21415a("adController");
            }
            InterstitialActivity interstitialActivity = this.f16755c;
            AbbayedeCiteauxentiere abbayedeCiteauxentiere2 = this.f16754b;
            if (abbayedeCiteauxentiere2 == null) {
                C6514hl.m21415a("adController");
            }
            abbayedeCiteauxentiere.mo34378a((Bethmale) new BleudeLaqueuille(vacherinSuisse, interstitialActivity, abbayedeCiteauxentiere2.mo34383b()));
            return;
        }
        throw new IllegalStateException("Cache Item not found");
    }

    /* renamed from: e */
    private final void m20808e() {
        AbbayedeCiteauxentiere abbayedeCiteauxentiere = this.f16754b;
        if (abbayedeCiteauxentiere == null) {
            C6514hl.m21415a("adController");
        }
        abbayedeCiteauxentiere.mo34386c((Bethmale) new CamembertdeNormandie(this));
    }

    /* renamed from: f */
    private final void m20809f() {
        Bethmale bethmale;
        if (!SaintNectaire.m20661a(this.f16757e)) {
            AbbayedeCiteauxentiere abbayedeCiteauxentiere = this.f16754b;
            if (abbayedeCiteauxentiere == null) {
                C6514hl.m21415a("adController");
            }
            bethmale = abbayedeCiteauxentiere.mo34383b();
        } else {
            bethmale = null;
        }
        AbbayedeCiteauxentiere abbayedeCiteauxentiere2 = this.f16754b;
        if (abbayedeCiteauxentiere2 == null) {
            C6514hl.m21415a("adController");
        }
        abbayedeCiteauxentiere2.mo34384b((Bethmale) new CamembertauCalvados(this, bethmale));
    }

    /* renamed from: b */
    public final AbbayedeCiteauxentiere mo34743b() {
        AbbayedeCiteauxentiere abbayedeCiteauxentiere = this.f16754b;
        if (abbayedeCiteauxentiere == null) {
            C6514hl.m21415a("adController");
        }
        return abbayedeCiteauxentiere;
    }

    /* renamed from: a */
    public final CamembertdeNormandie mo34742a() {
        CamembertdeNormandie camembertdeNormandie = this.f16753a;
        if (camembertdeNormandie == null) {
            C6514hl.m21415a("adLayout");
        }
        return camembertdeNormandie;
    }

    public /* synthetic */ C6226aq(InterstitialActivity interstitialActivity, Intent intent, PontlEveque pontlEveque, List list) {
        this(interstitialActivity, intent, pontlEveque, list, C6225ap.f16752a, Bouyssou.f16387a);
    }
}
