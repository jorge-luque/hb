package p163cz.msebera.android.httpclient.p165b0;

/* renamed from: cz.msebera.android.httpclient.b0.b */
/* compiled from: MessageConstraints */
public class C5565b implements Cloneable {

    /* renamed from: c */
    public static final C5565b f14523c = new C5566a().mo32885a();

    /* renamed from: a */
    private final int f14524a;

    /* renamed from: b */
    private final int f14525b;

    /* renamed from: cz.msebera.android.httpclient.b0.b$a */
    /* compiled from: MessageConstraints */
    public static class C5566a {

        /* renamed from: a */
        private int f14526a = -1;

        /* renamed from: b */
        private int f14527b = -1;

        C5566a() {
        }

        /* renamed from: a */
        public C5566a mo32884a(int i) {
            this.f14527b = i;
            return this;
        }

        /* renamed from: b */
        public C5566a mo32886b(int i) {
            this.f14526a = i;
            return this;
        }

        /* renamed from: a */
        public C5565b mo32885a() {
            return new C5565b(this.f14526a, this.f14527b);
        }
    }

    C5565b(int i, int i2) {
        this.f14524a = i;
        this.f14525b = i2;
    }

    /* renamed from: c */
    public static C5566a m17727c() {
        return new C5566a();
    }

    /* renamed from: a */
    public int mo32880a() {
        return this.f14525b;
    }

    /* renamed from: b */
    public int mo32881b() {
        return this.f14524a;
    }

    public String toString() {
        return "[maxLineLength=" + this.f14524a + ", maxHeaderCount=" + this.f14525b + "]";
    }

    /* access modifiers changed from: protected */
    public C5565b clone() throws CloneNotSupportedException {
        return (C5565b) super.clone();
    }
}
