package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p118io.presage.C6502h;

/* renamed from: io.presage.TommedAuvergne */
public final class TommedAuvergne {

    /* renamed from: a */
    public static final CamembertauCalvados f16707a = new CamembertauCalvados((byte) 0);
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: m */
    public static TommedAuvergne f16708m;

    /* renamed from: b */
    private boolean f16709b;

    /* renamed from: c */
    private long f16710c;

    /* renamed from: d */
    private C6263c f16711d;

    /* renamed from: e */
    private final Context f16712e;

    /* renamed from: f */
    private final C6502h f16713f;

    /* renamed from: g */
    private final TommedeSavoie f16714g;

    /* renamed from: h */
    private final TommeMarcdeRaisin f16715h;

    /* renamed from: i */
    private final PavedAremberg f16716i;

    /* renamed from: j */
    private final C6571q f16717j;

    /* renamed from: k */
    private final C6579y f16718k;

    /* renamed from: l */
    private final OlivetalaSauge f16719l;

    /* renamed from: io.presage.TommedAuvergne$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: b */
        private static TommedAuvergne m20734b(Context context) {
            C6502h.CamembertauCalvados camembertauCalvados = C6502h.f17033a;
            C6502h a = C6502h.CamembertauCalvados.m21397a(context);
            TommedeSavoie tommedeSavoie = new TommedeSavoie(new Taleggio(context), new TetedeMoine(context));
            PersilledumontBlanc persilledumontBlanc = PersilledumontBlanc.f16609a;
            return new TommedAuvergne(context, a, tommedeSavoie, TommeMarcdeRaisin.f16705a, PersilledumontBlanc.m20539a(context), C6573s.f17133a, new C6580z(), new OlivetalaSauge(), (byte) 0);
        }

