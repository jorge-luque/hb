package p113i.p114e0.p117i;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import p113i.C5972w;
import p113i.p114e0.C3500c;

/* renamed from: i.e0.i.c */
/* compiled from: Jdk9Platform */
final class C3518c extends C3521f {

    /* renamed from: c */
    final Method f9789c;

    /* renamed from: d */
    final Method f9790d;

    C3518c(Method method, Method method2) {
        this.f9789c = method;
        this.f9790d = method2;
    }

    /* renamed from: c */
    public static C3518c m11730c() {
        try {
            return new C3518c(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo19412a(SSLSocket sSLSocket, String str, List<C5972w> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a = C3521f.m11737a(list);
            this.f9789c.invoke(sSLParameters, new Object[]{a.toArray(new String[a.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C3500c.m11636a("unable to set ssl parameters", (Exception) e);
        }
    }

    @Nullable
    /* renamed from: b */
    public String mo19414b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f9790d.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C3500c.m11636a("unable to get selected protocols", (Exception) e);
        }
    }
}
