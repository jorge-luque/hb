package p163cz.msebera.android.httpclient.conn;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.k */
/* compiled from: HttpInetSocketAddress */
public class C5633k extends InetSocketAddress {
    private static final long serialVersionUID = -6650701828361907957L;

    /* renamed from: a */
    private final C5896l f14630a;

    public C5633k(C5896l lVar, InetAddress inetAddress, int i) {
        super(inetAddress, i);
        C5886a.m18894a(lVar, "HTTP host");
        this.f14630a = lVar;
    }

    /* renamed from: a */
    public C5896l mo33030a() {
        return this.f14630a;
    }

    public String toString() {
        return this.f14630a.mo33685b() + ":" + getPort();
    }
}
