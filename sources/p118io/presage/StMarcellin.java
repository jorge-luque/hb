package p118io.presage;

import admost.sdk.base.AdMost;
import java.io.Serializable;

/* renamed from: io.presage.StMarcellin */
public final class StMarcellin implements Serializable {

    /* renamed from: a */
    private boolean f16687a;

    /* renamed from: b */
    private int f16688b = 200;

    /* renamed from: c */
    private int f16689c = AdMost.AD_ERROR_FREQ_CAP;

    /* renamed from: a */
    public final void mo34683a(boolean z) {
        this.f16687a = z;
    }

    /* renamed from: b */
    public final int mo34685b() {
        return this.f16688b;
    }

    /* renamed from: c */
    public final int mo34687c() {
        return this.f16689c;
    }

    /* renamed from: a */
    public final boolean mo34684a() {
        return this.f16687a;
    }

    /* renamed from: b */
    public final void mo34686b(int i) {
        this.f16689c = i;
    }

    /* renamed from: a */
    public final void mo34682a(int i) {
        this.f16688b = i;
    }
}
