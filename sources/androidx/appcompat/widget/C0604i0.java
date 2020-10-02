package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* renamed from: androidx.appcompat.widget.i0 */
/* compiled from: TooltipCompat */
public class C0604i0 {
    /* renamed from: a */
    public static void m1679a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            C0606j0.m1685a(view, charSequence);
        }
    }
}
