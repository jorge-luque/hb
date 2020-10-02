package p163cz.msebera.android.httpclient.impl.conn;

import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5902r;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.conn.C5636n;
import p163cz.msebera.android.httpclient.conn.C5637o;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p178e0.C5702f;
import p163cz.msebera.android.httpclient.p181f0.C5725c;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p181f0.C5729g;
import p163cz.msebera.android.httpclient.p182g0.C5751u;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p183h0.C5760f;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.e */
/* compiled from: DefaultClientConnection */
public class C5810e extends C5702f implements C5637o, C5636n, C5875e {

    /* renamed from: k */
    public C5695b f14996k = new C5695b(C5810e.class);

    /* renamed from: l */
    public C5695b f14997l = new C5695b("cz.msebera.android.httpclient.headers");

    /* renamed from: m */
    public C5695b f14998m = new C5695b("cz.msebera.android.httpclient.wire");

    /* renamed from: n */
    private volatile Socket f14999n;

    /* renamed from: o */
    private boolean f15000o;

    /* renamed from: p */
    private volatile boolean f15001p;

    /* renamed from: q */
    private final Map<String, Object> f15002q = new HashMap();

    /* renamed from: B */
    public final boolean mo33041B() {
        return this.f15000o;
    }

    /* renamed from: N */
    public final Socket mo33042N() {
        return this.f14999n;
    }

    /* renamed from: R */
    public C5901q mo33182R() throws HttpException, IOException {
        C5901q R = super.mo33182R();
        if (this.f14996k.mo33168a()) {
            this.f14996k.mo33166a("Receiving response: " + R.mo33335a());
        }
        if (this.f14997l.mo33168a()) {
            this.f14997l.mo33166a("<< " + R.mo33335a().toString());
            for (C5691d dVar : R.getAllHeaders()) {
                this.f14997l.mo33166a("<< " + dVar.toString());
            }
        }
        return R;
    }

    /* renamed from: T */
    public SSLSession mo33040T() {
        if (this.f14999n instanceof SSLSocket) {
            return ((SSLSocket) this.f14999n).getSession();
        }
        return null;
    }

    /* renamed from: a */
    public void mo33043a(Socket socket, C5896l lVar) throws IOException {
        mo33214y();
        this.f14999n = socket;
        if (this.f15001p) {
            socket.close();
            throw new InterruptedIOException("Connection already shutdown");
        }
    }

    /* renamed from: b */
    public void mo33045b(boolean z, C5759e eVar) throws IOException {
        C5886a.m18894a(eVar, "Parameters");
        mo33214y();
        this.f15000o = z;
        mo33206a(this.f14999n, eVar);
    }

    public void close() throws IOException {
        try {
            super.close();
            if (this.f14996k.mo33168a()) {
                C5695b bVar = this.f14996k;
                bVar.mo33166a("Connection " + this + " closed");
            }
        } catch (IOException e) {
            this.f14996k.mo33167a("I/O error closing connection", e);
        }
    }

    public void shutdown() throws IOException {
        this.f15001p = true;
        try {
            super.shutdown();
            if (this.f14996k.mo33168a()) {
                C5695b bVar = this.f14996k;
                bVar.mo33166a("Connection " + this + " shut down");
            }
            Socket socket = this.f14999n;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            this.f14996k.mo33167a("I/O error shutting down connection", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C5729g mo33207b(Socket socket, int i, C5759e eVar) throws IOException {
        if (i <= 0) {
            i = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        C5729g b = super.mo33207b(socket, i, eVar);
        return this.f14998m.mo33168a() ? new C5818m(b, new C5822q(this.f14998m), C5760f.m18358a(eVar)) : b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5728f mo33205a(Socket socket, int i, C5759e eVar) throws IOException {
        if (i <= 0) {
            i = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        C5728f a = super.mo33205a(socket, i, eVar);
        return this.f14998m.mo33168a() ? new C5817l(a, new C5822q(this.f14998m), C5760f.m18358a(eVar)) : a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5725c<C5901q> mo33185a(C5728f fVar, C5902r rVar, C5759e eVar) {
        return new C5812g(fVar, (C5751u) null, rVar, eVar);
    }

    /* renamed from: a */
    public void mo33044a(Socket socket, C5896l lVar, boolean z, C5759e eVar) throws IOException {
        mo33191d();
        C5886a.m18894a(lVar, "Target host");
        C5886a.m18894a(eVar, "Parameters");
        if (socket != null) {
            this.f14999n = socket;
            mo33206a(socket, eVar);
        }
        this.f15000o = z;
    }

    /* renamed from: a */
    public void mo33189a(C5899o oVar) throws HttpException, IOException {
        if (this.f14996k.mo33168a()) {
            this.f14996k.mo33166a("Sending request: " + oVar.getRequestLine());
        }
        super.mo33189a(oVar);
        if (this.f14997l.mo33168a()) {
            this.f14997l.mo33166a(">> " + oVar.getRequestLine().toString());
            for (C5691d dVar : oVar.getAllHeaders()) {
                this.f14997l.mo33166a(">> " + dVar.toString());
            }
        }
    }

    /* renamed from: a */
    public Object mo33533a(String str) {
        return this.f15002q.get(str);
    }

    /* renamed from: a */
    public void mo33535a(String str, Object obj) {
        this.f15002q.put(str, obj);
    }
}
