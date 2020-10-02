package com.google.android.datatransport.cct.p070b;

import com.google.android.datatransport.cct.p070b.C2950f;

/* renamed from: com.google.android.datatransport.cct.b.m */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public abstract class C2965m {

    /* renamed from: com.google.android.datatransport.cct.b.m$a */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static abstract class C2966a {
        /* renamed from: a */
        public abstract C2966a mo12887a(C2942a aVar);

        /* renamed from: a */
        public abstract C2966a mo12888a(C2967b bVar);

        /* renamed from: a */
        public abstract C2965m mo12889a();
    }

    /* renamed from: com.google.android.datatransport.cct.b.m$b */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public enum C2967b {
        UNKNOWN(0),
        ANDROID(4);

        static {
            UNKNOWN = new C2967b("UNKNOWN", 0, 0);
            ANDROID = new C2967b("ANDROID", 1, 4);
        }

        private C2967b(int i) {
        }
    }

    /* renamed from: a */
    public static C2966a m9798a() {
        return new C2950f.C2952b();
    }
}
