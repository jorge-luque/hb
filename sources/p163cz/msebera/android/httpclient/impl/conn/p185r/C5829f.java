package p163cz.msebera.android.httpclient.impl.conn.p185r;

import java.util.LinkedList;
import java.util.Queue;
import p163cz.msebera.android.httpclient.conn.p173q.C5641b;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.r.f */
/* compiled from: RouteSpecificPool */
public class C5829f {

    /* renamed from: a */
    public C5695b f15050a = new C5695b(C5829f.class);

    /* renamed from: b */
    protected final C5645b f15051b;

    /* renamed from: c */
    protected final int f15052c;

    /* renamed from: d */
    protected final C5641b f15053d;

    /* renamed from: e */
    protected final LinkedList<C5824b> f15054e;

    /* renamed from: f */
    protected final Queue<C5832h> f15055f;

    /* renamed from: g */
    protected int f15056g;

    public C5829f(C5645b bVar, C5641b bVar2) {
        this.f15051b = bVar;
        this.f15053d = bVar2;
        this.f15052c = bVar2.mo33047a(bVar);
        this.f15054e = new LinkedList<>();
        this.f15055f = new LinkedList();
        this.f15056g = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0018  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p163cz.msebera.android.httpclient.impl.conn.p185r.C5824b mo33592a(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.LinkedList<cz.msebera.android.httpclient.impl.conn.r.b> r0 = r3.f15054e
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0032
            java.util.LinkedList<cz.msebera.android.httpclient.impl.conn.r.b> r0 = r3.f15054e
            int r1 = r0.size()
            java.util.ListIterator r0 = r0.listIterator(r1)
        L_0x0012:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.previous()
            cz.msebera.android.httpclient.impl.conn.r.b r1 = (p163cz.msebera.android.httpclient.impl.conn.p185r.C5824b) r1
            java.lang.Object r2 = r1.mo33541a()
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r1.mo33541a()
            boolean r2 = p163cz.msebera.android.httpclient.p187k0.C5893h.m18940a((java.lang.Object) r4, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0012
        L_0x002e:
            r0.remove()
            return r1
        L_0x0032:
            int r4 = r3.mo33596b()
            if (r4 != 0) goto L_0x005c
            java.util.LinkedList<cz.msebera.android.httpclient.impl.conn.r.b> r4 = r3.f15054e
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x005c
            java.util.LinkedList<cz.msebera.android.httpclient.impl.conn.r.b> r4 = r3.f15054e
            java.lang.Object r4 = r4.remove()
            cz.msebera.android.httpclient.impl.conn.r.b r4 = (p163cz.msebera.android.httpclient.impl.conn.p185r.C5824b) r4
            r4.mo33546b()
            cz.msebera.android.httpclient.conn.o r0 = r4.mo33573c()
            r0.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x005b
        L_0x0053:
            r0 = move-exception
            cz.msebera.android.httpclient.d0.b r1 = r3.f15050a
            java.lang.String r2 = "I/O error closing connection"
            r1.mo33167a(r2, r0)
        L_0x005b:
            return r4
        L_0x005c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.conn.p185r.C5829f.mo33592a(java.lang.Object):cz.msebera.android.httpclient.impl.conn.r.b");
    }

    /* renamed from: b */
    public int mo33596b() {
        return this.f15053d.mo33047a(this.f15051b) - this.f15056g;
    }

    /* renamed from: c */
    public final int mo33599c() {
        return this.f15052c;
    }

    /* renamed from: d */
    public final C5645b mo33601d() {
        return this.f15051b;
    }

    /* renamed from: e */
    public boolean mo33602e() {
        return !this.f15055f.isEmpty();
    }

    /* renamed from: f */
    public boolean mo33603f() {
        return this.f15056g < 1 && this.f15055f.isEmpty();
    }

    /* renamed from: g */
    public C5832h mo33604g() {
        return this.f15055f.peek();
    }

    /* renamed from: b */
    public boolean mo33598b(C5824b bVar) {
        boolean remove = this.f15054e.remove(bVar);
        if (remove) {
            this.f15056g--;
        }
        return remove;
    }

    /* renamed from: c */
    public void mo33600c(C5824b bVar) {
        int i = this.f15056g;
        if (i < 1) {
            throw new IllegalStateException("No entry created for this pool. " + this.f15051b);
        } else if (i > this.f15054e.size()) {
            this.f15054e.add(bVar);
        } else {
            throw new IllegalStateException("No entry allocated from this pool. " + this.f15051b);
        }
    }

    /* renamed from: b */
    public void mo33597b(C5832h hVar) {
        if (hVar != null) {
            this.f15055f.remove(hVar);
        }
    }

    /* renamed from: a */
    public void mo33594a(C5824b bVar) {
        C5886a.m18896a(this.f15051b.equals(bVar.mo33574d()), "Entry not planned for this pool");
        this.f15056g++;
    }

    /* renamed from: a */
    public void mo33593a() {
        C5887b.m18902a(this.f15056g > 0, "There is no entry that could be dropped");
        this.f15056g--;
    }

    /* renamed from: a */
    public void mo33595a(C5832h hVar) {
        C5886a.m18894a(hVar, "Waiting thread");
        this.f15055f.add(hVar);
    }
}
