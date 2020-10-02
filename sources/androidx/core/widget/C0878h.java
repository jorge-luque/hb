package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.p020f.C0804c;
import androidx.core.p020f.C0839t;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: androidx.core.widget.h */
/* compiled from: PopupWindowCompat */
public final class C0878h {

    /* renamed from: a */
    private static Method f2164a;

    /* renamed from: b */
    private static boolean f2165b;

    /* renamed from: c */
    private static Field f2166c;

    /* renamed from: d */
    private static boolean f2167d;

    /* renamed from: a */
    public static void m2933a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i, i2, i3);
            return;
        }
        if ((C0804c.m2545a(i3, C0839t.m2725n(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    /* renamed from: a */
    public static void m2934a(PopupWindow popupWindow, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (i >= 21) {
            if (!f2167d) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f2166c = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                f2167d = true;
            }
            Field field = f2166c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException unused2) {
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2932a(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!f2165b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f2164a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f2165b = true;
        }
        Method method = f2164a;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception unused2) {
            }
        }
    }
}
