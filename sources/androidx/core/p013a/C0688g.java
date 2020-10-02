package androidx.core.p013a;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.a.g */
/* compiled from: TypefaceCompatApi28Impl */
public class C0688g extends C0687f {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Typeface mo3826a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f1742g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f1748m.invoke((Object) null, new Object[]{newInstance, "sans-serif", -1, -1});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Method mo3831d(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), String.class, cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
