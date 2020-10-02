package p118io.presage;

import p118io.presage.Goudaauxepices;
import p118io.presage.common.AdConfig;

/* renamed from: io.presage.MunsterauCumin */
public final class MunsterauCumin {

    /* renamed from: a */
    public static final CamembertauCalvados f16583a = new CamembertauCalvados((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final PavedAremberg f16584b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final StRomans f16585c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Stilton f16586d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final RacletteSuisse f16587e;

    /* renamed from: io.presage.MunsterauCumin$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: io.presage.MunsterauCumin$CamembertdeNormandie */
    static final class CamembertdeNormandie extends C6515hm implements C6481gf<RouedeBrie> {

        /* renamed from: a */
        final /* synthetic */ MunsterauCumin f16588a;

        /* renamed from: b */
        final /* synthetic */ SableduBoulonnais f16589b;

        /* renamed from: c */
        final /* synthetic */ AdConfig f16590c;

        /* renamed from: d */
        final /* synthetic */ String f16591d;

        /* renamed from: e */
        final /* synthetic */ Soumaintrain f16592e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        CamembertdeNormandie(MunsterauCumin munsterauCumin, SableduBoulonnais sableduBoulonnais, AdConfig adConfig, String str, Soumaintrain soumaintrain) {
            super(0);
            this.f16588a = munsterauCumin;
            this.f16589b = sableduBoulonnais;
            this.f16590c = adConfig;
            this.f16591d = str;
            this.f16592e = soumaintrain;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public RouedeBrie mo34405a() {
            C6412dr a = this.f16588a.f16584b.mo34595a(this.f16589b, this.f16590c, this.f16591d, this.f16592e);
            if (a instanceof C6413ds) {
                RacletteSuisse unused = this.f16588a.f16587e;
                RouedeBrie a2 = RacletteSuisse.m20616a(((C6413ds) a).mo35377a(), this.f16589b, this.f16592e);
                this.f16588a.f16586d.mo34692a(a2.mo34662a(), this.f16588a.f16585c, this.f16588a.f16584b);
                return a2;
            } else if (a instanceof C6403di) {
                throw ((C6403di) a).mo35368a();
            } else {
                throw new C6430ei();
            }
        }
    }

    private MunsterauCumin(PavedAremberg pavedAremberg, StRomans stRomans, Stilton stilton, RacletteSuisse racletteSuisse) {
        this.f16584b = pavedAremberg;
        this.f16585c = stRomans;
        this.f16586d = stilton;
        this.f16587e = racletteSuisse;
    }

    private /* synthetic */ MunsterauCumin(PavedAremberg pavedAremberg, StRomans stRomans) {
        this(pavedAremberg, stRomans, Stilton.f16694a, RacletteSuisse.f16660a);
    }

    /* renamed from: a */
    public final Goudaauxepices<RouedeBrie> mo34586a(SableduBoulonnais sableduBoulonnais, AdConfig adConfig, String str, Soumaintrain soumaintrain) {
        Goudaauxepices.CamembertauCalvados camembertauCalvados = Goudaauxepices.f16532a;
        return Goudaauxepices.CamembertauCalvados.m20425a(new CamembertdeNormandie(this, sableduBoulonnais, adConfig, str, soumaintrain));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MunsterauCumin(android.content.Context r3) {
        /*
            r2 = this;
            io.presage.PersilledumontBlanc r0 = p118io.presage.PersilledumontBlanc.f16609a
            io.presage.PavedAremberg r0 = p118io.presage.PersilledumontBlanc.m20539a(r3)
            io.presage.StRomans$CamembertauCalvados r1 = p118io.presage.StRomans.f16690a
            io.presage.StRomans r3 = p118io.presage.StRomans.CamembertauCalvados.m20680a(r3)
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.MunsterauCumin.<init>(android.content.Context):void");
    }
}
