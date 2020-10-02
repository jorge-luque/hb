package p118io.fabric.sdk.android.p200m.p202b;

/* renamed from: io.fabric.sdk.android.m.b.m */
/* compiled from: DeliveryMechanism */
public enum C6098m {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: a */
    private final int f16045a;

    static {
        DEVELOPER = new C6098m("DEVELOPER", 0, 1);
        USER_SIDELOAD = new C6098m("USER_SIDELOAD", 1, 2);
        TEST_DISTRIBUTION = new C6098m("TEST_DISTRIBUTION", 2, 3);
        APP_STORE = new C6098m("APP_STORE", 3, 4);
    }

    private C6098m(int i) {
        this.f16045a = i;
    }

    /* renamed from: a */
    public int mo34179a() {
        return this.f16045a;
    }

    public String toString() {
        return Integer.toString(this.f16045a);
    }

    /* renamed from: a */
    public static C6098m m19770a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
