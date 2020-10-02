package p118io.presage;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: io.presage.BrillatSavarin */
public final class BrillatSavarin {
    /* renamed from: a */
    public final List<View> mo34462a(ViewGroup viewGroup, WebView webView) {
        ArrayList arrayList = new ArrayList();
        m20243a(viewGroup, (List<View>) arrayList);
        return arrayList.subList(arrayList.indexOf(webView) + 1, arrayList.size());
    }

    /* renamed from: a */
    private final void m20243a(ViewGroup viewGroup, List<View> list) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof CamembertdeNormandie)) {
                C6514hl.m21414a((Object) childAt, "child");
                list.add(childAt);
            }
            if (childAt instanceof ViewGroup) {
                m20243a((ViewGroup) childAt, list);
            }
        }
    }
}
