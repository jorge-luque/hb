package com.google.firebase.p124e;

/* renamed from: com.google.firebase.e.c */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public interface C3666c {

    /* renamed from: com.google.firebase.e.c$a */
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public enum C3667a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        

        /* renamed from: a */
        private final int f10238a;

        static {
            NONE = new C3667a("NONE", 0, 0);
            SDK = new C3667a("SDK", 1, 1);
            GLOBAL = new C3667a("GLOBAL", 2, 2);
            COMBINED = new C3667a("COMBINED", 3, 3);
        }

        private C3667a(int i) {
            this.f10238a = i;
        }

        /* renamed from: a */
        public int mo27266a() {
            return this.f10238a;
        }
    }

    /* renamed from: a */
    C3667a mo27265a(String str);
}
