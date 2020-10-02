package p113i.p114e0.p117i;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import p113i.C3542v;
import p113i.C5972w;
import p113i.p114e0.p198k.C5958a;
import p113i.p114e0.p198k.C5959b;
import p113i.p114e0.p198k.C5960c;
import p113i.p114e0.p198k.C5962e;
import p119j.C3577c;

/* renamed from: i.e0.i.f */
/* compiled from: Platform */
public class C3521f {

    /* renamed from: a */
    private static final C3521f f9799a = m11739c();

    /* renamed from: b */
    private static final Logger f9800b = Logger.getLogger(C3542v.class.getName());

    /* renamed from: b */
    static byte[] m11738b(List<C5972w> list) {
        C3577c cVar = new C3577c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C5972w wVar = list.get(i);
            if (wVar != C5972w.HTTP_1_0) {
                cVar.writeByte(wVar.toString().length());
                cVar.mo19708e(wVar.toString());
            }
        }
        return cVar.mo19680G();
    }

    /* renamed from: c */
    private static C3521f m11739c() {
        C3517b c;
        C3521f c2 = C3513a.m11707c();
        if (c2 != null) {
            return c2;
        }
        if (m11741e() && (c = C3517b.m11724c()) != null) {
            return c;
        }
        C3518c c3 = C3518c.m11730c();
        if (c3 != null) {
            return c3;
        }
        C3521f c4 = C3519d.m11733c();
        if (c4 != null) {
            return c4;
        }
        return new C3521f();
    }

    /* renamed from: d */
    public static C3521f m11740d() {
        return f9799a;
    }

    /* renamed from: e */
    public static boolean m11741e() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* renamed from: a */
    public String mo19428a() {
        return "OkHttp";
    }

    /* renamed from: a */
    public void mo19411a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo19426a(SSLSocket sSLSocket) {
    }

    /* renamed from: a */
    public void mo19412a(SSLSocket sSLSocket, @Nullable String str, List<C5972w> list) {
    }

    /* renamed from: a */
    public void mo19425a(SSLSocketFactory sSLSocketFactory) {
    }

    @Nullable
    /* renamed from: b */
    public String mo19414b(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: b */
    public boolean mo19416b(String str) {
        return true;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    /* renamed from: a */
    public void mo19409a(int i, String str, @Nullable Throwable th) {
        f9800b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public Object mo19408a(String str) {
        if (f9800b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo19410a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo19409a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public static List<String> m11737a(List<C5972w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C5972w wVar = list.get(i);
            if (wVar != C5972w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public SSLContext mo19415b() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    /* renamed from: a */
    public C5960c mo19407a(X509TrustManager x509TrustManager) {
        return new C5958a(mo19413b(x509TrustManager));
    }

    /* renamed from: b */
    public C5962e mo19413b(X509TrustManager x509TrustManager) {
        return new C5959b(x509TrustManager.getAcceptedIssuers());
    }
}
