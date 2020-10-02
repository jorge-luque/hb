package p113i.p114e0.p117i;

import android.os.Build;
import android.util.Log;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import p113i.C5972w;
import p113i.p114e0.C3500c;
import p113i.p114e0.p198k.C5960c;
import p113i.p114e0.p198k.C5962e;

/* renamed from: i.e0.i.a */
/* compiled from: AndroidPlatform */
class C3513a extends C3521f {

    /* renamed from: c */
    private final C5956e<Socket> f9777c;

    /* renamed from: d */
    private final C5956e<Socket> f9778d;

    /* renamed from: e */
    private final C5956e<Socket> f9779e;

    /* renamed from: f */
    private final C5956e<Socket> f9780f;

    /* renamed from: g */
    private final C3516c f9781g = C3516c.m11721a();

    /* renamed from: i.e0.i.a$a */
    /* compiled from: AndroidPlatform */
    static final class C3514a extends C5960c {

        /* renamed from: a */
        private final Object f9782a;

        /* renamed from: b */
        private final Method f9783b;

        C3514a(Object obj, Method method) {
            this.f9782a = obj;
            this.f9783b = method;
        }

        /* renamed from: a */
        public List<Certificate> mo19417a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f9783b.invoke(this.f9782a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C3514a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: i.e0.i.a$b */
    /* compiled from: AndroidPlatform */
    static final class C3515b implements C5962e {

        /* renamed from: a */
        private final X509TrustManager f9784a;

        /* renamed from: b */
        private final Method f9785b;

        C3515b(X509TrustManager x509TrustManager, Method method) {
            this.f9785b = method;
            this.f9784a = x509TrustManager;
        }

        /* renamed from: a */
        public X509Certificate mo19420a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f9785b.invoke(this.f9784a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw C3500c.m11636a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3515b)) {
                return false;
            }
            C3515b bVar = (C3515b) obj;
            if (!this.f9784a.equals(bVar.f9784a) || !this.f9785b.equals(bVar.f9785b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f9784a.hashCode() + (this.f9785b.hashCode() * 31);
        }
    }

    C3513a(Class<?> cls, C5956e<Socket> eVar, C5956e<Socket> eVar2, C5956e<Socket> eVar3, C5956e<Socket> eVar4) {
        this.f9777c = eVar;
        this.f9778d = eVar2;
        this.f9779e = eVar3;
        this.f9780f = eVar4;
    }

    /* renamed from: c */
    public static C3521f m11707c() {
        Class<?> cls;
        C5956e eVar;
        C5956e eVar2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        C5956e eVar3 = new C5956e((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        C5956e eVar4 = new C5956e((Class<?>) null, "setHostname", String.class);
        if (m11708f()) {
            C5956e eVar5 = new C5956e(cls2, "getAlpnSelectedProtocol", new Class[0]);
            eVar = new C5956e((Class<?>) null, "setAlpnProtocols", cls2);
            eVar2 = eVar5;
        } else {
            eVar2 = null;
            eVar = null;
        }
        return new C3513a(cls3, eVar3, eVar4, eVar2, eVar);
    }

    /* renamed from: f */
    private static boolean m11708f() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public void mo19411a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (C3500c.m11653a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e3);
                throw iOException2;
            }
            throw e3;
        }
    }

    @Nullable
    /* renamed from: b */
    public String mo19414b(SSLSocket sSLSocket) {
        byte[] bArr;
        C5956e<Socket> eVar = this.f9779e;
        if (eVar == null || !eVar.mo33762a(sSLSocket) || (bArr = (byte[]) this.f9779e.mo33765d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, C3500c.f9709i);
    }

    /* renamed from: i.e0.i.a$c */
    /* compiled from: AndroidPlatform */
    static final class C3516c {

        /* renamed from: a */
        private final Method f9786a;

        /* renamed from: b */
        private final Method f9787b;

        /* renamed from: c */
        private final Method f9788c;

        C3516c(Method method, Method method2, Method method3) {
            this.f9786a = method;
            this.f9787b = method2;
            this.f9788c = method3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Object mo19423a(String str) {
            Method method = this.f9786a;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, new Object[0]);
                    this.f9787b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo19424a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f9788c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a */
        static C3516c m11721a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new C3516c(method3, method, method2);
        }
    }

    /* renamed from: b */
    public boolean mo19416b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m11706b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo19416b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw C3500c.m11636a("unable to determine cleartext support", e);
        }
    }

    /* renamed from: b */
    private boolean m11706b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return m11705a(str, cls, obj);
        }
    }

    /* renamed from: a */
    public void mo19412a(SSLSocket sSLSocket, String str, List<C5972w> list) {
        if (str != null) {
            this.f9777c.mo33764c(sSLSocket, true);
            this.f9778d.mo33764c(sSLSocket, str);
        }
        C5956e<Socket> eVar = this.f9780f;
        if (eVar != null && eVar.mo33762a(sSLSocket)) {
            this.f9780f.mo33765d(sSLSocket, C3521f.m11738b(list));
        }
    }

    /* renamed from: b */
    public C5962e mo19413b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C3515b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo19413b(x509TrustManager);
        }
    }

    /* renamed from: a */
    public void mo19409a(int i, String str, @Nullable Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    /* renamed from: b */
    public SSLContext mo19415b() {
        boolean z = true;
        try {
            if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 22) {
                z = false;
            }
        } catch (NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    /* renamed from: a */
    public Object mo19408a(String str) {
        return this.f9781g.mo19423a(str);
    }

    /* renamed from: a */
    public void mo19410a(String str, Object obj) {
        if (!this.f9781g.mo19424a(obj)) {
            mo19409a(5, str, (Throwable) null);
        }
    }

    /* renamed from: a */
    private boolean m11705a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo19416b(str);
        }
    }

    /* renamed from: a */
    public C5960c mo19407a(X509TrustManager x509TrustManager) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C3514a(cls2.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls2.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, cls, cls}));
        } catch (Exception unused) {
            return super.mo19407a(x509TrustManager);
        }
    }
}
