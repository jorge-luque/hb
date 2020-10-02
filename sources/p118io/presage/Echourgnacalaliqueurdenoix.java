package p118io.presage;

import androidx.fragment.app.C0917h;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

/* renamed from: io.presage.Echourgnacalaliqueurdenoix */
public final class Echourgnacalaliqueurdenoix {
    /* renamed from: a */
    public static final List<Fragment> m20352a(C0917h hVar) {
        ArrayList arrayList = new ArrayList();
        m20353a(arrayList, hVar);
        return arrayList;
    }

    /* renamed from: a */
    private static final void m20353a(List<Fragment> list, C0917h hVar) {
        List<Fragment> c = hVar.mo4785c();
        C6514hl.m21414a((Object) c, "fm.fragments");
        for (Fragment fragment : c) {
            C6514hl.m21414a((Object) fragment, "it");
            if (fragment.getUserVisibleHint() && fragment.isResumed()) {
                list.add(fragment);
                C0917h childFragmentManager = fragment.getChildFragmentManager();
                C6514hl.m21414a((Object) childFragmentManager, "it.childFragmentManager");
                m20353a(list, childFragmentManager);
            }
        }
    }
}
