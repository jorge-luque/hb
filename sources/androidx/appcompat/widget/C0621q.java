package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.p008b.p009a.C0450c;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.graphics.drawable.C0859c;
import com.tapjoy.TJAdUnitConstants;
import java.lang.reflect.Field;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.widget.q */
/* compiled from: DrawableUtils */
public class C0621q {

    /* renamed from: a */
    private static final int[] f1537a = {16842912};

    /* renamed from: b */
    private static final int[] f1538b = new int[0];

    /* renamed from: c */
    public static final Rect f1539c = new Rect();

    /* renamed from: d */
    private static Class<?> f1540d;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1540d = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m1807a(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable a : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!m1807a(a)) {
                    return false;
                }
            }
            return true;
        } else if (drawable instanceof C0859c) {
            return m1807a(((C0859c) drawable).mo4230a());
        } else {
            if (drawable instanceof C0450c) {
                return m1807a(((C0450c) drawable).mo2254a());
            }
            if (drawable instanceof ScaleDrawable) {
                return m1807a(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
    }

    /* renamed from: b */
    static void m1808b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m1809c(drawable);
        }
    }

    /* renamed from: c */
    private static void m1809c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1537a);
        } else {
            drawable.setState(f1538b);
        }
        drawable.setState(state);
    }

    /* renamed from: d */
    public static Rect m1810d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets opticalInsets = drawable.getOpticalInsets();
            Rect rect = new Rect();
            rect.left = opticalInsets.left;
            rect.right = opticalInsets.right;
            rect.top = opticalInsets.top;
            rect.bottom = opticalInsets.bottom;
            return rect;
        }
        if (f1540d != null) {
            try {
                Drawable g = C0857a.m2817g(drawable);
                Object invoke = g.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(g, new Object[0]);
                if (invoke != null) {
                    Rect rect2 = new Rect();
                    for (Field field : f1540d.getFields()) {
                        String name = field.getName();
                        char c = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals(TJAdUnitConstants.String.BOTTOM)) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals(TJAdUnitConstants.String.RIGHT)) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            rect2.left = field.getInt(invoke);
                        } else if (c == 1) {
                            rect2.top = field.getInt(invoke);
                        } else if (c == 2) {
                            rect2.right = field.getInt(invoke);
                        } else if (c == 3) {
                            rect2.bottom = field.getInt(invoke);
                        }
                    }
                    return rect2;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f1539c;
    }

    /* renamed from: a */
    public static PorterDuff.Mode m1806a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
