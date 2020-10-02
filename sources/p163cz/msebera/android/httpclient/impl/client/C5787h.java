package p163cz.msebera.android.httpclient.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.client.ClientProtocolException;
import p163cz.msebera.android.httpclient.client.p169o.C5594c;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.client.p172r.C5621d;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.client.h */
/* compiled from: CloseableHttpClient */
public abstract class C5787h implements Closeable {
    public C5787h() {
        new C5695b(getClass());
    }

    /* renamed from: a */
    public C5594c mo33498a(C5600i iVar, C5875e eVar) throws IOException, ClientProtocolException {
        C5886a.m18894a(iVar, "HTTP request");
        return mo33453a(m18483a(iVar), iVar, eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C5594c mo33453a(C5896l lVar, C5899o oVar, C5875e eVar) throws IOException, ClientProtocolException;

    /* renamed from: a */
    private static C5896l m18483a(C5600i iVar) throws ClientProtocolException {
        URI uri = iVar.getURI();
        if (!uri.isAbsolute()) {
            return null;
        }
        C5896l a = C5621d.m17892a(uri);
        if (a != null) {
            return a;
        }
        throw new ClientProtocolException("URI does not specify a valid host name: " + uri);
    }
}
