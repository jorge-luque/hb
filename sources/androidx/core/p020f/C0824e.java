package androidx.core.p020f;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* renamed from: androidx.core.f.e */
/* compiled from: LayoutInflaterCompat */
public final class C0824e {

    /* renamed from: a */
    private static Field f2034a;

    /* renamed from: b */
    private static boolean f2035b;

    /* renamed from: a */
    private static void m2632a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f2035b) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f2034a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f2035b = true;
        }
        Field field = f2034a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    /* renamed from: b */
    public static void m2633b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                m2632a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                m2632a(layoutInflater, factory2);
            }
        }
    }
}
