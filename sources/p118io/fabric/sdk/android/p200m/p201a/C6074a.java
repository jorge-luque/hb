package p118io.fabric.sdk.android.p200m.p201a;

import android.content.Context;

/* renamed from: io.fabric.sdk.android.m.a.a */
/* compiled from: AbstractValueCache */
public abstract class C6074a<T> implements C6076c<T> {

    /* renamed from: a */
    private final C6076c<T> f16004a;

    public C6074a(C6076c<T> cVar) {
        this.f16004a = cVar;
    }

    /* renamed from: b */
    private void m19683b(Context context, T t) {
        if (t != null) {
            mo34146a(context, t);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo34144a(Context context);

    /* renamed from: a */
    public final synchronized T mo34145a(Context context, C6077d<T> dVar) throws Exception {
        T a;
        a = mo34144a(context);
        if (a == null) {
            a = this.f16004a != null ? this.f16004a.mo34145a(context, dVar) : dVar.load(context);
            m19683b(context, a);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo34146a(Context context, T t);
}
