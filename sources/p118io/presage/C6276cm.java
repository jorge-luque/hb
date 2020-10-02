package p118io.presage;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedList;
import java.util.List;

/* renamed from: io.presage.cm */
public final class C6276cm {

    /* renamed from: a */
    private final List<C6275cl> f16907a;

    /* renamed from: b */
    private final C6270cg f16908b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f16909c;

    /* renamed from: d */
    private int f16910d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f16911e;

    /* renamed from: f */
    private Handler f16912f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C6272ci f16913g;

    /* renamed from: h */
    private C6264ca f16914h;

    /* renamed from: i */
    private final C6273cj f16915i;

    /* renamed from: io.presage.cm$CamembertdeNormandie */
    static final class CamembertdeNormandie implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C6276cm f16917a;

        CamembertdeNormandie(C6276cm cmVar) {
            this.f16917a = cmVar;
        }

        public final void run() {
            this.f16917a.m21110j();
        }
    }

    public /* synthetic */ C6276cm() {
        this(new C6273cj());
    }

    /* renamed from: i */
    private final void m21109i() {
        this.f16912f.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public final void m21110j() {
        if (m21112l()) {
            m21111k();
            m21105g();
            return;
        }
        m21113m();
        C6264ca caVar = this.f16914h;
        if (caVar != null) {
            caVar.mo34443b();
        }
    }

    /* renamed from: k */
    private final void m21111k() {
        for (C6275cl next : this.f16907a) {
            if (next instanceof C6271ch) {
                next.mo34864b();
            }
        }
    }

    /* renamed from: l */
    private final boolean m21112l() {
        for (C6275cl next : this.f16907a) {
            if (!next.mo34863a() && !(next instanceof C6271ch)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: m */
    private final void m21113m() {
        for (C6275cl b : this.f16907a) {
            b.mo34864b();
        }
    }

    private C6276cm(C6273cj cjVar) {
        this.f16915i = cjVar;
        this.f16907a = new LinkedList();
        this.f16908b = m21097c();
        this.f16912f = new Handler(Looper.getMainLooper());
    }

    /* renamed from: c */
    private final C6270cg m21097c() {
        return new CamembertauCalvados(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m21099d() {
        if (m21104f()) {
            m21107h();
        } else if (m21101e()) {
            m21105g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final boolean m21101e() {
        return this.f16909c == this.f16907a.size();
    }

    /* renamed from: f */
    private final boolean m21104f() {
        return this.f16910d == 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void m21105g() {
        this.f16907a.clear();
        m21109i();
        C6264ca caVar = this.f16914h;
        if (caVar != null) {
            caVar.mo34441a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final void m21107h() {
        m21109i();
        this.f16911e = true;
        C6264ca caVar = this.f16914h;
        if (caVar != null) {
            caVar.mo34443b();
        }
    }

    /* renamed from: b */
    public final void mo34874b() {
        m21109i();
        m21113m();
        this.f16907a.clear();
        this.f16909c = 0;
        this.f16911e = false;
    }

    /* renamed from: a */
    public final C6264ca mo34870a() {
        return this.f16914h;
    }

    /* renamed from: io.presage.cm$CamembertauCalvados */
    public static final class CamembertauCalvados implements C6270cg {

        /* renamed from: a */
        final /* synthetic */ C6276cm f16916a;

        CamembertauCalvados(C6276cm cmVar) {
            this.f16916a = cmVar;
        }

        /* renamed from: a */
        public final void mo34868a(PontlEveque pontlEveque) {
            C6264ca a = this.f16916a.mo34870a();
            if (a != null) {
                a.mo34442a(pontlEveque);
            }
            C6276cm cmVar = this.f16916a;
            cmVar.f16909c = cmVar.f16909c + 1;
            C6272ci b = this.f16916a.f16913g;
            if (b != null) {
                b.mo34860a();
            }
            this.f16916a.m21099d();
        }

        /* renamed from: b */
        public final void mo34869b() {
            this.f16916a.m21107h();
        }

        /* renamed from: a */
        public final void mo34867a() {
            C6276cm cmVar = this.f16916a;
            cmVar.f16909c = cmVar.f16909c + 1;
            C6272ci b = this.f16916a.f16913g;
            if (b != null) {
                b.mo34860a();
            }
            if (this.f16916a.m21101e() && !this.f16916a.f16911e) {
                this.f16916a.m21105g();
            }
        }
    }

    /* renamed from: a */
    public final void mo34871a(C6264ca caVar) {
        this.f16914h = caVar;
    }

    /* renamed from: a */
    public final void mo34873a(C6275cl clVar) {
        this.f16907a.add(clVar);
    }

    /* renamed from: a */
    public final void mo34872a(C6267cd cdVar, long j, int i) {
        this.f16910d = i;
        C6272ci a = C6273cj.m21086a(this.f16908b, cdVar);
        this.f16913g = a;
        if (a != null) {
            a.mo34861a(this.f16907a);
        }
        m21094a(j);
    }

    /* renamed from: a */
    private final void m21094a(long j) {
        this.f16912f.postDelayed(new CamembertdeNormandie(this), j);
    }
}
