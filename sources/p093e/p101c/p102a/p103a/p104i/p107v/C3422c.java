package p093e.p101c.p102a.p103a.p104i.p107v;

import com.google.android.datatransport.runtime.backends.C2994e;
import com.google.android.datatransport.runtime.backends.C3005m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3030s;
import com.google.android.datatransport.runtime.synchronization.C3031a;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import p093e.p101c.p102a.p103a.C3384h;
import p093e.p101c.p102a.p103a.p104i.C3400h;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.C3412q;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;

/* renamed from: e.c.a.a.i.v.c */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class C3422c implements C3424e {

    /* renamed from: f */
    private static final Logger f9516f = Logger.getLogger(C3412q.class.getName());

    /* renamed from: a */
    private final C3030s f9517a;

    /* renamed from: b */
    private final Executor f9518b;

    /* renamed from: c */
    private final C2994e f9519c;

    /* renamed from: d */
    private final C3435c f9520d;

    /* renamed from: e */
    private final C3031a f9521e;

    public C3422c(Executor executor, C2994e eVar, C3030s sVar, C3435c cVar, C3031a aVar) {
        this.f9518b = executor;
        this.f9519c = eVar;
        this.f9517a = sVar;
        this.f9520d = cVar;
        this.f9521e = aVar;
    }

    /* renamed from: a */
    public void mo19219a(C3406l lVar, C3400h hVar, C3384h hVar2) {
        this.f9518b.execute(C3420a.m11385a(this, lVar, hVar2, hVar));
    }

    /* renamed from: a */
    static /* synthetic */ void m11388a(C3422c cVar, C3406l lVar, C3384h hVar, C3400h hVar2) {
        try {
            C3005m mVar = cVar.f9519c.get(lVar.mo19184a());
            if (mVar == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{lVar.mo19184a()});
                f9516f.warning(format);
                hVar.mo19152a(new IllegalArgumentException(format));
                return;
            }
            cVar.f9521e.mo13006a(C3421b.m11386a(cVar, lVar, mVar.mo12944a(hVar2)));
            hVar.mo19152a((Exception) null);
        } catch (Exception e) {
            Logger logger = f9516f;
            logger.warning("Error scheduling event " + e.getMessage());
            hVar.mo19152a(e);
        }
    }

    /* renamed from: a */
    static /* synthetic */ Object m11387a(C3422c cVar, C3406l lVar, C3400h hVar) {
        cVar.f9520d.mo19241a(lVar, hVar);
        cVar.f9517a.mo12974a(lVar, 1);
        return null;
    }
}
