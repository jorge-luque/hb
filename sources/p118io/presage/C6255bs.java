package p118io.presage;

/* renamed from: io.presage.bs */
public final class C6255bs {

    /* renamed from: a */
    private final boolean f16851a;

    /* renamed from: b */
    private boolean f16852b;

    /* renamed from: c */
    private final String f16853c;

    /* renamed from: d */
    private boolean f16854d;

    /* renamed from: e */
    private boolean f16855e;

    /* renamed from: f */
    private boolean f16856f;

    private C6255bs(boolean z, boolean z2, String str, boolean z3) {
        this.f16851a = z;
        this.f16852b = z2;
        this.f16853c = str;
        this.f16854d = z3;
        this.f16855e = false;
        this.f16856f = false;
    }

    /* renamed from: a */
    public final boolean mo34835a() {
        return this.f16851a;
    }

    /* renamed from: b */
    public final boolean mo34836b() {
        return this.f16852b;
    }

    /* renamed from: c */
    public final String mo34837c() {
        return this.f16853c;
    }

    /* renamed from: d */
    public final boolean mo34838d() {
        return this.f16854d;
    }

    /* renamed from: e */
    public final void mo34839e() {
        this.f16854d = true;
    }

    /* renamed from: f */
    public final boolean mo34840f() {
        return this.f16855e;
    }

    /* renamed from: g */
    public final void mo34841g() {
        this.f16855e = true;
    }

    /* renamed from: h */
    public final boolean mo34842h() {
        return this.f16856f;
    }

    /* renamed from: i */
    public final void mo34843i() {
        this.f16856f = true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C6255bs(boolean z, boolean z2, String str, boolean z3, int i) {
        this(z, z2, str, (i & 8) != 0 ? false : z3);
    }
}
