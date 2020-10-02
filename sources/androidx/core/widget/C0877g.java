package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

/* renamed from: androidx.core.widget.g */
/* compiled from: ListViewCompat */
public final class C0877g {
    /* renamed from: a */
    public static void m2931a(ListView listView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
        }
    }
}
