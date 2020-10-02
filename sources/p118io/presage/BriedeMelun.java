package p118io.presage;

import android.graphics.Rect;
import java.util.List;

/* renamed from: io.presage.BriedeMelun */
public final class BriedeMelun {
    /* renamed from: a */
    public static final int m20240a(Rect rect) {
        return rect.width() * rect.height();
    }

    /* renamed from: a */
    public static final void m20241a(Rect rect, Rect rect2) {
        rect.offset(-rect2.left, -rect2.top);
    }

    /* renamed from: a */
    public static final void m20242a(List<Rect> list, Rect rect) {
        for (Rect a : list) {
            m20241a(a, rect);
        }
    }
}
