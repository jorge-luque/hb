package p118io.presage;

/* renamed from: io.presage.RomansPartDieu */
public final class RomansPartDieu implements RegaldeBourgogne {

    /* renamed from: a */
    private final C6556j f16666a;

    /* renamed from: b */
    private final TetedeMoine f16667b;

    /* renamed from: c */
    private final Taleggio f16668c;

    /* renamed from: d */
    private final SaintPaulin f16669d;

    public RomansPartDieu(TetedeMoine tetedeMoine, Taleggio taleggio, SaintPaulin saintPaulin) {
        this.f16667b = tetedeMoine;
        this.f16668c = taleggio;
        this.f16669d = saintPaulin;
        C6556j a = C6565k.m21538a(tetedeMoine.mo34709g());
        if (a != null) {
            this.f16666a = a;
            return;
        }
        throw new IllegalStateException("Profig must not be null");
    }

    /* renamed from: a */
    public final String mo34652a() {
        return this.f16668c.mo34696i();
    }

    /* renamed from: b */
    public final String mo34653b() {
        return this.f16668c.mo34693f();
    }

    /* renamed from: c */
    public final String mo34654c() {
        return this.f16667b.mo34705c();
    }

    /* renamed from: d */
    public final String mo34655d() {
        return this.f16667b.mo34702a();
    }

    /* renamed from: e */
    public final boolean mo34656e() {
        return this.f16666a.mo35576c() && SaintPaulin.m20662a();
    }

    /* renamed from: f */
    public final boolean mo34657f() {
        return this.f16666a.mo35579d() && SaintPaulin.m20663b();
    }

    /* renamed from: g */
    public final int mo34658g() {
        return this.f16668c.mo34697j();
    }

    /* renamed from: h */
    public final int mo34659h() {
        return this.f16668c.mo34698k();
    }

    /* renamed from: i */
    public final String mo34660i() {
        return "3.3.9-moat";
    }

    /* renamed from: j */
    public final float mo34661j() {
        return this.f16668c.mo34701n();
    }
}
