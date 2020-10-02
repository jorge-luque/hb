package androidx.core.p020f.p021c0;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: androidx.core.f.c0.b */
/* compiled from: AccessibilityEventCompat */
public final class C0806b {
    /* renamed from: a */
    public static void m2548a(AccessibilityEvent accessibilityEvent, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    /* renamed from: a */
    public static int m2547a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }
}
