package p163cz.msebera.android.httpclient.conn.p174r;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.conn.p174r.C5648e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

/* renamed from: cz.msebera.android.httpclient.conn.r.b */
/* compiled from: HttpRoute */
public final class C5645b implements C5648e, Cloneable {

    /* renamed from: a */
    private final C5896l f14636a;

    /* renamed from: b */
    private final InetAddress f14637b;

    /* renamed from: c */
    private final List<C5896l> f14638c;

    /* renamed from: d */
    private final C5648e.C5650b f14639d;

    /* renamed from: e */
    private final C5648e.C5649a f14640e;

    /* renamed from: f */
    private final boolean f14641f;

    private C5645b(C5896l lVar, InetAddress inetAddress, List<C5896l> list, boolean z, C5648e.C5650b bVar, C5648e.C5649a aVar) {
        C5886a.m18894a(lVar, "Target host");
        this.f14636a = m17976a(lVar);
        this.f14637b = inetAddress;
        if (list == null || list.isEmpty()) {
            this.f14638c = null;
        } else {
            this.f14638c = new ArrayList(list);
        }
        if (bVar == C5648e.C5650b.TUNNELLED) {
            C5886a.m18896a(this.f14638c != null, "Proxy required if tunnelled");
        }
        this.f14641f = z;
        this.f14639d = bVar == null ? C5648e.C5650b.PLAIN : bVar;
        this.f14640e = aVar == null ? C5648e.C5649a.PLAIN : aVar;
    }

    /* renamed from: a */
    private static int m17975a(String str) {
        if ("http".equalsIgnoreCase(str)) {
            return 80;
        }
        return "https".equalsIgnoreCase(str) ? 443 : -1;
    }

    /* renamed from: B */
    public final boolean mo33054B() {
        return this.f14641f;
    }

    /* renamed from: b */
    public final boolean mo33057b() {
        return this.f14639d == C5648e.C5650b.TUNNELLED;
    }

    /* renamed from: c */
    public final C5896l mo33058c() {
        List<C5896l> list = this.f14638c;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f14638c.get(0);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* renamed from: d */
    public final InetAddress mo33060d() {
        return this.f14637b;
    }

    /* renamed from: e */
    public final C5896l mo33061e() {
        return this.f14636a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5645b)) {
            return false;
        }
        C5645b bVar = (C5645b) obj;
        if (this.f14641f != bVar.f14641f || this.f14639d != bVar.f14639d || this.f14640e != bVar.f14640e || !C5893h.m18940a((Object) this.f14636a, (Object) bVar.f14636a) || !C5893h.m18940a((Object) this.f14637b, (Object) bVar.f14637b) || !C5893h.m18940a((Object) this.f14638c, (Object) bVar.f14638c)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final boolean mo33063f() {
        return this.f14640e == C5648e.C5649a.LAYERED;
    }

    public final int hashCode() {
        int a = C5893h.m18938a(C5893h.m18938a(17, (Object) this.f14636a), (Object) this.f14637b);
        List<C5896l> list = this.f14638c;
        if (list != null) {
            for (C5896l a2 : list) {
                a = C5893h.m18938a(a, (Object) a2);
            }
        }
        return C5893h.m18938a(C5893h.m18938a(C5893h.m18939a(a, this.f14641f), (Object) this.f14639d), (Object) this.f14640e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((mo33055a() * 30) + 50);
        InetAddress inetAddress = this.f14637b;
        if (inetAddress != null) {
            sb.append(inetAddress);
            sb.append("->");
        }
        sb.append('{');
        if (this.f14639d == C5648e.C5650b.TUNNELLED) {
            sb.append('t');
        }
        if (this.f14640e == C5648e.C5649a.LAYERED) {
            sb.append('l');
        }
        if (this.f14641f) {
            sb.append('s');
        }
        sb.append("}->");
        List<C5896l> list = this.f14638c;
        if (list != null) {
            for (C5896l append : list) {
                sb.append(append);
                sb.append("->");
            }
        }
        sb.append(this.f14636a);
        return sb.toString();
    }

    /* renamed from: a */
    private static C5896l m17976a(C5896l lVar) {
        if (lVar.mo33686c() >= 0) {
            return lVar;
        }
        InetAddress a = lVar.mo33684a();
        String d = lVar.mo33688d();
        if (a != null) {
            return new C5896l(a, m17975a(d), d);
        }
        return new C5896l(lVar.mo33685b(), m17975a(d), d);
    }

    /* renamed from: a */
    public final int mo33055a() {
        List<C5896l> list = this.f14638c;
        if (list != null) {
            return 1 + list.size();
        }
        return 1;
    }

    /* renamed from: a */
    public final C5896l mo33056a(int i) {
        C5886a.m18891a(i, "Hop index");
        int a = mo33055a();
        C5886a.m18896a(i < a, "Hop index exceeds tracked route length");
        if (i < a - 1) {
            return this.f14638c.get(i);
        }
        return this.f14636a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C5645b(C5896l lVar, InetAddress inetAddress, C5896l[] lVarArr, boolean z, C5648e.C5650b bVar, C5648e.C5649a aVar) {
        this(lVar, inetAddress, (List<C5896l>) lVarArr != null ? Arrays.asList(lVarArr) : null, z, bVar, aVar);
    }

    public C5645b(C5896l lVar, InetAddress inetAddress, boolean z) {
        this(lVar, inetAddress, (List<C5896l>) Collections.emptyList(), z, C5648e.C5650b.PLAIN, C5648e.C5649a.PLAIN);
    }

    public C5645b(C5896l lVar) {
        this(lVar, (InetAddress) null, (List<C5896l>) Collections.emptyList(), false, C5648e.C5650b.PLAIN, C5648e.C5649a.PLAIN);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C5645b(C5896l lVar, InetAddress inetAddress, C5896l lVar2, boolean z) {
        this(lVar, inetAddress, (List<C5896l>) Collections.singletonList(lVar2), z, z ? C5648e.C5650b.TUNNELLED : C5648e.C5650b.PLAIN, z ? C5648e.C5649a.LAYERED : C5648e.C5649a.PLAIN);
        C5886a.m18894a(lVar2, "Proxy host");
    }
}
