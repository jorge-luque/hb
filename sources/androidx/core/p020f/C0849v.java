package androidx.core.p020f;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.R$id;

/* renamed from: androidx.core.f.v */
/* compiled from: ViewGroupCompat */
public final class C0849v {
    /* renamed from: a */
    public static boolean m2763a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(R$id.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && C0839t.m2729r(viewGroup) == null) ? false : true;
    }
}
