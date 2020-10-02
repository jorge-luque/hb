package p163cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLException;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.client.C5582h;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.client.p171q.C5606a;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.client.l */
/* compiled from: DefaultHttpRequestRetryHandler */
public class C5791l implements C5582h {

    /* renamed from: a */
    private final int f14936a;

    /* renamed from: b */
    private final boolean f14937b;

    /* renamed from: c */
    private final Set<Class<? extends IOException>> f14938c;

    static {
        new C5791l();
    }

    protected C5791l(int i, boolean z, Collection<Class<? extends IOException>> collection) {
        this.f14936a = i;
        this.f14937b = z;
        this.f14938c = new HashSet();
        for (Class<? extends IOException> add : collection) {
            this.f14938c.add(add);
        }
    }

    /* renamed from: a */
    public boolean mo28925a(IOException iOException, int i, C5875e eVar) {
        C5886a.m18894a(iOException, "Exception parameter");
        C5886a.m18894a(eVar, "HTTP context");
        if (i > this.f14936a || this.f14938c.contains(iOException.getClass())) {
            return false;
        }
        for (Class<? extends IOException> isInstance : this.f14938c) {
            if (isInstance.isInstance(iOException)) {
                return false;
            }
        }
        C5606a a = C5606a.m17839a(eVar);
        C5899o b = a.mo33643b();
        if (mo33502b(b)) {
            return false;
        }
        if (!mo33501a(b) && a.mo33645d() && !this.f14937b) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: b */
    public boolean mo33502b(C5899o oVar) {
        if (oVar instanceof C5802v) {
            oVar = ((C5802v) oVar).mo33528c();
        }
        return (oVar instanceof C5600i) && ((C5600i) oVar).isAborted();
    }

    public C5791l(int i, boolean z) {
        this(i, z, Arrays.asList(new Class[]{InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class}));
    }

    public C5791l() {
        this(3, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33501a(C5899o oVar) {
        return !(oVar instanceof C5885k);
    }
}
