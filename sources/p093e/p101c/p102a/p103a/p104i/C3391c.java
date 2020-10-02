package p093e.p101c.p102a.p103a.p104i;

import java.util.Arrays;
import p093e.p101c.p102a.p103a.C3380d;
import p093e.p101c.p102a.p103a.p104i.C3406l;

/* renamed from: e.c.a.a.i.c */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3391c extends C3406l {

    /* renamed from: a */
    private final String f9468a;

    /* renamed from: b */
    private final byte[] f9469b;

    /* renamed from: c */
    private final C3380d f9470c;

    /* renamed from: a */
    public String mo19184a() {
        return this.f9468a;
    }

    /* renamed from: b */
    public byte[] mo19185b() {
        return this.f9469b;
    }

    /* renamed from: c */
    public C3380d mo19186c() {
        return this.f9470c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3406l)) {
            return false;
        }
        C3406l lVar = (C3406l) obj;
        if (this.f9468a.equals(lVar.mo19184a())) {
            if (!Arrays.equals(this.f9469b, lVar instanceof C3391c ? ((C3391c) lVar).f9469b : lVar.mo19185b()) || !this.f9470c.equals(lVar.mo19186c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f9468a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f9469b)) * 1000003) ^ this.f9470c.hashCode();
    }

    /* renamed from: e.c.a.a.i.c$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static final class C3393b extends C3406l.C3407a {

        /* renamed from: a */
        private String f9471a;

        /* renamed from: b */
        private byte[] f9472b;

        /* renamed from: c */
        private C3380d f9473c;

        C3393b() {
        }

        /* renamed from: a */
        public C3406l.C3407a mo19190a(String str) {
            if (str != null) {
                this.f9471a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        /* renamed from: a */
        public C3406l.C3407a mo19191a(byte[] bArr) {
            this.f9472b = bArr;
            return this;
        }

        /* renamed from: a */
        public C3406l.C3407a mo19189a(C3380d dVar) {
            if (dVar != null) {
                this.f9473c = dVar;
                return this;
            }
            throw new NullPointerException("Null priority");
        }

        /* renamed from: a */
        public C3406l mo19192a() {
            String str = "";
            if (this.f9471a == null) {
                str = str + " backendName";
            }
            if (this.f9473c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new C3391c(this.f9471a, this.f9472b, this.f9473c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private C3391c(String str, byte[] bArr, C3380d dVar) {
        this.f9468a = str;
        this.f9469b = bArr;
        this.f9470c = dVar;
    }
}
