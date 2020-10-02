package p163cz.msebera.android.httpclient.impl.conn;

import java.net.InetAddress;
import java.net.UnknownHostException;
import p163cz.msebera.android.httpclient.conn.C5630h;

/* renamed from: cz.msebera.android.httpclient.impl.conn.p */
/* compiled from: SystemDefaultDnsResolver */
public class C5821p implements C5630h {
    static {
        new C5821p();
    }

    /* renamed from: a */
    public InetAddress[] mo33020a(String str) throws UnknownHostException {
        return InetAddress.getAllByName(str);
    }
}
