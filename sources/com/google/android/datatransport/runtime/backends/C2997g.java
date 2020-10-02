package com.google.android.datatransport.runtime.backends;

/* renamed from: com.google.android.datatransport.runtime.backends.g */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class C2997g {

    /* renamed from: com.google.android.datatransport.runtime.backends.g$a */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public enum C2998a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR;

        static {
            OK = new C2998a("OK", 0);
            TRANSIENT_ERROR = new C2998a("TRANSIENT_ERROR", 1);
            FATAL_ERROR = new C2998a("FATAL_ERROR", 2);
        }
    }

    /* renamed from: a */
    public static C2997g m9867a(long j) {
        return new C2991b(C2998a.OK, j);
    }

    /* renamed from: c */
    public static C2997g m9868c() {
        return new C2991b(C2998a.FATAL_ERROR, -1);
    }

    /* renamed from: d */
    public static C2997g m9869d() {
        return new C2991b(C2998a.TRANSIENT_ERROR, -1);
    }

    /* renamed from: a */
    public abstract long mo12955a();

    /* renamed from: b */
    public abstract C2998a mo12956b();
}
