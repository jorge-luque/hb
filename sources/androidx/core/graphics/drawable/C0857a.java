package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.core.graphics.drawable.a */
/* compiled from: DrawableCompat */
public final class C0857a {

    /* renamed from: a */
    private static Method f2085a;

    /* renamed from: b */
    private static boolean f2086b;

    /* renamed from: c */
    private static Method f2087c;

    /* renamed from: d */
    private static boolean f2088d;

    /* renamed from: a */
    public static void m2808a(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    /* renamed from: b */
    public static void m2812b(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
        } else if (drawable instanceof C0858b) {
            ((C0858b) drawable).setTint(i);
        }
    }

    /* renamed from: c */
    public static ColorFilter m2813c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* renamed from: d */
    public static int m2814d(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i >= 17) {
            if (!f2088d) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f2087c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f2088d = true;
            }
            Method method = f2087c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception unused2) {
                    f2087c = null;
                }
            }
        }
        return 0;
    }

    /* renamed from: e */
    public static boolean m2815e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    @Deprecated
    /* renamed from: f */
    public static void m2816f(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* renamed from: g */
    public static <T extends Drawable> T m2817g(Drawable drawable) {
        return drawable instanceof C0859c ? ((C0859c) drawable).mo4230a() : drawable;
    }

    /* renamed from: h */
    public static Drawable m2818h(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable;
        }
        return i >= 21 ? !(drawable instanceof C0858b) ? new C0861e(drawable) : drawable : !(drawable instanceof C0858b) ? new C0860d(drawable) : drawable;
    }

    /* renamed from: a */
    public static void m2802a(Drawable drawable, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    /* renamed from: a */
    public static void m2803a(Drawable drawable, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    /* renamed from: b */
    public static int m2811b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    /* renamed from: a */
    public static void m2804a(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof C0858b) {
            ((C0858b) drawable).setTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m2807a(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof C0858b) {
            ((C0858b) drawable).setTintMode(mode);
        }
    }

    /* renamed from: a */
    public static void m2805a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    /* renamed from: a */
    public static boolean m2809a(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* renamed from: a */
    public static void m2806a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    /* renamed from: a */
    public static boolean m2810a(Drawable drawable, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (i2 >= 17) {
            if (!f2086b) {
                Class<Drawable> cls = Drawable.class;
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                    f2085a = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f2086b = true;
            }
            Method method = f2085a;
            if (method != null) {
                try {
                    method.invoke(drawable, new Object[]{Integer.valueOf(i)});
                    return true;
                } catch (Exception unused2) {
                    f2085a = null;
                }
            }
        }
        return false;
    }
}
