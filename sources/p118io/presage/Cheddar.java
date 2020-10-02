package p118io.presage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.util.List;
import p118io.presage.common.AdConfig;
import p118io.presage.interstitial.p207ui.InterstitialActivity;

/* renamed from: io.presage.Cheddar */
public final class Cheddar {

    /* renamed from: a */
    private EcirdelAubrac f16465a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CendreduBeauzac f16466b;

    /* renamed from: c */
    private AbbayedeTimadeuc f16467c;

    /* renamed from: d */
    private final Context f16468d;

    /* renamed from: e */
    private final Chambertin f16469e;

    /* renamed from: f */
    private final AbbayeduMontdesCats f16470f;

    /* renamed from: g */
    private final CremeuxduJura f16471g;

    /* renamed from: h */
    private final EtivazGruyereSuisse f16472h;

    /* renamed from: io.presage.Cheddar$CamembertauCalvados */
    public static final class CamembertauCalvados implements Appenzeller {

        /* renamed from: a */
        final /* synthetic */ Cheddar f16473a;

        /* renamed from: b */
        final /* synthetic */ Activity f16474b;

        /* renamed from: c */
        final /* synthetic */ int f16475c;

        /* renamed from: d */
        final /* synthetic */ int f16476d;

        CamembertauCalvados(Cheddar cheddar, Activity activity, int i, int i2) {
            this.f16473a = cheddar;
            this.f16474b = activity;
            this.f16475c = i;
            this.f16476d = i2;
        }

        /* renamed from: a */
        public final void mo34450a(Context context, List<PontlEveque> list) {
            CendreduBeauzac a = this.f16473a.f16466b;
            if (a != null) {
                a.mo34519a(this.f16474b, this.f16475c, this.f16476d, list);
            }
        }
    }

    private Cheddar(Context context, Chambertin chambertin, AbbayeduMontdesCats abbayeduMontdesCats, CremeuxduJura cremeuxduJura, EtivazGruyereSuisse etivazGruyereSuisse) {
        this.f16468d = context;
        this.f16469e = chambertin;
        this.f16470f = abbayeduMontdesCats;
        this.f16471g = cremeuxduJura;
        this.f16472h = etivazGruyereSuisse;
    }

    /* renamed from: b */
    private final void m20326b(int i, int i2) {
        AbbayedeTimadeuc a = this.f16470f.mo34447a();
        this.f16467c = a;
        if (a != null) {
            a.mo34430a(this.f16465a);
        }
        AbbayedeTimadeuc abbayedeTimadeuc = this.f16467c;
        if (abbayedeTimadeuc != null) {
            abbayedeTimadeuc.mo34432a(new Soumaintrain(i, i2));
        }
    }

    private /* synthetic */ Cheddar(Context context, Chambertin chambertin, AbbayeduMontdesCats abbayeduMontdesCats) {
        this(context, chambertin, abbayeduMontdesCats, new CremeuxduJura(), new EtivazGruyereSuisse());
    }

    /* renamed from: a */
    public final boolean mo34529a() {
        AbbayedeTimadeuc abbayedeTimadeuc = this.f16467c;
        if (abbayedeTimadeuc != null) {
            return abbayedeTimadeuc.mo34435a();
        }
        return false;
    }

    /* renamed from: a */
    public final void mo34526a(EcirdelAubrac ecirdelAubrac) {
        this.f16465a = ecirdelAubrac;
        AbbayedeTimadeuc abbayedeTimadeuc = this.f16467c;
        if (abbayedeTimadeuc != null) {
            abbayedeTimadeuc.mo34430a(ecirdelAubrac);
        }
    }

    public Cheddar(Context context, AdConfig adConfig, SableduBoulonnais sableduBoulonnais) {
        this(context, new Chambertin(InterstitialActivity.f17069a), new AbbayeduMontdesCats(context, adConfig, sableduBoulonnais));
    }

    /* renamed from: b */
    private final void m20325b() {
        Chambertin chambertin = this.f16469e;
        Context applicationContext = this.f16468d.getApplicationContext();
        if (applicationContext != null) {
            this.f16466b = chambertin.mo34521a((Application) applicationContext, this.f16471g, this.f16472h);
            return;
        }
        throw new C6434em("null cannot be cast to non-null type android.app.Application");
    }

    /* renamed from: a */
    public final void mo34524a(int i, int i2) {
        AbbayedeTimadeuc abbayedeTimadeuc = this.f16467c;
        if (abbayedeTimadeuc != null && abbayedeTimadeuc.mo34438c()) {
            CendreduBeauzac cendreduBeauzac = this.f16466b;
            if (cendreduBeauzac != null) {
                cendreduBeauzac.mo34518a();
            }
            AbbayedeTimadeuc abbayedeTimadeuc2 = this.f16467c;
            if (abbayedeTimadeuc2 != null) {
                abbayedeTimadeuc2.mo34440e();
            }
        }
        m20325b();
        m20326b(i, i2);
        AbbayedeTimadeuc abbayedeTimadeuc3 = this.f16467c;
        if (abbayedeTimadeuc3 != null) {
            abbayedeTimadeuc3.mo34439d();
        }
    }

    /* renamed from: b */
    public final void mo34531b(String[] strArr) {
        this.f16472h.mo34549a(C6442eu.m21307a(strArr));
    }

    /* renamed from: b */
    public final void mo34530b(Class<? extends Object>[] clsArr) {
        this.f16472h.mo34551b(C6442eu.m21307a(clsArr));
    }

    /* renamed from: a */
    public final void mo34525a(Activity activity, int i, int i2) {
        EcirdelAubrac ecirdelAubrac;
        if (this.f16467c == null && (ecirdelAubrac = this.f16465a) != null) {
            ecirdelAubrac.mo34544d();
        }
        AbbayedeTimadeuc abbayedeTimadeuc = this.f16467c;
        if (abbayedeTimadeuc != null) {
            abbayedeTimadeuc.mo34429a((Appenzeller) new CamembertauCalvados(this, activity, i, i2));
        }
    }

    /* renamed from: a */
    public final void mo34528a(String[] strArr) {
        this.f16471g.mo34535a(C6443ev.m21312c(strArr));
    }

    /* renamed from: a */
    public final void mo34527a(Class<? extends Activity>[] clsArr) {
        this.f16471g.mo34537b(C6443ev.m21312c(clsArr));
    }
}
