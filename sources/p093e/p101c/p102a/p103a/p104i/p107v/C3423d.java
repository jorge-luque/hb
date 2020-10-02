package p093e.p101c.p102a.p103a.p104i.p107v;

import com.google.android.datatransport.runtime.backends.C2994e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3030s;
import com.google.android.datatransport.runtime.synchronization.C3031a;
import java.util.concurrent.Executor;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;
import p188f.p189a.C5913b;
import p193h.p194a.C5925a;

/* renamed from: e.c.a.a.i.v.d */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3423d implements C5913b<C3422c> {

    /* renamed from: a */
    private final C5925a<Executor> f9522a;

    /* renamed from: b */
    private final C5925a<C2994e> f9523b;

    /* renamed from: c */
    private final C5925a<C3030s> f9524c;

    /* renamed from: d */
    private final C5925a<C3435c> f9525d;

    /* renamed from: e */
    private final C5925a<C3031a> f9526e;

    public C3423d(C5925a<Executor> aVar, C5925a<C2994e> aVar2, C5925a<C3030s> aVar3, C5925a<C3435c> aVar4, C5925a<C3031a> aVar5) {
        this.f9522a = aVar;
        this.f9523b = aVar2;
        this.f9524c = aVar3;
        this.f9525d = aVar4;
        this.f9526e = aVar5;
    }

    /* renamed from: a */
    public static C3423d m11390a(C5925a<Executor> aVar, C5925a<C2994e> aVar2, C5925a<C3030s> aVar3, C5925a<C3435c> aVar4, C5925a<C3031a> aVar5) {
        return new C3423d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public C3422c get() {
        return new C3422c(this.f9522a.get(), this.f9523b.get(), this.f9524c.get(), this.f9525d.get(), this.f9526e.get());
    }
}
