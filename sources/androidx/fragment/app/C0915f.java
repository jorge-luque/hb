package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;
import p075d.p080b.C3204g;

/* renamed from: androidx.fragment.app.f */
/* compiled from: FragmentFactory */
public class C0915f {

    /* renamed from: a */
    private static final C3204g<String, Class<?>> f2320a = new C3204g<>();

    /* renamed from: b */
    static boolean m3155b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(m3156c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: c */
    private static Class<?> m3156c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> cls = f2320a.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        f2320a.put(str, cls2);
        return cls2;
    }

    /* renamed from: d */
    public static Class<? extends Fragment> m3157d(ClassLoader classLoader, String str) {
        try {
            return m3156c(classLoader, str);
        } catch (ClassNotFoundException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e);
        } catch (ClassCastException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        }
    }

    /* renamed from: a */
    public Fragment mo4773a(ClassLoader classLoader, String str) {
        try {
            return (Fragment) m3157d(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
