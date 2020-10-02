package p118io.presage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.presage.Entrammes */
public final class Entrammes {

    /* renamed from: a */
    private final DelicedesFiouves f16497a;

    public Entrammes(DelicedesFiouves delicedesFiouves) {
        this.f16497a = delicedesFiouves;
    }

    /* renamed from: a */
    private final boolean m20366a(Object obj) {
        String a = Coulommiers.m20339a(obj);
        List<String> b = this.f16497a.mo34539b();
        if ((b instanceof Collection) && b.isEmpty()) {
            return false;
        }
        for (String a2 : b) {
            if (C6514hl.m21416a((Object) a2, (Object) a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private final boolean m20367b(Object obj) {
        String a = Coulommiers.m20339a(obj);
        List<String> a2 = this.f16497a.mo34538a();
        if ((a2 instanceof Collection) && a2.isEmpty()) {
            return false;
        }
        for (String b : a2) {
            if (C6561je.m21509a(a, b)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo34547a(List<? extends Object> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (m20366a((Object) it.next())) {
                return false;
            }
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            if (m20367b(it2.next())) {
                return true;
            }
        }
        return false;
    }
}
