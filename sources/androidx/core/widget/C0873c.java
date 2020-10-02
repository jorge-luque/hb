package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: androidx.core.widget.c */
/* compiled from: CompoundButtonCompat */
public final class C0873c {

    /* renamed from: a */
    private static Field f2161a;

    /* renamed from: b */
    private static boolean f2162b;

    /* renamed from: a */
    public static void m2921a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof C0881j) {
            ((C0881j) compoundButton).mo2954a(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m2922a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof C0881j) {
            ((C0881j) compoundButton).mo2955a(mode);
        }
    }

    /* renamed from: a */
    public static Drawable m2920a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!f2162b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f2161a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2162b = true;
        }
        Field field = f2161a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                f2161a = null;
            }
        }
        return null;
    }
}
