package androidx.core.p020f;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

/* renamed from: androidx.core.f.c */
/* compiled from: GravityCompat */
public final class C0804c {
    /* renamed from: a */
    public static void m2546a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(i, i2, i3, rect, rect2, i4);
        } else {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    /* renamed from: a */
    public static int m2545a(int i, int i2) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i, i2) : i & -8388609;
    }
}
