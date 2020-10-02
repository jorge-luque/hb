package p163cz.msebera.android.httpclient.conn.p174r;

import java.net.InetAddress;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.conn.p174r.C5648e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

/* renamed from: cz.msebera.android.httpclient.conn.r.f */
/* compiled from: RouteTracker */
public final class C5651f implements C5648e, Cloneable {

    /* renamed from: a */
    private final C5896l f14646a;

    /* renamed from: b */
    private final InetAddress f14647b;

    /* renamed from: c */
    private boolean f14648c;

    /* renamed from: d */
    private C5896l[] f14649d;

    /* renamed from: e */
    private C5648e.C5650b f14650e;

    /* renamed from: f */
    private C5648e.C5649a f14651f;

    /* renamed from: g */
    private boolean f14652g;

    public C5651f(C5896l lVar, InetAddress inetAddress) {
        C5886a.m18894a(lVar, "Target host");
        this.f14646a = lVar;
        this.f14647b = inetAddress;
        this.f14650e = C5648e.C5650b.PLAIN;
        this.f14651f = C5648e.C5649a.PLAIN;
    }

    /* renamed from: B */
    public final boolean mo33054B() {
        return this.f14652g;
    }

    /* renamed from: a */
    public final void mo33068a(boolean z) {
        C5887b.m18902a(!this.f14648c, "Already connected");
        this.f14648c = true;
        this.f14652g = z;
    }

    /* renamed from: b */
    public final void mo33069b(boolean z) {
        C5887b.m18902a(this.f14648c, "No layered protocol unless connected");
        this.f14651f = C5648e.C5649a.LAYERED;
        this.f14652g = z;
    }

    /* renamed from: c */
    public final void mo33070c(boolean z) {
        C5887b.m18902a(this.f14648c, "No tunnel unless connected");
        C5887b.m18901a((Object) this.f14649d, "No tunnel without proxy");
        this.f14650e = C5648e.C5650b.TUNNELLED;
        this.f14652g = z;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* renamed from: d */
    public final InetAddress mo33060d() {
        return this.f14647b;
    }

    /* renamed from: e */
    public final C5896l mo33061e() {
        return this.f14646a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5651f)) {
            return false;
        }
        C5651f fVar = (C5651f) obj;
        if (this.f14648c == fVar.f14648c && this.f14652g == fVar.f14652g && this.f14650e == fVar.f14650e && this.f14651f == fVar.f14651f && C5893h.m18940a((Object) this.f14646a, (Object) fVar.f14646a) && C5893h.m18940a((Object) this.f14647b, (Object) fVar.f14647b) && C5893h.m18941a((Object[]) this.f14649d, (Object[]) fVar.f14649d)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public final boolean mo33063f() {
        return this.f14651f == C5648e.C5649a.LAYERED;
    }

    /* renamed from: g */
    public final boolean mo33073g() {
        return this.f14648c;
    }

    /* renamed from: h */
    public void mo33074h() {
        this.f14648c = false;
        this.f14649d = null;
        this.f14650e = C5648e.C5650b.PLAIN;
        this.f14651f = C5648e.C5649a.PLAIN;
        this.f14652g = false;
    }

    public final int hashCode() {
        int a = C5893h.m18938a(C5893h.m18938a(17, (Object) this.f14646a), (Object) this.f14647b);
        C5896l[] lVarArr = this.f14649d;
        if (lVarArr != null) {
            for (C5896l a2 : lVarArr) {
                a = C5893h.m18938a(a, (Object) a2);
            }
        }
        return C5893h.m18938a(C5893h.m18938a(C5893h.m18939a(C5893h.m18939a(a, this.f14648c), this.f14652g), (Object) this.f14650e), (Object) this.f14651f);
    }

    /* renamed from: i */
    public final C5645b mo33076i() {
        if (!this.f14648c) {
            return null;
        }
        return new C5645b(this.f14646a, this.f14647b, this.f14649d, this.f14652g, this.f14650e, this.f14651f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((mo33055a() * 30) + 50);
        sb.append("RouteTracker[");
        InetAddress inetAddress = this.f14647b;
        if (inetAddress != null) {
            sb.append(inetAddress);
            sb.append("->");
        }
        sb.append('{');
        if (this.f14648c) {
            sb.append('c');
        }
        if (this.f14650e == C5648e.C5650b.TUNNELLED) {
            sb.append('t');
        }
        if (this.f14651f == C5648e.C5649a.LAYERED) {
            sb.append('l');
        }
        if (this.f14652g) {
            sb.append('s');
        }
        sb.append("}->");
        C5896l[] lVarArr = this.f14649d;
        if (lVarArr != null) {
            for (C5896l append : lVarArr) {
                sb.append(append);
                sb.append("->");
            }
        }
        sb.append(this.f14646a);
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo33067a(C5896l lVar, boolean z) {
        C5886a.m18894a(lVar, "Proxy host");
        C5887b.m18902a(!this.f14648c, "Already connected");
        this.f14648c = true;
        this.f14649d = new C5896l[]{lVar};
        this.f14652g = z;
    }

    /* renamed from: b */
    public final boolean mo33057b() {
        return this.f14650e == C5648e.C5650b.TUNNELLED;
    }

    /* renamed from: c */
    public final C5896l mo33058c() {
        C5896l[] lVarArr = this.f14649d;
        if (lVarArr == null) {
            return null;
        }
        return lVarArr[0];
    }

    public C5651f(C5645b bVar) {
        this(bVar.mo33061e(), bVar.mo33060d());
    }

    /* renamed from: a */
    public final int mo33055a() {
        if (!this.f14648c) {
            return 0;
        }
        C5896l[] lVarArr = this.f14649d;
        if (lVarArr == null) {
            return 1;
        }
        return 1 + lVarArr.length;
    }

    /* renamed from: a */
    public final C5896l mo33056a(int i) {
        C5886a.m18891a(i, "Hop index");
        int a = mo33055a();
        C5886a.m18896a(i < a, "Hop index exceeds tracked route length");
        if (i < a - 1) {
            return this.f14649d[i];
        }
        return this.f14646a;
    }
}
