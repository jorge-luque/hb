package p118io.presage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: io.presage.FourmedeRochefort */
public final class FourmedeRochefort implements GaletteLyonnaise {

    /* renamed from: a */
    private final List<GaletteLyonnaise> f16524a = new ArrayList();

    /* renamed from: a */
    public final void mo34556a() {
        for (GaletteLyonnaise a : this.f16524a) {
            a.mo34556a();
        }
        this.f16524a.clear();
    }

    /* renamed from: a */
    public final void mo34560a(GaletteLyonnaise galetteLyonnaise) {
        this.f16524a.add(galetteLyonnaise);
    }
}
