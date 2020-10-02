package p093e.p101c.p102a.p103a.p104i;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.C3001j;
import com.google.android.datatransport.runtime.backends.C3004l;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3014g;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3024m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3025n;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3028q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3029r;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3030s;
import java.util.concurrent.Executor;
import p093e.p101c.p102a.p103a.p104i.C3413r;
import p093e.p101c.p102a.p103a.p104i.p107v.C3422c;
import p093e.p101c.p102a.p103a.p104i.p107v.C3423d;
import p093e.p101c.p102a.p103a.p104i.p107v.C3426g;
import p093e.p101c.p102a.p103a.p104i.p107v.C3428i;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3432a0;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3443f;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3444f0;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3445g;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3464z;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;
import p093e.p101c.p102a.p103a.p104i.p109w.C3471c;
import p093e.p101c.p102a.p103a.p104i.p109w.C3472d;
import p188f.p189a.C5912a;
import p188f.p189a.C5913b;
import p188f.p189a.C5914c;
import p188f.p189a.C5915d;
import p193h.p194a.C5925a;

/* renamed from: e.c.a.a.i.d */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3394d extends C3413r {

    /* renamed from: a */
    private C5925a<Executor> f9474a;

    /* renamed from: b */
    private C5925a<Context> f9475b;

    /* renamed from: c */
    private C5925a f9476c;

    /* renamed from: d */
    private C5925a f9477d;

    /* renamed from: e */
    private C5925a f9478e;

    /* renamed from: f */
    private C5925a<C3464z> f9479f;

    /* renamed from: g */
    private C5925a<C3014g> f9480g;

    /* renamed from: h */
    private C5925a<C3030s> f9481h;

    /* renamed from: i */
    private C5925a<C3422c> f9482i;

    /* renamed from: j */
    private C5925a<C3024m> f9483j;

    /* renamed from: k */
    private C5925a<C3028q> f9484k;

    /* renamed from: l */
    private C5925a<C3412q> f9485l;

    /* renamed from: e.c.a.a.i.d$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    private static final class C3396b implements C3413r.C3414a {

        /* renamed from: a */
        private Context f9486a;

        private C3396b() {
        }

        public C3413r build() {
            C5915d.m18982a(this.f9486a, Context.class);
            return new C3394d(this.f9486a);
        }

        /* renamed from: a */
        public C3396b mo19195a(Context context) {
            C5915d.m18980a(context);
            this.f9486a = context;
            return this;
        }
    }

    /* renamed from: a */
    private void m11302a(Context context) {
        this.f9474a = C5912a.m18977a(C3403j.m11335a());
        C5913b a = C5914c.m18979a(context);
        this.f9475b = a;
        C3001j a2 = C3001j.m9878a(a, C3471c.m11517a(), C3472d.m11519a());
        this.f9476c = a2;
        this.f9477d = C5912a.m18977a(C3004l.m9883a(this.f9475b, a2));
        this.f9478e = C3444f0.m11446a(this.f9475b, C3443f.m11444a());
        this.f9479f = C5912a.m18977a(C3432a0.m11407a(C3471c.m11517a(), C3472d.m11519a(), C3445g.m11447a(), this.f9478e));
        C3426g a3 = C3426g.m11394a((C5925a<C3469a>) C3471c.m11517a());
        this.f9480g = a3;
        C3428i a4 = C3428i.m11397a(this.f9475b, (C5925a<C3435c>) this.f9479f, (C5925a<C3014g>) a3, (C5925a<C3469a>) C3472d.m11519a());
        this.f9481h = a4;
        C5925a<Executor> aVar = this.f9474a;
        C5925a aVar2 = this.f9477d;
        C5925a<C3464z> aVar3 = this.f9479f;
        this.f9482i = C3423d.m11390a(aVar, aVar2, a4, aVar3, aVar3);
        C5925a<Context> aVar4 = this.f9475b;
        C5925a aVar5 = this.f9477d;
        C5925a<C3464z> aVar6 = this.f9479f;
        this.f9483j = C3025n.m9936a(aVar4, aVar5, aVar6, this.f9481h, this.f9474a, aVar6, C3471c.m11517a());
        C5925a<Executor> aVar7 = this.f9474a;
        C5925a<C3464z> aVar8 = this.f9479f;
        this.f9484k = C3029r.m9942a(aVar7, aVar8, this.f9481h, aVar8);
        this.f9485l = C5912a.m18977a(C3415s.m11376a(C3471c.m11517a(), C3472d.m11519a(), this.f9482i, this.f9483j, this.f9484k));
    }

    /* renamed from: u */
    public static C3413r.C3414a m11303u() {
        return new C3396b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C3435c mo19193d() {
        return this.f9479f.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public C3412q mo19194t() {
        return this.f9485l.get();
    }

    private C3394d(Context context) {
        m11302a(context);
    }
}
