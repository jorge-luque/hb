package androidx.media;

import java.util.Arrays;

/* renamed from: androidx.media.c */
/* compiled from: AudioAttributesImplBase */
class C1011c implements C1009a {

    /* renamed from: a */
    int f2581a = 0;

    /* renamed from: b */
    int f2582b = 0;

    /* renamed from: c */
    int f2583c = 0;

    /* renamed from: d */
    int f2584d = -1;

    C1011c() {
    }

    /* renamed from: a */
    public int mo5112a() {
        return this.f2582b;
    }

    /* renamed from: b */
    public int mo5113b() {
        int i = this.f2583c;
        int c = mo5114c();
        if (c == 6) {
            i |= 4;
        } else if (c == 7) {
            i |= 1;
        }
        return i & 273;
    }

    /* renamed from: c */
    public int mo5114c() {
        int i = this.f2584d;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.m3559a(false, this.f2583c, this.f2581a);
    }

    /* renamed from: d */
    public int mo5115d() {
        return this.f2581a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1011c)) {
            return false;
        }
        C1011c cVar = (C1011c) obj;
        if (this.f2582b == cVar.mo5112a() && this.f2583c == cVar.mo5113b() && this.f2581a == cVar.mo5115d() && this.f2584d == cVar.f2584d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2582b), Integer.valueOf(this.f2583c), Integer.valueOf(this.f2581a), Integer.valueOf(this.f2584d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2584d != -1) {
            sb.append(" stream=");
            sb.append(this.f2584d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.m3560a(this.f2581a));
        sb.append(" content=");
        sb.append(this.f2582b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2583c).toUpperCase());
        return sb.toString();
    }
}
