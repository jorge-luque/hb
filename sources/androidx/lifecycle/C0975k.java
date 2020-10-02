package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

/* renamed from: androidx.lifecycle.k */
/* compiled from: Lifecycling */
public class C0975k {

    /* renamed from: a */
    private static Map<Class, Integer> f2532a = new HashMap();

    /* renamed from: b */
    private static Map<Class, List<Constructor<? extends C0963c>>> f2533b = new HashMap();

    /* renamed from: a */
    static C0968f m3480a(Object obj) {
        boolean z = obj instanceof C0968f;
        boolean z2 = obj instanceof C0962b;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((C0962b) obj, (C0968f) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((C0962b) obj, (C0968f) null);
        }
        if (z) {
            return (C0968f) obj;
        }
        Class<?> cls = obj.getClass();
        if (m3483b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f2533b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(m3479a((Constructor) list.get(0), obj));
        }
        C0963c[] cVarArr = new C0963c[list.size()];
        for (int i = 0; i < list.size(); i++) {
            cVarArr[i] = m3479a((Constructor) list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(cVarArr);
    }

    /* renamed from: b */
    private static int m3483b(Class<?> cls) {
        Integer num = f2532a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int d = m3485d(cls);
        f2532a.put(cls, Integer.valueOf(d));
        return d;
    }

    /* renamed from: c */
    private static boolean m3484c(Class<?> cls) {
        return cls != null && C0969g.class.isAssignableFrom(cls);
    }

    /* renamed from: d */
    private static int m3485d(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends C0963c> a = m3482a(cls);
        if (a != null) {
            f2533b.put(cls, Collections.singletonList(a));
            return 2;
        } else if (C0959a.f2508c.mo4983b(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (m3484c(superclass)) {
                if (m3483b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f2533b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (m3484c(cls2)) {
                    if (m3483b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f2533b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f2533b.put(cls, arrayList);
            return 2;
        }
    }

    /* renamed from: a */
    private static C0963c m3479a(Constructor<? extends C0963c> constructor, Object obj) {
        try {
            return (C0963c) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: a */
    private static Constructor<? extends C0963c> m3482a(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a = m3481a(canonicalName);
            if (!name.isEmpty()) {
                a = name + "." + a;
            }
            Constructor<?> declaredConstructor = Class.forName(a).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static String m3481a(String str) {
        return str.replace(".", C6120b.ROLL_OVER_FILE_NAME_SEPARATOR) + "_LifecycleAdapter";
    }
}
