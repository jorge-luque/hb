package p113i.p114e0.p117i;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: i.e0.i.e */
/* compiled from: OptionalMethod */
class C5956e<T> {

    /* renamed from: a */
    private final Class<?> f15225a;

    /* renamed from: b */
    private final String f15226b;

    /* renamed from: c */
    private final Class[] f15227c;

    C5956e(Class<?> cls, String str, Class... clsArr) {
        this.f15225a = cls;
        this.f15226b = str;
        this.f15227c = clsArr;
    }

    /* renamed from: a */
    public boolean mo33762a(T t) {
        return m19103a(t.getClass()) != null;
    }

    /* renamed from: b */
    public Object mo33763b(T t, Object... objArr) throws InvocationTargetException {
        Method a = m19103a(t.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public Object mo33764c(T t, Object... objArr) {
        try {
            return mo33763b(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: d */
    public Object mo33765d(T t, Object... objArr) {
        try {
            return mo33761a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    public Object mo33761a(T t, Object... objArr) throws InvocationTargetException {
        Method a = m19103a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f15226b + " not supported for object " + t);
        }
    }

    /* renamed from: a */
    private Method m19103a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f15226b;
        if (str == null) {
            return null;
        }
        Method a = m19104a(cls, str, this.f15227c);
        if (a == null || (cls2 = this.f15225a) == null || cls2.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m19104a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
