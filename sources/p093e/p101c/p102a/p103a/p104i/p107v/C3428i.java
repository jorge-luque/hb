package p093e.p101c.p102a.p103a.p104i.p107v;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3014g;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C3030s;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3435c;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;
import p188f.p189a.C5913b;
import p188f.p189a.C5915d;
import p193h.p194a.C5925a;

/* renamed from: e.c.a.a.i.v.i */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3428i implements C5913b<C3030s> {

    /* renamed from: a */
    private final C5925a<Context> f9528a;

    /* renamed from: b */
    private final C5925a<C3435c> f9529b;

    /* renamed from: c */
    private final C5925a<C3014g> f9530c;

    /* renamed from: d */
    private final C5925a<C3469a> f9531d;

    public C3428i(C5925a<Context> aVar, C5925a<C3435c> aVar2, C5925a<C3014g> aVar3, C5925a<C3469a> aVar4) {
        this.f9528a = aVar;
        this.f9529b = aVar2;
        this.f9530c = aVar3;
        this.f9531d = aVar4;
    }

    /* renamed from: a */
    public static C3428i m11397a(C5925a<Context> aVar, C5925a<C3435c> aVar2, C5925a<C3014g> aVar3, C5925a<C3469a> aVar4) {
        return new C3428i(aVar, aVar2, aVar3, aVar4);
    }

    /* renamed from: a */
    public static C3030s m11396a(Context context, C3435c cVar, C3014g gVar, C3469a aVar) {
        C3030s a = C3427h.m11395a(context, cVar, gVar, aVar);
        C5915d.m18981a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public C3030s get() {
        return m11396a(this.f9528a.get(), this.f9529b.get(), this.f9530c.get(), this.f9531d.get());
    }
}
