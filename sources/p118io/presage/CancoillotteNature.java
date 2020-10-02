package p118io.presage;

import android.graphics.Rect;
import android.view.ViewGroup;

/* renamed from: io.presage.CancoillotteNature */
public final class CancoillotteNature {

    /* renamed from: a */
    public static final CamembertauCalvados f16429a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final int f16430b;

    /* renamed from: c */
    private final Camembertbio f16431c;

    /* renamed from: io.presage.CancoillotteNature$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public /* synthetic */ CancoillotteNature() {
        this(Camembertbio.f16412a);
    }

    /* renamed from: a */
    public final boolean mo34502a(ViewGroup viewGroup, C6388cu cuVar) {
        if (cuVar.mo35320c() < this.f16430b || cuVar.mo35322d() < this.f16430b) {
            return false;
        }
        Rect rect = new Rect();
        viewGroup.getWindowVisibleDisplayFrame(rect);
        Rect a = m20286a(rect, cuVar);
        BriquetteduNord a2 = Camembertbio.m20268a(a, rect, 0.75f);
        float c = a2.mo34465c();
        if (c < 0.5f) {
            return false;
        }
        if (!cuVar.mo35319b() && c < 0.75f) {
            return false;
        }
        if (!cuVar.mo35319b() || c >= 0.75f) {
            return true;
        }
        if (!a2.mo34463a()) {
            return false;
        }
        m20287a(cuVar, a, rect);
        return true;
    }

    private CancoillotteNature(Camembertbio camembertbio) {
        this.f16431c = camembertbio;
        this.f16430b = C6215af.m20776b(50);
    }

    /* renamed from: a */
    private static void m20287a(C6388cu cuVar, Rect rect, Rect rect2) {
        cuVar.mo35321c(rect.left - rect2.left);
        cuVar.mo35323d(rect.top - rect2.top);
        cuVar.mo35316a(rect.width());
        cuVar.mo35318b(rect.height());
    }

    /* renamed from: a */
    private static Rect m20286a(Rect rect, C6388cu cuVar) {
        Rect rect2 = new Rect();
        rect2.left = rect.left + cuVar.mo35324e();
        rect2.top = rect.top + cuVar.mo35326f();
        rect2.right = rect2.left + cuVar.mo35320c();
        rect2.bottom = rect2.top + cuVar.mo35322d();
        return rect2;
    }
}
