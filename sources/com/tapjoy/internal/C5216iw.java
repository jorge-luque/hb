package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.iw */
final class C5216iw implements C5210is {

    /* renamed from: a */
    public final C5209ir f14322a = new C5209ir();

    /* renamed from: b */
    public final C5222jb f14323b;

    /* renamed from: c */
    boolean f14324c;

    C5216iw(C5222jb jbVar) {
        if (jbVar != null) {
            this.f14323b = jbVar;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    public final void mo31393a(C5209ir irVar, long j) {
        if (!this.f14324c) {
            this.f14322a.mo31393a(irVar, j);
            m17528b();
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public final C5210is mo31396b(C5212iu iuVar) {
        if (!this.f14324c) {
            this.f14322a.mo31396b(iuVar);
            return m17528b();
        }
        throw new IllegalStateException("closed");
    }

    public final void close() {
        if (!this.f14324c) {
            Throwable th = null;
            try {
                if (this.f14322a.f14311b > 0) {
                    this.f14323b.mo31393a(this.f14322a, this.f14322a.f14311b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f14323b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f14324c = true;
            if (th != null) {
                C5226je.m17568a(th);
            }
        }
    }

    /* renamed from: d */
    public final C5210is mo31406d(int i) {
        if (!this.f14324c) {
            this.f14322a.mo31406d(i);
            return m17528b();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: e */
    public final C5210is mo31410e(int i) {
        if (!this.f14324c) {
            this.f14322a.mo31410e(i);
            return m17528b();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: f */
    public final C5210is mo31413f(long j) {
        if (!this.f14324c) {
            this.f14322a.mo31413f(j);
            return m17528b();
        }
        throw new IllegalStateException("closed");
    }

    public final void flush() {
        if (!this.f14324c) {
            C5209ir irVar = this.f14322a;
            long j = irVar.f14311b;
            if (j > 0) {
                this.f14323b.mo31393a(irVar, j);
            }
            this.f14323b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final String toString() {
        return "buffer(" + this.f14323b + ")";
    }

    /* renamed from: a */
    public final C5210is mo31391a() {
        if (!this.f14324c) {
            C5209ir irVar = this.f14322a;
            long j = irVar.f14311b;
            if (j > 0) {
                this.f14323b.mo31393a(irVar, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public final C5210is mo31397b(String str) {
        if (!this.f14324c) {
            this.f14322a.mo31397b(str);
            return m17528b();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    private C5210is m17528b() {
        if (!this.f14324c) {
            C5209ir irVar = this.f14322a;
            long j = irVar.f14311b;
            if (j == 0) {
                j = 0;
            } else {
                C5218iy iyVar = irVar.f14310a.f14334g;
                int i = iyVar.f14330c;
                if (i < 8192 && iyVar.f14332e) {
                    j -= (long) (i - iyVar.f14329b);
                }
            }
            if (j > 0) {
                this.f14323b.mo31393a(this.f14322a, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
