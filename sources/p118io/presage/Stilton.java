package p118io.presage;

import java.util.Iterator;
import java.util.List;

/* renamed from: io.presage.Stilton */
public final class Stilton {

    /* renamed from: a */
    public static final Stilton f16694a = new Stilton();

    private Stilton() {
    }

    /* renamed from: a */
    public final void mo34692a(List<PontlEveque> list, StRomans stRomans, PavedAremberg pavedAremberg) throws StVincentauChablis {
        PontlEveque a = m20681a(list);
        if (a != null && (!C6514hl.m21416a((Object) a.mo34631k(), (Object) stRomans.mo34688a()))) {
            try {
                m20682a(a.mo34631k(), true, stRomans, pavedAremberg);
            } catch (StVincentauChablis e) {
                MoelleuxduRevard moelleuxduRevard = MoelleuxduRevard.f16573a;
                MoelleuxduRevard.m20487a((Mimolette24mois) new Munster("loaded_error", a));
                throw e;
            }
        }
    }

    /* renamed from: a */
    private final void m20682a(String str, boolean z, StRomans stRomans, PavedAremberg pavedAremberg) throws StVincentauChablis {
        C6412dr c = pavedAremberg.mo34600c(str);
        if (c instanceof C6413ds) {
            stRomans.mo34689a(((C6413ds) c).mo35377a());
            stRomans.mo34691b(str);
        } else if (z) {
            Thread.sleep(400);
            m20682a(str, false, stRomans, pavedAremberg);
        } else {
            throw new StVincentauChablis();
        }
    }

    /* renamed from: a */
    private static PontlEveque m20681a(List<PontlEveque> list) {
        T t;
        boolean z;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((PontlEveque) t).mo34631k().length() > 0) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return (PontlEveque) t;
    }
}
