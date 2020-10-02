package p093e.p101c.p102a.p103a.p104i;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3024m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3028q;
import java.util.Collections;
import java.util.Set;
import p093e.p101c.p102a.p103a.C3378b;
import p093e.p101c.p102a.p103a.C3383g;
import p093e.p101c.p102a.p103a.C3384h;
import p093e.p101c.p102a.p103a.p104i.C3400h;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.C3413r;
import p093e.p101c.p102a.p103a.p104i.p107v.C3424e;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;

/* renamed from: e.c.a.a.i.q */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class C3412q implements C3411p {

    /* renamed from: e */
    private static volatile C3413r f9499e;

    /* renamed from: a */
    private final C3469a f9500a;

    /* renamed from: b */
    private final C3469a f9501b;

    /* renamed from: c */
    private final C3424e f9502c;

    /* renamed from: d */
    private final C3024m f9503d;

    C3412q(C3469a aVar, C3469a aVar2, C3424e eVar, C3024m mVar, C3028q qVar) {
        this.f9500a = aVar;
        this.f9501b = aVar2;
        this.f9502c = eVar;
        this.f9503d = mVar;
        qVar.mo13005a();
    }

    /* renamed from: a */
    public static void m11367a(Context context) {
        if (f9499e == null) {
            synchronized (C3412q.class) {
                if (f9499e == null) {
                    C3413r.C3414a u = C3394d.m11303u();
                    u.mo19195a(context);
                    f9499e = u.build();
                }
            }
        }
    }

    /* renamed from: b */
    public static C3412q m11368b() {
        C3413r rVar = f9499e;
        if (rVar != null) {
            return rVar.mo19194t();
        }
        throw new IllegalStateException("Not initialized!");
    }

    /* renamed from: b */
    private static Set<C3378b> m11369b(C3397e eVar) {
        if (eVar instanceof C3398f) {
            return Collections.unmodifiableSet(((C3398f) eVar).mo12851a());
        }
        return Collections.singleton(C3378b.m11260a("proto"));
    }

    /* renamed from: a */
    public C3383g mo19216a(C3397e eVar) {
        Set<C3378b> b = m11369b(eVar);
        C3406l.C3407a d = C3406l.m11350d();
        d.mo19190a(eVar.getName());
        d.mo19191a(eVar.getExtras());
        return new C3408m(b, d.mo19192a(), this);
    }

    /* renamed from: a */
    public C3024m mo19215a() {
        return this.f9503d;
    }

    /* renamed from: a */
    public void mo19214a(C3404k kVar, C3384h hVar) {
        this.f9502c.mo19219a(kVar.mo19173e().mo19211a(kVar.mo19171b().mo19141c()), m11366a(kVar), hVar);
    }

    /* renamed from: a */
    private C3400h m11366a(C3404k kVar) {
        C3400h.C3401a i = C3400h.m11311i();
        i.mo19162a(this.f9500a.mo19256a());
        i.mo19168b(this.f9501b.mo19256a());
        i.mo19165a(kVar.mo19175f());
        i.mo19163a(new C3399g(kVar.mo19170a(), kVar.mo19210c()));
        i.mo19164a(kVar.mo19171b().mo19139a());
        return i.mo19167a();
    }
}
