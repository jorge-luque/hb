package kotlin;

import kotlin.p212b.p213a.C6607b;

/* renamed from: kotlin.a */
/* compiled from: KotlinVersion.kt */
public final class C6604a implements Comparable<C6604a> {

    /* renamed from: e */
    public static final C6604a f17276e = new C6604a(1, 3, 72);

    /* renamed from: a */
    private final int f17277a;

    /* renamed from: b */
    private final int f17278b;

    /* renamed from: c */
    private final int f17279c;

    /* renamed from: d */
    private final int f17280d;

    /* renamed from: kotlin.a$a */
    /* compiled from: KotlinVersion.kt */
    public static final class C6605a {
        private C6605a() {
        }

        public /* synthetic */ C6605a(C6606a aVar) {
            this();
        }
    }

    static {
        new C6605a((C6606a) null);
    }

    public C6604a(int i, int i2, int i3) {
        this.f17278b = i;
        this.f17279c = i2;
        this.f17280d = i3;
        this.f17277a = m21697a(i, i2, i3);
    }

    /* renamed from: a */
    private final int m21697a(int i, int i2, int i3) {
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6604a)) {
            obj = null;
        }
        C6604a aVar = (C6604a) obj;
        if (aVar == null || this.f17277a != aVar.f17277a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f17277a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17278b);
        sb.append('.');
        sb.append(this.f17279c);
        sb.append('.');
        sb.append(this.f17280d);
        return sb.toString();
    }

    /* renamed from: a */
    public int compareTo(C6604a aVar) {
        C6607b.m21701a((Object) aVar, "other");
        return this.f17277a - aVar.f17277a;
    }
}
