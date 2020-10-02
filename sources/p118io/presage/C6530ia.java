package p118io.presage;

/* renamed from: io.presage.ia */
public final class C6530ia extends C6527hy {

    /* renamed from: b */
    public static final CamembertauCalvados f17064b = new CamembertauCalvados((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final C6530ia f17065c = new C6530ia(1, 0);

    /* renamed from: io.presage.ia$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static C6530ia m21444a() {
            return C6530ia.f17065c;
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public C6530ia(int i, int i2) {
        super(i, i2);
    }

    /* renamed from: d */
    public final boolean mo35532d() {
        return mo35529a() > mo35530b();
    }

    /* renamed from: e */
    public final Integer mo35538e() {
        return Integer.valueOf(mo35529a());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C6530ia)) {
            return false;
        }
        if (mo35532d() && ((C6530ia) obj).mo35532d()) {
            return true;
        }
        C6530ia iaVar = (C6530ia) obj;
        return mo35529a() == iaVar.mo35529a() && mo35530b() == iaVar.mo35530b();
    }

    /* renamed from: f */
    public final Integer mo35539f() {
        return Integer.valueOf(mo35530b());
    }

    public final int hashCode() {
        if (mo35532d()) {
            return -1;
        }
        return (mo35529a() * 31) + mo35530b();
    }

    public final String toString() {
        return mo35529a() + ".." + mo35530b();
    }
}
