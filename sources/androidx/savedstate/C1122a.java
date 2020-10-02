package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.C0965e;

/* renamed from: androidx.savedstate.a */
/* compiled from: SavedStateRegistryController */
public final class C1122a {

    /* renamed from: a */
    private final C1123b f3040a;

    /* renamed from: b */
    private final SavedStateRegistry f3041b = new SavedStateRegistry();

    private C1122a(C1123b bVar) {
        this.f3040a = bVar;
    }

    /* renamed from: a */
    public SavedStateRegistry mo5943a() {
        return this.f3041b;
    }

    /* renamed from: b */
    public void mo5945b(Bundle bundle) {
        this.f3041b.mo5939a(bundle);
    }

    /* renamed from: a */
    public void mo5944a(Bundle bundle) {
        C0965e lifecycle = this.f3040a.getLifecycle();
        if (lifecycle.mo4995a() == C0965e.C0967b.INITIALIZED) {
            lifecycle.mo4996a(new Recreator(this.f3040a));
            this.f3041b.mo5940a(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    /* renamed from: a */
    public static C1122a m4589a(C1123b bVar) {
        return new C1122a(bVar);
    }
}
