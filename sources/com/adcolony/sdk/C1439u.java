package com.adcolony.sdk;

/* renamed from: com.adcolony.sdk.u */
class C1439u {

    /* renamed from: c */
    static C1439u f4510c = new C1439u(3, false);

    /* renamed from: d */
    static C1439u f4511d = new C1439u(3, true);

    /* renamed from: e */
    static C1439u f4512e = new C1439u(2, false);

    /* renamed from: f */
    static C1439u f4513f = new C1439u(2, true);

    /* renamed from: g */
    static C1439u f4514g = new C1439u(1, false);

    /* renamed from: h */
    static C1439u f4515h = new C1439u(1, true);

    /* renamed from: i */
    static C1439u f4516i = new C1439u(0, false);

    /* renamed from: j */
    static C1439u f4517j = new C1439u(0, true);

    /* renamed from: a */
    private int f4518a;

    /* renamed from: b */
    private boolean f4519b;

    /* renamed from: com.adcolony.sdk.u$a */
    static class C1440a {

        /* renamed from: a */
        StringBuilder f4520a = new StringBuilder();

        C1440a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1440a mo6797a(char c) {
            if (c != 10) {
                this.f4520a.append(c);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1440a mo6801a(String str) {
            this.f4520a.append(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1440a mo6800a(Object obj) {
            if (obj != null) {
                this.f4520a.append(obj.toString());
            } else {
                this.f4520a.append("null");
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1440a mo6798a(double d) {
            C1359k0.m5306a(d, 2, this.f4520a);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1440a mo6799a(int i) {
            this.f4520a.append(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1440a mo6802a(boolean z) {
            this.f4520a.append(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6803a(C1439u uVar) {
            uVar.m5617a(this.f4520a.toString());
        }
    }

    C1439u(int i, boolean z) {
        this.f4518a = i;
        this.f4519b = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5617a(String str) {
        C1199a.m4880c().mo6547m().mo6818a(this.f4518a, str, this.f4519b);
    }
}
