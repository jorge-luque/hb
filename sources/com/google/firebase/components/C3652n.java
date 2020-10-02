package com.google.firebase.components;

/* renamed from: com.google.firebase.components.n */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final class C3652n {

    /* renamed from: a */
    private final Class<?> f10212a;

    /* renamed from: b */
    private final int f10213b;

    /* renamed from: c */
    private final int f10214c;

    private C3652n(Class<?> cls, int i, int i2) {
        C3656r.m12444a(cls, "Null dependency anInterface.");
        this.f10212a = cls;
        this.f10213b = i;
        this.f10214c = i2;
    }

    /* renamed from: a */
    public static C3652n m12429a(Class<?> cls) {
        return new C3652n(cls, 0, 0);
    }

    /* renamed from: b */
    public static C3652n m12430b(Class<?> cls) {
        return new C3652n(cls, 1, 0);
    }

    /* renamed from: c */
    public static C3652n m12431c(Class<?> cls) {
        return new C3652n(cls, 2, 0);
    }

    /* renamed from: d */
    public boolean mo27253d() {
        return this.f10213b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3652n)) {
            return false;
        }
        C3652n nVar = (C3652n) obj;
        if (this.f10212a == nVar.f10212a && this.f10213b == nVar.f10213b && this.f10214c == nVar.f10214c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f10212a.hashCode() ^ 1000003) * 1000003) ^ this.f10213b) * 1000003) ^ this.f10214c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f10212a);
        sb.append(", type=");
        int i = this.f10213b;
        boolean z = true;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        if (this.f10214c != 0) {
            z = false;
        }
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public Class<?> mo27250a() {
        return this.f10212a;
    }

    /* renamed from: b */
    public boolean mo27251b() {
        return this.f10214c == 0;
    }

    /* renamed from: c */
    public boolean mo27252c() {
        return this.f10213b == 1;
    }
}
