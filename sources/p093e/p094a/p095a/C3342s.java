package p093e.p094a.p095a;

/* renamed from: e.a.a.s */
/* compiled from: BackoffStrategy */
public enum C3342s {
    LONG_WAIT(1, 120000, 86400000, 0.5d, 1.0d),
    SHORT_WAIT(1, 200, 3600000, 0.5d, 1.0d),
    TEST_WAIT(1, 200, 1000, 0.5d, 1.0d),
    NO_WAIT(100, 1, 1000, 1.0d, 1.0d);
    

    /* renamed from: a */
    int f9348a;

    /* renamed from: b */
    long f9349b;

    /* renamed from: c */
    long f9350c;

    /* renamed from: d */
    double f9351d;

    /* renamed from: e */
    double f9352e;

    static {
        LONG_WAIT = new C3342s("LONG_WAIT", 0, 1, 120000, 86400000, 0.5d, 1.0d);
        SHORT_WAIT = new C3342s("SHORT_WAIT", 1, 1, 200, 3600000, 0.5d, 1.0d);
        TEST_WAIT = new C3342s("TEST_WAIT", 2, 1, 200, 1000, 0.5d, 1.0d);
        NO_WAIT = new C3342s("NO_WAIT", 3, 100, 1, 1000, 1.0d, 1.0d);
    }

    private C3342s(int i, long j, long j2, double d, double d2) {
        this.f9348a = i;
        this.f9349b = j;
        this.f9350c = j2;
        this.f9351d = d;
        this.f9352e = d2;
    }
}
