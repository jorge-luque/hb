package p118io.fabric.sdk.android.services.concurrency.p206m;

/* renamed from: io.fabric.sdk.android.services.concurrency.m.e */
/* compiled from: RetryState */
public class C6189e {

    /* renamed from: a */
    private final int f16236a;

    /* renamed from: b */
    private final C6185a f16237b;

    /* renamed from: c */
    private final C6188d f16238c;

    public C6189e(C6185a aVar, C6188d dVar) {
        this(0, aVar, dVar);
    }

    /* renamed from: a */
    public long mo34319a() {
        return this.f16237b.getDelayMillis(this.f16236a);
    }

    /* renamed from: b */
    public C6189e mo34320b() {
        return new C6189e(this.f16237b, this.f16238c);
    }

    /* renamed from: c */
    public C6189e mo34321c() {
        return new C6189e(this.f16236a + 1, this.f16237b, this.f16238c);
    }

    public C6189e(int i, C6185a aVar, C6188d dVar) {
        this.f16236a = i;
        this.f16237b = aVar;
        this.f16238c = dVar;
    }
}
