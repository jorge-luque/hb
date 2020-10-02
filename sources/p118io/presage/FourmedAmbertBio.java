package p118io.presage;

import java.util.Iterator;
import java.util.List;

/* renamed from: io.presage.FourmedAmbertBio */
public final class FourmedAmbertBio {

    /* renamed from: io.presage.FourmedAmbertBio$CamembertauCalvados */
    static final class CamembertauCalvados extends C6515hm implements C6482gg<PontlEveque, Boolean> {

        /* renamed from: a */
        public static final CamembertauCalvados f16510a = new CamembertauCalvados();

        CamembertauCalvados() {
            super(1);
        }

        /* renamed from: a */
        private static boolean m20385a(PontlEveque pontlEveque) {
            return pontlEveque.mo34646v();
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo34409a(Object obj) {
            return Boolean.valueOf(m20385a((PontlEveque) obj));
        }
    }

    /* renamed from: a */
    public static final PontlEveque m20382a(List<PontlEveque> list, String str) {
        if (list.isEmpty()) {
            return null;
        }
        if ((str.length() == 0) || C6514hl.m21416a((Object) str, (Object) "null")) {
            return list.remove(0);
        }
        return m20384b(list, str);
    }

    /* renamed from: b */
    private static final PontlEveque m20384b(List<PontlEveque> list, String str) {
        Iterator<PontlEveque> it = list.iterator();
        while (it.hasNext()) {
            PontlEveque next = it.next();
            if (C6514hl.m21416a((Object) next.mo34607b(), (Object) str)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static final void m20383a(List<PontlEveque> list) {
        C6453fe.m21335a(list, CamembertauCalvados.f16510a);
    }
}
