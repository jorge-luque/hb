package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: androidx.appcompat.app.h */
/* compiled from: ResourcesFlusher */
class C0429h {

    /* renamed from: a */
    private static Field f513a;

    /* renamed from: b */
    private static boolean f514b;

    /* renamed from: c */
    private static Class<?> f515c;

    /* renamed from: d */
    private static boolean f516d;

    /* renamed from: e */
    private static Field f517e;

    /* renamed from: f */
    private static boolean f518f;

    /* renamed from: g */
    private static Field f519g;

    /* renamed from: h */
    private static boolean f520h;

    /* renamed from: a */
    static void m572a(Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            if (i >= 24) {
                m576d(resources);
            } else if (i >= 23) {
                m575c(resources);
            } else if (i >= 21) {
                m574b(resources);
            }
        }
    }

    /* renamed from: b */
    private static void m574b(Resources resources) {
        if (!f514b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f513a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f514b = true;
        }
        Field field = f513a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* renamed from: c */
    private static void m575c(Resources resources) {
        if (!f514b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f513a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f514b = true;
        }
        Object obj = null;
        Field field = f513a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        if (obj != null) {
            m573a(obj);
        }
    }

    /* renamed from: d */
    private static void m576d(Resources resources) {
        Object obj;
        if (!f520h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f519g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f520h = true;
        }
        Field field = f519g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
                obj = null;
            }
            if (obj != null) {
                if (!f514b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f513a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e3) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
                    }
                    f514b = true;
                }
                Field field2 = f513a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                    }
                }
                if (obj2 != null) {
                    m573a(obj2);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m573a(Object obj) {
        if (!f516d) {
            try {
                f515c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f516d = true;
        }
        Class<?> cls = f515c;
        if (cls != null) {
            if (!f518f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f517e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                }
                f518f = true;
            }
            Field field = f517e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
