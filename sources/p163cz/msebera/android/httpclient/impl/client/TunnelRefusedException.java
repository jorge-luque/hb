package p163cz.msebera.android.httpclient.impl.client;

import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.HttpException;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.TunnelRefusedException */
public class TunnelRefusedException extends HttpException {
    private static final long serialVersionUID = -8646722842745617323L;

    /* renamed from: a */
    private final C5901q f14898a;

    public TunnelRefusedException(String str, C5901q qVar) {
        super(str);
        this.f14898a = qVar;
    }

    /* renamed from: a */
    public C5901q mo33447a() {
        return this.f14898a;
    }
}
