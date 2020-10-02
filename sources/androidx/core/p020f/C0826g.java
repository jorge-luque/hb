package androidx.core.p020f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import androidx.core.p014b.p015a.C0749b;

/* renamed from: androidx.core.f.g */
/* compiled from: MenuItemCompat */
public final class C0826g {
    /* renamed from: a */
    public static MenuItem m2639a(MenuItem menuItem, C0800b bVar) {
        if (menuItem instanceof C0749b) {
            return ((C0749b) menuItem).mo2395a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* renamed from: b */
    public static void m2645b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0749b) {
            ((C0749b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    /* renamed from: a */
    public static void m2643a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0749b) {
            ((C0749b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    /* renamed from: b */
    public static void m2644b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0749b) {
            ((C0749b) menuItem).setNumericShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i);
        }
    }

    /* renamed from: a */
    public static void m2640a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0749b) {
            ((C0749b) menuItem).setAlphabeticShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    /* renamed from: a */
    public static void m2641a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof C0749b) {
            ((C0749b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m2642a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof C0749b) {
            ((C0749b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
