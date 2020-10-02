package p163cz.msebera.android.httpclient.impl.conn;

import java.net.InetAddress;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.conn.p173q.C5643d;
import p163cz.msebera.android.httpclient.conn.p174r.C5645b;
import p163cz.msebera.android.httpclient.conn.p174r.C5647d;
import p163cz.msebera.android.httpclient.conn.p175s.C5660i;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.h */
/* compiled from: DefaultHttpRoutePlanner */
public class C5813h implements C5647d {

    /* renamed from: a */
    protected final C5660i f15009a;

    public C5813h(C5660i iVar) {
        C5886a.m18894a(iVar, "Scheme registry");
        this.f15009a = iVar;
    }

    /* renamed from: a */
    public C5645b mo33066a(C5896l lVar, C5899o oVar, C5875e eVar) throws HttpException {
        C5886a.m18894a(oVar, "HTTP request");
        C5645b b = C5643d.m17969b(oVar.getParams());
        if (b != null) {
            return b;
        }
        C5887b.m18901a((Object) lVar, "Target host");
        InetAddress c = C5643d.m17970c(oVar.getParams());
        C5896l a = C5643d.m17968a(oVar.getParams());
        try {
            boolean d = this.f15009a.mo33096b(lVar.mo33688d()).mo33088d();
            if (a == null) {
                return new C5645b(lVar, c, d);
            }
            return new C5645b(lVar, c, a, d);
        } catch (IllegalStateException e) {
            throw new HttpException(e.getMessage());
        }
    }
}
