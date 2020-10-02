package p113i.p114e0.p117i;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import p113i.C5972w;
import p113i.p114e0.C3500c;

/* renamed from: i.e0.i.d */
/* compiled from: JdkWithJettyBootPlatform */
class C3519d extends C3521f {

    /* renamed from: c */
    private final Method f9791c;

    /* renamed from: d */
    private final Method f9792d;

    /* renamed from: e */
    private final Method f9793e;

    /* renamed from: f */
    private final Class<?> f9794f;

    /* renamed from: g */
    private final Class<?> f9795g;

    /* renamed from: i.e0.i.d$a */
    /* compiled from: JdkWithJettyBootPlatform */
    private static class C3520a implements InvocationHandler {

        /* renamed from: a */
        private final List<String> f9796a;

        /* renamed from: b */
        boolean f9797b;

        /* renamed from: c */
        String f9798c;

        C3520a(List<String> list) {
            this.f9796a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C3500c.f9702b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f9797b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f9796a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f9796a.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f9798c = str;
                            return str;
                        }
                    }
                    String str2 = this.f9796a.get(0);
                    this.f9798c = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f9798c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    C3519d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f9791c = method;
        this.f9792d = method2;
        this.f9793e = method3;
        this.f9794f = cls;
        this.f9795g = cls2;
    }

    /* renamed from: c */
    public static C3521f m11733c() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new C3519d(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo19412a(SSLSocket sSLSocket, String str, List<C5972w> list) {
        List<String> a = C3521f.m11737a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(C3521f.class.getClassLoader(), new Class[]{this.f9794f, this.f9795g}, new C3520a(a));
            this.f9791c.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C3500c.m11636a("unable to set alpn", (Exception) e);
        }
    }

    @Nullable
    /* renamed from: b */
    public String mo19414b(SSLSocket sSLSocket) {
        try {
            C3520a aVar = (C3520a) Proxy.getInvocationHandler(this.f9792d.invoke((Object) null, new Object[]{sSLSocket}));
            if (!aVar.f9797b && aVar.f9798c == null) {
                C3521f.m11740d().mo19409a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.f9797b) {
                return null;
            } else {
                return aVar.f9798c;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C3500c.m11636a("unable to get selected protocol", (Exception) e);
        }
    }

    /* renamed from: a */
    public void mo19426a(SSLSocket sSLSocket) {
        try {
            this.f9793e.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C3500c.m11636a("unable to remove alpn", (Exception) e);
        }
    }
}
