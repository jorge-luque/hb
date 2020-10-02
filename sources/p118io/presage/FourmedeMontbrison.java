package p118io.presage;

/* renamed from: io.presage.FourmedeMontbrison */
public final class FourmedeMontbrison implements GaletteLyonnaise {

    /* renamed from: a */
    public static final CamembertauCalvados f16513a = new CamembertauCalvados((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f16514b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C6482gg<? super Throwable, C6437ep> f16515c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C6481gf<C6437ep> f16516d;

    /* renamed from: io.presage.FourmedeMontbrison$AbbayedeTamie */
    static final class AbbayedeTamie implements Runnable {

        /* renamed from: a */
        final /* synthetic */ FourmedeMontbrison f16517a;

        /* renamed from: b */
        final /* synthetic */ C6481gf f16518b;

        AbbayedeTamie(FourmedeMontbrison fourmedeMontbrison, C6481gf gfVar) {
            this.f16517a = fourmedeMontbrison;
            this.f16518b = gfVar;
        }

        public final void run() {
            try {
                this.f16517a.f16516d.mo34405a();
                this.f16517a.m20393b((C6481gf<C6437ep>) this.f16518b);
            } catch (Throwable th) {
                C6482gg b = this.f16517a.f16515c;
                if (b != null) {
                    this.f16517a.m20391a(b, th);
                }
            }
        }
    }

    /* renamed from: io.presage.FourmedeMontbrison$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static FourmedeMontbrison m20398a(C6481gf<C6437ep> gfVar) {
            return new FourmedeMontbrison(gfVar, (byte) 0);
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: io.presage.FourmedeMontbrison$CamembertdeNormandie */
    static final class CamembertdeNormandie implements Runnable {

        /* renamed from: a */
        final /* synthetic */ FourmedeMontbrison f16519a;

        /* renamed from: b */
        final /* synthetic */ C6481gf f16520b;

        CamembertdeNormandie(FourmedeMontbrison fourmedeMontbrison, C6481gf gfVar) {
            this.f16519a = fourmedeMontbrison;
            this.f16520b = gfVar;
        }

        public final void run() {
            if (!this.f16519a.f16514b) {
                this.f16520b.mo34405a();
            }
        }
    }

    /* renamed from: io.presage.FourmedeMontbrison$EcirdelAubrac */
    static final class EcirdelAubrac implements Runnable {

        /* renamed from: a */
        final /* synthetic */ FourmedeMontbrison f16521a;

        /* renamed from: b */
        final /* synthetic */ C6482gg f16522b;

        /* renamed from: c */
        final /* synthetic */ Object f16523c;

        EcirdelAubrac(FourmedeMontbrison fourmedeMontbrison, C6482gg ggVar, Object obj) {
            this.f16521a = fourmedeMontbrison;
            this.f16522b = ggVar;
            this.f16523c = obj;
        }

        public final void run() {
            if (!this.f16521a.f16514b) {
                this.f16522b.mo34409a(this.f16523c);
            }
        }
    }

    private FourmedeMontbrison(C6481gf<C6437ep> gfVar) {
        this.f16516d = gfVar;
    }

    public /* synthetic */ FourmedeMontbrison(C6481gf gfVar, byte b) {
        this(gfVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m20393b(C6481gf<C6437ep> gfVar) {
        Gouda36mois gouda36mois = Gouda36mois.f16526a;
        Gouda36mois.m20406c().mo34553a(new CamembertdeNormandie(this, gfVar));
    }

    /* renamed from: a */
    public final void mo34556a() {
        this.f16515c = null;
        this.f16514b = true;
    }

    /* renamed from: a */
    public final FourmedeMontbrison mo34554a(C6482gg<? super Throwable, C6437ep> ggVar) {
        this.f16515c = ggVar;
        return this;
    }

    /* renamed from: a */
    public final GaletteLyonnaise mo34555a(C6481gf<C6437ep> gfVar) {
        Gouda36mois gouda36mois = Gouda36mois.f16526a;
        Gouda36mois.m20405b().mo34553a(new AbbayedeTamie(this, gfVar));
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <R> void m20391a(C6482gg<? super R, C6437ep> ggVar, R r) {
        Gouda36mois gouda36mois = Gouda36mois.f16526a;
        Gouda36mois.m20406c().mo34553a(new EcirdelAubrac(this, ggVar, r));
    }
}
