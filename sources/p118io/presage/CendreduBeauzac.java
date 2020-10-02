package p118io.presage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import java.util.ArrayList;
import java.util.List;

/* renamed from: io.presage.CendreduBeauzac */
public final class CendreduBeauzac {

    /* renamed from: a */
    private AbbayedeCiteauxentiere f16451a;

    /* renamed from: b */
    private C6388cu f16452b;

    /* renamed from: c */
    private Activity f16453c;

    /* renamed from: d */
    private final Application f16454d;

    /* renamed from: e */
    private final CoeurdeNeufchatel f16455e;

    /* renamed from: f */
    private final BleudeGex f16456f;

    /* renamed from: g */
    private CoeurdArras f16457g;

    /* renamed from: h */
    private CamembertdeNormandie f16458h;

    /* renamed from: i */
    private final Comte18mois f16459i;

    /* renamed from: io.presage.CendreduBeauzac$CamembertauCalvados */
    public static final class CamembertauCalvados implements Bethmale {

        /* renamed from: a */
        final /* synthetic */ CendreduBeauzac f16460a;

        CamembertauCalvados(CendreduBeauzac cendreduBeauzac) {
            this.f16460a = cendreduBeauzac;
        }

        /* renamed from: a */
        public final void mo34454a(CamembertdeNormandie camembertdeNormandie, AbbayedeCiteauxentiere abbayedeCiteauxentiere) {
            this.f16460a.mo34518a();
        }
    }

    /* renamed from: io.presage.CendreduBeauzac$CamembertdeNormandie */
    static final /* synthetic */ class CamembertdeNormandie extends C6513hk implements C6493gr<PontlEveque, List<PontlEveque>, C6437ep> {
        CamembertdeNormandie(CendreduBeauzac cendreduBeauzac) {
            super(2, cendreduBeauzac);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ Object mo34520a(Object obj, Object obj2) {
            m20315a((PontlEveque) obj, (List<PontlEveque>) (List) obj2);
            return C6437ep.f17017a;
        }

        /* renamed from: b */
        public final C6536ig mo34406b() {
            return C6516hn.m21418a(CendreduBeauzac.class);
        }

        /* renamed from: c */
        public final String mo34407c() {
            return "showNextAd";
        }

        /* renamed from: d */
        public final String mo34408d() {
            return "showNextAd(Lio/presage/common/network/models/Ad;Ljava/util/List;)V";
        }

        /* renamed from: a */
        private void m20315a(PontlEveque pontlEveque, List<PontlEveque> list) {
            ((CendreduBeauzac) this.f17039a).m20309a(pontlEveque, list);
        }
    }

    private CendreduBeauzac(Application application, CoeurdeNeufchatel coeurdeNeufchatel, BleudeGex bleudeGex, CamembertdeNormandie camembertdeNormandie, Comte18mois comte18mois) {
        this.f16454d = application;
        this.f16455e = coeurdeNeufchatel;
        this.f16456f = bleudeGex;
        this.f16457g = null;
        this.f16458h = camembertdeNormandie;
        this.f16459i = comte18mois;
        this.f16452b = new C6388cu((byte) 0);
        this.f16458h.setContainsOverlayAd(true);
        this.f16451a = m20311b();
    }

    /* renamed from: b */
    private final AbbayedeCiteauxentiere m20311b() {
        AbbayedeCiteauxentiere a = this.f16459i.mo34533a(this.f16454d, this.f16458h);
        a.mo34378a((Bethmale) new BleudesCausses());
        a.mo34384b((Bethmale) new CamembertauCalvados(this));
        a.mo34379a((Bofavre) new CureNantais(new CamembertdeNormandie(this)));
        return a;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: a */
    public final void mo34519a(Activity activity, int i, int i2, List<PontlEveque> list) {
        this.f16453c = activity;
        try {
            PontlEveque remove = list.remove(0);
            FourmedAmbertBio.m20383a(list);
            this.f16452b.mo35321c(C6215af.m20776b(i));
            this.f16452b.mo35323d(C6215af.m20776b(i2));
            this.f16451a.mo34377a(C6215af.m20776b(i), C6215af.m20776b(i2));
            if (remove.mo34646v()) {
                this.f16456f.mo34455a(this.f16454d, remove, new ArrayList());
                if (!list.isEmpty()) {
                    m20310a(list.remove(0), list, activity, false);
                    return;
                }
                return;
            }
            m20310a(remove, list, activity, true);
        } catch (Throwable unused) {
            mo34518a();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CendreduBeauzac(android.app.Application r7, p118io.presage.CoeurdeNeufchatel r8, p118io.presage.BleudeGex r9) {
        /*
            r6 = this;
            io.presage.CamembertdeNormandie r4 = new io.presage.CamembertdeNormandie
            android.content.Context r0 = r7.getApplicationContext()
            java.lang.String r1 = "application.applicationContext"
            p118io.presage.C6514hl.m21414a((java.lang.Object) r0, (java.lang.String) r1)
            r4.<init>(r0)
            io.presage.Comte18mois r5 = new io.presage.Comte18mois
            r5.<init>(r9)
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.CendreduBeauzac.<init>(android.app.Application, io.presage.CoeurdeNeufchatel, io.presage.BleudeGex):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20309a(PontlEveque pontlEveque, List<PontlEveque> list) {
        Activity activity = this.f16453c;
        if (activity != null) {
            CamembertdeNormandie camembertdeNormandie = new CamembertdeNormandie(this.f16454d);
            this.f16458h = camembertdeNormandie;
            camembertdeNormandie.setContainsOverlayAd(true);
            AbbayedeCiteauxentiere b = m20311b();
            this.f16451a = b;
            b.mo34377a(this.f16452b.mo35324e(), this.f16452b.mo35326f());
            m20310a(pontlEveque, list, activity, true);
        }
    }

    /* renamed from: a */
    private final void m20310a(PontlEveque pontlEveque, List<PontlEveque> list, Activity activity, boolean z) {
        CoeurdArras coeurdArras;
        CoeurdArras coeurdArras2 = this.f16457g;
        if (coeurdArras2 != null) {
            coeurdArras2.unregisterLifecycleListener();
        }
        this.f16457g = this.f16455e.mo34532a(activity, this.f16458h, this.f16451a);
        this.f16451a.mo34380a(pontlEveque, list);
        if (z && (coeurdArras = this.f16457g) != null) {
            coeurdArras.injectInitialOverlay();
        }
        CoeurdArras coeurdArras3 = this.f16457g;
        if (coeurdArras3 != null) {
            coeurdArras3.registerLifecycleListener();
        }
    }

    /* renamed from: a */
    public final void mo34518a() {
        CoeurdArras coeurdArras = this.f16457g;
        if (coeurdArras != null) {
            coeurdArras.unregisterLifecycleListener();
        }
        this.f16458h.mo34472a();
        this.f16451a.mo34391h();
    }
}
