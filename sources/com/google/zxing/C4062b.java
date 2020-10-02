package com.google.zxing;

/* renamed from: com.google.zxing.b */
/* compiled from: Dimension */
public final class C4062b {

    /* renamed from: a */
    private final int f10887a;

    /* renamed from: b */
    private final int f10888b;

    /* renamed from: a */
    public int mo28266a() {
        return this.f10888b;
    }

    /* renamed from: b */
    public int mo28267b() {
        return this.f10887a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C4062b) {
            C4062b bVar = (C4062b) obj;
            if (this.f10887a == bVar.f10887a && this.f10888b == bVar.f10888b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.f10887a * 32713) + this.f10888b;
    }

    public String toString() {
        return this.f10887a + "x" + this.f10888b;
    }
}
