package p163cz.msebera.android.httpclient.impl.client;

import java.net.URI;
import java.net.URISyntaxException;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.C5909x;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.p182g0.C5731a;
import p163cz.msebera.android.httpclient.p182g0.C5744n;
import p163cz.msebera.android.httpclient.p183h0.C5760f;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.v */
/* compiled from: RequestWrapper */
public class C5802v extends C5731a implements C5600i {

    /* renamed from: c */
    private final C5899o f14968c;

    /* renamed from: d */
    private URI f14969d;

    /* renamed from: e */
    private String f14970e;

    /* renamed from: f */
    private C5907v f14971f;

    /* renamed from: g */
    private int f14972g;

    public C5802v(C5899o oVar) throws ProtocolException {
        C5886a.m18894a(oVar, "HTTP request");
        this.f14968c = oVar;
        mo33294a(oVar.getParams());
        mo33295a(oVar.getAllHeaders());
        if (oVar instanceof C5600i) {
            C5600i iVar = (C5600i) oVar;
            this.f14969d = iVar.getURI();
            this.f14970e = iVar.getMethod();
            this.f14971f = null;
        } else {
            C5909x requestLine = oVar.getRequestLine();
            try {
                this.f14969d = new URI(requestLine.getUri());
                this.f14970e = requestLine.getMethod();
                this.f14971f = oVar.getProtocolVersion();
            } catch (URISyntaxException e) {
                throw new ProtocolException("Invalid request URI: " + requestLine.getUri(), e);
            }
        }
        this.f14972g = 0;
    }

    /* renamed from: a */
    public void mo33526a(URI uri) {
        this.f14969d = uri;
    }

    public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public int mo33527b() {
        return this.f14972g;
    }

    /* renamed from: c */
    public C5899o mo33528c() {
        return this.f14968c;
    }

    /* renamed from: d */
    public void mo33529d() {
        this.f14972g++;
    }

    /* renamed from: e */
    public boolean mo33516e() {
        return true;
    }

    /* renamed from: f */
    public void mo33530f() {
        this.f14795a.mo33391a();
        mo33295a(this.f14968c.getAllHeaders());
    }

    public String getMethod() {
        return this.f14970e;
    }

    public C5907v getProtocolVersion() {
        if (this.f14971f == null) {
            this.f14971f = C5760f.m18361b(getParams());
        }
        return this.f14971f;
    }

    public C5909x getRequestLine() {
        C5907v protocolVersion = getProtocolVersion();
        URI uri = this.f14969d;
        String aSCIIString = uri != null ? uri.toASCIIString() : null;
        if (aSCIIString == null || aSCIIString.isEmpty()) {
            aSCIIString = "/";
        }
        return new C5744n(getMethod(), aSCIIString, protocolVersion);
    }

    public URI getURI() {
        return this.f14969d;
    }

    public boolean isAborted() {
        return false;
    }
}
