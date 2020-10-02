package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.p013a.C0680a;

/* renamed from: androidx.appcompat.widget.b0 */
/* compiled from: ThemeUtils */
class C0575b0 {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f1358a = new ThreadLocal<>();

    /* renamed from: b */
    static final int[] f1359b = {-16842910};

    /* renamed from: c */
    static final int[] f1360c = {16842908};

    /* renamed from: d */
    static final int[] f1361d = {16842919};

    /* renamed from: e */
    static final int[] f1362e = {16842912};

    /* renamed from: f */
    static final int[] f1363f = new int[0];

    /* renamed from: g */
    private static final int[] f1364g = new int[1];

    /* renamed from: a */
    public static int m1506a(Context context, int i) {
        ColorStateList c = m1510c(context, i);
        if (c != null && c.isStateful()) {
            return c.getColorForState(f1359b, c.getDefaultColor());
        }
        TypedValue a = m1508a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m1507a(context, i, a.getFloat());
    }

    /* renamed from: b */
    public static int m1509b(Context context, int i) {
        int[] iArr = f1364g;
        iArr[0] = i;
        C0598g0 a = C0598g0.m1609a(context, (AttributeSet) null, iArr);
        try {
            return a.mo3431a(0, 0);
        } finally {
            a.mo3434a();
        }
    }

    /* renamed from: c */
    public static ColorStateList m1510c(Context context, int i) {
        int[] iArr = f1364g;
        iArr[0] = i;
        C0598g0 a = C0598g0.m1609a(context, (AttributeSet) null, iArr);
        try {
            return a.mo3432a(0);
        } finally {
            a.mo3434a();
        }
    }

    /* renamed from: a */
    private static TypedValue m1508a() {
        TypedValue typedValue = f1358a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1358a.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: a */
    static int m1507a(Context context, int i, float f) {
        int b = m1509b(context, i);
        return C0680a.m2100c(b, Math.round(((float) Color.alpha(b)) * f));
    }
}