        /* renamed from: a */
        public final TommedAuvergne mo34711a(Context context) {
            TommedAuvergne a;
            C6218ai.m20781a("Profig.getInstance");
            synchronized (this) {
                if (TommedAuvergne.f16708m == null) {
                    CamembertauCalvados camembertauCalvados = TommedAuvergne.f16707a;
                    Context applicationContext = context.getApplicationContext();
                    C6514hl.m21414a((Object) applicationContext, "context.applicationContext");
                    TommedAuvergne.f16708m = m20734b(applicationContext);
                }
                a = TommedAuvergne.f16708m;
                if (a == null) {
                    C6514hl.m21413a();
                }
            }
            return a;
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private TommedAuvergne(Context context, C6502h hVar, TommedeSavoie tommedeSavoie, TommeMarcdeRaisin tommeMarcdeRaisin, PavedAremberg pavedAremberg, C6571q qVar, C6579y yVar, OlivetalaSauge olivetalaSauge) {
        this.f16712e = context;
        this.f16713f = hVar;
        this.f16714g = tommedeSavoie;
        this.f16715h = tommeMarcdeRaisin;
        this.f16716i = pavedAremberg;
        this.f16717j = qVar;
        this.f16718k = yVar;
        this.f16719l = olivetalaSauge;
        this.f16710c = TimeUnit.SECONDS.toMillis(7200);
        this.f16711d = TommeMarcdeRaisin.m20712a(this.f16712e);
    }

    /* renamed from: c */
    private final boolean m20731c() {
        return this.f16713f.mo35509f() != System.currentTimeMillis() / TimeUnit.DAYS.toMillis(1);
    }

    /* renamed from: d */
    private final void m20732d() {
        this.f16713f.mo35498a(this.f16713f.mo35497a() + 1);
    }

    /* renamed from: e */
    private final void m20733e() {
        this.f16713f.mo35506d(C6221al.m20787a());
    }

    /* renamed from: a */
    private final TommeduJura m20720a(boolean z) {
        this.f16711d = TommeMarcdeRaisin.m20712a(this.f16712e);
        return new TommeduJura(this.f16714g, this.f16711d, this.f16713f, z);
    }

    /* renamed from: b */
    private final void m20728b() {
        if (m20731c()) {
            this.f16713f.mo35498a(0);
            this.f16713f.mo35507e();
        }
    }

    public /* synthetic */ TommedAuvergne(Context context, C6502h hVar, TommedeSavoie tommedeSavoie, TommeMarcdeRaisin tommeMarcdeRaisin, PavedAremberg pavedAremberg, C6571q qVar, C6579y yVar, OlivetalaSauge olivetalaSauge, byte b) {
        this(context, hVar, tommedeSavoie, tommeMarcdeRaisin, pavedAremberg, qVar, yVar, olivetalaSauge);
    }

    /* renamed from: a */
    private final void m20722a(TommedeYenne tommedeYenne) {
        new StringBuilder("making profig api call ").append(tommedeYenne);
        try {
            C6412dr a = this.f16716i.mo34596a(tommedeYenne.mo34715c());
            if (a instanceof C6413ds) {
                JSONObject jSONObject = new JSONObject(((C6413ds) a).mo35377a());
                OlivetalaSauge.m20523a(jSONObject);
                m20724a(tommedeYenne, jSONObject);
            } else if (a instanceof C6403di) {
                m20726a(((C6403di) a).mo35368a());
            }
        } catch (Exception e) {
            m20726a((Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20730b(boolean z) throws Salers {
        if (!this.f16709b || z) {
            this.f16709b = true;
            m20728b();
            TommeduJura a = m20720a(z);
            TommedeYenne b = a.mo34722b();
            StringBuilder sb = new StringBuilder("Profig - profigRequest ");
            sb.append(z);
            sb.append(' ');
            sb.append(b);
            C6556j a2 = a.mo34721a();
            if (a2 != null) {
                this.f16710c = a2.mo35580e();
            }
            if (!this.f16718k.mo35605a(this.f16712e)) {
                this.f16717j.mo35604a(this.f16712e, this.f16710c);
                this.f16709b = false;
                return;
            }
            if (b.mo34716d()) {
                this.f16717j.mo35604a(this.f16712e, b.mo34714b());
            } else {
                this.f16717j.mo35603a(this.f16712e);
            }
            if (b.mo34713a()) {
                m20722a(b);
            }
            this.f16709b = false;
        }
    }

    /* renamed from: a */
    private final void m20726a(Throwable th) {
        if (C6218ai.m20782a(th)) {
            m20732d();
            m20733e();
        }
        if (th instanceof Salers) {
            throw th;
        }
    }

    /* renamed from: a */
    private final void m20724a(TommedeYenne tommedeYenne, JSONObject jSONObject) {
        m20732d();
        m20733e();
        m20725a(tommedeYenne.mo34717e());
        this.f16713f.mo35502b(this.f16711d.mo34854a());
        this.f16713f.mo35499a(System.currentTimeMillis());
        C6566l lVar = C6566l.f17118a;
        m20723a(tommedeYenne, C6566l.m21542a(jSONObject), jSONObject);
    }

    /* renamed from: a */
    private final void m20725a(String str) {
        if (str != null) {
            this.f16713f.mo35500a(str);
        }
    }

    /* renamed from: a */
    private final void m20723a(TommedeYenne tommedeYenne, C6568n nVar, JSONObject jSONObject) {
        if (nVar instanceof C6556j) {
            C6565k kVar = C6565k.f17116a;
            C6556j jVar = (C6556j) nVar;
            C6565k.m21539a(jVar);
            C6502h hVar = this.f16713f;
            String jSONObject2 = jSONObject.toString();
            C6514hl.m21414a((Object) jSONObject2, "profigJsonResponse.toString()");
            hVar.mo35504c(jSONObject2);
            m20727a(jVar.mo35568a(), jVar.mo35585g());
        } else if (nVar instanceof C6394d) {
            m20730b(true);
        } else if (nVar instanceof C6529i) {
            m20727a(tommedeYenne.mo34716d(), tommedeYenne.mo34714b());
        }
    }

    /* renamed from: a */
    private final void m20727a(boolean z, long j) {
        if (z) {
            this.f16717j.mo35604a(this.f16712e, j);
        } else {
            this.f16717j.mo35603a(this.f16712e);
        }
    }
}
