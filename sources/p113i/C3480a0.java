package p113i;

import java.io.Closeable;
import javax.annotation.Nullable;
import p113i.C3537r;

/* renamed from: i.a0 */
/* compiled from: Response */
public final class C3480a0 implements Closeable {

    /* renamed from: a */
    final C3548y f9608a;

    /* renamed from: b */
    final C5972w f9609b;

    /* renamed from: c */
    final int f9610c;

    /* renamed from: d */
    final String f9611d;
    @Nullable

    /* renamed from: e */
    final C3536q f9612e;

    /* renamed from: f */
    final C3537r f9613f;
    @Nullable

    /* renamed from: g */
    final C3484b0 f9614g;
    @Nullable

    /* renamed from: h */
    final C3480a0 f9615h;
    @Nullable

    /* renamed from: i */
    final C3480a0 f9616i;
    @Nullable

    /* renamed from: j */
    final C3480a0 f9617j;

    /* renamed from: k */
    final long f9618k;

    /* renamed from: l */
    final long f9619l;
    @Nullable

    /* renamed from: m */
    private volatile C3495d f9620m;

    /* renamed from: i.a0$a */
    /* compiled from: Response */
    public static class C3481a {
        @Nullable

        /* renamed from: a */
        C3548y f9621a;
        @Nullable

        /* renamed from: b */
        C5972w f9622b;

        /* renamed from: c */
        int f9623c;

        /* renamed from: d */
        String f9624d;
        @Nullable

        /* renamed from: e */
        C3536q f9625e;

        /* renamed from: f */
        C3537r.C3538a f9626f;
        @Nullable

        /* renamed from: g */
        C3484b0 f9627g;
        @Nullable

        /* renamed from: h */
        C3480a0 f9628h;
        @Nullable

        /* renamed from: i */
        C3480a0 f9629i;
        @Nullable

        /* renamed from: j */
        C3480a0 f9630j;

        /* renamed from: k */
        long f9631k;

        /* renamed from: l */
        long f9632l;

        public C3481a() {
            this.f9623c = -1;
            this.f9626f = new C3537r.C3538a();
        }

