package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.app.d */
/* compiled from: BundleCompat */
public final class C0709d {
    /* renamed from: a */
    public static IBinder m2213a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return C0710a.m2215a(bundle, str);
    }

    /* renamed from: a */
    public static void m2214a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            C0710a.m2216a(bundle, str, iBinder);
        }
    }

    /* renamed from: androidx.core.app.d$a */
    /* compiled from: BundleCompat */
    static class C0710a {

        /* renamed from: a */
        private static Method f1779a;

        /* renamed from: b */
        private static boolean f1780b;

        /* renamed from: c */
        private static Method f1781c;

        /* renamed from: d */
        private static boolean f1782d;

        /* renamed from: a */
        public static IBinder m2215a(Bundle bundle, String str) {
            if (!f1780b) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f1779a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f1780b = true;
            }
            Method method2 = f1779a;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    f1779a = null;
                }
            }
            return null;
        }

        /* renamed from: a */
        public static void m2216a(Bundle bundle, String str, IBinder iBinder) {
            if (!f1782d) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f1781c = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f1782d = true;
            }
            Method method2 = f1781c;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    f1781c = null;
                }
            }
        }
    }
}
