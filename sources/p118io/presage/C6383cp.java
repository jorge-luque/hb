package p118io.presage;

/* renamed from: io.presage.cp */
public final class C6383cp implements C6241be {

    /* renamed from: a */
    public static final CamembertauCalvados f16933a = new CamembertauCalvados((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final C6383cp f16934c = new C6383cp(new C6241be[0]);

    /* renamed from: b */
    private final C6241be[] f16935b;

    /* renamed from: io.presage.cp$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static C6383cp m21168a() {
            return C6383cp.f16934c;
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public C6383cp(C6241be[] beVarArr) {
        this.f16935b = beVarArr;
    }

    /* renamed from: a */
    public final boolean mo34777a(String str, C6396db dbVar, SaintFelicien saintFelicien) {
        for (C6241be a : this.f16935b) {
            if (a.mo34777a(str, dbVar, saintFelicien)) {
                return true;
            }
        }
        return false;
    }
}
