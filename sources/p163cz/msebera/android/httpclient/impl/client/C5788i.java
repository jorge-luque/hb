package p163cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.client.p169o.C5594c;
import p163cz.msebera.android.httpclient.p187k0.C5892g;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.i */
/* compiled from: CloseableHttpResponseProxy */
class C5788i implements InvocationHandler {

    /* renamed from: b */
    private static final Constructor<?> f14934b;

    /* renamed from: a */
    private final C5901q f14935a;

    static {
        try {
            f14934b = Proxy.getProxyClass(C5788i.class.getClassLoader(), new Class[]{C5594c.class}).getConstructor(new Class[]{InvocationHandler.class});
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    C5788i(C5901q qVar) {
        this.f14935a = qVar;
    }

    /* renamed from: a */
    public void mo33499a() throws IOException {
        C5892g.m18935a(this.f14935a.getEntity());
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().equals("close")) {
            mo33499a();
            return null;
        }
        try {
            return method.invoke(this.f14935a, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                throw cause;
            }
            throw e;
        }
    }

    /* renamed from: a */
    public static C5594c m18486a(C5901q qVar) {
        try {
            return (C5594c) f14934b.newInstance(new Object[]{new C5788i(qVar)});
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException(e3);
        }
    }
}
