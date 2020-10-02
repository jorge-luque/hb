package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.activity.b */
/* compiled from: OnBackPressedCallback */
public abstract class C0381b {

    /* renamed from: a */
    private boolean f276a;

    /* renamed from: b */
    private CopyOnWriteArrayList<C0380a> f277b = new CopyOnWriteArrayList<>();

    public C0381b(boolean z) {
        this.f276a = z;
    }

    /* renamed from: a */
    public abstract void mo1901a();

    /* renamed from: a */
    public final void mo1903a(boolean z) {
        this.f276a = z;
    }

    /* renamed from: b */
    public final boolean mo1905b() {
        return this.f276a;
    }

    /* renamed from: c */
    public final void mo1906c() {
        Iterator<C0380a> it = this.f277b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1902a(C0380a aVar) {
        this.f277b.add(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1904b(C0380a aVar) {
        this.f277b.remove(aVar);
    }
}
