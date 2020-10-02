package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.core.p020f.C0839t;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.widget.m0 */
/* compiled from: ViewUtils */
public class C0616m0 {

    /* renamed from: a */
    private static Method f1523a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                f1523a = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    f1523a.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m1739a(View view) {
        return C0839t.m2725n(view) == 1;
    }

    /* renamed from: b */
    public static void m1740b(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m1738a(View view, Rect rect, Rect rect2) {
        Method method = f1523a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception unused) {
            }
        }
    }
}
