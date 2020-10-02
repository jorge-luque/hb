package p093e.p094a.p095a;

/* renamed from: e.a.a.f0 */
/* compiled from: LogLevel */
public enum C3300f0 {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7),
    SUPRESS(8);
    

    /* renamed from: a */
    final int f9190a;

    static {
        VERBOSE = new C3300f0("VERBOSE", 0, 2);
        DEBUG = new C3300f0("DEBUG", 1, 3);
        INFO = new C3300f0("INFO", 2, 4);
        WARN = new C3300f0("WARN", 3, 5);
        ERROR = new C3300f0("ERROR", 4, 6);
        ASSERT = new C3300f0("ASSERT", 5, 7);
        SUPRESS = new C3300f0("SUPRESS", 6, 8);
    }

    private C3300f0(int i) {
        this.f9190a = i;
    }
}
