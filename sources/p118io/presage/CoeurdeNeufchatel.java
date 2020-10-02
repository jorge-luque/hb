package p118io.presage;

import android.app.Activity;
import android.content.Context;
import p118io.presage.DelicedesFiouves;

/* renamed from: io.presage.CoeurdeNeufchatel */
public final class CoeurdeNeufchatel {

    /* renamed from: a */
    private final CremeuxduJura f16477a;

    /* renamed from: b */
    private final EtivazGruyereSuisse f16478b;

    /* renamed from: c */
    private final FourmedAmbert f16479c;

    /* renamed from: d */
    private final C6565k f16480d;

    private CoeurdeNeufchatel(CremeuxduJura cremeuxduJura, EtivazGruyereSuisse etivazGruyereSuisse, FourmedAmbert fourmedAmbert, C6565k kVar) {
        this.f16477a = cremeuxduJura;
        this.f16478b = etivazGruyereSuisse;
        this.f16479c = fourmedAmbert;
        this.f16480d = kVar;
    }

    /* renamed from: a */
    public final CoeurdArras mo34532a(Activity activity, CamembertdeNormandie camembertdeNormandie, AbbayedeCiteauxentiere abbayedeCiteauxentiere) {
        C6421e eVar;
        C6475g gVar;
        Chaource chaource = new Chaource(camembertdeNormandie, abbayedeCiteauxentiere);
        C6556j a = C6565k.m21538a((Context) activity);
        if (a == null || (eVar = a.mo35595p()) == null) {
            eVar = new C6421e();
        }
        if (a == null || (gVar = a.mo35596q()) == null) {
            gVar = new C6475g();
        }
        new CapGrisNez();
        CarreMirabelle a2 = CapGrisNez.m20296a(activity, this.f16477a, eVar);
        DelicedesFiouves.CamembertauCalvados camembertauCalvados = DelicedesFiouves.f16485a;
        DelicedesFiouves a3 = DelicedesFiouves.CamembertauCalvados.m20349a(activity, gVar, this.f16478b);
        if (this.f16478b.mo34552c() || !gVar.mo35496a()) {
            return new CarreNormand(activity, chaource, a2);
        }
        if (FourmedAmbert.m20379a()) {
            return new EmmentalGrandCru(activity, chaource, new Entrammes(a3), (C6219aj) null, 8, (C6511hi) null);
        } else if (FourmedAmbert.m20381b()) {
            return new EpoissesdeBourgogne(activity, chaource, new Entrammes(a3), (C6219aj) null, 8, (C6511hi) null);
        } else {
            C6578x xVar = C6578x.f17137a;
            C6578x.m21579a("Fragment filter defined for thumbnail but no fragment dependency found. Only androidx and support v4 fragments are supported");
            return new CarreNormand(activity, chaource, a2);
        }
    }

    public /* synthetic */ CoeurdeNeufchatel(CremeuxduJura cremeuxduJura, EtivazGruyereSuisse etivazGruyereSuisse) {
        this(cremeuxduJura, etivazGruyereSuisse, FourmedAmbert.f16509a, C6565k.f17116a);
    }
}
