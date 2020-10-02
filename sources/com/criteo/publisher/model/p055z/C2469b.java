package com.criteo.publisher.model.p055z;

import com.criteo.publisher.model.p055z.C2488n;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.criteo.publisher.model.z.b */
abstract class C2469b extends C2488n {

    /* renamed from: a */
    private final List<C2493r> f7944a;

    /* renamed from: b */
    private final C2487m f7945b;

    /* renamed from: c */
    private final C2492q f7946c;

    /* renamed from: d */
    private final List<C2491p> f7947d;

    C2469b(List<C2493r> list, C2487m mVar, C2492q qVar, List<C2491p> list2) {
        if (list != null) {
            this.f7944a = list;
            if (mVar != null) {
                this.f7945b = mVar;
                if (qVar != null) {
                    this.f7946c = qVar;
                    if (list2 != null) {
                        this.f7947d = list2;
                        return;
                    }
                    throw new NullPointerException("Null pixels");
                }
                throw new NullPointerException("Null privacy");
            }
            throw new NullPointerException("Null advertiser");
        }
        throw new NullPointerException("Null nativeProducts");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2487m mo10434a() {
        return this.f7945b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2488n)) {
            return false;
        }
        C2488n nVar = (C2488n) obj;
        if (!this.f7944a.equals(nVar.mo10436g()) || !this.f7945b.equals(nVar.mo10434a()) || !this.f7946c.equals(nVar.mo10439i()) || !this.f7947d.equals(nVar.mo10437h())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("products")
    /* renamed from: g */
    public List<C2493r> mo10436g() {
        return this.f7944a;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("impressionPixels")
    /* renamed from: h */
    public List<C2491p> mo10437h() {
        return this.f7947d;
    }

    public int hashCode() {
        return ((((((this.f7944a.hashCode() ^ 1000003) * 1000003) ^ this.f7945b.hashCode()) * 1000003) ^ this.f7946c.hashCode()) * 1000003) ^ this.f7947d.hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public C2492q mo10439i() {
        return this.f7946c;
    }

    public String toString() {
        return "NativeAssets{nativeProducts=" + this.f7944a + ", advertiser=" + this.f7945b + ", privacy=" + this.f7946c + ", pixels=" + this.f7947d + "}";
    }

    /* renamed from: com.criteo.publisher.model.z.b$a */
    static class C2470a extends C2488n.C2489a {

        /* renamed from: a */
        private List<C2493r> f7948a;

        /* renamed from: b */
        private C2487m f7949b;

        /* renamed from: c */
        private C2492q f7950c;

        /* renamed from: d */
        private List<C2491p> f7951d;

        C2470a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2488n.C2489a mo10443a(List<C2493r> list) {
            if (list != null) {
                this.f7948a = list;
                return this;
            }
            throw new NullPointerException("Null nativeProducts");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C2488n.C2489a mo10445b(List<C2491p> list) {
            if (list != null) {
                this.f7951d = list;
                return this;
            }
            throw new NullPointerException("Null pixels");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public List<C2493r> mo10446c() {
            List<C2493r> list = this.f7948a;
            if (list != null) {
                return list;
            }
            throw new IllegalStateException("Property \"nativeProducts\" has not been set");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public List<C2491p> mo10447d() {
            List<C2491p> list = this.f7951d;
            if (list != null) {
                return list;
            }
            throw new IllegalStateException("Property \"pixels\" has not been set");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2488n.C2489a mo10441a(C2487m mVar) {
            if (mVar != null) {
                this.f7949b = mVar;
                return this;
            }
            throw new NullPointerException("Null advertiser");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2488n.C2489a mo10442a(C2492q qVar) {
            if (qVar != null) {
                this.f7950c = qVar;
                return this;
            }
            throw new NullPointerException("Null privacy");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2488n mo10444a() {
            String str = "";
            if (this.f7948a == null) {
                str = str + " nativeProducts";
            }
            if (this.f7949b == null) {
                str = str + " advertiser";
            }
            if (this.f7950c == null) {
                str = str + " privacy";
            }
            if (this.f7951d == null) {
                str = str + " pixels";
            }
            if (str.isEmpty()) {
                return new C2477h(this.f7948a, this.f7949b, this.f7950c, this.f7951d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
