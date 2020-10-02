package p118io.presage;

import android.graphics.Rect;
import android.view.View;

/* renamed from: io.presage.cz */
public final class C6393cz implements C6392cy {

    /* renamed from: a */
    private final Taleggio f16964a;

    /* renamed from: b */
    private final boolean f16965b;

    public C6393cz(Taleggio taleggio, boolean z) {
        this.f16964a = taleggio;
        this.f16965b = z;
    }

    /* renamed from: b */
    private final void m21219b(C6233ax axVar) {
        String m = this.f16964a.mo34700m();
        axVar.mo34760a(m, this.f16965b);
        if (!this.f16965b) {
            m = "none";
        }
        axVar.mo34762a(!this.f16965b, m);
    }

    /* renamed from: a */
    public final void mo35329a(C6233ax axVar) {
        int a = C6215af.m20775a(this.f16964a.mo34697j());
        int a2 = C6215af.m20775a(this.f16964a.mo34698k());
        Rect a3 = Taleggio.m20684a((View) axVar.mo34768c());
        axVar.mo34755a(a, a2);
        axVar.mo34764b(C6215af.m20775a(a3.width()), C6215af.m20775a(a3.height()));
        m21219b(axVar);
    }
}
