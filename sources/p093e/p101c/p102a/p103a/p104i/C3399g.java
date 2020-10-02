package p093e.p101c.p102a.p103a.p104i;

import java.util.Arrays;
import p093e.p101c.p102a.p103a.C3378b;

/* renamed from: e.c.a.a.i.g */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3399g {

    /* renamed from: a */
    private final C3378b f9487a;

    /* renamed from: b */
    private final byte[] f9488b;

    public C3399g(C3378b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f9487a = bVar;
            this.f9488b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    /* renamed from: a */
    public byte[] mo19197a() {
        return this.f9488b;
    }

    /* renamed from: b */
    public C3378b mo19198b() {
        return this.f9487a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3399g)) {
            return false;
        }
        C3399g gVar = (C3399g) obj;
        if (!this.f9487a.equals(gVar.f9487a)) {
            return false;
        }
        return Arrays.equals(this.f9488b, gVar.f9488b);
    }

    public int hashCode() {
        return ((this.f9487a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f9488b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f9487a + ", bytes=[...]}";
    }
}
