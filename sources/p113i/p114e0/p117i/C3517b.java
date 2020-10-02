package p113i.p114e0.p117i;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;
import p113i.C5972w;

/* renamed from: i.e0.i.b */
/* compiled from: ConscryptPlatform */
public class C3517b extends C3521f {
    private C3517b() {
    }

    /* renamed from: c */
    public static C3517b m11724c() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            return new C3517b();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: f */
    private Provider m11725f() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    /* renamed from: a */
    public void mo19412a(SSLSocket sSLSocket, String str, List<C5972w> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) C3521f.m11737a(list).toArray(new String[0]));
            return;
        }
        super.mo19412a(sSLSocket, str, list);
    }

    @Nullable
    /* renamed from: b */
    public String mo19414b(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.mo19414b(sSLSocket);
    }

    /* renamed from: b */
    public SSLContext mo19415b() {
        try {
            return SSLContext.getInstance("TLSv1.3", m11725f());
        } catch (NoSuchAlgorithmException e) {
            try {
                return SSLContext.getInstance("TLS", m11725f());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
    }

    /* renamed from: a */
    public void mo19425a(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
