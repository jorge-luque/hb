package androidx.appcompat.p011d;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.p020f.C0851x;
import androidx.core.p020f.C0855y;
import androidx.core.p020f.C0856z;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.appcompat.d.h */
/* compiled from: ViewPropertyAnimatorCompatSet */
public class C0465h {

    /* renamed from: a */
    final ArrayList<C0851x> f703a = new ArrayList<>();

    /* renamed from: b */
    private long f704b = -1;

    /* renamed from: c */
    private Interpolator f705c;

    /* renamed from: d */
    C0855y f706d;

    /* renamed from: e */
    private boolean f707e;

    /* renamed from: f */
    private final C0856z f708f = new C0466a();

    /* renamed from: androidx.appcompat.d.h$a */
    /* compiled from: ViewPropertyAnimatorCompatSet */
    class C0466a extends C0856z {

        /* renamed from: a */
        private boolean f709a = false;

        /* renamed from: b */
        private int f710b = 0;

        C0466a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo2346a() {
            this.f710b = 0;
            this.f709a = false;
            C0465h.this.mo2344b();
        }

        /* renamed from: b */
        public void mo2086b(View view) {
            int i = this.f710b + 1;
            this.f710b = i;
            if (i == C0465h.this.f703a.size()) {
                C0855y yVar = C0465h.this.f706d;
                if (yVar != null) {
                    yVar.mo2086b((View) null);
                }
                mo2346a();
            }
        }

        /* renamed from: c */
        public void mo2087c(View view) {
            if (!this.f709a) {
                this.f709a = true;
                C0855y yVar = C0465h.this.f706d;
                if (yVar != null) {
                    yVar.mo2087c((View) null);
                }
            }
        }
    }

    /* renamed from: a */
    public C0465h mo2340a(C0851x xVar) {
        if (!this.f707e) {
            this.f703a.add(xVar);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2344b() {
        this.f707e = false;
    }

    /* renamed from: c */
    public void mo2345c() {
        if (!this.f707e) {
            Iterator<C0851x> it = this.f703a.iterator();
            while (it.hasNext()) {
                C0851x next = it.next();
                long j = this.f704b;
                if (j >= 0) {
                    next.mo4207a(j);
                }
                Interpolator interpolator = this.f705c;
                if (interpolator != null) {
                    next.mo4208a(interpolator);
                }
                if (this.f706d != null) {
                    next.mo4210a((C0855y) this.f708f);
                }
                next.mo4215c();
            }
            this.f707e = true;
        }
    }

    /* renamed from: a */
    public C0465h mo2341a(C0851x xVar, C0851x xVar2) {
        this.f703a.add(xVar);
        xVar2.mo4214b(xVar.mo4212b());
        this.f703a.add(xVar2);
        return this;
    }

    /* renamed from: a */
    public void mo2343a() {
        if (this.f707e) {
            Iterator<C0851x> it = this.f703a.iterator();
            while (it.hasNext()) {
                it.next().mo4211a();
            }
            this.f707e = false;
        }
    }

    /* renamed from: a */
    public C0465h mo2338a(long j) {
        if (!this.f707e) {
            this.f704b = j;
        }
        return this;
    }

    /* renamed from: a */
    public C0465h mo2339a(Interpolator interpolator) {
        if (!this.f707e) {
            this.f705c = interpolator;
        }
        return this;
    }

    /* renamed from: a */
    public C0465h mo2342a(C0855y yVar) {
        if (!this.f707e) {
            this.f706d = yVar;
        }
        return this;
    }
}
