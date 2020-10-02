package androidx.core.p020f.p021c0;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* renamed from: androidx.core.f.c0.e */
/* compiled from: AccessibilityRecordCompat */
public class C0812e {
    /* renamed from: a */
    public static void m2622a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    /* renamed from: b */
    public static void m2623b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }
}
