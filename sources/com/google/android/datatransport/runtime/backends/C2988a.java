package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.C2995f;
import java.util.Arrays;
import p093e.p101c.p102a.p103a.p104i.C3400h;

/* renamed from: com.google.android.datatransport.runtime.backends.a */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C2988a extends C2995f {

    /* renamed from: a */
    private final Iterable<C3400h> f8340a;

    /* renamed from: b */
    private final byte[] f8341b;

    /* renamed from: a */
    public Iterable<C3400h> mo12947a() {
        return this.f8340a;
    }

    /* renamed from: b */
    public byte[] mo12948b() {
        return this.f8341b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2995f)) {
            return false;
        }
        C2995f fVar = (C2995f) obj;
        if (this.f8340a.equals(fVar.mo12947a())) {
            if (Arrays.equals(this.f8341b, fVar instanceof C2988a ? ((C2988a) fVar).f8341b : fVar.mo12948b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f8340a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f8341b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f8340a + ", extras=" + Arrays.toString(this.f8341b) + "}";
    }

    /* renamed from: com.google.android.datatransport.runtime.backends.a$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class C2990b extends C2995f.C2996a {

        /* renamed from: a */
        private Iterable<C3400h> f8342a;

        /* renamed from: b */
        private byte[] f8343b;

        C2990b() {
        }

        /* renamed from: a */
        public C2995f.C2996a mo12952a(Iterable<C3400h> iterable) {
            if (iterable != null) {
                this.f8342a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        /* renamed from: a */
        public C2995f.C2996a mo12953a(byte[] bArr) {
            this.f8343b = bArr;
            return this;
        }

        /* renamed from: a */
        public C2995f mo12954a() {
            String str = "";
            if (this.f8342a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new C2988a(this.f8342a, this.f8343b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private C2988a(Iterable<C3400h> iterable, byte[] bArr) {
        this.f8340a = iterable;
        this.f8341b = bArr;
    }
}