        /* renamed from: d */
        private void m11558d(C3480a0 a0Var) {
            if (a0Var.f9614g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public C3481a mo19300a(C3548y yVar) {
            this.f9621a = yVar;
            return this;
        }

        /* renamed from: b */
        public C3481a mo19306b(String str, String str2) {
            this.f9626f.mo19515c(str, str2);
            return this;
        }

        /* renamed from: c */
        public C3481a mo19307c(@Nullable C3480a0 a0Var) {
            if (a0Var != null) {
                m11558d(a0Var);
            }
            this.f9630j = a0Var;
            return this;
        }

        /* renamed from: a */
        public C3481a mo19299a(C5972w wVar) {
            this.f9622b = wVar;
            return this;
        }

        /* renamed from: b */
        public C3481a mo19305b(@Nullable C3480a0 a0Var) {
            if (a0Var != null) {
                m11557a("networkResponse", a0Var);
            }
            this.f9628h = a0Var;
            return this;
        }

        /* renamed from: a */
        public C3481a mo19293a(int i) {
            this.f9623c = i;
            return this;
        }

        C3481a(C3480a0 a0Var) {
            this.f9623c = -1;
            this.f9621a = a0Var.f9608a;
            this.f9622b = a0Var.f9609b;
            this.f9623c = a0Var.f9610c;
            this.f9624d = a0Var.f9611d;
            this.f9625e = a0Var.f9612e;
            this.f9626f = a0Var.f9613f.mo19500a();
            this.f9627g = a0Var.f9614g;
            this.f9628h = a0Var.f9615h;
            this.f9629i = a0Var.f9616i;
            this.f9630j = a0Var.f9617j;
            this.f9631k = a0Var.f9618k;
            this.f9632l = a0Var.f9619l;
        }

        /* renamed from: a */
        public C3481a mo19301a(String str) {
            this.f9624d = str;
            return this;
        }

        /* renamed from: b */
        public C3481a mo19304b(long j) {
            this.f9631k = j;
            return this;
        }

        /* renamed from: a */
        public C3481a mo19297a(@Nullable C3536q qVar) {
            this.f9625e = qVar;
            return this;
        }

        /* renamed from: a */
        public C3481a mo19302a(String str, String str2) {
            this.f9626f.mo19510a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C3481a mo19298a(C3537r rVar) {
            this.f9626f = rVar.mo19500a();
            return this;
        }

        /* renamed from: a */
        public C3481a mo19296a(@Nullable C3484b0 b0Var) {
            this.f9627g = b0Var;
            return this;
        }

        /* renamed from: a */
        public C3481a mo19295a(@Nullable C3480a0 a0Var) {
            if (a0Var != null) {
                m11557a("cacheResponse", a0Var);
            }
            this.f9629i = a0Var;
            return this;
        }

        /* renamed from: a */
        private void m11557a(String str, C3480a0 a0Var) {
            if (a0Var.f9614g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (a0Var.f9615h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (a0Var.f9616i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (a0Var.f9617j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        /* renamed from: a */
        public C3481a mo19294a(long j) {
            this.f9632l = j;
            return this;
        }

        /* renamed from: a */
        public C3480a0 mo19303a() {
            if (this.f9621a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f9622b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f9623c < 0) {
                throw new IllegalStateException("code < 0: " + this.f9623c);
            } else if (this.f9624d != null) {
                return new C3480a0(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }

    C3480a0(C3481a aVar) {
        this.f9608a = aVar.f9621a;
        this.f9609b = aVar.f9622b;
        this.f9610c = aVar.f9623c;
        this.f9611d = aVar.f9624d;
        this.f9612e = aVar.f9625e;
        this.f9613f = aVar.f9626f.mo19511a();
        this.f9614g = aVar.f9627g;
        this.f9615h = aVar.f9628h;
        this.f9616i = aVar.f9629i;
        this.f9617j = aVar.f9630j;
        this.f9618k = aVar.f9631k;
        this.f9619l = aVar.f9632l;
    }

    @Nullable
    /* renamed from: A */
    public C3480a0 mo19274A() {
        return this.f9615h;
    }

    /* renamed from: X */
    public C3481a mo19275X() {
        return new C3481a(this);
    }

    @Nullable
    /* renamed from: Y */
    public C3480a0 mo19276Y() {
        return this.f9617j;
    }

    /* renamed from: Z */
    public C5972w mo19277Z() {
        return this.f9609b;
    }

    @Nullable
    /* renamed from: a */
    public String mo19278a(String str) {
        return mo19279a(str, (String) null);
    }

    /* renamed from: a0 */
    public long mo19280a0() {
        return this.f9619l;
    }

    /* renamed from: b0 */
    public C3548y mo19281b0() {
        return this.f9608a;
    }

    /* renamed from: c0 */
    public long mo19282c0() {
        return this.f9618k;
    }

    public void close() {
        C3484b0 b0Var = this.f9614g;
        if (b0Var != null) {
            b0Var.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    @Nullable
    /* renamed from: d */
    public C3484b0 mo19284d() {
        return this.f9614g;
    }

    /* renamed from: t */
    public C3495d mo19285t() {
        C3495d dVar = this.f9620m;
        if (dVar != null) {
            return dVar;
        }
        C3495d a = C3495d.m11602a(this.f9613f);
        this.f9620m = a;
        return a;
    }

    public String toString() {
        return "Response{protocol=" + this.f9609b + ", code=" + this.f9610c + ", message=" + this.f9611d + ", url=" + this.f9608a.mo19607g() + '}';
    }

    @Nullable
    /* renamed from: u */
    public C3480a0 mo19287u() {
        return this.f9616i;
    }

    /* renamed from: v */
    public int mo19288v() {
        return this.f9610c;
    }

    @Nullable
    /* renamed from: w */
    public C3536q mo19289w() {
        return this.f9612e;
    }

    /* renamed from: x */
    public C3537r mo19290x() {
        return this.f9613f;
    }

    /* renamed from: y */
    public boolean mo19291y() {
        int i = this.f9610c;
        return i >= 200 && i < 300;
    }

    /* renamed from: z */
    public String mo19292z() {
        return this.f9611d;
    }

    @Nullable
    /* renamed from: a */
    public String mo19279a(String str, @Nullable String str2) {
        String a = this.f9613f.mo19502a(str);
        return a != null ? a : str2;
    }
}
