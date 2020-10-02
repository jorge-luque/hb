package p118io.presage;

import android.app.Application;
import java.util.List;

/* renamed from: io.presage.CureNantais */
public final class CureNantais implements Bofavre {

    /* renamed from: a */
    private final C6493gr<PontlEveque, List<PontlEveque>, C6437ep> f16484a;

    public CureNantais(C6493gr<? super PontlEveque, ? super List<PontlEveque>, C6437ep> grVar) {
        this.f16484a = grVar;
    }

    /* renamed from: a */
    public final void mo34457a(Application application, List<PontlEveque> list, String str) {
        PontlEveque a = FourmedAmbertBio.m20382a(list, str);
        if (a != null) {
            this.f16484a.mo34520a(a, list);
        }
    }
}
