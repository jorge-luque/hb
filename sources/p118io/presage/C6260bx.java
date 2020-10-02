package p118io.presage;

import java.lang.ref.WeakReference;

/* renamed from: io.presage.bx */
public final class C6260bx {

    /* renamed from: a */
    private final WeakReference<C6265cb> f16865a;

    /* renamed from: b */
    private final C6396db f16866b;

    /* renamed from: c */
    private final PontlEveque f16867c;

    /* renamed from: d */
    private final long f16868d;

    private C6260bx(WeakReference<C6265cb> weakReference, C6396db dbVar, PontlEveque pontlEveque, long j) {
        this.f16865a = weakReference;
        this.f16866b = dbVar;
        this.f16867c = pontlEveque;
        this.f16868d = j;
    }

    /* renamed from: a */
    public final WeakReference<C6265cb> mo34847a() {
        return this.f16865a;
    }

    /* renamed from: b */
    public final C6396db mo34848b() {
        return this.f16866b;
    }

    /* renamed from: c */
    public final PontlEveque mo34849c() {
        return this.f16867c;
    }

    /* renamed from: d */
    public final long mo34850d() {
        return this.f16868d;
    }

    public /* synthetic */ C6260bx(WeakReference weakReference, C6396db dbVar, PontlEveque pontlEveque) {
        this(weakReference, dbVar, pontlEveque, System.currentTimeMillis());
    }
}
