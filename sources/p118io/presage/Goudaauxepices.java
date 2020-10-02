package p118io.presage;

/* renamed from: io.presage.Goudaauxepices */
public final class Goudaauxepices<T> implements GaletteLyonnaise {

    /* renamed from: a */
    public static final CamembertauCalvados f16532a = new CamembertauCalvados((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f16533b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C6482gg<? super Throwable, C6437ep> f16534c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C6481gf<T> f16535d;

    /* renamed from: io.presage.Goudaauxepices$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static <T> Goudaauxepices<T> m20425a(C6481gf<? extends T> gfVar) {
            return new Goudaauxepices<>(gfVar, (byte) 0);
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    /* renamed from: io.presage.Goudaauxepices$CamembertdeNormandie */
    static final class CamembertdeNormandie implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Goudaauxepices f16536a;

        /* renamed from: b */
        final /* synthetic */ C6482gg f16537b;

        /* renamed from: c */
        final /* synthetic */ Object f16538c;

        CamembertdeNormandie(Goudaauxepices goudaauxepices, C6482gg ggVar, Object obj) {
            this.f16536a = goudaauxepices;
            this.f16537b = ggVar;
            this.f16538c = obj;
        }

        public final void run() {
            if (!this.f16536a.f16533b) {
                this.f16537b.mo34409a(this.f16538c);
            }
        }
    }

    /* renamed from: io.presage.Goudaauxepices$EcirdelAubrac */
    static final class EcirdelAubrac implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Goudaauxepices f16539a;

        /* renamed from: b */
        final /* synthetic */ C6482gg f16540b;

        EcirdelAubrac(Goudaauxepices goudaauxepices, C6482gg ggVar) {
            this.f16539a = goudaauxepices;
            this.f16540b = ggVar;
        }

        public final void run() {
            try {
                this.f16539a.m20419a(this.f16540b, this.f16539a.f16535d.mo34405a());
            } catch (Throwable th) {
                C6482gg b = this.f16539a.f16534c;
                if (b != null) {
                    this.f16539a.m20419a(b, th);
                }
            }
        }
    }

    private Goudaauxepices(C6481gf<? extends T> gfVar) {
        this.f16535d = gfVar;
    }

    public /* synthetic */ Goudaauxepices(C6481gf gfVar, byte b) {
        this(gfVar);
    }

    /* renamed from: b */
    public final GaletteLyonnaise mo34564b(C6482gg<? super T, C6437ep> ggVar) {
        Gouda36mois gouda36mois = Gouda36mois.f16526a;
        Gouda36mois.m20405b().mo34553a(new EcirdelAubrac(this, ggVar));
        return this;
    }

    /* renamed from: a */
    public final void mo34556a() {
        this.f16534c = null;
        this.f16533b = true;
    }

    /* renamed from: a */
    public final Goudaauxepices<T> mo34563a(C6482gg<? super Throwable, C6437ep> ggVar) {
        this.f16534c = ggVar;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <R> void m20419a(C6482gg<? super R, C6437ep> ggVar, R r) {
        Gouda36mois gouda36mois = Gouda36mois.f16526a;
        Gouda36mois.m20406c().mo34553a(new CamembertdeNormandie(this, ggVar, r));
    }
}
